package Criteres;

import Score.ScoreChoixSimplePond;

public class NiveauEtude extends CritereFaible implements ScoreChoixSimplePond {
	private String value ;
	
	public NiveauEtude(String s) {
		this.value = s ;
	}
}
