package pigLatin;

import java.util.Scanner;

public class PigLatinGenerator {
	// static variable that we will use to store the modified user input.
	static String pigLatin = "";

	// Method to welcome the user
	public static void welcomeUser() {
		System.out.println(
				"Hello! Welcome to the Pig Latin Generator. You can enter any word or sentence, and we'll convert it to Pig "
						+ "Latin for you!");

		// Read the user input and perform some logic on it
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		// Here, we call the createPigLatin function and pass input as a parameter
		PigLatinGenerator.createPigLatin(input);
		
	}

	// Method to take user input and create Pig Latin

	public static String createPigLatin(String userString) {


		// We can use a delimiter to break the string up word by word since the user will have spaces between their words  
		String[] words = userString.split(" ");
		// we can traverse thru the array we made with the splitter, and for each
		// element, we can check if it
		// begins with a vowel.
		// if it does, we will add "hay" to the end of that element.

		

		// for each string in the array we perform the below logic 

		for (int i = 0; i < words.length; i++) { //iterating thru the array of strings we got from using .split
			
			// We need to check if the word is only one letter long or zero letters long. If
			// so, we will leave it
			// alone. Otherwise we will throw an indexOutOfBounds error by trying to do
			// logic on the first and second characters of the word.
			// why? because the first and second characters of a word do not exist on one
			// letter strings or non-letter strings (duh).

			if (words[i].length() == 1 || words[i].length() == 0) {
				continue;
			}

			
			// Condition 1: If the first letter of a word is a vowel.
			// We are checking the ASCII value of words[i].charAt(0) to see if it is a
			// vowel.
			// if the charAt [0] is a vowel, add "hay" to end of the word

			try {

				if (words[i].charAt(0) == 65 || words[i].charAt(0) == 69 || words[i].charAt(0) == 73
						|| words[i].charAt(0) == 79 || words[i].charAt(0) == 85 || words[i].charAt(0) == 97
						|| words[i].charAt(0) == 101 || words[i].charAt(0) == 105 || words[i].charAt(0) == 111
						|| words[i].charAt(0) == 117) {
					
					//We also want to support the user's punctuation. Here we check the ascii value of each character in each string
					//if it has a value of a punctuation mark we want to save,
					//then we cut the string one character short using .substring  and add the punctation character back to it after we have done the piglating logic on it  
					String punct = ""; //variable we will use to store value of a punctuation element if we need to remove it from the word 
					for (Character c : words[i].toCharArray()) { //iterating thru the string char by char
						if (c == 33 || c == 44 || c == 46 || c == 63) {
							punct = punct + c;
							words[i] = words[i].substring(0, words[i].length() - 1); // We are using the substring
																						// method here to remove a
																						// punctuation element
						}

					}
					words[i] = words[i] + "hay" + punct; //Here we are reconstructing the string by adding "hay" and adding to the end of this string, the punctuation mark we removed earlier.

					// Condition 2: If the word begins with a consonant and a vowel
					// We are checking the ASCII value of words[i].chaarAt(0) to see if it is a
					// consonant first
				} else if (words[i].charAt(0) >= 66 && words[i].charAt(0) <= 122 && words[i].charAt(0) != 65
						&& words[i].charAt(0) != 69 && words[i].charAt(0) != 73 && words[i].charAt(0) != 79
						&& words[i].charAt(0) != 85 && words[i].charAt(0) != 97 && words[i].charAt(0) != 101
						&& words[i].charAt(0) != 105 && words[i].charAt(0) != 111 && words[i].charAt(0) != 117) {

					// We don't want to immediately perform anything, because we still dont know if
					// this word starts
					// with a consonant and then a vowel, or if it has two consecutive consonants.
					// Here, we check if the letter after words[i].charAt(0) is also a consonant

					// If the word has two consecutive consonants, then we perform condition 3 of
					// Pig Latin logic on it
					// else, we just perform condition 2 logic
					if (words[i].charAt(1) == 65 || words[i].charAt(1) == 69 || words[i].charAt(1) == 73
							|| words[i].charAt(1) == 79 || words[i].charAt(1) == 85 || words[i].charAt(1) == 97
							|| words[i].charAt(1) == 101 || words[i].charAt(1) == 105 || words[i].charAt(1) == 111
							|| words[i].charAt(1) == 117) {
						
						String punct = "";
						// We're only doing this piece of code if the letter following the consonant is
						// a vowel:

						for (Character c : words[i].toCharArray()) {
							if (c == 33 || c == 44 || c == 46 || c == 63) {
								punct = punct + c;
								words[i] = words[i].substring(0, words[i].length() - 1); // We are using the substring
																							// method here to remove a
																							// punctuation element
							}

						}

						String consonant1 = "";
						consonant1 = consonant1 + words[i].charAt(0);
						
						//we are going to reconstruct the string words[i], this time with piglatin applied to it
						String oldString = words[i];
						String newString = "";

						// only doing this for loop if the next letter is a vowel

						for (int j = 1; j < oldString.length(); j++) {
							newString = newString + oldString.charAt(j);
						}
						words[i] = newString + consonant1 + "ay" + punct;

						// one more conditional to check if the new words[i] has another consonant
						// if it does, we

					}

					else if (words[i].charAt(1) >= 66 && words[i].charAt(1) <= 122 && words[i].charAt(1) != 65
							&& words[i].charAt(1) != 69 && words[i].charAt(1) != 73 && words[i].charAt(1) != 79
							&& words[i].charAt(1) != 85 && words[i].charAt(1) != 97 && words[i].charAt(1) != 101
							&& words[i].charAt(1) != 105 && words[i].charAt(1) != 111 && words[i].charAt(1) != 117) {

						// remove also words[i].charAt(1) and add to the end
						String punct = "";

						for (Character c : words[i].toCharArray()) {
							if (c == 33 || c == 44 || c == 46 || c == 63) {
								punct = punct + c;
								words[i] = words[i].substring(0, words[i].length() - 1); // We are using the substring
																							// method here to remove a
																							// punctuation element
							}

						}

						String consonant1 = "";
						String consonant2 = ""; // adding a second letter to the same logic as above (  since in the case of a word having two consonants to start we want to remove both,
						//we need two variables to store  the removed characters.
						consonant1 = consonant1 + words[i].charAt(0);
						consonant2 = consonant2 + words[i].charAt(1);
						
						//we are going to reconstruct the string words[i], this time with piglatin applied to it
						String oldString = words[i];
						String newString = "";

						for (int j = 2; j < oldString.length(); j++) {
							newString = newString + oldString.charAt(j);
						}
						words[i] = newString + consonant1 + consonant2 + "ay" + punct;

					}

					// If none of the conditions are met, just continue. if the word uses non-letter
					// characters at the beginning we want to leave it alone because
					// those types of words are non-pig-latinable
				} else {
					continue;
				}

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("String index out of bounds line 259. string length is: " + words[i].length());
			}
		}

		// iterate thru array and fill each element into pigLatin value

		for (int i = 0; i < words.length; i++) {
			pigLatin = pigLatin + words[i] + " ";
		}

		return pigLatin;

	}

	// method to print Pig Latin

	public static void printPigLatin() {
		System.out.println("Oink oink...\n" + pigLatin);
	}

	public static void main(String[] args) {

		// We use the .welcomeUser method to get us the user input
		welcomeUser();

		// Once the user input has been received and converted appropriately by using
		// the .createPigLatin method called by
		// .welcomeUser, we print the change made to the static String variable
		// pigLatin.
		printPigLatin();
	}

}
