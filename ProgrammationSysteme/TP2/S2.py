import subprocess
# Lance Wordpad
def lance ():
    cp = subprocess.run("C:\Program Files (x86)\Windows NT\Accessories\wordpad.exe")
    print("Wordpad executer")
    print(cp.returncode)
    
lance()