from os import *

dir_compt_user = f"C:\\Users\\{getlogin()}\\petit_test"
if not path.exists(dir_compt_user):
    mkdir(dir_compt_user)

str(input("Supprimer (y / Y) ?"))

rmdir(dir_compt_user)