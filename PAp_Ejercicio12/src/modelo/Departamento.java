package modelo;

import java.util.List;

public class Departamento {

	private String nombre;
	private String nDepartamento;
	private String planta;
	private List<Empleado> empleados;
	
	public Departamento() {
		
	}

	public Departamento(String nombre, String nDepartamento, String planta, List<Empleado> empleados) {
		super();
		this.nombre = nombre;
		this.nDepartamento = nDepartamento;
		this.planta = planta;
		this.empleados = empleados;
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

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
