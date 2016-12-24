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
	 * 		si value == s, 100
	 * 		sinon 0
	 */
	public int getScore(String s) {
		return this.value.equals(s)? 100 : 0 ;
	}
}
