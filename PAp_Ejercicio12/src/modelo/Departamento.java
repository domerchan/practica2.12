package modelo;

public class Departamento {

	private String nombre;
	private String nDepartamento;
	private String planta;
	
	public Departamento() {
		
	}

	public Departamento(String nombre, String nDepartamento, String planta) {
		super();
		this.nombre = nombre;
		this.nDepartamento = nDepartamento;
		this.planta = planta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnDepartamento() {
		return nDepartamento;
	}

	public void setnDepartamento(String nDepartamento) {
		this.nDepartamento = nDepartamento;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

}
