package modelo;

import java.util.List;

public class Pais {

	private String nombre;
	private String presidente;
	private String nHabitantes;
	private List<Provincia> provincias;
	
	public Pais() {
		
	}
	
	public Pais(String nombre, String presidente, String nHabitantes, List<Provincia> provincias) {
		super();
		this.nombre = nombre;
		this.presidente = presidente;
		this.nHabitantes = nHabitantes;
		this.provincias = provincias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getnHabitantes() {
		return nHabitantes;
	}

	public void setnHabitantes(String nHabitantes) {
		this.nHabitantes = nHabitantes;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

}
