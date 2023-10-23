import module_udp as udp

coord_S = ('127.0.0.1', 65432)
s = udp.preparer_serveur(coord_S)
on_continue = True # on arrête les échanges si 'fin' et au moindre problème
if (s != -1):
    while (on_continue == True):
        (requete, coord_C) = udp.recevoir(s)
        if (requete != -1):
            bloc = udp.analyser(requete)
            if (bloc == b'fin'):
                on_continue = False
            reponse = udp.construire_reponse(bloc)
            statut_envoi = udp.envoyer(s,coord_C,reponse)
            if (statut_envoi == False):
                on_continue = False
        else:
            on_continue = False
    udp.arreter(s)