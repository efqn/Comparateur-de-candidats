package Recherche;

import Criteres.Critere;

public class Demande {
	private Critere[] recherche ;
	private Billet[] resultats ;
	
	public Demande(Critere[] criteres) {
		for(int i=0; i<8; i++)
			this.recherche = criteres ;
	}

	public Critere[] getRecherche() {
		return recherche;
	}

	public void setRecherche(Critere[] recherche) {
		this.recherche = recherche;
	}

	public Billet[] getResultats() {
		return resultats;
	}

	public void setResultats(Billet[] resultats) {
		this.resultats = resultats;
	}
}
