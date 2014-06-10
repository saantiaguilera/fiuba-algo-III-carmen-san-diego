package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Rasgo;
import fiuba.algo3.Sospechoso;

public class SospechosoTest {
	
	private Rasgo SEXO;
	private Rasgo HOBBY;
	private Rasgo CABELLO;
	private Rasgo SENIA;
	private Rasgo VEHICULO;	
	
	public SospechosoTest(){
		SEXO = new Rasgo("Femenino");
		HOBBY = new Rasgo("Tenis");
		CABELLO = new Rasgo("Rojo");
		SENIA = new Rasgo("Anillo");
		VEHICULO = new Rasgo("Descapotable");	
	}
	
	private Sospechoso generarSospechoso(){
		Sospechoso sospechoso = new Sospechoso();
		sospechoso.setSexo(SEXO);
		sospechoso.setHobby(HOBBY);
		sospechoso.setCabello(CABELLO);
		sospechoso.setSenia(SENIA);
		sospechoso.setVehiculo(VEHICULO);
		
		return sospechoso;
	}
	
	@Test
	public void deberiaGuardarLosRasgos(){		
		
		Sospechoso sospechoso = new Sospechoso();
		sospechoso = generarSospechoso();
		
		Assert.assertEquals(SEXO, sospechoso.getSexo());
		Assert.assertEquals(HOBBY, sospechoso.getHobby());
		Assert.assertEquals(CABELLO, sospechoso.getCabello());
		Assert.assertEquals(SENIA, sospechoso.getSenia());
		Assert.assertEquals(VEHICULO, sospechoso.getVehiculo());	
	}
	
	@Test
	public void deberiaReconocerSospechososCoincidentes(){
		Sospechoso sospechoso = generarSospechoso();
		
		Assert.assertTrue(sospechoso.coincideRasgosCon(sospechoso));
	}
	
	@Test
	public void noDeberiaReconocerSospechososDiferentes(){
		Sospechoso sospechoso = generarSospechoso();
		Sospechoso ladron = new Sospechoso();
		
		ladron.setSexo(new Rasgo("Masculino"));
		ladron.setHobby(HOBBY);
		ladron.setCabello(CABELLO);
		ladron.setSenia(SENIA);
		ladron.setVehiculo(VEHICULO);
		
		Assert.assertFalse(sospechoso.coincideRasgosCon(ladron));		
	}
	
}
