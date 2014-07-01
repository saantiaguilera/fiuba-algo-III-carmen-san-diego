package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.*;

public class PersonajeDetectiveTest {

	@Test
	public void deberiaDevolverHorasLimiteCorrectas() {
		PersonajeDetective personaje = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5,null);
		
		Assert.assertTrue(personaje.getHorasRestantes() == 10);
	}

	@Test
	public void deberiaDevolverUbicacionCorrecta(){
		Pais pais = new Pais(1,1,"Argentina");
		PersonajeDetective personaje = new PersonajeDetective(10,pais,5,null);
		
		Assert.assertEquals(personaje.getUbicacion() , pais);
	}
	
	@Test
	public void deberiaDevolverHorasRestantesCorrectas(){
		PersonajeDetective personaje = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5,null);	
		personaje.restarHoras(7);
	
		Assert.assertTrue(personaje.getHorasRestantes() == 3);
	}
}
