/*
 * Test de la classe Pays
 * TestPays.java                        09/22
 */
package test.structuredonnees.ensemble;

import java.util.ArrayList;

import structuredonnees.ensemble.Pays;



/**
 * Tests unitaires des principales m�thodes de la classe Pays
 * @author C. Servi�res
 * @version 1.0
 */
public class TestPays {

    /** Noms de pays invalides */
    private static final String[] NOM_PAYS_INVALIDE = { null, "", " ", "      "};

    /** Exemples de noms de pays valides */
    private static final String[] NOM_PAYS_VALIDE = { "France", "Espagne", "Italie", "Australie"};



    /** tableau contenant les noms des pays utilis�s pour les tests les plus complets */
    private static final String[] NOM_DES_PAYS = { "France", "Royaume-Uni", "Irlande", "Espagne",
                            "Allemagne", "Hongrie", "Pologne",
                            "Argentine", "Chili", "Perou", "Canada"};

    /**
     * tableau contenant les noms des pays voisins de ceux contenus dans
     * le tableau pr�c�dent NOM_DES_PAYS
     */
    private static final String [][] VOISINS = {
            { "Espagne", "Italie", "Suisse", "Allemagne", "Luxembourg", "Belgique" },
            { "Irlande" },
            { "Royaume-Uni" },
            { "Portugal", "France" },
            { "Danemark", "Pologne", "Republique Tcheque", "Autriche",
              "Suisse", "France", "Luxembourg", "Belgique", "Pays-Bas" },
            { "Slovaquie", "Ukraine", "Roumanie", "Serbie", "Croatie", "Slovenie",
              "Autriche" },
            { "Russie", "Lituanie", "Bielorussie", "Ukraine",
              "Slovaquie", "Republique Tcheque", "Allemagne" },
            { "Uruguay", "Bresil", "Paraguay", "Bolivie", "Chili"},
            { "Argentine", "Bolivie", "Perou"},
            { "Chili", "Bolivie", "Bresil", "Colombie", "Equateur"},
            { "Etats-Unis" } };


    /* ===================================================================== */
    /*                     m�thode outil pour g�rer les tests                */
    /* ===================================================================== */


    /**
     * Affiche le r�sultat d'un test : le nombre de tests r�ussis et le
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectu�s
     * @param nbTestOk          nombre de tests r�ussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println("\n" + nbTestOk + " test(s) ont r�ussi sur un total de "
                + nbTestTotal + " tests r�alis�s.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK"
                        : (nbTestTotal - nbTestOk) + " test(s) ont �chou�.") + "\n");
    }



    /* ===================================================================== */
    /*                            Tests des constructeurs                    */
    /* ===================================================================== */


    /**
     * Permet de tester que le constructeur avec un seul argument lève (ou pas)
     * l'exception IllegalArgumentException � bon escient
     */
    public static void testConstructeur1ArgumentException() {
        System.out.println("Test du constructeur ayant 1 argument\n"
                           + "-------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays

        // v�rification qu'aucune exception n'est lev�e si le nom du pays est valide
        nbTestOk = 0;
        for (String element : NOM_PAYS_VALIDE) {
            try {
                aTester = new Pays(element);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {
                System.out.println("Echec du test pour le pays " + element);
            }
        }

        // v�rification qu'une exception est lev�e si le nom du pays est invalide
        for (String element : NOM_PAYS_INVALIDE) {
            try {
                aTester = new Pays(element);
                System.out.println("Echec du test pour le pays " + element);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // r�sultat du test
        afficherResultatTest(NOM_PAYS_VALIDE.length + NOM_PAYS_INVALIDE.length, nbTestOk);
    }


    /**
     * Permet de tester que le constructeur avec 2 arguments lève (ou pas)
     * l'exception IllegalArgumentException � bon escient
     */
    public static void testConstructeur2ArgumentsException() {
        System.out.println("Test du constructeur ayant 2 arguments\n"
                           + "------------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays

        // v�rification qu'aucune exception n'est lev�e si les noms de pays sont valides
        nbTestOk = 0;
        for (String element : NOM_PAYS_VALIDE) {
            try {
                aTester = new Pays(element, NOM_PAYS_VALIDE);
                                   //i % 2 == 0 ? NOM_PAYS_VALIDE : new String[0]);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {
                System.out.println("Echec du test pour le pays " + element);
            }
        }

        // v�rification qu'une exception est lev�e si un nom de pays est invalide
        // 1)  nom du pays principal invalide, et noms des pays voisins valides
        for (String element : NOM_PAYS_INVALIDE) {
            try {
                aTester = new Pays(element, NOM_PAYS_VALIDE);
                System.out.println("Echec du test pour le pays invalide" + element);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // 2)  nom du pays principal valide, et noms des pays voisins invalides
        String[] paysVoisinAvecInvalide = new String[NOM_PAYS_INVALIDE.length];
        for (int i = 0; i < NOM_PAYS_INVALIDE.length ; i++) {
            paysVoisinAvecInvalide[i] = NOM_PAYS_INVALIDE[i];
        }
        for (int i = 0; i < NOM_PAYS_INVALIDE.length; i++) {
            try {
                paysVoisinAvecInvalide[2] = NOM_PAYS_INVALIDE[i];
                aTester = new Pays(NOM_PAYS_VALIDE[i], paysVoisinAvecInvalide);
                System.out.println("Echec du test pour le pays " + NOM_PAYS_INVALIDE[i]
                                   + " et son voisin invalide " + NOM_PAYS_INVALIDE[i]);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // r�sultat du test
        afficherResultatTest(NOM_PAYS_VALIDE.length * 2 + NOM_PAYS_INVALIDE.length, nbTestOk);
    }


    /**
     * Permet de tester que le constructeur avec un seul argument et la m�thode toString
     * sont corects
     */
    public static void testConstructeur1ArgumentToString() {
        System.out.println("Test du constructeur ayant 1 argument et toString\n"
                           + "-------------------------------------------------\n");
        Pays aTester;      // test effectu� pour ce pays

        System.out.println("*** Test Visuel ***  V�rifiez l'affichage correct **** \n");
        // v�rification qu'aucune exception n'est lev�e si le nom du pays est valide

        for (String element : NOM_PAYS_VALIDE) {
             aTester = new Pays(element);
             System.out.println("Cr�ation du pays " + element + " :\n     ==> "
                                + aTester);
        }
    }


    /**
     * Permet de tester que le constructeur avec 2 arguments et la m�thode toString
     * sont corects
     */
    public static void testConstructeur2ArgumentsToString() {
        System.out.println("Test du constructeur ayant 2 arguments et toString\n"
                           + "-------------------------------------------------\n");
        Pays aTester;      // test effectu� pour ce pays

        System.out.println("*** Test Visuel ***  V�rifiez l'affichage correct **** \n");
        // v�rification qu'aucune exception n'est lev�e si le nom du pays est valide

        for (int i = 0; i < NOM_DES_PAYS.length / 2; i++) {
             aTester = new Pays(NOM_DES_PAYS[i], VOISINS[i] );
             System.out.println("Cr�ation du pays " + NOM_DES_PAYS[i] + " :\n     ==> "
                                + aTester);
        }
    }



    /* ===================================================================== */
    /*              Tests des m�thodes portant sur les pays voisins          */
    /* ===================================================================== */



    /**
     * Permet de tester la m�thode ajouterVoisin
     */
    public static void testAjouterVoisin() {
        System.out.println("Test de la m�thode ajouterVoisin \n"
                           + "---------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays

        // v�rification qu'une exception est l�v�e, si le voisin est incorrect
        System.out.println("======> Ajout de voisins incorrects ....");
        nbTestOk = 0;
        aTester = new Pays("France");
        for (String element : NOM_PAYS_INVALIDE) {
            try {
                aTester.ajouterVoisin(element);
                System.out.println("Echec du test pour le pays voisin "
                                   + element);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;
            }
        }

        // v�rification qu'aucune exception est lev�e si pays voisin correct est ajout�
        //  + v�rification visuelle de l'ajout
        System.out.println("\n======> Ajout de voisins corrects et pas encore pr�sents ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            try {
                aTester.ajouterVoisin(VOISINS[0][i]);
                System.out.println("Après ajout du voisin " + VOISINS[0][i]
                                   + " :\n     => " + aTester);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {

            }
        }

        // v�rification qu'aucune exception est lev�e si pays voisin d�jà pr�sent est ajout�
        //  + v�rification visuelle qu'il n'est pas ajout� une 2ème fois
        System.out.println("\n======> Ajout de voisins corrects et d�jà pr�sents ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            try {
                aTester.ajouterVoisin(VOISINS[0][i]);
                System.out.println("Après ajout du voisin " + VOISINS[0][i]
                                   + " :\n     => " + aTester);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {

            }
        }

        // r�sultat du test
        afficherResultatTest(NOM_PAYS_INVALIDE.length + VOISINS[0].length * 2, nbTestOk);
    }


    /**
     * Permet de tester la m�thode aPourVoisin
     */
    public static void testAPourVoisin() {
        System.out.println("Test de la m�thode aPourVoisin \n"
                           + "-----------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays


        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront � partir du pays " + aTester + "\n");

        // v�rification que les voisins sont bien d�tect�s en tant que voisins
        System.out.println("======> V�rification des voisins ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.aPourVoisin(VOISINS[0][i])) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test pour le pays voisin "
                        + VOISINS[0][i]);
            }
        }

        // v�rification que les non voisins sont bien d�tect�s en tant que non voisins
        System.out.println("======> V�rification des pays non voisins ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            if (! aTester.aPourVoisin(VOISINS[5][i])) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test pour le pays non voisin "
                        + VOISINS[5][i]);
            }
        }

        // r�sultat du test
        afficherResultatTest(VOISINS[0].length + VOISINS[5].length, nbTestOk);
    }

    /**
     * Permet de tester la m�thode nombreVoisin
     */
    public static void testNombreVoisin() {
        System.out.println("Test de la m�thode nombreVoisin (test visuel) \n"
                           + "----------------------------------------------\n");
        Pays aTester;      // test effectu� pour ce pays

        // v�rification visuelle du nombre de voisins
        System.out.println("\n======> Ajout de voisins et comptage ....");
        aTester = new Pays("France");
        System.out.println("Pour l'instant, le pays " + aTester + " ===> "
                           + aTester.nombreVoisin() + " voisins\n");
        for (int i = 0; i < VOISINS[0].length; i++) {
                aTester.ajouterVoisin(VOISINS[0][i]);
                System.out.println("Pour l'instant, le pays " + aTester + " ===> "
                        + aTester.nombreVoisin() + " voisins\n");
        }
    }



    /* ===================================================================== */
    /*          Tests des m�thodes portant un groupe de pays voisins         */
    /* ===================================================================== */


    /**
     * Permet de tester la m�thode aPourVoisin avec en argument une liste de pays
     */
    public static void testAPourVoisinListePays() {
        System.out.println("Test de la m�thode aPourVoisin (argument ArrayList) \n"
                           + "-----------------------------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays
        ArrayList<String> listeATester = new ArrayList<>();

        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront � partir du pays " + aTester + "\n");

        // v�rification que l'argument ne coincide pas avec les voisins
        // (car 1 au moins pays manque)
        System.out.println("======> V�rification des voisins (il manque des voisins) ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.aPourVoisin(listeATester)) {
                System.out.println("Echec du test avec les voisins "
                        + listeATester);
            } else {
                nbTestOk++;
            }
            listeATester.add(VOISINS[0][i]);
        }

        // normalemnt : la liste coincide avec les voisins
        System.out.println("======> V�rification des voisins (ils coincident) ....");
        if (aTester.aPourVoisin(listeATester)) {
            nbTestOk++;
        } else {
            System.out.println("Echec du test avec les voisins "
                    + listeATester);
        }

        // v�rification que l'argument ne coincide pas avec les voisins
        // (car 1 pays au moins est un trop et �ventuellement 1 manque)
        System.out.println("======> V�rification des voisins (des voisins en trop) ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            listeATester.add(VOISINS[5][i]);
            if (aTester.aPourVoisin(listeATester)) {
                System.out.println("Echec du test avec les voisins "
                        + listeATester);
            } else {
                nbTestOk++;
            }
            if (i > VOISINS[5].length / 2) {
                // on supprime un voisin
                listeATester.remove(0);
            }
        }

        // r�sultat du test
        afficherResultatTest(VOISINS[0].length + VOISINS[5].length + 1, nbTestOk);
    }

    /**
     * Permet de tester la m�thode nombreCommun
     */
    public static void testNombreCommun() {
        System.out.println("Test de la m�thode nombreCommun  \n"
                           + "---------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectu� pour ce pays
        ArrayList<String> listeATester = new ArrayList<>();

        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront � partir du pays " + aTester + "\n");

        // v�rification quand le nombre de pays de la liste test�e est inf�rieur au
        // nombre de voisins
        System.out.println("======> V�rification du nombre de voisins qui coincident (nombre inf�rieur) ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.nombreCommun(listeATester) == i) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouv� est "
                        + aTester.nombreCommun(listeATester) + " au lieu de " + i);
            }
            listeATester.add(VOISINS[0][i]);
        }

        // normalemnt : la liste coincide avec les voisins
        System.out.println("======> V�rification du nombre de voisins qui coincident (nombre �gal) ....");
        if (aTester.nombreCommun(listeATester) == VOISINS[0].length) {
            nbTestOk++;
        } else {
            System.out.println("Echec du test avec les voisins "
                    + listeATester
                    + ". Le nombre de voisins communs trouv� est "
                    + aTester.nombreCommun(listeATester) + " au lieu de " + VOISINS[0].length);
        }

        // v�rification avec des pays en plus des voisins
        System.out.println("======> V�rification du nombre de voisins qui coincident "
                           + "(nombre �gal, et avec plus de pays dans la liste) ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            listeATester.add(VOISINS[5][i]);
            if (aTester.nombreCommun(listeATester) == VOISINS[0].length) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouv� est "
                        + aTester.nombreCommun(listeATester) + " au lieu de " + VOISINS[0].length);
            }

        }

        // v�rification avec des pays en plus des voisins et des voisins manquant
        System.out.println("======> V�rification du nombre de voisins qui coincident "
                           + "(nombre inf�rieur, et des pays non voisins dans la liste) ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            listeATester.remove(0);
            if (aTester.nombreCommun(listeATester) == VOISINS[0].length - i - 1) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouv� est "
                        + aTester.nombreCommun(listeATester) + " au lieu de "
                        + (VOISINS[0].length - i - 1));
            }
        }

        // r�sultat du test
        afficherResultatTest(VOISINS[0].length * 2 + VOISINS[5].length + 1, nbTestOk);
    }

    /**
     * Test des accesseurs
     * @author Fran�ois de Saint Palais
     */
    public static void testAccesseur() {

        int nbTestOk;
        Pays paysTester;

        System.out.println(  "Test des accesseur\n"
                           + "---------------------------------\n");

        System.out.println("======> V�rification de getNom()");
        nbTestOk = 0;
        for (String element : NOM_DES_PAYS) {
            paysTester = new Pays(element);

            if (paysTester.getNom().equals(element)) {
                nbTestOk++;
            } else {
                System.out.println("Test �chou� avec " + element);
            }
        }

        afficherResultatTest(NOM_DES_PAYS.length, nbTestOk);

        System.out.println("======> V�rification de getPaysLimitrophe()");
        nbTestOk = 0;
        boolean sontVoisins;
        for (String[] element : VOISINS) {
            paysTester = new Pays(NOM_DES_PAYS[0],element);

            sontVoisins = paysTester.getPaysLimitrophe().size() <= element.length;
            for (String possibleVoisin : element) {
                sontVoisins &= paysTester.getPaysLimitrophe().contains(possibleVoisin);
            }
            if (sontVoisins) {
                nbTestOk++;
            } else {
                System.out.println("Test �chou� avec " + element);
            }
        }

        afficherResultatTest(VOISINS.length, nbTestOk);

    }



    /* ===================================================================== */
    /*                Programme principal pour lancer les tests              */
    /* ===================================================================== */

    /**
     * Programme principal : lancement des m�thodes de tests unitaires
     * @param args  argument non utlis�
     */
    public static void main(String[] args) {
        System.out.println("TESTS DE LA  CLASSE PAYS\n------------------------------\n\n");

//         testConstructeur1ArgumentException();
//         testConstructeur2ArgumentsException();
//         testConstructeur1ArgumentToString();
//         testConstructeur2ArgumentsToString();
//         testAjouterVoisin();
//         testAPourVoisin();
//         testNombreVoisin();
//         testAPourVoisinListePays();
//         testNombreCommun();
         testAccesseur();
    }

}
