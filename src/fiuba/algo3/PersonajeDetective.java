package fiuba.algo3;

public class PersonajeDetective extends Personaje {
	
	public PersonajeDetective(int horasMaxima, Pais pais , int velocidad, Jefatura unaJefatura){
		super(horasMaxima, unaJefatura);
		paisesVisitados.push(pais);
		this.ubicacion = pais;
		this.velocidad = velocidad;
	}
	
	public String rango(){
		return "detective";
	}
	
	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
}
