package Criteres;

import Score.ScoreIntervalle;

public class Age extends CritereFaible implements ScoreIntervalle {
	private String value ;
	private int score ;
	
	public Age(String s) {
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
	 * 		 baseScore - (ecart avec les bornes)
	 * 		
	 * ecart avec les bornes : chaque ecart de 1 avec les bornes diminue de 1*facteur le baseScore
	 * 		--> si ecartMax est atteint, le score devient 0
	 */
	public int getScore(int borneInf, int borneSup) {
		int value = Integer.parseInt(this.value) ;
		int baseScore = 100 ;
		int facteur = 10 ;
		int ecartMax = 10 ;

		if( value <= borneSup && value >= borneInf )
			return baseScore ;
		else {
			int res = Math.abs(value);
			if( value < borneInf )
				res = borneInf - value ;
			else
				res = value - borneSup ;
			
			return res < ecartMax ? (baseScore - res*facteur) : 0 ;										
		}
	}
}
