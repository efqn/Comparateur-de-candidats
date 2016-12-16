package Criteres;

public class Stage extends CritereFort {
	private boolean value ;
	
	public Stage(boolean value) {
		this.value = value ;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
