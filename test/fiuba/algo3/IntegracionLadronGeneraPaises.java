package fiuba.algo3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class IntegracionLadronGeneraPaises {
	
	Ladron ladron;
	
	@Before
	public void before() throws ParserConfigurationException, SAXException, IOException{
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
		
		ladron = new Ladron("Juan Perez");
		ladron.setCabello(new Rasgo("rojo"));
		ladron.setSenia(new Rasgo("tatuajes"));
		ladron.setSexo(new Rasgo("masculino"));
		ladron.setHobby(new Rasgo("alpinismo"));
		ladron.setVehiculo(new Rasgo("moto"));
		
		ladron.robarUnTesoroRandom(tesoros, docPaises);
	}
	
	@Test
	public void ladronDeberiaElegirseAleatorioLosPaises() throws ParserConfigurationException, SAXException, IOException{

		Assert.assertTrue(this.ladron.getCantPaises() >= 4);
		
		ArrayList<String> nombrePaises = new ArrayList<String>();
		for(int i=0; i<this.ladron.getCantPaises(); i++){
			Assert.assertFalse(nombrePaises.contains(this.ladron.getPais(i).getNombre()));
			nombrePaises.add(this.ladron.getPais(i).getNombre());
			
		}
	}
	
	@Test
	public void ladronVerificaSiEstuvoEnUnPais(){
		Pais paisPrimero = this.ladron.getPais(0);
		Assert.assertTrue(this.ladron.estuvoEn(paisPrimero));
	}
	
}
