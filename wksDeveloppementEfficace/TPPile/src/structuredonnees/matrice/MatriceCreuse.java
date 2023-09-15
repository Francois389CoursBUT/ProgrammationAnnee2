/*
 * MatriceCreuse.java                                    15 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package structuredonnees.matrice;

import java.util.ArrayList;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
public class MatriceCreuse {

    private static final int HAUTEUR_DEFAUT = 5;
    
    private static final int LARGEUR_DEFAUT = 5;
        
    /** 
     * Contient les Coefficient non nul
     */
    private ArrayList<Coefficient> donnee;
    
    /** Le nombre de ligne dans la matrice */
    private int hauteur;
    
    
    /** Le nombre de colonne dans la matrice */
    private int largeur;

    /** 
     * Créer une matrice carré de taille 5, par défaut
     * Tout les coefficient sont nul.
     */
    public MatriceCreuse() {
        super();
        hauteur = HAUTEUR_DEFAUT;
        largeur = LARGEUR_DEFAUT;
        donnee = new ArrayList<>();
    }

    /** 
     * Créer une matrice nul de dimmension hauteur, largeur
     * @param hauteur Le nombre de ligne de la matrice
     * @param largeur Le nombre de colonne de la matrice
     * @throws IllegalArgumentException Si une des dimmensions est inférieur à 1
     */
    public MatriceCreuse(int hauteur, int largeur) {
        super();
        if (hauteur < 1 || largeur < 1) {
            throw new IllegalArgumentException("Erreur : Les dimensions de la "
                    + "matrice doivent au minimum être à 1");
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        donnee = new ArrayList<>();
    }
    
    /**
     * Retourne la valeur du coefficient à la position ligne, colonne
     * @param ligne
     * @param colonne
     * @return La valeur du coefficent au coordonnée donnée
     */
    public double getValeur(int ligne, int colonne) {
        if (   ligne   < 1 || hauteur < ligne 
            || colonne < 1 || largeur < colonne) {
            throw new IllegalArgumentException("Erreur : les coordonnées "
                    + "selectionner sont hors des dimmensions de la matrice");
        }
        for (Coefficient coefficient : donnee) {
            if (   coefficient.getColonne() == colonne 
                && coefficient.getLigne() == ligne) {
                return coefficient.getValeur();
            }
        }
        return 0;
    }

    /**
     * Change la valeur du coefficient à la position ligne, colonne
     * @param ligne
     * @param colonne
     * @param valeur
     */
    public void setValeur(int ligne, int colonne, double valeur) {
        if (   ligne   < 1 || hauteur < ligne 
                || colonne < 1 || largeur < colonne) {
            throw new IllegalArgumentException("Erreur : les coordonnées "
                    + "selectionner sont hors des dimmensions de la matrice");
        }
        
        boolean coefficientEstSet = false;
        int cpt = 0;
        
        for (Coefficient coefficient : donnee) {
            if (   coefficient.getColonne() == colonne 
                    && coefficient.getLigne() == ligne) {
                if (valeur == 0) {
                    donnee.remove(cpt);
                } else {
                    coefficient.setValeur(valeur);                    
                }
                coefficientEstSet = true;
            }
            cpt ++;
        }
        if (!coefficientEstSet) {
            donnee.add(new Coefficient(ligne, colonne, valeur));
        }
    }
    
    /** Affiche les coefficients non nul */
    public void afficher() {
        String template = "Ligne : %d | Colonne : %d | Valeur : %d%n";
        for (Coefficient coefficient : donnee) {
            System.out.printf(template,coefficient.getLigne(), 
                    coefficient.getColonne(), coefficient.getValeur());
        }
    }
    
    /**
     * TODO comment method role
     * @param facteur
     */
    public void multiplication(double facteur) {
       for (Coefficient coefficient : donnee) {
           coefficient.setValeur(coefficient.getValeur() * facteur);
       } 
    }
    
    /**
     * @param mat1
     * @param mat2
     * @return renvoie Une matrice resultant de l'addition de mat1 et mat2
     */
    public MatriceCreuse addition(MatriceCreuse mat1, MatriceCreuse mat2) {
        if (mat1.hauteur != mat2.hauteur || mat1.largeur == mat2.largeur) {
            throw new IllegalArgumentException("Erreur : Les deux matrice ne "
                    + "$sont pas de la même dimensions");
        }
        
        MatriceCreuse resultat = new MatriceCreuse(mat1.hauteur,mat1.largeur);
        
        return null;
    }
}
