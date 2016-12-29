package Criteres;

import Score.ScoreChoixSimple;

public class Region extends CritereFaible implements ScoreChoixSimple {
	private String value ;
	
	public Region(String s) {
		this.value = s ;
	}

	/**
	 * Calcul du score :
	 * 
	 * Si ce critere n'a pas d'importance, le score = baseScore.
	 * 
	 * Sinon :
	 * 		- baseScore si s == value
	 * 		- 0   sinon
	 */
	public int getScore(boolean flag, String s) {
		this.baseScore = 150 ;
		
		if( flag )
			return this.value.equals(s)? baseScore : 0 ;
		else
			return baseScore ;
	}
	
	public int getScore(CritereFaible critere, boolean flag) {
		return getScore(flag, critere.getContent()) ;
	}
	
	public String getContent() {
		return value ;
	}
	
	public String getValue() {
		return getContent() ;
	}
	
	public void setValue(String s) {
		this.value = s ;
	}
	
	public String toString() {
		return value ;
	}
}
