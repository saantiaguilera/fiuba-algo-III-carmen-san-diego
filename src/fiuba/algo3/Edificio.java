package fiuba.algo3;

public class Edificio {
	int vecesVisitado;
	Pista pistaFacil;
	Pista pistaDificil;
	int porcentajeDeAsalto;
	int contador;
	
	public Edificio(int porcentaje){
		vecesVisitado = 0;
		pistaFacil = new Pista();
		pistaDificil = new Pista();
		porcentajeDeAsalto=porcentaje;
		contador=1;
	}
	
	private void verificarSiFueHerido(PersonajeNovato unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeAsalto));
		if (R < porcentajeDeAsalto){
			unPersonaje.restarHoras(2);
		}
	}	
	
	private void verificarSiFueHerido(PersonajeDetective unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeAsalto));
		if (R < porcentajeDeAsalto){
			unPersonaje.restarHoras(3);
		}
	}
	
	public Pista darPistaA(PersonajeNovato unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		unPersonaje.restarHoras(contador);
		contador+=1;
		return this.pistaFacil;
	}
	
	public Pista darPistaA(PersonajeDetective unPersonaje){
		this.verificarSiFueHerido(unPersonaje);
		unPersonaje.restarHoras(contador);
		contador+=1;
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
