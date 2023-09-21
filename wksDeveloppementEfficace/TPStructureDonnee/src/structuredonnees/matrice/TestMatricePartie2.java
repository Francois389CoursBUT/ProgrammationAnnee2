/*
 * Programme de test de la classe MatriceCreuse (matrice creuse)
 * TestMatricePartie2.java                                              10/20
 */
package structuredonnees.matrice;

/**
 * Programme de test de la classe MatriceCreuse qui repr�sente une matrice creuse.
 * Seules les op�rations de la partie 2 du TP sont test�es.
 *    - multiplication de la matrice par un coefficient
 *    - addition de 2 matrices
 *    - multiplication de 2 matrices
 * @author INFO2
 * @version 1.0
 *
 */
public class TestMatricePartie2 {

    /** Dimension des matrices carr�es M1  et M2 utilis�es pour les tests */
    private static final int DIMENSION_M = 5;

    /**
     * jeux de donn�es avec les coordonn�es où seront plac�es des valeurs
     *  non nulles dans la matrice carr�e M1
     */
    private static final int[][] COORDONNEES_M1 = { {1, 2}, {3, 3}, {4, 1} };

    /**
     * Jeu de donn�es avec les valeurs des coefficients non nuls de la matrice M1
     */
    private static final double[] A_INSERER_M1 = { 10.5, 6, 5.3 };

    /**
     * jeux de donn�es avec les coordonn�es où seront plac�es des valeurs
     *  non nulles dans la matrice carr�e M2
     */
    private static final int[][] COORDONNEES_M2 = { {1, 3}, {3, 3}, {3, 4}, {4, 1}, {5, 5} };

    /**
     * Jeu de donn�es avec les valeurs des coefficients non nuls de la matrice M2
     */
    private static final double[] A_INSERER_M2 = { -2, -6, 9, 2.2, 1 };


    /** Nombre de lignes de la matrice A */
    private static final int LIGNE_A = 3;

    /** Nombre de colonnes de la matrice A */
    private static final int COLONNE_A = 4;

    /**
     * Jeu de donn�es avec les coordonn�es où seront plac�es des valeurs
     *  non nulles dans la matrice A
     */
    private static final int[][] COORDONNEES_A = { {1, 1}, {2, 3}, {3, 4} };

    /**
     * Jeu de donn�es avec les valeurs des coefficients non nuls de la matrice A
     */
    private static final double[] A_INSERER_A = { 4, -1, 9};


    /** Nombre de lignes de la matrice B */
    private static final int LIGNE_B = 4;

    /** Nombre de colonnes de la matrice A */
    private static final int COLONNE_B = 4;

    /**
     * Jeu de donn�es avec les coordonn�es où seront plac�es des valeurs
     *  non nulles dans la matrice B
     */
    private static final int[][] COORDONNEES_B = { {1, 2}, {2, 3}, {4, 1}, {4, 4} };

    /**
     * Jeu de donn�es avec les valeurs des coefficients non nuls de la matrice B
     */
    private static final double[] A_INSERER_B = { 4, 5, -5, 2};


    /**
     * Initialise une matrice
     * @param aInitiliaser  matrice à initialiser (elle doit d�jà être
     *                      cr��e à l'appel de la m�thode)
     * @param valeur    valeur des coefficients à ins�rer dans la matrice
     * @param position  coordonn�es des coefficients à ins�rer dans la matrice
     */
    private static void initMatrice(MatriceCreuse aInitialiser, double[] valeur,
                                    int[][] position) {
        for(int i = 0; i < valeur.length; i++) {
            aInitialiser.setValeur(position[i][0], position[i][1], valeur[i]);
        }
    }


    /**
     * Test de la m�thode qui multiplie la matrice par un facteur
     */
    public static void testMultiplier() {
        MatriceCreuse aTester = null;         // matrice utilis�e pour les tests
        MatriceCreuse resultat = null;        // matrice r�sultat de la multiplication

        System.out.println("Test de la multiplication par un facteur : \n"
                           + "-------------------------------------------\n\n"
                           + "Tests visuels : v�rifiez les r�sultats affich�s.\n\n");

        /* TEST 1 : on multiplie par 0 */
        aTester = new MatriceCreuse(DIMENSION_M, DIMENSION_M);
        resultat = aTester.multiplier(0);

        System.out.println("MatriceCreuse nulle multipli�e par 0 = ");
        resultat.afficher();

        initMatrice(aTester, A_INSERER_M1, COORDONNEES_M1);
        System.out.println("\nMatrice M1 initiale = ");
        aTester.afficher();

        System.out.println("\n\nMatrice M1 multipli�e par 0 = ");
        resultat = aTester.multiplier(0);
        resultat.afficher();

        /* TEST 2 : on multiplie par 2 */
        aTester = new MatriceCreuse(DIMENSION_M, DIMENSION_M);

        System.out.println("\nMatrice nulle multipli�e par 2 = ");
        resultat = aTester.multiplier(2);
        resultat.afficher();

        initMatrice(aTester, A_INSERER_M1, COORDONNEES_M1);
        System.out.println("\nMatrice M1 multipli�e par 2 = ");
        initMatrice(aTester, A_INSERER_M1, COORDONNEES_M1);
        resultat = aTester.multiplier(2);
        resultat.afficher();
    }


    /**
     * Programme de test de l'addition entre 2 matrices
     */
    public static void testAddition() {
        MatriceCreuse m1, m2;         // 2 matrices qu'il est possible d'additionner
        MatriceCreuse somme;          // r�sultat de l'additon de 2 matrices
        MatriceCreuse a, b;           // matrices de tailles diff�rentes : addition impossible

        System.out.println("\nTest de l'addition entre 2 matrices : \n"
                           + "---------------------------------------\n");

        /* TEST 1 : on tente d'addtionner des matrices de tailles diff�rentes */
        System.out.println("   => Test 1 : addition matrices tailles diff�rentes :\n"
                           + "      Vous devez v�rifier que le message d'erreur"
                           + "  est affich� correctement.\n");
        try {
            a = new MatriceCreuse(LIGNE_A, COLONNE_A);
            b = new MatriceCreuse(LIGNE_B, COLONNE_B);
            somme = MatriceCreuse.addition(a, b);
            System.out.println("ERREUR : l'addition a �t� jug�e possible.");
        } catch(IllegalArgumentException erreur) {
            System.out.println(erreur.getMessage());
        }

        /* TEST 2 : Addition des matrices M1 et M2 non nulles */
        System.out.println("\n\n   => Test 2 : addition de 2 matrices non nulles :\n");
        m1 = new MatriceCreuse(DIMENSION_M, DIMENSION_M);
        initMatrice(m1, A_INSERER_M1, COORDONNEES_M1);
        m2 = new MatriceCreuse(DIMENSION_M, DIMENSION_M);
        initMatrice(m2, A_INSERER_M2, COORDONNEES_M2);

        System.out.println("MatriceCreuse M1 = ");
        m1.afficher();
        System.out.println("\nMatrice M2 = ");
        m2.afficher();

        somme = MatriceCreuse.addition(m1, m2);
        System.out.println("\n\nSomme des 2 matrices = ");
        somme.afficher();

        somme = MatriceCreuse.addition(m1, m1);
        System.out.println("\n\nSomme M1 + M1 = ");
        somme.afficher();

        /* TEST 3 : Addition entre M1 et une matrice nulle */
        System.out.println("\n\n   => Test 3 : addition avec une matrice nulle :\n");
        m2 = new MatriceCreuse(DIMENSION_M, DIMENSION_M);   // m2 = matrice nulle

        System.out.println("MatriceCreuse M1 = ");
        m1.afficher();

        somme = MatriceCreuse.addition(m1, m2);
        System.out.println("\n\nSomme M1 + matrice nulle = ");
        somme.afficher();

        somme = MatriceCreuse.addition(m2, m1);
        System.out.println("\n\nSomme matrice nulle + M1 = ");
        somme.afficher();

        somme = MatriceCreuse.addition(m2, m2);
        System.out.println("\n\nSomme matrice nulle + matrice nulle = ");
        somme.afficher();

    }


    /**
     * Programme de test de la multiplication entre 2 matrices
     */
    @SuppressWarnings("unused")
    public static void testMultiplication() {
        MatriceCreuse a, b;           // 2 matrices qu'il est possible de multiplier
        MatriceCreuse produit;        // r�sultat de la multiplication des 2 matrices
        MatriceCreuse m1, m2;         // 2 matrices de même taille qui peuvent se multiplier

        System.out.println("\nTest de la multiplication entre 2 matrices : \n"
                           + "---------------------------------------\n");

        /* TEST 1 : on tente de multiplier des matrices de tailles incompatibles */
        System.out.println("   => Test 1 : multiplication matrices tailles incompatibles :\n"
                           + "      Vous devez v�rifier que le message d'erreur"
                           + "  est affich� correctement.\n");
        try {
            a = new MatriceCreuse(LIGNE_A, COLONNE_A);
            m1 = new MatriceCreuse(DIMENSION_M, DIMENSION_M);
            produit = MatriceCreuse.multiplication(a, m1);
            System.out.println("ERREUR : la multiplication a été jugée possible.");
        } catch(IllegalArgumentException erreur) {
            System.out.println(erreur.getMessage());
        }

        /* TEST 2 : Multiplication des matrices A et B non nulles */
        System.out.println("\n\n   => Test 2 : multiplication de 2 matrices non nulles :\n");
        a = new MatriceCreuse(LIGNE_A, COLONNE_A);
        initMatrice(a, A_INSERER_A, COORDONNEES_A);
        b = new MatriceCreuse(LIGNE_B, COLONNE_B);
        initMatrice(b, A_INSERER_B, COORDONNEES_B);

        System.out.println("MatriceCreuse A = ");
        a.afficher();
        System.out.println("\nMatrice B = ");
        b.afficher();

        produit = MatriceCreuse.multiplication(a, b);
        System.out.println("\n\nMultiplication des 2 matrices = ");
        produit.afficher();


        /* TEST 3 : Multiplication entre a et une matrice nulle */
        System.out.println("\n\n   => Test 3 : multiplication avec une matrice nulle :\n");
        a = new MatriceCreuse(LIGNE_A, COLONNE_A);
        initMatrice(a, A_INSERER_A, COORDONNEES_A);
        b = new MatriceCreuse(LIGNE_B, COLONNE_B);

        System.out.println("MatriceCreuse a = ");
        a.afficher();

        produit = MatriceCreuse.multiplication(a, b);
        System.out.println("\n\nProduit a * matrice nulle = ");
        produit.afficher();

        /* TEST 4 : Multiplication des matrices A et B non nulles */
        System.out.println("\n\n   => Test 4 : multiplication de 2 matrices non nulles :\n");
        a = new MatriceCreuse(LIGNE_A, COLONNE_A);
        initMatrice(a, A_INSERER_A, COORDONNEES_A);
        a.setValeur(1, 4, -8);
        a.setValeur(3, 1, 3);
        b = new MatriceCreuse(LIGNE_B, COLONNE_B);
        initMatrice(b, A_INSERER_B, COORDONNEES_B);
        b.setValeur(4, 2, 2);

        System.out.println("MatriceCreuse A = ");
        a.afficher();
        System.out.println("\nMatrice B = ");
        b.afficher();

        produit = MatriceCreuse.multiplication(a, b);
        System.out.println("\n\nMultiplication des 2 matrices = ");
        produit.afficher();
    }


    /**
     * Autre test pour l'addition : les 2 matrices op�randes sont configur�es
     * de telle sorte que l'ajout de 2 coefficients donne la valeur 0, à plusieurs
     * reprise. Le but est de bien v�rifier que ce coefficient nul n'est pas ajout�
     * dans la liste des coefficients de la matrice r�sultat
     */
    public static void testAdditionComplementaire() {
        try {
            MatriceCreuse mat1 = new MatriceCreuse(50,50);
            MatriceCreuse mat2 = new MatriceCreuse(50,50);

            // pr�paration de mat1
            mat1.setValeur(1, 2, 5);
            mat1.setValeur(2, 1, 1);
            mat1.setValeur(2, 4, 7);
            mat1.setValeur(3, 3, 2);
            mat1.setValeur(4, 2, 8);
            mat1.setValeur(4, 5, 5);

            // pr�paration de mat2
            mat2.setValeur(1, 3, 3);
            mat2.setValeur(2, 1, -1);
            mat2.setValeur(2, 4, 7);
            mat2.setValeur(3, 2, 1);
            mat2.setValeur(3, 3, -2);
            mat2.setValeur(4, 2, 2);
            mat2.setValeur(4, 4, 1);
            mat2.setValeur(4, 5, -5);

            // affichage des matrices mat1, mat2 et du r�sultat
            System.out.println("\nTest compl�mentaire de l'addition entre 2 matrices : \n"
                    + "-----------------------------------------------------\n\n"
                    + "      Vous devez v�rifier que la somme des 2 matrices est correcte. \n"
                    + "      (en particulier qu'il n'y a pas de coef. nul dans le r�sultat.");

            System.out.println("\nMatrice mat1 = ");
            mat1.afficher();

            System.out.println("\n\nMatrice mat2 = ");
            mat2.afficher();

            MatriceCreuse addition = MatriceCreuse.addition(mat1, mat2);
            System.out.println("\n\nMatrice addition = ");
            addition.afficher();
        } catch (IllegalArgumentException erreur) {
            System.out.println("ERREUR : l'exception lev�e alors que ce n'est pas n�cessaire.");
        }
    }


    /**
     * Autre test pour l'addition : les 2 matrices op�randes sont configur�es
     * de telle sorte que la multiplication engendre, à plusieurs
     * reprise, un r�sultat nul. Le but est de bien v�rifier que ce coefficient nul
     * n'est pas ajout� dans la liste des coefficients de la matrice r�sultat
     */
    private static void testProduitComplementaire() {
        try {
            MatriceCreuse a = new MatriceCreuse(4, 4);
            MatriceCreuse b = new MatriceCreuse(4, 3);

            // pr�paration de mat1
            a.setValeur(1, 1, 2);
            a.setValeur(1, 4, 3);
            a.setValeur(2, 3, 1);
            a.setValeur(3, 2, 2);
            a.setValeur(4, 4, 5);

            // pr�paration de mat2
            b.setValeur(1, 2, -3);
            b.setValeur(1, 3, 6);
            b.setValeur(4, 1, -1);
            b.setValeur(4, 2, 2);
            b.setValeur(4, 3, -4);

            // affichage des matrices mat1, mat2 et du r�sultat
            System.out.println("\n\n\nTest compl�mentaire multiplication entre 2 matrices :\n"
                    + "-----------------------------------------------------\n\n"
                    + "      Vous devez v�rifier que la multiplication est correcte. \n"
                    + "      (en particulier qu'il n'y a pas de coef. nul dans le r�sultat.");


            System.out.println("\nMatrice A = ");
            a.afficher();
            System.out.println("\nMatrice B = ");
            b.afficher();

            MatriceCreuse resultat = MatriceCreuse.multiplication(a, b);
            System.out.println("\nR�sultat = ");
            resultat.afficher();
        } catch(IllegalArgumentException erreur) {
            System.out.println("Exception");
        }
    }

    /**
     * Test de la m�thode compareTo de la class Coefficient
     */
    private static void testComparTo() {
        boolean testPasser = true;
        Coefficient c1 = new Coefficient(1, 1, 1);
        Coefficient c2 = new Coefficient(1, 2, 1);
        Coefficient c3 = new Coefficient(2, 1, 1);
        Coefficient c4 = new Coefficient(2, 2, 1);

        testPasser &= c1.compareTo(c2) <= -1;
        testPasser &= c2.compareTo(c1) >= 1;
        testPasser &= c1.compareTo(c1) == 0;
        testPasser &= c3.compareTo(c4) <= -1;
        testPasser &= c4.compareTo(c3) >= 1;

        System.out.println(testPasser ? "Test Passer" : " TEST RATE");
    }

    /**
     * Programme principal permettant de lancer les proc�dures de test
     * @param args  argument non utilis�
     */
    public static void main(String[] args) {
        System.out.println("TEST METHODES DE CALCUL -  CLASSE MATRICE CREUSE\n\n");
        testMultiplier();
        testAddition();
        testAdditionComplementaire();
        testMultiplication();
        testProduitComplementaire();
        testComparTo();
    }



}



