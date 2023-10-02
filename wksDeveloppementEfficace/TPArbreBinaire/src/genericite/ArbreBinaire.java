/*
 * ArbreBinaire.java                                    2 oct. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package genericite;

/** 
 * TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 */
public class ArbreBinaire<E extends Comparable<E>> {

    private Noeud<E> racine;
    
    /**
     * Constructeur par défaut, initialise à vide.
     */
    public ArbreBinaire() {}

    /** 
     * Insére un Noeud
     * @param valeur La valeur à ajouter
     */
    public boolean inserer(E valeur) {
        if (racine == null) {
            racine = new Noeud<E>(valeur);
            return true;
        }
        return racine.inserer(valeur);
    }

    /** 
     * @param i
     * @return
     */
    public boolean estPresente(E i) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * TODO comment method role
     * @param valeur
     * @return
     */
    public boolean estSurUneFeuille(E valeur) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * TODO comment method role
     * @return
     */
    public String hauteur() {
        
        return null;
    }
    
    
}
