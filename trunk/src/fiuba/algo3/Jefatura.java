package fiuba.algo3;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Jefatura {
	
	private Ladron ladron;
	private Boolean ordenEmitida;
	private ArrayList <String> listaDeSexo;
	private ArrayList <String> listaDeHobys;
	private ArrayList <String> listaDeCabellos;
	private ArrayList <String> listaDeSenias;
	private ArrayList <String> listaDeVehiculos;
	
	public Jefatura(Ladron ladron){
		this.ladron = ladron;
		this.ordenEmitida = false;
		listaDeSexo = new ArrayList <String>();
		listaDeHobys = new ArrayList <String>();
		listaDeCabellos = new ArrayList <String>();
		listaDeSenias = new ArrayList <String>();
		listaDeVehiculos = new ArrayList <String>();
	}

	public ArrayList<String> getListaDeSexo() {
		return listaDeSexo;
	}

	public ArrayList<String> getListaDeHobys() {
		return listaDeHobys;
	}

	public ArrayList<String> getListaDeCabellos() {
		return listaDeCabellos;
	}

	public ArrayList<String> getListaDeSenias() {
		return listaDeSenias;
	}

	public ArrayList<String> getListaDeVehiculos() {
		return listaDeVehiculos;
	}

	public void emitirOrden(Sospechoso sospechoso) {
		if(ladron.coincideRasgosCon(sospechoso))
			ordenEmitida = true;
	}

	public boolean ordenEstaEmitida() {
		return ordenEmitida;
	}
	
	private void cargarListaDeSexo(Document doc){
		NodeList nodos = doc.getElementsByTagName("Sexo");
		Element elementoNodo =(Element)nodos.item(0);
		listaDeSexo.add(elementoNodo.getAttribute("opcion1"));
		listaDeSexo.add(elementoNodo.getAttribute("opcion2"));	
	}
	
	private void cargarListaDeHobbys(Document doc){
		NodeList nodos = doc.getElementsByTagName("Hobby");
		Element elementoNodo =(Element)nodos.item(0);
		listaDeHobys.add(elementoNodo.getAttribute("opcion1"));
		listaDeHobys.add(elementoNodo.getAttribute("opcion2"));
		listaDeHobys.add(elementoNodo.getAttribute("opcion3"));
	}
	
	private void cargarListaDeCabellos(Document doc){
		NodeList nodos = doc.getElementsByTagName("Cabello");
		Element elementoNodo =(Element)nodos.item(0);
		listaDeCabellos.add(elementoNodo.getAttribute("opcion1"));
		listaDeCabellos.add(elementoNodo.getAttribute("opcion2"));
		listaDeCabellos.add(elementoNodo.getAttribute("opcion3"));
		listaDeCabellos.add(elementoNodo.getAttribute("opcion4"));
	}
	
	private void cargarListaDeSenias(Document doc){
		NodeList nodos = doc.getElementsByTagName("Senia");
		Element elementoNodo =(Element)nodos.item(0);
		listaDeSenias.add(elementoNodo.getAttribute("opcion1"));
		listaDeSenias.add(elementoNodo.getAttribute("opcion2"));
		listaDeSenias.add(elementoNodo.getAttribute("opcion3"));
	}
	
	private void cargarListaDeVehiculos(Document doc){
		NodeList nodos = doc.getElementsByTagName("Vehiculo");
		Element elementoNodo =(Element)nodos.item(0);
		listaDeVehiculos.add(elementoNodo.getAttribute("opcion1"));
		listaDeVehiculos.add(elementoNodo.getAttribute("opcion2"));
		listaDeVehiculos.add(elementoNodo.getAttribute("opcion3"));
	}
	
	public static Jefatura Hidratar(Document doc,Ladron ladron){
		Jefatura jefatura = new Jefatura(ladron);
		jefatura.cargarListaDeSexo(doc);
		jefatura.cargarListaDeHobbys(doc);
		jefatura.cargarListaDeCabellos(doc);
		jefatura.cargarListaDeSenias(doc);
		jefatura.cargarListaDeVehiculos(doc);
		
		return jefatura;
	}

	public Personaje asignarPersonajeConNombre(Document docPersonajes, String nombrePersonaje) {
	//POST: retorna el personaje correspondiente a los casos resueltos.
	
		NodeList nodosPersonajes = docPersonajes.getElementsByTagName("Personaje");
		for(int i=0; i<nodosPersonajes.getLength(); i++){
			Element elementoPersonaje = (Element)nodosPersonajes.item(i);
			int casosResueltos = 
					Integer.parseInt(elementoPersonaje.getAttribute("casosResueltos"));
			if(elementoPersonaje.getAttribute("nombre").equals(nombrePersonaje)){
				return personajeSegunCasos(casosResueltos);
			}
				
		}
		
		//Se recorrieron todos los personajes y el buscado no tenia historial
		return new PersonajeNovato(150, this.ladron.getPais(0), 900,this);
	}
	
	private Personaje personajeSegunCasos(int casosResueltos){
		if(casosResueltos < 5){
			return new PersonajeNovato(150, this.ladron.getPais(0), 900,this);
		}
		else
			if(casosResueltos < 10){
				return new PersonajeDetective(150, this.ladron.getPais(0), 1100,this);
			}
			else{
				if(casosResueltos < 20){
					return new PersonajeInvestigador(150, this.ladron.getPais(0), 1300,this);
				}
				else
					return new PersonajeSargento(150, this.ladron.getPais(0), 1500,this);
			}
	}

	public Pais paisActualDelLadron(Pais paisAnterior) {
		return ladron.getPaisActual(paisAnterior);
	}

	public boolean verificarSiElLadronPasoPor(Pais ubicacion) {
		return ladron.estuvoEn(ubicacion);
	}

	public void sumarCasoAXML(File personajesXML, String nombrePersonaje) {
		//Carga los datos del xml...
		ArrayList<NodoXMLPersonaje> listaPersonajes =
				NodoXMLPersonaje.generarLista(personajesXML);;
		
		//...y finalmente reescribo
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {}
		Document docPersonajes = dBuilder.newDocument();
		
		Element elementoPersonajes = docPersonajes.createElement("Personajes");
		Boolean personajeEncontrado = false;
		
		for(NodoXMLPersonaje personaje : listaPersonajes){
			Element elementoPersonaje = docPersonajes.createElement("Personaje");
			
			if( personaje.nombre.matches(nombrePersonaje) ){
				personajeEncontrado = true;
				int casosResueltos = 
						Integer.parseInt(personaje.casosResueltos);
				casosResueltos++;
				elementoPersonaje.setAttribute("casosResueltos", String.valueOf(casosResueltos));
				elementoPersonaje.setAttribute("nombre", nombrePersonaje);
			}
			else{
				elementoPersonaje.setAttribute("nombre", personaje.nombre);
				elementoPersonaje.setAttribute("casosResueltos", personaje.casosResueltos);
			}
			
			elementoPersonajes.appendChild(elementoPersonaje);
		}
		if(!personajeEncontrado){
			Element personajeNuevo = docPersonajes.createElement("Personaje");
			personajeNuevo.setAttribute("nombre", nombrePersonaje);
			personajeNuevo.setAttribute("casosResueltos", "1");
			elementoPersonajes.appendChild(personajeNuevo);
		}
		
		docPersonajes.appendChild(elementoPersonajes);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = tf.newTransformer();
		} catch (TransformerConfigurationException e) {}
		DOMSource source = new DOMSource(docPersonajes);
		StreamResult result = new StreamResult(personajesXML);
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {}
		
	}

	public boolean esUltimoPais(Pais unPais) {
		return ladron.esUltimoPais(unPais);
	}

}

