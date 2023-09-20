import subprocess
#lance S1
cp = subprocess.run(["py", 'ProgrammationSysteme\\TP2\\S2.py'])
print("S1 en cours ...")
print("Code retour de S2.py",cp.returncode)