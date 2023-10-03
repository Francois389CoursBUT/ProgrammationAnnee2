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

    /**
    * Constante égale au nombre d'espaces d'indentation à laisser lors de
    * l'affichage des différents niveaux de l'arbre
    */
    private static final int DECALAGE = 5;

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
    * Affiche les valeurs contenues dans l'arbre débutant au noeud argument
    * Chaque fois que l'on descend d'un niveau dans l'arbre, les valeurs des
    * noeuds sont affichées (en colonne) à droite des précédentes.
    * @param niveau niveau de profondeur du noeud courant. Cette valeur sert à calculer
    * sur quelle colonne il faut effectuer l'affichage
    */
    public void afficheArbreNiveau(int niveau) {
        //TODO ça marche pas
        if (voisinGauche == null && voisinDroite == null) {
            blanc(niveau);
            System.out.println(valeur);
        }
        if (voisinGauche != null) {
            voisinGauche.afficheArbreNiveau(niveau + 1);
        }
        if (voisinDroite != null) {
            voisinDroite.afficheArbreNiveau(niveau + 1);
        }
        blanc(niveau);
        System.out.print(valeur);
    }

    /**
     * Affiche nbBlanc fois le caractère espace
     * TODO comment method role
     * @param nbBlanc
     */
    private void blanc(int nbBlanc) {
        for (int i = 0; i < nbBlanc; i++) {
            System.out.print(' ');
        }
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

    public Noeud<E> getVoisinDroite() {
        return voisinDroite;
    }

    public Noeud<E> getVoisinGauche() {
        return voisinGauche;
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
                voisinGauche = new Noeud<>(valeurAInserer);
                return true;
            }
            return voisinGauche.inserer(valeurAInserer);
        }
        if (voisinDroite == null) {
            voisinDroite = new Noeud<>(valeurAInserer);
            return true;
        }
        return voisinDroite.inserer(valeurAInserer);
    }






}
