package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import controlador.GestionB;

public class B extends JInternalFrame implements ActionListener, ItemListener {

	private GestionB gb;
	private JComboBox cbxPais;
	private JComboBox cbxProvincia;
	private JComboBox cbxCanton;
	
	public B(GestionB gb) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gb = gb;
		setSize(750, 209);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlDatos = new JPanel();
		pnlDatos.setLayout(new GridLayout(1,3));
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Datos")));
		
		
		JPanel pnlSelec = new JPanel();
		pnlSelec.setBorder(BorderFactory.createEmptyBorder());
	//	String[] paises = gb.getPaises();
		//String[] provincias = gb.searchProvincias(cbxPais.getSelectedItem().toString());
		//String[] cantones = gb.searchCantones(cbxProvincia.getSelectedItem().toString());
		//cbxPais = new JComboBox(paises);
		

	}

	public void actionPerformed(ActionEvent e) {

	}

	public void itemStateChanged(ItemEvent e) {
		
	}
	
	/*
	 * ESPANOL
	 Provincia Provincia
	 
	 * INGLES
	 Provincia  Province
	 
	 * */

}
