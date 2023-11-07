/*
 * Exemples d'utilisation des expressions régulières
 * ExerciceExpressionReguliere.java                                 10/22
 */

package exercicesdivers.expressionreguliere;
import java.util.regex.Pattern;

/**
 * Cette classe contient des méthodes permettant de tester des expressions régulieres :
 *     1)   nom d'une activité
 *     2)   réponse à une question
 *     3)   identifiant de salle
 *     4)   note étudiant
 *     5)   numéro dans une rue
 *     6)   horaire de la journée
 *     7)   nom de paquetage
 *     8)   prénom (éventuellement composé)
 *     9)   commande pour interpréteur sur piles
 * @author François de Saint Palais
 */
public class ExpressionsRegulieres {
    
    
    /**
     * Vérifie si une regex correspond à toutes les chaînes du tableau argument
     * Affiche les chaînes qui donnent un résultat inattendu
     * @param regex       chaîne contenant l'expression régulière à vérifier
     * @param jeuDeTest   tableau contenant les chaînes à vérifier
     * @return un booléen égal à vrai ssi la regex correspond à toutes les 
     *         chaînes du tableau
     */
    private static boolean verifieCorrect(String regex, String[] jeuDeTest) {       
        boolean correct = true;       // vrai ssi le jeuDeTest correspond à la regex
        Pattern motif = Pattern.compile(regex);       // on compile la regex
        
        // parcours du jeuDeTest pour vérifier toutes les chaînes qu'il contient
        for (int i = 0; i < jeuDeTest.length; i++) {
            
            // on vérifie si le jeuDeTest d'indice i correspond à la regex
            if (! motif.matcher(jeuDeTest[i]).matches()) {
                System.out.println("Erreur la chaîne " + jeuDeTest[i] 
                                   + " est considérée comme invalide pour "
                                   + motif);
                correct = false;
            }
        }
        return correct;
    }
    
    
    /**
     * Vérifie si une regex ne correspond à aucune  des chaînes du tableau argument
     * Affiche les chaînes qui donnent un résultat inattendu
     * @param regex        chaîne contenant l'expression régulière à vérifier
     * @param jeuDeTest    tableau contenant les chaînes à vérifier
     *                     aucune ne doit correspondre  à l'expression régulière
     * @return un booléen égal à vrai ssi le motif ne correspond à aucune des
     *         chaînes du tableau
     */
    private static boolean verifieNonCorrect(String regex, String[] jeuDeTest) {
        boolean correct = true;   // vrai ssi le jeuDeTest ne correspond pas à la regex
        Pattern motif = Pattern.compile(regex);         // on compile la regex
        
        // parcours du jeuDeTest pour vérifier toutes les chaînes qu'il contient        
        for (int i = 0; i < jeuDeTest.length; i++) {
            if (motif.matcher(jeuDeTest[i]).matches()) {
                System.out.println("Erreur la chaîne " + jeuDeTest[i] 
                                   + " est considérée comme valide pour "
                                   + motif);
                correct = false;
            }
        }
        return correct;
    }
    
    
    /*
     *  Test de l'expression régulière pour un nom d'activité
     */
    public static void nomActivite() {
        
        // des lettres minuscules, au nombre de 5 à 20
        String regex =  "^[a-z]{5,20}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "pause", "reunion", "formation", "enseignement",
                                    "professionnalisation"};
        String[] chaineIncorrecte = { "cafe", "Pause", "pauseE", "td-tp", "professionnalisations", 
                                      " pause", "pause ", "td tp", "td_tp", "reunion4", ""};
                                           
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n1) Tests pour un nom d'activité." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    
    
    /*
     *  Test de l'expression régulière pour un nom d'activité
     */
    public static void reponseQuestion() {
        
        // des lettres (minuscules ou majuscules), des chiffres, des espaces, des apostrophes. 
        // au moins 3 caractères
        String regex =  "^([a-zA-Z0-9]| |'){3,}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "non", "je ne sais pas", "12 valeurs", "l'attribut est egal a 345",
                                    " non ", "    12   valeurs   ", "OUI", "Inconnu", "VALEUR 8 entier"};
        String[] chaineIncorrecte = { "no", " ", "12 - 4", "non !", "# 236", 
                                      "non_oui", "p", "", "td ? tp", "$", "VALEUR = entier"};
                                   
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n2) Tests pour la réponse à une question." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    /*
     *  Test de l'expression régulière pour un numéro de salle
     */
    public static void numeroSalle() {
        
        // lettre A ou B ou C suivie de 3 chiffres
        String regex =  "^[ABC]\\d{3}$"; 
            
        // jeux de tests
        String[] chaineCorrecte = { "A300", "B307", "B500", "C300"};
        String[] chaineIncorrecte = { "A30", "A3000"};
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n3) Tests pour le numéro de salle." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
            && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression régulière pour une note : Les notes vont de 0 à 20. 
     * Eventuellement, elles peuvent contenir un chiffre décimal. 
     * Dans ce cas, le séparateur est la virgule ‘,’. 
     */
    public static void note() {
        
        /*
         *  un chiffre, ou le chiffre 1 suivi d'un chiffre ou le chiffre 2
         *  suivi de 0. Le tout suivi éventuelle d'une virgule et d'un chiffre
         */
        
        String regex = "(^([0-9]|1[0-9])(,[0-9])?$)|(^20(,0)?)$";
        
        // jeux de tests
        String[] chaineCorrecte = { "20", "12", "15,6", "9,9", "0", "20,0", "5,0", "20,0"};
        String[] chaineIncorrecte = { "05", " 20", "1 4", "14 ", "21", 
                                      "14,45", "14.5", "36", "211", "9,10", "8, 5",
                                       "20,1", "20,99"};
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n4) Tests pour la note." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression régulière pour un numéro dans une rue : 
     * Un numéro pourra être tout simplement un entier compris entre 1 et 999, 
     * car on autorise 3 chiffres au plus pour le numéro. 
     * Toutefois ce numéro pourra être complété par l’une des mentions Ter ou Bis. 
     * Dans ce cas, un espace séparera le numéro de la mention. 
     * Cette dernière pourra être écrite aussi bien en minuscules qu’en majuscules 
     * ou pourra commencer par une majuscule suivie de minuscule 
     * (Bis, BIS ou bis sont donc corrects, contrairement à bIS ou BiS par exemple).
     */
    public static void numeroRue() {
        
        /*
         * Un chiffre entre 1 et 9 suivi éventuellement de 1, 2 ou 3 chiffres.
         * Eventuellement un espace puis la mention Ter ou Bis.
         * Ter pourra être écrit : Ter TER ter
         * Bis pourra être écrit : Bis BIS bis
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
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n5) Tests pour un numéro de rue." 
                            + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    
    /*
     * Expression régulière pour un horaire de la journée : 
     * 2 chiffres suivis de la lette h ou H suivi de 2 chiffres. 
     * Il faudra vérifier que les 2 chiffres forment une suite valide. 
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
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n6) Tests pour un horaire de la journée." 
                            + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression régulière pour un nom de paquetage en JAVA : 
     * Un nom de paquetage est écrit en lettres minuscules. Il peut contenir des chiffres, 
     * mais au début du mot. Eventuellement plusieurs noms peuvent être mis 
     * à la suite des uns des autres (paquetages imbriqués). Ils sont alors séparés 
     * par le caractère ‘.’.
     */
    public static void paquetageJava() {
        
        /*
         * une lettre minuscule puis des minuscules ou des chiffres,
         * puis éventuellement, 1 ou plusieures fois, un point et le motif précédent
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
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n7) Tests pour un nom de paquetage." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
    /*
     * Expression régulière pour le prénom d'une personne
     * Il doit commencer par une majuscule, suivi de minuscules.
     * Le prénom peut être composé avec un '-' suivi d'une majuscule.
     * Exemple : Marie-Helene   Jean-Michel  (après une majuscule, toujours au moins une
     * minuscule)
     */
    public static void prenom() {
        
        /*
         * une majusucle, suivie de au moins une minuscule
         * éventuellement ensuite : une majusucle, suivie de au moins une minuscule
         */
        String regex = "TODO";
        
        // jeux de tests
        String[] chaineCorrecte = { "Marie-Helene", "Marie", "Jean-Michel"};
        String[] chaineIncorrecte = { "marie", " marie", "Marie_Helene", "Marie-H", 
                                      "J-Michel", "Jean-", "JEAN", "Jean-Michel-Pierre"};
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n8) Tests pour un prénom." 
                           + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte)   
                && verifieNonCorrect(regex,chaineIncorrecte)) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }       
    }
    
    
   
    
    /*
     * Expression régulière pour une commande d'un interpréteur  : 
     * L'utilisateur de l'interpréteur disposera de 10 piles, numérotées de 0 à 9. 
     * Les commandes reconnues par l'interpréteur sont (minusucles ou majuscules) :
     *      c   numéro_de_pile  capacité        
     *      v   numéro_de_pile              
     *      d   numéro_de_pile              
     *      s   numéro_de_pile              
     *      e   numéro_de_pile  élément     
     *      ?                           
     *      q                   
     */
    public static void commande() {
        
        /*
         * le caractère ? ou Q ou q
         * ou bien le caractère V ou v ou D ou d ou S ou s suivi d'un chiffre
         * ou bien le caractère c ou C ou e ou E suivi d'un chiffre suivi d'un entier
         * Eventuellement des espaces en début ou fin de chaîne
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
        
        // vérification des chaînes correctes et incorrectes
        System.out.println("\n\n9) Tests pour une commande." 
                + " Motif = " + regex);
        if (verifieCorrect(regex,chaineCorrecte) 
                && verifieNonCorrect(regex,chaineIncorrecte) ) {
            System.out.println("  ==> Tous les tests sont corrects.");
        }
    }
    
    
   
    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {

        /*
         * appels aux différentes méthodes faisant intervenir les expressions 
         * régulières afin de les tester
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
