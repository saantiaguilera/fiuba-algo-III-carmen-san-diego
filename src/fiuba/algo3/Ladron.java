package fiuba.algo3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ladron extends Sospechoso{
	
	protected ArrayList<Pais> listaPaises;
	protected String nombre;
	
	public Ladron(Tesoros tesoro){
		listaPaises = new ArrayList<Pais>();
		robarUnTesoroRandom(tesoro);
		this.nombre = null;
	}
	
	public Ladron(){
		super();
		this.listaPaises = new ArrayList<Pais>();
		this.nombre = null;
	}
	public Ladron(ArrayList<Pais> listaPaises, String unNombre){
		super();
		this.listaPaises = listaPaises;
		this.nombre = unNombre;
	}
	
	private void robarUnTesoroRandom(Tesoros tesoro) {
		Random rnd = new Random();
		int tipoDeObjeto = rnd.nextInt(3);
		switch (tipoDeObjeto){
		case 0:
			int unaPosision = rnd.nextInt(tesoro.getCantidadDeTesorosRaros());
			ObjetoRaro unObjetoRaro = tesoro.obtenerObjetoRaro(unaPosision);
			try {
				this.generarListaPaises(unObjetoRaro);
			} catch (ParserConfigurationException | SAXException | IOException e) {}
			break;
		case 1:
			int otraPosision = rnd.nextInt(tesoro.getCantidadDeTesorosExoticos());
			ObjetoExotico unObjetoExotico = tesoro.obtenerObjetoExotico(otraPosision);
			try {
				this.generarListaPaises(unObjetoExotico);
			} catch (ParserConfigurationException | SAXException | IOException e) {}
			break;			
		case 2:
			int otraPosisionMas = rnd.nextInt(tesoro.getCantidadDeTesorosLegendarios());
			ObjetoLegendario unObjetoLegendario = tesoro.obtenerObjetoLegendario(otraPosisionMas);
			try {
				this.generarListaPaises(unObjetoLegendario);
			} catch (ParserConfigurationException | SAXException | IOException e) {}
			break;
		}	
	}
	
	private void generarListaPaises(ObjetoRaro unObjeto) throws ParserConfigurationException, SAXException, IOException{
		//POST: this.listaPaises termina con una lista aleatoria de paises
		//	que recorre el ladron
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docPaises = dBuilder.parse(new File("paises.xml"));
			docPaises.getDocumentElement().normalize();
			
			NodeList nodosPaises = docPaises.getElementsByTagName("Pais");
			int cantPaisesObjExotico = 4;
			Random rnd = new Random();
			
			//Se quiere buscar 4 paises aleatorios no repetidos
			int nroPaisActual = rnd.nextInt(nodosPaises.getLength());
			ArrayList<Integer> nrosPaisesElegidos = new ArrayList<Integer>();
			nrosPaisesElegidos.add(nroPaisActual);
			
			while(listaPaises.size() < cantPaisesObjExotico){
				//Busco un numero de prox. pais que sea != al actual y que no haya sido elegido
				int nroProxPais = nroPaisActual;
				while(nroProxPais == nroPaisActual || nrosPaisesElegidos.contains(nroProxPais)){
					nroProxPais = rnd.nextInt(nodosPaises.getLength());
				}		
				nrosPaisesElegidos.add(nroProxPais);
				
				Element elementoPaisNuevo = (Element)nodosPaises.item(nroPaisActual);
				Element elementoPaisProx = (Element)nodosPaises.item(nroProxPais);
				String nombrePaisNuevo = elementoPaisNuevo.getAttribute("nombre");
				String nombreProxPais = elementoPaisProx.getAttribute("nombre");
				
					
				if(listaPaises.size() < cantPaisesObjExotico - 1){	//Si no se esta en ultimo pais
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, nombreProxPais);
					listaPaises.add(paisNuevo);
				}
				else{
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, null);
					listaPaises.add(paisNuevo);
				}
				
				//El siguiente pais será el que ahora es próximo
				nroPaisActual = nroProxPais;		
			}
		}

	private void generarListaPaises(ObjetoExotico unObjeto) throws ParserConfigurationException, SAXException, IOException{
	//POST: this.listaPaises termina con una lista aleatoria de paises
	//	que recorre el ladron
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document docPaises = dBuilder.parse(new File("paises.xml"));
		docPaises.getDocumentElement().normalize();
		
		NodeList nodosPaises = docPaises.getElementsByTagName("Pais");
		int cantPaisesObjExotico = 5;
		Random rnd = new Random();
		
		//Se quiere buscar 5 paises aleatorios no repetidos
		int nroPaisActual = rnd.nextInt(nodosPaises.getLength());
		ArrayList<Integer> nrosPaisesElegidos = new ArrayList<Integer>();
		nrosPaisesElegidos.add(nroPaisActual);
		
		while(listaPaises.size() < cantPaisesObjExotico){
			//Busco un numero de prox. pais que sea != al actual y que no haya sido elegido
			int nroProxPais = nroPaisActual;
			while(nroProxPais == nroPaisActual || nrosPaisesElegidos.contains(nroProxPais)){
				nroProxPais = rnd.nextInt(nodosPaises.getLength());
			}
			
			nrosPaisesElegidos.add(nroProxPais);
			Element elementoPaisNuevo = (Element)nodosPaises.item(nroPaisActual);
			Element elementoPaisProx = (Element)nodosPaises.item(nroProxPais);
			String nombrePaisNuevo = elementoPaisNuevo.getAttribute("nombre");
			String nombreProxPais = elementoPaisProx.getAttribute("nombre");
			
				
			if(listaPaises.size() < cantPaisesObjExotico - 1){	//Si no se esta en ultimo pais
				Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, nombreProxPais);
				listaPaises.add(paisNuevo);
			}
			else{
				Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, null);
				listaPaises.add(paisNuevo);
			}
			
			//El siguiente pais será el que ahora es próximo
			nroPaisActual = nroProxPais;		
		}
	}

	private void generarListaPaises(ObjetoLegendario unObjeto) throws ParserConfigurationException, SAXException, IOException{
		//POST: this.listaPaises termina con una lista aleatoria de paises
		//	que recorre el ladron
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document docPaises = dBuilder.parse(new File("paises.xml"));
			docPaises.getDocumentElement().normalize();
			
			NodeList nodosPaises = docPaises.getElementsByTagName("Pais");
			int cantPaisesObjExotico = 7;
			Random rnd = new Random();
			
			//Se quiere buscar 7 paises aleatorios no repetidos
			int nroPaisActual = rnd.nextInt(nodosPaises.getLength());
			ArrayList<Integer> nrosPaisesElegidos = new ArrayList<Integer>();
			nrosPaisesElegidos.add(nroPaisActual);
			
			while(listaPaises.size() < cantPaisesObjExotico){
				//Busco un numero de prox. pais que sea != al actual y que no haya sido elegido
				int nroProxPais = nroPaisActual;
				while(nroProxPais == nroPaisActual || nrosPaisesElegidos.contains(nroProxPais)){
					nroProxPais = rnd.nextInt(nodosPaises.getLength());
				}
				
				nrosPaisesElegidos.add(nroProxPais);
				Element elementoPaisNuevo = (Element)nodosPaises.item(nroPaisActual);
				Element elementoPaisProx = (Element)nodosPaises.item(nroProxPais);
				String nombrePaisNuevo = elementoPaisNuevo.getAttribute("nombre");
				String nombreProxPais = elementoPaisProx.getAttribute("nombre");
				
					
				if(listaPaises.size() < cantPaisesObjExotico - 1){	//Si no se esta en ultimo pais
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, nombreProxPais);
					listaPaises.add(paisNuevo);
				}
				else{
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, null);
					listaPaises.add(paisNuevo);
				}
				
				//El siguiente pais será el que ahora es próximo
				nroPaisActual = nroProxPais;		
			}
		}
	
	public void agregarPais(Pais pais){
		listaPaises.add(pais);
	}

	public Pais getPais(int numeroPais) {
		return listaPaises.get(numeroPais);
	}

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public int getCantPaises(){
		return listaPaises.size();
	}
	
	public boolean esUltimoPais(Pais unPais) {
		int posision=listaPaises.indexOf(unPais);
		if (posision==0){
			posision+=1;
		}
		if (posision==listaPaises.size()){
			return true;
		}
		else { return false;}
	}
	
	public void esconderse(Edificio primerEdificio,Edificio segundoEdificio, Edificio tercerEdificio){
		Complice unComplice= new Complice(this,new Bala());
		Complice otroComplice = new Complice(this, new Cuchillo());
		Complice ladron= new Complice (this, null);
		primerEdificio.setComplice(unComplice);
		segundoEdificio.setComplice(ladron);
		tercerEdificio.setComplice(otroComplice);
	}
	
	public static Ladron Hidratar(Document doc, int numeroDeSospechoso){
		Ladron ladron = new Ladron();
		NodeList nodos = doc.getElementsByTagName("Sospechoso");

		Element elementoNodo =(Element)nodos.item(numeroDeSospechoso);
		ladron.setNombre(elementoNodo.getAttribute("nombre"));
		ladron.setSexo(new Rasgo(elementoNodo.getAttribute("sexo")));
		ladron.setHobby(new Rasgo(elementoNodo.getAttribute("hobby")));
		ladron.setCabello(new Rasgo((String)elementoNodo.getAttribute("cabello")));
		ladron.setSenia(new Rasgo(elementoNodo.getAttribute("senia")));
		ladron.setVehiculo(new Rasgo(elementoNodo.getAttribute("vehiculo")));
		
		return ladron;
	}
	
}
