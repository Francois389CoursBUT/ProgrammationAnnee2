import socket
import os.path

from numpy import byte

TAILLE = 512

def preparer_client():
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print(s)
    except OSError:
        print('Création socket échouée')
        return(-1)
    else:
        print('Création socket réussie')
        return(s)


def preparer_serveur(coord):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print(s)
    except OSError:
        print('Création socket échouée')
        return(-1)
    else:
        print('Création socket réussie')
        try:
            s.bind(coord)
        except OSError:
            print('bind() échoué')
            s.close()
            return(-1)
        else:
            print('bind() réussi')
            try: 
                s.listen(1)
            except OSError:
                print('listen() échoué')
                s.close()
                return(-1)
            else:
                print('listen() réussi')
                return(s)

def accepter(s):
    print("En attente d'un client")
    try:
        (sc, coord_C)= s.accept()
    except OSError:
        print('accept() échoué')
        return(-1)
    else:
        print('accept() réussi pour le client', coord_C)
        return(sc)


def connecter(s,coord_S):
    try:
        s.connect(coord_S)
    except ConnectionRefusedError:
        print('Connexion au serveur',coord_S,'échouée')
        return(-1)
    else:
        print('Connexion au serveur',coord_S,'réussie')
        return(0)


def construire_requete():
    # unique opération à faire ici : saisie requête
    requete = input('Saisir la requête : ')
    return(requete.encode())


def construire_reponse(chemin:bytes)->bytes:
    # ici, "écho" => on retourne ce qu'on a reçu 
    resultat = enteteHTTP(chemin.decode())
    resultat += "\n"
    resultat = resultat.encode() + contenu(chemin.decode())
    print("Resultat :\n" + resultat.decode())
    print('----Construction réponse effectuée')
    return resultat


def analyser(bloc):
    # ici, pas d'analyse car on retourne ce qu'on a reçu
    print('Analyse requête effectuée\n')
    bloc_decoder = bloc.decode().split("\n")[0]
    pageDemander = bloc_decoder.split("GET /")[1].split(" ")[0]
    print("Page demander : " + pageDemander)
    print("\nFin de l'analyse")
    return pageDemander.encode()


def utiliser(bloc):
    # unique opération à faire ici : afficher le bloc
    print('réponse reçue = '+ bloc.decode())


def envoyer(s,bloc):
    try:
        qte = s.send(bloc)
    except (ConnectionResetError, ConnectionAbortedError):
        print('Problème envoi : l interlocuteur a quitté sauvagement')
        return(-1)
    else:    
        print('Quantité données envoyées = ',qte)
        return(0)


def recevoir(s):
    # inutile ici de vérifier les coordonnées de notre interlocuteur ; elles sont associées à la socket
    try:
        bloc = s.recv(TAILLE)
    except (ConnectionResetError, ConnectionAbortedError):
        print('Problème réception : interlocuteur absent ou parti')
        return(-1)
    else:
        if (len(bloc) == 0):
            print('recv(): l interlocuteur a quitté proprement')
            return(-1)
        else:
            return(bloc)


def arreter(s):
    try:
        s.close()
    except OSError:
        print('Socket encore ouverte !')
    else:
        print('Socket correctement fermée')


def contenu(chemin:str)->bytes:
    """Retourne le contenu d'un fichier

    Args:
        chemin (str): Le chemin du fichier

    Returns:
        str: Le contenu du fichier
    """
    if os.path.isfile(chemin):
        fichier = open(chemin, "rb")
        contenu = fichier.read()
        fichier.close()
        # print("\tFichier : " + chemin + "\n\tContenu : " + str(contenu))
        return contenu
    return b"fin"

def enteteHTTP(chemin:str)->str:
    # Vérifie si le fichier existe
    if os.path.isfile(chemin):
        return "HTTP/1.1 200 OK\n"
    return "HTTP/1.1 404 Not Found\n"