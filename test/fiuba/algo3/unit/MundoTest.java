package fiuba.algo3.unit;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import fiuba.algo3.Mundo;

public class MundoTest {
	private String nombreArchivo;
	private Mundo mundo;
	
	@Test
	public void esCorrectaLaPista() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		this.nombreArchivo = "paises.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		File archivo = new File(this.nombreArchivo);
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		mundo = new Mundo(doc);
		String unPais = "Argentina";
		
		Assert.assertTrue(mundo.getUnPaisDistintoDe(unPais)!=null);
	}
}
