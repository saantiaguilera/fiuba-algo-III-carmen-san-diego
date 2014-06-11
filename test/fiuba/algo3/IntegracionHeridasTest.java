package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionHeridasTest {
	
	@Test
	public void heridaCuchilloEnPersonajeNovatoRetrasaDosHoras(){
		int horasLimite = 15;
		PersonajeNovato personaje = new PersonajeNovato(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100,50);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasRestantes(), horasLimite-2-1);	
	}
	
	@Test
	public void heridaCuchilloEnPersonajeDetectiveRetrasaTresHoras(){
		int horasLimite = 15;
		PersonajeDetective personaje = new PersonajeDetective(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100,50);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasRestantes(), horasLimite-3-1);	

	}
	
	@Test
	public void heridaBalaEnPersonajeNovatoRetrasaTresHoras(){
		int horasLimite = 15;
		PersonajeNovato personaje = new PersonajeNovato(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100,1000);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasRestantes(), horasLimite-4-1);	
	}
	
	@Test
	public void heridaBalaEnPersonajeDetectiveRetrasaCincoHoras(){
		int horasLimite = 15;
		PersonajeDetective personaje = new PersonajeDetective(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100,1000);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasRestantes(), horasLimite-5-1);	
	}
}
