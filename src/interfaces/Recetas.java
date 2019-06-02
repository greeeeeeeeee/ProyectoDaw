package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import clases.Plato;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Paint;

public class Recetas extends JPanel {
	private Ventana ventana;
	private String nombre;
	ImageIcon imagen;
	public Recetas thisRef;
	private Plato platin;
	public ListaRec lista;
	private boolean botOn;
	private Ventana modGustos;
	private Media media; // import javafx.scene.media.Media
	public MediaPlayer player;
	private MediaView view;
	JFXPanel fxPanel;

	public Recetas(Ventana v, String nombre, Plato platin) {

		super();
		thisRef = this;
		this.ventana = v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		this.platin = platin;
		setSize(1117, 721);
		setLayout(null);
		botOn = false;
		modGustos = new Ventana("Video " + platin.getNombrePlato());
		modGustos.setVisible(false);
		fxPanel = new JFXPanel();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(97, 21, 845, 538);
		add(panel);
		panel.setLayout(null);
		String path = "src/audios/tartaQueso.mp4";
		media = new Media(new File(path).toURI().toString());
		player = new MediaPlayer(media);
		view = new MediaView(player);
		view.setFitHeight(800);
		view.setFitWidth(800);
		// view.setMediaPlayer(player);
		// view.setVisible(true);
		Group g = new Group();
		g.getChildren().add(view);
		Scene s = new Scene(g);

		// s.setFill(Paint.valueOf("TRANSPARENT")); // THIS MAKES IT TRANSPARENT!

		// player.play();
		fxPanel.setScene(s);
		modGustos.add(fxPanel);

		JLabel lblNombreDelPlato = new JLabel("Nombre del Plato:");
		lblNombreDelPlato.setForeground(Color.WHITE);
		lblNombreDelPlato.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblNombreDelPlato.setBounds(27, 20, 157, 27);
		panel.add(lblNombreDelPlato);

		// NOMBRE REC
		JTextField campoNombre = new JTextField();
		campoNombre.setBorder(null);
		campoNombre.setForeground(Color.WHITE);
		campoNombre.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		campoNombre.setBackground(Color.BLACK);
		campoNombre.setBounds(194, 11, 620, 39);
		panel.add(campoNombre);
		campoNombre.setColumns(10);

		// PASOS

		JTextArea textAreaPasos = new JTextArea();
		textAreaPasos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		textAreaPasos.setBounds(27, 300, 787, 181);
		panel.add(textAreaPasos);

		JLabel lblPasos = new JLabel("Pasos");
		lblPasos.setBackground(Color.BLACK);
		lblPasos.setForeground(Color.WHITE);
		lblPasos.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		lblPasos.setBounds(669, 267, 145, 33);
		panel.add(lblPasos);

		// NUM PERSONAS

		JTextField personas = new JTextField();
		personas.setBorder(null);
		personas.setForeground(Color.WHITE);
		personas.setFont(new Font("Arial", Font.BOLD, 25));
		personas.setBackground(Color.BLACK);
		personas.setBounds(462, 128, 50, 27);
		panel.add(personas);
		personas.setColumns(10);

		JLabel lblPersonas = new JLabel("Personas");
		lblPersonas.setForeground(Color.WHITE);
		lblPersonas.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblPersonas.setBounds(349, 127, 84, 33);
		panel.add(lblPersonas);

		// TIEMPO

		JLabel labelTiempoCoc = new JLabel("Tiempo de Cocción");
		labelTiempoCoc.setForeground(Color.WHITE);
		labelTiempoCoc.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		labelTiempoCoc.setBounds(349, 69, 145, 33);
		panel.add(labelTiempoCoc);

		JTextField hourPlat = new JTextField();
		hourPlat.setBorder(null);
		hourPlat.setForeground(Color.WHITE);
		hourPlat.setFont(new Font("Arial", Font.BOLD, 25));
		hourPlat.setBackground(Color.BLACK);
		hourPlat.setColumns(10);
		hourPlat.setBounds(492, 75, 136, 27);
		panel.add(hourPlat);

		// INGREDIENTES

		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblIngredientes.setBounds(27, 69, 100, 33);
		panel.add(lblIngredientes);

		// futuro reloj

		JLabel lblGustos = new JLabel("Reloj");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblGustos.setBounds(553, 130, 64, 27);
		panel.add(lblGustos);
		// LocalTime tiempoRec = LocalTime.of(horasRec,minutosRec);
		JButton buttonReloj = new JButton("Proximamente");
		buttonReloj.setEnabled(false);
		buttonReloj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// VENTANA GUSTOS
				Ventana modGustos = new Ventana("Temporizador");
				modGustos.setResizable(true);

			}
		});
		buttonReloj.setBounds(627, 135, 89, 23);
		panel.add(buttonReloj);

		// futura IMAGEN

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblImagen.setBounds(553, 181, 64, 27);
		panel.add(lblImagen);

		JButton btnElegirImagen = new JButton("Ver");
		btnElegirImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ventana modGustos = new Ventana("Imagen");
				modGustos.setResizable(true);
			}
		});
		btnElegirImagen.setBounds(627, 186, 89, 23);
		panel.add(btnElegirImagen);

		// futuro VIDEO

		JLabel lblVideo = new JLabel("Video");
		lblVideo.setForeground(Color.WHITE);
		lblVideo.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblVideo.setBounds(349, 181, 64, 27);
		panel.add(lblVideo);

		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPlay.setBounds(423, 186, 89, 23);
		panel.add(btnPlay);

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// VENTANA VIDEO
				if (botOn == true) {
					modGustos.setVisible(false);

					btnPlay.setText("Play");
					// modGustos=null;
					botOn = false;
					player.pause();
				} else {
					if (modGustos == null) {
						modGustos = new Ventana("Video " + platin.getNombrePlato());
						modGustos.add(fxPanel);
					}

					modGustos.setVisible(true);

					btnPlay.setText("Stop");
					/*
					 * JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
					 * 
					 * panel_1.add(chckbxNewCheckBox);
					 */

					// modGustos.getContentPane().add(chckbxPasta);
					modGustos.setBounds(700, 100, 800, 500);

					botOn = true;
					// mp.setAutoPlay(false); !!!!!!!!!!!!!!!! MIGUEL SI TE MOLESTA EL AUDIO PUEDES
					// PONERLO EN FALSE
					player.setVolume(0.25);

					player.play();
					modGustos.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent arg0) {
							btnPlay.setText("Play");

							botOn = false;

							// modGustos=null;

							player.pause();
						}
					});
				}

			}
		});

//---------------- Platos creados
		/*
		 * HashMap<String, Plato> misPlatos = new HashMap<String, Plato>();
		 * Ingrediente[] ingredientesPapasHuevos = {new Ingrediente("Patata", 500), new
		 * Ingrediente("Huevo", 30), new Ingrediente("Sal", -1)};
		 * misPlatos.put("Papas con huevos", new Plato("Papas con Huevos",
		 * ingredientesPapasHuevos, 1, LocalTime.of(0, 30)));
		 * 
		 * 
		 * Ingrediente[] ingredientesMojito = {new
		 * Ingrediente("cucharaditas de azúcar blanco", 2), new
		 * Ingrediente("hojas de hierbabuena", 8), new Ingrediente("ml de zumo de lima",
		 * 30) , new Ingrediente("ml. de ron cubano", 60), new
		 * Ingrediente("lima en rodajas o cuartos", 1/2),new Ingrediente("ml. de Soda",
		 * 120),new Ingrediente("Hielo picado", -1)}; misPlatos.put("Cóctel Mojito", new
		 * Plato("Cóctel Mojito", ingredientesMojito, 1, LocalTime.of(0, 5)));
		 * 
		 * Ingrediente[] ingredientesTartaQueso = {new Ingrediente("queso crema", 600),
		 * new Ingrediente("nata de montar", 400), new Ingrediente("huevos camperos", 6)
		 * , new Ingrediente("azúcar de caña", 200), new Ingrediente("sal", 4),new
		 * Ingrediente("queso Flor de guía", 60),new Ingrediente("galleta tipo María",
		 * 200),new Ingrediente("mantequilla salada", 125)};
		 * misPlatos.put("Tarta de Queso", new Plato("Tarta de Queso",
		 * ingredientesTartaQueso, 5, LocalTime.of(2, 0)));
		 * 
		 * Ingrediente[] ingredientesTortitas = {new Ingrediente("huevos L", 2), new
		 * Ingrediente("mantequilla sin sal", 50), new Ingrediente("leche", 250) , new
		 * Ingrediente("azúcar blanco", 50), new Ingrediente("harina de trigol",
		 * 200),new Ingrediente("cucharadita de levadura en polvo", 1),new
		 * Ingrediente("cucharaditas de vainilla", 2)}; misPlatos.put("Tortitas", new
		 * Plato("Tortitas", ingredientesTortitas, 3, LocalTime.of(0, 40)));
		 * 
		 * Ingrediente[] ingredientesEnsaladaPastaPollo = {new
		 * Ingrediente("pasta corta", 150), new Ingrediente("hojas de lechuga", -1), new
		 * Ingrediente("hojas de rúcula", -1) , new Ingrediente("Cebolla", 1/2), new
		 * Ingrediente("pimiento rojo", 1/2),new Ingrediente("Aceite de oliva", -1),new
		 * Ingrediente("Sal", -1),new Ingrediente("kikos triturados", -1),new
		 * Ingrediente("pechuga de pollo", 1)};
		 * misPlatos.put("Ensalada de pasta con pollo", new
		 * Plato("Ensalada de pasta con pollo", ingredientesEnsaladaPastaPollo, 2,
		 * LocalTime.of(0, 30)));
		 */

		JTextArea textIngre = new JTextArea();
		textIngre.setBackground(Color.BLACK);
		textIngre.setForeground(Color.WHITE);
		textIngre.setFont(new Font("Consolas", Font.BOLD, 20));
		textIngre.setEditable(false);
		textIngre.setBounds(27, 131, 316, 158);
		panel.add(textIngre);

		// String nombrePlats = platin.getNombrePlato();
		campoNombre.setText(platin.getNombrePlato());
		personas.setText(Integer.toString(platin.getNumeroPersonas()));
		textAreaPasos.setText(platin.getPasos());
		hourPlat.setText(platin.getTiempo().toString());

		campoNombre.setEditable(false);
		personas.setEditable(false);
		textAreaPasos.setEditable(false);
		hourPlat.setEditable(false);

		String ingrediii = "";
		textIngre.setText(ingrediii.valueOf(platin.getIngredientes()[0].getNombre()));

		JButton btnImprimirIngr = new JButton("Guardar");
		btnImprimirIngr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					File arIngre = new File("./listaIngredientes.txt");
					FileWriter escritor = new FileWriter(arIngre);
					BufferedWriter bfed = new BufferedWriter(escritor);
					bfed.write(textIngre.getText());
					bfed.close();
					JOptionPane.showMessageDialog(ventana, "Archivo guardado", "Archivo guardado",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "Fallo en el guardado", "Fallo en el guardado",
							JOptionPane.ERROR_MESSAGE);
				}
				// TODO:arreglar que guarde seleccionando lugar
				/*
				 * JFileChooser elegir = new JFileChooser(); elegir.showSaveDialog(thisRef);
				 */
			}
		});
		btnImprimirIngr.setBounds(144, 77, 89, 23);
		panel.add(btnImprimirIngr);

		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.setBounds(301, 492, 112, 35);
		panel.add(botonAtras);

		JButton btnVer = new JButton("MODIFICAR");
		btnVer.setBounds(423, 492, 112, 35);
		panel.add(btnVer);
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!modGustos.isVisible()) {
					modGustos = null;
				}
				if (modGustos != null) {
					JOptionPane.showMessageDialog(ventana, "Porfavor, cierre la ventana", "Error: video reproduciendo",
							JOptionPane.ERROR_MESSAGE);

				} else {
					ventana.irANuevasRecetas();
				}

			}
		});

		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!modGustos.isVisible()) {
					modGustos = null;
				}
				if (modGustos != null) {
					JOptionPane.showMessageDialog(ventana, "Porfavor, cierre la ventana", "Error: video reproduciendo",
							JOptionPane.ERROR_MESSAGE);

				} else {
					Plato platin;
					platin = (null);
					ventana.irALista(ventana.getLista().getNombreUsuario());
				}

			}
		});
	}

	/**
	 * @return the platin
	 */
	public Plato getPlatin() {
		return platin;
	}

	/**
	 * @param platin the platin to set
	 */
	public void setPlatin(Plato platin) {
		this.platin = platin;
	}

	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
