package fiuba.algo3;

import java.util.ArrayList;

public class Ladron extends Sospechoso{
	
	protected ArrayList<Pais> listaPaises;
	protected String nombre;
	
	public Ladron(){
		this.listaPaises = null;
		this.nombre = null;
	}
	
	public Ladron(ArrayList<Pais> listaPaises, String nombre){
		this.listaPaises = listaPaises;
		this.nombre = nombre;
	}

	public Pais getPais(int numeroPais) {
		return listaPaises.get(numeroPais);
	}

	public String getNombre(){
		return nombre;
	}
}
