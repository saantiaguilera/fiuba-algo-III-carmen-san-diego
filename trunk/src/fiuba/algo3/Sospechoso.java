package fiuba.algo3;

public class Sospechoso {
	
	private Rasgo sexo;
	private Rasgo hobby;
	private Rasgo cabello;
	private Rasgo senia;
	private Rasgo vehiculo;
	
	public Sospechoso(){
		sexo = new Rasgo();
		hobby = new Rasgo();
		cabello = new Rasgo();
		senia = new Rasgo();
		vehiculo = new Rasgo();
	}

	public Rasgo getSexo() {
		return sexo;
	}

	public void setSexo(Rasgo sexo) {
		this.sexo = sexo;
	}

	public Rasgo getHobby() {
		return hobby;
	}

	public void setHobby(Rasgo hobby) {
		this.hobby = hobby;
	}

	public Rasgo getCabello() {
		return cabello;
	}

	public void setCabello(Rasgo cabello) {
		this.cabello = cabello;
	}

	public Rasgo getSenia() {
		return senia;
	}

	public void setSenia(Rasgo senia) {
		this.senia = senia;
	}

	public Rasgo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Rasgo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	public boolean coincideRasgosCon(Sospechoso ladron) {
		int cantidadCoincidencias = 0;
		int COINCIDENCIAS_MINIMAS = 3;
		
		if(ladron.getSexo().tieneRasgo())
			if(sexo == ladron.getSexo())
				cantidadCoincidencias++;
			else return false;
		
		if(ladron.getHobby().tieneRasgo())
			if(hobby == ladron.getHobby())
				cantidadCoincidencias++;
			else return false;
		
		if(ladron.getCabello().tieneRasgo())	
			if(cabello == ladron.getCabello())
				cantidadCoincidencias++;
			else return false;
		
		if(ladron.getSenia().tieneRasgo())
			if(senia == ladron.getSenia())
				cantidadCoincidencias++;
			else return false;
		
		if(ladron.getVehiculo().tieneRasgo())
			if(vehiculo == ladron.getVehiculo())
				cantidadCoincidencias++;
			else return false;
		
		return cantidadCoincidencias >= COINCIDENCIAS_MINIMAS;
		
	}
}