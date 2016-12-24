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
	 * 		- 100 si value = true
	 * 		- 0   sinon
	 * 
	 */
	public int getScore(String s) {
		return value? 100 : 0 ;
	}
}
