package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Pais;

public class PaisTest {

	@Test
	public void deberiaDevolverCorrectamenteLaPosicionEnX() {
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getPosisionX() == 10);
	}
	
	@Test
	public void deberiaDevolverCorrectamenteLaPosicionEnY(){
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getPosisionY() == 2);
	}

	@Test
	public void deberiaDevolverCorrectamenteElNombre(){
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getNombre() == "Uruguay");
	}
	
}
