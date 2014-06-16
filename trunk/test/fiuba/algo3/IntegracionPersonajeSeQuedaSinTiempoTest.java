package fiuba.algo3;


import org.junit.Assert;
import org.junit.Test;

public class IntegracionPersonajeSeQuedaSinTiempoTest {
	
	@Test
	public void integracion(){
		Pais primerPais = new Pais(1,2,"Argentina");
		Pais segundoPais = new Pais(4,5,"Ghana");
		Pais tercerPais = new Pais(6,7,"Turquia");
		//Inicializador ladron con una lista de estos 3 paises
		//Sospechoso ladron= new Sospechoso();
		//Jefatura jefatura = new Jefatura(ladron); No lo uso porque no necesito emitir orden
		PersonajeNovato jugador = new PersonajeNovato(10,primerPais,1);
		
		
		Edificio primerEdificio = new Edificio(false);
		Edificio segundoEdificio = new Edificio(false);
		Edificio tercerEdificio = new Edificio(false);
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(segundoPais);
		//ladron tiene que viajar a el next de su lista
		//si es el ultimo edificio se setea uno con cuchillo otro con bala y en otro se esconde
		
		primerEdificio = new Edificio(false);
		segundoEdificio = new Edificio(false);
		tercerEdificio = new Edificio(false);
		primerEdificio.darPistaA(jugador);
		segundoEdificio.darPistaA(jugador);
		tercerEdificio.darPistaA(jugador);
		jugador.viajarA(tercerPais);
		//ladron tiene que viajar a el next de su lista
		//si es el ultimo edificio se setea uno con cuchillo otro con bala y en otro se esconde
		
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
