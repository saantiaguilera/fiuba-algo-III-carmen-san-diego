package fiuba.algo3;

import java.util.Calendar;

public abstract class Personaje {
	protected Pais ubicacion;
	protected int velocidad;
	protected Calendar horaActual;
	protected static int horasADormir = 8;
	protected Calendar tiempoLimite;
	
	public Personaje(int horasMaxima) {
		horaActual = Calendar.getInstance();
		horaActual.set(2014,7,1,8,0,0);//1 de julio de 2014 8 am
		tiempoLimite = Calendar.getInstance();
		tiempoLimite.set(2014,7,1,8,0,0);
	    tiempoLimite.add(Calendar.HOUR_OF_DAY, horasMaxima);
	}
	
	public void viajarA(Pais destino){
		restarHoras(this.calcularTiempo(destino));
		this.ubicacion = destino;
	}
	
	public void restarHoras(int horas){
		horaActual.add(Calendar.HOUR_OF_DAY, horas);
		if (this.horaActual.get(Calendar.HOUR_OF_DAY) >= 22 || this.horaActual.get(Calendar.HOUR_OF_DAY) <= 4){//si son entre las 22 y las 4 duerme
			this.dormir();
		}
	}
	
	private int calcularTiempo(Pais destino){
		double distancia = ubicacion.calcularDistanciaCon(destino);
		return (int)(distancia/velocidad);			
	}
	
	public int getHorasRestantes(){
		int diasAux = tiempoLimite.get(Calendar.DAY_OF_MONTH) - horaActual.get(Calendar.DAY_OF_MONTH);
		int horasAux = diasAux * 24;
		if (tiempoLimite.get(Calendar.HOUR_OF_DAY) >= horaActual.get(Calendar.HOUR_OF_DAY)){
			horasAux = horasAux + (tiempoLimite.get(Calendar.HOUR_OF_DAY) - horaActual.get(Calendar.HOUR_OF_DAY));}
		else{
			horasAux = horasAux - ( horaActual.get(Calendar.HOUR_OF_DAY) - tiempoLimite.get(Calendar.HOUR_OF_DAY) );	
			}
		return horasAux;
	}
	
	public Pais getUbicacion(){
		return ubicacion;
	}

	public abstract Pista pedirPistaA(Edificio edificio);
	
	public void emitirOrdenA(Jefatura jefatura, Sospechoso sospechoso) {
		this.restarHoras(3);
		jefatura.emitirOrden(sospechoso);
	}
	
	private void dormir(){
		horaActual.add(Calendar.HOUR_OF_DAY, horasADormir);
	}
	
}
