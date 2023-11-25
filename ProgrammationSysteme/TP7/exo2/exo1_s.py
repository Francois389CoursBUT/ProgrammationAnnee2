import module_tcp as tcp
# base serveur "echo" TCP itératif 1 connexion
import socket
import threading

separateur = b'|' 

def analyser(bloc):
    print('Requête reçue = ',bloc.decode())
    sep = bloc.index(separateur)
    #pseudo = bloc[0:sep]
    #print('pseudo=',pseudo.decode())
    message = bloc[sep+1:]
    if len(message)<20:
        code = b'c'
    else:
        code = b'l'
    print('Analyse requête effectuée')
    return(message,code)

def construire_reponse(message,code,compteur):
    rep = message + separateur + code + separateur + str(compteur).encode()
    print('Construction réponse effectuée')
    return rep

def communication(s2:socket):
    cpt = 0
    on_continue = True
    if (s2 != -1):
        while (on_continue == True):
            requete = tcp.recevoir(s2)
            if (requete != -1):
                (message,code) = analyser(requete)
                cpt = cpt + 1
                if (message == b'fin'):
                    on_continue = False
                reponse = construire_reponse(message,code,cpt)
                statut_envoi = tcp.envoyer(s2,reponse)
                if (statut_envoi == -1):
                    on_continue = False
            else:
                on_continue = False
        tcp.arreter(s2)

def demarrerThread(listeThread:list):
    for thread in listeThread:
        if thread is not None and not thread.is_alive():
            thread.start()
            
def attent(listeThread:list):
    for thread in listeThread:
        thread.join()

# programme principal

N = 3 # Nombre de client autorisé avant arret

coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
if (s1 != -1):
    nbClient = 0
    listeThread =  []
    listeSocket =  []
    while len(listeSocket) < N:
        listeSocket.append(tcp.accepter(s1))
        listeThread.append(threading.Thread(target=communication, args=(listeSocket[nbClient],)))
        nbClient += 1
        demarrerThread(listeThread)
    tcp.arreter(s1)
    print("Nombre de client maximum atteint")
    attent(listeThread)