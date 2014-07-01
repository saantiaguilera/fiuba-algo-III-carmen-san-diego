package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(int horasMaxima, Pais pais , int velocidad, Jefatura unaJefatura){
		super(horasMaxima, unaJefatura);
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}

	public String rango(){
		return "novato";
	}
	
	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
	
}
