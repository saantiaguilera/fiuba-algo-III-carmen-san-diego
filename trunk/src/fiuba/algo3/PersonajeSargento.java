package fiuba.algo3;

public class PersonajeSargento extends Personaje {

	public PersonajeSargento(int horasMaxima, Pais pais , int velocidad, Jefatura unaJefatura){
		super(horasMaxima, unaJefatura);
		paisesVisitados.push(pais);
		this.ubicacion= pais ;
		this.velocidad = velocidad;
	}

	public String rango(){
		return "sargento";
	}
	
	public Pista pedirPistaA(Edificio edificio){
		return edificio.darPistaA(this);
	}
}
