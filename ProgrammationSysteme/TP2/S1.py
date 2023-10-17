import subprocess
#lance S1
print("S1 en cours ...")
cp = subprocess.run(["py", "ProgrammationSysteme\\TP2\\S2.py"])
print("Code retour de S2.py",cp.returncode)