package fiuba.algo3;

import java.io.*; 
import java.util.ArrayList;
import java.util.Calendar;
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
	
	
	/*private static Sospechoso describirSospechoso() throws IOException{
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
	}*/
	
	private static String convertirHoras(Calendar tiempo){
		String hora = new String();
		hora = Integer.toString(tiempo.get(Calendar.HOUR_OF_DAY)) +" hs del dia " + Integer.toString(tiempo.get(Calendar.DATE)) +"/" + Integer.toString(tiempo.get(Calendar.MONTH));
		return hora;
	}
	
	private static void emitirOrden(Sospechoso sospechoso,Personaje personaje, Ladron ladron)throws IOException{
		char numero;
			System.out.println("EMITIR ORDEN");
			System.out.println("Elija el rasgo que quiere setear o ver del sospechoso");
			System.out.println("1 Sexo . 2 Hobby . 3 Cabello . 4 Senia . 5 Vehiculo . 6 Enviar orden a la jefatura . 7 Salir");
			System.in.read(); System.in.read();
			numero = (char)System.in.read();
			switch(numero){
			case '1':
				Main.elejirSexo(sospechoso);
				break;
			case '2':
				Main.elejirHobby(sospechoso);
				break;
			case '3':
				Main.elejirCabello(sospechoso);
				break;
			case '4':
				Main.elejirLaSenia(sospechoso);
				break;
			case '5':
				Main.elejirElVehiculo(sospechoso);
				break;
			case '6':
				personaje.emitirOrdenA(sospechoso);
				if (personaje.getJefatura().ordenEstaEmitida()){
					System.out.println("La orden de arresto que se envio es correcta y corresponde a "+ladron.getNombre());
				}
				else {
					System.out.println("La orden de arresto enviada es incorrecta");
				}	
				break;
			case '7':
				break;
			}
	}
	
	private static void elejirSexo (Sospechoso sospechoso)throws IOException{
		if (!sospechoso.getSexo().hayRasgo())
				System.out.println("Aun no ha elejido el sexo del sospechoso");
		else{
				System.out.println("usted marco q su sospechos es "+sospechoso.getSexo().getRasgo());
		}
		System.out.println("Elija el sexo de su sospechoso");
		System.out.println("1 Masculino . 2 Femenino . 3 Borrar rasgos elejidos . 4 Salir");
		System.in.read(); System.in.read();
		char numero = (char)System.in.read();
		boolean actualizado = true;
		switch(numero){
		case '1':
			sospechoso.setSexo(new Rasgo("masculino"));
			break;
		case '2':
			sospechoso.setSexo(new Rasgo("femenino"));
			break;
		case '3':
			sospechoso.setSexo(new Rasgo(null));
			break;
		case '4':
			actualizado = false;
			break;
		}
		if (actualizado){
			System.out.println("Se ha actualizado el sexo del sospechoso");
		}
	}
	
	public static void elejirHobby(Sospechoso sospechoso)throws IOException{
		if (!sospechoso.getHobby().hayRasgo())
			System.out.println("Aun no ha elejido el hobby del sospechoso");
		else{
				System.out.println("Usted marco q su sospechoso le gusta el/la "+sospechoso.getHobby().getRasgo());
			}
		System.out.println("Elija el hobby de su sospechoso");
		System.out.println("1 Alpinismo . 2 Croquet . 3 Tenis . 4 Musica . 5 Paracaidismo . 6 Natacion . 7 Borrar el hobby . 8 Salir");
		System.in.read(); System.in.read();
		char numero = (char)System.in.read();
		boolean actualizado = true;
		switch(numero){
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
		case '7':
			sospechoso.setHobby(new Rasgo(null));
			break;
		case '8':
			actualizado = false;
			break;
		}
		if (actualizado){
			System.out.println("Se ha actualizado el hobby del sospechoso");
		}
	}
	private static void elejirCabello(Sospechoso sospechoso)throws IOException{
		if (!sospechoso.getCabello().hayRasgo())
			System.out.println("Aun no ha elejido el cabello del sospechoso");
		else{
				System.out.println("Usted marco q su sospechoso tiene el cabello "+sospechoso.getCabello().getRasgo());
			}
		System.out.println("Elija el cabello de su sospechoso");
		System.out.println("1 Negro . 2 Colorado . 3 Rubio . 4 Castanio . 5 Borrar el cabello . 6 Salir");
		System.in.read(); System.in.read();
		char numero = (char)System.in.read();
		boolean actualizado = true;
		switch(numero){
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
			break;
		case '5':
			sospechoso.setCabello(new Rasgo(null));
			break;
		case '6':
			actualizado = false;
			break;
		}
		if (actualizado){
			System.out.println("Se ha actualizado el cabello del sospechoso");
		}
	}	
	
	private static void elejirLaSenia(Sospechoso sospechoso)throws IOException{
		if (!sospechoso.getSenia().hayRasgo())
			System.out.println("Aun no ha elejido la senia del sospechoso");
		else{
				System.out.println("Usted marco q su sospechoso tiene "+sospechoso.getSenia().getRasgo());
			}
		System.out.println("Elija la senia de su sospechoso");
		System.out.println("1 Anillos . 2 Tatuajes . 3 Joyas . 4 Cicatrices . 5 Borrar la senia . 6 Salir");
		System.in.read(); System.in.read();
		char numero = (char)System.in.read();
		boolean actualizado = true;
		switch(numero){
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
			sospechoso.setSenia(new Rasgo("cicatrices"));
			break;
		case '5':
			sospechoso.setSenia(new Rasgo(null));
			break;
		case '6':
			actualizado = false;
			break;
		}
		if (actualizado){
			System.out.println("Se ha actualizado la senia del sospechoso");
		}
	}
	
	private static void elejirElVehiculo(Sospechoso sospechoso)throws IOException{
		if (!sospechoso.getVehiculo().hayRasgo())
			System.out.println("Aun no ha elejido el vehiculo del sospechoso");
		else{
				System.out.println("Usted marco q su sospechoso anda en "+sospechoso.getVehiculo().getRasgo());
			}
		System.out.println("Elija el vehiculo de su sospechoso");
		System.out.println("1 Moto . 2 Descapotable . 3 Limusina . 4 Deportivo . 5 Borrar el vehiculo . 6 Salir");
		System.in.read(); System.in.read();
		char numero = (char)System.in.read();
		boolean actualizado = true;
		switch(numero){
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
			break;
		case '5':
			sospechoso.setVehiculo(new Rasgo(null));
			break;
		case '6':
			actualizado = false;
			break;
		}
		if (actualizado){
			System.out.println("Se ha actualizado el vehiculo del sospechoso");
		}
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
		
		boolean seguirJugando;
		
		do{
			Mundo mundo = new Mundo(docPaises);
			Tesoros tesoro = new Tesoros(docTesoros);
			Ladron ladron = Ladron.Hidratar(docLadron);
			Jefatura jefatura = Jefatura.Hidratar(docJefatura, ladron);
			ladron.robarUnTesoroRandom(tesoro, docPaises);
			Sospechoso sospechoso = new Sospechoso();
			
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
			System.out.println("Fecha limite: "+ Main.convertirHoras(personaje.getTiempoLimite()));
			
			char numero;
			char otroNumero;
			
			while (!personaje.ladronCapturado() & personaje.getHorasRestantes()>0){
				System.out.println();
				System.out.print("Hora : ");
				System.out.println(Main.convertirHoras(personaje.getHoraActual()));
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
					if(!jefatura.ordenEstaEmitida())
						Main.emitirOrden(sospechoso, personaje,ladron);
					else
						System.out.println("Orden ya emitida a " + ladron.getNombre());
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
			
			System.out.println("Desea seguir jugando? (y/n)");
			Character opcion = (char)System.in.read();
			opcion = Character.toUpperCase(opcion);
			seguirJugando = opcion=='Y';
			System.in.read();
			System.in.read();
		} while (seguirJugando);
	}

}