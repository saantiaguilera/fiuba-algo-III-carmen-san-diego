package fiuba.algo3;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Tesoros {
	protected ArrayList<ObjetoRaro> tesorosRaros;
	protected ArrayList<ObjetoExotico> tesorosExoticos;
	protected ArrayList<ObjetoLegendario> tesorosLegendarios;

	public Tesoros(Document doc){
		tesorosRaros = new ArrayList<ObjetoRaro>();
		tesorosExoticos = new ArrayList<ObjetoExotico>();
		tesorosLegendarios= new ArrayList<ObjetoLegendario>();
		hidratar(doc);
	}
	
	private void hidratar(Document doc){
		NodeList nodos = doc.getElementsByTagName("ObjetosRaros");
		int indice=0;
		for (indice=0; indice<nodos.getLength(); indice++){
			Element elementoNodo =(Element)nodos.item(indice);
			String nombre=elementoNodo.getAttribute("nombre");
			ObjetoRaro objetoValioso= new ObjetoRaro(nombre);
			tesorosRaros.add(objetoValioso);
		}
		nodos = doc.getElementsByTagName("ObjetosExoticos");
		for (indice=0; indice<nodos.getLength(); indice++){
			Element elementoNodo =(Element)nodos.item(indice);
			String nombre=elementoNodo.getAttribute("nombre");
			ObjetoExotico objetoValioso= new ObjetoExotico(nombre);
			tesorosExoticos.add(objetoValioso);
		}
		nodos = doc.getElementsByTagName("ObjetosLegendarios");
		for (indice=0; indice<nodos.getLength(); indice++){
			Element elementoNodo =(Element)nodos.item(indice);
			String nombre=elementoNodo.getAttribute("nombre");
			ObjetoLegendario objetoValioso= new ObjetoLegendario(nombre);
			tesorosLegendarios.add(objetoValioso);
		}	
	}
		
	public ObjetoRaro obtenerObjetoRaro(int posision){
		return tesorosRaros.get(posision);
	}
	
	public ObjetoExotico obtenerObjetoExotico(int posision){
		return tesorosExoticos.get(posision);
	}
	
	public ObjetoLegendario obtenerObjetoLegendario(int posision){
		return tesorosLegendarios.get(posision);
	}
	
	public int getCantidadDeTesorosRaros(){
		return tesorosRaros.size();
	}
	
	public int getCantidadDeTesorosExoticos(){
		return tesorosExoticos.size();
	}
	
	public int getCantidadDeTesorosLegendarios(){
		return tesorosLegendarios.size();
	}
	
}
