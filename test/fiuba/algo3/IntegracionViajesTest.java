package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionViajesTest {
	
	@Test
	public void SargentoNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeSargento personaje = new PersonajeSargento(10,new Pais(1,1,"Argentina"),5);
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void InvestigadorNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,new Pais(1,1,"Argentina"),5);
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void DetectiveNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeDetective personaje = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void NovatoNoDeberiaDescontarHorasAlViajarAlMismoLugarDeOrigen(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		int horasParaResolverElCaso = personaje.horasRestantes();
		Pais pais = new Pais(1,1,"Argentina");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == horasParaResolverElCaso );
	}
	
	@Test
	public void SargentoDeberiaDescontarHorasAlViajar(){
		PersonajeSargento personaje = new PersonajeSargento(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 9 );
	}	
	
	@Test
	public void InvestigadorDeberiaDescontarHorasAlViajar(){
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 9 );
	}
	
	@Test
	public void DetectiveDeberiaDescontarHorasAlViajar(){
		PersonajeDetective personaje = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 9 );
	}
	
	@Test
	public void NovatoDeberiaDescontarHorasAlViajar(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		Pais pais = new Pais(5,4,"Espania");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.horasRestantes() == 5 );
	}
	
	@Test
	public void SargentoDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeSargento personaje = new PersonajeSargento(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}	
	
	@Test
	public void InvestigadorDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeInvestigador personaje = new PersonajeInvestigador(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
	
	@Test
	public void DetectiveDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeDetective personaje = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
	
	@Test
	public void NovatoDeberiaSituarAlPersonajeEnElPaisDestino(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		Pais pais = new Pais(12,9,"Italia");
		personaje.viajarA(pais);
		
		Assert.assertTrue(personaje.getUbicacion() == pais);
	}
	
}
