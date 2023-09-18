import os

def rm_tree(chemin:str):
    if os.path.isfile(chemin):
        os.remove(chemin)
    elif len(os.listdir(chemin)) == 0:
        os.rmdir(chemin)
    else:
        for elt in os.listdir(chemin):
            rm_tree(elt)