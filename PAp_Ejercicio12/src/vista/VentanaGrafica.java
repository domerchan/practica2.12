package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.GestionDatos;

public class VentanaGrafica extends JFrame implements ActionListener {
	
	public static Locale localizacion;
	private JDesktopPane escritorio;
	private GestionDatos gd;
	private JMenu mnuVentanaPais, mnuVentanaEmpresa, mnuVentanaCompetencia, mnuIdiom, mnuFichInsc, mnuAutor, mnuMedico;
	private JMenuItem mnuVentanas,mnuVentana3, mnuVentana11, mnuVentanabus, mnuVentana22, mnudisponible, mnuSalir, idiomaen,
			idiomaes;

	public VentanaGrafica() {
		gd = new GestionDatos();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		localizacion = new Locale("es", "Es");
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
		setSize(800, 600);
		setTitle(lang.getString("Gestion Listas"));
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		mnuVentanas = new JMenu(lang.getString("Registros"));

		mnuVentana1 = new JMenuItem(lang.getString("Pais"));
		mnuVentana1.addActionListener(this);
		mnuVentana1.setActionCommand("mnuVentana1");
		mnuVentanas.add(mnuVentana1);
		
		mnuVentana3 = new JMenuItem(lang.getString("Empresa"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);
		
		mnuVentana3 = new JMenuItem(lang.getString("Competencia"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);
		
		mnuVentana3 = new JMenuItem(lang.getString("Equipos"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);
		
		mnuVentana3 = new JMenuItem(lang.getString("Revistas"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);
		
		mnuVentana3 = new JMenuItem(lang.getString("Consultas"));
		mnuVentana3.addActionListener(this);
		mnuVentana3.setActionCommand("mnuVentana3");
		mnuVentanas.add(mnuVentana3);

		mnuVentanas1 = new JMenu(lang.getString("Aspirante"));
		mnuVentana11 = new JMenuItem(lang.getString("ListadeAspirantes"));
		mnuVentana11.addActionListener(this);
		mnuVentana11.setActionCommand("mnuVentana2");
		mnuVentanas1.add(mnuVentana11);

		mnuVentanabus = new JMenuItem(lang.getString("BuscarAspirantes"));
		mnuVentanabus.addActionListener(this);
		mnuVentanabus.setActionCommand("mnuVentanabus");
		mnuVentanas1.add(mnuVentanabus);

		mnuVentanas2 = new JMenu(lang.getString("CarrerasUniversitarias"));
		mnuVentana22 = new JMenuItem(lang.getString("ListadeCarreras"));
		mnuVentana22.addActionListener(this);
		mnuVentana22.setActionCommand("mnuVentana22");
		mnuVentanas2.add(mnuVentana22);

		mnudisponible = new JMenuItem(lang.getString("BuscarCarreras"));
		mnudisponible.addActionListener(this);
		mnudisponible.setActionCommand("mnuVentanadisponible");
		mnuVentanas2.add(mnudisponible);

		mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuSalir.setActionCommand("mnuSalir");
		mnuVentanas.add(mnuSalir);

		idioma = new JMenu(lang.getString("Idiomas"));
		idiomaen = new JMenuItem("EN");
		idiomaen.addActionListener(this);
		idiomaen.setActionCommand("mnuEN");
		idioma.add(idiomaen);

		idiomaes = new JMenuItem("ES");
		idiomaes.addActionListener(this);
		idiomaes.setActionCommand("mnuES");
		idioma.add(idiomaes);

		barra.add(mnuVentanas);
		barra.add(mnuVentanas1);
		barra.add(mnuVentanas2);
		barra.add(idioma);

		// getContentPane().add(barra); error
		setJMenuBar(barra);

	}

	@Override

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//gd = new GestionDatos();
		String comando = event.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "mnuVentana1":
			llamarVentanaInscripcion();
			break;
		case "mnuVentana3":
			llamarVentanaUniversidad();
			break;
		case "mnuVentanabus":
			llamarBuscarAspirante();
			break;
		case "mnuVentana2":
			llamarListadoAspirantes();
			break;
		case "mnuVentana22":
			llamarListadoCarreras();
			break;
		case "mnuVentanadisponible":
			llamarBuscarCarrera();
			break;
		case "mnuSalir":
			salir();
			break;
		case "mnuEN":
			llamaridioma("en", "US");
			break;
		case "mnuES":
			llamaridioma("es", "EC");
			break;
		default:
			break;
		}

	}

	private void llamarBuscarCarrera() {
		// TODO Auto-generated method stub

	}

	private void llamaridioma(String lenguaje, String pais) {
		// TODO Auto-generated method stub
		localizacion = new Locale(lenguaje, pais);
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
		setTitle(lang.getString("SistemadeInscripcionUniversitaria"));
		mnuVentanas.setText(lang.getString("Inscripciones"));
		idioma.setText(lang.getString("Idiomas"));

		mnuVentana1.setText(lang.getString("NuevaInscripcion"));
		mnuVentana3.setText(lang.getString("NuevaUniversidad"));
		mnuVentanas1.setText(lang.getString("Aspirante"));
		mnuVentana11.setText(lang.getString("ListadeAspirantes"));
		mnuVentanabus.setText(lang.getString("BuscarAspirantes"));
		mnuVentanas2.setText(lang.getString("CarrerasUniversitarias"));
		mnuVentana22.setText(lang.getString("ListadeCarreras"));
		mnudisponible.setText(lang.getString("BuscarCarreras"));
		mnuSalir.setText(lang.getString("Salir"));

	}

	private void llamarBuscarAspirante() {
		// TODO Auto-generated method stub
		BuscarAspirante buscar = new BuscarAspirante();
		buscar.setVisible(true);
		escritorio.add(buscar);
		try {
			buscar.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void llamarListadoAspirantes() {
		// TODO Auto-generated method stub
		VentanaTablaAspirantes vta = new VentanaTablaAspirantes(gd);
		vta.setVisible(true);
		escritorio.add(vta);
		try {
			vta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void llamarVentanaInscripcion() {
		// TODO Auto-generated method stub
		VnVentanaInscripcion vins = new VnVentanaInscripcion(gd);
		vins.setVisible(true);
		escritorio.add(vins);
		try {
			vins.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void llamarVentanaUniversidad() {
		// TODO Auto-generated method stub
		VnVentanaUniversidad vuni = new VnVentanaUniversidad(gd);
		vuni.setVisible(true);
		escritorio.add(vuni);
		
		try {
			vuni.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void llamarListadoCarreras() {
		// TODO Auto-generated method stub
		TablaCarrera tc = new TablaCarrera(gd);
		tc.setVisible(true);
		escritorio.add(tc);
		try {
			tc.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void salir() {
		System.exit(0);
	}
	
	

}
