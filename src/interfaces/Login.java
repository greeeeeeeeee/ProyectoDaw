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
import javax.swing.JTextField;

import clases.ContraseniaCortaException;
import clases.NombreCortoException;
import clases.Usuario;
import componentes.Audioss;
import componentes.BotonMenu;
import java.awt.Font;

public class Login extends JPanel {
	private JTextField campoNombreUsuario;
	private JPasswordField campoContrasenia;
	private Ventana ventana;
	ImageIcon imagen;

	public Login(Ventana v, String nombre) {
		super();
		this.ventana = v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(), imagen.getIconHeight());
		setSize(600, 600);
		setBackground(new Color(100, 210, 21));

		setLayout(null);
		JLabel lblNewLabel = new JLabel("Usuario : ");
		lblNewLabel.setFont(new Font("Banana Yeti", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(49, 103, 165, 40);
		add(lblNewLabel);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Banana Yeti", Font.BOLD, 40));
		lblContrasea.setBounds(28, 170, 197, 40);
		add(lblContrasea);

		campoNombreUsuario = new JTextField();
		campoNombreUsuario.setBounds(217, 119, 202, 29);
		add(campoNombreUsuario);
		campoNombreUsuario.setColumns(10);

		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(217, 181, 202, 29);
		add(campoContrasenia);
		campoContrasenia.setColumns(10);
		String nombreUsuario2 = "";

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 32, 461, 310);
		add(panel);
				panel.setLayout(null);
		
				JButton botonAtras = new JButton("Atr\u00E1s");
				botonAtras.setBounds(113, 262, 89, 23);
				panel.add(botonAtras);
				BotonMenu botonLogin = new BotonMenu("Login");
				botonLogin.setBounds(212, 260, 89, 25);
				panel.add(botonLogin);
				botonLogin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						String nombreUsuario = campoNombreUsuario.getText();
						String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
						if(!nombreUsuario.equals("") && !contrasenia.equals("") ) {
							
						try {
							ventana.setCon(
									DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas", "chef", "chef"));
							
							// set global time_zone='+1:00';*/
							Statement smt = ventana.getCon().createStatement();
							// he cambiado email por nombre en el where y el getstring
							ResultSet rs = smt.executeQuery("select * from usuarios where Nombre ='" + nombreUsuario
									+ "' and Password = '" + contrasenia + "'");// AQUI SOLO PONEMOS LOS CAMPOS QUE ESTAMOS buscando
																				
							if (rs.next()) {
								// AQUI PONEMOS EL RESTO DE CAMPOS
								String email = rs.getString("email");

								try {
									ventana.setUsuario(new Usuario(nombreUsuario, contrasenia, email));
								} catch (NombreCortoException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								campoNombreUsuario.setText("");
								campoContrasenia.setText("");
								ventana.irALista(nombreUsuario);

							} else {
								JOptionPane.showMessageDialog(ventana, "Introduce el nombre y contrasenia correctos", "Login fallido",
										JOptionPane.ERROR_MESSAGE);
							}
							ventana.getCon().close();

						} catch (SQLException e) {
							JOptionPane.showMessageDialog(ventana, "Conexion fallida", "Conexi�n incorrecta",
									JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						} catch (ContraseniaCortaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(ventana, "Porfavor, rellene todos los campos", "Error: campo vacío",
								JOptionPane.ERROR_MESSAGE);
					}
					}
				});
				botonAtras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						campoNombreUsuario.setText("");
						campoContrasenia.setText("");

						ventana.irAEligeLoginRegistro();
					}
				});

		this.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
