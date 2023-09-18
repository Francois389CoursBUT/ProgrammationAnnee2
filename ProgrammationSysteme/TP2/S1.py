import subprocess
#lance S1
cp = subprocess.run(["py", "Z:\\ProgrammationAnnee2\\ProgrammationSysteme\\TP2\\S2.py"],shell=True)
print("S2 executer")
print(cp.returncode)