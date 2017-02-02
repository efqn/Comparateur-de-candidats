package Criteres;

public class Stage extends CritereFort {
	private boolean value ;
	
	public Stage(boolean value) {
		this.value = value ;
	}
	
	public String getContent() {
		return "ok" ;
	}
	
	public String toString() {
		return "Stage" ;
	}
}
