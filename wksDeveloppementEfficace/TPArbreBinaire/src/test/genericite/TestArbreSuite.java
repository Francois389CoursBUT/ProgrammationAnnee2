/*
 * Test des méthodes de la  classe arbre binaire (questions 4 à 7)
 * TestArbreSuite.java
 */
package test.genericite;

import genericite.ArbreBinaire;

/**
 * Test des méthodes des classes gérant les arbres binaires (questions 4 à 7)
 * @author INFO2
 */
public class TestArbreSuite {
    
    /**
     * Valeurs à  inséser pour les tests
     */
    private static final int[] A_INSERER = {25, 77, 11, 5, 20};

    /**
     * Valeurs présentes dans l'arbre de l'énoncé
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68, 
                                               25, 11, 43, 7, 17, 31, 44};
    
    /**
     * 
     * Méthode qui crée un arbre et insère toutes les valeus du
     * tableau argument. La première valeur sera celle du noeud racine
     * @param valeursAInserer  entiers à  insérer dans l'arbre
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
     * Test des 3 méthodes de parcours
     */
    public static void test3Parcours() {
        System.out.println("\nTest des 3 méthodes de parcours :\n"
                           + "-------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Avec l'arbre de l'énoncé :");
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
     * Test de la méthode hauteur : sur un arbre vide et sur l'arbre de l'énoncé
     */
    public static void testHauteur() {
        System.out.println("\nTest de la hauteur de l'arbre :\n"
                + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Hauteur de l'arbre de l'énoncé = " + arbre.hauteur());
       
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("Hauteur d'un arbre vide = " + arbreVide.hauteur());
    }
    

    /**
     * Test de la méthode qui détermine si une valeur est présente et placée sur
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
        
        // création arbre de l'énoncé
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        // tests de valeurs non présentes sur une feuille
        nbTestOk = 0;
        for (int valeur : PAS_SUR_FEUILLE) {
            if (arbre.estSurUneFeuille(valeur)) {
                System.out.println("Echec => " + valeur
                                   + " a été trouvée sur une feuille"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour valeurs pas sur une feuille = " + nbTestOk 
                + " tests ok sur un total de "
                + PAS_SUR_FEUILLE.length +  " tests.");    
        
        // tests de valeurs présentes sur une feuille
        nbTestOk = 0;
        for (int valeur : SUR_FEUILLE) {
            if (! arbre.estSurUneFeuille(valeur)) {
                System.out.println("Echec =>  " + valeur
                                   + " n'a pas été trouvée sur une feuille"); 
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour valeurs sur une feuille = " + nbTestOk 
                + " tests ok sur un total de "
                + SUR_FEUILLE.length +  " tests.");   
        
        // TODO : compléter avec test sur un arbre vide
    }
    
    
    
    /**
     * Test de la méthode plusGrandElement : sur un arbre vide 
     * et sur l'arbre de l'énoncé
     */
    public static void testPlusGrandElement() {
        System.out.println("\nTest recherche plus grand élément :\n"
                      + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Plus grand élément de l'arbre de l'énoncé = " 
                           + arbre.plusGrandElement());
       
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("Plus grand élément  d'un arbre vide = " 
                            + arbreVide.plusGrandElement());
    }
    
    
    /**
     * Test de la méthode qui supprime une valeur si elle est sur une feuille
     */
    public static void testSupprimerSiFeuille() {
        System.out.println("\nTest supprimerSiFeuille :\n"
                           + "-----------------------------\n");
        
        // valeurs qui ne sont pas sur une feuille (ne peuvent Ãªtre supprimées)
        final int[] PAS_SUR_FEUILLE = {47, 25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66};
        
        // valeurs qui sont sur une feuille (peuvent Ãªtre supprimées)
        final int[] SUR_FEUILLE = { 7, 17, 31, 44, 68, 93 };
        
        int nbTestOk;
        
        // création arbre de l'énoncé
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        // tests de suppressions impossibles
        nbTestOk = 0;
        for (int valeur : PAS_SUR_FEUILLE) {
            if (arbre.supprimeSiFeuille(valeur)) {
                System.out.println("Echec => suppression de " + valeur
                                   + " alors que pas situé sur une feuille"); 
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
                                   + " alors que situé sur une feuille"); 
            } else {
                // arbre.afficherArbre();
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT pour suppressions possibles = " + nbTestOk 
                + " tests ok sur un total de "
                + SUR_FEUILLE.length +  " tests.");   
        
        // TODO : compléter avec test sur un arbre vide
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
     * Test de la méthode qui supprime un élément de l'arbre
     */
    public static void testSupprimerQuelconque() {
        System.out.println("\nTest supprimerQuelconque :\n"
                         + "-----------------------------\n");

        // valeurs qui ne sont pas sur une feuille (ne peuvent Ãªtre supprimées)
        final int[] VALEUR_NON_RACINE = {25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66,7, 17, 31, 44, 68, 93};

        int nbTestOk;

        // création arbre de l'énoncé
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
     * @param args argument non utilisé
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
