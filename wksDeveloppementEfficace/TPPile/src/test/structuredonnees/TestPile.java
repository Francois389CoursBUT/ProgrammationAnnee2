/*
 * TestPile.java                                    7 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package test.structuredonnees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structuredonnees.pile.Pile;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
class TestPile {

    @Test
    void testManuel() {
        Pile cinq = new Pile(5);
        
        assertTrue(cinq.estVide());
        
        cinq.empiler(1);
        cinq.empiler(22);
        cinq.empiler(333);
        
        assertFalse(cinq.estVide());
        
        System.out.println(cinq.sommet());
        
        System.out.println(cinq);
        
        cinq.depiler();
        
        System.out.println(cinq);
        
        cinq.empiler(4444);
        cinq.empiler(55555);
        cinq.empiler(666666);
        
        assertTrue(cinq.estPleine());
        
        assertThrows(IllegalStateException.class, () -> cinq.empiler(123));
        
        assertThrows(IllegalArgumentException.class, () -> new Pile(-1));
        
        Pile vide = new Pile();
        assertThrows(IllegalStateException.class, () -> vide.depiler());
        
        assertThrows(IllegalStateException.class, () -> vide.sommet());
        
    }

    

}
