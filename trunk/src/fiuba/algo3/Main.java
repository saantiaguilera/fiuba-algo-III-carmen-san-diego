package fiuba.algo3;

import java.io.*; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;





//import org.junit.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class Main {
	
	public static void main (String [] args) throws IOException{
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
		
		Mundo mundo = new Mundo(docPaises);
		Tesoros tesoro = new Tesoros(docTesoros);
		Ladron ladron = Ladron.Hidratar(docLadron,1);
		Jefatura jefatura = Jefatura.Hidratar(docJefatura, ladron);
		ladron.robarUnTesoroRandom(tesoro, docPaises);
		//Aca hay que fijarse que si ya existe tu personaje no se cree un novato y te "cargue" el tuyo, no puede ser
		//Personaje solo porque perdemos dispatching
		PersonajeNovato personaje = new PersonajeNovato(150,ladron.getPais(0),900, jefatura); 
		
		System.out.print("se ha robado un tesoro en ");
		System.out.print(ladron.getPais(0).getNombre());
		System.out.println(" debe seguir las pistas hasta encontrar al ladron");
		
		int numero;
		int otroNumero;
		
		while (personaje.capturoAlLadron()!=true & personaje.getHorasRestantes()>0){
			System.out.println("Elija una opcion");
			System.out.println("1. Pedir pista a un edificio");
			System.out.println("2. Viajar a un pais");
			System.out.println("3. Emitir orden de arresto");
			numero = System.in.read();
			switch (numero){
			case 1:
				Pais paisActual = personaje.getUbicacion();
				paisActual = Pais.hidratar(docPaises, paisActual.getNombre(), ladron.getPaisActual(paisActual).getNombre(), ladron);//Hace falta esto?
				System.out.println("Que edificio desea visitar?");
				System.out.println("1. Biblioteca");
				System.out.println("2. Puerto");
				System.out.println("3. Banco");
				otroNumero = System.in.read();
				switch(otroNumero){
				case 1:
					paisActual.biblioteca.darPistaA(personaje);
					break;
				case 2:
					paisActual.puerto.darPistaA(personaje);
					break;
				case 3:
					paisActual.banco.darPistaA(personaje);
					break;
				}
			case 2:
				personaje.elegirPaisAViajar(mundo, docPaises);
				break;
			case 3:
				//emitir orden de arresto
				break;
			}
			
		}
		System.out.println(ladron.getPais(0).getNombre());
		System.out.println(ladron.getPais(1).getNombre());
		System.out.println(ladron.getPais(2).getNombre());
		System.out.println(personaje.pedirPistaA(ladron.getPais(0).banco).getPista());
		
	}

}