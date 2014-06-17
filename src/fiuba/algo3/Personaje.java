package fiuba.algo3;

public abstract class Personaje {
	protected int horasLimite;
	protected Pais ubicacion;
	protected int velocidad;
	
	public void viajarA(Pais destino){
		horasLimite -= this.calcularTiempo(destino);
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

	public abstract Pista pedirPistaA(Edificio edificio);
	
	public void emitirOrdenA(Jefatura jefatura, Sospechoso sospechoso) {
		this.restarHoras(3);
		jefatura.emitirOrden(sospechoso);
	}
}
