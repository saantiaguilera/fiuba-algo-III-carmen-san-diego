package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Pais;
import fiuba.algo3.PersonajeNovato;

public class PersonajeNovatoTest {

	@Test
	public void deberiaDevolverHorasLimiteCorrectas() {
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),5,null);
		
		Assert.assertTrue(personaje.getHorasRestantes() == 10);
	}

	@Test
	public void deberiaDevolverUbicacionCorrecta(){
		Pais pais = new Pais(1,1,"Argentina");
		PersonajeNovato personaje = new PersonajeNovato(10,pais,5,null);
		
		Assert.assertEquals(personaje.getUbicacion() , pais);
	}
	
	@Test
	public void deberiaDevolverHorasRestantesCorrectas(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),5,null);	
		personaje.restarHoras(7);
	
		Assert.assertTrue(personaje.getHorasRestantes() == 3);
	}
}
