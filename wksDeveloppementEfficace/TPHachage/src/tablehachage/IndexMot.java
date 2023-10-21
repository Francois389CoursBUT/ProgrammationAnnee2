/*
 * IndexMot.java                                    20 oct. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package tablehachage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/** 
 * 
 * @author Francois de Saint Palais
 */
public class IndexMot {

    private HashMap<String, ArrayList<Integer>> index;
    
    /** 
     * TODO comment initial state properties
     * @param index
     */
    public IndexMot() {
        index = new HashMap<String, ArrayList<Integer>>();
    }

    /** 
     * Ajoute une paire (mot, num�ro de page) � l'index
     * @param mot
     * @param i
     * @return Renvoie true si l'ajout � pu �tre fait false sinon
     */
    public boolean ajouterMot(String mot, int i) {
        boolean ajouterOk;
        if (i <= 0 || mot == null) {
            ajouterOk = false;
        } else if (!index.containsKey(mot)) {
            ArrayList<Integer> page = new ArrayList<Integer>();
            page.add(i);
            index.put(mot, page);
            ajouterOk = true;
        } else if (!index.get(mot).contains(i)) {
            index.get(mot).add(i);
            ajouterOk = true;
        } else ajouterOk = false;
        return ajouterOk;
    }

    /** 
     * @return une cha�ne de carat�re contenant tous les mots 
     * pr�sents dans l'index
     */
    public String getListeMot() {
        StringBuilder resultat = new StringBuilder();
        for (String mot : index.keySet()) {
            resultat.append(mot + " ");
        }
        return resultat.toString();
    }

    /** 
     * @param mot Le mot dont on recherche les pages
     * @return une liste des num�ros de page associ� � mot
     */
    public ArrayList<Integer> getListeNumero(String mot) {
        ArrayList<Integer> resultat = null;
        if (mot != null && index.containsKey(mot)) {
            resultat = new ArrayList<Integer>();
            for (Integer page : index.get(mot)) {
                resultat.add(page);
            }
        }
        return resultat;            
    }

    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        ArrayList<String> cle = new ArrayList<String>(index.keySet());
        Collections.sort(cle);
        for (String mot : cle) {
            resultat.append(mot + " [");
            ArrayList<Integer> page = getListeNumero(mot);
            Collections.sort(page);
            for (int i = 0; i < page.size() - 1; i++) {
                resultat.append(page.get(i)+", ");
            }
            resultat.append(page.get(page.size() - 1));
            resultat.append("]\n");
        }
        return resultat.toString();
    }

    /** 
     * Supprime une page de l'index. Si c'�tait la derni�re page d'un mot 
     * alors le mots est supprim�
     * @param mot Le mot ou supprimer une page
     * @param i La numero de page � supprimer
     * @return true si la suppression � �t� faite false sinon
     */
    public boolean supprimerNumero(String mot, int i) {
        boolean suppressionOK;
        
        if (index.containsKey(mot) && index.get(mot).contains(i) && index.get(mot).size() == 1) {
            index.remove(mot);
            suppressionOK = true;
        } else if (index.containsKey(mot) && index.get(mot).contains(i)) {
            //On doit changer le type sinon le compilateur pense que
            //l'argument pass� est un index
            index.get(mot).remove((Integer) i);
            suppressionOK = true;
        } else {
            suppressionOK = false;
        }
        
        return suppressionOK;
    }

    /** 
     * Incremente de un les pages sup�rieur � l'argument
     * @param i
     */
    public void incrementerApres(int i) {
        for (String mot : index.keySet()) {
            
            ArrayList<Integer> lesPages = index.get(mot);
            for (int j = 0; j < lesPages.size(); j++) {
                
                Integer numero = lesPages.get(j);
                if (i < numero) lesPages.set(j, numero + 1);
            }
        }
    }

    /** 
     * 
     * @param i
     */
    public void supprimerDecrementerApres(int i) {
        /*
         *  Comme nous voulons modifier (remove()) notre HashMap 
         *  durant son it�ration, nous devons nous pr�munir 
         *  de l'exception ConcurrentModificationException.
         *  Pour ce faire nous allons enregistrer les mots � supprimer 
         *  puis nous allons le faire apr�s la boucle
         */
        ArrayList<String> aRetirer = new ArrayList<String>();
        for (String mot : index.keySet()) {
            
            if (index.containsKey(mot) && index.get(mot).contains(i)) {
                index.get(mot).remove((Integer) i);
                if (index.get(mot).size() == 0) {
                    aRetirer.add(mot);
                } else {
                    /*
                     * On a supprimer la page mais il reste des pages dans l'index
                     * Il faut decrementer les pages restante qui sont sup�rieru � i.
                     */
                    ArrayList<Integer> lesPages = index.get(mot);
                    for (int j = 0; j < lesPages.size(); j++) {
                        
                        Integer numero = lesPages.get(j);
                        if (i < numero) lesPages.set(j, numero - 1);
                    }
                }
            }
        }
        for (String motARetirer : aRetirer) {
            index.remove(motARetirer);            
        }
    }

    
}
