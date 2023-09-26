/*
 * FigureGeometrique.java                                    25 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package recursivite;


/**
 * @author francois.desaintpala
 *
 */
public class FigureGeometrique {
    
    public static void main(String[] args) {
        etoileHautGauche(8);
        etoileBasGauche(8);
        triangleIsocele(8,8);
        losange(8, 8);
    }

    /**
     * @param n
     */
    public static void etoile(int n) {
        if (0 < n) {
            System.out.print('*');
            etoile(n - 1);
        }
    }

    /**
     * @param n
     */
    public static void blanc(int n) {
        if (0 < n) {
            System.out.print(' ');
            blanc(n - 1);
        }
    }
    
    public static void etoileHautGauche (int n) {
        if (0 < n) {
            etoile(n);
            System.out.println();
            etoileHautGauche(n-1);
        }
    }
    
    
    public static void etoileBasGauche(int n) {
        if (0 < n) {
            etoileBasGauche(n-1);
            etoile(n);
            System.out.println();
        }
    }
    
    public static void triangleIsocele(int total,int n) {
        if (0 < n) {
            triangleIsocele(total,n-1);
            blanc(total-n);
            etoile(2*n-1);
            System.out.println();
        }
    }

    public static void triangleIsoceleInverser(int total,int n) {
        if (0 < n) {
            blanc(total-n);
            etoile(2*n-1);
            System.out.println();
            triangleIsoceleInverser(total, n-1);
        }
    }
    
    public static void losange(int total, int n) {
        triangleIsocele(total, n);
        triangleIsoceleInverser(total, n);
    }
    
}




