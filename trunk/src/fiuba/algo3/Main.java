package fiuba.algo3;

import java.io.*; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {
	
	public static void main (String [] args) throws IOException{
		
		File sospechososXML = new File("sospechosos.xml");
		File rasgosXML = new File("rasgos.xml");
		File tesorosXML = new File("tesoros.xml");
		File paisesXML = new File("paises.xml");
		File personajesXML = new File("personajes.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document docLadron = null;
		Document docJefatura = null;
		Document docTesoros = null;
		Document docPaises = null;
		Document docPersonajes = null;
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
			docPersonajes = db.parse(personajesXML);
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
		
		//Empieza la partida para el jugador
		String nombrePersonaje;
		System.out.println("Ingrese su nombre:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nombrePersonaje = br.readLine();		
		Personaje personaje = jefatura.asignarPersonajeConNombre(docPersonajes, nombrePersonaje);
		System.out.println("Bienvenido, " + personaje.rango());
		System.out.println();
		
		System.out.println("ULTIMA NOTICIA");
		System.out.print("Ladron de sexo ");
		System.out.print(ladron.getSexo().getRasgo());
		System.out.print(" se ha robado un tesoro en ");
		System.out.print(ladron.getPais(0).getNombre());
		System.out.println(". Debe seguir las pistas hasta encontrar al ladron");
		
		char numero;
		char otroNumero;
		
		while (!personaje.ladronCapturado() & personaje.getHorasRestantes()>0){
			System.out.println();
			System.out.print("HORAS: ");
			System.out.println(personaje.getHorasRestantes());
			System.out.print("PAIS: ");
			System.out.println(personaje.getUbicacion().getNombre());
			System.out.println("Elija una opcion");
			System.out.println("1. Pedir pista a un edificio");
			System.out.println("2. Viajar a un pais");
			System.out.println("3. Emitir orden de arresto");
			numero = (char)System.in.read();
			switch (numero){
			case '1':
				Pais paisActual = personaje.getUbicacion();
				System.out.println("Que edificio desea visitar?");
				System.out.println("1. Biblioteca");
				System.out.println("2. Puerto");
				System.out.println("3. Banco");
				
				System.in.read();	//Lee el enter
				System.in.read();	//Lee el retorno al carro
				otroNumero = (char)System.in.read();

				switch(otroNumero){
				case '1':
					System.out.println(personaje.pedirPistaA(paisActual.biblioteca).getPista());
					break;
				case '2':
					System.out.println(personaje.pedirPistaA(paisActual.puerto).getPista());
					break;
				case '3':
					System.out.println(personaje.pedirPistaA(paisActual.banco).getPista());
					break;
				}
				break;
			case '2':
				personaje.elegirPaisAViajar(mundo, docPaises);
				break;
			case '3':
				if(!jefatura.ordenEstaEmitida()){
					personaje.emitirOrdenA(personaje.describirSospechoso());
					if(jefatura.ordenEstaEmitida())
						System.out.println("Orden emitida a " + ladron.getNombre());
					else
						System.out.println("Lo siento, no se a encontrado un sospechoso");
				}
				else{
					System.out.println("Orden ya emitida a " + ladron.getNombre());
				}
				break;
			}
			
			System.in.read();	//Lee el enter
			System.in.read();	//Lee el retorno al carro
		}

		if(personaje.ladronCapturado()){
			if(jefatura.ordenEstaEmitida()){
				jefatura.sumarCasoAXML(personajesXML, nombrePersonaje);
				System.out.println("Felicidades! Ahora vivira sus dias en Azkaban");
			}
			else{
				System.out.println("Pero como colgaste mal en emitir la orden, se fue no mas. Gil.");
			}
		}
		else{
			System.out.println("Dale macho, media pila! Ni sigas, se te re fue el ladron");
		}
	}

}