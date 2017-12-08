package modelo;

public class Competencia {

	private String nombre;
	private String categoria;
	private String nParticipantes;
	
	public Competencia() {
		
	}

	public Competencia(String nombre, String categoria, String nParticipantes) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.nParticipantes = nParticipantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getnParticipantes() {
		return nParticipantes;
	}

	public void setnParticipantes(String nParticipantes) {
		this.nParticipantes = nParticipantes;
	}
	
}
