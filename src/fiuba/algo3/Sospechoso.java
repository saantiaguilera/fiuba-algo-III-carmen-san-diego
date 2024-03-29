package fiuba.algo3;

public class Sospechoso {
	
	protected Rasgo sexo;
	protected Rasgo hobby;
	protected Rasgo cabello;
	protected Rasgo senia;
	protected Rasgo vehiculo;
	
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
	
	
	public boolean coincideRasgosCon(Sospechoso sospechoso) {
		int cantidadCoincidencias = 0;
		int COINCIDENCIAS_MINIMAS = 3;
		
		if(sospechoso.getSexo().hayRasgo())
			if(sexo.getRasgo().matches(sospechoso.getSexo().getRasgo()))
				cantidadCoincidencias++;
			else return false;
		
		if(sospechoso.getHobby().hayRasgo())
			if(hobby.getRasgo().matches(sospechoso.getHobby().getRasgo()))
				cantidadCoincidencias++;
			else return false;
		
		if(sospechoso.getCabello().hayRasgo())	
			if(cabello.getRasgo().matches(sospechoso.getCabello().getRasgo()))
				cantidadCoincidencias++;
			else return false;
		
		if(sospechoso.getSenia().hayRasgo())
			if(senia.getRasgo().matches(sospechoso.getSenia().getRasgo()))
				cantidadCoincidencias++;
			else return false;
		
		if(sospechoso.getVehiculo().hayRasgo())
			if(vehiculo.getRasgo().matches(sospechoso.getVehiculo().getRasgo()))
				cantidadCoincidencias++;
			else return false;
		
		return cantidadCoincidencias >= COINCIDENCIAS_MINIMAS;	
	}
	
}