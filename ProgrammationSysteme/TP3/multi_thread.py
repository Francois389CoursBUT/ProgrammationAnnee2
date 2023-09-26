import threading
import time

def affiche_entier(entier:int, exposant:int):
    """Affiche l'entier a la puissance de l'exposant

    Args:
        entier (int): l'entier que l'on veux mettre à la puissance
        exposant (int): La puissance souhaité
    """
    print(entier**exposant)

entier = int(input("Entrez un entier : "))

while entier != 0:
    t1 = [None, None]
    
    # Créer les thread
    for i in range(len(t1)):
        t1[i] = threading.Thread(target=affiche_entier, args=(entier,i+1))
        
    # Démarer les thread
    for t in t1:
        t.start()
    
    # Attendre que les thread ont finis leur travaille
    # Vu que l'on n'est pas patient on attend 0.1s avant de les tuer
    for t in t1:
        t.join(timeout=0.1)
    
    # Affiche les information créée
    for thread in t1:
        etat = thread.is_alive()
        print("thread en vie ? " + str(etat))
    
    entier = int(input("Entrez un entier : "))