/*
 * Pile.java                                    7 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package structuredonnees;

/** 
 * Représente une pile de FIFO
 * 
 * @author François de Saint Palais
 */
public class Pile {
    
    /** TODO comment field role (attribute, associative role) */
    private static final int CAPACITE_MAXIMAL_DEFAUT = 10;

    /** La capacite maximal de la Pile */
    private int capacite;
    
    /** L'indice du sommet de la Pile */
    private int sommet;
    
    /** Les donnée de la Pile */
    private int[] donnee;
    
    /** 
     * Constructeur par défaut, la pile sera initialisé 
     * avec la capacité par défaut 
     * */
    public Pile() {
        capacite = CAPACITE_MAXIMAL_DEFAUT;
        donnee = new int[capacite];
        sommet = -1;
    }
    
    /** 
     * @param capacitePile La capacite de la pile voulue
     */
    public Pile (int capacitePile) {
        if (capacitePile < 1) {
            throw new IllegalArgumentException("La capacité doit au minimum être égale à 1");
        }
        capacite = capacitePile;
        donnee = new int[capacite];
        sommet = -1;
    }
    
    /** @return true si la pile est vide false sinon */
    public boolean estVide () {
        return sommet < 0;
    }
    
    /** @return true si la pile est pleine false sinon */
    public boolean estPleine() {
        return sommet == capacite -1;
    }
    
    /**
     * Ajoute element au sommet de la pile 
     * @param element L'entier à ajouter au sommet
     * @throws IllegalStateException si le pile est pleine, 
     * il est impossible d'ajouter un élément
     */
    public void empiler (int element) {
        if (estPleine()) {
            throw new IllegalStateException("La pile est pleine.");
        }
        sommet ++;
        donnee[sommet] = element;
    }
    
    /** @return Le sommet de la pile */
    public int sommet () {
        if (estVide()) {
            throw new IllegalStateException("La pile est vide.");
        }
        return donnee[sommet];
    }
    
    /**
     * Retire le sommet de la pile
     * @throws IllegalStateException Si la pile est vide, 
     * on ne peut pas enlever ce qui n'existe pas
     */
    public void depiler () {
        if (estVide()) {
            throw new IllegalStateException("La pile est vide.");
        }
        /* On met le sommet à zéro */ 
        donnee[sommet] = 0;
        sommet--;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        String chaine = "[sommet = ";
        for (int i = 0; i <= sommet; i++) {
            chaine += donnee[i] + "|";
        }
        chaine += ']';
        return chaine;
    }
    
    /** 
     * @param premier
     * @param autre 
     * @return true si les deux Pile ont la meme capcite, false sinon 
     */
    public static boolean memeCapacite (Pile premier, Pile autre) {
        return premier.capacite == autre.capacite;
    }


    /* non javadoc - @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object obj) {
        boolean memeContenue = true;
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pile other = (Pile) obj;
        if (donnee.length == other.donnee.length) {
            for (int i = 0; i < donnee.length && memeContenue; i++) {
                memeContenue = donnee[i] == other.donnee[i];
            }            
        }
        return capacite == other.capacite && sommet == other.sommet && memeContenue;
    }
    
}