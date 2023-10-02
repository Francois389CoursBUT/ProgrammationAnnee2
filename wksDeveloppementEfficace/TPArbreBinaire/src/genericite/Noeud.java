/*
 * Noeud.java                                    2 oct. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package genericite;

/** 
 * Représente un arbre binaire de recharche
 * @author "FranÃ§ois de Saint Palais"
 */
public class Noeud<E extends Comparable<E>> {
    
    private E valeur;
    
    private Noeud<E> voisinGauche;

    private Noeud<E> voisinDroite;

    /**
     * Un Noeud a une valeur non null est des voisins
     * @param valeur
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
    }

    /** 
     * TODO comment method role
     * @param valeurAInserer
     */
    public boolean inserer(E valeurAInserer) {
        if (estPresente(valeurAInserer)) {
            return false;
        }
        if (valeurAInserer.compareTo(valeur) < 0) {
            if (voisinGauche == null) {
                voisinGauche = new Noeud<E>(valeurAInserer);
                return true;
            }
            return voisinGauche.inserer(valeurAInserer);
        }
        if (voisinDroite == null) {
            voisinDroite = new Noeud<E>(valeurAInserer);
            return true;
        }
        return voisinDroite.inserer(valeurAInserer);
    }

    /** 
     * TODO comment method role
     * @param valeurRechercher recherche
     * @return
     */
    public boolean estPresente(E valeurRechercher) {
        if (valeurRechercher.equals(valeur)) {
            return true;
        }
        if (voisinGauche != null && valeurRechercher.compareTo(valeur) < 0) {
            return voisinGauche.estPresente(valeurRechercher);
        }
        // if (this.valeur < valeur)
        return voisinDroite != null && voisinDroite.estPresente(valeurRechercher);
    }

    
    //TODO Tester les getteur
    public E getValeur() {
        return valeur;
    }

    public Noeud<E> getVoisinGauche() {
        return voisinGauche;
    }

    public Noeud<E> getVoisinDroite() {
        return voisinDroite;
    }
    
    
    
    
    
    
}
