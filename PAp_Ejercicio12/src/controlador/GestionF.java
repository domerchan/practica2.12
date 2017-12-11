package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

public class GestionF {
	
	private List<Paciente> pacientes;
	private String pathF = "src/archivos/F.txt";
	
	public GestionF() {
		pacientes = new ArrayList<Paciente>();
	}
	
	public void addPaciente(String telefono, String nombre, String apellido, String cedula) {
		try {
		Paciente paciente = new Paciente();
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setCedula(cedula);
		paciente.setTelefono(telefono);
		pacientes.add(paciente);
		
		FileWriter file = new FileWriter(pathF, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = paciente.getNombre()+" , "+paciente.getApellido()+" , "+paciente.getCedula()+" , "+paciente.getTelefono();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void addMedico(String nombre, String apellido, String cedula) {
		try {
		Medico medico = new Medico();
		medico.setNombre(nombre);
		medico.setApellido(apellido);
		medico.setCedula(cedula);
		
		FileWriter file = new FileWriter(pathF, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = medico.getNombre()+" , "+medico.getApellido()+" , "+medico.getCedula();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addConsulta(Medico medico, Paciente paciente) {
		try {
		Consulta consulta = new Consulta();
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		
		FileWriter file = new FileWriter(pathF, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = consulta.getMedico()+" , "+consulta.getPaciente();
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
	
	public boolean duplicadosPacientes(String nombre,String cedula){
		for(int i=0; i<pacientes.size();i++) {
			if(pacientes.get(i).getNombre().equals(nombre) && pacientes.get(i).getCedula().equals(cedula)){
				return true;
			}
		}
		return false;
	}
}
