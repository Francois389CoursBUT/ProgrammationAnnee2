package recursivite;

import java.util.Scanner;

/**
 * Programme myst�re
 * 
 * @author INFO2
 */
public class Mystere {
    /** Saisie sur l'entr�e standard */
    private static Scanner entree = new Scanner(System.in);

    /** M�thode r�cursive */
    public static void traitement() {
        char caract; // contient le caract�re entr� par l'utilisateur
        System.out.print(" ? ");

        // on stocke le premier caract�re entr� par l'utilisateur
        caract = entree.nextLine().charAt(0);
        if (caract != '.') {
            traitement(); // appel r�cursif
        }
        System.out.print(caract);
    }

    /**
     * Programme principal
     * 
     * @param args argument non utilis�
     */
    public static void main(String args[]) {
        System.out.println("Lorsque le programme affiche '?', l'utilisateur doit entrer un "
                + "caractere. \nPour terminer le programme, il doit entrer le " + "caractere + '.'. \n");
        traitement();
        System.out.println();
    }
}
