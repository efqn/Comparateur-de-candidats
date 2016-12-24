package Recherche;

import java.util.ArrayList;
import java.util.Iterator;

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
	public void rechercheResultats(ArrayList<Billet> all) {
		ArrayList<Billet> tmp = all ;
		Billet min ;
		/*
		 * - Recuperer tous les candidats correspondants aux criteres forts
		 * - Remplir 'resultats' avec les 10 premiers trouves
		 * - Ensuite, comparer le suivant avec le minimum de 'resultats' jusqu'a ce que tmp soit epuise, 
		 * 		si meilleur le mettre dans a la place de min
		 * 		sinon ignorer
		 *  - fin de la recherche
		 * 
		 */
		
		Iterator iter = tmp.iterator() ;
		while(iter.hasNext()) {
			this.resultats.add((Billet)iter.next()) ;
		}
	}

	public ArrayList<Critere> getRecherche() {
		return recherche;
	}

	public void setRecherche(ArrayList<Critere> recherche) {
		this.recherche = recherche;
	}

	public ArrayList<Billet> getResultats() {
		return resultats;
	}

	public void setResultats(ArrayList<Billet> resultats) {
		this.resultats = resultats;
	}
	
	public String toString() {
		String result = "" ;
		Iterator iter = this.resultats.iterator() ;
		while(iter.hasNext()) {
			result = result + iter.next() + "\n";
		}
		return result ;
	}
	
}
