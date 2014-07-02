package fiuba.algo3;

import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {
	
	private static void elegirUnPaisAViajar(Personaje unPersonaje, Mundo mundo, Document doc) throws IOException{
		if(!(unPersonaje.getJefatura()).esUltimoPais(unPersonaje.getUbicacion())){
			System.out.println("Seleccione un pais a viajar:");
			Pais paisCorrecto;
			if (unPersonaje.seConfundioDePais()){
				Pais miPaisActual = unPersonaje.sacarPaisDeLaPila();
				paisCorrecto = unPersonaje.verPaisDeLaPila();
				unPersonaje.agregarPaisALaPila(miPaisActual);
			}
			else{
				paisCorrecto = (unPersonaje.getJefatura()).paisActualDelLadron(unPersonaje.getUbicacion());
			}
			
			
			String unStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
			Pais unPaisIncorrecto = Pais.hidratar(doc, unStringDePaisIncorrecto, null, null);

			
			String otroStringDePaisIncorrecto = unStringDePaisIncorrecto;
			while(otroStringDePaisIncorrecto.matches(unStringDePaisIncorrecto)){
				otroStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
			}
			Pais otroPaisIncorrecto = Pais.hidratar(doc, otroStringDePaisIncorrecto, null, null);
			
			
			ArrayList<Pais> paisesAElegir = new ArrayList<Pais>();
			paisesAElegir.add(paisCorrecto);
			paisesAElegir.add(unPaisIncorrecto);
			paisesAElegir.add(otroPaisIncorrecto);
			Collections.shuffle(paisesAElegir);
			System.out.println("1. " + (paisesAElegir.get(0)).getNombre());
			System.out.println("2. " + (paisesAElegir.get(1)).getNombre());
			System.out.println("3. " + (paisesAElegir.get(2)).getNombre());

			
			
			System.in.read();	//Lee el enter
			System.in.read();	//Lee el retorno al carro
			char numero = (char)System.in.read();
			switch (numero){
			case '1':
					unPersonaje.viajarA(paisesAElegir.get(0));
					break;
			case '2':
					unPersonaje.viajarA(paisesAElegir.get(1));
					break;
			case '3':
					unPersonaje.viajarA(paisesAElegir.get(2));
					break;
			}
		}
		else{
			System.out.println("Se rumorea que el ladron esta en la ciudad. Buscalo!");
		}
	}
	
	
	private static Sospechoso describirSospechoso() throws IOException{
		Sospechoso sospechoso = new Sospechoso();
		char opcion;
		System.out.println("SEXO\n1. Masculino\n2. Femenino\n3. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setSexo(new Rasgo("masculino"));
			break;
		case '2':
			sospechoso.setSexo(new Rasgo("femenino"));
			break;
		}
		System.out.println("HOBBY\n1. Alpinismo\n2. Croquet\n3. Tenis");
		System.out.println("4. Musica\n5. Paracaidismo\n6. Natacion\n7. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char) System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setHobby(new Rasgo("alpinismo"));
			break;
		case '2':
			sospechoso.setHobby(new Rasgo("croquet"));
			break;
		case '3':
			sospechoso.setHobby(new Rasgo("tenis"));
			break;
		case '4':
			sospechoso.setHobby(new Rasgo("musica"));
			break;
		case '5':
			sospechoso.setHobby(new Rasgo("paracaidismo"));
			break;
		case '6':
			sospechoso.setHobby(new Rasgo("natacion"));
			break;
		}
		System.out.println("CABELLO\n1. Negro\n2. Colorado\n3. Rubio");
		System.out.println("4. Castanio\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setCabello(new Rasgo("negro"));
			break;
		case '2':
			sospechoso.setCabello(new Rasgo("colorado"));
			break;
		case '3':
			sospechoso.setCabello(new Rasgo("rubio"));
			break;
		case '4':
			sospechoso.setCabello(new Rasgo("castanio"));
		}
		System.out.println("SENIA\n1. Anillos\n2. Tatuajes\n3. Joyas");
		System.out.println("4. Cicatrices\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setSenia(new Rasgo("anillos"));
			break;
		case '2':
			sospechoso.setSenia(new Rasgo("tatuajes"));
			break;
		case '3':
			sospechoso.setSenia(new Rasgo("joyas"));
			break;
		case '4':
			sospechoso.setSenia(new Rasgo("cicactrices"));
		}
		System.out.println("VEHICULO\n1. Moto\n2. Descapotable\n3. Limusina");
		System.out.println("4. Deportivo\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setVehiculo(new Rasgo("moto"));
			break;
		case '2':
			sospechoso.setVehiculo(new Rasgo("descapotable"));
			break;
		case '3':
			sospechoso.setVehiculo(new Rasgo("limusina"));
			break;
		case '4':
			sospechoso.setVehiculo(new Rasgo("deportivo"));
		}
		
		return sospechoso;
	}
	
	
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
		Ladron ladron = Ladron.Hidratar(docLadron);
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
		System.out.println("Fecha limite: "+personaje.getTiempoLimite());
		
		char numero;
		char otroNumero;
		
		while (!personaje.ladronCapturado() & personaje.getHorasRestantes()>0){
			System.out.println();
			System.out.print("Hora : ");
			System.out.println(personaje.getHoraActual());
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
				elegirUnPaisAViajar(personaje,mundo,docPaises);
				break;
			case '3':
				if(!jefatura.ordenEstaEmitida()){
					personaje.emitirOrdenA(Main.describirSospechoso());
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