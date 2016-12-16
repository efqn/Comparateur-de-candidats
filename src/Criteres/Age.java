package Criteres;

import Score.ScoreIntervalle;

public class Age extends CritereFaible implements ScoreIntervalle {
	private String value ;
	
	public Age(String s) {
		this.value = s ;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
