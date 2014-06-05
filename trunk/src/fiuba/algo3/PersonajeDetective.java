package fiuba.algo3;

public class PersonajeDetective extends Personaje {
	
	public PersonajeDetective(){
		horasLimite=10;
		ubicacion = new Pais(1,1,"Argentina");
		velocidad=5;
	}
	
	public Pista pedirPistaA(Edificio edificio){
		horasLimite -= edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
