package Criteres;

import Score.ScoreChoixSimple;

public class Region extends CritereFaible implements ScoreChoixSimple {
	private String value ;
	
	public Region(String s) {
		this.value = s ;
	}
}
