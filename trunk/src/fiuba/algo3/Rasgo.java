package fiuba.algo3;

public class Rasgo {
	
	private String rasgo;
	
	public Rasgo(String rasgo){
		this.rasgo = rasgo;
	}

	public Rasgo() {
		this.rasgo = null;
	}

	public String getRasgo() {
		return rasgo;
	}

	public void setRasgo(String rasgo) {
		this.rasgo = rasgo;
	}

	public boolean tieneRasgo() {
		return this.rasgo != null;
	}
	
}

