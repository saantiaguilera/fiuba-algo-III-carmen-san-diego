package fiuba.algo3;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class IntegracionPartidaTest {
	
	public int HORAS_LIMITE;
	public Pais ARGENTINA;
	public Pais PARAGUAY;
	public Pais ECUADOR;
	
	public IntegracionPartidaTest(){
		HORAS_LIMITE = 150;
		ARGENTINA = new Pais(-2000, -4000, "Argentina");
		PARAGUAY = new Pais(-2000, -3000, "Paraguay");
		ECUADOR = new Pais(0, -4000, "Ecuador");
	}
	
	public ArrayList<Pais> generarListaPaises(){
		ArrayList<Pais> listaPaises = new ArrayList<Pais>();
		listaPaises.add(ARGENTINA);
		listaPaises.add(PARAGUAY);
		listaPaises.add(ECUADOR);
		
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
	
	public PersonajeNovato generarPersonajeNovato(){
		return new PersonajeNovato(HORAS_LIMITE, ARGENTINA);
	}
	
	public Edificio generarBibliotecaConPistaFacilDe(Pais pais){
		Edificio biblio;
		
		if(pais == PARAGUAY){
			biblio = new Edificio(false);
			biblio.agregarPistaFacil(new Pista("Queria ver la triple forntera"));
		}
		else{
			biblio = new Edificio(true);
			biblio.agregarPistaFacil(new Pista("Queria ir a la linea ecuatorial. Tenia un anillo"));
		}
		
		return biblio;
	}
	
	public Edificio generarPuertoConPistaFacilDe(Pais pais){
		Edificio puerto;
		
		if(pais == PARAGUAY){
			puerto = new Edificio(false);
			puerto.agregarPistaFacil(new Pista("Se fue en un auto con la bandera roja, blanca y azul"));
		}
		else{
			puerto = new Edificio(true);
			puerto.agregarPistaFacil(new Pista("Bandera amarilla, roja y azul, con un escudo"));
		}
		
		return puerto;		
	}
	
	public Edificio generarBancoConPistaFacilDe(Pais pais){
		Edificio banco;
		
		if(pais == PARAGUAY){
			banco = new Edificio(false);
			banco.agregarPistaFacil(new Pista("Se fue en un auto con la bandera roja, blanca y azul"));
		}
		else{
			banco = new Edificio(true);
			banco.agregarPistaFacil(new Pista("Bandera amarilla, roja y azul, con un escudo"));
		}
		
		return banco;			
	}
	
	@Test
	public void personajeAtrapaALadron(){
		Ladron ladron = generarLadron();
		PersonajeNovato personaje = generarPersonajeNovato();
		Jefatura jefatura = new Jefatura(ladron);
		
		Edificio biblioteca = generarBibliotecaConPistaFacilDe(PARAGUAY);
		Edificio puerto = generarPuertoConPistaFacilDe(PARAGUAY);
		Edificio banco = generarBancoConPistaFacilDe(PARAGUAY);
				
		personaje.pedirPistaA(biblioteca);
		personaje.pedirPistaA(puerto);
		personaje.pedirPistaA(banco);
		
		personaje.viajarA(PARAGUAY);
		
		Assert.assertEquals(146, personaje.horasRestantes());
		
		biblioteca = generarBibliotecaConPistaFacilDe(ECUADOR);
		puerto = generarPuertoConPistaFacilDe(ECUADOR);
		banco = generarBancoConPistaFacilDe(ECUADOR);		
				
		personaje.pedirPistaA(biblioteca);
		personaje.pedirPistaA(puerto);
		personaje.pedirPistaA(banco);
		
		Assert.assertEquals(1, banco.vecesVisitado());
		personaje.pedirPistaA(banco);
				
		Assert.assertEquals(141, personaje.horasRestantes());
		
		Sospechoso sospechoso = new Sospechoso();
		sospechoso.setSexo(new Rasgo("Femenino"));
		sospechoso.setSenia(new Rasgo("Anillo"));
		sospechoso.setCabello(new Rasgo("Rojo"));
		Assert.assertTrue(ladron.coincideRasgosCon(sospechoso));
		
		personaje.emitirOrdenA(jefatura, sospechoso);
		
		personaje.viajarA(ECUADOR);
		
		Assert.assertEquals(136, personaje.horasRestantes());	
		Assert.assertTrue(jefatura.ordenEstaEmitida());
		
	}
}
