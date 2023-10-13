/*
 * Test des méthodes de la  classe arbre binaire
 * TestArbre.java
 */
package test.genericite;

import genericite.ArbreBinaire;

/**
 * Test des méthodes des classes gérant les arbres binaires
 * @author INFO2
 */
public class TestArbre {    
    
    /**
     * Valeurs Ã  inséser pour les tests
     */
    private static final int[] A_INSERER = {25, 77, 11, 5, 20};

    /**
     * Valeurs présentes dans l'arbre de l'énoncé
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68, 
                                               25, 11, 43, 7, 17, 31, 44};
    
 
    /**
     * Test d'un arbre contenant des chaânes de caractères
     * Des chaânes sont ajoutées et on vérifie ensuite si certaines d'entre elles
     * sont bien présentes, et si d'autres absentes sont bien détectées comme étant
     * absentes
     */
    public static void testArbreChaine() {
        System.out.println("\nTest de la gestion d'un arbre de chaânes de caractères :\n"
                           + "-----------------------------------------------------------\n");
        ArbreBinaire<String> arbre = new ArbreBinaire<>();
        
        // insertion des mois de janvier Ã  aoÃ»t
        arbre.inserer("janvier");
        arbre.inserer("fevrier");
        arbre.inserer("mars");
        arbre.inserer("avril");
        arbre.inserer("mai");
        arbre.inserer("juin");
        arbre.inserer("juillet");
        arbre.inserer("aout");
        System.out.println("Les valeurs suivantes sont insérées :"
                + " janvier -> aout ");
        //arbre.afficheArbre();

        if (arbre.inserer("mars")) {
            System.out.println("Echec => insertion de mars alors que déjà  présent ! ");
        }

        if (arbre.estPresente("mars")) {
            System.out.println("Test ok => La valeur mars est présente.");
        }

        if (!arbre.estPresente("decembre")) {
            System.out.println("Test ok => La valeur decembre n'est pas présente.");
        }        
    }
    
    
    /**
     * Méthode qui crée un arbre et insère toutes les valeus du
     * tableau argument. La première valeur sera celle du noeud racine
     * @param valeursAInserer  entiers Ã  insérer dans l'arbre
     * @return un arbre contenant les valeurs du tableau argument
     */
    public static ArbreBinaire<Integer>  creerArbre(int[] valeursAInserer) {
        ArbreBinaire<Integer> noeud = new ArbreBinaire<>();
        
        for (int valeur : valeursAInserer) {
            noeud.inserer(valeur);
        }
        return noeud;
    }
        
    
    
    
    /**
     * Cette méthode teste la création d'un arbre vide
     * Elle ne teste pas toutes les opérations Ã  effectuer lors de la création
     */
    public static void testConstructeurSeul() {
        System.out.println("\nTest de la création d'un arbre vide (test partiel):\n"
                           + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        System.out.println("Test OK");
    }
    
    
    /**
     * Cette méthode teste la méthode estPresente dans le cas oÃ¹ l'arbre est vide
     * 
     */
    public static void testEstPresenteDansArbreVide() {
        System.out.println("\nTest de la méthode estPresente (test partiel, arbre vide):\n"
                           + "------------------------------------------------------------\n");
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        if (! arbre.estPresente(47)) {
            System.out.println("Test OK = > la valeur 47 est absente");
        } else {
            System.out.println("Test NOK => la valeur 47 n'a pas été trouvée, alors qu'elle est présente.");
        }       
    }
    
    /**
     * Cette méthode teste l'insertion de valeurs
     * Elle ne teste pas toutes les actions a effectuer lors de l'insertion
     */
    public static void testInserer() {
        System.out.println("\nTest de l'insertion de valeurs (test partiel) :\n"
                           + "-------------------------------------------\n");
        int nbTestOk;
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        
        nbTestOk = 0;
        // insertions de valeurs absentes
        for (int valeur : A_INSERER) {
            if (! arbre.inserer(valeur)) {
                System.out.println("Test NOK : échec de l'insertion de " + valeur);
            } else {
                nbTestOk++;
            }
        }
        
        // insertion de valeurs présentes : l'ajout ne doit pas se faire
        for (int valeur : A_INSERER) {
            if (arbre.inserer(valeur)) {
                System.out.println("Test NOK : insertion de " + valeur + " alors que déjà  présente");
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                + " tests ok sur un total de "
                + A_INSERER.length * 2 +  " tests.\n");     
    }
    
    
    /**
     * Cette méthode teste l'insertion de valeurs et la méthode estPresente
     */
    public static void testInsererEstPresente() {
        System.out.println("\nTest methode estPresente :\n"
                           + "------------------------------\n");
        int nbTestOk;
        
        // création d'une hiérarchie conforme Ã  l'exemple du TP
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);        
        nbTestOk = 0;
        arbre.afficheAbreNiveau();
        
        // on vérifie que toutes les valeurs de ARBRE_ENONCE sont présentes
        for (int valeur : ARBRE_ENONCE) {
            if (! arbre.estPresente(valeur)) {
                System.out.println("Test NOK : " +  valeur + "n'a pas été trouvée.");
            } else {
                nbTestOk++;
            }
        }
        
        // on vérifie que toutes les valeurs de ARBRE_ENONCE + 1 sont absentes
        for (int valeur : ARBRE_ENONCE) {
            // TODO : améliorer 43 écrit en dur
            if (valeur != 43 && arbre.estPresente(valeur + 1)) {
                System.out.println("Test NOK : " +  valeur + "a été trouvée.");
            } else {
                nbTestOk++;
            }
        }       
        
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                + " tests ok sur un total de "
                + ARBRE_ENONCE.length * 2 +  " tests.\n");     
    }
    
    /**
     * Test des 3 méthodes de parcours
     */
    public static void test3Parcours() {
        System.out.println("\nTest des 3 méthodes de parcours :\n"
                           + "-------------------------------------\n");
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
        
        System.out.println("Avec l'arbre de l'énoncé :");
        System.out.println("  Resultat du parcours prefixe :  " + arbre.parcoursPrefixe());
        System.out.println("  Resultat du parcours infixe :   " + arbre.parcoursInfixe());
        System.out.println("  Resultat du parcours postfixe : " + arbre.parcoursPostfixe());
        
        ArbreBinaire<Integer> arbreVide = new ArbreBinaire<>();
        System.out.println("\nAvec l'arbre vide :");
        System.out.println("  Resultat du parcours prefixe :  " + arbreVide.parcoursPrefixe());
        System.out.println("  Resultat du parcours infixe :   " + arbreVide.parcoursInfixe());
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
        
        // valeurs qui ne sont pas sur une feuille (ne peuvent être supprimées)
        final int[] PAS_SUR_FEUILLE = {47, 25, 77, 65, 11, 3, 13, 26, 70, 79,
                43, 9, 22, 62, 66};
        
        // valeurs qui sont sur une feuille (peuvent être supprimées)
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
    }
  
    
   
    
    /**
     * Programme principal : lance les tests
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
//       testConstructeurSeul();
//       testEstPresenteDansArbreVide();
//       testInserer();
//       testInsererEstPresente();
//       testArbreChaine();
//       
//       test3Parcours();
//       testHauteur();
//       testEstSurUneFeuille();
       testPlusGrandElement();
//       testSupprimerSiFeuille();
       
       ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);
//       arbre.afficheAbreNiveau();

    }
    

}
