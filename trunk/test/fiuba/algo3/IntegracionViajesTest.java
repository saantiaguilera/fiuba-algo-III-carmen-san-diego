package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionViajesTest {

	@Test
	public void DetectiveNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeDetective personaje = new PersonajeDetective();
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void NovatoNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeNovato personaje = new PersonajeNovato();
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void DetectiveDeberiaDescontarHorasAlViajar(){
		PersonajeDetective personaje = new PersonajeDetective();
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 9 );
	}
	
	@Test
	public void NovatoDeberiaDescontarHorasAlViajar(){
		PersonajeNovato personaje = new PersonajeNovato();
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 5 );
	}
	
	@Test
	public void DetectiveDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeDetective personaje = new PersonajeDetective();
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
	
	@Test
	public void NovatoDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeNovato personaje = new PersonajeNovato();
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
	
}
