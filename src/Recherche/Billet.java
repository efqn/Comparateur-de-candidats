package Recherche;

import Candidat.Candidat;
import Criteres.Critere;

public class Billet {
	private Candidat candidat ;
	private Critere[] criteres ;		//Arraylist ?
	
	public Billet(Candidat candidat, Critere criteres) {
		this.candidat = candidat ;
		for(int i=0; i<8; i++)
			this.criteres[i] = criteres ;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Critere[] getCriteres() {
		return criteres;
	}

	public void setCriteres(Critere[] criteres) {
		this.criteres = criteres;
	}
	
	
}
