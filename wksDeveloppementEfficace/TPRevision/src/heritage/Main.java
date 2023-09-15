/**
 * 
 */
package heritage;

import java.util.Scanner;

/**
 * @author François de Saint Palais
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner entree = new Scanner(System.in);		
		Individu[] desGens = new Individu[5];
		String saisie;
		
		for (int i = 0; i < desGens.length; i++) {
			System.out.println("Voulez-vous créer un Individu(I) ou une Personne(P) ?");
			saisie = entree.next().toUpperCase();

			if (saisie.charAt(0) == 'I') {
				Individu utilisateurSaisie = new Individu();
				utilisateurSaisie.saisir();					
				while (contient(desGens, utilisateurSaisie)) {
					System.out.println("L'individu saisie existe déjà");
					utilisateurSaisie.saisir();					
				}
			    desGens[i] = utilisateurSaisie;

			} else if (saisie.charAt(0) == 'P') {
				Personne utilisateurSaisie = new Personne();
				utilisateurSaisie.saisir();	
				while (contient(desGens, utilisateurSaisie)) {
					System.out.println("L'individu saisie existe déjà");
					utilisateurSaisie.saisir();					
				}
				desGens[i] = utilisateurSaisie;
			
			} else {
				System.out.println("Saisissez 'I' ou 'P'.");
				i--;
			}
		}
		System.out.println("\n-----Les gens de la liste-------");
		for (Individu individu : desGens) {
			individu.afficher();
			System.out.println();
		}
		
		entree.close();
	}

	private static boolean contient (Individu[] liste, Individu individuTeste) {
		boolean estPresent = false;
		for (Individu individu : liste) {
			if (individu != null) {
				estPresent 
				|= individu.getNom() == individuTeste.getNom() 
				   && individu.getPrenom() == individuTeste.getPrenom();				
			}
		}
		return estPresent;
	}
	

}
