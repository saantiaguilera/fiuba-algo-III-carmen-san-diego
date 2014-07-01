package fiuba.algo3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class IntegracionJefaturaPersistePersonajeTest {
	
	Ladron ladron;
	String nombreDeArchivo;
	
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
	
	@Before
	public void before(){
		this.nombreDeArchivo = java.util.UUID.randomUUID().toString() + ".xml";
	}
	
	@After
	public void after(){
		File archivo = new File(this.nombreDeArchivo);
		if(archivo.exists())
			archivo.delete();
	}
	
	@Test
	public void jefaturaDevuelveUnaInstanciaDePersonajeYActualiza() throws ParserConfigurationException, TransformerException{
		Jefatura jefatura = new Jefatura(this.ladron);
		File personajesXML = new File(this.nombreDeArchivo);
		
		//Preparo personajesXML para que contenga <Personajes/>
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		Element elementoPersonajes = doc.createElement("Personajes");
		doc.appendChild(elementoPersonajes);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(personajesXML);
		transformer.transform(source, result);
	
		//Verifico la escritura
		jefatura.sumarCasoAXML(personajesXML, "pepito");
		
		Assert.assertNotNull(personajesXML.toString());
		
		
		//Verifico la lectura
		Personaje personaje = jefatura.asignarPersonajeConNombre(personajesXML, "pepito");
		Assert.assertNotNull(personaje);
	}

}
