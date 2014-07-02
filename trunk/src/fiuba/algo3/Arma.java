package fiuba.algo3;

public class Arma {
	protected int danio;
	boolean haceDanio;
	
	public Arma(){
		danio = 0;
		haceDanio = false;
	}
	
	public int daniar(){
		return danio;
	}

	public boolean haceDanio() {
		return haceDanio;
	}
}
