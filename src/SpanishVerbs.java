import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Contains code for conjugating a verb for a chosen tense based on user input
 * 
 * @author Neena Ugail
 * @version 1.0
 * @release 
 *
 */
public class SpanishVerbs {
	
	/*The verb to be conjugated*/
	static String verb;
	
	/*The ending of the verb - ar, ir, er*/
	static int verbEnding;
	
	/*Whether the user has entered a valid verb*/
	static boolean validVerb;
	
	/*The user's chosen tense*/
	static int tense;
	
	/*Whether the user has entered a valid tense*/
	static boolean validTense;
	
	/*The main part of the verb without the ending*/
	static String main;
	
	/*Conjugations*/
	static String yo;
	static String tu;
	static String you;
	static String nosotros;
	static String vosotros;
	static String youAll;
	
	/*2D array with verb endings*/
	static String[][] endings = {{"o","as","a","amos","\u00E1is","an"}, {"o","es","e","emos","\u00E9is","en"}, {"o","es","e","imos","\u00EDs","en"}, 
			{"\u00E9","aste","\u00F3","amos","asteis","aron"}, {"\u00ED","iste","i\u00F3","imos","isteis","ieron"}, {"aba","abas","aba","\u00E1bamos","abais","aban"},
			{"\u00EDa","\u00EDas","\u00EDa","\u00EDamos","\u00EDais","\u00EDan"}, {"ar\u00EDa","ar\u00EDas","ar\u00EDa","ar\u00EDamos","ar\u00EDais","ar\u00EDan"},
			{"er\u00EDa","er\u00EDas","er\u00EDa","er\u00EDamos","er\u00EDais","er\u00EDan"}, {"ir\u00EDa","ir\u00EDas","ir\u00EDa","ir\u00EDamos","ir\u00EDais","ir\u00EDan"},
			{"ar\u00E9","ar\u00E1s","ar\u00E1","aremos","aru\0233is","ar\u00E1n"}, {"er\u00E9","er\u00E1s","er\u00E1","eremos","er\u00E9is","er\u00E1n"},
			{"ir\u00E9","ir\u00E1s","ir\u00E1","iremos","ir\u00E9is","ir\u00E1n"}};
	
	/**
	 * Constructor used to set field values
	 */
	public SpanishVerbs() {
		validVerb = false;
		validTense = false;
	}
	
	/**
	 * Validating the verb by checking if it has a valid ending
	 * @param s: The string to be validated
	 * @return Whether the verb is valid
	 */
	public static boolean validateVerb(String s) {
		
		s = s.toLowerCase();
		
		if (s.length() > 2) { 
			String lastTwoLetters = s.substring(s.length()-2);
			
			switch(lastTwoLetters) {
				case "ar": 
					verbEnding = 1;
					return true;
				case "er": 
					verbEnding = 2;
					return true;
				case "ir": 
					verbEnding = 3;
					return true;
				default: System.out.println("Please enter a valid verb");
						 return false;
			}
		}
		else {
			System.out.println("Please enter a valid verb");
			return false;
		}
	}
	
	/**
	 * Validating the tense by checking if the user has entered a valid number
	 * @param s: The number to be validated
	 * @return: Whether the tense is valid
	 */
	public static Boolean validateTense(String s) {
		try {
			tense = Integer.parseInt(s);
			
			if (tense > 5 || tense < 1) {
				System.out.println("Please enter a valid number ");
				return false;
			}				
		}
		catch (Exception e) {
			System.out.println("Please enter a valid number");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * Main method - accepts input from the user for a verb and tense
	 * Calls the correct method based on the user's input to generate the correct conjugations
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the verb you would like to conjugate ");
		while (validVerb == false) {
			verb = scanner.nextLine();
			if (validateVerb(verb)) {
				validVerb = true;
				main = verb.substring(0, verb.length()-2); //Determine the main part of the verb by removing last two characters
				
			}
		}
	
		System.out.println("Enter the number corresponding to your chosen tense:\n"
				+ "1) Present\n"
				+ "2) Preterite\n"
				+ "3) Imperfect\n"
				+ "4) Conditional\n"
				+ "5) Future\n");
		
		while (validTense == false) {
			String t = scanner.nextLine();
			
			if (validateTense(t)) {
				validTense = true;
			}
			
		}
			
		int index = 0;
		
		switch(tense) { //Select correct array of conjugations from 2D array
			case 1:
				validTense = true;
				if (verbEnding == 1) {
					index = 0;
				}
				else if (verbEnding == 2) {
					index = 1;
				}
				else if (verbEnding == 3){
					index = 2;
				}
				break;
			case 2: 
				validTense = true;
				if (verbEnding == 1) {
					index = 3;
				}
				else if (verbEnding == 2 || verbEnding == 3) {
					index = 4;
				}
				break;
			case 3:
				validTense = true;
				if (verbEnding == 1) {
					index = 5;
				}
				else if (verbEnding == 2 || verbEnding == 3) {
					index = 6;
				}
				break;
			case 4:
				validTense = true;
				if (verbEnding == 1) {
					index = 7;
				}
				else if (verbEnding == 2) {
					index = 8;
				}
				else if (verbEnding == 3){
					index = 9;
				}
				break;
			case 5:
				validTense = true;
				if (verbEnding == 1) {
					index = 10;
				}
				else if (verbEnding == 2) {
					index = 11;
				}
				else if (verbEnding == 3){
					index = 12;
				}
				break;
		}
		
		yo = main+endings[index][0];
		tu = main+endings[index][1];
		you = main+endings[index][2];
		nosotros = main+endings[index][3];
		vosotros = main+endings[index][4];
		youAll = main+endings[index][5];
		
		
		//Create new object instance to display unicode characters correctly
		PrintWriter out = new PrintWriter(System.out, true);
		
		out.printf("Yo: %s\n", yo);
		out.printf("T\u00FA: %s\n", tu);
		out.printf("\u00C9l/Ella/Usted: %s\n", you);
		out.printf("Nosotros: %s\n", nosotros);
		out.printf("Vosotros: %s\n", vosotros);
		out.printf("Ellos/Ellas/Ustedes: %s\n", youAll);
			
	}
}