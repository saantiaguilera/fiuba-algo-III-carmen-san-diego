package fiuba.algo3.unit;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.*;

public class JefaturaTest {

	@Test
	public void deberiaInicializarJefaturaSinOrdenEmitida() {
		Jefatura jefatura = new Jefatura(new Sospechoso());
	
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}

}
