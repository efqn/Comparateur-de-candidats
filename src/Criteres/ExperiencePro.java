package Criteres;

import Score.ScoreChoixSimplePond;

public class ExperiencePro extends CritereFaible implements ScoreChoixSimplePond {
	private int value ;
	
	public ExperiencePro(int nb) {
		this.value = nb ;
	}
	
	/**
	 * Calcul du score :
	 * 			baseScore - ecart*facteur
	 * 
	 * L'ecart peut etre de 0, 1, 2, 3, 5 ou 7 (bac+2, +3, +5 ou +7).
	 * Si l'ecart est positif (plus d'exp que demande, i.e i < value), il n'y aura pas de points bonus. 
	 */
	public int getScore(boolean flag, int i) {
		this.baseScore = 200 ;
		this.facteur = 20 ;
		
		if( flag ) {
			if( this.value <= i )
				baseScore = baseScore - (i - this.value)*facteur ;
		}
		return baseScore ;
	}
	
	/**
	 * fonction commune a tous les criteres faibles.
	 * Appelle la bonne fonction getScore() qui effectuera le calcul du score
	 */
	public int getScore(CritereFaible critere, boolean flag) {
		return getScore(flag, Integer.parseInt(critere.getContent())) ;
	}
	
	public String getContent() {
		return String.valueOf(this.value) ;
	}
	
	public int getValue() {
		return this.value ;
	}
	
	public void setValue(int i) {
		this.value = i ;
	}
	
	public String toString() {
		return String.valueOf(this.value) ;
	}
}
