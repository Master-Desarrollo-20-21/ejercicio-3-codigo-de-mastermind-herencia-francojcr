package es.escuelait.poo.practica2v2;

public class Game {

	private SecretCombination secretCombination;
	private Attempt[] attempts;
	private boolean hasWon;
	private int lastAttempt;
	
	static final int MAX_ATTEMPTS = 10;

	public void play() {
		
		secretCombination = new SecretCombination();
		attempts = new Attempt[MAX_ATTEMPTS];
		lastAttempt = 0;
		hasWon = false;
		
		do {
			attempts[lastAttempt] = new Attempt();
			attempts[lastAttempt].play(secretCombination);
			this.showAttempts();
			lastAttempt++;
		} while (lastAttempt < attempts.length && !attempts[lastAttempt-1].isWinner());
	
		hasWon = attempts[lastAttempt-1].isWinner();
	}


	private void showAttempts() {
		for (int i=0; i <= lastAttempt ; i++) {
			attempts[i].show();
		} 
	}


	public boolean hasWon() {
		return hasWon;
	}


}
