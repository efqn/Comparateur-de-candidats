package Recherche;

import java.util.ArrayList;
import java.util.Iterator;

import Candidat.Candidat;
import Criteres.*;
import Score.ScoreFinal;

public class Billet implements ScoreFinal, Comparable<Billet> {
	private Candidat candidat ;
	private ArrayList<Critere> criteres = new ArrayList<>(8) ;
	private int score = 0;
	
	public Billet(Candidat candidat, ArrayList<Critere> criteres) {
		this.candidat = candidat ;
		this.criteres.addAll(criteres) ;
	}
	
	/**
	 * 
	 * @param criteres 	: Criteres a comparer avec la collection
	 * @param flags		: tableau de boolean pour savoir si il faut prendre en compte le critere concerne

	 * @return	Score final
	 */
	public int getScore(ArrayList<Critere> criteres, boolean[] flags) {
		Iterator<Critere> iter = this.criteres.iterator() ;
		Iterator<Critere> iter2 = criteres.iterator() ;
		this.score = 0 ;															//si on veut recompter pour une autre demande
		
		//Les 2 premiers champs d'une arraylist de criteres seront des criteres forts. Ils ne sont pas utilises pour le calcul
		for(int i=0; i<2; i++)
			iter.next() ;
		for(int i=0; i<2; i++)
			iter2.next() ;
		
		CritereFaible current ;														//critere du billet
		CritereFaible current2 ;													//critere de reference
		int i = 0 ;
		while( iter.hasNext() && iter2.hasNext() ) {
			current = (CritereFaible)iter.next() ;
			current2 = (CritereFaible)iter2.next();
			System.out.println("\n\nCalcul score :");
			System.out.println("Reference : " + current2) ;
			System.out.println("current : "+ current) ;
			System.out.println("Score current : "+ current.getScore(current2, flags[i]));
			this.score = this.score + current.getScore(current2, flags[i++]) ;
		}
		
		return this.score ;
	}
	
	public void afficher() {
		System.out.println("");
	}
	
	//contrairement a getScore(), cette fonction n'effectue pas de calcul
	public int getThisScore() {
		return this.score ;
	}
	
	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
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

///////	Methodes a implementer pour les interfaces meres	////////////////
	@Override
	public int getScore(boolean flag, ArrayList<String> reference) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, int borneInf, int borneSup) {
		// TODO Auto-generated method stub
		return 0;
	}
/////////////////////////////////////////////////////////////////////////

	@Override
	public int compareTo(Billet b) {
		if( this.score < b.getThisScore() )
			return -1 ;
		else if ( this.score == b.getThisScore() )
			return 0 ;
		else
			return 1 ;
			
	}
}
