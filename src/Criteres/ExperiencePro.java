package Criteres;

import Score.ScoreChoixSimplePond;

public class ExperiencePro extends CritereFaible implements ScoreChoixSimplePond {
	private int nombre ;
	
	public ExperiencePro(int nb) {
		this.nombre = nb ;
	}
}