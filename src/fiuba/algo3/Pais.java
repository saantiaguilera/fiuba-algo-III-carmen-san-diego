package fiuba.algo3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Pais {
	private int posicionX;	
	private int posicionY;
	private String nombre;
	public Edificio biblioteca;
	public Edificio puerto;
	public Edificio banco;
	
	public Pais(int x, int y, String nombrePais){
		posicionX = x;
		posicionY = y;
		nombre = nombrePais;
		biblioteca = null;
		puerto = null;
		banco = null;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public String getNombre() {
		return nombre;
	}

	public double calcularDistanciaCon(Pais paisDestino) {
		return Math.sqrt( Math.pow(this.posicionX - paisDestino.getPosicionX(), 2)
				+ Math.pow(this.posicionY - paisDestino.getPosicionY(), 2));
	}

	private void asignarPistasDePaisIncorrecto(){
		Pista noFueVisto = new Pista("Lo siento, no hemos visto a esa persona");
		this.biblioteca = new Edificio();
		this.puerto = new Edificio();
		this.banco = new Edificio();
		
		this.biblioteca.agregarPistaDificil(noFueVisto);
		this.biblioteca.agregarPistaMedia(noFueVisto);
		this.biblioteca.agregarPistaFacil(noFueVisto);
		this.puerto.agregarPistaDificil(noFueVisto);
		this.puerto.agregarPistaMedia(noFueVisto);
		this.puerto.agregarPistaFacil(noFueVisto);
		this.banco.agregarPistaDificil(noFueVisto);
		this.banco.agregarPistaMedia(noFueVisto);
		this.banco.agregarPistaFacil(noFueVisto);
	}
	
	public static Pais hidratar(Document doc, String paisActual, String proxPais, Ladron ladron) {
	//POST: Devuelve un pais con coordenadas y nombre de paisActual
	//	y con edificios que tienen pistas del proximo pais. Si este ultimo es null,
	//	carga pistas de que no se vio al ladron por ahi
		Pais paisNuevo;
		NodeList nodosPaises = doc.getElementsByTagName("Pais");
		
		//Busco	indice de pais actual por nombre
		int indice;
		for(indice=0; !((Element)nodosPaises.item(indice)).getAttribute("nombre").matches(paisActual); indice++);
		
		//Creo una nueva instancia del pais actual
		Element elementoPais = (Element)nodosPaises.item(indice);
		int coordX = Integer.parseInt(elementoPais.getAttribute("coordX"));
		int coordY = Integer.parseInt(elementoPais.getAttribute("coordY"));
		paisNuevo = new Pais(coordX, coordY, paisActual);
	
		if(proxPais != null){
			//Busco indice de pais destino
			for(indice=0; !((Element)nodosPaises.item(indice)).getAttribute("nombre").matches(proxPais); indice++);
			
			//Asigno pistas de proximo pais
			elementoPais = (Element)nodosPaises.item(indice);
			NodeList nodosEdificios = elementoPais.getElementsByTagName("Edificio");
			paisNuevo.biblioteca = Edificio.hidratar(nodosEdificios.item(0), ladron);
			paisNuevo.puerto = Edificio.hidratar(nodosEdificios.item(1), ladron);
			paisNuevo.banco = Edificio.hidratar(nodosEdificios.item(2), ladron);
		}
		else{
			//Asigno pistas de que no fue visto
			paisNuevo.asignarPistasDePaisIncorrecto();
		}
		
		return paisNuevo;
	}
	
}
