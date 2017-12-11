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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionA;
import modelo.Revista;

public class A extends JInternalFrame implements ActionListener {

	private GestionA ga;
	private JTextField txtTitulo;
	private JTextArea txtResumen;
	private JTextField txtInicio;
	private JTextField txtFinal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtSeudonimo;
	private JTextField txtNacionalidad;
	private JTextField txtAutor;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JComboBox cbxAutor;
	private JComboBox cbxArticulo;
	private JTable tblArticulo;

	public A(GestionA ga) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.ga = ga;
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
		pnlRevista.add(new JLabel(ga.getRevista().getNombre()));
		pnlRevista.add(new JLabel(lang.getString("Edicion:") + ga.getRevista().getnEdicion()));
		
		c.add(pnlRevista, BorderLayout.NORTH);
		c.add(pnlA, BorderLayout.CENTER);

	}

	public void newArticulo() {
		ga.addArticulo(txtTitulo.getText(), txtResumen.getText(), txtInicio.getText(), txtFinal.getText(), txtApellido.getText(), txtNombre.getText(), txtCedula.getText(), txtNacionalidad.getText(), txtSeudonimo.getText(), txtAutor.getText());
	}
	
	private void limpiar() {
		txtTitulo.setText("");
		txtResumen.setText("");
		txtInicio.setText("");
		txtFinal.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtCedula.setText("");
		txtSeudonimo.setText("");
		txtNacionalidad.setText("");
	}
	
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		switch (command) {
		case "Guardar":
			newArticulo();
			break;
		case "Limpiar":
			limpiar();
			break;
		}
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
