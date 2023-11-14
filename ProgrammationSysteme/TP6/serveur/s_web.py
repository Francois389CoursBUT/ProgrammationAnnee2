# base : TP5 exo3 serveur itératif multi-connexions
import module_tcp as tcp
# attention : changer valeur TAILLE 128 -> 512 
import os.path

def analyser(bloc):
    # extraction du nom de la page web demandée de la 1ère ligne de la requête reçue
    print("requête reçue : ", bloc.decode())
    p1 = bloc.split(b' ')
    commande = p1[0]
    print('commande HTTP = ',commande.decode()) # pour info
    chemin = p1[1][1:]
    print('chemin = ',chemin.decode())
    return(chemin.decode())

def construire_reponse(chemin):
    entete = b'HTTP/1.1 200 OK\n\n'
    rep_404 = b'HTTP/1.1 404 NOT FOUND\n\n<!DOCTYPE html><HEAD><TITLE>PROBLEME</TITLE></HEAD><BODY>Page non trouvee</BODY></HTML>'
    if (os.path.exists(chemin) == True):
        f = open(chemin,'br')
        corps = f.read()
        f.close()
        reponse = entete + corps
    else:
        reponse = rep_404
    return(reponse)

coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
on_continue = True
if (s1 != -1):
    while (on_continue == True):
        s2 = tcp.accepter(s1)
        if (s2 != -1):
            requete = tcp.recevoir(s2)
            if (requete != -1):
                nom_page = analyser(requete)
                if (nom_page == 'fin'):
                    on_continue = False
                    # normalement, ne s'arrête jamais
                reponse = construire_reponse(nom_page)
                statut_envoi = tcp.envoyer(s2,reponse)
                if (statut_envoi == -1):
                    on_continue = False
            else:
                on_continue = False
            tcp.arreter(s2)
    tcp.arreter(s1)