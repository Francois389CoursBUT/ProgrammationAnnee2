import module_tcp as tcp

coord_S = ('127.0.0.1', 65432)
s1 = tcp.preparer_serveur(coord_S)
on_continue = True

if (s1 != -1):
    while (on_continue == True):
        s2 = tcp.accepter(s1)
        if (s2 != -1):
            requete = tcp.recevoir(s2)
            if (requete != -1):
                bloc = tcp.analyser(requete)
                if (bloc == b'fin'):
                    on_continue = False
                reponse = tcp.construire_reponse(bloc)
                statut_envoi = tcp.envoyer(s2,reponse)
                if (statut_envoi == -1):
                    on_continue = False
            else:
                on_continue = False
            tcp.arreter(s2)
    tcp.arreter(s1)
