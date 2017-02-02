package Recherche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Criteres.Critere;
import database.SQLRequest;

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
	
	//Recupere les donnees dans la base de donnee
	public void retrieveData(String s) {
		SQLRequest request = new SQLRequest();
		
	}
	
	/**
	 * Cette fonction ira rechercher les meilleurs resultats dans la base de donnees
	 * Le nombre de resultats est limite a 10
	 */
	public void rechercheResultats(ArrayList<Billet> all) {
		ArrayList<Billet> tmp = all ;
		Billet min ;	
		Iterator<Billet> iter = tmp.iterator() ;
		
		// remplir 'resultats' avec les 10 premiers trouves
		Billet current ;
		for(int i=0; i<10; i++) {
			if( iter.hasNext() ) {
				current = (Billet)iter.next() ;
				current.getScore(this.recherche, this.flags) ;
				this.resultats.add(current) ;
			}
		}
		
		/* 
		 * Parcourir le reste des candidats 
		 * et les mettre dans 'resultats' si ils sont meilleurs que le min courant dans 'resultats'
		*/
		min = Collections.min(this.resultats) ;
		while(iter.hasNext()) {
			current = (Billet)iter.next() ;
			System.out.println("Score = "+current.getScore(recherche, flags)) ;
			if( min.getThisScore() < current.getThisScore()) {
				this.resultats.remove(min) ;
				this.resultats.add(current) ;
				min = Collections.min(this.resultats) ;
			}
		}
		
		//Tri des resultats dans l'ordre decroissant
		Collections.sort(this.resultats) ;
		Collections.reverse(this.resultats) ;
		System.out.println("Score min : "+Collections.min(this.resultats).getThisScore()) ;
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
		Billet current ;
		Iterator<Billet> iter = this.resultats.iterator() ;
		while(iter.hasNext()) {
			//result = result + iter.next() ++ "\n";
			current = (Billet)iter.next();
			result = result + current + current.getThisScore() + "\n" ;
		}
		return result ;
	}
	
}
