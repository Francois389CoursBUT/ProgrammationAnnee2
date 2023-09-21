/*
 * TestPaysJUnit.java                                    18 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package test.structuredonnees.ensemble;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import structuredonnees.ensemble.Pays;;

/**
 * TODO comment class responsibility (SRP)
 *
 * @author François de Saint Palais
 *
 */
class TestPaysJUnit {

    /** Noms de pays invalides */
    private static final String[] NOM_PAYS_INVALIDE = { null, "", " ", "      " };

    /** Exemples de noms de pays valides */
    private static final String[] NOM_PAYS_VALIDE = { "France", "Espagne", "Italie", "Australie" };

    /**
     * tableau contenant les noms des pays voisins de ceux contenus dans le tableau
     * précédent NOM_DES_PAYS
     */
    private static final String[][] VOISINS = {
            { "Espagne", "Italie", "Suisse", "Allemagne", "Luxembourg", "Belgique" }, { "Irlande" }, { "Royaume-Uni" },
            { "Portugal", "France" },
            { "Danemark", "Pologne", "Republique Tcheque", "Autriche", "Suisse", "France", "Luxembourg", "Belgique",
                    "Pays-Bas" },
            { "Slovaquie", "Ukraine", "Roumanie", "Serbie", "Croatie", "Slovenie", "Autriche" },
            { "Russie", "Lituanie", "Bielorussie", "Ukraine", "Slovaquie", "Republique Tcheque", "Allemagne" },
            { "Uruguay", "Bresil", "Paraguay", "Bolivie", "Chili" }, { "Argentine", "Bolivie", "Perou" },
            { "Chili", "Bolivie", "Bresil", "Colombie", "Equateur" }, { "Etats-Unis" } };

    @Test
    void test() {
        System.out.println("Test de la méthode aPourVoisin (argument ArrayList) \n"
                + "-----------------------------------------------------\n");
        int nbTestOk; // nombre de tests corrects
        Pays aTester; // test effectué pour ce pays
        ArrayList<String> listeATester = new ArrayList<>();

        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront à  partir du pays " + aTester + "\n");

// vérification que l'argument ne coincide pas avec les voisins
// (car 1 au moins pays manque)
        System.out.println("======> Vérification des voisins (il manque des voisins) ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            System.out.println("Liste à tester : " + listeATester);
            System.out.println("Pays tester : " + aTester+"\n");
            assertFalse(aTester.aPourVoisin(listeATester));
            if (aTester.aPourVoisin(listeATester)) {
                //System.out.println("Echec du test avec les voisins " + listeATester);
            } else {
                nbTestOk++;
            }
            listeATester.add(VOISINS[0][i]);
        }

// normalemnt : la liste coincide avec les voisins
        System.out.println("======> Vérification des voisins (ils coincident) ....");
        if (aTester.aPourVoisin(listeATester)) {
            nbTestOk++;
        } else {
            System.out.println("Echec du test avec les voisins " + listeATester);
        }

// vérification que l'argument ne coincide pas avec les voisins
// (car 1 pays au moins est un trop et éventuellement 1 manque)
        System.out.println("======> Vérification des voisins (des voisins en trop) ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            listeATester.add(VOISINS[5][i]);
            if (aTester.aPourVoisin(listeATester)) {
                System.out.println("Echec du test avec les voisins " + listeATester);
            } else {
                nbTestOk++;
            }
            if (i > VOISINS[5].length / 2) {
                // on supprime un voisin
                listeATester.remove(0);
            }
        }
    }

}
