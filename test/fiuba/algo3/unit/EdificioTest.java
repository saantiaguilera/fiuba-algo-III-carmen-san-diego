package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.*;

public class EdificioTest {

	@Test
	public void deberiaInicializarEdificioConCeroVisitas() {
		Edificio edificio = new Edificio();
		Assert.assertEquals(0 , edificio.vecesVisitado());
	}
	
	@Test
	public void deberiaDevolverTresVisitas(){
		Edificio edificio = new Edificio();
		PersonajeDetective personajeDetective = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5,null);
		PersonajeNovato personajeNovato = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1,null);
		
		personajeDetective.pedirPistaA(edificio);
		personajeNovato.pedirPistaA(edificio);
		personajeDetective.pedirPistaA(edificio);
		
		Assert.assertEquals(3 , edificio.vecesVisitado());
	}

}
