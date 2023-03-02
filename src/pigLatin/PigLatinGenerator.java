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
		// for each string in the array we perform the below logic 

		for (int i = 0; i < words.length; i++) { //iterating thru the array of strings we got from using .split

			if (words[i].length() == 1 || words[i].length() == 0) {
				continue;
			}

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
							words[i] = words[i].substring(0, words[i].length() - 1); 
						}

					}
					words[i] = words[i] + "hay" + punct; //Here we are reconstructing the string by adding "hay" and adding to the end of this string, the punctuation mark we removed earlier.

					
				} else if (words[i].charAt(0) >= 66 && words[i].charAt(0) <= 122 && words[i].charAt(0) != 65
						&& words[i].charAt(0) != 69 && words[i].charAt(0) != 73 && words[i].charAt(0) != 79
						&& words[i].charAt(0) != 85 && words[i].charAt(0) != 97 && words[i].charAt(0) != 101
						&& words[i].charAt(0) != 105 && words[i].charAt(0) != 111 && words[i].charAt(0) != 117) {

					
					
					if (words[i].charAt(1) == 65 || words[i].charAt(1) == 69 || words[i].charAt(1) == 73
							|| words[i].charAt(1) == 79 || words[i].charAt(1) == 85 || words[i].charAt(1) == 97
							|| words[i].charAt(1) == 101 || words[i].charAt(1) == 105 || words[i].charAt(1) == 111
							|| words[i].charAt(1) == 117) {
						
						String punct = "";
					

						for (Character c : words[i].toCharArray()) {
							if (c == 33 || c == 44 || c == 46 || c == 63) {
								punct = punct + c;
								words[i] = words[i].substring(0, words[i].length() - 1); 
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
								words[i] = words[i].substring(0, words[i].length() - 1); 
							}

						}

						String consonant1 = "";
						String consonant2 = ""; 
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
