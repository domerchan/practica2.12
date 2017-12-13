package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Autor;
import modelo.Canton;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Persona;
import modelo.Provincia;

public class GestionC {

	private List<Departamento> departamentos;
	private List<Empleado> empleadosV;
	private List<Empleado> empleadosC;
	private Empresa empresa;
	private String pathC = "src/archivos/C.txt";

	public GestionC() {

		departamentos = new ArrayList<Departamento>();
		empleadosV = new ArrayList<Empleado>();
		empleadosC = new ArrayList<Empleado>();
		addDepartamento();
		addEmpresa();
	}

	public void addEmpleado(String nombre, String apellido, String cedula, String telefono, String departamento) {
		try {
			Empleado empleado = new Empleado();

			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			empleado.setCedula(cedula);
			empleado.setTelefono(telefono);

			if (departamentos.get(0).getNombre().equals(departamento))
				empleadosV.add(empleado);
			else if (departamentos.get(1).getNombre().equals(departamento))
				empleadosC.add(empleado);

			FileWriter file = new FileWriter(pathC, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = empleado.getNombre() + " , " + empleado.getApellido() + " , " + empleado.getCedula()
					+ " , " + empleado.getTelefono();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	private void saveDepartamento(Departamento departamento) throws IOException {
		FileWriter file = new FileWriter(pathC, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = departamento.getNombre() + " , " + departamento.getnDepartamento() + " , "
				+ departamento.getPlanta() + " , " + departamento.getEmpleados();
		out.append(registro + "\n");
		out.close();
		file.close();
	}

	public void addDepartamento() {
		try {
			Departamento departamento = new Departamento();
			departamento.setNombre("Ventas");
			departamento.setnDepartamento("1");
			departamento.setPlanta("2");
			departamento.setEmpleados(empleadosV);
			departamentos.add(departamento);

			saveDepartamento(departamento);

			departamento = new Departamento();
			departamento.setNombre("Contabilidad");
			departamento.setnDepartamento("2");
			departamento.setPlanta("4");
			departamento.setEmpleados(empleadosC);
			departamentos.add(departamento);

			saveDepartamento(departamento);

		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void addEmpresa() {
		try {
			empresa = new Empresa();
			empresa.setNombre("La Favorita");
			empresa.setRuc("01065065");
			empresa.setDireccion("Av. Don Bosco");
			empresa.setDepartamentos(departamentos);

			FileWriter file = new FileWriter(pathC, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = empresa.getNombre() + " , " + empresa.getRuc() + " , " + empresa.getDireccion() + " , "
					+ empresa.getDepartamentos();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public Empresa listEmpresa() {
		return empresa;
	}

	public List<Empleado> listEmpleados(String departamento) {
		if (departamentos.get(0).getNombre().equals(departamento))
				return empleadosV;
		else if (departamentos.get(1).getNombre().equals(departamento))
				return empleadosC;
		return null;
	}

	public String[] getEmpresa() {
		String[] lista = new String[1];
		lista[0] = empresa.getNombre();
		return lista;
	}

	public String[] getDepartamentos() {
		String[] lista = new String[departamentos.size()];
		for (int i = 0; i < departamentos.size(); i++)
			lista[i] = departamentos.get(i).getNombre();
		return lista;
	}

	public String[] getEmpleados(String departamento) {
		String[] lista;
		if (departamentos.get(0).getNombre().equals(departamento)) {
			lista = new String[empleadosV.size()];
			for (int i = 0; i < empleadosV.size(); i++) {
				lista[i] = empleadosV.get(i).getNombre();
			}
			return lista;
		} else if (departamentos.get(1).getNombre().equals(departamento)) {
			lista = new String[empleadosC.size()];
			for (int i = 0; i < empleadosC.size(); i++) {
				lista[i] = empleadosC.get(i).getNombre();
			}
			return lista;
		}
		return null;
	}

	public boolean isCedulaValida(String cedula) throws Exception {
		try {
			int a = Integer.parseInt(cedula);
		} catch (NumberFormatException e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (cedula.length() != 10)
			throw new Exception("Debe ser de 10 dígitos");

		return true;
	}

	public boolean duplicadosDepartamentos(String nombre, String nDepartamento) {
		for (int i = 0; i < departamentos.size(); i++) {
			if (departamentos.get(i).getNombre().equals(nombre)
					&& departamentos.get(i).getnDepartamento().equals(nDepartamento)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public boolean duplicadosEmpleados(String nombre, String cedula) { for
	 * (int i = 0; i < empleados.size(); i++) { if
	 * (empleados.get(i).getNombre().equals(nombre) &&
	 * empleados.get(i).getCedula().equals(cedula)) { return true; } } return
	 * false; }
	 */
}
