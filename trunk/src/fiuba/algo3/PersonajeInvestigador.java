package fiuba.algo3;

public class PersonajeInvestigador extends Personaje{
	
	public PersonajeInvestigador(int horasMaxima, Pais pais , int velocidad, Jefatura unaJefatura){
		super(horasMaxima, unaJefatura);
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}
	
	public String rango(){
		return "investigador";
	}
	
	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
}
