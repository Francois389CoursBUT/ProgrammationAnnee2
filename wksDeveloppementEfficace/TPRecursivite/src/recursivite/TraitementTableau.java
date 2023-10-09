/*
 * TraitementTableau.java                                    25 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package recursivite;


/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 */
public class TraitementTableau {

    /** 
     * @param args inutilisé
     */
    public static void main(String[] args) {
        int[] tab = new int[10];
        for (int i : tab) {
            System.out.print(i + "|");
        }
        System.out.println();
        fill(tab, -1, 0);
        for (int i : tab) {
            System.out.print(i + "|");
        }
        System.out.println();
        
        int[] tab2 = {3, 10, 5, 9, 4, 2, 1, 8, 14, -6};
        System.out.println(estPresent(tab2, 2, 0));
        System.out.println(estPresent(tab2, 0, 0));
        
        System.out.println(max(tab2, 0, 0));
        tab2[8] = 10;
        System.out.println(max(tab2, 0, 0));
    }

    public static int[] fill (int[] tab, int val, int indice) {
        if (indice < tab.length) {
            tab[indice] = val;
            fill(tab, val, indice + 1);
        }
        return tab;
    }
    
    public static boolean estPresent(int[] tab, int recherche, int i) {
        if (i == tab.length) {
            return false;
        }
        if (tab[i] == recherche) {
            return true;
        }
        return estPresent(tab, recherche, i+1);
    }
    
    public static int max (int[] tab, int indiceMax, int i) {
        if (i == tab.length) {
            return indiceMax;
        }
        if (tab[indiceMax] < tab[i]) {
            indiceMax = i;
        }
        return max(tab, indiceMax, i+1);
    }
}





