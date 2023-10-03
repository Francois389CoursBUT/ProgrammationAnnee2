/*
 * ArbreBinaire.java                                    2 oct. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package genericite;

/**
 * TODO comment class responsibility (SRP)
 * @author Fran�ois de Saint Palais
 */
public class ArbreBinaire<E extends Comparable<E>> {

    private Noeud<E> racine;

    /**
     * Constructeur par d�faut, initialise � vide.
     */
    public ArbreBinaire() {}

    /**
     *
     * TODO comment method role
     */
    public void afficheAbreNiveau() {
        if (racine != null) {
            racine.afficheArbreNiveau(0);
        }
    }

     /**
     * @param valeurRechercher
     * @return
     */
    public boolean estPresente(E valeurRechercher) {
        return racine != null && racine.estPresente(valeurRechercher);
    }

    /**
     * Ins�re un Noeud
     * @param valeur La valeur � ajouter
     */
    public boolean inserer(E valeur) {
        if (racine == null) {
            racine = new Noeud<>(valeur);
            return true;
        }
        return racine.inserer(valeur);
    }
}
