package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(int horasMaxima, Pais pais , int velocidad){
		horasLimite = horasMaxima;
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}
	
	public Pista pedirPistaA(Edificio edificio){
		horasLimite -= edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
