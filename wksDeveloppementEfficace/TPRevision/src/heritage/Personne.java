/*
 * Presonne.java                                    6 sept. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package heritage;

import java.util.Scanner;

/** TODO comment class responsibility (SRP)
 * @author francois.desaintpala
 *
 */
public class Personne extends Individu {

    private Telephone numero;
    
    private String addresseMail;
    
    private static Scanner entree = new Scanner(System.in);   

    /** TODO comment initial state properties
     * 
     */
    public Personne() {
        super();
        numero = new Telephone();
    }
    
    public Personne (String nom, String prenom) {
    	super(nom, prenom);
    	numero = new Telephone();
    }
    
    public Personne (String nom, String prenom, String numeroTelephone,String addresseMail) {
    	super(prenom, prenom);
    	numero = new Telephone(numeroTelephone);
    	this.addresseMail = addresseMail;
    }
    
    public void afficher () {
    	super.afficher();
    	numero.afficher();
    	System.out.println(addresseMail);
    }
    
    @SuppressWarnings("unused")
	public void saisir () {
    	super.saisir();
    	numero.saisir();
    	
    	boolean correct = false;

        do {
            System.out.print("Addresse mail ? ");
            if (true) { // Vérifier la validiter de la saisie
            	addresseMail = entree.nextLine();				
			} else {
				System.out.println("Addresse mail invalide. Recommencez ! ");				
			}
        } while (!correct);
    }
    
    public String information () {
    	return null;
    }
    
    
}
