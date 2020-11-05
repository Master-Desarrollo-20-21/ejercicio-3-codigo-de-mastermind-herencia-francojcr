package es.escuelait.poo.practica2v2;

class Mastermind {
	  private Game game;

	  public Mastermind(){
	    this.game = new Game();
	  }

	  private void play() {
	    do {
	      this.game.play();
	      
	      if (this.game.hasWon()) {
	    	  this.celebrate();
	      }
	      
	    } while(this.isResumed());
	  }

	  private void celebrate() {
		  GestorIO gestoIO =  new GestorIO();
		  
		  gestoIO.out("You've won!!! ;-)\n");
		
	}

	private boolean isResumed() {
	    String answer;
	    GestorIO gestoIO =  new GestorIO();
	    do {
	    	gestoIO.out("¿Quieres continuar? (s/n): ");
	    	answer = gestoIO.inString();
	    } while (!answer.equals("s") && !answer.equals("n"));
	    return answer.equals("s");
	  }

	  public static void main(String[] args) {
	    new Mastermind().play();
	  }
}
