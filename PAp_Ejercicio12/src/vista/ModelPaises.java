package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Pais;

public class ModelPaises extends AbstractTableModel {
	
	private Locale localizacion = VentanaGrafica.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	private List<Pais> datos;
	public String[] columnas = {lang.getString("Nombre"), lang.getString("Presidente"), "#" + lang.getString("Habitantes")};
	public Class[] columnasTipos = {String.class, String.class, String.class};
	
	public ModelPaises() {
		super();
		datos = new ArrayList<Pais>();
		Locale localizacion = VentanaGrafica.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	}
	
	public ModelPaises(List<Pais> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Pais>();
		else
			this.datos = datos;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}

	
	public int getRowCount() {
		return datos.size();
	}

	public String getColumnName(int col) {
		return columnas[col];
	}
	
	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}
	
	public Object getValueAt(int row, int col) {
		
		Pais dato = (Pais) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getPresidente();
		case 2:
			return dato.getnHabitantes();
		default:
			break;
		}
		return new String();
	}


}
