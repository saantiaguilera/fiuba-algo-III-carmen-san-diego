package fiuba.algo3;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public  class Pista {
	private String pista;
	
	public Pista(){
		pista = "Pista";
	}

	public Pista(String textoPista){
		this.pista = textoPista;
	}
	
	public String getPista() {
		return pista;
	}
	
	public static Pista hidratar(Node nodoPista){
		String textoPista = ((Element)nodoPista).getAttribute("pista");
		return new Pista(textoPista);
	}

	public void setPista(String texto){
		this.pista = texto;
	}

	public void concatenar(String texto) {
		pista = pista.concat(texto);
	}
}
