/*
 * Pays.java                                    18 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package structuredonnees.ensemble;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author François de Saint Palais
 */
public class Pays {

    private String nom;

    private TreeSet<String> paysLimitrophe;

    /**
     * Constructeur qui initialise les pays limitrophe a vide
     * @param nom
     */
    public Pays(String nom) {
        super();
        if (!nomValide(nom)) {
            throw new IllegalArgumentException("Erreur : Nom saisie invalide");
        }
        this.nom = nom;
        paysLimitrophe = new TreeSet<>();
    }

    /** TODO comment initial state properties
     * @param nom
     * @param paysLimitrophe
     */
    public Pays(String nom, String[] paysLimitrophe) {
        super();
        if (!nomValide(nom)) {
            throw new IllegalArgumentException("Erreur : Nom saisie invalide");
        }
        this.nom = nom;
        this.paysLimitrophe = new TreeSet<>();
        for (String pays : paysLimitrophe) {
            if (!nomValide(pays)) {
                throw new IllegalArgumentException(
                        String.format("Erreur : %s est un nom invalide", pays));
            }
            this.paysLimitrophe.add(pays);
        }
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return nom + " a pour voisin : " + paysLimitrophe;
    }

    /**
     * Ajoute a la liste des nom de pays voisin, nom
     * @param nom
     */
    public void ajouterVoisin(String nom) {
        if (!nomValide(nom)) {
            throw new IllegalArgumentException("Erreur : Nom saisie invalide");
        }
        paysLimitrophe.add(nom);
    }

    /**
     * @param nomTeste
     * @return true si nomTeste est voisin du pays et false sinon
     */
    public boolean aPourVoisin (String nomTeste) {
        return paysLimitrophe.contains(nomTeste);
    }

    /**
     * Indique si les pays de la liste sont tous voisins de this.
     * Un pays peut être présent plusieur fois dans la liste.
     * @param listeVoisin
     * @return true si la liste contient au minimum tous les voisin du pays courant.
     */
    public boolean aPourVoisin(ArrayList<String> listeVoisin) {
        boolean sontVoisins;

        /* Si la liste testé est plus petite que celle du pays alors
         * il manque des pays
         */
        sontVoisins = paysLimitrophe.size() <= listeVoisin.size();
        for (String possibleVoisin : listeVoisin) {
            sontVoisins &= this.aPourVoisin(possibleVoisin);
        }
        return sontVoisins;
    }

    /** @return le nombre de voisin du pays courant */
    public int nombreVoisin() {
        return paysLimitrophe.size();
    }

    /**
     * @param listeATester
     * @return le nombre de pays de la liste qui sont voisin du pays courant
     */
    public int nombreCommun(ArrayList<String> listeATester) {
        int cpt = 0;
        for (String pays : listeATester) {
            cpt += aPourVoisin(pays) ? 1 : 0;
        }
        return cpt;
    }

    /**
     * @param nom
     * @return true si le nom est valide false sinon
     */
    public static boolean nomValide(String nom) {
        if (nom == null) {
            return false;
        }
        return !nom.isBlank();
    }

    /** @return Le nom du pays */
    public String getNom() {
        return nom;
    }

    /** @return L'ensemble des pays voisins */
    public TreeSet<String> getPaysLimitrophe() {
        return paysLimitrophe;
    }



}
