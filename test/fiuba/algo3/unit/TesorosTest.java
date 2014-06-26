package fiuba.algo3.unit;

import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import fiuba.algo3.Tesoros;;

public class TesorosTest {
	
	private String nombreArchivo;
	private Tesoros Tesoro;
	
	@Test
	public void esCorrectaLaPista() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		this.nombreArchivo = "tesoros.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		File archivo = new File(this.nombreArchivo);
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Tesoro = new Tesoros(doc);
		
		
		Assert.assertTrue(Tesoro.getCantidadDeTesoros()>0);
		
		
	}
}
