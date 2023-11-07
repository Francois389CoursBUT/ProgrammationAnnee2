/*
 * Exemples d'utilisation des expressions r�guli�res
 * ExerciceExpressionReguliere.java                                 10/22
 */

package exercicesdivers.expressionreguliere;
import java.util.regex.Pattern;

/**
 * Cette classe contient des m�thodes permettant de tester des expressions r�gulieres :
 *     1)   nom d'une activit�
 *     2)   r�ponse � une question
 *     3)   identifiant de salle
 *     4)   note �tudiant
 *     5)   num�ro dans une rue
 *     6)   horaire de la journ�e
 *     7)   nom de paquetage
 *     8)   pr�nom (�ventuellement compos�)
 *     9)   commande pour interpr�teur sur piles
 * @author Fran�ois de Saint Palais
 */
public class ExpressionsRegulieres {
    
    
    /**
     * V�rifie si une regex correspond � toutes les cha�nes du tableau argument
     * Affiche les cha�nes qui donnent un r�sultat inattendu
     * @param regex       cha�ne contenant l'expression r�guli�re � v�rifier
     * @param jeuDeTest   tableau contenant les cha�nes � v�rifier
     * @return un bool�en �gal � vrai ssi la regex correspond � toutes les 
     *         cha�nes du tableau
     */
    private static boolean verifieCorrect(String regex, String[] jeuDeTest) {       
        boolean correct = true;       // vrai ssi le jeuDeTest correspond � la regex
        Pattern motif = Pattern.compile(regex);       // on compile la regex
        
        // parcours du jeuDeTest pour v�rifier toutes les cha�nes qu'il contient
        for (int i = 0; i < jeuDeTest.length; i++) {
            
            // on v�rifie si le jeuDeTest d'indice i correspond � la regex
            if (! motif.matcher(jeuDeTest[i]).matches()) {
                System.out.println("Erreur la cha�ne " + jeuDeTest[i] 
                                   + " est consid�r�e comme invalide pour "
                                   + motif);
                correct = false;
            }
        }
        return correct;
    }
    
    
    /**
     * V�rifie si une regex ne correspond � aucune  des cha�nes du tableau argument
     * Affiche les cha�nes qui donnent un r�sultat inattendu
     * @param regex        cha�ne contenant l'expression r�guli�re � v�rifier
     * @param jeuDeTest    tableau contenant les cha�nes � v�rifier
     *                     aucune ne doit correspondre  � l'expression r�guli�re
     * @return un bool�en �gal � vrai ssi le motif ne correspond � aucune des
     *         cha�nes du tableau
     */
    private static boolean verifieNonCorrect(String regex, String[] jeuDeTest) {
        boolean correct = true;   // vrai ssi le jeuDeTest ne correspond pas � la regex
        Pattern motif = Pattern.compile(regex);         // on compile la regex
        
        // parcours du jeuDeTest pour v�rifier toutes les cha�nes qu'il contient        
        for (int i = 0; i < jeuDeTest.length; i++) {
            if (motif.matcher(jeuDeTest[i]).matches()) {
                System.out.println("Erreur la cha�ne " + jeuDeTest[i] 
                                   + " est consid�r�e comme valide pour "
                                   + motif);
                correct = false;
            }
        }
        return correct;
    }
    
    
    /*
     *  Test de l'expression r�guli�re pour un nom d'activit�
     */
    public static void nomActivite() {
        
        // des lettres minuscules, au nombre de 5 � 20
        String regex =  "^[a-z]{5,20}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "pause", "reunion", "formation", "enseignement",
                                    "professionnalisation"};
        String[] chaineIncorrecte = { "cafe", "Pause", "pauseE", "td-tp", "professionnalisations", 
                                      " pause", "pause ", "td tp", "td_tp", "reunion4", ""};
                                           
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n1) Tests pour un nom d'activit�." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    
    
    /*
     *  Test de l'expression r�guli�re pour un nom d'activit�
     */
    public static void reponseQuestion() {
        
        // des lettres (minuscules ou majuscules), des chiffres, des espaces, des apostrophes. 
        // au moins 3 caract�res
        String regex =  "^([a-zA-Z0-9]| |'){3,}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "non", "je ne sais pas", "12 valeurs", "l'attribut est egal a 345",
                                    " non ", "    12   valeurs   ", "OUI", "Inconnu", "VALEUR 8 entier"};
        String[] chaineIncorrecte = { "no", " ", "12 - 4", "non !", "# 236", 
                                      "non_oui", "p", "", "td ? tp", "$", "VALEUR = entier"};
                                   
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n2) Tests pour la r�ponse � une question." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    /*
     *  Test de l'expression r�guli�re pour un num�ro de salle
     */
    public static void numeroSalle() {
        
        // lettre A ou B ou C suivie de 3 chiffres
        String regex =  "^[ABC]\\d{3}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "A300", "B307", "B500", "C300"};
        String[] chaineIncorrecte = { "A30", "A3000"};
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n3) Tests pour le num�ro de salle." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression r�guli�re pour une note : Les notes vont de 0 � 20. 
     * Eventuellement, elles peuvent contenir un chiffre d�cimal. 
     * Dans ce cas, le s�parateur est la virgule �,�. 
     */
    public static void note() {
        
        /*
         *  un chiffre, ou le chiffre 1 suivi d'un chiffre ou le chiffre 2
         *  suivi de 0. Le tout suivi �ventuelle d'une virgule et d'un chiffre
         */
        
        String regex = "(^([0-9]|1[0-9])(,[0-9])?$)|(^20(,0)?)$";
        
        // jeux de tests
        String[] chaineCorrecte = { "20", "12", "15,6", "9,9", "0", "20,0", "5,0", "20,0"};
        String[] chaineIncorrecte = { "05", " 20", "1 4", "14 ", "21", 
                                      "14,45", "14.5", "36", "211", "9,10", "8, 5",
                                       "20,1", "20,99"};
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n4) Tests pour la note." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression r�guli�re pour un num�ro dans une rue : 
     * Un num�ro pourra �tre tout simplement un entier compris entre 1 et 999, 
     * car on autorise 3 chiffres au plus pour le num�ro. 
     * Toutefois ce num�ro pourra �tre compl�t� par l�une des mentions Ter ou Bis. 
     * Dans ce cas, un espace s�parera le num�ro de la mention. 
     * Cette derni�re pourra �tre �crite aussi bien en minuscules qu�en majuscules 
     * ou pourra commencer par une majuscule suivie de minuscule 
     * (Bis, BIS ou bis sont donc corrects, contrairement � bIS ou BiS par exemple).
     */
    public static void numeroRue() {
        
        /*
         * Un chiffre entre 1 et 9 suivi �ventuellement de 1, 2 ou 3 chiffres.
         * Eventuellement un espace puis la mention Ter ou Bis.
         * Ter pourra �tre �crit : Ter TER ter
         * Bis pourra �tre �crit : Bis BIS bis
         */
        String regex  = "^([1-9]|[1-9]\\d|[1-9]\\d{2})(( )(Bis|BIS|bis|Ter|TER|ter))?$";
        
        // jeux de tests
        String[] chaineCorrecte = { "1", "5", "60", "120", "999", 
                                    "1 bis", "34 Bis", "777 BIS", 
                                    "7 ter", "10 Ter", "505 TER"};
        String[] chaineIncorrecte = { "01", "0", "060", "12000", "999999", "1234",
                                      "1 ", " 1", "6 0", "1 200 ", " 99 999 9",
                                      "1 Tis", "34  Bis", " 777 BIS", 
                                      "7 ter ", "10 Te", "505 ER",
                                      "1Bis", "34Ter", " 777 BIS    ", 
                                      "7 BeR", "12 BiS", "55 bIs", "67 tEr",
                                      "69 bIS", "26 biS", "59 tER", "666 teR"}; 
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n5) Tests pour un num�ro de rue." 
                            + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    
    /*
     * Expression r�guli�re pour un horaire de la journ�e : 
     * 2 chiffres suivis de la lette h ou H suivi de 2 chiffres. 
     * Il faudra v�rifier que les 2 chiffres forment une suite valide. 
     */
    public static void horaire() {
        
        /* le chiffre 0 ou 1 suivi d'un chiffre ou bien le chiffre 2 suivi 
         * de 0, 1, 2 ou 3, puis la lettre h ou H, puis le chiffre 0, 1, 2, 3, 4, 5
         * suivi d'un chiffre
         */
        String regex  = "TODO";
        
        // jeux de tests
        String[] chaineCorrecte = { "09h10", "01H05", "23h59", "11h11", "20h00",
                                    "21H48", "22h31", "23h28"};
        String[] chaineIncorrecte = { "9h10", "01H5", "23h59 ", " 11h11", "20 h00",
                "21H 48", "22h3 1", "23:28", "23h", "h56", "119h45", "24h56",
                "32h60", "22h60", "22h88", "22h125"};
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n6) Tests pour un horaire de la journ�e." 
                            + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression r�guli�re pour un nom de paquetage en JAVA : 
     * Un nom de paquetage est �crit en lettres minuscules. Il peut contenir des chiffres, 
     * mais au d�but du mot. Eventuellement plusieurs noms peuvent �tre mis 
     * � la suite des uns des autres (paquetages imbriqu�s). Ils sont alors s�par�s 
     * par le caract�re �.�.
     */
    public static void paquetageJava() {
        
        /*
         * une lettre minuscule puis des minuscules ou des chiffres,
         * puis �ventuellement, 1 ou plusieures fois, un point et le motif pr�c�dent
         */
        String regex  = "TODO";
        
        // jeux de tests
        String[] chaineCorrecte = { "general", "general2", "api21java",
                                    "semestre3.regex", "dut.utilitaire.v2",
                                    "semestre3.module426.v45"};
        String[] chaineIncorrecte = { " general", "general2 ", "api 21java",
                                      "General", "generaL ", "21apijava",
                                      "ge_neral", "ge-neraL ", "api'java",
                                      "semestre3:regex", "dut,utilitaire",
                                      "semestre3.Module426.v45"};
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n7) Tests pour un nom de paquetage." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression r�guli�re pour le pr�nom d'une personne
     * Il doit commencer par une majuscule, suivi de minuscules.
     * Le pr�nom peut �tre compos� avec un '-' suivi d'une majuscule.
     * Exemple : Marie-Helene   Jean-Michel  (apr�s une majuscule, toujours au moins une
     * minuscule)
     */
    public static void prenom() {
        
        /*
         * une majusucle, suivie de au moins une minuscule
         * �ventuellement ensuite : une majusucle, suivie de au moins une minuscule
         */
        String regex = "TODO";
        
        // jeux de tests
        String[] chaineCorrecte = { "Marie-Helene", "Marie", "Jean-Michel"};
        String[] chaineIncorrecte = { "marie", " marie", "Marie_Helene", "Marie-H", 
                                      "J-Michel", "Jean-", "JEAN", "Jean-Michel-Pierre"};
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n8) Tests pour un pr�nom." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte)   
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }       
    }
    
    
   
    
    /*
     * Expression r�guli�re pour une commande d'un interpr�teur  : 
     * L'utilisateur de l'interpr�teur disposera de 10 piles, num�rot�es de 0 � 9. 
     * Les commandes reconnues par l'interpr�teur sont (minusucles ou majuscules) :
     *      c   num�ro_de_pile  capacit�        
     *      v   num�ro_de_pile              
     *      d   num�ro_de_pile              
     *      s   num�ro_de_pile              
     *      e   num�ro_de_pile  �l�ment     
     *      ?                           
     *      q                   
     */
    public static void commande() {
        
        /*
         * le caract�re ? ou Q ou q
         * ou bien le caract�re V ou v ou D ou d ou S ou s suivi d'un chiffre
         * ou bien le caract�re c ou C ou e ou E suivi d'un chiffre suivi d'un entier
         * Eventuellement des espaces en d�but ou fin de cha�ne
         * Entre les arguments ou moins un espace
         */
        String regex = "TODO";   
                       
        
        // jeux de tests
        String[] chaineCorrecte = { "E   5   236", "  E 6 1", "e   4 0 ", " ? ", "?",
                                    "S 4 ", "  C   9   0   ", "d 0  ", "q", "Q  ",  "   Q  ",
                                    "s 9", "c 1 1", "E  8  02", "C  4  0001"};
        String[] chaineIncorrecte = { "B 5 6", "E", "E 1", "E 123", 
                                       "E f 23", "E 3 f", "E 3 -23", "E 3 -23 f",
                                       "e 56", "k", "v4", "e 12 4", 
                                       "d 125", "d 3 8", "? 6",  "3 23 f",
                                       " ? 4 ", " ? 4  5  ", " q 6"}; 
        
        // v�rification des cha�nes correctes et incorrectes
        System.out.println("\n\n9) Tests pour une commande." 
                + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte) ) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
   
    /**
     * Programme principal
     * @param args  argument non utilis�
     */
    public static void main(String[] args) {

        /*
         * appels aux diff�rentes m�thodes faisant intervenir les expressions 
         * r�guli�res afin de les tester
         */
         nomActivite();
         reponseQuestion();
         numeroSalle();
         note();
         numeroRue();
        // horaire();
        // paquetageJava();
        // prenom();        
        // commande();
    }

}
