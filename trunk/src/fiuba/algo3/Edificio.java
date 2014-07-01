package fiuba.algo3;

import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Edificio {
	protected int vecesVisitado;
	protected Complice complice;
	

	public Edificio() {
		vecesVisitado = 0;
		complice = new Complice(new Ladron(), null);
	}

	
	public Pista darPistaA(PersonajeNovato unPersonaje){
		if (complice.esElLadron(unPersonaje.getUbicacion())){
			unPersonaje.capturoAlLadron();
		}
		else{
			unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
			vecesVisitado += 1;
			unPersonaje.restarHoras(vecesVisitado);
		}
		return complice.darPistaFacil();
	}
	
	public Pista darPistaA(PersonajeDetective unPersonaje){
		if (complice.esElLadron(unPersonaje.getUbicacion())){
			unPersonaje.capturoAlLadron();
		}
		else{
			unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
			vecesVisitado += 1;
			unPersonaje.restarHoras(vecesVisitado);
		}
		return complice.darPistaMedia();
	}
	
	public Pista darPistaA(PersonajeInvestigador unPersonaje){
		if (complice.esElLadron(unPersonaje.getUbicacion())){
			unPersonaje.capturoAlLadron();
		}
		else{
			unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
			vecesVisitado += 1;
			unPersonaje.restarHoras(vecesVisitado);
		}
		return complice.darPistaDificil();
	}
	
	public Pista darPistaA(PersonajeSargento unPersonaje){
		if (complice.esElLadron(unPersonaje.getUbicacion())){
			unPersonaje.capturoAlLadron();
		}
		else{
			unPersonaje.restarHoras(complice.getHorasARestar(unPersonaje.getUbicacion()));
			vecesVisitado += 1;
			unPersonaje.restarHoras(vecesVisitado);
		}
		return complice.darPistaDificil();
	}
	
	public void agregarPistaFacil(Pista unaPista){
		complice.agregarPistaFacil(unaPista);
	}
	
	public void agregarPistaMedia(Pista unaPista) {
		complice.agregarPistaMedia(unaPista);		
	}

	public void agregarPistaDificil(Pista unaPista){
		complice.agregarPistaDificil(unaPista);
	}
	
	public int vecesVisitado() {
		return this.vecesVisitado;
	}

	public void setComplice(Complice complice) {
		this.complice = complice;
	}
	
	public static Edificio hidratar(Node nodoEdificio, Ladron ladron){
		Edificio nuevoEdificio = new Edificio();
		NodeList nodosPistas = ((Element)nodoEdificio).getElementsByTagName("Pista");
		
		nuevoEdificio.agregarPistaDificil(Pista.hidratar(nodosPistas.item(0)));
		nuevoEdificio.agregarPistaMedia(Pista.hidratar(nodosPistas.item(1)));
		nuevoEdificio.agregarPistaFacil(Pista.hidratar(nodosPistas.item(2)));
		

		Random rand = new Random();
		if(rand.nextInt(5) == 4){
			if(ladron != null) ladron.dejarRasgoAleatorioEn(nuevoEdificio);
		}
		
		return nuevoEdificio;
	}

	public void concatenarRasgo(String texto, Rasgo rasgo) {
		complice.concatenarAPistas(texto.concat(rasgo.getRasgo()));
	}


	public String getPistas() {
		return complice.darPistaDificil().getPista().concat(complice.darPistaMedia().getPista()).concat(complice.darPistaFacil().getPista());
	}
}
