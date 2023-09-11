def demande_donnee():
    nom = str(input("Entrez votre nom : "))
    age = int(input("Entrez votre age : "))
    donnee = (nom,age)
    phrase = f"Bonjour {donnee[0]}, vous avez {donnee[1]} ans"
    print(phrase)
    print(donnee)


def statut(donnee:tuple):
    age = donnee[1]
    if (0 <= age <= 3):
        return "bébé"
    elif (4 <= age <= 12):
        return "enfant"
    elif (13 <= age <= 17):
        return "ado"
    elif (18 <= age <= 65):
        return "adulte"
    elif (66 <= age):
        return "senior"

def annee_prochaine(donnee:tuple):
    donnee = list(donnee)
    donnee[1] += 1
    return tuple(donnee)