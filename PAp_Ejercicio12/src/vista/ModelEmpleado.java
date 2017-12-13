package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.Empleado;

public class ModelEmpleado extends AbstractTableModel {

	private Locale localizacion = VentanaGrafica.localizacion;
	private ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	private List<Empleado> datos;
	private String departamento;
	public String[] columnas = {lang.getString("Departamento"), lang.getString("Nombre"), lang.getString("Apellido"), lang.getString("Cedula")};
	public Class[] columnasTipos = {String.class, String.class, String.class, String.class};
	
	public ModelEmpleado() {
		super();
		datos = new ArrayList<Empleado>();
		Locale localizacion = VentanaGrafica.localizacion;
		lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
	}
	
	public ModelEmpleado(List<Empleado> datos, String departamento) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Empleado>();
		else
			this.datos = datos;
		this.departamento = departamento;
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
		
		Empleado dato = (Empleado) (datos.get(row));
		
		switch(col) {
		case 0:
			return departamento;
		case 1:
			return dato.getNombre();
		case 2:
			return dato.getApellido();
		case 3:
			return dato.getCedula();
		default:
			break;
		}
		return new String();
	}
}
