package fiuba.algo3;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionOrdenArrestoTest {
	
	public ArrayList<Pais> generarListaPaises(){
		ArrayList<Pais> listaPaises = new ArrayList<Pais>();
		listaPaises.add(new Pais(2,2, "Brasil"));
		listaPaises.add(new Pais(5,5, "Inglaterra"));
		listaPaises.add(new Pais(3,4, "Sudafrica"));
		
		return listaPaises;
	}
		
	public Ladron generarLadron(){
		Ladron ladron = new Ladron(generarListaPaises(), "Carmen SanDiego");
		
		ladron.setSexo(new Rasgo("Femenino"));
		ladron.setCabello(new Rasgo("Rojo"));
		ladron.setHobby(new Rasgo("Alpinismo"));
		ladron.setSenia(new Rasgo("Anillo"));
		ladron.setVehiculo(new Rasgo("Descapotable"));
		
		return ladron;
	}
	
	@Test
	public void emiteOrdenSiEsCorrecta(){

		Rasgo SEXO = new Rasgo("Masculino");
		Rasgo CABELLO = new Rasgo("Rubio");
		Rasgo SENIA = new Rasgo("Tatuaje");
				
		Ladron ladron = new Ladron();
		Sospechoso sospechoso = new Sospechoso();
				
		ladron.setSexo(SEXO);
		sospechoso.setSexo(SEXO);
		ladron.setCabello(CABELLO);
		sospechoso.setCabello(CABELLO);
		ladron.setSenia(SENIA);
		sospechoso.setSenia(SENIA);
	
		Jefatura jefatura = new Jefatura(ladron);
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertTrue(jefatura.ordenEstaEmitida());
	}
	
	@Test
	public void noDeberiaEmitirOrdenSiEsIncorrecta(){
		
		Ladron ladron = new Ladron();
		Sospechoso sospechoso = new Sospechoso();	
		
		Rasgo HOBBY_LADRON = new Rasgo("Tenis");
		Rasgo HOBBY_SOSP = new Rasgo("Alpinismo");
		
		ladron.setHobby(HOBBY_LADRON);
		sospechoso.setHobby(HOBBY_SOSP);
		
		Jefatura jefatura = new Jefatura(ladron);		
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertFalse(jefatura.ordenEstaEmitida());
		}
	
	@Test
	public void coincidirTresRasgosPeroErrarUnoNoDeberiaEmitirOrden(){
		
		Ladron ladron = new Ladron();
		Sospechoso sospechoso = new Sospechoso();
		
		ladron.setSexo(new Rasgo("Masculino"));
		sospechoso.setSexo(new Rasgo("Masculino"));
		ladron.setCabello(new Rasgo("Rubio"));
		sospechoso.setCabello(new Rasgo("Rubio"));
		ladron.setHobby(new Rasgo("Musica"));
		sospechoso.setHobby(new Rasgo("Musica"));
		
		ladron.setSenia(new Rasgo("Tatuaje"));
		sospechoso.setSenia(new Rasgo("Anillo"));
		
		Jefatura jefatura = new Jefatura(ladron);
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}
	
	@Test
	public void emitirUnaOrdenRestaTiempo(){
		PersonajeNovato personaje = new PersonajeNovato(150, new Pais(2,2, "Brasil"), 5);
		Jefatura jefatura = new Jefatura(generarLadron());
				
		personaje.emitirOrdenA(jefatura, new Sospechoso());
		
		Assert.assertEquals(147, personaje.getHorasRestantes());
	}
}
