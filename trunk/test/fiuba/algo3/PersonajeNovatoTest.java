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
	
	@Test
	public void noDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeNovato personaje = new PersonajeNovato();
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void deberiaDescontarHorasAlViajar(){
		PersonajeNovato personaje = new PersonajeNovato();
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 5 );
	}
	
	@Test
	public void deberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeNovato personaje = new PersonajeNovato();
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
}
