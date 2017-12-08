package modelo;

public class Atleta extends Persona {

	private String codigo;
	
	public Atleta() {
		
	}

	public Atleta(String nombre, String apellido, String cedula, String codigo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
