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




public class VentanaGrafica extends JFrame implements ActionListener {
	
	public static Locale localizacion;
	private JDesktopPane escritorio;
	private GestionDatos gd;
	private JMenu mnuVentanaRegistro, mnuVentanaTablas, idioma;
	private JMenuItem mnuVentanpais, mnuVentanaC, mnuVentanaD, mnuIdiom, mnuVentanaE, mnuVentanaA, mnuVentanaF, mnuSalir, idiomaen,
			idiomaes;

	public VentanaGrafica() {
		initComponents();
		gd = new GestionDatos();
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		localizacion = new Locale("es", "EC");
		ResourceBundle lang = ResourceBundle.getBundle("lang.mensajes", localizacion);
		setSize(800, 600);
		setTitle(lang.getString("Gestion Listas"));
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		mnuVentanaRegistro = new JMenu(lang.getString("Registros"));

		JMenuItem mnuVentanaB = new JMenuItem(lang.getString("B"));
		mnuVentanaB.addActionListener(this);
		mnuVentanaB.setActionCommand("mnuVentanaB");
		mnuVentanaRegistro.add(mnuVentanaB);
		
		JMenuItem mnuVentanaC = new JMenuItem(lang.getString("C"));
		mnuVentanaC.addActionListener(this);
		mnuVentanaC.setActionCommand("mnuVentanaC");
		mnuVentanaRegistro.add(mnuVentanaC);
		
		mnuVentanaD = new JMenuItem(lang.getString("D"));
		mnuVentanaD.addActionListener(this);
		mnuVentanaD.setActionCommand("mnuVentanaD");
		mnuVentanaRegistro.add(mnuVentanaD);
		
		mnuVentanaE = new JMenuItem(lang.getString("E"));
		mnuVentanaE.addActionListener(this);
		mnuVentanaE.setActionCommand("mnuVentanaE");
		mnuVentanaRegistro.add(mnuVentanaE);
		
		mnuVentanaA = new JMenuItem(lang.getString("A"));
		mnuVentanaA.addActionListener(this);
		mnuVentanaA.setActionCommand("mnuVentanaA");
		mnuVentanaRegistro.add(mnuVentanaA);
		
		mnuVentanaF = new JMenuItem(lang.getString("F"));
		mnuVentanaF.addActionListener(this);
		mnuVentanaF.setActionCommand("mnuVentanaF");
		mnuVentanaRegistro.add(mnuVentanaF);

		mnuSalir = new JMenuItem(lang.getString("Salir"));
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
		case "mnuVentanaA":
			llamarVentanaA();
			break;
		case "mnuVentanaB":
			llamarVentanaB();
			break;
		case "mnuVentanaC":
			llamarVentanaC();
			break;
		case "mnuVentanaD":
			llamarVentanaD();
			break;
		case "mnuVentanaE":
			llamarVentanaE();
			break;
		case "mnuVentanaF":
			llamarVentanaF();
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


	private void llamarVentanaF() {
		// TODO Auto-generated method stub
		F vntf = new F(gd);
		vntf.setVisible(true);
		escritorio.add(vntf);
		try {
			vntf.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void llamarVentanaE() {
		// TODO Auto-generated method stub
		E vnte = new E(gd);
		vnte.setVisible(true);
		escritorio.add(vnte);
		try {
			vnte.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamarVentanaD() {
		// TODO Auto-generated method stub
		D vntd = new D(gd);
		vntd.setVisible(true);
		escritorio.add(vntd);
		try {
			vntd.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamarVentanaC() {
		// TODO Auto-generated method stub
		C vntc = new C(gd);
		vntc.setVisible(true);
		escritorio.add(vntc);
		try {
			vntc.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamarVentanaB() {
		// TODO Auto-generated method stub
		B vntb = new B(gd);
		vntb.setVisible(true);
		escritorio.add(vntb);
		try {
			vntb.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamarVentanaA() {
		// TODO Auto-generated method stub
		A vnta = new A(ga);
		vnta.setVisible(true);
		escritorio.add(vnta);
		try {
			vnta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void llamaridioma(String lenguaje, String pais) {
		// TODO Auto-generated method stub
		localizacion = new Locale(lenguaje, pais);
		ResourceBundle lang = ResourceBundle.getBundle("Idioma.mensajes", localizacion);
		setTitle(lang.getString("SistemadeInscripcionUniversitaria"));
		mnuVentanaRegistro.setText(lang.getString("Inscripciones"));
		idioma.setText(lang.getString("Idiomas"));
	}
	
	public void salir() {
		System.exit(0);
	}
	
	//bsdjkfgsdufglsfgsldf
	
	

}
