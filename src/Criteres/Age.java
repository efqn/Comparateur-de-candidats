package Criteres;

import Score.ScoreIntervalle;

public class Age extends CritereFaible implements ScoreIntervalle {
	private String value ;
	
	public Age(String s) {
		this.value = s ;
	}
}
