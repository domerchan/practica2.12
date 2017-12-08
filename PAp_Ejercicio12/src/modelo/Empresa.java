package modelo;

public class Empresa {

	private String nombre;
	private String ruc;
	private String direccion;
	
	public Empresa() {
		
	}

	public Empresa(String nombre, String ruc, String direccion) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", ruc=" + ruc + ", direccion=" + direccion + "]";
	}
	
}
