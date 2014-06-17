package fiuba.algo3;


import org.junit.Assert;
import org.junit.Test;

public class IntegracionPersonajeSeQuedaSinTiempoTest {
	
	@Test
	public void integracion(){
		Pais primerPais = new Pais(1,2,"Argentina");
		Pais segundoPais = new Pais(4,5,"Ghana");
		Pais tercerPais = new Pais(6,7,"Turquia");
		Ladron ladron = new Ladron();
		ladron.agregarPais(primerPais);
		ladron.agregarPais(segundoPais);
		ladron.agregarPais(tercerPais);
		//Jefatura jefatura = new Jefatura(ladron); No lo uso porque no necesito emitir orden
		PersonajeNovato jugador = new PersonajeNovato(10,primerPais,1);
		
		

		
		
		Edificio primerEdificio = new Edificio(false);
		Edificio segundoEdificio = new Edificio(false);
		Edificio tercerEdificio = new Edificio(false);
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(segundoPais);

		
		
		
		if (ladron.esUltimoPais(segundoPais)){		
			primerEdificio = new Edificio(true);
			segundoEdificio = new Edificio(true);
			tercerEdificio = new Edificio(true);
			ladron.esconderse(primerEdificio, segundoEdificio, tercerEdificio);
		}
		else{		
			primerEdificio = new Edificio(false);
			segundoEdificio = new Edificio(false);
			tercerEdificio = new Edificio(false);
		}
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(tercerPais);

		
		
		
		if (ladron.esUltimoPais(tercerPais)){	
			primerEdificio = new Edificio(true);
			segundoEdificio = new Edificio(true);
			tercerEdificio = new Edificio(true);
			ladron.esconderse(primerEdificio, segundoEdificio, tercerEdificio);	
		}
		else{		
			primerEdificio = new Edificio(false);
			segundoEdificio = new Edificio(false);
			tercerEdificio = new Edificio(false);
		}
		primerEdificio = new Edificio(true);
		segundoEdificio = new Edificio(true);
		tercerEdificio = new Edificio(true);
		primerEdificio.setSeEscondioElLadron(true);
		segundoEdificio.setTienenArmas(true);
		tercerEdificio.setTienenCuchillos(true);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		
		Assert.assertFalse(jugador.getHorasLimite()>=0);
	}
}
