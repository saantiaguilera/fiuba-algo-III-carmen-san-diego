package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(int horasMaxima, Pais pais , int velocidad){
		super(horasMaxima);
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}

	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
	
}