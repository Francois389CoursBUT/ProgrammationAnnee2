import threading
import time

def carre():
    global nb
    while nb != 0:
        time.sleep(1)
        nb = int(input("Entrez un nombre : "))
        carre = nb * nb
        print("Le carré de %d est %d" % (nb, carre))


def suivant ():
    global nb
    while nb != 0 or nb != 1:
        time.sleep(1)
        nb = nb + 1
        print("Le nombre suivant est %d" % (nb))

global nb 
nb = int(input("Entrez un nombre : "))

tCarre = threading.Thread(target = carre)
tSuivant = threading.Thread(target = suivant)

tCarre.start()
tSuivant.start()
while nb != 0:
    tCarre.join()
    tSuivant.join()
    print(nb)  



print(nb)
etat1 = tCarre.is_alive()
etat2 = tSuivant.is_alive()
print("Thread suivant : %s" % etat1)
print("Thread carré : %s" % etat2)
