package fiuba.algo3.unit;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Ladron;
import fiuba.algo3.Pais;
import fiuba.algo3.Rasgo;
import fiuba.algo3.Sospechoso;

public class LadronTest {
	
	private Sospechoso generarSospechoso(){
		Sospechoso sospechoso = new Sospechoso();
		sospechoso.setSexo(new Rasgo("Femenino"));
		sospechoso.setHobby(new Rasgo("Alpinismo"));
		sospechoso.setCabello(new Rasgo("Rojo"));
		sospechoso.setSenia(new Rasgo("Anillo"));
		sospechoso.setVehiculo(new Rasgo("Descapotable"));
		
		return sospechoso;
	}
	
	public ArrayList<Pais> generarListaPaises(){
		ArrayList<Pais> listaPaises = new ArrayList<Pais>();
		listaPaises.add(new Pais(1,1, "Argentina"));
		listaPaises.add(new Pais(5,4, "Italia"));
		
		return listaPaises;
	}
	
	public Ladron generarLadron(){
		Ladron ladron = new Ladron(generarListaPaises(), "Carmen SanDiego");
		
		ladron.setSexo(new Rasgo("Femenino"));
		ladron.setCabello(new Rasgo("Rojo"));
		ladron.setHobby(new Rasgo("Alpinismo"));
		ladron.setSenia(new Rasgo("Anillo"));
		ladron.setVehiculo(new Rasgo("Descapotable"));
		
		return ladron;
	}
	
	@Test
	public void debeContenerUnaListaDePaises(){
		Ladron ladron = new Ladron(generarListaPaises(), "Juan Perez");
		
		Assert.assertEquals("Argentina", ladron.getPais(0).getNombre());
		Assert.assertEquals("Italia", ladron.getPais(1).getNombre());
	}
	
	@Test
	public void debeConservarInterfazHeredadaDeSospechoso(){
		Ladron ladron = generarLadron();
				
		Assert.assertEquals("Femenino", ladron.getSexo().getRasgo());
		Assert.assertEquals("Rojo", ladron.getCabello().getRasgo());
		Assert.assertEquals("Alpinismo", ladron.getHobby().getRasgo());
		Assert.assertEquals("Anillo", ladron.getSenia().getRasgo());
		Assert.assertEquals("Descapotable", ladron.getVehiculo().getRasgo());
	}
	
	@Test
	public void ladronDebeTenerNombre(){
		Ladron ladron = generarLadron();
		
		Assert.assertEquals("Carmen SanDiego", ladron.getNombre());
	}
	
	@Test
	public void debePoderCoincidirRasgosConOtroSospechoso(){
		Ladron ladron = generarLadron();
		Sospechoso sospechoso = generarSospechoso();
		
		Assert.assertTrue(ladron.coincideRasgosCon(sospechoso));
	}
}
