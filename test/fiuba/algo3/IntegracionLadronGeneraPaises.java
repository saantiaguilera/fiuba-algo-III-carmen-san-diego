package fiuba.algo3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class IntegracionLadronGeneraPaises {
	
	@Test
	public void ladronDeberiaElegirseAleatorioLosPaises() throws ParserConfigurationException, SAXException, IOException{
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
		
		Ladron ladron = new Ladron("Juan Perez");
		ladron.setCabello(new Rasgo("rojo"));
		ladron.setSenia(new Rasgo("tatuajes"));
		ladron.setSexo(new Rasgo("masculino"));
		ladron.setHobby(new Rasgo("alpinismo"));
		ladron.setVehiculo(new Rasgo("moto"));
		
		ladron.robarUnTesoroRandom(tesoros, docPaises);
		
		Assert.assertTrue(ladron.getCantPaises() >= 4);
		
		ArrayList<String> nombrePaises = new ArrayList<String>();
		for(int i=0; i<ladron.getCantPaises(); i++){
			Assert.assertFalse(nombrePaises.contains(ladron.getPais(i).getNombre()));
			nombrePaises.add(ladron.getPais(i).getNombre());
			
		}
	}
	
}
