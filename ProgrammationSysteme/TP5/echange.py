import socket

def preparer_serveur(ip_serveur:str, port_serveur: int):
    """Prépare le serveur pour l'écoute

    Args:
        ip_serveur (str): L'addresse IP du serveur
        port_serveur (int): le numero de port du serveur

    Returns:
        socket: La socket generer
    """
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    print(type(s))
    coord_S = (ip_serveur, port_serveur)
    s.bind(coord_S)
    return s

def preparer_client(ip_serveur:str, port_serveur: int):
    """Prépare le client pour envoyer des requetes

    Args:
        ip_serveur (str): L'addresse IP du serveur
        port_serveur (int): le numero de port du serveur

    Returns:
        socket: La socket generer
    """
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    return s

def analyser(reponse: str):
    """
    Affiche la reponse à une requete
    """
    print(reponse)

def contruire_requete():
    """Demande une saisie à l'utilisateur et envoie la requete

    Returns:
        _type_: _description_
    """
    requete = input('Saisir la requête : ')	#  E1
    if len(requete) >= 1024:
        requete = requete[0:1023]
    return requete

def construire_reponse(requete):
    """Construit la reponse

    Args:
        reponse (str): La réponse obtenue

    Returns:
        str: La reponse à la requete
    """
    reponse = requete
    return reponse

def envoyer(socket:socket.socket, serveur : tuple, message:str):
    """Envoie une requete

    Args:
        socket (socket.socket): Le socket
        serveur (tuple): L'IP du serveur en 0 et le port du serveur en 1
        message (str): Le message à envoyer

    Raises:
        Exception: Si le tuple ne contient pas les bon type
    """
    if type(serveur[0]) != str or type(serveur[1]) != int:
        raise Exception("Serveur introuvable veillez vérifier l'IP et le port")
    socket.sendto(message.encode(), serveur)

def recevoir(socket: socket.socket):
    """Attends une requete

    Args:
        socket (socket.socket): Le socket

    Returns:
        _type_: Le message obtenu en 0 et le coordonnée de l'émetteur en 1
    """
    (reponse, cord) = socket.recvfrom(1024)
    return (reponse.decode(), cord)

def arreter(socket: socket.socket):
    """
        Ferme les connexions
    """
    socket.close()

