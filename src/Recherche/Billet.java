package Recherche;

import java.util.ArrayList;
import Candidat.Candidat;
import Criteres.Critere;

public class Billet {
	private Candidat candidat ;
	private ArrayList<Critere> criteres = new ArrayList<>(10) ;
	
	public Billet(Candidat candidat, ArrayList<Critere> criteres) {
		this.candidat = candidat ;
		this.criteres.addAll(criteres) ;
	}
}
