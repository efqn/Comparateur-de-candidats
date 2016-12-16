package Criteres;

import Score.ScoreChoixSimple;

public class PermisB extends CritereFaible implements ScoreChoixSimple {
	private boolean value ;
	
	public PermisB(boolean value) {
		this.value = value ;
	}
}
