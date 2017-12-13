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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionB;
import controlador.ModelCantones;
import controlador.ModelPaises;
import controlador.ModelProvincias;

public class B extends JInternalFrame implements ActionListener, ItemListener {

	private GestionB gb;
	private JComboBox cbxPais;
	private JComboBox cbxProvincia;
	private JComboBox cbxCanton;
	private JTable tblPais;
	private JTable tblProvincia;
	private JTable tblCanton;
	private JButton btnCargar;

	public B(GestionB gb) {

		Locale localizacion = VentanaGrafica.localizacion;
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);

		this.gb = gb;
		setSize(750, 509);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pnlDatos = new JPanel();
		pnlDatos.setBorder(BorderFactory.createEmptyBorder());
		pnlDatos.setLayout(new GridLayout(3, 1));

		JPanel pnlOp = new JPanel();
		pnlOp.setBorder(BorderFactory.createEmptyBorder());
		pnlOp.setLayout(new GridLayout(2, 3));
		pnlOp.add(new JLabel(lang.getString("Pais") + ": "));
		pnlOp.add(new JLabel(lang.getString("Provincia") + ": "));
		pnlOp.add(new JLabel(lang.getString("Canton") + ": "));
		String[] paises = gb.getPaises();
		cbxPais = new JComboBox(paises);
		cbxPais.addItemListener(this);
		String[] provincias = gb.getProvincias((String) cbxPais.getSelectedItem());
		cbxProvincia = new JComboBox(provincias);
		cbxProvincia.addItemListener(this);
		String[] cantones = gb.getCantones(cbxProvincia.getSelectedItem().toString());
		cbxCanton = new JComboBox(cantones);
		
		pnlOp.add(cbxPais);
		pnlOp.add(cbxProvincia);
		pnlOp.add(cbxCanton);

		tblPais = new JTable();
		tblPais.setModel(new ModelPaises());
		JScrollPane sPais = new JScrollPane(tblPais);

		tblProvincia = new JTable();
		tblProvincia.setModel(new ModelProvincias());
		JScrollPane sProvincia = new JScrollPane(tblProvincia);

		tblCanton = new JTable();
		tblCanton.setModel(new ModelCantones());
		JScrollPane sCanton = new JScrollPane(tblCanton);

		pnlDatos.add(sCanton);
		pnlDatos.add(sProvincia);
		pnlDatos.add(sPais);

		JPanel pnlButton = new JPanel();
		btnCargar = new JButton(lang.getString("Cargar"));
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand("btnCargar");
		pnlButton.add(btnCargar);

		c.add(pnlOp, BorderLayout.NORTH);
		c.add(pnlDatos, BorderLayout.CENTER);
		c.add(pnlButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		switch (command) {
		case "btnCargar":
			tblPais.setModel(new ModelPaises(gb.listPa(cbxPais.getSelectedItem().toString())));
			tblProvincia.setModel(new ModelProvincias(gb.listP(cbxPais.getSelectedItem().toString())));
			tblCanton.setModel(new ModelCantones(gb.listC(cbxProvincia.getSelectedItem().toString())));
		}
	}

	public void itemStateChanged(ItemEvent e) {

	/*	if (cbxPais.getSelectedItem().equals("Ecuador")) {
			cbxProvincia.removeAllItems();
			cbxProvincia.addItem("Pichincha");
			cbxProvincia.addItem("Guayas");
			cbxProvincia.addItem("Azuay");
		}
*/
		if (cbxProvincia.getSelectedItem().equals("Pichincha")) {
			cbxCanton.removeAllItems();
			cbxCanton.addItem("Quito");
			cbxCanton.addItem("Cayambe");
		} else if (cbxProvincia.getSelectedItem().equals("Guayas")) {
			cbxCanton.removeAllItems();
			cbxCanton.addItem("Guayaquil");
			cbxCanton.addItem("Daule");
		} else if (cbxProvincia.getSelectedItem().equals("Azuay")) {
			cbxCanton.removeAllItems();
			cbxCanton.addItem("Cuenca");
			cbxCanton.addItem("Gualaceo");
		} 
	}

}
