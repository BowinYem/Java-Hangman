import java.util.Scanner;


public class Game {
	
	
	private static String word;
	
	public static void main(String[] args)
	{
		setWord();
	}
	
	public static void setWord()
	{	
		Scanner kb = new Scanner(System.in);
		System.out.println("Player 1, enter a word for Player 2 to guess");
		word =  kb.next();
		kb.close();
	}
	
	public static void loadInterface()
	{
		
	}

}
