package interfaces;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.ContraseniaCortaException;
import clases.Usuario;
import componentes.BotonMenu;

public class Registro extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoEmail;
	ImageIcon imagen;
	private JPasswordField campoContrasenia;
	private JButton botonAtras2;
	public Registro thisRef;
	
	public Registro (Ventana v,String nombre) {
		super();
		thisRef=this;
		
		
		this.ventana=v;
		ventana.setSize(800,800);
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(),imagen.getIconHeight());
		this.setSize(500,500);
		
		setBackground(new Color(100,210,21));
		
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(38, 64, 62, 14);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(38, 108, 46, 14);
		add(lblEmail);
		
		
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(38, 200, 94, 14);
		add(lblContrasea);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(148, 61, 86, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(148, 105, 86, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(148, 197, 86, 20);
		add(campoContrasenia);
		
		botonAtras2 = new JButton("Atr\u00E1s");
		botonAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAtras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		botonAtras2.setBounds(190, 244, 89, 23);
		add(botonAtras2);
		
		BotonMenu botonRegistrar = new BotonMenu("Registrar");
		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nombreUsuario = campoNombre.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				
				String email = campoEmail.getText();
				
				//ESTO CREA UN OBJETO USUARIO NUEVO
				
				
				//ESTO ES PARA GUARDARLO EN LA BASE DE DATOS EL USUARIO RECIEN CREADO
				try {
					ventana.setUsuario(new Usuario(nombreUsuario, contrasenia,  email)); //ESTO CREA EL NUEVO OBJETO USUARIO
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recetas","root","")); //ESTO CONECTA A LA BASE DE DATOS
					//usamos
					PreparedStatement smt =
					ventana.getCon().prepareStatement("insert into usuarios values(?,?,?)"); //ESTO INSERTA LOS VALORES
					
					smt.setString(1, email);
					smt.setString(2, nombreUsuario);
					
					smt.setString(3, contrasenia);
					smt.executeUpdate();                                                   //HASTA AQUI SE HAN INSERTADO LOS VALORES PARA LA BASE DE DATOS
					
					//cerramos
					
					ventana.getCon().close();
					ventana.irAPrincipal();
					
					//ESTE CATCH SE PONE PARA QUE NO SE PUEDA REPETIR LA CLAVE PRIMARIA, EN ESTE CASO ES EL EMAI, EN NUESTRO PROYECTO SER� EL NOMBRE DE USUARIO
				} catch (SQLIntegrityConstraintViolationException iex){
					JOptionPane.showMessageDialog(ventana, "El email ya est� registrado, elige otro","Email ya registrado", JOptionPane.ERROR_MESSAGE);
					
				}
				
				catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				catch (ContraseniaCortaException e1) {
	 JOptionPane.showMessageDialog(ventana, "La contrase�a debe tener al menos 8 caracteres", "Password incorrecto", JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				}
				
				
				
			}
		});
		botonRegistrar.setBounds(66, 244, 89, 23);
		add(botonRegistrar);
		
		JButton añadirGusto = new JButton("+");
		añadirGusto.setBounds(288, 60, 89, 23);
		add(añadirGusto);
		
		JPanel gustos = new JPanel();
		gustos.setBounds(286, 112, 204, 116);
		add(gustos);
		setVisible(true);
		

		añadirGusto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ir a un dialogo donde se pueda seleccionar uno cualquiera entre los gustos disponibles. Recuperarlo en esta pantalla.
				gustos.add(new JButton("Pasta"));
				gustos.setVisible(false);
				gustos.setVisible(true);
			}
		});
	}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
