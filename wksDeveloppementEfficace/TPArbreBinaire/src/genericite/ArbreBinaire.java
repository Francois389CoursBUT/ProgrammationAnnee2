/*
 * ArbreBinaire.java                                    2 oct. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package genericite;

/**
 * Un arbre binaire de recherche
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
        } else {
            System.out.println();
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
    
    public String parcoursPrefixe() {
        return racine == null ? "Arbre vide" : racine.parcoursPrefixe();
    }
    
    public String parcoursInfixe() {
        return racine == null ? "Arbre vide" : racine.parcoursInfixe();
    }
    
    public String parcoursPostfixe() {
        return racine == null ? "Arbre vide" : racine.parcoursPostfixe();
    }

    /** 
     * @return la hauteur de l'arbre
     */
    public int hauteur() {
        return racine == null ? 0 :racine.hauteur();
    }

    /**
     * @param valeur La valeur de l'�l�ment recherche
     * @return true si l'�l�ment est sur une feuille false sinon
     */
    public boolean estSurUneFeuille(E valeur) {
        return racine == null ? false : racine.estSurUneFeuille(valeur);
    }

    /** 
     * @return Le plus grand �lement de l'arbre, bas� sur la relation d'ordre de
     * comparTo()
     */
    public E plusGrandElement() {
        if (racine != null) {
            return racine.plusGrandElement();            
        }
        return null;
    }

    /** 
     * Supprime un element si il est sur une feuille
     * @param valeur La valeur de la feuille � supprimer
     * @return true si l'�lement � pu �ter supprimer 
     * false sinon 
     */
    public boolean supprimeSiFeuille(E valeur) {
        if (racine == null ) {
            return false;
        }
        if (   racine.getVoisinGauche() == null
            && racine.getVoisinDroite() == null) {
            racine = null;
            return true;
        }
        if (racine.getValeur().equals(valeur) || !racine.estPresente(valeur)) {
            return false;
        }
        return racine.supprimeSiFeuille(valeur);
    }
    
    /**
     * 
     * TODO comment method role
     * @param valeur
     * @return
     */
    public boolean supprimerQuelconque(E valeur) {
        if (   racine == null || !racine.estPresente(valeur) 
            || racine.getValeur().equals(valeur)) {
            
            return false;
        }
        return racine.supprimerQuelconque(racine, valeur);
    }

}
