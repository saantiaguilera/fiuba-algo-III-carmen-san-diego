package fiuba.algo3;

public class PersonajeDetective extends Personaje {
	
	
	public PersonajeDetective(int horasMaxima, Pais pais , int velocidad){
		super(horasMaxima);
		ubicacion = pais;
		this.velocidad = velocidad;
	}
	
	public Pista pedirPistaA(Edificio edificio){
		horasLimite -= edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
