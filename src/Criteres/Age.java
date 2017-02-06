package Criteres;

import Score.ScoreIntervalle;

public class Age extends CritereFaible implements ScoreIntervalle {
	private int value ;
	private int borneInf ;
	private int borneSup ;
	
	//Constructeur cote client
	public Age(int age) {
		this.value = age ;
		this.borneInf = value ;
		this.borneSup = value ;
	}
	

	//Constructeur cote recruteur
	public Age(int borneInf, int borneSup) {
		this.borneInf = borneInf ;
		this.borneSup = borneSup ;
		this.value = -1 ;
	}
	
	/**
	 * Calcul du score :
	 * 		 baseScore - (ecart avec les bornes)
	 * 		
	 * ecart avec les bornes : chaque ecart de 1 avec les bornes diminue de 1*facteur le baseScore
	 * 		--> si ecartMax est atteint, le score devient 0
	 */
	public int getScore(boolean flag, int borneInf, int borneSup) {
		this.baseScore = 150 ;
		this.facteur = 15 ;
		int ecartMax = 10 ;

		if( flag ) {
			if( this.value > borneSup || this.value < borneInf ) {
				int res = Math.abs(value);
				if( this.value < borneInf )
					res = borneInf - this.value ;
				else
					res = value - borneSup ;
				
				return res < ecartMax ? (baseScore - res*facteur) : 0 ;	
			}
		}
		
		return baseScore ;
	}
	
	/**
	 * fonction commune a tous les criteres faibles.
	 * Appelle la bonne fonction getScore() qui effectuera le calcul du score
	 */
	public int getScore(CritereFaible critere, boolean flag) {
		Age age = (Age)critere ;
		return this.getScore(flag, age.getBorneInf(), age.getBorneSup()) ;
	}
	
	
	//Valeur cote client. Pour avoir la 'fourchette' du cote du recruteur, utiliser les get/set specifiques
	public String getContent() {
		return String.valueOf(this.value) ;
	}
	
	public int getValue() {
		return this.value ;
	}
	
	public int getBorneInf() {
		return this.borneInf ;
	}
	
	public int getBorneSup() {
		return this.borneSup ;
	}
	
	public void setBorneInf(int i) {
		this.borneInf = i ;
	}
	
	public void setBorneSup(int i) {
		this.borneSup = i ;
	}
	
	public void setValue(int i) {
		this.value = i ;
	}
	
	public String toString() {
		return "Value = "+String.valueOf(this.value)+", BorneInf = "+this.borneInf+", BorneSup = "+this.borneSup ;
	}
}
