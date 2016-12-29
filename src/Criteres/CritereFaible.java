package Criteres;

public class CritereFaible extends Critere {

	protected int baseScore = 100;
	protected int facteur = 10;
	
	public CritereFaible(){
	}
	
	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Ce getScore() appelera le bon getScore() defini pour chaque critere faible
	 */
	public int getScore(CritereFaible critereF, boolean flag) {
		return 0 ;
	}
}
