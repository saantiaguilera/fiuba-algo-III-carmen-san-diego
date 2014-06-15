package fiuba.algo3;

public class Pais {
	private int posicionX;	
	private int posicionY;
	private String nombre;
	
	public Pais(int x, int y, String nombrePais){
		posicionX = x;
		posicionY = y;
		nombre = nombrePais;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public String getNombre() {
		return nombre;
	}

	public double calcularDistanciaCon(Pais paisDestino) {
		return Math.sqrt( Math.pow(this.posicionX - paisDestino.getPosicionX(), 2)
				+ Math.pow(this.posicionY - paisDestino.getPosicionY(), 2));
	}
	
}
