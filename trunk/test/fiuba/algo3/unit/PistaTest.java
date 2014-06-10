package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Pista;

public class PistaTest {
	
	@Test
	public void inicializaConStringPista(){
		Pista pista = new Pista();
		
		Assert.assertEquals(pista.getPista(), "Pista");
	}
	
	@Test
	public void alCrearseSePuedeCambiarElContenidoDefault(){
		Pista pista = new Pista("Contenido arbitrario");
		
		Assert.assertEquals("Contenido arbitrario", pista.getPista());
	}
}
