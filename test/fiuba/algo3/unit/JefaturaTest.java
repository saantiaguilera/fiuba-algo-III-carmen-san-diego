package fiuba.algo3.unit;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.*;

public class JefaturaTest {
	
	@Test
	public void deberiaInicializarJefaturaSinOrdenEmitida() {
		Jefatura jefatura = new Jefatura(new Ladron());
	
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}
		
}
