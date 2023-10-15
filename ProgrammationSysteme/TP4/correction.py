with open() as f:
	debut = f.seek(5,0)
	fin = f.Seek(-5,2)
	taille = debut- fin
	f.seek(5,0)
	tout_sauf_10 = f.read(taille)

	f.seek(0,0)
	tout = f.read()
	pos = tout.index(b'supprimer')
	f.seek(0,0)
	p1 = f.read(pos)
	f.seek(9,1)
	p2 = f.read()
