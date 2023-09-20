import subprocess
# Lance Wordpad
def lance ():
    cp = subprocess.run("C:\Program Files (x86)\Windows NT\Accessories\wordpad.exe")
    print("S2 en cours ...")
    print("Code retour de Wordpad",cp.returncode)
    
lance()