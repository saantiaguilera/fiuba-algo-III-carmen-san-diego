package fiuba.algo3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.junit.Assert;
import org.junit.Test;

public class IntegracionPistasTest {

	PersonajeSargento sargento;
	PersonajeInvestigador investigador;
	PersonajeDetective detective;
	PersonajeNovato novato;
	
	public IntegracionPistasTest(){
		this.sargento = new PersonajeSargento(10, new Pais(1,1, "Argentina"), 5);
		this.investigador = new PersonajeInvestigador(10, new Pais(1,1, "Argentina"), 5);
		this.detective = new PersonajeDetective(10, new Pais(1,1, "Argentina"), 5);
		this.novato = new PersonajeNovato(10, new Pais(1,1, "Argentina"), 5);
	}
			
	@Test
	public void SargentoDebeRecibirPistaDificil(){
		PersonajeSargento sargento = this.sargento;
		Edificio edificio = new Edificio();
		Pista pistaDificil = new Pista("Pista dificil");
		
		edificio.agregarPistaDificil(pistaDificil);
		Pista pistaRecibida = sargento.pedirPistaA(edificio);
		
		Assert.assertEquals("Pista dificil", pistaRecibida.getPista());
	}
	
	@Test
	public void InvestigadorDebeRecibirPistaDificil(){
		PersonajeInvestigador personaje = this.investigador;
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
		PersonajeSargento personaje = this.sargento;
		Edificio edificio = new Edificio();
		
		personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(9, personaje.getHorasRestantes());	
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(7, personaje.getHorasRestantes());
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(4, personaje.getHorasRestantes());
	}
	
	@Test
	public void pedirPistaMultiplesVecesConInvestigadorRestaMasTiempo(){
		PersonajeInvestigador personaje = this.investigador;
		Edificio edificio = new Edificio();
		
		personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(9, personaje.getHorasRestantes());	
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(7, personaje.getHorasRestantes());
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(4, personaje.getHorasRestantes());
	}
	
	@Test
	public void pedirPistaMultiplesVecesConDetectiveRestaMasTiempo(){
		PersonajeDetective personaje = this.detective;
		Edificio edificio = new Edificio();
		
		personaje.pedirPistaA(edificio);
		
		Assert.assertEquals(9, personaje.getHorasRestantes());	
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(7, personaje.getHorasRestantes());
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(4, personaje.getHorasRestantes());
	}
	
	@Test
	public void pedirPistaMultiplesVecesConNovatoRestaMasTiempo(){
		PersonajeNovato personaje = this.novato;
		Edificio edificio = new Edificio();
		
		personaje.pedirPistaA(edificio);

		Assert.assertEquals(9, personaje.getHorasRestantes());	
		
		personaje.pedirPistaA(edificio);

		Assert.assertEquals(7, personaje.getHorasRestantes());
		
		personaje.pedirPistaA(edificio);
		Assert.assertEquals(4, personaje.getHorasRestantes());
	}
	
	@Test
	public void paisDeberiaHidratarseConSusPistas() throws ParserConfigurationException, SAXException, IOException{
		File paisesXML = new File("paises.xml");
		Assert.assertTrue(paisesXML.exists());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(paisesXML);
		doc.getDocumentElement().normalize();
		
		Pais pais = Pais.hidratar(doc, "Argentina", "Paraguay");
		Pista pista = pais.biblioteca.darPistaA(this.sargento);
		
		Assert.assertNotNull(pista);
	}
	
	@Test
	public void piasPuedeHidratarseConPistasIncorrectas() throws ParserConfigurationException, SAXException, IOException{
		File paisesXML = new File("paises.xml");
		Assert.assertTrue(paisesXML.exists());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(paisesXML);
		doc.getDocumentElement().normalize();
		
		Pais pais = Pais.hidratar(doc, "Argentina", null);
		Pista pista = pais.biblioteca.darPistaA(this.sargento);
		String noFueVisto = "Lo siento, no hemos visto a esa persona";
		
		Assert.assertEquals(noFueVisto, pista.getPista());
	}
	
	
}

