package modelo;

public class Revista {

	private String nombre;
	private String nEdicion;
	private String idioma;
	
	public Revista() {
		
	}
	
	public Revista(String nombre, String nEdicion, String idioma) {
		super();
		this.nombre = nombre;
		this.nEdicion = nEdicion;
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnEdicion() {
		return nEdicion;
	}

	public void setnEdicion(String nEdicion) {
		this.nEdicion = nEdicion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
