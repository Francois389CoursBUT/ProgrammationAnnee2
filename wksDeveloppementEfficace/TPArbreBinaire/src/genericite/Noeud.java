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
        if (voisinDroite != null) {
            voisinDroite.afficheArbreNiveau(niveau + 1);
        }
        blanc(niveau);
        System.out.println(valeur);
        if (voisinGauche != null) {
            voisinGauche.afficheArbreNiveau(niveau + 1);
        }
    }

    /**
     * Affiche nbBlanc fois le caractère espace
     * TODO comment method role
     * @param nbBlanc
     */
    private void blanc(int nbBlanc) {
        for (int i = 0; i < nbBlanc * DECALAGE; i++) {
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
    
    public String parcoursPrefixe() {
        StringBuilder resultat = new StringBuilder();
        resultat.append(valeur).append("  ")
                .append(voisinGauche == null ? "" : voisinGauche.parcoursPrefixe())
                .append(voisinDroite == null ? "" : voisinDroite.parcoursPrefixe());
        return resultat.toString();
    }
    
    public String parcoursInfixe() {
        StringBuilder resultat = new StringBuilder();
        if (voisinGauche != null) resultat.append(voisinGauche.parcoursInfixe());
        resultat.append(valeur).append("  ");
        if (voisinDroite != null) resultat.append(voisinDroite.parcoursInfixe());
        return resultat.toString();
    }
    
    public String parcoursPostfixe() {
        StringBuilder resultat = new StringBuilder();
        if (voisinGauche != null) resultat.append(voisinGauche.parcoursInfixe());
        if (voisinDroite != null) resultat.append(voisinDroite.parcoursInfixe());
        resultat.append(valeur).append("  ");
        return resultat.toString();
    }

    
    public int hauteur() {
        if (voisinGauche == null && voisinDroite == null) {
            return 1;
        }
        if (voisinGauche == null) {
            return voisinDroite.hauteur() + 1;
        }
        if (voisinDroite == null) {
            return voisinGauche.hauteur();
        }
        return Math.max(voisinGauche.hauteur(), voisinDroite.hauteur()) + 1;
    }
    
    
    public boolean estSurUneFeuille(E valeurCherche) {
        if (voisinGauche == null && voisinDroite == null ) {
            return valeurCherche.equals(valeur);
        }
        
        if (voisinGauche != null && voisinDroite != null) {
            return valeurCherche.compareTo(valeur) < 0 ?
                   voisinGauche.estSurUneFeuille(valeurCherche):
                   voisinDroite.estSurUneFeuille(valeurCherche);     
        }
        
        if (voisinGauche != null && valeurCherche.compareTo(valeur) < 0) {
            return voisinGauche.estSurUneFeuille(valeurCherche);
        }
        if (voisinDroite != null && valeur.compareTo(valeurCherche) < 0) {
            return voisinDroite.estSurUneFeuille(valeurCherche);
        }
        
        return false;
    }
    
    public E plusGrandElement() {
        if (voisinDroite != null) {
            return voisinDroite.plusGrandElement();
        }
        return valeur;
    }

    /** 
     * Supprime un element si il est sur une feuille
     * @param valeurASupprimer La valeur de la feuille à supprimer
     * @return true si l'élement à pu êter supprimer 
     * false sinon 
     */
    public boolean supprimeSiFeuille(E valeurASupprimer) {
        //TODO Fix 
        if (valeurASupprimer.compareTo(valeur) < 0) {
            if (voisinGauche.voisinGauche == null && voisinGauche.voisinDroite == null) {
                if (voisinGauche.valeur.equals(valeurASupprimer)) {
                    voisinGauche = null; //Suppression de l'élement
                    return true;                    
                } else {
                    return false;
                }
            }
            return voisinGauche.supprimeSiFeuille(valeurASupprimer);
        }
        
        if (valeurASupprimer.compareTo(valeur) > 0) {
            if (voisinDroite.voisinGauche == null && voisinDroite.voisinDroite == null) {
                if (voisinDroite.valeur.equals(valeurASupprimer)) {
                    voisinDroite = null; //Suppression de l'élement
                    return true;                    
                } else {
                    return false;
                }
            }
            return voisinDroite.supprimeSiFeuille(valeurASupprimer);
        }
        return false;
        
    }




}
