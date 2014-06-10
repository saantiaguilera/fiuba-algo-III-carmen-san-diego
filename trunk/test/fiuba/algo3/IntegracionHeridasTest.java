package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionHeridasTest {
	
	@Test
	public void heridaCuchilloEnPersonajeNovatoRetrasaDosHoras(){
		int horasLimite = 15;
		PersonajeNovato personaje = new PersonajeNovato(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasLimite(), horasLimite-2-1);	
	}
	
	public void heridaCuchilloEnPersonajeDetectiveRetrasaTresHoras(){
		int horasLimite = 15;
		PersonajeDetective personaje = new PersonajeDetective(horasLimite,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio(100);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.getHorasLimite(), horasLimite-3-1);	

	}
}
