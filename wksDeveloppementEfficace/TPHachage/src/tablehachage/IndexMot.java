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
     * Ajoute une paire (mot, numéro de page) à l'index
     * @param mot
     * @param i
     * @return Renvoie true si l'ajout à pu étre fait false sinon
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
     * @return une chaîne de caratère contenant tous les mots 
     * présents dans l'index
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
     * @return une liste des numéros de page associé à mot
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
     * 
     * @param mot
     * @param i
     * @return
     */
    public boolean supprimerNumero(String mot, int i) {
        boolean suppressionOK;
        
        if (index.containsKey(mot) && index.get(mot).contains(i) && index.get(mot).size() == 1) {
            index.remove(mot);
            suppressionOK = true;
        } else if (index.containsKey(mot) && index.get(mot).contains(i)) {
            //On doit changer le type sinon le compilateur pense que
            //l'argument passé est un index
            index.get(mot).remove((Integer) i);
            suppressionOK = true;
        } else {
            suppressionOK = false;
        }
        
        return suppressionOK;
    }

    /** 
     * TODO comment method role
     * @param i
     */
    public void incrementerApres(int i) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * TODO comment method role
     * @param i
     */
    public void supprimerDecrementerApres(int i) {
        // TODO Auto-generated method stub
        
    }

    
}
