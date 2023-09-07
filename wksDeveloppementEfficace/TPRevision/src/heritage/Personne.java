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
    	super(nom, prenom);
    	numero = new Telephone(numeroTelephone);
    	if (valide(addresseMail)) {
    		this.addresseMail = addresseMail;			
		} else {
			throw new IllegalArgumentException("Erreur : L'addresse mail saisie est invalide.");
		}
    }
    
    public void afficher () {
    	super.afficher();
    	numero.afficher();
    	System.out.println("\n"+addresseMail);
    }
    
    @SuppressWarnings("unused")
	public void saisir () {
    	String saisie;
    	super.saisir();
    	numero.saisir();
    	System.out.println("Telephone set");
    	
    	boolean correct = false;

        do {
            System.out.print("Addresse mail ? ");
            addresseMail = entree.nextLine();
            correct = valide(addresseMail);
			if (!correct) { // Vérifier la validiter de la saisie
				System.out.println("Addresse mail invalide. Recommencez ! ");				
			}
        } while (!correct);
    }
    
    public String information () {
    	return "Nom :............." + getNom() + "\n" +
    		   "Prenom :.........." + getPrenom() + "\n" +
    		   "Téléphone :......." + numero.getNumero() + "\n" +
    		   "Adresse mail :...." + addresseMail;
    }
    
    /** @param args inutilisé */
    public static void main (String[] args) {
    	Personne a = new Personne();
    	Personne b = new Personne("Dubois","Jean");
    	Personne c = new Personne("Martin","Paul","0612345678","paul.dubois@gmail.com");
    	
    	a.afficher();
    	System.out.println();
    	b.afficher();
    	System.out.println();
    	c.afficher();
    	System.out.println();
    	
//    	a.saisir();
    	
    	System.out.println(a.information());
    	
    }
    
    private static boolean valide (String addresseMail) {
    	return addresseMail.matches("^[\\w._-]+@[\\w._-]+\\.[a-z]{2,3}$");
    }
    
    
}
