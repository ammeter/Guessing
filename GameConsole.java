package week1;

import java.util.Scanner;
/**
 * Game of guessing a secret number
 * @author Pannapat panpakdee
 */
public class GameConsole {
/**
 * The play method plays a game using input from a user
 * @param game is new object of guessing game
 * @return Return the correct number
 */
	public int play(Game game){
		Scanner s = new Scanner(System.in);
		int number = 0;
		System.out.println("Guessing Game");
		System.out.println("Your Guess?");
		do{
			System.out.println(game.getHint());
			number = s.nextInt();	
		}
		while(!game.guess(number));
		System.out.println(game.getHint());
		return number;
	}
	/** Create objects and start the game */
	public static void main(String[] args){
		Game game = new Game(10);
		GameConsole ui = new GameConsole();
		ui.play(game);
		//
	}
}