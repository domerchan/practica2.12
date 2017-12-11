package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Canton;
import modelo.Pais;
import modelo.Provincia;

public class GestionB {

	private List<Pais> paises;
	private List<Provincia> provincias;
	private List<Canton> cantones;
	private String pathB = "archivos/B.txt";
	
	public GestionB() {
		paises = new ArrayList<Pais>();
		provincias = new ArrayList<Provincia>();
		cantones = new ArrayList<Canton>();
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

}
