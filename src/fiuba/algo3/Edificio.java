package fiuba.algo3;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Edificio {
	protected int vecesVisitado;
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	protected Pista pistaDificil;
	protected Complice complice;
	

	public Edificio() {
		vecesVisitado = 0;
		complice = new Complice(new Ladron(), null);
	}

	
	public Pista darPistaA(PersonajeNovato unPersonaje){
		unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaFacil;
	}
	
	public Pista darPistaA(PersonajeDetective unPersonaje){
		unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaMedia;
	}
	
	public Pista darPistaA(PersonajeInvestigador unPersonaje){
		unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaDificil;
	}
	
	public Pista darPistaA(PersonajeSargento unPersonaje){
		unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
		vecesVisitado += 1;
		unPersonaje.restarHoras(vecesVisitado);
		return this.pistaDificil;
	}
	
	public void agregarPistaFacil(Pista unaPista){
		this.pistaFacil = unaPista;
	}
	
	public void agregarPistaMedia(Pista unaPista) {
		this.pistaMedia = unaPista;
		
	}

	public void agregarPistaDificil(Pista unaPista){
		this.pistaDificil = unaPista;
	}
	
	public int vecesVisitado() {
		return this.vecesVisitado;
	}

	public void setComplice(Complice complice) {
		this.complice = complice;
	}

	public static Edificio hidratar(Node nodoEdificio){
		Edificio nuevoEdificio = new Edificio();
		NodeList nodosPistas = ((Element)nodoEdificio).getElementsByTagName("Pista");
		
		nuevoEdificio.agregarPistaDificil(Pista.hidratar(nodosPistas.item(0)));
		nuevoEdificio.agregarPistaMedia(Pista.hidratar(nodosPistas.item(1)));
		nuevoEdificio.agregarPistaFacil(Pista.hidratar(nodosPistas.item(2)));
		
		return nuevoEdificio;
	}
}
