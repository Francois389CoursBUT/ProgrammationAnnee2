from math import sqrt

def carre_parfait(n:int):
    for i in range(1,int(sqrt(n)+1)):
        if (i**2 == n):
            return True
    return False

def table_multiplication(n:int):
    affichage = f"Table de {n} :\n------------\n"
    for i in range (10+1):
        affichage += f"{i} * {n} = {i*n}\n"
    return affichage

def afficher_tables():
    for i in range (1,10):
        print(table_multiplication(i),end="\n\n")

def int_to_list(n:int):
    liste = []
    while(n>0):
        list.append(n%10)
        n/=10
    return liste


if __name__ == '__main__':
    # nombre = int(input("Entrez un nombre : "))
    # if (carre_parfait(nombre)):
    #     print("C'est un carrée parfait")
    # else:
    #     print("Ce n'est pas un carrée parrfait")

    #afficher_tables()
    print(int_to_list(213))