package es.escuelait.poo.practica2v2;

public class Attempt {
	
	ProposeCombination proposeCombination;
	int blacks, whites;

	public Attempt() {
		proposeCombination = new ProposeCombination();
	}
	
	public void play(SecretCombination secretCombination) {
		proposeCombination.getProporsal();
		this.setComparation(secretCombination);		
	}

	private void setComparation( SecretCombination secretCombination) {
		blacks = proposeCombination.getBlacks(secretCombination);
		whites = proposeCombination.getWhites(secretCombination);
	}

	public boolean isWinner() {
		// TODO Auto-generated method stub
		return (blacks == 4);
	}

	public void show() {
		GestorIO gestoIO =  new GestorIO();
		
		gestoIO.out(proposeCombination.toString() + " -->  "+ blacks + " blacks  and " + whites + " whites\n");
	}
	

}
