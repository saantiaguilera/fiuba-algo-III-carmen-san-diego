package fiuba.algo3;

public class Jefatura {
	
	private Ladron ladron;
	private Boolean ordenEmitida;
	
	public Jefatura(Ladron ladron){
		this.ladron = ladron;
		this.ordenEmitida = false;
	}

	public void emitirOrden(Sospechoso sospechoso) {
		if(ladron.coincideRasgosCon(sospechoso))
			ordenEmitida = true;
	}

	public boolean ordenEstaEmitida() {
		return ordenEmitida;
	}
}
