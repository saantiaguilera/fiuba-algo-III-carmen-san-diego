package fiuba.algo3;

import java.util.*;

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
}