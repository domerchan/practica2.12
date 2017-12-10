package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionDatos;
import modelo.Revista;

public class A extends JInternalFrame implements ActionListener {

	private GestionDatos gd;
	private JTextField txtTitulo;
	private JTextArea txtResumen;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtSeudonimo;
	private JTextField txtNacionalidad;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JTable tblArticulo;

	public A(GestionDatos gd) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mesajes", localizacion);

		this.gd = gd;
		setSize(750, 209);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlA = new JPanel();
		pnlA.setLayout(new GridLayout(2,1));
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Datos")));
		pnlDatos.setLayout(new GridLayout(2, 1));

		JPanel pnlArticulo = new JPanel();
		pnlArticulo.setLayout(new GridLayout(4, 2));
		pnlArticulo.add(new JLabel(lang.getString("Titulo:")));
		txtTitulo = new JTextField(20);
		pnlArticulo.add(txtTitulo);
		pnlArticulo.add(new JLabel(lang.getString("Resumen:")));
		txtResumen = new JTextArea(10,20); 
		pnlArticulo.add(txtResumen);
		pnlArticulo.add(new JLabel(lang.getString("Inicio:")));
		txtInicio = new JTextField(20);
		pnlArticulo.add(txtInicio);
		pnlArticulo.add(new JLabel(lang.getString("Final:")));
		txtFinal = new JTextField(20); 
		pnlArticulo.add(txtFinal);
		
		JPanel pnlAutor = new JPanel();
		pnlAutor.setBorder(BorderFactory.createTitledBorder(lang.getString("Autor:")));
		pnlAutor.setLayout(new GridLayout(3,4));
		pnlAutor.add(new JLabel(lang.getString("Nombre:")));
		txtNombre = new JTextField(20);
		pnlAutor.add(txtNombre);
		pnlAutor.add(new JLabel(lang.getString("Apellido:")));
		txtApellido = new JTextField(20);
		pnlAutor.add(txtApellido);
		pnlAutor.add(new JLabel(lang.getString("Cedula:")));
		txtCedula = new JTextField(20);
		pnlAutor.add(txtCedula);
		pnlAutor.add(new JLabel(lang.getString("Seudonimo:")));
		txtSeudonimo = new JTextField(20);
		pnlAutor.add(txtSeudonimo);
		pnlAutor.add(new JLabel(lang.getString("Nacionalidad:")));
		txtNacionalidad = new JTextField(20);
		pnlAutor.add(txtNacionalidad);
		btnGuardar = new JButton(lang.getString("Guardar"));
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		pnlAutor.add(btnGuardar);
		btnLimpiar = new JButton(lang.getString("Limpiar"));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand("Limpiar");
		pnlAutor.add(btnLimpiar);
		
		pnlDatos.add(pnlArticulo);
		pnlDatos.add(pnlAutor);
		
		tblArticulo = new JTable();
		tblArticulo.setModel(new ModelArticulo());
		JScrollPane scpArticulo = new JScrollPane(tblArticulo);
		
		pnlA.add(pnlDatos);
		pnlA.add(tblArticulo);
		
		JPanel pnlRevista = new JPanel();
		pnlRevista.setLayout(new GridLayout(2,1));
		pnlRevista.add(new JLabel(gd.getRevista().getNombre()));
		pnlRevista.add(new JLabel(lang.getString("Edicion:") + gd.getRevista().getnEdicion()));
		
		c.add(pnlRevista, BorderLayout.NORTH);
		c.add(pnlA, BorderLayout.CENTER);

	}

	public void newArticulo() {
		gd.addArticulo(txtTitulo.getText(), txtResumen.getText(), txtInicio.getText(), txtFinal.getText(), txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtNacionalidad.getText(), txtSeudonimo.getText());
	}
	
	public void actionPerformed(ActionEvent arg0) {

	}

	/*
	 * ESPAÑOL 
	 Datos Datos 
	 Titulo: Título: 
	 Resumen: Resumen: 
	 Inicio: Página Inicial: 
	 Final: Página Final: 
	 Autor Autor
	 Nombre: Nombre: 
	 Apellido: Apellido: 
	 Cedula: Cédula: 
	 Nacionalidad: Nacionalidad: 
	 Guardar Guardar
	 Edicion: Edición: 
	 Limpiar Limpiar
	  
	 * INGLES 
	 Datos Data 
	 Titulo: Title: 
	 Resumen: Summary: 
	 Inicio: Initial Page: 
	 Final: Final Page: 
	 Autor Author
	 Nombre: Name: 
	 Apellido: Last Name: 
	 Cedula: ID: 
	 Nacionalidad: Nationality: 
	 Guardar Save
	 Edicion: Edition: 
	 Limpiar Clean
	 
	 */
}
