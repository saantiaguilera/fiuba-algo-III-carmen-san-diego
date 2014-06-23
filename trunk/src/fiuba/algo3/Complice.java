package fiuba.algo3;

public class Complice extends Ladron {
	protected Ladron ladron;
	protected Arma arma;
	
	public Complice(Ladron unLadron, Arma unArma){
		arma=unArma;
		ladron=unLadron;
	}
	
	public int getHorasARestar(Pais unPais){
		if (ladron.esUltimoPais(unPais)){

			return arma.dañar();
		}
		else { return 0;}
	}
}
