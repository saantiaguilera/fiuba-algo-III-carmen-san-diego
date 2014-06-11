package fiuba.algo3;

public class Pais {
	private int posisionX;
	private int posisionY;
	private String nombre;
	
	public Pais(int x, int y, String nombrePais){
		posisionX = x;
		posisionY = y;
		nombre = nombrePais;
	}

	public int getPosisionX() {
		return posisionX;
	}

	public int getPosisionY() {
		return posisionY;
	}

	public String getNombre() {
		return nombre;
	}
	
}
