package es.escuelait.poo.practica2v2;

public class Combination {
	
	static final int COMBINATION_SIZE = 4;
	char[] validColors = {'r','b','y','g','o','p'};
	char[] combination;
	
	public void setCombination(String colors) {
		this.combination[0] = colors.charAt(0);
		this.combination[1] = colors.charAt(1);
		this.combination[2] = colors.charAt(2);
		this.combination[3] = colors.charAt(3);
	}

	public Combination() {
		combination = new char[COMBINATION_SIZE]; 
	}
	
	public void readCombination() {
		String colors;
		GestorIO gestoIO =  new GestorIO();
		
		do {
			gestoIO.out("Propose a combination:");
			colors = gestoIO.inString();
		} while (!isValid(colors));
		
		this.setCombination(colors);
	}
	
	private boolean isValid(String input) {
		GestorIO gestoIO =  new GestorIO();
		
		if (input.length() != COMBINATION_SIZE) {
			gestoIO.out("Wrong proposed combination length\n");
			return false;
		}
		
		int position = 0;
		while (position < COMBINATION_SIZE && isColorValid(input.charAt(position))) {
			position++;
		}
		
		if (position != COMBINATION_SIZE) {
			gestoIO.out("Wrong colors, they must be: rbygop\n");
			return false;
		} else {
			return true;			
		}
	}

	private boolean isColorValid(char color) {
		
		for(int i=0;i < validColors.length;i++) {
			if (color == validColors[i]) {
				return true;
			}
		}
		
		return false;
	}

	public int getBlacks(SecretCombination secretCombination) {
		int blacks = 0;
		
		for(int i = 0;i < COMBINATION_SIZE;i++) {
			if (this.getPos(i) == secretCombination.getPos(i)) {
				blacks++;
			}
		}		
		return blacks;
	}

	public int getWhites(SecretCombination secretCombination) {
		int whites = 0;
		
		for(int i = 0;i < COMBINATION_SIZE;i++) {
			for(int j = 0; j < COMBINATION_SIZE;j++) {
				if (i != j && this.getPos(i) == secretCombination.getPos(j)) {
					whites++;
				}
			}
		}
		return whites;
	}	

	public char getPos(int position) {
		return this.combination[position];
	}
	
	public String toString() {
		String colors = "";
		
		for(int i = 0;i < COMBINATION_SIZE;i++) {
			colors =  colors.concat(Character.toString(this.combination[i]));
		}
		
		return colors;
	}
}
