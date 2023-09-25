/*
 * Fibonnacci.java                                    25 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package recursivite;

/** TODO comment class responsibility (SRP)
 * @author francois.desaintpala
 *
 */
public class OutilEntierRecursif {

    /**
     * Calcule la valeur du terme de rang n de la 
     * @param n Le terme voulue
     * @return la valeur du terme de rang n
     */
    public static int fibonnacci(int n) {
       if (n <= 1) {
        return 1;
       }
       return fibonnacci(n - 1) + fibonnacci(n - 2);
    }
    
    /**
     * @param args inutilisé
     */
    public static void main(String[] args) {
        System.out.println(fibonnacci(8));
    }
    
    
}
