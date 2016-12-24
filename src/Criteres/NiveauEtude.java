package Criteres;

import Score.ScoreChoixSimplePond;

public class NiveauEtude extends CritereFaible implements ScoreChoixSimplePond {
	private int value ;
	private int score ;
	
	public NiveauEtude(int value) {
		this.value = value ;
	}
	
	public String getContent() {
		return String.valueOf(value) ;
	}
	
	public String toString() {
		return String.valueOf(value) ;
	}

	/**
	 * Calcul du score :
	 * 	
	 */
	public int getScore(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
