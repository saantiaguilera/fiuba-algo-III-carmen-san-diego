package fiuba.algo3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodoXMLPersonaje {
	
	public String nombre;
	public String casosResueltos;
	
	public NodoXMLPersonaje(String unNombre, String tantosCasosResueltos){
		this.nombre = unNombre;
		this.casosResueltos = tantosCasosResueltos;
	}

	public static ArrayList<NodoXMLPersonaje> generarLista(File personajesXML) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {}
		Document docPersonajes = null;
		try {
			docPersonajes = dBuilder.parse(personajesXML);
		} catch (SAXException e) {
		} catch (IOException e) {}
		docPersonajes.getDocumentElement().normalize();
		NodeList nodosPersonajes = docPersonajes.getElementsByTagName("Personaje");
		
		ArrayList<NodoXMLPersonaje> listaRetorno = new ArrayList<NodoXMLPersonaje>();
		for(int i=0; i<nodosPersonajes.getLength(); i++){
			listaRetorno.add(new NodoXMLPersonaje(
					((Element)nodosPersonajes.item(i)).getAttribute("nombre"),
					((Element)nodosPersonajes.item(i)).getAttribute("casosResueltos")));
		}
		
		return listaRetorno;
	}
}
