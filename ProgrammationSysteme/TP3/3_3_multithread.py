import threading

def carre():
    global nb
    while (nb != 0):
        carre = nb * nb
        print("Le carré de %d est %d" % (nb, carre))

def suivant ():
    global nb
    while (nb != 0):
        nb = nb + 1
        print("Le nombre suivant est %d" % (nb))

nb = int(input("Entrez un nombre : "))

t1 = threading.Thread(target = carre)
t2 = threading.Thread(target = suivant)
t1.start()
t2.start()

while nb != 0:
    nb = int(input("Entrez un nombre : "))

t1.join()
t2.join()
etat1 = t1.is_alive()
etat2 = t2.is_alive()
print("Thread suivant : %s" % etat1)
print("Thread carré : %s" % etat2)
