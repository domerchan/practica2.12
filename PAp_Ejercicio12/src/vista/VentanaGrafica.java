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
	private JMenu mnuVentanaRegistro, mnuVentanaTablas, idioma;
	private JMenuItem mnuVentanpais, mnuVentanaEmpresa, mnuVentanaCompetencia, mnuIdiom, mnuVentanaEquipos, mnuVentanaRevista, mnuVentanaConsulta, mnuSalir, idiomaen,
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

		mnuVentanaRegistro = new JMenu(lang.getString("Registros"));

		JMenuItem mnuVentanapais = new JMenuItem(lang.getString("B"));
		mnuVentanapais.addActionListener(this);
		mnuVentanapais.setActionCommand("mnuVentanaB");
		mnuVentanaRegistro.add(mnuVentanapais);
		
		mnuVentanaEmpresa = new JMenuItem(lang.getString("C"));
		mnuVentanaEmpresa.addActionListener(this);
		mnuVentanaEmpresa.setActionCommand("mnuVentanaC");
		mnuVentanaRegistro.add(mnuVentanaEmpresa);
		
		mnuVentanaCompetencia = new JMenuItem(lang.getString("D"));
		mnuVentanaCompetencia.addActionListener(this);
		mnuVentanaCompetencia.setActionCommand("mnuVentanaD");
		mnuVentanaRegistro.add(mnuVentanaCompetencia);
		
		mnuVentanaEquipos = new JMenuItem(lang.getString("E"));
		mnuVentanaEquipos.addActionListener(this);
		mnuVentanaEquipos.setActionCommand("mnuVentanaE");
		mnuVentanaRegistro.add(mnuVentanaEquipos);
		
		mnuVentanaRevista = new JMenuItem(lang.getString("A"));
		mnuVentanaRevista.addActionListener(this);
		mnuVentanaRevista.setActionCommand("mnuVentanaA");
		mnuVentanaRegistro.add(mnuVentanaRevista);
		
		mnuVentanaConsulta = new JMenuItem(lang.getString("F"));
		mnuVentanaConsulta.addActionListener(this);
		mnuVentanaConsulta.setActionCommand("mnuVentanaF");
		mnuVentanaRegistro.add(mnuVentanaConsulta);

		mnuSalir = new JMenuItem("Salir");
		mnuSalir.addActionListener(this);
		mnuSalir.setActionCommand("mnuSalir");
		mnuVentanaRegistro.add(mnuSalir);

		idioma = new JMenu(lang.getString("Idiomas"));
		idiomaen = new JMenuItem("EN");
		idiomaen.addActionListener(this);
		idiomaen.setActionCommand("mnuEN");
		idioma.add(idiomaen);

		idiomaes = new JMenuItem("ES");
		idiomaes.addActionListener(this);
		idiomaes.setActionCommand("mnuES");
		idioma.add(idiomaes);

		barra.add(mnuVentanaRegistro);
		barra.add(idioma);

		setJMenuBar(barra);

	}

	@Override

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//gd = new GestionDatos();
		String comando = event.getActionCommand();
		System.out.println("Eventos menu " + comando);

		switch (comando) {
		case "mnuVentanapais":
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
		mnuVentanaRegistro.setText(lang.getString("Inscripciones"));
		idioma.setText(lang.getString("Idiomas"));

		/*mnuVentana1.setText(lang.getString("NuevaInscripcion"));
		mnuVentana3.setText(lang.getString("NuevaUniversidad"));
		mnuVentanas1.setText(lang.getString("Aspirante"));
		mnuVentana11.setText(lang.getString("ListadeAspirantes"));
		mnuVentanabus.setText(lang.getString("BuscarAspirantes"));
		mnuVentanas2.setText(lang.getString("CarrerasUniversitarias"));
		mnuVentana22.setText(lang.getString("ListadeCarreras"));
		mnudisponible.setText(lang.getString("BuscarCarreras"));*/
		mnuSalir.setText(lang.getString("Salir"));

	}

	private void llamarBuscarAspirante() {
		// TODO Auto-generated method stub
	/*	BuscarAspirante buscar = new BuscarAspirante();
		buscar.setVisible(true);
		escritorio.add(buscar);
		try {
			buscar.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	private void llamarListadoAspirantes() {
		// TODO Auto-generated method stub
	/*	VentanaTablaAspirantes vta = new VentanaTablaAspirantes(gd);
		vta.setVisible(true);
		escritorio.add(vta);
		try {
			vta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void llamarVentanaInscripcion() {
		// TODO Auto-generated method stub
/*		VnVentanaInscripcion vins = new VnVentanaInscripcion(gd);
		vins.setVisible(true);
		escritorio.add(vins);
		try {
			vins.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public void llamarVentanaUniversidad() {
		// TODO Auto-generated method stub
	/*	VnVentanaUniversidad vuni = new VnVentanaUniversidad(gd);
		vuni.setVisible(true);
		escritorio.add(vuni);
		
		try {
			vuni.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	private void llamarListadoCarreras() {
		// TODO Auto-generated method stub
	/*	TablaCarrera tc = new TablaCarrera(gd);
		tc.setVisible(true);
		escritorio.add(tc);
		try {
			tc.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

	public void salir() {
		System.exit(0);
	}
	
	

}
