package modelo;

public class Autor extends Persona {


	private String pseudonimo;
	private String nacionalidad;
	
	public Autor() {
		
	}
	
	public Autor(String nombre, String apellido, String cedula, String pseudonimo, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.pseudonimo = pseudonimo;
		this.nacionalidad = nacionalidad;
	}
	
	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
}
