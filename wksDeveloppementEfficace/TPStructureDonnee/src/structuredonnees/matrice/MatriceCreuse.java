/*
 * MatriceCreuse.java                                    15 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package structuredonnees.matrice;

import java.util.ArrayList;

/**
 * Repr�sente une matrice creuse.
 *
 * @author Fran�ois de Saint Palais
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
     * Cr�er une matrice carr� de taille 5, par d�faut
     * Tout les coefficient sont nul.
     */
    public MatriceCreuse() {
        super();
        hauteur = HAUTEUR_DEFAUT;
        largeur = LARGEUR_DEFAUT;
        donnee = new ArrayList<>();
    }

    /**
     * Cr�er une matrice nul de dimension hauteur, largeur
     * @param hauteur Le nombre de ligne de la matrice
     * @param largeur Le nombre de colonne de la matrice
     * @throws IllegalArgumentException Si une des dimensions est inf�rieur � 1
     */
    public MatriceCreuse(int hauteur, int largeur) {
        super();
        if (hauteur < 1 || largeur < 1) {
            throw new IllegalArgumentException("Erreur : Les dimensions de la "
                    + "matrice doivent au minimum être � 1");
        }
        this.hauteur = hauteur;
        this.largeur = largeur;
        donnee = new ArrayList<>();
    }

    /**
     * Retourne la valeur du coefficient � la position ligne, colonne
     * @param ligne
     * @param colonne
     * @return La valeur du coefficient au coordonn�e donn�e
     */
    public double getValeur(int ligne, int colonne) {
        if (   ligne   < 1 || hauteur < ligne
            || colonne < 1 || largeur < colonne) {
            throw new IllegalArgumentException("Erreur : les coordonn�es "
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
     * Change la valeur du coefficient � la position ligne, colonne
     * @param ligne
     * @param colonne
     * @param valeur
     */
    public void setValeur(int ligne, int colonne, double valeur) {
        if (   ligne   < 1 || hauteur < ligne
                || colonne < 1 || largeur < colonne) {
            throw new IllegalArgumentException("Erreur : les coordonn�es "
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
        String template = "Ligne : %d | Colonne : %d | Valeur : %f%n";
        for (Coefficient coefficient : donnee) {
            System.out.printf(template,coefficient.getLigne(),
                    coefficient.getColonne(), coefficient.getValeur());
        }
    }

    /**
     * @param facteur
     * @return la matrice resultant du produit scalaire
     */
    public MatriceCreuse multiplier(double facteur) {

       MatriceCreuse resultat = new MatriceCreuse(hauteur, largeur);

       for (int i = 1; i < resultat.hauteur; i++) {
           for (int j = 1; j < resultat.largeur; j++) {
               resultat.setValeur(i, j, getValeur(i, j) * facteur);
           }
       }

       return resultat;
    }

    /**
     * @param mat1
     * @param mat2
     * @return renvoie Une matrice resultant de l'addition de mat1 et mat2
     */
    public static MatriceCreuse addition(MatriceCreuse mat1, MatriceCreuse mat2) {
        if (mat1.hauteur != mat2.hauteur || mat1.largeur != mat2.largeur) {
            throw new IllegalArgumentException("Erreur : Les deux matrice ne "
                    + "sont pas de la m�me dimensions");
        }

        MatriceCreuse resultat = new MatriceCreuse(mat1.hauteur,mat1.largeur);

        for (int i = 1; i < resultat.hauteur; i++) {
            for (int j = 1; j < resultat.largeur; j++) {
                resultat.setValeur(i, j,
                        mat1.getValeur(i, j) + mat2.getValeur(i, j));
            }
        }

        return resultat;
    }

    /**
     * Multiplication matricielle
     * @param m1
     * @param m2
     * @return la matrice resultante du produit
     */
    public static MatriceCreuse multiplication(MatriceCreuse m1, MatriceCreuse m2) {
        if (m1.largeur != m2.hauteur) {
            throw new IllegalArgumentException(
                    String.format(  "Erreur : Produit matricielle impossible"
                                  + " %d != %d",m1.largeur, m2.hauteur)
            );
        }
        MatriceCreuse resultat = new MatriceCreuse(m1.hauteur, m2.largeur);
        for (int i = 1; i < resultat.hauteur; i++) {
            for (int j = 1; j < resultat.largeur; j++) {
                resultat.setValeur(i, j, produitScalaire(m1, m2, i, j));
            }
        }
        return resultat;
    }

    /**
     * Calcule le produit scalaire de deux vecteur.
     * C'est une m�thode extraite du calcul du produit matricielle
     * @param m1 La matrice o� ce trouve le vecteur horizontale
     * @param m2 La matrice o� ce trouve le vecteur vertical
     * @param ligne L'indice du vecteur horizontale
     * @param colonne L'indice du vecteur vertical
     * @return
     */
    private static double produitScalaire (MatriceCreuse m1, MatriceCreuse m2, int ligne, int colonne) {
        double resultat = 0;
        /* Ici nous aurions pu utiliser m2.hauteur en effet ces deux valeur sont identique */
        for (int i = 1; i < m1.largeur; i++) {
            resultat += m1.getValeur(ligne, i) * m2.getValeur(i, colonne);
        }
        return resultat;
    }
}









