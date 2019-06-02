package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import clases.Ingrediente;
import clases.Plato;
import clases.TiposPlato;

import java.awt.Font;
import java.awt.Color;

public class ListaRec extends JPanel {
	private Ventana ventana;
	final private String nombreUsuario;
	private ImageIcon imagen;
	private String nombreplato;
	private TiposPlato tipo;
	private LocalTime tiempo;
	private Plato platin;
	private String eleccion;

	private JTextField textFieldBuscador;

	public ListaRec(Ventana v, String nombre, String nombreUsuario) {
		super();
		
		this.ventana = v;
		this.nombreUsuario = nombreUsuario;
		// ventana.setSize(800,800);
		imagen = new ImageIcon(getClass().getResource(nombre));

		JList<String> list = new JList<String>();
		
		

		list.setBounds(140, 141, 777, 285);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		// JScrollPane scrollPane = new JScrollPane(list); //PODER HACER SCROLL

		try {
			ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas", "chef", "chef"));

			// set global time_zone='+1:00';
			Statement smt = ventana.getCon().createStatement();

			ResultSet rs = smt
					.executeQuery("select nombrePlato from receta_plato where usuario ='" + nombreUsuario + "'");

			while (rs.next()) {
				// AQUI PONEMOS EL RESTO DE CAMPOS
				nombreplato = rs.getString(1);
				modelo.addElement(nombreplato);
			}

			ventana.getCon().close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ventana, "Conexion fallida", "Conexi�n incorrecta",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		list.setModel(modelo);
		add(list);

		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.setBounds(28, 22, 97, 33);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.removeAll();

				ventana.irALogin();
			}
		});
		setLayout(null);
		add(botonAtras);

		JButton btnAnadir = new JButton("CREAR RECETA");
		btnAnadir.setBounds(536, 474, 166, 38);
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ventana.irANuevasRecetas();
			}
		});
		add(btnAnadir);
		JButton btnVer = new JButton("VER RECETA");
		btnVer.setBounds(360, 474, 166, 38);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVer.setEnabled(false); 
				btnAnadir.setText("CREAR RECETA");
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnVer.setEnabled(true); 
				btnAnadir.setText("MODIFICAR RECETA");
			}
		});
		
		if(list.getSelectedIndex()==-1) {
			 btnVer.setEnabled(false); 
			 }
		 

		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eleccion = String.valueOf(list.getSelectedValue());

				try {

					ventana.setCon(
							DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas", "chef", "chef"));
																													
					Statement smt = ventana.getCon().createStatement();
					ResultSet rs = smt.executeQuery("select * from receta_plato where nombrePlato ='" + eleccion + "' and usuario ='" + nombreUsuario + "'");// AQUI SOLO PONEMOS LOS CAMPOS QUE ESTAMOS BUSCANDO PARA HACER LOGIN
																		

					if (rs.next()) {
						// Plato(String nombrePlato, Ingrediente[] ingredientes, TiposPlato tipo, int numeroPersonas,LocalTime tiempo, String pasos)
						nombreplato = rs.getString(1);
						String ingrediente1 = rs.getString(2);
						Ingrediente[] ingredientes = { new Ingrediente(ingrediente1 ) };
						//tipo = TiposPlato.valueOf(rs.getString(3));
						int personas = rs.getInt(4);
						String tiempo1 = rs.getString(5);
						// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");

						// convert String to LocalTime
						tiempo = LocalTime.parse(tiempo1, formatter);

						String pasitos = rs.getString(6);
						platin = new Plato(nombreplato, ingredientes, personas, tiempo, pasitos);
					}

					ventana.getCon().close();
					ventana.irAReceta(platin);
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(ventana, "Conexion fallida", "Conexi�n incorrecta",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}

			}
		});
		add(btnVer);

		JButton btnNewButton = new JButton("Modificar Login");
		btnNewButton.setBounds(149, 22, 146, 33);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ventana.irALoginGustosMod();
			}
		});
		
		add(btnNewButton);	//NO LO TENGO BIEN TERMINADO LA MODIFICACIÓN DE USUARIO

		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Banana Yeti", Font.BOLD, 27));
		lblBuscador.setBounds(500, 59, 166, 38);
		add(lblBuscador);

		textFieldBuscador = new JTextField();
		textFieldBuscador.setText("próximamente");
		textFieldBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVer.setEnabled(false); 
				btnAnadir.setText("CREAR RECETA");
			}
		});
		textFieldBuscador.setBounds(604, 72, 313, 22);
		add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(ListaRec.class.getResource("/imagenes/rubbish.jpg")));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				if (list.getSelectedIndex()!= -1 && !nombreUsuario.equals("")) {
					int indiceBorr = list.getSelectedIndex();
					String nombrePlatoLista = String.valueOf(list.getSelectedValue());
					try {
						// ventana.setCon(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recetas","root",""));		//PARA CENEC
						ventana.setCon(
								DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas", "chef", "chef")); 

						PreparedStatement smt = ventana.getCon().prepareStatement("DELETE FROM receta_plato WHERE usuario = '" + getNombreUsuario()
										+ "' and nombrePlato = '" + nombrePlatoLista + "'");
						smt.executeUpdate();
						
						
						modelo.remove(indiceBorr);
						list.setModel(modelo);
						JOptionPane.showMessageDialog(ventana, "Plato eliminado", "Plato eliminado",
								JOptionPane.INFORMATION_MESSAGE);
						

						ventana.getCon().close();

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(ventana, "Conexion fallida", "Conexi�n incorrecta",
								JOptionPane.ERROR_MESSAGE);
						
					}
				} else {
					JOptionPane.showMessageDialog(ventana, "Seleccione un plato de la lista", "Error: selecciona plato",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBorrar.setBounds(970, 306, 97, 120);
		add(btnBorrar);
		
		

	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
