package fiuba.algo3;

public class Edificio {
	int vecesVisitado;
	Pista pistaFacil;
	Pista pistaDificil;
	int porcentajeDeAsalto;
	int porcentajeDeArmaOCuchillo;//>50 arma ; <=50 cuchillo
	int contador;
	
	public Edificio(int porcentajeDeAsalto, int porcentajeDeArmaOCuchillo){
		vecesVisitado = 0;
		pistaFacil = new Pista();
		pistaDificil = new Pista();
		this.porcentajeDeAsalto=porcentajeDeAsalto;
		this.porcentajeDeArmaOCuchillo=porcentajeDeArmaOCuchillo;
		contador=1;
	}
	
	private void verificarConQueFueHerido(PersonajeNovato unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeArmaOCuchillo));
		if (R <= 50){
			unPersonaje.restarHoras(2);//Cuchillo			
		}
		else{
			unPersonaje.restarHoras(4);//Bala
			} 
	}
	
	private void verificarConQueFueHerido(PersonajeDetective unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeArmaOCuchillo));
		if (R <= 50){
			unPersonaje.restarHoras(3);//Cuchillo			
		}
		else{
			unPersonaje.restarHoras(5);//Bala
			} 
	}
	
	private void verificarSiFueHerido(PersonajeNovato unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeAsalto));
		if (R <= porcentajeDeAsalto){
			verificarConQueFueHerido(unPersonaje);
		}
	}	
	
	private void verificarSiFueHerido(PersonajeDetective unPersonaje){
		int R = (int) (Math.random() * (porcentajeDeAsalto));
		if (R < porcentajeDeAsalto){
			verificarConQueFueHerido(unPersonaje);
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
