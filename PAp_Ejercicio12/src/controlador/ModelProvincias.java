package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Provincia;
import vista.VentanaGrafica;

public class ModelProvincias extends AbstractTableModel {

	private Locale localizacion = VentanaGrafica.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	private List<Provincia> datos;
	public String[] columnas = {lang.getString("Nombre"), "#" + lang.getString("Habitantes")};
	public Class[] columnasTipos = {String.class, String.class};
	
	public ModelProvincias() {
		super();
		datos = new ArrayList<Provincia>();
		Locale localizacion = VentanaGrafica.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	}
	
	public ModelProvincias(List<Provincia> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Provincia>();
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
		
		Provincia dato = (Provincia) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getnHabitantes();
		default:
			break;
		}
		return new String();
	}
}
