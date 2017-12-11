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
	private List<Empleado> empleados;
	private String pathC = "src/archivos/C.txt";
	
	public GestionC() {
		
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
	}
	
	public void addEmpleado(String telefono,String nombre,String apellido,String cedula,Persona persona) {
		try {
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCedula(cedula);
		empleado.setTelefono(telefono);
		empleados.add(empleado);
		
		FileWriter file = new FileWriter(pathC, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = empleado.getNombre()+" , "+empleado.getApellido()+" , "+empleado.getCedula()+" , "+empleado.getTelefono();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
		
	}
	
	public void addDepartamento(String nombre,String nDepartamento,String planta, Empleado empleado) {
		try {
		Departamento departamento = new Departamento();
		departamento.setNombre(nombre);
		departamento.setnDepartamento(nDepartamento);
		departamento.setPlanta(planta);
		departamento.setEmpleados(empleados);
		departamentos.add(departamento);
		
		FileWriter file = new FileWriter(pathC, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = departamento.getNombre()+" , "+departamento.getnDepartamento()+" , "+departamento.getPlanta()+" , "+departamento.getEmpleados();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addEmpresa(String nombre, String ruc, String direccion, Departamento departamento) {
		try {
		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		empresa.setRuc(ruc);
		empresa.setDireccion(direccion);
		empresa.setDepartamentos(departamentos);
		
		FileWriter file = new FileWriter(pathC, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = empresa.getNombre()+" , "+empresa.getRuc()+" , "+empresa.getDireccion()+" , "+empresa.getDepartamentos();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public boolean isCedulaValida(String cedula) throws Exception{
		try {
			int a = Integer.parseInt(cedula);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("Debe ser de 10 dígitos");
		
		return true;
	}
	
	public boolean duplicadosDepartamentos(String nombre,String nDepartamento){
		for(int i=0; i<departamentos.size();i++) {
			if(departamentos.get(i).getNombre().equals(nombre) && departamentos.get(i).getnDepartamento().equals(nDepartamento)){
				return true;
			}
		}
		return false;
	}
	
	public boolean duplicadosEmpleados(String nombre,String cedula){
		for(int i=0; i<empleados.size();i++) {
			if(empleados.get(i).getNombre().equals(nombre) && empleados.get(i).getCedula().equals(cedula)){
				return true;
			}
		}
		return false;
	}
}
