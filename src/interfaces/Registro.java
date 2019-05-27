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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.ContraseniaCortaException;
import clases.NombreCortoException;
import clases.TiposPlato;
import clases.Usuario;
import componentes.BotonMenu;
import java.awt.Font;
import java.awt.Cursor;

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
		//ventana.setSize(800,800);
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(874,501);
		
		setBackground(new Color(100,210,21));
		setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(23, 113, 94, 33);
		add(lblNewLabel);
		
		
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblEmail.setBounds(22, 157, 82, 33);
		add(lblEmail);
		
		
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(22, 240, 131, 33);
		add(lblContrasea);
		
		
		
		campoNombre = new JTextField();
		campoNombre.setBounds(163, 126, 106, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		
		campoEmail = new JTextField();
		campoEmail.setBounds(163, 170, 106, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(163, 253, 106, 20);
		add(campoContrasenia);
		
		
		
		//PARA HACER USUARIO
		String nombreUsuario = campoNombre.getText();
		String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
		String email = campoEmail.getText();
		ArrayList<TiposPlato> gustoUs = new ArrayList<TiposPlato>();
		
		
		
		
		JButton añadirGustoPasta = new JButton("Pasta");
		añadirGustoPasta.setBounds(609, 157, 100, 94);
		añadirGustoPasta.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/pasta.jpg")));
		add(añadirGustoPasta);
		
		
		JPanel gustos = new JPanel();
		gustos.setBounds(321, 102, 243, 228);
		add(gustos);
		setVisible(true);
		
		añadirGustoPasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ir a un dialogo donde se pueda seleccionar uno cualquiera entre los gustos disponibles. Recuperarlo en esta pantalla.
				JButton gusto1;
				gustos.add( gusto1 =new JButton("Pasta"));
				añadirGustoPasta.setVisible(false);
				//PARA EL REFRESCO??
				//gustos.setVisible(false);
				gustos.setVisible(true);
				gustoUs.add(TiposPlato.PASTA);
				
				gusto1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						for (int i = 0; i < gustoUs.size(); i++) {
							if(gustoUs.get(i)==TiposPlato.PASTA) {
								gustoUs.remove(i);
								break;
							}
						}
						
						gusto1.setVisible(false);
						añadirGustoPasta.setVisible(true);
					}
				});
			}
		});
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 88, 569, 279);
		add(panel);
		panel.setLayout(null);
		
		BotonMenu botonRegistrar = new BotonMenu("Registrar");
		botonRegistrar.setBounds(80, 245, 89, 23);
		panel.add(botonRegistrar);
		
		
		
		
		
		botonAtras2 = new JButton("Atr\u00E1s");
		botonAtras2.setBounds(193, 245, 89, 23);
		panel.add(botonAtras2);
		
		JPanel panel_iconos = new JPanel();
		panel_iconos.setBackground(Color.BLACK);
		panel_iconos.setBounds(598, 72, 243, 279);
		add(panel_iconos);
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
		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				
				
				//añadir gustos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				
				//ESTO ES PARA GUARDARLO EN LA BASE DE DATOS EL USUARIO RECIEN CREADO
				//ESTO CREA UN OBJETO USUARIO NUEVO
				try {
					
					//PARA LA TABLA USUARIOS
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.85:3306/recetas","chef","chef")); //ESTO CONECTA A LA BASE DE DATOS
					//usamos
					PreparedStatement smt =
					ventana.getCon().prepareStatement("insert into usuarios values(?,?,?)"); //ESTO INSERTA LOS VALORES
					
					smt.setString(1, nombreUsuario);
					smt.setString(2, contrasenia);
					smt.setString(3, email);
					
					smt.executeUpdate();                                                   //HASTA AQUI SE HAN INSERTADO LOS VALORES PARA LA BASE DE DATOS
					
					
					//CREAR USUARIO
					
					Usuario user;
					
					ventana.setUsuario(user=new Usuario (nombreUsuario, contrasenia,  email, gustoUs)); //ESTO CREA EL NUEVO OBJETO USUARIO
					
					
					
					//PARA TABLA GUSTOS AÑADIR CADA GUSTO EN CADA FILA POR SEPARADO JUNTO CON NOMBRE
					/*
					for (int i = 0; i <gustoUs.size(); i++) {
						PreparedStatement smt2 =
								ventana.getCon().prepareStatement("insert into gustostabla values(?,?)"); //ESTO INSERTA LOS VALORES
								//String indice1="";
						
								smt2.setString(1, ventana.getUsuario().getNombre());
								
								//indice1 = gustoUs.get(i).toString();
								smt2.setString(2, gustoUs.get(i).toString());
								
								
								smt2.executeUpdate(); 
					}*/
					
					//PARA AÑADIR LOS GUSTOS COMO UN UNICO STRING
					PreparedStatement smt2 =
							ventana.getCon().prepareStatement("insert into gustostabla values(?,?)"); //ESTO INSERTA LOS VALORES
							String conjuntoGustos="";
					
							smt2.setString(1, ventana.getUsuario().getNombre());
							int i = 0;
							
							//SE PUEDE???????????????
							/*
							for(TiposPlato prueba:gustoUs) {
								conjuntoGustos += prueba.toString()+" , ";
							}
							*/
							
							for (int j = 0; j < gustoUs.size(); j++) {
								conjuntoGustos += gustoUs.get(j).toString()+" , ";
							}
							
							smt2.setString(2, conjuntoGustos);
							
							
							smt2.executeUpdate(); 
					
					
					
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
				
				catch (NombreCortoException e2) {
					 JOptionPane.showMessageDialog(ventana, "El nombre debe tener al menos 8 caracteres", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
									//e1.printStackTrace();
								}
				
				
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
