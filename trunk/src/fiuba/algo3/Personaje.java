package fiuba.algo3;

public abstract class Personaje {
	int horasLimite;
	Pais ubicacion;
	int velocidad;
	
	public void viajarA(Pais ubicacion){
		horasLimite-=this.calcularTiempo(ubicacion);
		this.ubicacion=ubicacion;
	}
	
	public int calcularTiempo(Pais ubicacion){
		return 10;
	}//Hardcodeo
}
