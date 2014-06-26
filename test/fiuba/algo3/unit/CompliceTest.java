package fiuba.algo3.unit;

import org.junit.Assert;

import org.junit.Test;

import fiuba.algo3.Complice;
import fiuba.algo3.Ladron;
import fiuba.algo3.Pista;

public class CompliceTest {

	Pista pistaFacil;
	Pista pistaMedia;
	Pista pistaDificil;

	public CompliceTest(){
		pistaFacil = new Pista("Pista Facil");
		pistaMedia = new Pista("Pista Media");
		pistaDificil = new Pista("Pista Dificil");
	}
	
	@Test
	public void deberiaAlbergarTresPistas(){
		Complice complice = new Complice(new Ladron(), null);
		complice.agregarPistaFacil(this.pistaFacil);
		complice.agregarPistaMedia(this.pistaMedia);
		complice.agregarPistaDificil(this.pistaDificil);
		
		Assert.assertEquals(this.pistaFacil, complice.darPistaFacil());
		Assert.assertEquals(this.pistaMedia, complice.darPistaMedia());
		Assert.assertEquals(this.pistaDificil, complice.darPistaDificil());
	}
	
	
}
