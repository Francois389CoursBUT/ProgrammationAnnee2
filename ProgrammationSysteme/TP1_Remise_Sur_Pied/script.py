from demande import *

def ex1():
    a = int(input("Entrez un nombre : "))
    print(a+1)

def convertion(phrase:str):
    compteur = 1
    n = 0
    for lettre in phrase:
        n += compteur * ord(lettre)
        compteur += 1
    return n

def dessin(h:int):
    for i in range(h):
        print(" " * (h-i-1),end="")
        print("*"*(2*i+1))


if __name__ == '__main__':
    #demande_donnee()
    # print(convertion("salut"))
    dessin(10)