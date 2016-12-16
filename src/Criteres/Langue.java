package Criteres;

import Score.ScoreChoixMult;

public class Langue extends CritereFaible implements ScoreChoixMult {
	private String[] values ;						//a voir si on fait un tableau de bool ou comme ca
	
	public Langue(String[] s) {
		for(int i=0; i<4; i++)
			this.values[i] = s[i] ;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}
}
