package Criteres;

import Score.ScoreChoixSimple;

public class PermisB extends CritereFaible implements ScoreChoixSimple {
	private boolean value ;
	
	public PermisB(boolean value) {
		this.value = value ;
	}

	/**
	 * Calcul du score :
	 * 
	 * Si ce critere n'a pas d'importance, score = baseScore.
	 * 
	 * Sinon :
	 * 		- baseScore si value = true
	 * 		- 0   sinon
	 */
	public int getScore(boolean flag, String s) {
		if( flag )
			return value? baseScore : 0 ;
		else
			return baseScore ;
	}
	
	/**
	 * fonction commune a tous les criteres faibles.
	 * Appelle la bonne fonction getScore() qui effectuera le calcul du score
	 */
	public int getScore(CritereFaible critere, boolean flag) {
		return getScore(flag, critere.getContent()) ;
	}
	
	public String getContent() {
		return ( value ? "Oui" : "Non") ;
	}
	
	public boolean getValue() {
		return this.value ;
	}
	
	public void setValue(boolean b) {
		this.value = b ;
	}
	
	public String toString() {
		return String.valueOf(value) ;
	}
}
