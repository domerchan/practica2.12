package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionDatos;

public class A extends JInternalFrame implements ActionListener {

	private GestionDatos gd;
	private JTextField txtTitulo;
	private JTextArea txtResumen;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtPseudo;
	private JTextField txtNacionalidad;

	public A(GestionDatos gd) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mesajes", localizacion);

		this.gd = gd;
		setSize(750, 209);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Datos")));
		pnlDatos.setLayout(new GridLayout(2, 1));

		JPanel pnlArticulo = new JPanel();
		pnlArticulo.setLayout(new GridLayout(4, 2));
		pnlArticulo.add(new JLabel(lang.getString("Titulo")));
		txtTitulo = new JTextField(20);
		pnlArticulo.add(txtTitulo);
		pnlArticulo.add(new JLabel(lang.getString("Resumen")));
		txtResumen = new JTextArea(10,20); 
		pnlArticulo.add(txtResumen);
		pnlArticulo.add(new JLabel(lang.getString("Inicio")));
		txtInicio = new JTextField(20);
		pnlArticulo.add(txtInicio);
		pnlArticulo.add(new JLabel(lang.getString("Final")));
		txtFinal = new JTextField(20); 
		pnlArticulo.add(txtFinal);
		
		JPanel pnlAutor = new JPanel();
		pnlAutor.setBorder(BorderFactory.createTitledBorder(lang.getString("Autor")));
		pnlAutor.setLayout(new GridLayout(3,4));
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	/*
	 * ESPAÑOL 
	 Datos Datos 
	 Titulo Título: 
	 Resumen Resumen: 
	 Inicio Página Inicial: 
	 Final Página Final: 
	 Autor Autor
	  
	 * INGLES 
	 Datos Data 
	 Titulo Title: 
	 Resumen Summary: 
	 Inicio Initial Page: 
	 Final Final Page: 
	 Autor Author
	 
	 */
}
