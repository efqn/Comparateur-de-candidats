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
}
