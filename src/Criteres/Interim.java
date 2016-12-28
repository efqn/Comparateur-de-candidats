package Criteres;

public class Interim extends CritereFort {
	private boolean value ;
	
	public Interim(boolean value) {
		this.value = value ;
	}
	
	public String getContent() {
		return "ok" ;
	}
	
	public String toString() {
		return String.valueOf(value) ;
	}
}
