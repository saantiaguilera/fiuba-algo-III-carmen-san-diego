package fiuba.algo3;

public class PersonajeDetective extends Personaje {
	
	public PersonajeDetective(){
		horasLimite=100;
		ubicacion= new Pais(1,1,"Argentina");
		velocidad=200;
	}
	
	public PistaDetective pedirPistaA(Edificio edificio){
		horasLimite-=edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
