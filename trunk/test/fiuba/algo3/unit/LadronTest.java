package fiuba.algo3.unit;

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

import fiuba.algo3.Ladron;
import fiuba.algo3.Pais;
import fiuba.algo3.Rasgo;
import fiuba.algo3.Sospechoso;

public class LadronTest {
	
	private Sospechoso generarSospechoso(){
		Sospechoso sospechoso = new Sospechoso();
		sospechoso.setSexo(new Rasgo("Femenino"));
		sospechoso.setHobby(new Rasgo("Alpinismo"));
		sospechoso.setCabello(new Rasgo("Rojo"));
		sospechoso.setSenia(new Rasgo("Anillo"));
		sospechoso.setVehiculo(new Rasgo("Descapotable"));
		
		return sospechoso;
	}
	
	public ArrayList<Pais> generarListaPaises(){
		ArrayList<Pais> listaPaises = new ArrayList<Pais>();
		listaPaises.add(new Pais(1,1, "Argentina"));
		listaPaises.add(new Pais(5,4, "Italia"));
		
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
	public void debeContenerUnaListaDePaises(){
		Ladron ladron = new Ladron(generarListaPaises(), "Juan Perez");
		
		Assert.assertEquals("Argentina", ladron.getPais(0).getNombre());
		Assert.assertEquals("Italia", ladron.getPais(1).getNombre());
	}
	
	@Test
	public void debeConservarInterfazHeredadaDeSospechoso(){
		Ladron ladron = generarLadron();
				
		Assert.assertEquals("Femenino", ladron.getSexo().getRasgo());
		Assert.assertEquals("Rojo", ladron.getCabello().getRasgo());
		Assert.assertEquals("Alpinismo", ladron.getHobby().getRasgo());
		Assert.assertEquals("Anillo", ladron.getSenia().getRasgo());
		Assert.assertEquals("Descapotable", ladron.getVehiculo().getRasgo());
	}
	
	@Test
	public void ladronDebeTenerNombre(){
		Ladron ladron = generarLadron();
		
		Assert.assertEquals("Carmen SanDiego", ladron.getNombre());
	}
	
	@Test
	public void debePoderCoincidirRasgosConOtroSospechoso(){
		Ladron ladron = generarLadron();
		Sospechoso sospechoso = generarSospechoso();
		
		Assert.assertTrue(ladron.coincideRasgosCon(sospechoso));
	}
	
	@Test
	public void deberiaHidratarseConElLadronNickBrunch() throws ParserConfigurationException, SAXException, IOException{
		File sospechososXML = new File("sospechosos.xml");
		Assert.assertTrue(sospechososXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(sospechososXML);
		doc.getDocumentElement().normalize();
		
		Ladron ladronCargado = Ladron.Hidratar(doc, 0);
		
		Assert.assertNotNull(ladronCargado);
		Assert.assertEquals( "Nick Brunch" , ladronCargado.getNombre());
		
	}
	
	@Test
	public void deberiaHidratarseConElLadronConRasgos() throws ParserConfigurationException, SAXException, IOException{
		File sospechososXML = new File("sospechosos.xml");
		Assert.assertTrue(sospechososXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(sospechososXML);
		doc.getDocumentElement().normalize();
		
		Ladron ladronCargado = Ladron.Hidratar(doc, 1);
		
		Assert.assertNotNull(ladronCargado);
		
		Assert.assertEquals( "colorado" , ladronCargado.getCabello().getRasgo());
		Assert.assertEquals( "tatuajes" , ladronCargado.getSenia().getRasgo());
		Assert.assertEquals( "descapotable" , ladronCargado.getVehiculo().getRasgo());
	}
}

