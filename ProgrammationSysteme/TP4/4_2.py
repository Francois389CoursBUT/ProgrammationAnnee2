# Ouvrir le fichier HTML en mode lecture
with open("index.html", "r") as file:
    contenu = file.readlines()
    

# Rechercher la position de la balise </body>
position_body = -1
print(contenu)
for i in range(len(contenu)-1):
    # print(contenu[i])
    if contenu[i] == "</body>\n":
        position_body = i

# Vérifier si la balise </body> a été trouvée
if position_body != -1:
    # Ajouter votre ligne supplémentaire
    ligne_supplementaire = "\t<p>Ceci est une ligne supplémentaire.</p>\n"
    contenu_modifie = (contenu[:position_body]) + (ligne_supplementaire) + (contenu[position_body:])

    # Ouvrir le fichier HTML en mode écriture et écrire le contenu modifié
    with open("index.html", "w") as file:
        file.write(contenu_modifie)
else:
    print("Balise </body> non trouvée dans le fichier HTML.")
