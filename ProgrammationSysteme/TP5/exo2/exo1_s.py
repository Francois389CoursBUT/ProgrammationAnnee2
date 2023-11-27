import module_udp as udp

# Serveur

message_fin = udp.get_message_fin()

coord_S = ('127.0.0.1', 65432)
s = udp.preparer_serveur(coord_S)
on_continue = True # on arrête les échanges si 'fin' et au moindre problème
if (s != -1):
    while (on_continue):
        (requete, coord_C) = udp.recevoir(s)
        udp.incremente_compteur()
        if (requete != -1):
            bloc= udp.analyser(requete)
            if (message_fin.encode() in bloc):
                on_continue = False
            reponse = udp.construire_reponse(bloc)
            statut_envoi = udp.envoyer(s,coord_C,reponse)
            
            on_continue = statut_envoi != -1
        else:
            on_continue = False
    udp.arreter(s)