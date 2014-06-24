package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Pais;
import fiuba.algo3.PersonajeInvestigador;

public class PersonajeInvestigadorTest {

	@Test
	public void deberiaDevolverHorasLimiteCorrectas() {
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,new Pais(1,1,"Argentina"),5);
		
		Assert.assertTrue(personaje.getHorasRestantes() == 10);
	}

	@Test
	public void deberiaDevolverUbicacionCorrecta(){
		Pais pais = new Pais(1,1,"Argentina");
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,pais,5);
		
		Assert.assertEquals(personaje.getUbicacion() , pais);
	}
	
	@Test
	public void deberiaDevolverHorasRestantesCorrectas(){
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,new Pais(1,1,"Argentina"),5);	
		personaje.restarHoras(7);
	
		Assert.assertTrue(personaje.getHorasRestantes() == 3);
	}
	
}
