package fiuba.algo3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
		
		if(!jefatura.esUltimoPais(ubicacion)){
			System.out.println("Seleccione un pais a viajar:");
			Pais paisCorrecto;
			if (seConfundioDePais()){
				Pais miPaisActual = paisesVisitados.pop();
				paisCorrecto = paisesVisitados.peek();
				paisesVisitados.push(miPaisActual);
			}
			else{
				paisCorrecto = jefatura.paisActualDelLadron(ubicacion);
			}
			
			
			String unStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
			Pais unPaisIncorrecto = Pais.hidratar(doc, unStringDePaisIncorrecto, null, null);

			
			String otroStringDePaisIncorrecto = unStringDePaisIncorrecto;
			while(otroStringDePaisIncorrecto.matches(unStringDePaisIncorrecto)){
				otroStringDePaisIncorrecto = mundo.getUnPaisDistintoDe(paisCorrecto.getNombre());
			}
			Pais otroPaisIncorrecto = Pais.hidratar(doc, otroStringDePaisIncorrecto, null, null);
			
			
			ArrayList<Pais> paisesAElegir = new ArrayList<Pais>();
			paisesAElegir.add(paisCorrecto);
			paisesAElegir.add(unPaisIncorrecto);
			paisesAElegir.add(otroPaisIncorrecto);
			Collections.shuffle(paisesAElegir);
			System.out.println("1. " + (paisesAElegir.get(0)).getNombre());
			System.out.println("2. " + (paisesAElegir.get(1)).getNombre());
			System.out.println("3. " + (paisesAElegir.get(2)).getNombre());

			
			
			System.in.read();	//Lee el enter
			System.in.read();	//Lee el retorno al carro
			char numero = (char)System.in.read();
			switch (numero){
			case '1':
					viajarA(paisesAElegir.get(0));
					break;
			case '2':
					viajarA(paisesAElegir.get(1));
					break;
			case '3':
					viajarA(paisesAElegir.get(2));
					break;
			}
		}
		else{
			System.out.println("Se rumorea que el ladron esta en la ciudad. Buscalo!");
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
	
	public abstract String rango();
}
