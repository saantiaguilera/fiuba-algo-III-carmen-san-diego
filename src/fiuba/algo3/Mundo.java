package fiuba.algo3;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Mundo {
	protected ArrayList<String> paises;
	
	
	public Mundo(Document doc){
		paises = new ArrayList<String>();
		hidratar(doc);
	}
	
	public void hidratar(Document doc){
		NodeList nodosPaises = doc.getElementsByTagName("Pais");
		int indice;
		for (indice=0; indice<nodosPaises.getLength(); indice++){
			String nombre = ((Element) nodosPaises.item(indice)).getAttribute("nombre");
			paises.add(nombre);
		}
	}
	
	public String getUnPaisDistintoDe(String unPais){
		Random rnd = new Random();
		int unNumero = rnd.nextInt(paises.size());
		if (paises.get(unNumero)==unPais){
			unNumero=rnd.nextInt(paises.size());
		}
		return paises.get(unNumero);
	}
}

