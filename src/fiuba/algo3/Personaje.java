package fiuba.algo3;

public abstract class Personaje {
	static int horasLimite;
	Pais ubicacion;
	int velocidad;
	
	public void viajarA(Pais destino){
		horasLimite-= this.calcularTiempo(destino);
		this.ubicacion = destino;
	}
	
	public int getHorasLimite() {
		return horasLimite;
	}
	
	public void restarHoras(int horas){
		horasLimite-=horas;
	}
	
	private int calcularTiempo(Pais destino){
		double distancia = ubicacion.calcularDistanciaCon(destino);
		return (int)(distancia/velocidad);			
	}
	
	public int horasRestantes(){
		return horasLimite;
	}
	
	public Pais getUbicacion(){
		return ubicacion;
	}
}
