package fiuba.algo3;

public class Edificio {
	int vecesVisitado;
	PistaNovato pistaNovato;
	PistaDetective pistaDetective;
	
	public Edificio(){
		vecesVisitado=0;
		pistaNovato=new PistaNovato();
		pistaDetective= new PistaDetective();
	}
	
	public PistaNovato darPistaA(PersonajeNovato unPersonaje){
		return pistaNovato;
	}
	
	public PistaDetective darPistaA(PersonajeDetective unPersonaje){
		return pistaDetective;
	}

	public int vecesVisitado() {
		// TODO Auto-generated method stub
		return 0;
	}
}
