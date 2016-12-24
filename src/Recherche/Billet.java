package Recherche;

import java.util.ArrayList;
import Candidat.Candidat;
import Criteres.Critere;
import Score.ScoreFinal;

public class Billet implements ScoreFinal {
	private Candidat candidat ;
	private ArrayList<Critere> criteres = new ArrayList<>(10) ;
	private int score = 0;
	
	public Billet(Candidat candidat, ArrayList<Critere> criteres) {
		this.candidat = candidat ;
		this.criteres.addAll(criteres) ;
	}
	
	public void afficher() {
		System.out.println("");
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	public int getScore() {
		return this.score ;
	}
	
	/// a voir 
	public ArrayList<Critere> getCriteres() {
		return criteres;
	}

	public void setCriteres(ArrayList<Critere> criteres) {
		this.criteres = criteres;
	}
	////

	@Override
	public String toString() {
		return "Billet [candidat=" + candidat + ", criteres=" + criteres + "]";
	}

	/*@Override
	public int getScore(int borneInf, int borneSup) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
}
