package fiuba.algo3;

public class Edificio {
	protected int vecesVisitado;
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	protected Pista pistaDificil;
	protected boolean seEscondioElLadron;
	protected boolean tienenArmas;
	protected boolean tienenCuchillos;
	protected boolean esEdificioDeUltimoPais;
	

	public Edificio(boolean esUltimoEdificio) {
		vecesVisitado = 0;
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
	
	private void verificarConQueFueHerido(PersonajeInvestigador unPersonaje){
		if (tienenArmas){
			unPersonaje.restarHoras(5);
		}
		if (tienenCuchillos){
			unPersonaje.restarHoras(3);
		}
	}	
	
	private void verificarConQueFueHerido(PersonajeSargento unPersonaje){
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
	
	private void verificarSiFueHerido(PersonajeInvestigador unPersonaje){
		if (esEdificioDeUltimoPais & seEscondioElLadron==false){
			verificarConQueFueHerido(unPersonaje);
		}		
	}

	private void verificarSiFueHerido(PersonajeSargento unPersonaje){
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
		return this.pistaMedia;
	}
	
	public Pista darPistaA(PersonajeInvestigador unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaDificil;
	}
	
	public Pista darPistaA(PersonajeSargento unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaDificil;
	}
	
	public void agregarPistaFacil(Pista unaPista){
		this.pistaFacil = unaPista;
	}
	
	public void agregarPistaMedia(Pista unaPista) {
		this.pistaMedia = unaPista;
		
	}

	public void agregarPistaDificil(Pista unaPista){
		this.pistaDificil = unaPista;
	}
	
	public int vecesVisitado() {
		return this.vecesVisitado;
	}

}
