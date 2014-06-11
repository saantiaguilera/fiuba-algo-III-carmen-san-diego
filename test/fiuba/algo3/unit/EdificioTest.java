package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.*;

public class EdificioTest {

	@Test
	public void deberiaInicializarEdificioConCeroVisitas() {
		Edificio edificio = new Edificio(0,0);
		Assert.assertEquals(0 , edificio.vecesVisitado());
	}
	
	@SuppressWarnings("unused") //suprimo los warnings de que no se utilizan las pistas
	@Test
	public void deberiaDevolverTresVisitas(){
		Edificio edificio = new Edificio(0,0);
		PersonajeDetective personajeDetective = new PersonajeDetective(10,new Pais(1,1,"Argentina"),5);
		PersonajeNovato personajeNovato = new PersonajeNovato(10,new Pais(1,1,"Argentina"),1);
		Pista pistaRecibida1 = personajeDetective.pedirPistaA(edificio);
		Pista pistaRecibida2 = personajeNovato.pedirPistaA(edificio);
		Pista pistaRecibida3 = personajeDetective.pedirPistaA(edificio);
		
		Assert.assertEquals(3 , edificio.vecesVisitado());
	}

}
