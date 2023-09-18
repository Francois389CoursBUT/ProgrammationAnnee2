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

    /**
     * Contructeur par défaut, 
     * qui initialise les paramétres avec des valuers par défaut
     */
    public Personne() {
        super();
        numero = new Telephone();
    }
    

    /**
     * Constructeur d'une personne avec seulement son nom et prenom
     * les autre paramétre sont initialisé âr défaut 
     * @param nom
     * @param prenom
     */
    public Personne (String nom, String prenom) {
    	super(nom, prenom);
    	numero = new Telephone();
    }
    
    /**
     * Constructeur complet d'une personne
     * @param nom
     * @param prenom
     * @param numeroTelephone
     * @param addresseMail
     */
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
    
    /** @return Renvoie une String contenant ses information personnel */
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
