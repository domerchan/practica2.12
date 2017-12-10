package controlador;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Autor;
import modelo.Canton;
import modelo.Competencia;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Equipo;
import modelo.Inscripcion;
import modelo.Jugador;
import modelo.Paciente;
import modelo.Persona;
import modelo.Provincia;
import vista.A;
import vista.B;
import vista.C;
import vista.D;
import vista.E;
import vista.F;

public class GestionDatos {
	
	
	private List<Articulo> articulos;
	private List<Provincia> provincias;
	private List<Canton> cantones;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	private List<Competencia> competencias;
	private List<Paciente> pacientes;
	
	public GestionDatos() {
		articulos = new ArrayList<Articulo>();
		provincias = new ArrayList<Provincia>();	
		cantones = new ArrayList<Canton>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();	
		equipos = new ArrayList<Equipo>();
		jugadores = new ArrayList<Jugador>();
		competencias = new ArrayList<Competencia>();	
		pacientes = new ArrayList<Paciente>();

	}
	
	public void addArticulo(String titulo, String resumen, String pInicio, String pFinal, Autor autor,Persona persona, String nombre, String apellido, String cedula, String nacionalidad, String seudonimo) {
			Autor autor1 = new Autor(); 
			autor1.setNombre(nombre);
			autor1.setApellido(apellido);
			autor1.setCedula(cedula);
			autor1.setNacionalidad(nacionalidad);
			autor1.setSeudonimo(seudonimo);
			
			Articulo articulo = new Articulo();
			articulo.setAutor(autor1);
			articulo.setTitulo(titulo);
			articulo.setResumen(resumen);
			articulo.setpInicio(pInicio);
			articulo.setpFinal(pFinal);
			articulos.add(articulo);
		}
	
	
	
}
