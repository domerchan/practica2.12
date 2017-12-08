package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JInternalFrame;

import controlador.GestionDatos;

public class A extends JInternalFrame implements ActionListener {

	private GestionDatos gd;
	
	public A(GestionDatos gd) {
		
		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mesajes", localizacion);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	
}
