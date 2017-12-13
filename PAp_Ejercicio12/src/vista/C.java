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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.GestionC;

public class C extends JInternalFrame implements ActionListener {

	private GestionC gc;
	private JComboBox cbxEmpresa;
	private JComboBox cbxDepartamento;
	private JTable tblEmpleado;
	private JButton btnCargar;
	private JButton btnLimpiar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	
	public C(GestionC gd) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gc = gd;
		setSize(700, 300);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlC = new JPanel();
		pnlC.setLayout(new GridLayout(2,1));
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createTitledBorder(lang.getString("Empresa")));
		pnlDatos.setLayout(new GridLayout(3,1));
		pnlDatos.add(new JLabel(gc.listEmpresa().getNombre()));
		pnlDatos.add(new JLabel(lang.getString("Direccion") + ":" + gc.listEmpresa().getDireccion()));
		pnlDatos.add(new JLabel(lang.getString("RUC") + ":" + gc.listEmpresa().getRuc()));
		
		JPanel pnlOp = new JPanel();
		pnlOp.setBorder(BorderFactory.createEmptyBorder());
		pnlOp.setLayout(new GridLayout(3, 4));
		pnlOp.add(new JLabel(lang.getString("Empresa") + ": "));
		String[] empresas = gc.getEmpresa();
		cbxEmpresa = new JComboBox(empresas);
		pnlOp.add(cbxEmpresa);
		pnlOp.add(new JLabel(lang.getString("Departamento") + ": "));
		String[] departamentos = gc.getDepartamentos();
		cbxDepartamento = new JComboBox(departamentos);
		pnlOp.add(cbxDepartamento);
		pnlOp.add(new JLabel(lang.getString("Nombre") + ": "));
		txtNombre = new JTextField(20);
		pnlOp.add(txtNombre);
		pnlOp.add(new JLabel(lang.getString("Apellido") + ": "));
		txtApellido = new JTextField(20);
		pnlOp.add(txtApellido);
		pnlOp.add(new JLabel(lang.getString("Cedula") + ": "));
		txtCedula = new JTextField(20);
		pnlOp.add(txtCedula);
		pnlOp.add(new JLabel(lang.getString("Telefono") + ": "));
		txtTelefono = new JTextField(20);
		pnlOp.add(txtTelefono);
		
		tblEmpleado = new JTable();
		tblEmpleado.setModel(new ModelEmpleado());
		JScrollPane sEmpleado = new JScrollPane(tblEmpleado);
		
		pnlC.add(pnlOp);
		pnlC.add(sEmpleado);
		
		JPanel pnlButton = new JPanel();
		btnCargar = new JButton(lang.getString("Cargar"));
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand("Cargar");
		btnLimpiar = new JButton(lang.getString("Limpiar"));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setActionCommand("Limpiar");
		
		pnlButton.add(btnCargar);
		pnlButton.add(btnLimpiar);
		
		c.add(pnlDatos, BorderLayout.NORTH);
		c.add(pnlC, BorderLayout.CENTER);
		c.add(pnlButton, BorderLayout.SOUTH);
		
	}
	
	public void newEmpleado() {
		gc.addEmpleado(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtTelefono.getText(), cbxDepartamento.getSelectedItem().toString());
	}

	public void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Cargar":
			newEmpleado();
			tblEmpleado.setModel(new ModelEmpleado(gc.listEmpleados(cbxDepartamento.getSelectedItem().toString()), cbxDepartamento.getSelectedItem().toString()));
			break;
		case "Limpiar":
			limpiar();
			break;
		}
	}


}
