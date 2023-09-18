/*
 * TestPaysJUnit.java                                    18 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package test.structuredonnees.ensemble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static structuredonnees.ensemble.Pays.nomValide;;

/** TODO comment class responsibility (SRP)
 * @author francois.desaintpala
 *
 */
class TestPaysJUnit {
    
    /** Noms de pays invalides */
    private static final String[] NOM_PAYS_INVALIDE = { null, "", " ", "      "};
    
    /** Exemples de noms de pays valides */
    private static final String[] NOM_PAYS_VALIDE = { "France", "Espagne", "Italie", "Australie"};

    @Test
    void test() {
        for (String string : NOM_PAYS_VALIDE) {
            assertTrue(nomValide(string));        
        }
        for (String string : NOM_PAYS_INVALIDE) {
            assertFalse(nomValide(string));
        }
    }

}
