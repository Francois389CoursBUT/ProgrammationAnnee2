import socket, select

TAILLE = 128
entrees = []
nb_cli = -1 # compteur de client ; -1 => lancement du serveur et donc forcément 0 client connecté
s1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
coord_S = ('127.0.0.1', 65432)
s1.bind(coord_S)
s1.listen(1)
entrees.append(s1)
while (nb_cli != 0): # on continue le serveur tant qu'il y a des clients connectés
    (r,w,e) = select.select(entrees,[],[])
    if s1 in r: # on reçoit une demande d'ouverture de connexion
        (s2, coord_C)= s1.accept()
        entrees.append(s2)
        if (nb_cli == -1): # c'est le 1er client accepté
            nb_cli = 1
        else:
            nb_cli = nb_cli + 1
    for s in sockets:
        if s in r: # on reçoit un bloc d'un des clients connectés
            requete = s.recv(TAILLE)
            reponse = requete # echo
            s.send(reponse)
            if (requete == b'fin'): 
                s.close()
                nb_cli = nb_cli - 1
                entrees.remove(s)
s1.close()