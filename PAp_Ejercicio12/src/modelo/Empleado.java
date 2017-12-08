package modelo;

public class Empleado extends Persona {

	private String telefono;
	
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellido, String cedula, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
