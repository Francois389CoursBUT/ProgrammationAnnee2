
def lireTout():
    with open("index.html", 'r') as f:
        print(f.read())

def lireLigneParLigne():
    with open("index.html", 'r') as f:
        ligne = f.readline()
        while ligne != "":
            print(ligne, end="")
            ligne = f.readline()

def lireLigneTout():
    with open("index.html", 'r') as f:
        print("".join(f.readlines()))

def lireBinaire():
    with open("index.html", 'br') as f:
        print(f.read().decode())


if __name__ == "__main__":
    print("--------------Tout------------------")
    lireTout()
    print("---------Ligne par ligne------------")
    lireLigneParLigne()
    print("--Ligne par la ligne 1 instruction--")
    lireLigneTout()
    print("------------Binaire-----------------")
    lireBinaire()