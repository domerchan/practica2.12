package modelo;

public class Canton {

	private String nombre;
	private String nHabitantes;
	private String ubicacionGPS;
	
	public Canton() {
		
	}

	public Canton(String nombre, String nHabitantes, String ubicacionGPS) {
		super();
		this.nombre = nombre;
		this.nHabitantes = nHabitantes;
		this.ubicacionGPS = ubicacionGPS;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnHabitantes() {
		return nHabitantes;
	}

	public void setnHabitantes(String nHabitantes) {
		this.nHabitantes = nHabitantes;
	}

	public String getUbicacionGPS() {
		return ubicacionGPS;
	}

	public void setUbicacionGPS(String ubicacionGPS) {
		this.ubicacionGPS = ubicacionGPS;
	}

}
