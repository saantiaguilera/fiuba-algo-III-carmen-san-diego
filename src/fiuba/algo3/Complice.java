package fiuba.algo3;

public class Complice {
	protected Ladron ladron;
	protected Arma arma;
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	protected Pista pistaDificil;
	
	public Complice(Ladron unLadron, Arma unArma){
		arma=unArma;
		ladron=unLadron;
	}
		
	public int getHorasARestar(Pais unPais){
		if(arma!=null){
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
		if (arma!= null && ladron.esUltimoPais(ubicacion)){
			if (!arma.haceDanio()){
				return true;
			}
		}
		return false;
	}
}