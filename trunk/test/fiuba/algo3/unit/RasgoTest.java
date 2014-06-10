package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Rasgo;

public class RasgoTest {
	
	@Test
	public void laInstanciaContieneInfoDelRasgo(){
		Rasgo rasgo = new Rasgo("Castanio");
		
		Assert.assertEquals("Castanio", rasgo.getRasgo());
	}
	
	@Test
	public void deberiaReconocerQueTieneRasgo(){
		Rasgo rasgo = new Rasgo("Alpinismo");
		
		Assert.assertTrue(rasgo.tieneRasgo());
	}
	
	@Test public void noDeberiaReconocerQueTieneRasgoSiEsAsi(){
		Rasgo rasgo = new Rasgo(null);
		
		Assert.assertFalse(rasgo.tieneRasgo());
	}
}
