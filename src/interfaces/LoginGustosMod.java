package interfaces;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import clases.NombreCortoException;
import clases.TiposPlato;
import clases.Usuario;
import componentes.Audioss;
import componentes.BotonMenu;
import java.awt.Font;

public class LoginGustosMod extends JPanel {
	private JTextField campoNombreUsuario;
	private JPasswordField campoContrasenia;
	private Ventana ventana;
	ImageIcon imagen;
	private Audioss audio2;
	private JButton botonAtras2;
	public LoginGustosMod thisRef;
	public Boolean botOn; //TODO ES ASI?
	
	public LoginGustosMod(Ventana v, String nombre) {
        super();
        thisRef=this;
        this.ventana = v;
        imagen = new ImageIcon(getClass().getResource(nombre));
        setSize(732,600);
		setSize(915,600);
		setSize(600,600);
		setBackground(new Color(100,210,21));
		String ejem ="";
		audio2 = new Audioss(ejem);
		setLayout(null);
		ArrayList<TiposPlato> gustoUs = new ArrayList<TiposPlato>();
		
		//TODO:GUARDA EL ARRAYLIST DE GUSTOS DEL USUARIO
		//ArrayList<TiposPlato> gustoUs = v.getUsuario().getGustos();
		
		JLabel lblNombreUsuario = new JLabel("Usuario : ");
		lblNombreUsuario.setBounds(49, 103, 165, 40);
		lblNombreUsuario.setFont(new Font("Banana Yeti", Font.BOLD, 40));
		lblNombreUsuario.setForeground(Color.WHITE);
		add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setBounds(28, 170, 197, 40);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Banana Yeti", Font.BOLD, 40));
		add(lblContrasea);
		
		campoNombreUsuario = new JTextField();
		campoNombreUsuario.setBounds(217, 119, 202, 29);
		add(campoNombreUsuario);
		campoNombreUsuario.setColumns(10);
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(217, 181, 202, 29);
		add(campoContrasenia);
		campoContrasenia.setColumns(10);
		
		
		
		
		 botonAtras2 = new JButton("Atr\u00E1s");
		botonAtras2.setBounds(102, 282, 89, 23);
		botonAtras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				audio2.getMp().stop();
				botOn=false;
				ventana.irAEligeLoginRegistro();
			}
		});
		add(botonAtras2);
		
		JButton btnIaA = new JButton("ia a");
		btnIaA.setBounds(217, 241, 89, 23);
		btnIaA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				audio2.getMp().stop();
				botOn=false;
				ventana.irALista();
			}
		});
		add(btnIaA);
		
		JLabel lblGustos = new JLabel("Gustos");
		lblGustos.setBounds(244, 275, 175, 54);
		add(lblGustos);
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Banana Yeti", Font.BOLD, 40));
		
		botOn = false;
		JButton button = new JButton("+");
		button.setBounds(354, 241, 98, 108);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Banana Yeti", Font.PLAIN, 90));
		add(button);
		
		//primero los BOTONES
		
		JButton añadirGustoPasta;
		añadirGustoPasta = new JButton("Pasta");
		añadirGustoPasta.setBounds(609, 157, 100, 94);
		añadirGustoPasta.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/pasta.jpg")));
		add(añadirGustoPasta);
		
		añadirGustoPasta.setVisible(false);
		
		//despues PANELES
		
		//PANEL IZQ
		JPanel gustos;
		gustos = new JPanel();
		gustos.setBounds(10, 326, 479, 184);
		add(gustos);
		gustos.setVisible(false);
		
		//PANEL DER
		JPanel panelIconos;
		panelIconos = new JPanel();
		panelIconos.setBounds(580, 33, 500, 500);
		add(panelIconos);
		panelIconos.setVisible(false);
		
		
		
		
		/*TODO
		//los gustos que ya debe tener el panel segun usuario
				//TiposPlato gustosPlatos;
				
				//for (TiposPlato gus : TiposPlato.values()) {
					  for (int i = 0; i < ventana.getUsuario().getGustos().size(); i++) {
						  if(ventana.getUsuario().getGustos().get(i).equals("PASTA") ) {
							  JButton gusto1;
								panel_1.add( gusto1 =new JButton("Pasta"));
								añadirGustoPasta.setVisible(false);
						  }
					}
		*/
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			if(botOn==false) {
					button.setText("-");
					añadirGustoPasta.setVisible(true);
					panelIconos.setVisible(true);
					gustos.setVisible(true);
					
					
					añadirGustoPasta.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							//ir a un dialogo donde se pueda seleccionar uno cualquiera entre los gustos disponibles. Recuperarlo en esta pantalla.
							gustos.setVisible(false);
							JButton gusto1;
							gusto1 =new JButton("Pasta");
							gustos.add(gusto1);
							gusto1.setVisible(true);
							gustos.setVisible(true);
							
							
							añadirGustoPasta.setVisible(false);
							
							//gustoUs.add(TiposPlato.PASTA);
							
							gusto1.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									/*
									for (int i = 0; i < gustoUs.size(); i++) {
										if(gustoUs.get(i)==TiposPlato.PASTA) {
											gustoUs.remove(i);
											break;
										}
									}
									*/
									gusto1.setVisible(false);
									panelIconos.setVisible(false);
									añadirGustoPasta.setVisible(true);
									panelIconos.setVisible(true);
								}
							});
						}
					});
					
					
					/*
					JButton añadirGusto2;
					
					añadirGusto2 = new JButton("Pescado");
					añadirGusto2.setIcon(new ImageIcon(LoginGustosMod.class.getResource("/imagenes/pescado.png")));
					añadirGusto2.setSize(200, 200);
					add(añadirGusto2);
					
					
					JButton añadirGusto3;
					añadirGusto3 = new JButton("Dulces");
					añadirGusto3.setIcon(new ImageIcon(LoginGustosMod.class.getResource("/imagenes/dulces.jpg")));
					añadirGusto3.setSize(200, 200);
					add(añadirGusto3);*/
					
					
					
					botOn=true;
				}else {
					button.setText("+");
					añadirGustoPasta.setVisible(false);
					
					panelIconos.setVisible(false);
					gustos.setVisible(false);
					
					botOn=false;
				}
				
				
				//POSIBLE VENTANA PARA LOS GUSTOS
				//Ventana modGustos = new Ventana("");
				
				
				//AÑADIRGUSTO ES EL BOTON DE panel
				//gusto1 es el boton de resultado
				//panel es el panel del boton añadir gusto.
				//gustos es el panel del boton gusto1.
				
				
				
				/*
				JButton añadirGusto = new JButton("Pasta");
				añadirGusto.setSize(200, 200);
				panel.add(añadirGusto);
				
				añadirGusto.setIcon(new ImageIcon(LoginGustosMod.class.getResource("/imagenes/ensalada.jpg")));*/
				
				
				
				
				
				
				
				/*JPanel panel2 = new JPanel();
				panel2.setBackground(Color.BLACK);
				panel2.setBounds(354, 241, 98, 108);
				add(panel2, BorderLayout.CENTER);
				//panel2.setLayout(new CardLayout(0, 0));
				panel2.setVisible(true);*/
			}
		});
		
		
		
		
		//LOGIN AL FINAL CON GUSTOS YA MODIFICADOS
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.setBounds(102, 239, 89, 23);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				audio2.getMp().stop();
				botOn=false;
				String nombreUsuario = campoNombreUsuario.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				try {
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/recetas","chef","chef"));//CONECTAMOS A LA BASE DE DATOS
					
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
					
					UPDATE empleados
SET sueldo_bruto = '50000',
prima_objetivos = '3000'
WHERE sueldo_bruto < 45000 AND sueldo_bruto > 40000
					
					
					//set global time_zone='+1:00';*/
					Statement smt = ventana.getCon().createStatement(); 
					//he cambiado email por nombre en el where y el getstring
					ResultSet rs = smt.executeQuery("select * from usuarios where nombre ='"+nombreUsuario+"' and contrase�a = '"+contrasenia+"'");//AQUI SOLO PONEMOS LOS CAMPOS QUE ESTAMOS BUSCANDO PARA HACER LOGIN
					if (rs.next()) {
						//AQUI PONEMOS EL RESTO DE CAMPOS
						String email = rs.getString("email");
						
						
						try {
							ventana.setUsuario(new Usuario(nombreUsuario, contrasenia, email));
						} catch (NombreCortoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
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
				
				//PARA TABLA GUSTOS AÑADIR CADA GUSTO EN CADA FILA POR SEPARADO JUNTO CON NOMBRE EN BASE DATOS
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
				
				
				
				
				//MODIFICAR GUSTOS DEL OBJETO USUARIO HEREDADO DE VENTANA
				ventana.getUsuario().setGustos(gustoUs);
				
				//PARA AÑADIR LOS GUSTOS COMO UN UNICO STRING EN BASE DATOS
				PreparedStatement smt2 = null;
				try {
					smt2 = ventana.getCon().prepareStatement("insert into gustostabla values(?,?)");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //ESTO INSERTA LOS VALORES
						String conjuntoGustos="";
				
						try {
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
							
							ventana.getCon().close();
						
				
						
				
				//cerramos
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		add(botonLogin);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.BLACK);
		menu.setBounds(10, 78, 479, 316);
		add(menu);
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
