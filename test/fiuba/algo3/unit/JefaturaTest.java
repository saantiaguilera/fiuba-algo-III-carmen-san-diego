package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Jefatura;
import fiuba.algo3.Ladron;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class JefaturaTest {
	
	@Test
	public void deberiaInicializarJefaturaSinOrdenEmitida() {
		Jefatura jefatura = new Jefatura(new Ladron());
	
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}
		
	@Test
	public void deberiaInicializarJefatura() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());
		
		Assert.assertNotNull(jefatura);
	}
	
	@Test
	public void deberiaDevolverLasOpcionesDelRasgoSexo() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());

		Assert.assertEquals(jefatura.getListaDeSexo().get(0) , "masculino");
		Assert.assertEquals(jefatura.getListaDeSexo().get(1) , "femenino");
	}
	
	@Test
	public void deberiaDevolverLasOpcionesDelRasgoHobby() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());

		Assert.assertEquals(jefatura.getListaDeHobys().get(0) , "alpinismo");
		Assert.assertEquals(jefatura.getListaDeHobys().get(1) , "croquet");
		Assert.assertEquals(jefatura.getListaDeHobys().get(2) , "tenis");
	}
	
	@Test
	public void deberiaDevolverLasOpcionesDelRasgoCabello() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());

		Assert.assertEquals(jefatura.getListaDeCabellos().get(0) , "negro");
		Assert.assertEquals(jefatura.getListaDeCabellos().get(1) , "colorado");
		Assert.assertEquals(jefatura.getListaDeCabellos().get(2) , "rubio");
		Assert.assertEquals(jefatura.getListaDeCabellos().get(3) , "castanio");
	}
	
	@Test
	public void deberiaDevolverLasOpcionesDelRasgoSenia() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());

		Assert.assertEquals(jefatura.getListaDeSenias().get(0) , "anillos");
		Assert.assertEquals(jefatura.getListaDeSenias().get(1) , "tatuajes");
		Assert.assertEquals(jefatura.getListaDeSenias().get(2) , "joyas");
	}	
	
	@Test
	public void deberiaDevolverLasOpcionesDelRasgoVehiculo() throws ParserConfigurationException, SAXException, IOException{
		File rasgosXML = new File("rasgos.xml");
		Assert.assertTrue(rasgosXML.exists());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc = db.parse(rasgosXML);
		doc.getDocumentElement().normalize();
		
		Jefatura jefatura = Jefatura.Hidratar(doc, new Ladron());

		Assert.assertEquals(jefatura.getListaDeVehiculos().get(0) , "moto");
		Assert.assertEquals(jefatura.getListaDeVehiculos().get(1) , "descapotable");
		Assert.assertEquals(jefatura.getListaDeVehiculos().get(2) , "limusina");
	}
}