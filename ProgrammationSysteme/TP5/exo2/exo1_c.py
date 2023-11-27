import module_udp as udp

# Client

message_fin = udp.get_message_fin()

udp.definir_pseudo()
coord_S = ('192.168.140.48', 65432)
s = udp.preparer_client()
on_continue : bool = True # on arrête les échanges si 'fin' et au moindre problème
if (s != -1):
    while (on_continue):
        requete = udp.construire_requete()
        if (message_fin.encode() in requete):
            on_continue = False
        statut_envoi = udp.envoyer(s,coord_S,requete)
        if (statut_envoi == -1):
            on_continue = False
        else:
            (reponse, coord_S) = udp.recevoir(s)
            if (reponse != -1):
                udp.utiliser(reponse)
            else:
                on_continue = False
    udp.arreter(s)



