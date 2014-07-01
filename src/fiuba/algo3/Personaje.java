package fiuba.algo3;

import java.io.IOException;
import java.util.Calendar;
import java.util.Stack;

import org.w3c.dom.Document;

public abstract class Personaje {
	protected Pais ubicacion;
	protected int velocidad;
	protected Calendar horaActual;
	protected static int horasADormir = 8;
	protected Calendar tiempoLimite;
	protected Jefatura jefatura;
	protected Stack<Pais> paisesVisitados;
	protected boolean capturoAlLadron;
	
	public Personaje(int horasMaxima, Jefatura unaJefatura) {
		horaActual = Calendar.getInstance();
		horaActual.set(2014,7,1,8,0,0);//1 de julio de 2014 8 am
		tiempoLimite = Calendar.getInstance();
		tiempoLimite.set(2014,7,1,8,0,0);
	    tiempoLimite.add(Calendar.HOUR_OF_DAY, horasMaxima);
	    jefatura=unaJefatura;
	    paisesVisitados = new Stack<Pais>();
	    paisesVisitados.push(ubicacion);
	    capturoAlLadron=false;
	}
	
	public boolean ladronCapturado(){
		return capturoAlLadron;
	}
	
	public void capturarLadron(){
		capturoAlLadron = true;
	}
	
	public void viajarA(Pais destino){
		restarHoras(this.calcularTiempo(destino));
		this.ubicacion = destino;
		paisesVisitados.push(ubicacion);
	}
	
	public void restarHoras(int horas){
		horaActual.add(Calendar.HOUR_OF_DAY, horas);
		if (this.horaActual.get(Calendar.HOUR_OF_DAY) >= 22 || this.horaActual.get(Calendar.HOUR_OF_DAY) <= 4){//si son entre las 22 y las 4 duerme
			this.dormir();
		}
	}
	
	public void elegirPaisAViajar(Mundo mundo, Document doc) throws IOException{
		System.out.println("Seleccione un pais a viajar:");
		Pais paisCorrecto;
		if (seConfundioDePais()){
			Pais miPaisActual = paisesVisitados.pop();
			paisCorrecto = paisesVisitados.peek();
			System.out.println("1. " + paisCorrecto.getNombre());
			paisesVisitados.push(miPaisActual);
		}
		else{
			paisCorrecto = jefatura.paisActualDelLadron(ubicacion);
			System.out.println("1. " + paisCorrecto.getNombre());
		}
		String unStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
		Pais unPaisIncorrecto = Pais.hidratar(doc, unStringDePaisIncorrecto, null, null);
		System.out.println("2. " + unPaisIncorrecto.getNombre());
		
		String otroStringDePaisIncorrecto = unStringDePaisIncorrecto;
		while(otroStringDePaisIncorrecto.matches(unStringDePaisIncorrecto)){
			otroStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
		}
		Pais otroPaisIncorrecto = Pais.hidratar(doc, otroStringDePaisIncorrecto, null, null);
		System.out.println("3. " + otroPaisIncorrecto.getNombre());
		
		System.in.read();	//Lee el enter
		System.in.read();	//Lee el retorno al carro
		char numero = (char)System.in.read();
		switch (numero){
		case '1':
				viajarA(paisCorrecto);
				break;
		case '2':
				viajarA(unPaisIncorrecto);
				break;
		case '3':
				viajarA(otroPaisIncorrecto);
				break;
		}
	}
	
	private boolean seConfundioDePais() {
		return !jefatura.verificarSiElLadronPasoPor(ubicacion);
	}

	private int calcularTiempo(Pais destino){
		double distancia = ubicacion.calcularDistanciaCon(destino);
		return (int)(distancia/velocidad);			
	}
	
	public int getHorasRestantes(){
		int diasAux = tiempoLimite.get(Calendar.DAY_OF_MONTH) - horaActual.get(Calendar.DAY_OF_MONTH);
		int horasAux = diasAux * 24;
		if (tiempoLimite.get(Calendar.HOUR_OF_DAY) >= horaActual.get(Calendar.HOUR_OF_DAY)){
			horasAux = horasAux + (tiempoLimite.get(Calendar.HOUR_OF_DAY) - horaActual.get(Calendar.HOUR_OF_DAY));}
		else{
			horasAux = horasAux - ( horaActual.get(Calendar.HOUR_OF_DAY) - tiempoLimite.get(Calendar.HOUR_OF_DAY) );	
			}
		return horasAux;
	}
	
	public Pais getUbicacion(){
		return ubicacion;
	}

	public abstract Pista pedirPistaA(Edificio edificio);
	
	public void emitirOrdenA(Sospechoso sospechoso) {
		this.restarHoras(3);
		jefatura.emitirOrden(sospechoso);
	}
	
	private void dormir(){
		horaActual.add(Calendar.HOUR_OF_DAY, horasADormir);
	}
	
	public String getTiempoLimite(){
		String diaLimite = new String();
		diaLimite = Integer.toString(tiempoLimite.get(Calendar.HOUR_OF_DAY)) +" hs del dia " + Integer.toString(tiempoLimite.get(Calendar.DATE)) +"/" + Integer.toString(tiempoLimite.get(Calendar.MONTH));
		return diaLimite;
	}
	
	public String getHoraActual(){
		String hora = new String();
		hora = Integer.toString(horaActual.get(Calendar.HOUR_OF_DAY)) +" hs del dia " + Integer.toString(horaActual.get(Calendar.DATE)) +"/" + Integer.toString(horaActual.get(Calendar.MONTH));
		return hora;
	}
	
	public Sospechoso describirSospechoso() throws IOException{
		Sospechoso sospechoso = new Sospechoso();
		char opcion;
		System.out.println("SEXO\n1. Masculino\n2. Femenino\n3. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setSexo(new Rasgo("masculino"));
			break;
		case '2':
			sospechoso.setSexo(new Rasgo("femenino"));
			break;
		}
		System.out.println("HOBBY\n1. Alpinismo\n2. Croquet\n3. Tenis");
		System.out.println("4. Musica\n5. Paracaidismo\n6. Natacion\n7. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char) System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setHobby(new Rasgo("alpinismo"));
			break;
		case '2':
			sospechoso.setHobby(new Rasgo("croquet"));
			break;
		case '3':
			sospechoso.setHobby(new Rasgo("tenis"));
			break;
		case '4':
			sospechoso.setHobby(new Rasgo("musica"));
			break;
		case '5':
			sospechoso.setHobby(new Rasgo("paracaidismo"));
			break;
		case '6':
			sospechoso.setHobby(new Rasgo("natacion"));
			break;
		}
		System.out.println("CABELLO\n1. Negro\n2. Colorado\n3. Rubio");
		System.out.println("4. Castanio\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setCabello(new Rasgo("negro"));
			break;
		case '2':
			sospechoso.setCabello(new Rasgo("colorado"));
			break;
		case '3':
			sospechoso.setCabello(new Rasgo("rubio"));
			break;
		case '4':
			sospechoso.setCabello(new Rasgo("castanio"));
		}
		System.out.println("SENIA\n1. Anillos\n2. Tatuajes\n3. Joyas");
		System.out.println("4. Cicatrices\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setSenia(new Rasgo("anillos"));
			break;
		case '2':
			sospechoso.setSenia(new Rasgo("tatuajes"));
			break;
		case '3':
			sospechoso.setSenia(new Rasgo("joyas"));
			break;
		case '4':
			sospechoso.setSenia(new Rasgo("cicactrices"));
		}
		System.out.println("VEHICULO\n1. Moto\n2. Descapotable\n3. Limusina");
		System.out.println("4. Deportivo\n5. Desconocido");
		System.in.read(); System.in.read();
		opcion = (char)System.in.read();
		switch(opcion){
		case '1':
			sospechoso.setVehiculo(new Rasgo("moto"));
			break;
		case '2':
			sospechoso.setVehiculo(new Rasgo("descapotable"));
			break;
		case '3':
			sospechoso.setVehiculo(new Rasgo("limusina"));
			break;
		case '4':
			sospechoso.setVehiculo(new Rasgo("deportivo"));
		}
		
		return sospechoso;
	}
	
	public abstract String rango();
}
