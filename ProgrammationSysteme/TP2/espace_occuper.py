import shutil
import os

#a
total_usage = shutil.disk_usage("D:")
print(f"{total_usage[1]/total_usage[0]*100:.2f}%")

#b et c
dir_test = os.listdir("D:\\non_vide")
for elt in dir_test:
    elt_test = "D:\\non_vide\\" + elt
    if os.path.isfile(elt_test):
        print(f"Fichier : {elt_test}")
        os.remove(elt_test)
    elif os.path.isdir(elt_test):
        print(f"Dossier {elt_test}")
        os.rmdir(elt_test)
os.rmdir("D:\\non_vide")
