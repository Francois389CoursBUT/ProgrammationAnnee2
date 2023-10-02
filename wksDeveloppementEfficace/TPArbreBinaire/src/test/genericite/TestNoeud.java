/*
 *  Test de la classe Noeud
 *  fichier TestNoeud.java
 */
package test.genericite;

import genericite.Noeud;


/**
 * Test de quelques m�thodes de la classe Noeud 
 * @author INFO2
 */
public class TestNoeud {
    
    
    /**
     * Valeurs à ins�ser pour les tests
     */
    private static final int[] A_INSERER = {25, 77, 11, 5, 20};

    /**
     * Valeurs pr�sentes dans l'arbre de l'�nonc�
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68, 
                                               25, 11, 43, 7, 17, 31, 44};
    
    
    
    /**
     * M�thode qui cr�e un noeud racine et insère toutes les valeus du
     * tableau argument. La première valeur sera celle du noeud racine
     * @param valeursAInserer  entiers à ins�rer à partir du noeud racine
     * @return un noeud racine contenant des descendants
     */
    public static Noeud<Integer>  creerDescendant(int[] valeursAInserer) {
        Noeud<Integer> noeud = new Noeud<>(valeursAInserer[0]);
        
        for (int i = 1; i < valeursAInserer.length; i++) {
            noeud.inserer(valeursAInserer[i]);
        }
        return noeud;
    }
        
    
    
    
    /**
     * Cette m�thode teste la cr�ation d'un noeud
     * Elle ne teste pas toutes les op�rations à effectuer lors de la cr�ation
     */
    public static void testConstructeurSeul() {
        System.out.println("\nTest de la cr�ation d'un noeud (test partiel):\n"
                           + "-------------------------------------------\n");
        Noeud<Integer> noeud = new Noeud<>(47);
        System.out.println("Test OK");
    }
    
    
    /**
     * Cette m�thode teste la m�thode estPresente dans le cas où le noeud n'a pas
     * de descendant
     * Elle ne teste pas toutes les op�rations à effectuer lors de la cr�ation
     */
    public static void testEstPresenteSansDescendance() {
        System.out.println("\nTest de la m�thode estPresente (test partiel, noeud sans descendant):\n"
                           + "---------------------------------------------------------------------\n");
        Noeud<Integer> noeud = new Noeud<>(47);
        if (noeud.estPresente(47)) {
            System.out.println("Test OK = > la valeur 47 a bien �t� trouv�e.");
        } else {
            System.out.println("Test NOK => la valeur 47 n'a pas �t� trouv�e, alors qu'elle est pr�sente.");
        }
        
        for (int valeur : A_INSERER) {
            if (! noeud.estPresente(valeur)) {
                System.out.println("Test OK : " +  valeur + " n' est pas pr�sente");
            } else {
                System.out.println("Test NOK : " +  valeur + " a �t� trouv�e, alors qu'elle est absente");
            }
        }
       
    }
    
    /**
     * Cette m�thode teste l'insertion de valeurs
     * Elle ne teste pas toutes les actions a effectuer lors de l'insertion
     */
    public static void testInserer() {
        System.out.println("\nTest de l'insertion de valeurs (test partiel) :\n"
                           + "-------------------------------------------\n");
        int nbTestOk;
        Noeud<Integer> noeud = new Noeud<>(47);
        
        nbTestOk = 0;
        // insertions de valeurs absentes
        for (int valeur : A_INSERER) {
            if (! noeud.inserer(valeur)) {
                System.out.println("Test NOK : �chec de l'insertion de " + valeur);
            } else {
                nbTestOk++;
            }
        }
        
        // insertion de valeurs pr�sentes : l'ajout ne doit pas se faire
        for (int valeur : A_INSERER) {
            if (noeud.inserer(valeur)) {
                System.out.println("Test NOK : insertion de " + valeur + " alors que d�jà pr�sente");
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                + " tests ok sur un total de "
                + A_INSERER.length * 2 +  " tests.\n");     
    }
    
    
    /**
     * Cette m�thode teste l'insertion de valeurs et la m�thode estPresente
     * Elle ne teste pas toutes les actions a effectuer lors de l'insertion
     */
    public static void testInsererEstPresente() {
        System.out.println("\nTest methode estPresente :\n"
                           + "------------------------------\n");
        int nbTestOk;
        
        // cr�ation d'une hi�rarchie conforme à l'exemple du TP
        Noeud<Integer> noeud = creerDescendant(ARBRE_ENONCE);
        
        nbTestOk = 0;
        
        // on v�rifie que toutes les valeurs de ARBRE_ENONCE sont pr�sentes
        for (int valeur : ARBRE_ENONCE) {
            if (! noeud.estPresente(valeur)) {
                System.out.println("Test NOK : " +  valeur + "n'a pas �t� trouv�e.");
            } else {
                nbTestOk++;
            }
        }
        
        // on v�rifie que toutes les valeurs de ARBRE_ENONCE + 1 sont absentes
        for (int valeur : ARBRE_ENONCE) {
            // TODO : am�liorer 43 �crit en dur
            if (valeur != 43 && noeud.estPresente(valeur + 1)) {
                System.out.println("Test NOK : " +  valeur + "a �t� trouv�e.");
            } else {
                nbTestOk++;
            }
        }
       
        
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                + " tests ok sur un total de "
                + ARBRE_ENONCE.length * 2 +  " tests.\n");     
    }
    
   
    
    /**
     * Programme principal : lance les tests
     * @param args argument non utilis�
     */
    public static void main(String[] args) {
       // testConstructeurSeul();
//        testEstPresenteSansDescendance();
//        testInserer();
        testInsererEstPresente();
    }
    
}
