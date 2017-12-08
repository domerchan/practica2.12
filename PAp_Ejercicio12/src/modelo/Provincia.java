package modelo;

import java.util.List;

public class Provincia {

	private String nombre;
	private String alcalde;
	private String nHabitantes;
	private List<Canton> cantones;
	
	public Provincia() {
		
	}

	public Provincia(String nombre, String alcalde, String nHabitantes, List<Canton> cantones) {
		super();
		this.nombre = nombre;
		this.alcalde = alcalde;
		this.nHabitantes = nHabitantes;
		this.cantones = cantones;
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

	public List<Canton> getCantones() {
		return cantones;
	}

	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}

}
