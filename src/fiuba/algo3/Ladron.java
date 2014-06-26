package fiuba.algo3;

import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ladron extends Sospechoso{
	
	protected ArrayList<Pais> listaPaises;
	protected String nombre;
	
	public Ladron(Tesoros tesoro){
		listaPaises = new ArrayList<Pais>();
		robarUnTesoroRandom(tesoro);
		this.nombre = null;
	}
	
	private void robarUnTesoroRandom(Tesoros tesoro) {
		Random rnd = new Random();
		int tipoDeObjeto = rnd.nextInt(3);
		switch (tipoDeObjeto){
		case 0:
			int unaPosision = rnd.nextInt(tesoro.getCantidadDeTesorosRaros());
			ObjetoRaro unObjetoRobado = tesoro.obtenerObjetoRaro(unaPosision);
			//Hace dispatch con el objeto
			break;
		case 1:
			int otraPosision = rnd.nextInt(tesoro.getCantidadDeTesorosExoticos());
			ObjetoExotico otroObjetoRobado = tesoro.obtenerObjetoExotico(otraPosision);
			//Hace dispatch con el objeto
			break;			
		case 2:
			int otraPosisionMas = rnd.nextInt(tesoro.getCantidadDeTesorosLegendarios());
			ObjetoLegendario otroObjetoRobadoMas = tesoro.obtenerObjetoLegendario(otraPosisionMas);
			//Hace dispatch con el objeto
			break;
		}	
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
