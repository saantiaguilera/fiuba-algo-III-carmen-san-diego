package fiuba.algo3;

public class Edificio {
	int vecesVisitado;
	Pista pistaFacil;
	Pista pistaDificil;
	
	public Edificio(){
		vecesVisitado = 0;
		pistaFacil = new Pista();
		pistaDificil = new Pista();
	}
	
	public Pista darPistaA(PersonajeNovato unPersonaje){
		return this.pistaFacil;
	}
	
	public Pista darPistaA(PersonajeDetective unPersonaje){
		return this.pistaDificil;
	}
	
	public void agregarPistaFacil(Pista unaPista){
		this.pistaFacil = unaPista;
	}

	public void agregarPistaDificil(Pista unaPista){
		this.pistaDificil = unaPista;
	}
	
	public int vecesVisitado() {
		return 0;
	}

}
