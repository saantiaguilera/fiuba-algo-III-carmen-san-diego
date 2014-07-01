package fiuba.algo3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class IntegracionJefaturaPersistePersonajeTest {
	
	Ladron ladron;
	
	public IntegracionJefaturaPersistePersonajeTest() throws ParserConfigurationException, SAXException, IOException{
		ladron = new Ladron();
		
		File tesorosXML = new File("tesoros.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document docTesoros = dBuilder.parse(tesorosXML);
		docTesoros.getDocumentElement().normalize();
		Tesoros tesoros = new Tesoros(docTesoros);
		
		File paisesXML = new File("paises.xml");
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		Document docPaises = dBuilder.parse(paisesXML);
		docPaises.getDocumentElement().normalize();
		
		ladron.setCabello(new Rasgo("rubio"));
		ladron.setSexo(new Rasgo("masculino"));
		ladron.setHobby(new Rasgo("alpinismo"));
		ladron.setSenia(new Rasgo("tatuajes"));
		ladron.setVehiculo(new Rasgo("descapotable"));		
		
		ladron.robarUnTesoroRandom(tesoros, docPaises);
	}
	
	@Test
	public void jefaturaDevuelveUnaInstanciaDePersonaje(){
		Jefatura jefatura = new Jefatura(this.ladron);
		Personaje personaje = jefatura.asignarPersonajeConNombre("juanma");
		
		Assert.assertNotNull(personaje);
	}
}
