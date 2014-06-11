package fiuba.algo3;

public class Edificio {
	protected int vecesVisitado;
	protected Pista pistaFacil;
	protected Pista pistaDificil;
	protected int porcentajeDeAsalto;
	protected int porcentajeDeArmaOCuchillo;//>50 arma ; <=50 cuchillo
	//protected int contador;
	
	public Edificio(int porcentajeDeAsalto, int porcentajeDeArmaOCuchillo){
		vecesVisitado = 0;
		//pistaFacil = new Pista();
		//pistaDificil = new Pista();
		this.porcentajeDeAsalto=porcentajeDeAsalto;
		this.porcentajeDeArmaOCuchillo=porcentajeDeArmaOCuchillo;
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
