import java.util.Scanner;


public class Game {
	
	
	private static String word;
	private static int chances;
	private static Scanner kb = new Scanner(System.in);
	private static char letter;

	
	public static void main(String[] args)
	{
		beginGame();
	}
	
	public static void setWord()
	{	
		System.out.println("Player 1, enter a word for Player 2 to guess");
		word =  kb.next();
	}
	
	public static void loadInterface()
	{
		for(int i = 0; i < word.length(); i++)
		{		
			System.out.print("_ ");
		}
		System.out.println();
		System.out.println(" O ");
		System.out.println("-|-");
		System.out.println("You have " + chances + " chances left");
	}
	
	public static void beginGame()
	{
		
		setWord();
		loadInterface();
		guessLetter();
		
	}
	
	public static void guessLetter()
	{
		System.out.println("Enter a letter");
		letter = kb.next().charAt(0);
		
		if(word.contains(Character.toString(letter)))
		{
			System.out.println("Yeah, it's in there!");
		}
		else System.out.println("Nope, not in there.");
	}

}
