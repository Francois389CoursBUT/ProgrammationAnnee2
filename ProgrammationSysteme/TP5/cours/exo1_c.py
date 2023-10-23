import module_udp as udp

coord_S = ('127.0.0.1', 65432)
s = udp.preparer_client()
on_continue = True # on arrête les échanges si 'fin' et au moindre problème
if (s != -1):
    while (on_continue == True):
        requete = udp.construire_requete()
        if (requete == b'fin'):
            on_continue = False
        statut_envoi = udp.envoyer(s,coord_S,requete)
        if (statut_envoi != -1):
            (reponse, coord_S) = udp.recevoir(s)
            if (reponse != -1):
                udp.utiliser(reponse)
            else:
                on_continue = False
        else:
            on_continue = False 
    udp.arreter(s)



