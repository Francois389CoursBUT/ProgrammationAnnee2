import socket
from echange import *
# serveur UDP "echo" du cours

print("Lancement de l'application")
coord_S = ('127.0.0.1', 65432)

socket = preparer_serveur(coord_S[0], coord_S[1])

print("Le serveur écoute ...")
requet = recevoir(socket)

print("On a recu quelque chose !")
analyser(requet[0])

print("On envoie la même chose (echo)")
envoyer(socket, requet[1], requet[0])

arreter(socket)
print("Fin de l'application")

# s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
# print(type(s))
# s.bind(coord_S)
# (requete, coord_C) = s.recvfrom(1024)	# attente et E3 ; pas d’E4
# print(requete)
# reponse = requete			# E5 : écho
# s.sendto(reponse, coord_C)		# E6
# s.close()