package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Atleta;
import modelo.Competencia;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Resultado;

public class GestionD {
	
	private List<Competencia> competencias;
	private List<Atleta> atletas;
	private String pathD = "archivos/D.txt";
	
	public GestionD() {
		competencias = new ArrayList<Competencia>();
		atletas = new ArrayList<Atleta>();

	}
	
	public void addResultado(String tInicial, String tFinal) {
		try {
		Resultado resultado = new Resultado();
		resultado.settInicial(tInicial);
		resultado.settFinal(tFinal);
		
		FileWriter file = new FileWriter(pathD, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = resultado.gettInicial()+" , "+resultado.gettFinal();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addAtleta(String codigo, Resultado resultado,String nombre,String apellido,String cedula) {
		try {
		Atleta atleta = new Atleta();
		atleta.setNombre(nombre);
		atleta.setApellido(apellido);
		atleta.setCedula(cedula);
		atleta.setCodigo(codigo);
		atleta.setResultado(resultado);
		atletas.add(atleta);
		
		FileWriter file = new FileWriter(pathD, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = atleta.getNombre()+" , "+atleta.getApellido()+" , "+atleta.getCedula()+" , "+atleta.getCodigo()+" , "+atleta.getResultado();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void addCompetencia(String nombre, String categoria, Atleta atleta) {
		try {
		Competencia competencia = new Competencia();
		competencia.setNombre(nombre);
		competencia.setCategoria(categoria);
		competencia.setAtletas(atletas);
		competencias.add(competencia);
		
		FileWriter file = new FileWriter(pathD, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = competencia.getNombre()+" , "+competencia.getCategoria()+" , "+competencia.getAtletas();
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
}
