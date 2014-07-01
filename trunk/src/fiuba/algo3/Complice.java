package fiuba.algo3;

public class Complice {
	protected Ladron ladron;
	protected Arma arma;
	Pista pistaFacil;
	Pista pistaMedia;
	Pista pistaDificil;
	
	public Complice(Ladron unLadron, Arma unArma){
		arma=unArma;
		ladron=unLadron;
	}
		
	//REFACTOR: Podria preguntarse directamente si arma!=null,
	//	y encontes Complice no necesitaria saber de Ladron
	public int getHorasARestar(Pais unPais){
		if (ladron.esUltimoPais(unPais)){
			return arma.daniar();
		}
		else { return 0;}
	}


	public void agregarPistaFacil(Pista unaPista) {
		this.pistaFacil = unaPista;
	}
	
	public void agregarPistaMedia(Pista unaPista) {
		this.pistaMedia = unaPista;
	}
	
	public void agregarPistaDificil(Pista unaPista) {
		this.pistaDificil = unaPista;
	}

	public Pista darPistaFacil() {
		return pistaFacil;
	}
	
	public Pista darPistaMedia() {
		return pistaMedia;
	}
	
	public Pista darPistaDificil() {
		return pistaDificil;
	}

	public void concatenarAPistas(String texto) {
		pistaFacil.concatenar(texto);
		pistaMedia.concatenar(texto);
		pistaDificil.concatenar(texto);
	}

	public boolean esElLadron(Pais ubicacion) {
		if (ladron.esUltimoPais(ubicacion)){
			if (arma.haceDanio()==false){
				return true;
			}
		}
		return false;
	}
}