package interfaces;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Ingrediente;
import clases.Plato;
import clases.TiposPlato;
import clases.Usuario;
import componentes.Audioss;
import javafx.scene.media.MediaPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class Ventana extends JFrame{

	private EligeLoginRegistro elr;
	private Login login;
	private Registro registro;
	private Usuario usuario;
	private TiposPlato tiposPlato;
	private Principal principal;
	private Connection con;
	ImageIcon imagen;
	private Audioss audi;
	private Audioss audiPri;
	private ListaRec lista;
	private Recetas rec;
	private NuevasRec nueva;
	private LoginGustosMod loginMod;
	private Ventana thisRef;
	private Plato plato;
	private Ingrediente ingredientes;
	 
	
	

	/**
	 * @return the elr
	 */
	public EligeLoginRegistro getElr() {
		return elr;
	}

	/**
	 * @param elr the elr to set
	 */
	public void setElr(EligeLoginRegistro elr) {
		this.elr = elr;
	}

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

	/**
	 * @return the rec
	 */
	public Recetas getRec() {
		return rec;
	}

	/**
	 * @param rec the rec to set
	 */
	public void setRec(Recetas rec) {
		this.rec = rec;
	}

	/**
	 * @return the nueva
	 */
	public NuevasRec getNueva() {
		return nueva;
	}

	/**
	 * @param nueva the nueva to set
	 */
	public void setNueva(NuevasRec nueva) {
		this.nueva = nueva;
	}

	/**
	 * @return the lista
	 */
	public ListaRec getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(ListaRec lista) {
		this.lista = lista;
	}

	/**
	 * @return the audiPri
	 */
	public Audioss getAudiPri() {
		return audiPri;
	}

	/**
	 * @param audiPri the audiPri to set
	 */
	public void setAudiPri(Audioss audiPri) {
		this.audiPri = audiPri;
	}

	/**
	 * @return the audi
	 */
	public Audioss getAudi() {
		return audi;
	}

	/**
	 * @param audi the audi to set
	 */
	public void setAudi(Audioss audi) {
		this.audi = audi;
	}

	/**
	 * @return the tiposPlato
	 */
	public TiposPlato getTiposPlato() {
		return tiposPlato;
	}

	/**
	 * @param tiposPlato the tiposPlato to set
	 */
	public void setTiposPlato(TiposPlato tiposPlato) {
		this.tiposPlato = tiposPlato;
	}
	
	
	

	/**
	 * @return the ingredientes
	 */
	public Ingrediente getIngredientes() {
		return ingredientes;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(Ingrediente ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	

	/**
	 * @return the plato
	 */
	public Plato getPlato() {
		return plato;
	}

	/**
	 * @param plato the plato to set
	 */
	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Ventana() {
		super();
		elr = new EligeLoginRegistro(this, "FONDON.jpg");
		
		audiPri = new Audioss();
		//elr.setBackground(Color.CYAN);
		this.setTitle("Mmm");
		this.setSize(1100, 600);
		this.setContentPane(elr);
		this.setResizable(false);
		
		try {
			this.setIconImage(ImageIO.read(new File("./src/imagenes/goroo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int opcionElegida = JOptionPane.showConfirmDialog(thisRef, "seguro?","una hortaliza bebé será sacrificada",JOptionPane.YES_NO_OPTION);
					//Si es 0 y no es 1
				if(opcionElegida==0) {
					System.exit(0);
				}
				
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setVisible(true);
	
	}
	
	public Ventana(String nom) {
		super();
		
		//this.setBackground(Color.CYAN);
		this.setTitle("GUSTOS");
		//this.setSize(500, 500);
		
		this.setResizable(false);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		
		add(panel2, BorderLayout.CENTER);
		this.setBounds(550, 200, 500, 500);
		this.setContentPane(panel2);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		
		this.setVisible(true);
	
	}
	
	public void irALogin() {
		if(principal!=null) {
			audi.Stop();
			this.principal.setVisible(false);
		}
		//1- Inicializar login, si no lo est� a
		if (login==null) {
			this.login = new Login(this,"login.jpg");
		}
		audiPri.Stop();
		audi = new Audioss("");
		
		//2- Hacer invisible las ventanas anteriores
		this.elr.setVisible(false);
		
		//3- Establecer el contentPane a esta nueva pantalla
		this.setContentPane(login);
		this.login.setVisible(true);
		
	}
	
	public void irARegistro() {
		if (registro==null) {
			this.registro= new Registro(this,"loginburger.jpg");
		
		}
		/*if (this.elr!=null) {
			this.elr.setVisible(false);
		}*/
		audiPri.Stop();
		audi = new Audioss("");
		this.elr.setVisible(false);
		this.setContentPane(registro);
		this.registro.setVisible(true);
	}
		
	
	
	public void irAEligeLoginRegistro() {
		
		if (elr==null) {
			this.elr= new EligeLoginRegistro(this, "FONDON.jpg");
			
		}else {
			audiPri=new Audioss();
			this.setElr(new EligeLoginRegistro(this, "FONDON.jpg"));
		}
		if(login!=null) {
			login.setVisible(false);}
		
		if(registro!=null) {
			registro.setVisible(false);
		}
		
		this.setContentPane(elr);
		this.elr.setVisible(true);
		audi.Stop();
	}
	
	public void irAPrincipal() {
		if (principal==null) {
			this.principal= new Principal(this);
		}
		
		if(login!=null) {
			login.setVisible(false);}
		
		this.setContentPane(principal);
		this.principal.setVisible(true);
	}
	public void irALista(String nombreUsuario) {
		
		if(login!=null) {
			audi.Stop();
			this.login.setVisible(false);
		}
		if(rec!=null) {
			
			this.rec.setVisible(false);
			this.setRec(null);
		}
		if(nueva!=null) {
			this.nueva.setVisible(false);
		}
		
		if (lista==null) {
			this.lista= new ListaRec(this,"login.jpg", nombreUsuario);
		
		}else {
			this.setLista(new ListaRec(this,"login.jpg", nombreUsuario));		//HE SACADO ESTA CONCLUSIÓN TARDE :( , quizás podría haberme ahorrado bastantes retoques que hice antes
			//this.lista= this.getLista();										//Entiendo que así me modifica el objeto ya creado (con sus valores originales), no me crea otro
		}
		
		
		
		this.setContentPane(lista);
		this.lista.setVisible(true);
	}
	
	public void irALoginGustosMod() {
		if (loginMod==null) {
			this.loginMod= new LoginGustosMod(this,"loginMod.jpg");
		
		}
		
		this.lista.setVisible(false);
		this.setContentPane(loginMod);
		this.loginMod.setVisible(true);
	}
	
	
	
	public void irAReceta(Plato p) {
		if (rec==null) {
			this.rec= new Recetas(this,"login.jpg",p);
		
		}
		
		this.lista.setVisible(false);
		this.setContentPane(rec);
		this.rec.setVisible(true);
	}
	
	public void irANuevasRecetas() {
		
		
		if (nueva==null) {
			this.nueva= new NuevasRec(this,"login.jpg");
		
		}else {
			this.setNueva(new NuevasRec(this,"login.jpg"));
		}
		if(rec!=null) {
			this.rec.setVisible(false);
		}
		if(lista!=null) {
			this.lista.setVisible(false);
		}
		
		this.setContentPane(nueva);
		this.nueva.setVisible(true);
	}
	
}
