package fiuba.algo3;

import java.io.*; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


//import org.junit.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class Main {
	
	public static void main (String [] args){
		//Scanner stdin = new Scanner (System.in); 
		System.out.println("Bievenido detective, su rango actual es novato"); 
		//int numero= stdin.nextInt(); 
		//System.out.println(numero); 
		
		File sospechososXML = new File("sospechosos.xml");
		File rasgosXML = new File("rasgos.xml");
		File tesorosXML = new File("tesoros.xml");
		File paisesXML = new File("paises.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document docLadron = null;
		Document docJefatura = null;
		Document docTesoros = null;
		Document docPaises = null;
		try{
			db = dbf.newDocumentBuilder();
			docLadron = db.newDocument();
			docLadron = db.parse(sospechososXML);
			docJefatura = db.newDocument();
			docJefatura = db.parse(rasgosXML);
			docTesoros = db.newDocument();
			docTesoros = db.parse(tesorosXML);
			docPaises = db.newDocument();
			docPaises = db.parse(paisesXML);
			}
		catch (ParserConfigurationException  e) {}
		catch (SAXException e){} 
		catch (IOException e){}
		docLadron.getDocumentElement().normalize();
		docJefatura.getDocumentElement().normalize();
		docTesoros.getDocumentElement().normalize();
		docPaises.getDocumentElement().normalize();
		
		Tesoros tesoro = new Tesoros(docTesoros);
		Ladron ladron = Ladron.Hidratar(docLadron,1);
		Jefatura jefatura = Jefatura.Hidratar(docJefatura, ladron);
		ladron.robarUnTesoroRandom(tesoro, docPaises);
		Personaje personaje = new PersonajeNovato(150,ladron.getPais(0),900, jefatura); 
		
		System.out.print("se ha robado un tesoro en ");
		System.out.print(ladron.getPais(0).getNombre());
		System.out.println(" debe seguir las pistas hasta encontrar al ladron");
		
		
		System.out.println(personaje.pedirPistaA(ladron.getPais(0).banco).getPista());
		
	}

}