/*
 * Test des m�thodes de la  classe arbre binaire
 * TestArbre.java
 */
package test.genericite;

import genericite.ArbreBinaire;

/**
 * Test des m�thodes des classes g�rant les arbres binaires
 * @author INFO2
 */
public class TestArbre {    
    
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
     * Test d'un arbre contenant des cha�nes de caract�res
     * Des cha�nes sont ajout�es et on v�rifie ensuite si certaines d'entre elles
     * sont bien pr�sentes, et si d'autres absentes sont bien d�tect�es comme �tant
     * absentes
     */
    public static void testArbreChaine() {
        System.out.println("\nTest de la gestion d'un arbre de cha�nes de caract�res :\n"
                           + "-----------------------------------------------------------\n");
        ArbreBinaire<String> arbre = new ArbreBinaire<>();
        
        // insertion des mois de janvier à août
        arbre.inserer("janvier");
        arbre.inserer("fevrier");
        arbre.inserer("mars");
        arbre.inserer("avril");
        arbre.inserer("mai");
        arbre.inserer("juin");
        arbre.inserer("juillet");
        arbre.inserer("aout");
        System.out.println("Les valeurs suivantes sont ins�r�es :"
                + " janvier -> aout ");
        //arbre.afficheArbre();

        if (arbre.inserer("mars")) {
            System.out.println("Echec => insertion de mars alors que d�j� pr�sent ! ");
        }

        if (arbre.estPresente("mars")) {
            System.out.println("Test ok => La valeur mars est pr�sente.");
        }

        if (!arbre.estPresente("decembre")) {
            System.out.println("Test ok => La valeur decembre n'est pas pr�sente.");
        }        
    }
    
    
    /**
     * M�thode qui cr�e un arbre et ins�re toutes les valeus du
     * tableau argument. La premi�re valeur sera celle du noeud racine
     * @param valeursAInserer  entiers à ins�rer dans l'arbre
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
     * Cette m�thode teste la cr�ation d'un arbre vide
     * Elle ne teste pas toutes les op�rations à effectuer lors de la cr�ation
     */
    public static void testConstructeurSeul() {
        System.out.println("\nTest de la cr�ation d'un arbre vide (test partiel):\n"
                           + "-------------------------------------------\n");
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        System.out.println("Test OK");
    }
    
    
    /**
     * Cette m�thode teste la m�thode estPresente dans le cas où l'arbre est vide
     * 
     */
    public static void testEstPresenteDansArbreVide() {
        System.out.println("\nTest de la m�thode estPresente (test partiel, arbre vide):\n"
                           + "------------------------------------------------------------\n");
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        if (! arbre.estPresente(47)) {
            System.out.println("Test OK = > la valeur 47 est absente");
        } else {
            System.out.println("Test NOK => la valeur 47 n'a pas �t� trouv�e, alors qu'elle est pr�sente.");
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
        ArbreBinaire<Integer> arbre = new ArbreBinaire<>();
        
        nbTestOk = 0;
        // insertions de valeurs absentes
        for (int valeur : A_INSERER) {
            if (! arbre.inserer(valeur)) {
                System.out.println("Test NOK : �chec de l'insertion de " + valeur);
            } else {
                nbTestOk++;
            }
        }
        
        // insertion de valeurs pr�sentes : l'ajout ne doit pas se faire
        for (int valeur : A_INSERER) {
            if (arbre.inserer(valeur)) {
                System.out.println("Test NOK : insertion de " + valeur + " alors que d�j� pr�sente");
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
     */
    public static void testInsererEstPresente() {
        System.out.println("\nTest methode estPresente :\n"
                           + "------------------------------\n");
        int nbTestOk;
        
        // cr�ation d'une hi�rarchie conforme à l'exemple du TP
        ArbreBinaire<Integer> arbre = creerArbre(ARBRE_ENONCE);        
        nbTestOk = 0;
        
        // on v�rifie que toutes les valeurs de ARBRE_ENONCE sont pr�sentes
        for (int valeur : ARBRE_ENONCE) {
            if (! arbre.estPresente(valeur)) {
                System.out.println("Test NOK : " +  valeur + "n'a pas �t� trouv�e.");
            } else {
                nbTestOk++;
            }
        }
        
        // on v�rifie que toutes les valeurs de ARBRE_ENONCE + 1 sont absentes
        for (int valeur : ARBRE_ENONCE) {
            // TODO : am�liorer 43 �crit en dur
            if (valeur != 43 && arbre.estPresente(valeur + 1)) {
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
       testConstructeurSeul();
       testEstPresenteDansArbreVide();
       testInserer();
       testInsererEstPresente();
       testArbreChaine();
    }
    

}
