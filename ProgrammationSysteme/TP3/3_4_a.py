import threading
import time

def carre():
    global nb
    time.sleep(1)
    carre = nb * nb
    print("Le carré de %d est %d" % (nb, carre))


def suivant ():
    global nb
    time.sleep(1)
    nb = nb + 1
    print("Le nombre suivant est %d" % (nb))

global nb 
nb = int(input("Entrez un nombre : "))

tCarre = threading.Thread(target = carre)
tSuivant = threading.Thread(target = suivant)

while nb != 0:
    tCarre.start()
    tSuivant.start()
    tCarre.join()
    tSuivant.join()
    nb = int(input("Entrez un nombre : "))
    print(nb)


print(nb)
etat1 = tCarre.is_alive()
etat2 = tSuivant.is_alive()
print("Thread suivant : %s" % etat1)
print("Thread carré : %s" % etat2)
