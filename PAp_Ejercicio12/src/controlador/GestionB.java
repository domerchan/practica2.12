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
	private List<Provincia> provinciasE;
	private List<Canton> cantonesP;
	private List<Canton> cantonesG;
	private List<Canton> cantonesA;
	private String pathB = "src/archivos/B.txt";

	public GestionB() {
		paises = new ArrayList<Pais>();
		provinciasE = new ArrayList<Provincia>();
		cantonesP = new ArrayList<Canton>();

	}

	public void addPais() {
		try {
			Pais pais = new Pais();
			pais.setNombre("Ecuador");
			pais.setPresidente("Lenín Moreno");
			pais.setnHabitantes("2164563515163");
			pais.setProvincias(provinciasE);
			paises.add(pais);

			FileWriter file = new FileWriter(pathB, true);
			BufferedWriter out = new BufferedWriter(file);
			String registro = pais.getNombre() + " , " + pais.getPresidente() + " , " + pais.getnHabitantes() + " , "
					+ pais.getProvincias();
			out.append(registro + "\n");
			out.close();
			file.close();

		} catch (IOException evento) {

		}

	}

	public void saveProvincia(Provincia provincia) throws IOException {
		FileWriter file = new FileWriter(pathB, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = provincia.getNombre() + " , " + provincia.getnHabitantes();
		out.append(registro + "\n");
		out.close();
		file.close();
	}

	public void addProvincia() {
		try {
			Provincia provincia = new Provincia();
			provincia.setNombre("Pichincha");
			provincia.setnHabitantes("354664654");
			provincia.setCantones(cantonesP);
			provinciasE.add(provincia);

			saveProvincia(provincia);

			provincia = new Provincia();
			provincia.setNombre("Guayas");
			provincia.setnHabitantes("3515656145");
			provincia.setCantones(cantonesG);
			provinciasE.add(provincia);

			provincia = new Provincia();
			provincia.setNombre("Azuay");
			provincia.setnHabitantes("665132156");
			provincia.setCantones(cantonesA);
			provinciasE.add(provincia);

			saveProvincia(provincia);

			saveProvincia(provincia);

		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public void saveCanton(Canton canton) throws IOException {
		FileWriter file = new FileWriter(pathB, true);
		BufferedWriter out = new BufferedWriter(file);
		String registro = canton.getNombre() + " , " + canton.getnHabitantes() + " , " + canton.getUbicacionGPS();
		out.append(registro + "\n");
		out.close();
		file.close();
	}

	public void addCanton() {
		try {
			Canton canton = new Canton();
			canton.setNombre("Quito");
			canton.setnHabitantes("541651654");
			canton.setUbicacionGPS("122542 012634");
			cantonesP.add(canton);

			saveCanton(canton);

			canton = new Canton();
			canton.setNombre("Cayambe");
			canton.setnHabitantes("41651654");
			canton.setUbicacionGPS("112542 022634");
			cantonesP.add(canton);

			saveCanton(canton);

			canton = new Canton();
			canton.setNombre("Guayaquil");
			canton.setnHabitantes("3514654545");
			canton.setUbicacionGPS("132542 012634");
			cantonesG.add(canton);

			saveCanton(canton);

			canton = new Canton();
			canton.setNombre("Daule");
			canton.setnHabitantes("41651654");
			canton.setUbicacionGPS("112542 022634");
			cantonesG.add(canton);

			saveCanton(canton);

			canton = new Canton();
			canton.setNombre("Cuenca");
			canton.setnHabitantes("541651654");
			canton.setUbicacionGPS("122542 012634");
			cantonesA.add(canton);

			saveCanton(canton);

			canton = new Canton();
			canton.setNombre("Gualaceo");
			canton.setnHabitantes("41651654");
			canton.setUbicacionGPS("112542 022634");
			cantonesA.add(canton);

			saveCanton(canton);

		} catch (IOException evento) {
			evento.printStackTrace();
		}
	}

	public boolean duplicadosProvincias(String nombre) {
		for (int i = 0; i < provinciasE.size(); i++) {
			if (provinciasE.get(i).getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	public Provincia getProvincia(String nombre) {
		for (int i = 0; i < provinciasE.size(); i++) {
			Provincia prov = provinciasE.get(i);
			if (prov.getNombre().equals(nombre)) {
				return prov;
			}
		}
		return null;
	}

	public String[] getProvincias(String pais) {
		String[] lista;
		if (paises.get(0).getNombre().equals(pais)) {
			lista = new String[provinciasE.size()];
			for (int i = 0; i < provinciasE.size(); i++) {
				lista[i] = provinciasE.get(i).getNombre();
			}
			return lista;
		}
		return null;
	}

	public List<Pais> listPa(String nombre) {
		if (paises.get(0).getNombre().equals(nombre))
			return paises;
		return null;
	}

	public List<Provincia> listP(String pais) {
		if (paises.get(0).getNombre().equals(pais))
			return provinciasE;
		return null;
	}

	public List<Canton> listC(String provincia) {
		if (provinciasE.get(0).getNombre().equals(provincia))
			return cantonesP;
		else if (provinciasE.get(1).getNombre().equals(provincia))
			return cantonesG;
		else if (provinciasE.get(2).getNombre().equals(provincia))
			return cantonesA;
		return null;
	}

	public String[] getCantones(String provincia) {
		String[] lista;
		if (provinciasE.get(0).getNombre().equals(provincia)) {
			lista = new String[cantonesP.size()];
			for (int i = 0; i < cantonesP.size(); i++) {
				lista[i] = cantonesP.get(i).getNombre();
			}
			return lista;
		} else if (provinciasE.get(1).getNombre().equals(provincia)) {
			lista = new String[cantonesG.size()];
			for (int i = 0; i < cantonesG.size(); i++) {
				lista[i] = cantonesG.get(i).getNombre();
			}
			return lista;
		} else if (provinciasE.get(2).getNombre().equals(provincia)) {
			lista = new String[cantonesA.size()];
			for (int i = 0; i < cantonesA.size(); i++) {
				lista[i] = cantonesA.get(i).getNombre();
			}
			return lista;
		}
		return null;
	}

	public String[] getPaises() {
		String[] lista = new String[paises.size()];
		for (int i = 0; i < paises.size(); i++) {
			lista[i] = paises.get(i).getNombre();
		}
		return lista;
	}

	public boolean duplicadosCantones(String nombre) {
		for (int i = 0; i < cantonesP.size(); i++) {
			if (cantonesP.get(i).getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

}
