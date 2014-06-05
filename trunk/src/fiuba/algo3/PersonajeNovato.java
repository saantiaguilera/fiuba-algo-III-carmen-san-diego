package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(){
		this.horasLimite=10;
		this.ubicacion= new Pais(1,1,"Argentina");
		this.velocidad=1;
	}
	
	public Pista pedirPistaA(Edificio edificio){
		horasLimite -= edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
