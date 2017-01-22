package week1;

import java.util.Random;
/**
 * Game of guessing a secret number
 * @author Pannapat Panpakdee
 */
public class Game {
	/* properties of a guessing game*/
	private int upperBound;
	private int secret;
	private String hint;
	private int cnt = 1;
	/**
	 * Initialize a new game
	 * @param upperBound is the max value for the secret number (>1)
	 */
	public Game(int upperBound){
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and "+upperBound+".";
	}
	/**
	 * Create a random number between 1 and limit
	 * @param limit is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	private int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis( );
		Random rand = new Random( seed );
		return rand.nextInt(limit) + 1;
	}
	/**
	 * Check the number that user guess.
	 * @param number is the value that the user guess
	 * @return ture if the number is correct, false if the number is wrong.
	 */
	public boolean guess(int number){
		if(number == this.secret){
			this.hint = "Correct. You used "+this.cnt+" guesses.";
			return true;
		}
		else if(number > this.secret){
			this.hint = "Sorry, your guess is too large.";
			this.cnt++;
		}
		else if(number < this.secret){
			this.hint = "Sorry, your guess is too small.";
			this.cnt++;
		}
		return false;
	}
	/**
	 * Set Hint
	 * @param hint will show what user should guess next
	 */
	public void setHint(String hint){
		this.hint = hint;
	}
	/**
	 * Return how many time that user guess the number
	 * @return the time that user guess
	 */
	public int getCount(){
		return this.cnt;
	}
	/**
	 * Return a hint based on the most recent guess.
	 * @return hint based on most recent guess
	 */
	public String getHint(){
		return this.hint;
	}
}
