package Criteres;

import Score.ScoreChoixSimple;

public class Region extends CritereFaible implements ScoreChoixSimple {
	private String value ;
	
	public Region(String s) {
		this.value = s ;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
