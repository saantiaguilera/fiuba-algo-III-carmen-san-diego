package fiuba.algo3;

public class PersonajeInvestigador extends Personaje{
	
	public PersonajeInvestigador(int horasMaxima, Pais pais , int velocidad){
		horasLimite = horasMaxima;
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}
	
	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
}