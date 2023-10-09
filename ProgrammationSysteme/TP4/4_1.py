fichier = open("index.html","r")
print("\n=====Tout d'un bloc====\n")
print(fichier.read())
fichier.close()

fichier = open("index.html","r")
print("\n\n=====Ligne par ligne=====\n")
lignes = fichier.readlines()
for ligne in lignes:
    print(ligne)
fichier.close()

fichier = open("index.html","br")
print("\n\n=====Binaire=====\n")
print(fichier.read())
fichier.close()