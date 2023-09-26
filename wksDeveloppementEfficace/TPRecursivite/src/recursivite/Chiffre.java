/*
 * Chiffre.java                                    25 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package recursivite;

/** TODO comment class responsibility (SRP)
 * @author "François de Saint Palais"
 */
public class Chiffre {
    
    /**
     * @param args inutilisé
     */
    public static void main(String[] args) {
        afficheInverse(1736);
        System.out.println();
        System.out.println(chaineInverse(1736));
    }

    
    public static void afficheInverse(int n) {
        if (n != 0) {
            System.out.print(n%10+" ");
            afficheInverse(n/10);
        }
    }

    public static String chaineInverse(int n) {
        if (n != 0) {
            return n % 10 + " " + chaineInverse(n/10);
        }
        return "";
    }
    
    
}
