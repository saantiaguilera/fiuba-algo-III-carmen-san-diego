package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeDetectiveTest {
	
	@Test
	public void deberiaRecibirPistaParaDetective(){
		PersonajeDetective personaje = new PersonajeDetective();
		Edificio edificio = new Edificio();
		Pista pista = personaje.pedirPistaA(edificio);
		
		Assert.assertTrue(pista.esDetective());
	}
}
