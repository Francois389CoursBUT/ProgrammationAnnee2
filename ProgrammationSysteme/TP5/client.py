import socket
from echange import *
# client UDP "echo" du cours

print("Lancement de l'application")
coord_S = ('127.0.0.1', 65432)
socket = preparer_client(coord_S[0], coord_S[1])

print("Envoie de la requete")
envoyer(socket, coord_S, contruire_requete())

print("Attente de réponse ...")
reponse = recevoir(socket)
analyser(reponse[0])

arreter(socket)
print("Fin de l'application")

# s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
# requete = input('Saisir la requête : ')	#  E1
# s.sendto(requete.encode(), coord_S)	#  E2
# (reponse, coord_S) = s.recvfrom(1024)	#  attente et E7 
# print('Réponse = ', reponse.decode())  	#  E8
# s.close()