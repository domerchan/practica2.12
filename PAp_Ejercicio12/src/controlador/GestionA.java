package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Autor;
import modelo.Revista;

public class GestionA {
	
	private List<Articulo> articulos;
	private List<Autor> autores;
	private Revista revista;
	private String pathA = "archivos/A.txt";
	
	public GestionA() {
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();
		addRevista();

	}
	
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
