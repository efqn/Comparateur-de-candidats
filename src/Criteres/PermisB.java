package Criteres;

import Score.ScoreChoixSimple;

public class PermisB extends CritereFaible implements ScoreChoixSimple {
	private boolean value ;
	
	public PermisB(boolean value) {
		this.value = value ;
	}
	
	public String getContent() {
		return "ok" ;
	}
	
	public String toString() {
		return String.valueOf(value) ;
	}

	/**
	 * Calcul du score :
	 * 
	 * Si ce critere n'a pas d'importance, le score sera de 100.
	 * 
	 * Sinon :
	 * 		- 100 si value = true
	 * 		- 0   sinon
	 * 
	 */
	public int getScore(boolean flag, String s) {
		int baseScore = 100 ;
		
		if( flag )
			return value? baseScore : 0 ;
		else
			return baseScore ;
	}
}
