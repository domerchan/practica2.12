package modelo;

public class Provincia {

	private String nombre;
	private String alcalde;
	private String nHabitantes;
	
	public Provincia() {
		
	}

	public Provincia(String nombre, String alcalde, String nHabitantes) {
		super();
		this.nombre = nombre;
		this.alcalde = alcalde;
		this.nHabitantes = nHabitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlcalde() {
		return alcalde;
	}

	public void setAlcalde(String alcalde) {
		this.alcalde = alcalde;
	}

	public String getnHabitantes() {
		return nHabitantes;
	}

	public void setnHabitantes(String nHabitantes) {
		this.nHabitantes = nHabitantes;
	}

}
