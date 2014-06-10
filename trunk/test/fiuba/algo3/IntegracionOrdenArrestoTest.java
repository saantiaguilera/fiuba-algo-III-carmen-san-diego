package fiuba.algo3;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionOrdenArrestoTest {
	
	@Test
	public void emiteOrdenSiEsCorrecta(){

		Rasgo SEXO = new Rasgo("Masculino");
		Rasgo CABELLO = new Rasgo("Rubio");
		Rasgo SENIA = new Rasgo("Tatuaje");
				
		Sospechoso ladron = new Sospechoso();
		Sospechoso sospechoso = new Sospechoso();
				
		ladron.setSexo(SEXO);
		sospechoso.setSexo(SEXO);
		ladron.setCabello(CABELLO);
		sospechoso.setCabello(CABELLO);
		ladron.setSenia(SENIA);
		sospechoso.setSenia(SENIA);
	
		Jefatura jefatura = new Jefatura(ladron);
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertTrue(jefatura.ordenEstaEmitida());
	}
	
	@Test
	public void noDeberiaEmitirOrdenSiEsIncorrecta(){
		
		Sospechoso ladron = new Sospechoso();
		Sospechoso sospechoso = new Sospechoso();	
		
		Rasgo HOBBY_LADRON = new Rasgo("Tenis");
		Rasgo HOBBY_SOSP = new Rasgo("Alpinismo");
		
		ladron.setHobby(HOBBY_LADRON);
		sospechoso.setHobby(HOBBY_SOSP);
		
		Jefatura jefatura = new Jefatura(ladron);		
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertFalse(jefatura.ordenEstaEmitida());
		}
	
	@Test
	public void coincidirTresRasgosPeroErrarUnoNoDeberiaEmitirOrden(){
		
		Sospechoso ladron = new Sospechoso();
		Sospechoso sospechoso = new Sospechoso();
		
		ladron.setSexo(new Rasgo("Masculino"));
		sospechoso.setSexo(new Rasgo("Masculino"));
		ladron.setCabello(new Rasgo("Rubio"));
		sospechoso.setCabello(new Rasgo("Rubio"));
		ladron.setHobby(new Rasgo("Musica"));
		sospechoso.setHobby(new Rasgo("Musica"));
		
		ladron.setSenia(new Rasgo("Tatuaje"));
		sospechoso.setSenia(new Rasgo("Anillo"));
		
		Jefatura jefatura = new Jefatura(ladron);
		jefatura.emitirOrden(sospechoso);
		
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}
}
