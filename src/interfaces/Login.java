package interfaces;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import clases.ContraseniaCortaException;
import clases.Usuario;
import componentes.Audioss;
import componentes.BotonMenu;

public class Login extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContrasenia;
	private Ventana ventana;
	ImageIcon imagen;
	private Audioss audio2;
	
	public Login(Ventana v, String nombre) {
        super();
        this.ventana = v;
        imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(),imagen.getIconHeight());
		setSize(600,600);
		setBackground(new Color(100,210,21));
		
		
		setLayout(null);
		String ejem ="";
		audio2 = new Audioss(ejem);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setBounds(50, 122, 79, 14);
		add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setBounds(50, 181, 79, 14);
		add(lblContrasea);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(139, 119, 86, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(139, 178, 86, 20);
		add(campoContrasenia);
		campoContrasenia.setColumns(10);
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				audio2.getMp().stop();
				String usuario = campoUsuario.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				try {
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.26:3306/huesitos","1dam","123"));//CONECTAMOS A LA BASE DE DATOS
					
				/*	//AHORA USAMOS LA BASE DE DATOS
				 * CREATE USER 'chef' IDENTIFIED BY 'chef';
					GRANT ALL PRIVILEGES ON * . * TO 'chef';
					CREATE SCHEMA recetas COLLATE = utf8_general_ci;
					
					CREATE TABLE `usuarios` (
  `Nombre` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
				 * 
					//set global time_zone='+1:00';*/
					Statement smt = ventana.getCon().createStatement(); 
					
					ResultSet rs = smt.executeQuery("select * from usuarios where email ='"+usuario+"' and contrase�a = '"+contrasenia+"'");//AQUI SOLO PONEMOS LOS CAMPOS QUE ESTAMOS BUSCANDO PARA HACER LOGIN
					if (rs.next()) {
						//AQUI PONEMOS EL RESTO DE CAMPOS
						String nombre = rs.getString("nombre");
						
						
						ventana.setUsuario(new Usuario(nombre, contrasenia, usuario));
						
						ventana.irAPrincipal();
						
					}else {
						JOptionPane.showMessageDialog(ventana, "Contrase�a incorrecta","Contrase�a incorrecta", JOptionPane.ERROR_MESSAGE);
					}
					ventana.getCon().close();
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(ventana, "Conexion fallida","Conexi�n incorrecta", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (ContraseniaCortaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		botonLogin.setBounds(102, 239, 89, 23);
		add(botonLogin);
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				audio2.getMp().stop();

				ventana.irAEligeLoginRegistro();
			}
		});
		botonAtras.setBounds(211, 266, 89, 23);
		add(botonAtras);
		
		ButtonGroup group=new ButtonGroup();
		
		JRadioButton femeninoUser = new JRadioButton("F");
		femeninoUser.setBounds(283, 118, 109, 23);
		group.add(femeninoUser);
		add(femeninoUser);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(283, 144, 109, 23);
		group.add(rdbtnM);
		add(rdbtnM);
		
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
