package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionPistasTest {

	public PersonajeInvestigador generarInvestigador(){
		return new PersonajeInvestigador(10, new Pais(1,1, "Argentina"), 5);
	}
	
	public PersonajeSargento generarSargento(){
		return new PersonajeSargento(10, new Pais(1,1, "Argentina"), 5);
	}
	
	@Test
	public void SargentoDebeRecibirPistaDificil(){
		PersonajeSargento sargento = generarSargento();
		Edificio edificio = new Edificio();
		Pista pistaDificil = new Pista("Pista dificil");
		
		edificio.agregarPistaDificil(pistaDificil);
		Pista pistaRecibida = sargento.pedirPistaA(edificio);
		
		Assert.assertEquals("Pista dificil", pistaRecibida.getPista());
	}
	
	@Test
	public void InvestigadorDebeRecibirPistaDificil(){
		PersonajeInvestigador personaje = generarInvestigador();
		Edificio edificio = new Edificio();
		Pista pistaDificil = new Pista("Pista dificil");
		
		edificio.agregarPistaDificil(pistaDificil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals("Pista dificil", pistaRecibida.getPista());
	}
	
	@Test
	public void DetectiveDeberiaRecibirPistaMedia(){
		PersonajeDetective personaje= new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		Edificio edificio = new Edificio();
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaMedia = new Pista("Pista Media");
		
		edificio.agregarPistaFacil(pistaFacil);
		edificio.agregarPistaMedia(pistaMedia);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Media");
	}
	
	@Test
	public void NovatoDebeRecibirPistaFacil(){
		PersonajeNovato personaje = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		Edificio edificio = new Edificio();
		Pista pistaFacil = new Pista("Pista Facil");
		Pista pistaDificil = new Pista("Pista Dificil");
		
		edificio.agregarPistaDificil(pistaDificil);	
		edificio.agregarPistaFacil(pistaFacil);
		Pista pistaRecibida = personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(pistaRecibida.getPista(), "Pista Facil");
	}

	@Test
	public void pedirPistaMultiplesVecesConSargentoRestaMasTiempo(){
		PersonajeSargento personaje = generarSargento();
		Edificio edificio = new Edificio();
		
		personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(9, personaje.horasRestantes());	
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(7, personaje.horasRestantes());
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(4, personaje.horasRestantes());
	}
	
}
