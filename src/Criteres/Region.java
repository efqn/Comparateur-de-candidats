package Criteres;

import Score.ScoreChoixSimple;

public class Region extends CritereFaible implements ScoreChoixSimple {
	private String value ;
	private int score ;
	
	public Region(String s) {
		this.value = s ;
	}
	
	public String getContent() {
		return value ;
	}
	
	public String toString() {
		return value ;
	}

	/**
	 * Calcul du score :
	 * 
	 * Si ce critere n'a pas d'importance, le score sera de 100.
	 * 
	 * Sinon :
	 * 		- 100 si s == value
	 * 		- 0   sinon
	 * 
	 */
	public int getScore(boolean flag, String s) {
		int baseScore = 100 ;
		
		if( flag )
			return this.value.equals(s)? baseScore : 0 ;
		else
			return baseScore ;
	}
}
