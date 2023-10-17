import os

def rm_tree(chemin:str):
    print(chemin)
    if os.path.isfile(chemin):
        os.remove(chemin)
    else:
        for elt in os.listdir(chemin):
            rm_tree(chemin + "\\" + elt)
        os.rmdir(chemin)

rm_tree("E:\deleteMoi")