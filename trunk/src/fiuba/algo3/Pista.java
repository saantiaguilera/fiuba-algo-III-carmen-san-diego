package fiuba.algo3;

public abstract class Pista {
	String pista;
	
	public Pista(){
		pista="Pista";
	}

	public String getPista() {
		return pista;
	}
	
	public abstract Boolean esNovato();
	public abstract Boolean esDetective();
}
