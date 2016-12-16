package Criteres;

import Score.ScoreChoixSimple;

public class PermisB extends CritereFaible implements ScoreChoixSimple {
	private boolean value ;
	
	public PermisB(boolean value) {
		this.value = value ;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
