package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class PersonajeDetectiveTest {
	
	@Test
	public void deberiaRecibirPistaParaDetective(){
		PersonajeDetective personaje= new PersonajeDetective();
		Edificio edificio = new Edificio();
		Pista pista = personaje.pedirPistaA(edificio);
		
		Assert.assertTrue(pista.esDetective());
	}
	
	@Test
	public void noDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeDetective personaje = new PersonajeDetective();
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void deberiaDescontarHorasAlViajar(){
		PersonajeDetective personaje = new PersonajeDetective();
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 9 );
	}
	
	@Test
	public void deberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeDetective personaje = new PersonajeDetective();
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
}
