package modelo;

public class Pais {

	private String nombre;
	private String presidente;
	private String nHabitantes;
	
	public Pais() {
		
	}
	
	public Pais(String nombre, String presidente, String nHabitantes) {
		super();
		this.nombre = nombre;
		this.presidente = presidente;
		this.nHabitantes = nHabitantes;
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

}
