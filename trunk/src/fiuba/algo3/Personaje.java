package fiuba.algo3;

public abstract class Personaje {
	int horasLimite;
	Pais ubicacion;
	int velocidad;
	
	public void viajarA(Pais destino){
		horasLimite-= this.calcularTiempo(destino);
		this.ubicacion = destino;
	}
	
	private int calcularTiempo(Pais destino){
		int distanciaEnX = destino.getPosisionX() - ubicacion.getPosisionX();
		int distanciaEnY = destino.getPosisionY() - ubicacion.getPosisionY();
		double distancia = Math.sqrt( Math.pow(distanciaEnX, 2) + Math.pow(distanciaEnY, 2));
		return (int)(distancia/velocidad);			
	}
	
	public int horasRestantes(){
		return horasLimite;
	}
	
	public Pais getUbicacion(){
		return ubicacion;
	}
}
