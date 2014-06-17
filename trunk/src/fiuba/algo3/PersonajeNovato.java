package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(int horasMaxima, Pais pais , int velocidad){
		horasLimite = horasMaxima;
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}
	
	public PersonajeNovato(int horas, Pais pais) {
		this.horasLimite = horas;
		this.ubicacion = pais;
		this.velocidad = 900;
	}

	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}

}
