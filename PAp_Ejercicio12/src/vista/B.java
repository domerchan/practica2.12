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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionB;

public class B extends JInternalFrame implements ActionListener, ItemListener {

	private GestionB gb;
	private JComboBox cbxPais;
	private JComboBox cbxProvincia;
	private JComboBox cbxCanton;
	private JTextField txtTitulo;
	private JTextArea txtResumen;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTextField txtNombre;
	private JTextField txtnHabitantes;
	private JTextField txtPresidente;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JTable tblArticulo;
	
	public B(GestionB gb) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gb = gb;
		setSize(750, 209);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Datos")));
		pnlDatos.setLayout(new GridLayout(1,3));
		
		
		JPanel pnlPais = new JPanel();
		pnlPais.setBorder(BorderFactory.createTitledBorder(lang.getString("Autor:")));
		pnlPais.setLayout(new GridLayout(3,4));
		pnlPais.add(new JLabel(lang.getString("Nombre:")));
		txtNombre = new JTextField(20);
		pnlPais.add(txtNombre);
		pnlPais.add(new JLabel(lang.getString("Apellido:")));
		txtPresidente = new JTextField(20);
		pnlPais.add(txtPresidente);
		pnlPais.add(new JLabel(lang.getString("Cedula:")));
		txtnHabitantes = new JTextField(20);
		pnlPais.add(txtnHabitantes);
		btnGuardar = new JButton(lang.getString("Guardar"));
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		pnlPais.add(btnGuardar);
		btnLimpiar = new JButton(lang.getString("Limpiar"));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand("Limpiar");
		pnlPais.add(btnLimpiar);
		
		JPanel pnlProvincia = new JPanel();
		pnlProvincia.setLayout(new GridLayout(4,2));
		pnlProvincia.setBorder(BorderFactory.createEmptyBorder());
		txtTitulo = new JTextField(20);
		pnlProvincia.add(txtTitulo);
		pnlProvincia.add(new JLabel(lang.getString("Resumen:")));
		txtResumen = new JTextArea(10,20); 
		pnlProvincia.add(txtResumen);
		pnlProvincia.add(new JLabel(lang.getString("Inicio:")));
		txtInicio = new JTextField(20);
		pnlProvincia.add(txtInicio);
		pnlProvincia.add(new JLabel(lang.getString("Final:")));
		txtFinal = new JTextField(20); 
		pnlProvincia.add(txtFinal);
		
		JPanel pnlCanton = new JPanel();
		pnlCanton.setLayout(new GridLayout(4,2));
		pnlCanton.setBorder(BorderFactory.createEmptyBorder());
		txtTitulo = new JTextField(20);
		pnlCanton.add(txtTitulo);
		pnlCanton.add(new JLabel(lang.getString("Resumen:")));
		txtResumen = new JTextArea(10,20); 
		pnlCanton.add(txtResumen);
		pnlCanton.add(new JLabel(lang.getString("Inicio:")));
		txtInicio = new JTextField(20);
		pnlCanton.add(txtInicio);
		pnlCanton.add(new JLabel(lang.getString("Final:")));
		txtFinal = new JTextField(20); 
		pnlCanton.add(txtFinal);
		
		
		

		
	//	String[] paises = gb.getPaies();
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
