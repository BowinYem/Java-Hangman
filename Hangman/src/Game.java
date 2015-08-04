import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	
	
	private static String word;
	private static char[] progress;
	private static ArrayList<Character> guessedLetters = new ArrayList<Character>();
	private static int chances = 6;
	private static Scanner kb = new Scanner(System.in);
	private static String letter;
	private static boolean twoPlayers = false;
		
	public static void main(String[] args)
	{
		playGame();
		kb.close();
	}
	
	public static void playerSetWord()
	{	
		
		while(true)
		{
			System.out.println("Player 1, enter a word for Player 2 to guess. Must be a valid word.");
			word =  kb.next();		
			if(isWord(word)) break;
			else System.out.println("Word is not valid.");
		}
	}
	
	public static void aiSetWord()
	{
		word = RandomWord.getWord();
	}
	
	public static boolean isWord(String word)
	{
		return word.matches("[a-zA-Z]+");
	}
	
	public static boolean validGuess(String guess)
	{
		return guess.length() == 1 && guess.matches("[a-zA-Z]+");
	}
		
	public static void playGame()
	{
		
		System.out.println("1 player or 2 players?");
		
		if(twoPlayers) playerSetWord();
		else aiSetWord();
	
		progress = new char[word.length()];
		for(int i = 0; i < word.length(); i++)
		{
			progress[i] = '_';
		}
		
		while(chances != 0)
		{
			if(checkWin())
			{
				updateInterface();
				System.out.println("YOU WIN");
				return;	
			}
			updateInterface();
			guessLetter();
		}		
		
		updateInterface();
		System.out.println("GAME OVER. The word was: " + word);
	}
	
	public static boolean checkWin()
	{
		if(!new String(progress).contains("_"))
		{
			return true;
		}
		else return  false;
	}
	
	public static void updateInterface()
	{
		System.out.println("__________________");
		
		for(int i = 0; i < word.length(); i++)
		{
			System.out.print(progress[i] + " ");
			
		}
		System.out.println();
		loadStickman();
		System.out.println("You have " + chances + " chances left");
		System.out.println("Letter's you've guessed:");
		System.out.println(guessedLetters.toString());
		System.out.println("__________________");
	}
	
	public static void guessLetter()
	{
		while(true)
		{
			System.out.println("Enter a letter");
			letter = kb.next();
			if(validGuess(letter)) break;
			else System.out.println("That's not a letter");
		}

	
		if(word.contains(letter))
		{
			System.out.println("Yeah, it's in there!");
			updateProgress(letter);
		}
		else
		{
			System.out.println("Nope, not in there.");
			chances--;

		}
		
		guessedLetters.add(letter.charAt(0));

	}
	
	public static void updateProgress(String c)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == c.charAt(0))
			{
				progress[i] = c.charAt(0);
			}
		}
	}
	
	public static void loadStickman()
	{
		switch(chances){
			
		case 0: 
			System.out.println(" O");
			System.out.println("-|-");
			System.out.println("||");
			break;
		case 1:
			System.out.println(" O");
			System.out.println("-|-");
			System.out.println("|");
			break;
		case 2:
			System.out.println(" O");
			System.out.println("-|-");
			break;
		case 3:
			System.out.println(" O");
			System.out.println("-|");
			break;
		case 4:
			System.out.println("O");
			System.out.println("|");
			break;
		case 5:
			System.out.println("O");
			break;
						
		}
		
	}

}
