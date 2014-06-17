package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Pais;

public class PaisTest {

	@Test
	public void deberiaDevolverCorrectamenteLaPosicionEnX() {
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getPosicionX() == 10);
	}
	
	@Test
	public void deberiaDevolverCorrectamenteLaPosicionEnY(){
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getPosicionY() == 2);
	}

	@Test
	public void deberiaDevolverCorrectamenteElNombre(){
		Pais pais = new Pais(10,2,"Uruguay");
		
		Assert.assertTrue(pais.getNombre() == "Uruguay");
	}
	
	@Test
	public void deberiaCalcularLaDistanciaConOtroPais(){
		Pais paisOrigen = new Pais(-2, -1, "Argentina");
		Pais paisDestino = new Pais(2, 2, "Uruguay");
		
		Assert.assertTrue(5 == paisOrigen.calcularDistanciaCon(paisDestino));
	}
}
