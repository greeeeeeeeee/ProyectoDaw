package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

import clases.CampoVacio;
import clases.ContraseniaCortaException;
import clases.NombreCortoException;
import clases.Plato;
import clases.TiposPlato;
import clases.Usuario;
import componentes.BotonMenu;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class Registro extends JPanel {

	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoEmail;
	ImageIcon imagen;
	private JPasswordField campoContrasenia;
	private JButton botonAtras2;
	public Registro thisRef;
	private ArrayList<TiposPlato> gustoUs;
	private JButton gusto1;
	private JButton gusto2;

	// private ArrayList<String> gustoUs;
	public Registro(Ventana v, String nombre) {
		super();
		thisRef = this;
		this.ventana = v;
		// ventana.setSize(800,800);
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(874, 501);
		gustoUs = new ArrayList<TiposPlato>();
		setBackground(new Color(100, 210, 21));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(23, 113, 106, 33);
		add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblEmail.setBounds(22, 157, 82, 33);
		add(lblEmail);

		JLabel lblContrasea = new JLabel("Contraseña :");
		lblContrasea.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(22, 240, 148, 33);
		add(lblContrasea);

		JButton añadirGustoPasta = new JButton("Pasta");
		añadirGustoPasta.setBounds(609, 157, 100, 94);
		añadirGustoPasta.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/pasta.jpg")));
		add(añadirGustoPasta);

		JButton añadirGustoEnsalada = new JButton("Ensalada");

		añadirGustoEnsalada.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/ensalada.jpg")));
		añadirGustoEnsalada.setBounds(731, 157, 100, 94);
		add(añadirGustoEnsalada);

		JPanel gustos = new JPanel();
		gustos.setBounds(321, 102, 243, 228);
		add(gustos);
		setVisible(true);
		gusto1 = new JButton();
		gusto2 = new JButton();

		añadirGustoPasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				gustos.add(gusto1 = new JButton("Pasta"));
				añadirGustoPasta.setVisible(false);
				// PARA EL REFRESCO??
				// gustos.setVisible(false);
				gustos.setVisible(true);
				gustoUs.add(TiposPlato.PASTA);

				gusto1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {

						for (int i = 0; i < gustoUs.size(); i++) {
							if (gustoUs.get(i) == TiposPlato.PASTA) {
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

		añadirGustoEnsalada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gustos.add(gusto2 = new JButton("Ensalada"));
				añadirGustoEnsalada.setVisible(false);
				// PARA EL REFRESCO??
				// gustos.setVisible(false);
				gustos.setVisible(true);
				gustoUs.add(TiposPlato.ENSALADA);
				gusto2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {

						for (int i = 0; i < gustoUs.size(); i++) {
							if (gustoUs.get(i) == TiposPlato.ENSALADA) {
								gustoUs.remove(i);
								break;
							}
						}

						gusto2.setVisible(false);
						añadirGustoEnsalada.setVisible(true);
					}
				});
			}
		});

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 60, 569, 316);
		add(panel);
		panel.setLayout(null);

		BotonMenu botonRegistrar = new BotonMenu("Registrar");
		botonRegistrar.setBounds(81, 273, 89, 25);
		panel.add(botonRegistrar);

		botonAtras2 = new JButton("Atr\u00E1s");
		botonAtras2.setBounds(193, 275, 89, 23);
		panel.add(botonAtras2);

		JLabel lblGustos = new JLabel("--G  u  s  t  o  s--");
		lblGustos.setBackground(Color.BLACK);
		lblGustos.setBounds(362, 0, 138, 32);
		panel.add(lblGustos);
		lblGustos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Breakfast DEMO", Font.BOLD, 20));

		campoEmail = new JTextField();
		campoEmail.setBounds(176, 105, 106, 20);
		panel.add(campoEmail);
		campoEmail.setColumns(10);

		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(176, 191, 106, 20);
		panel.add(campoContrasenia);

		campoNombre = new JTextField();
		campoNombre.setBounds(176, 64, 106, 20);
		panel.add(campoNombre);
		campoNombre.setColumns(10);

		JPanel panel_iconos = new JPanel();
		panel_iconos.setBounds(603, 60, 243, 316);
		add(panel_iconos);
		panel_iconos.setBackground(Color.BLACK);

		botonAtras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
				campoEmail.setText("");
				campoContrasenia.setText("");
				gustoUs.clear();

				if (gusto1.isVisible() == true) {
					gusto1.setVisible(false);
				}
				if (gusto2.isVisible()) {
					gusto2.setVisible(false);
				}

				añadirGustoPasta.setVisible(true);
				añadirGustoEnsalada.setVisible(true);
				ventana.irAEligeLoginRegistro();

			}
		});
		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// PARA HACER USUARIO

				String nombreUsuario = campoNombre.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				String email = campoEmail.getText();

				if (!nombreUsuario.equals("") && !contrasenia.equals("") && !email.equals("")) {
					if (!gustoUs.isEmpty()) {

						try {
							Usuario user;

							ventana.setUsuario(user = new Usuario(nombreUsuario, contrasenia, email, gustoUs));

							// ventana.setCon(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recetas","root",""));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas",
									"chef", "chef")); // ESTO CONECTA A LA BASE DE DATOS

							PreparedStatement smt = ventana.getCon()
									.prepareStatement("insert into usuarios values(?,?,?)");

							smt.setString(1, nombreUsuario);
							smt.setString(2, contrasenia);
							smt.setString(3, email);

							smt.executeUpdate();
							// ESTE CATCH SE PONE PARA QUE NO SE PUEDA REPETIR LA CLAVE PRIMARIA, EN ESTE
							// CASO ES EL EMAI, EN NUESTRO PROYECTO SER� EL NOMBRE DE USUARIO
						} catch (SQLIntegrityConstraintViolationException iex) {
							try {
								ventana.getCon().close();
							} catch (SQLException e1) {

								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(ventana, "El nombre ya est� registrado, elige otro",
									"Email ya registrado", JOptionPane.ERROR_MESSAGE);

						} catch (SQLException ex) {

							ex.printStackTrace();
						}

						catch (ContraseniaCortaException e1) {

							JOptionPane.showMessageDialog(ventana, "La contrase�a debe tener al menos 8 caracteres",
									"Password incorrecto", JOptionPane.ERROR_MESSAGE);
							// e1.printStackTrace();
						}

						catch (NombreCortoException e2) {

							JOptionPane.showMessageDialog(ventana, "El nombre debe tener al menos 8 caracteres",
									"Nombre incorrecto", JOptionPane.ERROR_MESSAGE);

						}

						// Recorrer el panel gustos
						// gustos.getComponents()
						/*
						 * for (int j = 0; j < gustoUs.size(); j++) { PreparedStatement smt2 =
						 * ventana.getCon().prepareStatement("insert into gustostabla values(?,?)"); ;
						 * 
						 * 
						 * smt2.setString(1, ventana.getUsuario().getNombre());
						 * smt2.setString(2,Plato.tipoPlatoToString(gustoUs.get(j)));
						 * 
						 * smt2.executeUpdate();
						 * 
						 * }
						 */

						// PARA TABLA GUSTOS AÑADIR CADA GUSTO EN CADA FILA POR SEPARADO JUNTO CON
						// NOMBRE

						try {
							String totalGustos="";
							for (int i = 0; i < gustoUs.size(); i++) {

								PreparedStatement smt2 = ventana.getCon()
										.prepareStatement("insert into gustostabla values(?,?)"); // ESTO INSERTA LOS
																									// VALORES
								// String indice1="";
								smt2.setString(1, gustoUs.get(i).toString());
								smt2.setString(2, ventana.getUsuario().getNombre());

								// indice1 = gustoUs.get(i).toString();
								smt2.executeUpdate();

							}
							ventana.getCon().close();

						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						JOptionPane.showMessageDialog(ventana, "Registro completado", "Registro completado con éxito",
								JOptionPane.INFORMATION_MESSAGE);
						File arRegist = new File("./listausers.text");
						try {
							FileWriter escritor = new FileWriter(arRegist,true);
							BufferedWriter bfed = new BufferedWriter(escritor);
							bfed.write("Usuario registrado:"+ventana.getUsuario().getNombre()+" con email: "+ventana.getUsuario().getEmail() );
							bfed.close();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						campoNombre.setText("");
						campoEmail.setText("");
						campoContrasenia.setText("");
						gustoUs.clear();
						if (gusto1.isVisible()) {
							gusto1.setVisible(false);
						}
						if (gusto2.isVisible()) {
							gusto2.setVisible(false);
						}
						añadirGustoPasta.setVisible(true);
						añadirGustoEnsalada.setVisible(true);
						// ventana.irAPrincipal();
					} else {
						JOptionPane.showMessageDialog(ventana, "Añade algún gusto hijo", "Error: poco gusto",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					// podria hacer aquí distinción de si nombre, email o contraseña están vacíos
					// con errores más específicos
					JOptionPane.showMessageDialog(ventana, "Porfavor, rellene todos los campos", "Error: campo vacío",
							JOptionPane.ERROR_MESSAGE);

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
