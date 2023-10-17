/*
 * Test des m�thodes de la  classe arbre binaire (questions 4 �7)
 * TestArbreSuite.java
 */
package test.genericite;

import genericite.ArbreBinaire;

/**
 * Test des m�thodes des classes g�rant les arbres binaires (questions 4 �7)
 * @author INFO2
 */
public class TestArbreSuite {
    
    /**
     * Valeurs � ins�ser pour les tests
     */
    private static final int[] A_INSERER = {25, 77, 11, 5, 20};

    /**
     * Valeurs pr�sentes dans l'arbre de l'�nonc�
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68, 
                                               25, 11, 43, 7, 17, 31, 44};
    
    /**
     * 
     * M�thode qui cr�e un arbre et ins�re toutes les valeus du
     * tableau argument. La premi�re valeur sera celle du noeud racine
     * @param valeursAInserer  entiers � ins�rer dans l'arbre
     * @return un arbre contenant les valeurs du tableau argument
     */
    public static ArbreBinaire<Integer>  creerArbre(int[] valeursAInserer) {
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        
        for (int valeur : valeursAInserer) {
            arbre.inserer(valeur);
        }
        return arbre;
    }
        
    
    /**
     * Test des 3 m�thodes de parcours
     */
    public static void test3Parcours() {
        System.out.println("\nTest des 3 m�thodes de parcours :\n"
                           + "-------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Avec l'arbre de l'�nonc� :");
        System.out.println("  Resultat du parcours prefixe : " + arbre.parcoursPrefixe());
        System.out.println("  Resultat du parcours infixe : " + arbre.parcoursInfixe());
        System.out.println("  Resultat du parcours postfixe : " + arbre.parcoursPostfixe());
        
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("\nAvec l'arbre vide :");
        System.out.println("  Resultat du parcours prefixe : " + arbreVide.parcoursPrefixe());
        System.out.println("  Resultat du parcours infixe : " + arbreVide.parcoursInfixe());
        System.out.println("  Resultat du parcours postfixe : " + arbreVide.parcoursPostfixe());
        
    }
    
    
    /**
     * Test de la m�thode hauteur : sur un arbre vide et sur l'arbre de l'�nonc�
     */
    public static void testHauteur() {
        System.out.println("\nTest de la hauteur de l'arbre :\n"
                + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Hauteur de l'arbre de l'�nonc� = " + arbre.hauteur());
       
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("Hauteur d'un arbre vide = " + arbreVide.hauteur());
    }
    

    /**
     * Test de la m�thode qui d�termine si une valeur est pr�sente et plac�e sur
     * une feuille
     */
    public static void testEstSurUneFeuille() {
        System.out.println("\nTest estSurUneFeuille :\n"
                           + "------------------------\n");
        
        // valeurs qui ne sont pas sur une feuille 
        final int[] PAS_SUR_FEUILLE = {47, 25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66};
        
        // valeurs qui sont sur une feuille 
        final int[] SUR_FEUILLE = { 7, 17, 31, 44, 68, 93 };
        
        int nbTestOk;
        
        // cr�ation arbre de l'�nonc�
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        // tests de valeurs non pr�sentes sur une feuille
        nbTestOk = 0;
        for (int valeur : PAS_SUR_FEUILLE) {
            if (arbre.estSurUneFeuille(valeur)) {
                System.out.println("Echec => " + valeur
                                   + " a �t� trouv�e sur une feuille"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour valeurs pas sur une feuille = " + nbTestOk 
                + " tests ok sur un total de "
                + PAS_SUR_FEUILLE.length +  " tests.");    
        
        // tests de valeurs pr�sentes sur une feuille
        nbTestOk = 0;
        for (int valeur : SUR_FEUILLE) {
            if (! arbre.estSurUneFeuille(valeur)) {
                System.out.println("Echec =>  " + valeur
                                   + " n'a pas �t� trouv�e sur une feuille"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour valeurs sur une feuille = " + nbTestOk 
                + " tests ok sur un total de "
                + SUR_FEUILLE.length +  " tests.");   
        
        // TODO : compl�ter avec test sur un arbre vide
    }
    
    
    
    /**
     * Test de la m�thode plusGrandElement : sur un arbre vide 
     * et sur l'arbre de l'�nonc�
     */
    public static void testPlusGrandElement() {
        System.out.println("\nTest recherche plus grand �l�ment :\n"
                      + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Plus grand �l�ment de l'arbre de l'�nonc� = " 
                           + arbre.plusGrandElement());
       
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("Plus grand �l�ment  d'un arbre vide = " 
                            + arbreVide.plusGrandElement());
    }
    
    
    /**
     * Test de la m�thode qui supprime une valeur si elle est sur une feuille
     */
    public static void testSupprimerSiFeuille() {
        System.out.println("\nTest supprimerSiFeuille :\n"
                           + "-----------------------------\n");
        
        // valeurs qui ne sont pas sur une feuille (ne peuvent être supprim�es)
        final int[] PAS_SUR_FEUILLE = {47, 25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66};
        
        // valeurs qui sont sur une feuille (peuvent être supprim�es)
        final int[] SUR_FEUILLE = { 7, 17, 31, 44, 68, 93 };
        
        int nbTestOk;
        
        // cr�ation arbre de l'�nonc�
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        // tests de suppressions impossibles
        nbTestOk = 0;
        for (int valeur : PAS_SUR_FEUILLE) {
            if (arbre.supprimeSiFeuille(valeur)) {
                System.out.println("Echec => suppression de " + valeur
                                   + " alors que pas situ� sur une feuille"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour suppressions impossibles = " + nbTestOk 
                + " tests ok sur un total de "
                + PAS_SUR_FEUILLE.length +  " tests.");    
        
        // tests de suppressions possibles
        nbTestOk = 0;
        for (int valeur : SUR_FEUILLE) {
            if (! arbre.supprimeSiFeuille(valeur)) {
                System.out.println("Echec => suppression impossible de " + valeur
                                   + " alors que situ� sur une feuille"); 
            } else {
                // arbre.afficherArbre();
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour suppressions possibles = " + nbTestOk 
                + " tests ok sur un total de "
                + SUR_FEUILLE.length +  " tests.");   
        
        // TODO : compl�ter avec test sur un arbre vide
        arbre = new ArbreBinaire<Integer>();
        nbTestOk = 0;
        for (int valeur : SUR_FEUILLE) {
            if (arbre.supprimeSiFeuille(valeur)) {
                System.out.println("Echec => suppression possible de " + valeur
                                   + " alors que l'arbre est vide"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour suppressions dans un "
                + "arbre vide = " + nbTestOk + " tests ok sur un total de "
                + SUR_FEUILLE.length +  " tests."); 
    }
    
    /** 
     * Test de la m�thode qui supprime un �l�ment de l'arbre
     */
    public static void testSupprimerQuelconque() {
        System.out.println("\nTest supprimerQuelconque :\n"
                         + "-----------------------------\n");

        // valeurs qui ne sont pas sur une feuille (ne peuvent être supprim�es)
        final int[] VALEUR_NON_RACINE = {25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66,7, 17, 31, 44, 68, 93};

        int nbTestOk;

        // cr�ation arbre de l'�nonc�
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);

        // tests de suppressions impossibles
        nbTestOk = 0;
        for (int valeur : VALEUR_NON_RACINE) {
            if (arbre.estPresente(valeur) && !arbre.supprimerQuelconque(valeur)) {
                System.out.println("Echec => suppression possible de " + valeur); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour suppressions possibles = " + nbTestOk 
                + " tests ok sur un total de "
                + VALEUR_NON_RACINE.length +  " tests.");    

        }
    
 
    
    /**
     * Programme principal : lance les tests
     * @param args argument non utilis�
     */
    public static void main(String[] args) {
        test3Parcours();
        testHauteur();
        testEstSurUneFeuille();
        testPlusGrandElement();
        testSupprimerSiFeuille();
        testSupprimerQuelconque();
    }
    
    
    

}
