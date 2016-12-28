package Recherche;

import java.util.ArrayList;
import java.util.Iterator;

import Criteres.Critere;

public class Demande {
	private ArrayList<Critere> recherche = new ArrayList<>(10) ;
	private ArrayList<Billet> resultats = new ArrayList<>(10) ;
	private boolean[] flags ;
	
	/**
	 * 
	 * @param criteres : Criteres de references
	 * 					---> dans l'ordre : Filiere, type de contrat, Age, PermisB, Region, NiveauEtude, ExperiencePro, Langue
	 * @param flags    : Criteres Faibles a prendre en compte
	 * 					---> dans l'ordre : Age, PermisB, Region, NiveauEtude, ExperiencePro, Langue
	 */
	public Demande(ArrayList<Critere> criteres, boolean[]flags) {
			this.recherche.addAll(criteres) ;
			this.flags = new boolean[this.recherche.size()-2] ;							// les -2 correspond aux criteres forts, qui ne sont pas pris en compte ici
			for(int i=0; i<this.flags.length; i++)
				this.flags[i] = flags[i] ;
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
		
		Iterator<Billet> iter = tmp.iterator() ;
		
		// remplir 'resultats' avec les 10 premiers trouves
		for(int i=0; i<10; i++) {
			if( iter.hasNext() )
				this.resultats.add((Billet)iter.next()) ;
		}
		
		/* 
		 * Parcourir le reste des candidats 
		 * et les mettre dans 'resultats' si ils sont meilleurs que le min courant dans 'resultats'
		*/
		while(iter.hasNext()) {
			Billet current ;
			current = (Billet)iter.next() ;
			System.out.println("Score = "+current.getScore(recherche, flags));
			//this.resultats.add((Billet)iter.next()) ;
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
		Iterator<Billet> iter = this.resultats.iterator() ;
		while(iter.hasNext()) {
			result = result + iter.next() + "\n";
		}
		return result ;
	}
	
}
