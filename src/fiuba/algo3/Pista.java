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
		Pista nuevaPista = new Pista(((Element)nodoPista).getAttribute("pista"));
		
		return nuevaPista;
	}
}
