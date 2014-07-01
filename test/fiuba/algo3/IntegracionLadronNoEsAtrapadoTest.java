  package fiuba.algo3;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionLadronNoEsAtrapadoTest {

	private Pais brasil = new Pais(2000,2000,"Brasil");
	private Pais argentina = new Pais(0,0,"Argentina");
	
	private ArrayList<Pais> generarListaPaises(){
		ArrayList<Pais> listaPaises = new ArrayList<Pais>();
		listaPaises.add(brasil);
		
		return listaPaises;
	}

	private Ladron generarLadron(){
		Ladron ladron = new Ladron(generarListaPaises(), "Carmen SanDiego");
		
		ladron.setSexo(new Rasgo("Femenino"));
		ladron.setCabello(new Rasgo("Rojo"));
		ladron.setHobby(new Rasgo("Alpinismo"));
		ladron.setSenia(new Rasgo("Anillo"));
		ladron.setVehiculo(new Rasgo("Descapotable"));
		
		return ladron;
	}
	
	private Edificio generarBibliotecaConPistaMediaDe(Pais pais){
		Edificio biblio;
		
		if(pais.getNombre() == "Argentina"){
			biblio = new Edificio();
			biblio.agregarPistaMedia(new Pista("Queria ver la triple forntera. Tenia un anillo"));
		}
		else{
			biblio = new Edificio();
			//biblio.setTienenArmas(true);
			biblio.agregarPistaMedia(new Pista("La banda esta cerca, podrian lastimarte"));
		}
		
		return biblio;
	}
	
	private Edificio generarPuertoConPistaMediaDe(Pais pais){
		Edificio puerto;
		
		if(pais.getNombre() == "Argentina"){
			puerto = new Edificio();
			puerto.agregarPistaMedia(new Pista("Se fue en un auto con la bandera verde, amarilla y azul. Era una mujer"));
		}
		else{
			puerto = new Edificio();
			//puerto.setTienenCuchillos(true);
			puerto.agregarPistaMedia(new Pista("La banda esta cerca, podrian lastimarte"));
		}
		
		return puerto;		
	}
	
	private Edificio generarBancoConPistaMediaDe(Pais pais){
		Edificio banco;
		
		if(pais.getNombre() == "Argentina"){
			banco = new Edificio();
			banco.agregarPistaMedia(new Pista("Se fue en un auto con la bandera verde, amarilla y azul. Tenia el pelo rojo"));
		}
		else{
			banco = new Edificio();
			//banco.setSeEscondioElLadron(true);
			banco.agregarPistaMedia(new Pista("Alli esa el ladron"));
		}
		
		return banco;			
	}
	
	@Test
	public void faltaOrdenDeArrestoParaAtraparAlLadron(){
		Ladron ladron = generarLadron();
		Jefatura jefatura = new Jefatura(ladron);
		Personaje personaje = new PersonajeDetective(168,argentina,1100, jefatura);
		Sospechoso sospechoso = new Sospechoso();
		
		Edificio biblioteca = generarBibliotecaConPistaMediaDe(argentina);
		Edificio puerto = generarPuertoConPistaMediaDe(argentina);
		Edificio banco = generarBancoConPistaMediaDe(argentina);
		
		personaje.pedirPistaA(biblioteca);
		sospechoso.setSenia(new Rasgo("Anillo"));
		personaje.pedirPistaA(puerto);
		sospechoso.setSexo(new Rasgo("Femenino"));
		personaje.pedirPistaA(banco);
		sospechoso.setCabello(new Rasgo("Rojo"));
		
		personaje.viajarA(brasil);
		
		biblioteca = generarBibliotecaConPistaMediaDe(brasil);
		puerto = generarPuertoConPistaMediaDe(brasil);
		banco = generarBancoConPistaMediaDe(brasil);
		
		personaje.pedirPistaA(biblioteca);
		personaje.pedirPistaA(puerto);
		personaje.pedirPistaA(banco);
		
		Assert.assertTrue(personaje.getUbicacion().getNombre() == "Brasil");
		Assert.assertTrue(banco.vecesVisitado() == 1);
		Assert.assertTrue(personaje.getHorasRestantes() >= 0);
		Assert.assertFalse(jefatura.ordenEstaEmitida());
		}

	@Test
	public void ordenDeArrestoIncorrectaParaAtraparAlLadron(){
		Ladron ladron = generarLadron();
		Jefatura jefatura = new Jefatura(ladron);
		Personaje personaje = new PersonajeDetective(168,argentina,1100, jefatura);
		Sospechoso sospechoso = new Sospechoso();
		
		Edificio biblioteca = generarBibliotecaConPistaMediaDe(argentina);
		Edificio puerto = generarPuertoConPistaMediaDe(argentina);
		Edificio banco = generarBancoConPistaMediaDe(argentina);
		
		personaje.pedirPistaA(biblioteca);
		sospechoso.setSenia(new Rasgo("Anillo"));
		personaje.pedirPistaA(puerto);
		sospechoso.setSexo(new Rasgo("Masculino"));
		personaje.pedirPistaA(banco);
		sospechoso.setCabello(new Rasgo("Rojo"));
		
		personaje.emitirOrdenA(sospechoso);
		personaje.viajarA(brasil);
		
		biblioteca = generarBibliotecaConPistaMediaDe(brasil);
		puerto = generarPuertoConPistaMediaDe(brasil);
		banco = generarBancoConPistaMediaDe(brasil);
		
		personaje.pedirPistaA(biblioteca);
		personaje.pedirPistaA(puerto);
		personaje.pedirPistaA(banco);
		
		Assert.assertTrue(personaje.getUbicacion().getNombre() == "Brasil");
		Assert.assertTrue(banco.vecesVisitado() == 1);
		Assert.assertTrue(personaje.getHorasRestantes() >= 0);
		Assert.assertFalse(jefatura.ordenEstaEmitida());
	}

	@Test
	public void noSeVisitaElEdificioDelLadron(){
		Ladron ladron = generarLadron();
		Jefatura jefatura = new Jefatura(ladron);
		Personaje personaje = new PersonajeDetective(168,argentina,1100,jefatura);
		Sospechoso sospechoso = new Sospechoso();
		
		Edificio biblioteca = generarBibliotecaConPistaMediaDe(argentina);
		Edificio puerto = generarPuertoConPistaMediaDe(argentina);
		Edificio banco = generarBancoConPistaMediaDe(argentina);
		
		personaje.pedirPistaA(biblioteca);
		sospechoso.setSenia(new Rasgo("Anillo"));
		personaje.pedirPistaA(puerto);
		sospechoso.setSexo(new Rasgo("Femenino"));
		personaje.pedirPistaA(banco);
		sospechoso.setCabello(new Rasgo("Rojo"));
		
		personaje.viajarA(brasil);
		
		biblioteca = generarBibliotecaConPistaMediaDe(brasil);
		puerto = generarPuertoConPistaMediaDe(brasil);
		banco = generarBancoConPistaMediaDe(brasil);
		
		personaje.pedirPistaA(biblioteca);
		personaje.pedirPistaA(puerto);
		
		Assert.assertTrue(personaje.getUbicacion().getNombre() == "Brasil");
		Assert.assertTrue(personaje.getHorasRestantes() >= 0);
		Assert.assertFalse(jefatura.ordenEstaEmitida());
		
		Assert.assertTrue(banco.vecesVisitado() == 0);
	}
}
