package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Atleta;
import modelo.Autor;
import modelo.Canton;
import modelo.Competencia;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Equipo;
import modelo.Inscripcion;
import modelo.Jugador;
import modelo.Paciente;
import modelo.Pais;
import modelo.Persona;
import modelo.Provincia;
import modelo.Resultado;
import modelo.Revista;
import vista.A;
import vista.B;
import vista.C;
import vista.D;
import vista.E;
import vista.F;

public class GestionDatos {

	private List<Articulo> articulos;
	private List<Autor> autores;
	private List<Provincia> provincias;
	private List<Canton> cantones;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	private List<Competencia> competencias;
	private List<Paciente> pacientes;
	private String pathA = "archivos/A.txt";
	private String pathB = "archivos/B.txt";

	public GestionDatos() {
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();
		provincias = new ArrayList<Provincia>();
		cantones = new ArrayList<Canton>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
		equipos = new ArrayList<Equipo>();
		jugadores = new ArrayList<Jugador>();
		competencias = new ArrayList<Competencia>();
		pacientes = new ArrayList<Paciente>();

	}

	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal, Autor autor, Persona persona,
			String nombre, String apellido, String cedula, String nacionalidad, String pseudonimo) {
		try {
			Autor autor1 = new Autor();
			autor1.setNombre(nombre);
			autor1.setApellido(apellido);
			autor1.setCedula(cedula);
			autor1.setNacionalidad(nacionalidad);
			autor1.setPseudonimo(pseudonimo);
			autores.add(autor1);

			Articulo articulo = new Articulo();
			articulo.setAutor(autor1);
			articulo.setTitulo(titulo);
			articulo.setResumen(resumen);
			articulo.setpInicio(pInicio);
			articulo.setpFinal(pFinal);
			articulos.add(articulo);

			FileWriter file = new FileWriter(pathA, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = articulo.getTitulo() + " , " + articulo.getAutor() + " ; " + articulo.getResumen() + " , "
					+ articulo.getpInicio() + " ; " + articulo.getpFinal();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addRevista(String nombre, String nEdicion, String idioma, Articulo articulo) {
		try {
		Revista revista = new Revista();
		revista.setNombre(nombre);
		revista.setnEdicion(nEdicion);
		revista.setIdioma(idioma);
		revista.setArticulos(articulos);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = revista.getNombre()+" , "+revista.getnEdicion()+" , "+revista.getIdioma()+" , "+revista.getArticulos();
		out.append(registro + "\n");
		out.close();
		file.close();
		}catch (IOException evento){
			evento.printStackTrace();
		}
	}

	public void addCanton(String nHabitantes,String nombre, String ubicacionGPS) {
		try {
		Canton canton = new Canton();
		canton.setNombre(nombre);
		canton.setnHabitantes(nHabitantes);
		canton.setUbicacionGPS(ubicacionGPS);
		cantones.add(canton);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = canton.getNombre()+" , "+canton.getnHabitantes()+" , "+canton.getUbicacionGPS();
		out.append(registro + "\n");
		out.close();
		file.close();
		}catch (IOException evento){
			evento.printStackTrace();
		}
	}
	
	public void addProvincia(String nombre, String alcalde,String nHabitantes,Canton canton) {
		try {
			Provincia provincia = new Provincia();
			provincia.setNombre(nombre);
			provincia.setAlcalde(alcalde);
			provincia.setnHabitantes(nHabitantes);
			provincia.setCantones(cantones);
			provincias.add(provincia);

			FileWriter file = new FileWriter(pathA, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = provincia.getNombre()+" , "+provincia.getAlcalde()+" , "+provincia.getnHabitantes();
			out.append(registro + "\n");
			out.close();
			file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
		
	}

	public void addPais(String nombre, String presidente, String nHabitantes, Provincia provincia) {
		try {
		Pais pais = new Pais();
		pais.setNombre(nombre);
		pais.setPresidente(presidente);
		pais.setnHabitantes(nHabitantes);
		pais.setProvincias(provincias);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = pais.getNombre()+" , "+pais.getPresidente()+" , "+pais.getnHabitantes()+" , "+pais.getProvincias();
		out.append(registro + "\n");
		out.close();
		file.close();
		
		}catch (IOException evento) {
			
		}
	}

	public void addEmpleado(String telefono,String nombre,String apellido,String cedula,Persona persona) {
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCedula(cedula);
		empleado.setTelefono(telefono);
		empleados.add(empleado);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = empleado.getNombre()+" , "+empleado.getApellido()+" , "+empleado.getCedula()+" , "+empleado.getTelefono();
		out.append(registro + "\n");
		out.close();
		file.close();
		
	}
	
	public void addDepartamento(String nombre,String nDepartamento,String planta, Empleado empleado) {
		Departamento departamento = new Departamento();
		departamento.setNombre(nombre);
		departamento.setnDepartamento(nDepartamento);
		departamento.setPlanta(planta);
		departamento.setEmpleados(empleados);
		departamentos.add(departamento);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = departamento.getNombre()+" , "+departamento.getnDepartamento()+" , "+departamento.getPlanta()+" , "+departamento.getEmpleados();
		out.append(registro + "\n");
		out.close();
		file.close();
	}
	
	public void addEmpresa(String nombre, String ruc, String direccion, Departamento departamento) {
		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		empresa.setRuc(ruc);
		empresa.setDireccion(direccion);
		empresa.setDepartamentos(departamentos);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = empresa.getNombre()+" , "+empresa.getRuc()+" , "+empresa.getDireccion()+" , "+empresa.getDepartamentos();
		out.append(registro + "\n");
		out.close();
		file.close();
	}
	
	public void addResultado(String tInicial, String tFinal) {
		Resultado resultado = new Resultado();
		resultado.settInicial(tInicial);
		resultado.settFinal(tFinal);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = resultado.gettInicial()+" , "+resultado.gettFinal();
		out.append(registro + "\n");
		out.close();
		file.close();
	}
	
	public void addAtleta(String codigo, Resultado resultado,String nombre,String apellido,String cedula) {
		Atleta atleta = new Atleta();
		atleta.setNombre(nombre);
		atleta.setApellido(apellido);
		atleta.setCedula(cedula);
		atleta.setCodigo(codigo);
		atleta.setResultado(resultado);
		
		FileWriter file = new FileWriter(pathA, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = atleta.getNombre()+" , "+atleta.getApellido()+" , "+atleta.getCedula()+" , "+atleta.getCodigo()+" , "+atleta.getResultado();
		out.append(registro + "\n");
		out.close();
		file.close();
	}

	public void addCompetencia(String nombre, String categorias, Atleta atleta) {
		
	}
}



