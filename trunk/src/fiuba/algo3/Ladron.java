package fiuba.algo3;

import java.util.ArrayList;

public class Ladron extends Sospechoso{
	
	protected ArrayList<Pais> listaPaises;
	protected String nombre;
	
	public Ladron(){
		this.listaPaises = new ArrayList<Pais>();
		this.nombre = null;
	}
	
	public Ladron(ArrayList<Pais> listaPaises, String nombre){
		this.listaPaises = listaPaises;
		this.nombre = nombre;
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

	public boolean esUltimoPais(Pais unPais) {
		int posision=listaPaises.indexOf(unPais);
		if (posision==listaPaises.size()){
			return true;
		}
		else { return false;}
	}

	public void esconderse(Edificio primerEdificio, Edificio segundoEdificio, Edificio tercerEdificio) {
		primerEdificio.setSeEscondioElLadron(true);
		segundoEdificio.setTienenArmas(true);
		tercerEdificio.setTienenCuchillos(true);
	}
}
