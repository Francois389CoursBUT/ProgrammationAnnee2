package recursivite;

import java.util.Scanner;

/**
 * Programme mystère
 * 
 * @author INFO2
 */
public class Mystere {
    /** Saisie sur l'entrée standard */
    private static Scanner entree = new Scanner(System.in);

    /** Méthode récursive */
    public static void traitement() {
        char caract; // contient le caractère entré par l'utilisateur
        System.out.print(" ? ");

        // on stocke le premier caractère entré par l'utilisateur
        caract = entree.nextLine().charAt(0);
        if (caract != '.') {
            traitement(); // appel récursif
        }
        System.out.print(caract);
    }

    /**
     * Programme principal
     * 
     * @param args argument non utilisé
     */
    public static void main(String args[]) {
        System.out.println("Lorsque le programme affiche '?', l'utilisateur doit entrer un "
                + "caractere. \nPour terminer le programme, il doit entrer le " + "caractere + '.'. \n");
        traitement();
        System.out.println();
    }
}
