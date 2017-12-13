package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Canton;
import vista.VentanaGrafica;

public class ModelCantones extends AbstractTableModel {

	private Locale localizacion = VentanaGrafica.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
	private List<Canton> datos; 
	public String[] columnas = {lang.getString("Nombre"), lang.getString("Ubicacion"), "#" + lang.getString("Habitantes")};
	public Class[] columnasTipos = {String.class, String.class, String.class};
	
	public ModelCantones() {
		super();
		datos = new ArrayList<Canton>();
		Locale localizacion = VentanaGrafica.localizacion;
		lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
	}
	
	public ModelCantones(List<Canton> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Canton>();
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
		
		Canton dato = (Canton) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getUbicacionGPS();
		case 2:
			return dato.getnHabitantes();
		default:
			break;
		}
		return new String();
	}
}
