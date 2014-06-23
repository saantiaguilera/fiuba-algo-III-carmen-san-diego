package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;



public class IntegracionHeridasTest {
	
	@Test
	public void heridaCuchilloEnPersonajeNovatoRetrasaDosHoras(){
		int horasLimite = 15;
		Pais pais=new Pais(1,1,"Argentina");
		PersonajeNovato personaje = new PersonajeNovato(horasLimite,pais,5);
		Edificio edificio = new Edificio();
		Cuchillo cuchillo=new Cuchillo();
		Ladron ladron = new Ladron();
		ladron.agregarPais(pais);
		Complice complice= new Complice(ladron,cuchillo);
		edificio.setComplice(complice);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.horasRestantes(), horasLimite-2-1);	
	}
		
	@Test
	public void heridaBalaEnPersonajeNovatoRetrasaCuatroHoras(){
		int horasLimite = 15;
		Pais pais=new Pais(1,1,"Argentina");
		PersonajeNovato personaje = new PersonajeNovato(horasLimite,pais,5);
		Edificio edificio = new Edificio();
		Bala bala= new Bala();
		Ladron ladron = new Ladron();
		ladron.agregarPais(pais);
		Complice complice= new Complice(ladron,bala);
		edificio.setComplice(complice);
		edificio.darPistaA(personaje);
		Assert.assertEquals(personaje.horasRestantes(), horasLimite-4-1);	
	}
}
