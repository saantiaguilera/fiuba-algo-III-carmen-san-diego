package fiuba.algo3;

public class Edificio {
	protected int vecesVisitado;
	protected Pista pistaFacil;
	protected Pista pistaDificil;
	protected boolean seEscondioElLadron;
	protected boolean tienenArmas;
	protected boolean tienenCuchillos;
	protected boolean esEdificioDeUltimoPais;
	

	public Edificio(boolean esUltimoEdificio) {
		vecesVisitado = 0;
		//pistaFacil = new Pista();
		//pistaDificil = new Pista();
		esEdificioDeUltimoPais=esUltimoEdificio;
		tienenCuchillos=false;
		tienenArmas=false;
		seEscondioElLadron=false;
	}

	public void setSeEscondioElLadron(boolean seEscondioElLadron) {
		this.seEscondioElLadron = seEscondioElLadron;
	}
	
	public void setTienenArmas(boolean tienenArmas) {
		this.tienenArmas = tienenArmas;
	}
	
	public void setTienenCuchillos(boolean tienenCuchillos) {
		this.tienenCuchillos = tienenCuchillos;
	}
	
	public void setEsEdificioDeUltimoPais(boolean esEdificioDeUltimoPais) {
		this.esEdificioDeUltimoPais = esEdificioDeUltimoPais;
	}

	
	private void verificarConQueFueHerido(PersonajeNovato unPersonaje){
		if (tienenArmas){
			unPersonaje.restarHoras(4);
		}
		if (tienenCuchillos){
			unPersonaje.restarHoras(2);
		}
	}
	
	private void verificarConQueFueHerido(PersonajeDetective unPersonaje){
		if (tienenArmas){
			unPersonaje.restarHoras(5);
		}
		if (tienenCuchillos){
			unPersonaje.restarHoras(3);
		}
	}
	
	private void verificarSiFueHerido(PersonajeNovato unPersonaje){
		if (esEdificioDeUltimoPais & seEscondioElLadron==false){
			verificarConQueFueHerido(unPersonaje);
		}
	}	
	
	private void verificarSiFueHerido(PersonajeDetective unPersonaje){
		if (esEdificioDeUltimoPais & seEscondioElLadron==false){
			verificarConQueFueHerido(unPersonaje);
		}		
	}
	
	public Pista darPistaA(PersonajeNovato unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaFacil;
	}
	
	public Pista darPistaA(PersonajeDetective unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaDificil;
	}
	
	public void agregarPistaFacil(Pista unaPista){
		this.pistaFacil = unaPista;
	}

	public void agregarPistaDificil(Pista unaPista){
		this.pistaDificil = unaPista;
	}
	
	public int vecesVisitado() {
		return this.vecesVisitado;
	}

}
