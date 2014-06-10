package fiuba.algo3;

public class Jefatura {
	
	private Sospechoso ladron;
	private Boolean ordenEmitida;
	
	public Jefatura(Sospechoso ladron){
		this.ladron = ladron;
		this.ordenEmitida = false;
	}

	public void emitirOrden(Sospechoso sospechoso) {
		if(sospechoso.coincideRasgosCon(ladron))
			ordenEmitida = true;
	}

	public boolean ordenEstaEmitida() {
		return ordenEmitida;
	}
}
