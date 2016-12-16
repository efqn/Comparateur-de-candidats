package Recherche;

import Criteres.Critere;

public class Demande {
	private Critere[] recherche ;
	private Billet[] resultats ;
	
	public Demande(Critere[] criteres) {
		for(int i=0; i<8; i++)
			this.recherche = criteres ;
	}
}
