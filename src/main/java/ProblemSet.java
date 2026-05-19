import java.util.HashMap;
import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		//declaring counters
		String text;
		int charCount;
		int wordCount;
		int vowelCount;
		int spaceCount;

		//introduction
		System.out.println("Welcome to the Text Analyzer.\n");
		System.out.print("Input a sentence or paragraph: ");

		//getting input and remove unecessary spaces
		text = input.nextLine();
		text = text.trim();

		//initializing the count for characters
		charCount = text.length();

		//accounting for an empty input
		if (text.length() == 0) {
			wordCount = 0;
			spaceCount = 0;

		} else {
			spaceCount = 0;
		}
		
		//initializing the count for spaces
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				spaceCount++;
			}
		}

		//initializing the count for words
		wordCount = spaceCount + 1;


		vowelCount = 0;

		//initializing the count for vowels
		for (int i = 0; i < text.length(); i++) {
			char c = Character.toLowerCase(text.charAt(i));

			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowelCount++;
			}
		}

		//printing the counts
		System.out.println("\nTotal Characters: " + charCount);
		System.out.println("Total Words: " + wordCount);
		System.out.println("Total Vowels: " + vowelCount);
		System.out.println("Total Spaces: " + spaceCount);

		//Word Frequency Option 2
		
		//replacing punctuation and setting everything to lowercase
		text = text.toLowerCase();
		text = text.replaceAll("[,!?.]", "");
		
		//spliting at spaces to get words as seperate arrays
		String[] words = text.split(" ");
	
		//creating an empty HashMap
		HashMap<String, Integer> frequency = new HashMap<String, Integer>();

		//ignoring common words and finding how many of each word show up
		for (int i = 0; i < words.length; i++) {

			String word = words[i];

           	//filters out empty strings, common words, and counts frequency
			if (word.length() > 0) {

				if (!(word.equals("a") || word.equals("an") || word.equals("and") || word.equals("the") || word.equals("is"))) {

					if (frequency.containsKey(word)) {
						frequency.put(word, frequency.get(word) + 1);
				} else {
					frequency.put(word, 1);
				}
			}
		}
	}
		//printing the frequency
		System.out.println("\nWord Frequency:\n");

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			if (word.length() > 0) {
				
				//using boolean to print so that only when conditions are met
				boolean alreadyPrinted;
				alreadyPrinted = false;
				
				
				for (int j = 0; j < i; j++) {
					if (words[j].equals(word)) {
						alreadyPrinted = true;
					}
				}

					if (!alreadyPrinted) {
						System.out.println(word + ": " + frequency.get(word));
					}
				}
			}
		}


	}
