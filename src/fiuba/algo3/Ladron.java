package fiuba.algo3;

//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ladron extends Sospechoso{
	
	protected ArrayList<Pais> listaPaises;
	protected String nombre;
	
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
	
	public Ladron(String unNombre){
		super();
		this.listaPaises = new ArrayList<Pais>();
		this.nombre = unNombre;
	}
	
	public Pais getPaisActual(Pais paisDelPersonaje){
		int posision=listaPaises.indexOf(paisDelPersonaje);
		return listaPaises.get(posision+1);
	}
	
	public void robarUnTesoroRandom(Tesoros tesoro ,Document doc) {
		Random rnd = new Random();
		int tipoDeObjeto = rnd.nextInt(3);
		switch (tipoDeObjeto){
		case 0:
			int unaPosision = rnd.nextInt(tesoro.getCantidadDeTesorosRaros());
			ObjetoRaro unObjetoRaro = tesoro.obtenerObjetoRaro(unaPosision);
			try {
				this.generarListaPaisesPara(unObjetoRaro,doc);
			} catch (ParserConfigurationException  e) {}
			catch (SAXException e){} 
			catch (IOException e){}
			break;
		case 1:
			int otraPosision = rnd.nextInt(tesoro.getCantidadDeTesorosExoticos());
			ObjetoExotico unObjetoExotico = tesoro.obtenerObjetoExotico(otraPosision);
			try {
				this.generarListaPaisesPara(unObjetoExotico,doc);
			} catch (ParserConfigurationException  e) {}
			catch (SAXException e){} 
			catch (IOException e){}
			break;			
		case 2:
			int otraPosisionMas = rnd.nextInt(tesoro.getCantidadDeTesorosLegendarios());
			ObjetoLegendario unObjetoLegendario = tesoro.obtenerObjetoLegendario(otraPosisionMas);
			try {
				this.generarListaPaisesPara(unObjetoLegendario,doc);
			} catch (ParserConfigurationException  e) {}
			catch (SAXException e){} 
			catch (IOException e){}
			break;
		}	
	}
	
	private void generarListaPaisesPara(ObjetoLegendario unObjetoLegendario, Document doc)
			throws ParserConfigurationException, SAXException, IOException{
		this.generarListaPaisesDeTamanio(7,doc);
	}
	
	private void generarListaPaisesPara(ObjetoExotico unObjetoExotico,Document doc)
			throws ParserConfigurationException, SAXException, IOException{
		this.generarListaPaisesDeTamanio(5,doc);
	}	

	private void generarListaPaisesPara(ObjetoRaro unObjetoRaro,Document doc)
			throws ParserConfigurationException, SAXException, IOException{
		this.generarListaPaisesDeTamanio(4,doc);
	}	
	
	private void generarListaPaisesDeTamanio(int cantPaises,Document docPaises) throws ParserConfigurationException , SAXException, IOException{
		//POST: this.listaPaises termina con una lista aleatoria de paises
		//	que recorre el ladron
			
			NodeList nodosPaises = docPaises.getElementsByTagName("Pais");
			Random rnd = new Random();
			
			//Se quiere buscar x=cantPaises paises aleatorios no repetidos
			int nroPaisActual = rnd.nextInt(nodosPaises.getLength());
			ArrayList<Integer> nrosPaisesElegidos = new ArrayList<Integer>();
			nrosPaisesElegidos.add(nroPaisActual);
			
			while(listaPaises.size() < cantPaises){
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
				
					
				if(listaPaises.size() < cantPaises - 1){	//Si no se esta en ultimo pais
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, nombreProxPais, this);
					listaPaises.add(paisNuevo);
				}
				else{
					Pais paisNuevo = Pais.hidratar(docPaises, nombrePaisNuevo, null, this);
					listaPaises.add(paisNuevo);
					this.esconderse(paisNuevo.biblioteca, paisNuevo.banco, paisNuevo.puerto);
				}
				
				//El siguiente pais sera el que ahora es proximo
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
		if (posision == listaPaises.size() - 1){
			return true;
		}
		else { return false;}
	}
	
	public void esconderse(Edificio primerEdificio,Edificio segundoEdificio, Edificio tercerEdificio){
		Complice unComplice= new Complice(this,new Bala());
		Pista pistaBala = new Pista("Te han disparado!");
		unComplice.agregarPistaDificil(pistaBala);
		unComplice.agregarPistaMedia(pistaBala);
		unComplice.agregarPistaFacil(pistaBala);
		
		Complice otroComplice = new Complice(this, new Cuchillo());
		Pista pistaCuchillo = new Pista("Te han lastimado con un cuchillo!");
		otroComplice.agregarPistaDificil(pistaCuchillo);
		otroComplice.agregarPistaMedia(pistaCuchillo);
		otroComplice.agregarPistaFacil(pistaCuchillo);
		
		Complice ladron= new Complice (this, new ActaDeRendicion());
		Pista pistaLadron = new Pista("Has encontrado al ladron!");
		ladron.agregarPistaDificil(pistaLadron);
		ladron.agregarPistaMedia(pistaLadron);
		ladron.agregarPistaFacil(pistaLadron);
		
		ArrayList<Complice> complicesAElegir = new ArrayList<Complice>();
		complicesAElegir.add(ladron);
		complicesAElegir.add(unComplice);
		complicesAElegir.add(otroComplice);
		Collections.shuffle(complicesAElegir);
		
		primerEdificio.setComplice(complicesAElegir.get(0));
		segundoEdificio.setComplice(complicesAElegir.get(1));
		tercerEdificio.setComplice(complicesAElegir.get(2));
	}
	
	public static Ladron Hidratar(Document doc){
		Ladron ladron = new Ladron();
		NodeList nodos = doc.getElementsByTagName("Sospechoso");
		Random rnd = new Random();
		int nroDeSospechoso = rnd.nextInt(nodos.getLength());

		Element elementoNodo = (Element)nodos.item(nroDeSospechoso);
		ladron.setNombre(elementoNodo.getAttribute("nombre"));
		ladron.setSexo(new Rasgo(elementoNodo.getAttribute("sexo")));
		ladron.setHobby(new Rasgo(elementoNodo.getAttribute("hobby")));
		ladron.setCabello(new Rasgo((String)elementoNodo.getAttribute("cabello")));
		ladron.setSenia(new Rasgo(elementoNodo.getAttribute("senia")));
		ladron.setVehiculo(new Rasgo(elementoNodo.getAttribute("vehiculo")));
		
		return ladron;
	}

	public void dejarRasgoAleatorioEn(Edificio edificio) {
		Random rand = new Random();
		switch(rand.nextInt(4)){
		case 0:
			edificio.concatenarRasgo(" Le gustaba hacer ", hobby);
			break;
		case 1:
			edificio.concatenarRasgo(" Tenia el cabello ", cabello);
			break;
		case 2:
			edificio.concatenarRasgo(" Le vi sus grandes ", senia);
			break;
		case 3:
			edificio.concatenarRasgo(" Le gustaba lucir su ", vehiculo);
		}
	}
	
	public boolean estuvoEn(Pais ubicacion) {
		return listaPaises.contains(ubicacion);
	}
	
}
