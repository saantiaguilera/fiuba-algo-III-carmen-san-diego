package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeNovatoTest {
	
	@Test
	public void debeRecibirPistaParaNovatos(){
		PersonajeNovato personaje = new PersonajeNovato();
		Edificio edificio = new Edificio();
		Pista pista = personaje.pedirPistaA(edificio);
		
		Assert.assertTrue(pista.esNovato());
	}
	
	
}
