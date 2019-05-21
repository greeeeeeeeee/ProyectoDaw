package interfaces;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Usuario;
import componentes.Audioss;
import java.awt.Color;

public class Ventana extends JFrame{

	private EligeLoginRegistro elr;
	private Login login;
	private Registro registro;
	private Usuario usuario;
	private Principal principal;
	private Connection con;
	ImageIcon imagen;
	private Audioss audi;
	private ListaRec lista;
	private Recetas rec;
	
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

	public Ventana() {
		super();
		elr = new EligeLoginRegistro(this, "FONDON.jpg");
		//elr.setBackground(Color.CYAN);
		this.setTitle("Mmm");
		this.setSize(1100, 600);
		this.setContentPane(elr);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	
	}
	
	public void irALogin() {
		//1- Inicializar login, si no lo est� a
		if (login==null) {
			this.login = new Login(this,"agua.gif");
		}else {
			String ejem ="";
			audi = new Audioss(ejem);
			
		}
		//2- Hacer invisible las ventanas anteriores
		this.elr.setVisible(false);
		
		//3- Establecer el contentPane a esta nueva pantalla
		this.setContentPane(login);
		this.login.setVisible(true);
		
	}
	
	public void irARegistro() {
		if (registro==null) {
			this.registro= new Registro(this,"registro.jpg");
		
		}
		/*if (this.elr!=null) {
			this.elr.setVisible(false);
		}*/
		this.elr.setVisible(false);
		this.setContentPane(registro);
		this.registro.setVisible(true);
	}
		
	
	
	public void irAEligeLoginRegistro() {
		if (elr==null) {
			this.elr= new EligeLoginRegistro(this, "FONDON.jpg");
			
		}
		if(login!=null) {
			login.setVisible(false);}
		this.setContentPane(elr);
		this.elr.setVisible(true);
	}
	
	public void irAPrincipal() {
		if (principal==null) {
			this.principal= new Principal(this);
		}
		if(this.registro!=null) {
			registro.setVisible(false);}
		if(login!=null) {
			login.setVisible(false);}
		
		this.setContentPane(principal);
		this.principal.setVisible(true);
	}
	public void irALista() {
		if (lista==null) {
			this.lista= new ListaRec(this,"registro.jpg");
		
		}
		/*if (this.elr!=null) {
			this.elr.setVisible(false);
		}*/
		if(login!=null) {
			this.login.setVisible(false);
		}
		if(rec!=null) {
			this.rec.setVisible(false);
		}
		this.setContentPane(lista);
		this.lista.setVisible(true);
	}
	
	
	
}
