package Recherche;

import java.util.ArrayList;

import Criteres.Critere;

public class Demande {
	private ArrayList<Critere> recherche = new ArrayList<>(10) ;
	private ArrayList<Billet> resultats = new ArrayList<>(10) ;
	
	public Demande(ArrayList<Critere> criteres) {
			this.recherche.addAll(criteres) ;
	}
	
	/**
	 * Cette fonction ira rechercher les meilleurs resultats dans la base de donnees
	 * Le nombre de resultats est limite a 10
	 */
	public void rechercheResultats() {
		ArrayList<Billet> tmp = new ArrayList<>() ;
		/*
		 * - Recuperer tous les candidats correspondants aux criteres forts
		 * - Remplir 'resultats' avec les 10 premiers trouves
		 * - Ensuite, comparer le suivant avec le minimum de 'resultats' jusqu'a ce que tmp soit epuise, 
		 * 		si meilleur le mettre dans a la place de min
		 * 		sinon ignorer
		 *  - fin de la recherche
		 * 
		 */
		
	}
}
