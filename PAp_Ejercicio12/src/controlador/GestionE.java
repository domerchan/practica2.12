package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Inscripcion;
import modelo.Jugador;

public class GestionE {
	
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	private String pathE = "archivos/E.txt";
	
	public GestionE() {
		equipos = new ArrayList<Equipo>();
		jugadores = new ArrayList<Jugador>();
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
	
	public boolean duplicadosJugadores(String nombre,String cedula){
		for(int i=0; i<jugadores.size();i++) {
			if(jugadores.get(i).getNombre().equals(nombre) && jugadores.get(i).getCedula().equals(cedula)){
				return true;
			}
		}
		return false;
	}
	
	public boolean duplicadosEquipos(String nombre,String codigo){
		for(int i=0; i<equipos.size();i++) {
			if(equipos.get(i).getNombre().equals(nombre) && equipos.get(i).getCodigo().equals(codigo)){
				return true;
			}
		}
		return false;
	}
}
