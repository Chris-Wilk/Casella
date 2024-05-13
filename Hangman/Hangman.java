/* *
 * Assignment 03 Arrays Review 2
 * @author Chris Wilk
 * @date: 14 September 2023
 * @assignment CIS 203, Assignment 02, Fall 2023
 **/
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	static int timesRan = 0;

	public static void main(String[] args) {
		file(); 


	}
	
	/**
	 * the file method will initialize the scanner and start with asking the user for the file name
	 * it will then call the next method to start the game if the file exists.
	 * 
	 * @param none
	 * @throws fileNotFound
	 **/
	public static void file() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Which fild do you want to use? ");
			String name = input.next();	
			Scanner file = new Scanner(new File(name));
			Game(input, Word(array1(file)));
			System.out.print("Do you want to play again? yes/no: ");
			playAgain(input);
			}
		catch(Exception e) {
			System.out.println("Error" + e);
			e.printStackTrace();
			System.exit(2);
		}
	}
	
	/**
	 * The array1 method will be called by file when if the file exists and create an array including
	 * all of the strings in the file. It will take the file and create an array based on how
	 * many words are in it.
	 * 
	 * @param filename the file inputed by the user
	 * @return all of the words in the file in an array
	 **/
	public static String[] array1(Scanner filename) {
		String[] totalWords = new String[100];
		int count = 0;
		while (filename.hasNext() && count < totalWords.length) {
            totalWords[count++] = filename.next();
        }
		return totalWords;
	}
	
	/**
	 * the Word method is called in the file method when the game is ran. It will take the array
	 * from the array1 method and use random to select a random word from the array.
	 * 
	 * @param array1 for the method to select from
	 * @return the single word selected at random from the method
	 **/
	public static String Word (String[] array1) {
		String[] oldWords = new String[100];
		int count =0;
		for(int i =0; i < array1.length; i++) {
			if(array1[i] != null) {
				count++;
			}
		}
		Random rand = new Random();
		int RandomIndex =rand.nextInt(count);
		oldWords[timesRan] = array1[RandomIndex];
		return array1[RandomIndex];
	}
	
	/**
	 * the Game method will do the heavy lifting. This method will take the word from the Word method
	 * and play the game. It will create an array to store the correct guesses from the user
	 * along with integers to keep track of how many guesses the user has done, how many of those
	 * guesses have been wrong, and the maximum wrong guesses the user is allowed. After that the 
	 * program will prompt the user for a character and if it is only one letter long and not an integer
	 * the program will check to see if it is in the word. if it is the program will display that and ask
	 * for a new one. if it is wrong the program will display it in the wrong guesses and display
	 * all wrong guesses. once all guesses are used or the user guesses the words the program 
	 * will exit the method.
	 * 
	 * @param input for use of scanner
	 * @param word so the program knows what word to use for the game
	 **/
	public static void Game(Scanner input, String word) {
		int compare = 0;
		char[] tallies = new char[word.length()];
		Arrays.fill(tallies, '_');
		int wrongAttemps = 0;
		int maxwrongAttemps = 6;
		String[] wrongGuess = new String[6];	
		while(wrongAttemps < maxwrongAttemps) {
			System.out.print("Select a letter: ");
			String guess = input.next();
			boolean isDigit = digit(guess);
			System.out.println();
			while(guess.length() > 1 || isDigit) {
				System.out.print("Guesses must be one character long and a letter. Guess again: ");
				guess = input.next();
				isDigit = digit(guess);
			}
			int Correctcount = 0;
			for(int i = 0; i < word.length(); i ++) {
				if(guess.charAt(0) == word.charAt(i)) {
					Correctcount++;
				    tallies[i] = guess.charAt(0);
				}
			}
			if(Correctcount == 0) {
				for(int i = 0; i < maxwrongAttemps; i++) {
					while(guess.equals(wrongGuess[i])) {
						System.out.print("Please select a letter not arealy chosen: ");
						guess = input.next();
					}
				}
				wrongGuess[wrongAttemps] = guess;
				wrongAttemps++;
			}
			for(int i = 0; i < tallies.length; i ++) {
				System.out.print(tallies[i] + " ");
			}
			System.out.println();
			System.out.println("Wrong Guesses: " + wrongAttemps);
			System.out.print("Guesses: ");
			for(int i = 0; i < wrongAttemps; i++) {
				System.out.print(wrongGuess[i] + ", ");
			}
			System.out.println();
			if (Arrays.equals(tallies, word.toCharArray())) {
				System.out.println("You guessed the word: " + word);
				compare = 1;
				break;
			}
		}
		if(compare == 0) {
			System.out.println();
			System.out.println("No guesses left. The word was " + word);
		}

	}
	
	/**
	 * the playAgain method will ask the user if they want to play the game again and if they
	 * say yes it will call the file method to run the program all over again.
	 * 
	 * @param input passes scanner to the program so it can ask the user
	 **/
	public static void playAgain(Scanner input) {
		String response = input.next();
	    if(response.equals("yes")) {
	    	file();
	    }else {
	    	System.out.println("Thank you for playing!");
	    }
	}
	
	/**
	 * the digit method will take the guess from the user and make sure it is not a number.
	 * if it is the game method will ask the user for a new input.
	 * 
	 * @param guess the guess from the user to check if it is an int
	 * @return true or false if it is an int or not.
	 **/
	public static boolean digit(String guess) {
	       if (Character.isDigit(guess.charAt(0)) == true) {
	           return true;
	       }
	 
	        return false;
	    }
}