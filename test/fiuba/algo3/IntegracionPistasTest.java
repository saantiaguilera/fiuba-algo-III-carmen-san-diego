package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionPistasTest {

	@Test
	public void DetectiveDeberiaRecibirPistaDificil(){
		PersonajeDetective personaje= new PersonajeDetective();
		Edificio edificio = new Edificio();
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaDificil = new Pista("Pista Dificil");
		
		edificio.agregarPistaFacil(pistaFacil);
		edificio.agregarPistaDificil(pistaDificil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Dificil");
	}
	
	@Test
	public void NovatoDebeRecibirPistaFacil(){
		PersonajeNovato personaje = new PersonajeNovato();
		Edificio edificio = new Edificio();
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaDificil = new Pista("Pista Dificil");
		
		edificio.agregarPistaDificil(pistaDificil);	
		edificio.agregarPistaFacil(pistaFacil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Facil");
	}

	
}
