package Criteres;

import Score.ScoreChoixSimplePond;

public class ExperiencePro extends CritereFaible implements ScoreChoixSimplePond {
	private int nombre ;
	
	public ExperiencePro(int nb) {
		this.nombre = nb ;
	}
	
	public String getContent() {
		return String.valueOf(nombre) ;
	}
	
	public String toString() {
		return String.valueOf(nombre) ;
	}

	@Override
	public int getScore(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
