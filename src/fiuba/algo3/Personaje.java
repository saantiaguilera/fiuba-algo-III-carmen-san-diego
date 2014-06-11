package fiuba.algo3;

public abstract class Personaje {
	protected static int horasLimite;
	protected Pais ubicacion;
	protected int velocidad;
	
	public Personaje(int horasMaxima){
		horasLimite = horasMaxima;
	}
	
	public void viajarA(Pais destino){
		horasLimite-= this.calcularTiempo(destino);
		this.ubicacion = destino;
	}
	
	
	public void restarHoras(int horas){
		horasLimite-=horas;
	}
	
	private int calcularTiempo(Pais destino){
		int distanciaEnX = destino.getPosisionX() - ubicacion.getPosisionX();
		int distanciaEnY = destino.getPosisionY() - ubicacion.getPosisionY();
		double distancia = Math.sqrt( Math.pow(distanciaEnX, 2) + Math.pow(distanciaEnY, 2));
		return (int)(distancia/velocidad);			
	}
	
	public int getHorasRestantes(){
		return horasLimite;
	}
	
	public Pais getUbicacion(){
		return ubicacion;
	}
}
