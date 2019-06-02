package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	private Boolean botOn; // TODO ES ASI?
	private JButton gusto1;

	public LoginGustosMod(Ventana v, String nombre) {
		super();
		thisRef = this;
		this.ventana = v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(1098, 569);
		setBackground(new Color(100, 210, 21));
		setLayout(null);
		botOn = false;
		gusto1 = new JButton();

		ArrayList<TiposPlato> gustoUs = new ArrayList<TiposPlato>();

		// TODO:GUARDA EL ARRAYLIST DE GUSTOS DEL USUARIO
		// ArrayList<TiposPlato> gustoUs = v.getUsuario().getGustos();

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
		campoNombreUsuario.setText(ventana.getLista().getNombreUsuario());

		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(217, 181, 202, 29);
		add(campoContrasenia);
		campoContrasenia.setColumns(10);

		botonAtras2 = new JButton("Atr\u00E1s");
		botonAtras2.setBounds(102, 282, 89, 23);
		botonAtras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				botOn = false;

				ventana.irALista(ventana.getLista().getNombreUsuario());
			}
		});
		add(botonAtras2);

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

		// primero los BOTONES

		JButton añadirGustoPasta;
		añadirGustoPasta = new JButton("Pasta");
		añadirGustoPasta.setBounds(609, 157, 100, 94);
		añadirGustoPasta.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/ensalada.jpg")));
		add(añadirGustoPasta);

		añadirGustoPasta.setVisible(false);
		gusto1 = new JButton("Pasta");
		gusto1.setVisible(false);

		// despues PANELES

		// PANEL IZQ
		JPanel gustos;
		gustos = new JPanel();
		gustos.setBounds(10, 326, 479, 184);
		add(gustos);
		gustos.setVisible(false);
		
		// PANEL DER
		JPanel panelIconos;
		panelIconos = new JPanel();
		panelIconos.setBackground(Color.BLACK);
		
		
		try {
			BufferedImage image = ImageIO.read(new File("./src/imagenes/madera.jpg"));
			JLabel label = new JLabel (new ImageIcon(image));
			label.setBounds(580, 86, 457, 424);
			panelIconos.add(label);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(panelIconos);
		panelIconos.setBounds(580, 86, 457, 424);
		
		
		panelIconos.setVisible(false);

		/*
		 * TODO //los gustos que ya debe tener el panel segun usuario //TiposPlato
		 * gustosPlatos;
		 * 
		 * //for (TiposPlato gus : TiposPlato.values()) { for (int i = 0; i <
		 * ventana.getUsuario().getGustos().size(); i++) {
		 * if(ventana.getUsuario().getGustos().get(i).equals("PASTA") ) { JButton
		 * gusto1; panel_1.add( gusto1 =new JButton("Pasta"));
		 * añadirGustoPasta.setVisible(false); } }
		 */

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (botOn == false) {
					button.setText("-");

					añadirGustoPasta.setVisible(true);

					panelIconos.setVisible(true);
					gustos.setVisible(true);

					añadirGustoPasta.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {

							gustos.add(gusto1);
							gusto1.setVisible(true);
							añadirGustoPasta.setVisible(false);

							// gustoUs.add(TiposPlato.PASTA);

							gusto1.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									/*
									 * for (int i = 0; i < gustoUs.size(); i++) {
									 * if(gustoUs.get(i)==TiposPlato.PASTA) { gustoUs.remove(i); break; } }
									 */
									gusto1.setVisible(false);

									añadirGustoPasta.setVisible(true);
									// panelIconos.setVisible(true);
								}
							});
						}
					});

					botOn = true;
				} else {

					button.setText("+");
					gusto1.setVisible(false);
					añadirGustoPasta.setVisible(false);
					panelIconos.setVisible(false);
					gustos.setVisible(false);

					botOn = false;
				}

			}
		});

		// ir a
		JButton btnIaA = new JButton("ModGus");
		btnIaA.setEnabled(false);
		btnIaA.setBounds(217, 241, 89, 23);
		add(btnIaA);

		// LOGIN AL FINAL CON GUSTOS YA MODIFICADOS

		BotonMenu botonLogin = new BotonMenu("Borrar Usuario");

		botonLogin.setBounds(102, 239, 89, 23);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String nombreUsuario = campoNombreUsuario.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				if (!nombreUsuario.equals("") && !contrasenia.equals("")) {

					try {
						// ventana.setCon(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recetas","root",""));
						ventana.setCon(
								DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas", "chef", "chef")); 

						PreparedStatement smt = ventana.getCon()
								.prepareStatement("DELETE FROM usuarios WHERE Nombre = '" + nombreUsuario
										+ "' and Password = '" + contrasenia + "'");
						
						int opcionElegida =JOptionPane.showConfirmDialog(ventana, "eliminar usuario?", "eliminar usuario?",
								JOptionPane.YES_NO_OPTION);
						//Si es 0 y no es 1
						if(opcionElegida==0) {
							smt.executeUpdate();
							JOptionPane.showMessageDialog(ventana, "usuario eliminado", "fuera de aquí",
									JOptionPane.INFORMATION_MESSAGE);
							ventana.getCon().close();
							campoNombreUsuario.setText("");
							campoContrasenia.setText("");
							botOn = false;
							ventana.irALogin();
							
							
						}else {
							ventana.getCon().close();
							JOptionPane.showMessageDialog(ventana, "sigues existiendo", "sigues existiendo",
									JOptionPane.INFORMATION_MESSAGE);
							
						}
						

						

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(ventana, "Conexion fallida", "Conexi�n incorrecta",
								JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(ventana, "Porfavor, rellene todos los campos", "Error: campo vacío",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(botonLogin);

		JPanel menu = new JPanel();
		menu.setBackground(Color.BLACK);
		menu.setBounds(10, 86, 479, 308);
		add(menu);

		this.setVisible(true);

		// PARA TABLA GUSTOS AÑADIR CADA GUSTO EN CADA FILA POR SEPARADO JUNTO CON
		// NOMBRE EN BASE DATOS
		/*
		 * for (int i = 0; i <gustoUs.size(); i++) { PreparedStatement smt2 =
		 * ventana.getCon().prepareStatement("insert into gustostabla values(?,?)");
		 * //ESTO INSERTA LOS VALORES //String indice1="";
		 * 
		 * smt2.setString(1, ventana.getUsuario().getNombre());
		 * 
		 * //indice1 = gustoUs.get(i).toString(); smt2.setString(2,
		 * gustoUs.get(i).toString());
		 * 
		 * 
		 * smt2.executeUpdate();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //MODIFICAR GUSTOS DEL OBJETO USUARIO HEREDADO DE VENTANA
		 * ventana.getUsuario().setGustos(gustoUs);
		 * 
		 * //PARA AÑADIR LOS GUSTOS COMO UN UNICO STRING EN BASE DATOS PreparedStatement
		 * smt2 = null; try { smt2 =
		 * ventana.getCon().prepareStatement("insert into gustostabla values(?,?)"); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } //ESTO INSERTA LOS VALORES String conjuntoGustos="";
		 * 
		 * try { smt2.setString(1, ventana.getUsuario().getNombre());
		 * 
		 * int i = 0;
		 * 
		 * //SE PUEDE??????????????? /* for(TiposPlato prueba:gustoUs) { conjuntoGustos
		 * += prueba.toString()+" , "; }
		 */
		/*
		 * for (int j = 0; j < gustoUs.size(); j++) { conjuntoGustos +=
		 * gustoUs.get(j).toString()+" , "; }
		 * 
		 * smt2.setString(2, conjuntoGustos); smt2.executeUpdate(); }
		 */

	}

	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
