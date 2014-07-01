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
		PersonajeNovato jugador = new PersonajeNovato(10,primerPais,1,null);
		
		

		
		
		Edificio primerEdificio = new Edificio();
		Edificio segundoEdificio = new Edificio();
		Edificio tercerEdificio = new Edificio();
		if (ladron.esUltimoPais(jugador.getUbicacion())){
			ladron.esconderse(primerEdificio,segundoEdificio,tercerEdificio);
		}
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(segundoPais);

		
		
		
		
		primerEdificio = new Edificio();
		segundoEdificio = new Edificio();
		tercerEdificio = new Edificio();
		if (ladron.esUltimoPais(jugador.getUbicacion())){
			ladron.esconderse(primerEdificio,segundoEdificio,tercerEdificio);
		}
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(tercerPais);

		
		
		
		
		primerEdificio = new Edificio();
		segundoEdificio = new Edificio();
		tercerEdificio = new Edificio();
		if (ladron.esUltimoPais(jugador.getUbicacion())){
			ladron.esconderse(primerEdificio,segundoEdificio,tercerEdificio);
		}
		primerEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		
		Assert.assertFalse(jugador.getHorasRestantes()>=0);
	}
}
