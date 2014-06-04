package fiuba.algo3;

public class PersonajeNovato extends Personaje {
	
	public PersonajeNovato(){
		horasLimite=100;
		ubicacion= new Pais(1,1,"Argentina");
		velocidad=100;
	}
	
	public PistaNovato pedirPistaA(Edificio edificio){
		horasLimite-=edificio.vecesVisitado();
		return edificio.darPistaA(this);
	}
}
