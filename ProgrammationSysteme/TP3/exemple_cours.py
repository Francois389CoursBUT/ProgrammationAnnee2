import threading
import time

# méthode de démarrage du thread
def methode_thread(nb): 
	id = threading.get_native_id()
	for i in range(nb):
		print('op n° ' + str(i) +' du thread id ' +str(id))
		time.sleep(1.0) # attends 1 sec

def creer_thread_pause(pause:int): 
	"""Créer un thread et affiche dis fois son id avec une pause

	Args:
		pause (int): duree en seconde de la pause
	"""
	id = threading.get_native_id()
	for i in range(5):
		print('op n° ' + str(i) +' du thread id ' +str(id))
		time.sleep(pause) 
  
# tout ce qui suit définit le thread principal
nb_thread = 2
t1 = [None] * nb_thread
cpt = 5

# Initialise les trhead
for j in range(nb_thread):
    t1[j] = threading.Thread(target = creer_thread_pause, args = (j+0.5,))

depart = time.time()
# Lance les threads
for thread in t1:
    thread.start()
    
for i in range (cpt):
	print('op n°'+str(i)+' du thread principal')

for thread in t1:
	thread.join(timeout = 5) # on attend le thread t1, au max 5 s
 
fin = time.time()
for thread in t1:
    etat = thread.is_alive() # => vérifie l’état de t1 (! si True, risque zombie)
    print('durée tot = ' + str(fin-depart) + ' / thread en vie ? ' + str(etat))