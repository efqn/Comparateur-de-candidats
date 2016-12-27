package Criteres;

import Score.ScoreChoixSimplePond;

public class ExperiencePro extends CritereFaible implements ScoreChoixSimplePond {
	private int value ;
	
	public ExperiencePro(int nb) {
		this.value = nb ;
	}
	
	public String getContent() {
		return String.valueOf(value) ;
	}
	
	public String toString() {
		return String.valueOf(value) ;
	}

	/**
	 * Calcul du score :
	 * 			baseScore - ecart*facteur
	 * 
	 * L'ecart peut etre de 0, 1, 2, 3, 5 ou 7 (bac+2, +3, +5 ou +7).
	 * Si l'ecart est positif (plus d'exp que demande), il n'y aura pas de points bonus. 
	 */
	public int getScore(boolean flag, int i) {
		int baseScore = 100 ;
		int facteur = 10 ;
		
		if( flag )
			baseScore = baseScore - (i - this.value)*facteur ;
		return baseScore ;
	}
}
