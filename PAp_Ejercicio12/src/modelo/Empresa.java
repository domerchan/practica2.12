package modelo;

import java.util.List;

public class Empresa {

	private String nombre;
	private String ruc;
	private String direccion;
	private List<Departamento> departamentos;
	
	public Empresa() {
		
	}

	public Empresa(String nombre, String ruc, String direccion, List<Departamento> departamentos) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
		this.departamentos = departamentos;
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
