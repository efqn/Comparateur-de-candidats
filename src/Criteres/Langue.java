package Criteres;

import java.util.ArrayList;
import java.util.Iterator;

import Score.ScoreChoixMult;

public class Langue extends CritereFaible implements ScoreChoixMult {
	private ArrayList<String> values = new ArrayList<>() ;
	
	public Langue(ArrayList<String> langues) {
			this.values.addAll(langues) ;
	}
		
	/**
	 * Calcul du score :
	 * 		baseScore - ecart
	 * 
	 * L'ecart sera calcule en fonction du nombre de langue non presentes par rapport a la reference.
	 * Le baseScore sera divise par le nombre de langue dans la reference. Si l'ecart est de 0, le candidat aura 'toute les parts' du baseScore.
	 * Sinon, une 'part' sera perdue pour chaque langue non presente
	 */
	public int getScore(boolean flag, ArrayList<String> reference) {
		int baseScore = 100 ;
		
		if( flag ) {
			int onePart = baseScore/reference.size() ;
			Iterator iter = reference.iterator() ;
			
			while( iter.hasNext() ) {
				String current = (String)iter.next() ;
				if( !this.values.contains(current) ) 
					baseScore = baseScore - onePart ;
			}
		}	
		return baseScore ;
	}
	
	public int getScore(CritereFaible critere, boolean flag) {
		Langue langue = (Langue)critere ;
		return getScore(flag, langue.getValues()) ;
	}
	
	public String getContent() {
		Iterator<String> iter = this.values.iterator() ;
		String res = "" ;
		String current ;
		
		while( iter.hasNext() ) {
			current = iter.next()+"/" ;
			res = res + current ;
		}
		return res ;
	}
	
	public ArrayList<String> getValues() {
		return this.values ;
	}
	
	public void setValue(ArrayList<String> s) {
		this.values = s ;
	}
	
	public String toString() {
		return this.getContent() ;
	}
}
