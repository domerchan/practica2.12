package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import controlador.GestionDatos;

public class F extends JInternalFrame implements ActionListener {

	private GestionDatos gd;
	
	public F(GestionDatos gd) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mesajes", localizacion);

		this.gd = gd;
		setSize(750, 209);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Datos")));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
