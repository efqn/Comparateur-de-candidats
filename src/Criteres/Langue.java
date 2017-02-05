package Criteres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Score.ScoreChoixMult;

public class Langue extends CritereFaible implements ScoreChoixMult {
	private HashMap<String, Integer> values = new HashMap<>() ;
	
	public Langue(ArrayList<String> langues) {
		String str, tmp ;
		int key ;
		for(String lang : langues) {
			System.out.println("lang : "+lang);
			str = lang.substring(0, lang.indexOf("+")) ;						//Format langue : (langue+ espace + niveau)
			System.out.println("str : "+str+", taille : "+str.length());
			/*System.out.println(lang.charAt(lang.indexOf(" ")+1)) ;
			System.out.println(Integer.valueOf(lang.charAt(lang.indexOf(" ")+1))) ;
			System.out.println(String.valueOf(lang.charAt(lang.indexOf(" ")+1))) ;*/
			tmp = "" + lang.charAt(lang.indexOf("+")+1) ;
			key = Integer.parseInt(tmp) ;
			//System.out.println("key : "+key);
			values.put(str, key) ;
			//System.out.println("Creation successful");
		}
	}
	
	public String convertLangueToBDDFormat() {
		String result = "" ;
		
		for( Map.Entry<String, Integer> entry: this.values.entrySet() )
			result = result + entry.getKey()+"+"+entry.getValue()+", " ;
		
		result = result.substring(0, result.length()-2) ;
		
		return result ;
	}
		
	/**
	 * Calcul du score :
	 * 		baseScore - ecart
	 * 
	 * L'ecart sera calcule en fonction du nombre de langue non presentes par rapport a la reference.
	 * Le baseScore sera divise par le nombre de langue dans la reference. Si l'ecart est de 0, le candidat aura 'toute les parts' du baseScore.
	 * Sinon, une 'part' sera perdue pour chaque langue non presente
	 */
	public int getScore(boolean flag, HashMap<String, Integer> reference) {
		
		int coeff = 2 ;
		
		if( flag ) {
			int onePart = baseScore/reference.size() ;
			String ref ;
			int lvl_ref, my_lvl ;
			
			for(Map.Entry<String, Integer> entree : reference.entrySet()) {
				ref = entree.getKey() ;
				lvl_ref = entree.getValue() ;
				
				if( this.values.containsKey(ref) ) {
					my_lvl = this.values.get(ref) ;								//la clÅEref existe aussi dans this.val
					//System.out.println("my_lvl = "+my_lvl);
					//System.out.println("lvl_ref = "+lvl_ref);
					if( my_lvl < lvl_ref ) {
						//System.out.println("lvl_ref - my_lvl = "+Math.abs(lvl_ref - my_lvl));
						baseScore = baseScore - Math.abs(lvl_ref - my_lvl)*coeff ;
					}
				}
				else {
					baseScore = baseScore - onePart ;
				}
			}
		}	
		return baseScore ;
	}
	
	public int getScore(CritereFaible critere, boolean flag) {
		Langue langue = (Langue)critere ;
		return getScore(flag, langue.getValues()) ;
	}
	
	public String getContent() {
		String res = "" ;
		
		for(Map.Entry<String, Integer> entry: this.values.entrySet()) {
			res = res + entry.getKey() + "/"  ;
		}
		return res ;
	}
	
	public HashMap<String, Integer> getValues() {
		return this.values ;
	}
	
	public void setValue(HashMap<String, Integer> map) {
		this.values = map ;
	}
	
	public void setVal(HashMap<String, Integer> map) {
		this.values = map;
	}
	
	public String toString() {
		return this.getContent() ;
	}
}
