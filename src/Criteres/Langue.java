package Criteres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Score.ScoreChoixMult;

public class Langue extends CritereFaible implements ScoreChoixMult {
	private HashMap<String, Integer> values = new HashMap<>() ;
	int coeff = 2 ;			//coefficient a appliquer pour les ecarts entre les niveaux de langues
	
	public Langue(ArrayList<String> langues) {
		String str, tmp ;
		int key ;
		for(String lang : langues) {
			//System.out.println("lang : "+lang);
			str = lang.substring(0, lang.indexOf("+")) ;						//Format langue : (langue+ "+" + niveau)
			//System.out.println("str : "+str+", taille : "+str.length());
			tmp = "" + lang.charAt(lang.indexOf("+")+1) ;
			key = Integer.parseInt(tmp) ;
			values.put(str, key) ;
		}
	}
	
	/**
	 * Converti la HashMap dans le format utilise pour l'insertion dans la base de donnees
	 * @return une chaine de caractere au format de la base de donnees
	 */
	public String convertLangueToBDDFormat() {
		String result = "" ;
		
		if( !this.values.entrySet().isEmpty() ) {
			for( Map.Entry<String, Integer> entry: this.values.entrySet() )
				result = result + entry.getKey()+"+"+entry.getValue()+", " ;
			
			result = result.substring(0, result.length()-2) ;
		}
		return result ;
	}
		
	/**
	 * Calcul du score :
	 * 		baseScore - ecart
	 * 
	 * L'ecart sera calcule en fonction du nombre de langue non presentes par rapport a la reference
	 * ET l'ecart entre les niveaux de la reference et le niveau de l'objet a comparer si la langue est presente
	 * Le baseScore sera divise par le nombre de langue dans la reference. Si l'ecart est de 0, le candidat aura 'toute les parts' du baseScore.
	 * Sinon, une 'part' sera perdue pour chaque langue non presente et pour chaque ecart de niveau.
	 */
	public int getScore(boolean flag, HashMap<String, Integer> reference) {
			
		if( flag ) {
			int onePart = baseScore/reference.size() ;
			String ref ;
			int lvl_ref, my_lvl ;
			
			for(Map.Entry<String, Integer> entree : reference.entrySet()) {
				ref = entree.getKey() ;
				lvl_ref = entree.getValue() ;
				
				if( this.values.containsKey(ref) ) {
					my_lvl = this.values.get(ref) ;								//la cle ref existe aussi dans this.val
					if( my_lvl < lvl_ref ) {
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
	
	/**
	 * fonction commune a tous les criteres faibles.
	 * Appelle la bonne fonction getScore() qui effectuera le calcul du score
	 */
	public int getScore(CritereFaible critere, boolean flag) {
		Langue langue = (Langue)critere ;
		return getScore(flag, langue.getValues()) ;
	}
	
	public String getContent() {
		return this.convertLangueToBDDFormat() ;
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
