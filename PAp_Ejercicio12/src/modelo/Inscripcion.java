package modelo;

import java.util.List;

public class Inscripcion {

	private int nFicha;
	private int valor;
	private Equipo equipo;
	private List<Jugador> jugadores;
	
	public Inscripcion() {
		
	}

	public Inscripcion(int nFicha, int valor, Equipo equipo, List<Jugador> jugadores) {
		super();
		this.nFicha = nFicha;
		this.valor = valor;
		this.equipo = equipo;
		this.jugadores = jugadores;
	}

	public int getnFicha() {
		return nFicha;
	}

	public void setnFicha(int nFicha) {
		this.nFicha = nFicha;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
