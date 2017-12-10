package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Atleta;
import modelo.Autor;
import modelo.Canton;
import modelo.Competencia;
import modelo.Consulta;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Equipo;
import modelo.Inscripcion;
import modelo.Jugador;
import modelo.Medico;
import modelo.Paciente;
import modelo.Pais;
import modelo.Persona;
import modelo.Provincia;
import modelo.Resultado;
import modelo.Revista;
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
	private List<Atleta> atletas;
	private List<Paciente> pacientes;
	private Revista revista;
	private String pathA = "archivos/A.txt";
	private String pathB = "archivos/B.txt";
	private String pathC = "archivos/C.txt";
	private String pathD = "archivos/D.txt";
	private String pathE = "archivos/E.txt";
	private String pathF = "archivos/F.txt";

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
		atletas = new ArrayList<Atleta>();
		pacientes = new ArrayList<Paciente>();
		
		addRevista();

	}
/*<<<<<<< HEAD
	
	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal, Autor autor,Persona persona, String nombre, String apellido, String cedula, String nacionalidad, String seudonimo) {
			Autor autor1 = new Autor(); 
=======*/

	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal, Autor autor,
			String nombre, String apellido, String cedula, String nacionalidad, String seudonimo) {
		try {
			Autor autor1 = new Autor();
//>>>>>>> branch 'master' of https://github.com/domerchan/practica2.12.git
			autor1.setNombre(nombre);
			autor1.setApellido(apellido);
			autor1.setCedula(cedula);
			autor1.setNacionalidad(nacionalidad);
/*<<<<<<< HEAD
			autor1.setSeudonimo(seudonimo);
			
=======*/
			autor1.setSeudonimo(seudonimo);
			autores.add(autor1);

//>>>>>>> branch 'master' of https://github.com/domerchan/practica2.12.git
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
	
	public void addRevista() {
		try {
		revista = new Revista();
		revista.setNombre("Nature");
		revista.setnEdicion("204");
		revista.setIdioma("Inglés");
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
	
	public Revista getRevista() {
		return revista;
	}

	public void addCanton(String nHabitantes,String nombre, String ubicacionGPS) {
		try {
		Canton canton = new Canton();
		canton.setNombre(nombre);
		canton.setnHabitantes(nHabitantes);
		canton.setUbicacionGPS(ubicacionGPS);
		cantones.add(canton);
		
		FileWriter file = new FileWriter(pathB, true);
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

			FileWriter file = new FileWriter(pathB, true);
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
		
		FileWriter file = new FileWriter(pathB, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = pais.getNombre()+" , "+pais.getPresidente()+" , "+pais.getnHabitantes()+" , "+pais.getProvincias();
		out.append(registro + "\n");
		out.close();
		file.close();
		
		}catch (IOException evento) {
			
		}
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

	public void addJugador(String nombre, String apellido, String cedula) {
		try {
		Jugador jugador = new Jugador();
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setCedula(cedula);
		jugadores.add(jugador);
		
		FileWriter file = new FileWriter(pathE, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = jugador.getNombre()+" , "+jugador.getApellido()+" , "+jugador.getCedula();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addEquipo(String nombre, String codigo) {
		try {
		Equipo equipo = new Equipo();
		equipo.setNombre(nombre);
		equipo.setCodigo(codigo);
		equipos.add(equipo);
		
		FileWriter file = new FileWriter(pathE, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = equipo.getNombre()+" , "+equipo.getCodigo();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}
	
	public void addInscripcion(int nFicha, int valor, Equipo equipo, Jugador jugador) {
		try {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setnFicha(nFicha);
		inscripcion.setValor(valor);
		inscripcion.setEquipos(equipos);
		inscripcion.setJugadores(jugadores);
		
		FileWriter file = new FileWriter(pathE, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = inscripcion.getnFicha()+" , "+inscripcion.getValor()+" , "+inscripcion.getEquipos()+" , "+inscripcion.getJugadores();
		out.append(registro + "\n");
		out.close();
		file.close();
		} catch (IOException evento) {
			evento.printStackTrace();
		}
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

}



