package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionPistasTest {

	@Test
	public void DetectiveDeberiaRecibirPistaDificil(){
		PersonajeDetective personaje= new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(0,0);
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaDificil = new Pista("Pista Dificil");
		
		edificio.agregarPistaFacil(pistaFacil);
		edificio.agregarPistaDificil(pistaDificil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Dificil");
	}
	
	@Test
	public void NovatoDebeRecibirPistaFacil(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		Edificio edificio = new Edificio(0,0);
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaDificil = new Pista("Pista Dificil");
		
		edificio.agregarPistaDificil(pistaDificil);	
		edificio.agregarPistaFacil(pistaFacil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Facil");
	}

	
}
