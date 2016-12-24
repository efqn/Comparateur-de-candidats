package Criteres;

import Score.ScoreChoixMult;

public class Langue extends CritereFaible implements ScoreChoixMult {
	private String values ;						//a voir si on fait un tableau de bool ou comme ca
	
	public Langue(String s) {
			this.values = s ;
	}
	
	public String getContent() {
		return values ;
	}
	
	public String toString() {
		return values ;
	}
}
