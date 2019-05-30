package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.LocalTime;

import clases.ContraseniaCortaException;
import clases.Ingrediente;
import clases.NombreCortoException;
import clases.Plato;
import clases.TiposPlato;
import clases.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class NuevasRec extends JPanel {
	private Ventana ventana;
	ImageIcon imagen;
	public NuevasRec thisRef;
	private JTextField campoNombre;
	private JTextArea textAreaPasos;
	public Plato platin;
	public ListaRec lista;
	
	public NuevasRec (Ventana v,String nombre) {
		super();
		thisRef=this;
		this.ventana=v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(984,572);
	
	
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				ventana.irALista(lista.getNombreUsuario());
			}
		});
		setLayout(null);
		
		botonAtras.setBounds(200, 524, 127, 37);
		add(botonAtras);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(37, 38, 609, 469);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDelPlato = new JLabel("Nombre del Plato:");
		lblNombreDelPlato.setForeground(Color.WHITE);
		lblNombreDelPlato.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblNombreDelPlato.setBounds(27, 24, 157, 27);
		panel.add(lblNombreDelPlato);
		
		
		// NOMBRE REC
		campoNombre = new JTextField();
		campoNombre.setBounds(194, 30, 387, 20);
		panel.add(campoNombre);
		campoNombre.setColumns(10);
		
		
		//PASOS
		
		textAreaPasos = new JTextArea();
		textAreaPasos.setBounds(27, 280, 554, 165);
		panel.add(textAreaPasos);
		
		JLabel lblPasos = new JLabel("Pasos");
		lblPasos.setBackground(Color.BLACK);
		lblPasos.setForeground(Color.WHITE);
		lblPasos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblPasos.setBounds(27, 236, 145, 33);
		panel.add(lblPasos);
		
		
		//NUM PERSONAS
		
		JSpinner spinnerPersonas = new JSpinner();
		spinnerPersonas.setBounds(288, 75, 40, 27);
		panel.add(spinnerPersonas);
		
		JLabel lblPersonas = new JLabel("Personas");
		lblPersonas.setForeground(Color.WHITE);
		lblPersonas.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblPersonas.setBounds(204, 69, 84, 33);
		panel.add(lblPersonas);
		
		
		//TIEMPO
		
		JLabel labelTiempoCoc = new JLabel("Tiempo de Cocción");
		labelTiempoCoc.setForeground(Color.WHITE);
		labelTiempoCoc.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		labelTiempoCoc.setBounds(349, 69, 145, 33);
		panel.add(labelTiempoCoc);
		
		JSpinner spinnerMinutos = new JSpinner();
		spinnerMinutos.setModel(new SpinnerNumberModel(0, 0, 60, 5));
		spinnerMinutos.setBounds(541, 75, 40, 27);
		panel.add(spinnerMinutos);
		
		JSpinner spinnerHoras = new JSpinner();
		spinnerHoras.setBounds(491, 75, 40, 27);
		panel.add(spinnerHoras);
		
		
		//INGREDIENTES
		
		List listIngredientes = new List();
		listIngredientes.setBounds(393, 132, 188, 123);
		panel.add(listIngredientes);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblIngredientes.setBounds(288, 178, 100, 33);
		panel.add(lblIngredientes);
		
		
		//GUSTOS
		
		JLabel lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblGustos.setBounds(27, 72, 64, 27);
		panel.add(lblGustos);
		
		JButton buttonGustos = new JButton("+");
		buttonGustos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//VENTANA GUSTOS
				Ventana modGustos = new Ventana("Gustos");
				JCheckBox chckbxPasta = new JCheckBox("Pasta");
				//chckbxPasta.setBounds(125, 232, 97, 23);
				modGustos.getContentPane().add(chckbxPasta);
				modGustos.setBounds(700, 100, 300, 300);
				modGustos.setSize(300, 300);
				JCheckBox chckbxCarne = new JCheckBox("Carne");
				//chckbxPasta.setBounds(125, 232, 97, 23);
				modGustos.getContentPane().add(chckbxCarne);
				JCheckBox chckbxQueso = new JCheckBox("Queso");
				//chckbxPasta.setBounds(125, 232, 97, 23);
				modGustos.getContentPane().add(chckbxQueso);
				JCheckBox chckbxCoctel = new JCheckBox("Coctel");
				//chckbxPasta.setBounds(125, 232, 97, 23);
				modGustos.getContentPane().add(chckbxCoctel);
				JCheckBox chckbxEnsalada = new JCheckBox("Ensalada");
				//chckbxPasta.setBounds(125, 232, 97, 23);
				modGustos.getContentPane().add(chckbxEnsalada);
				/*
				 * ENSALADA,
		    CARNE,
		    PESCADO,
		    QUESO,
		    POLLO,
		    CÓCTELES,
		    DULCES,
		    BEBIDA,
		    SALSA,
		    PASTA,
				 */
				
			}
		});
		buttonGustos.setBounds(95, 75, 89, 27);
		panel.add(buttonGustos);
		
		
		//IMAGEN
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblImagen.setBounds(27, 127, 64, 27);
		panel.add(lblImagen);
		
		JButton btnElegirImagen = new JButton("Elegir");
		btnElegirImagen.setBounds(95, 132, 89, 23);
		panel.add(btnElegirImagen);
		
		
		//VIDEO
		
		JLabel lblVideo = new JLabel("Video");
		lblVideo.setForeground(Color.WHITE);
		lblVideo.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblVideo.setBounds(27, 181, 64, 27);
		panel.add(lblVideo);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(95, 186, 89, 23);
		panel.add(btnAadir);
		
		
		
		
	
		//PARA HACER PLATO
		String nombreRec = campoNombre.getText();
		String pasosRec = textAreaPasos.getText();
		Integer numPersonRec = (Integer)spinnerPersonas.getValue();
		Integer minutosRec = (Integer)spinnerMinutos.getValue();
		Integer horasRec = (Integer)spinnerHoras.getValue();
		if(minutosRec==60) {
			minutosRec=0;
			horasRec+=1;
		}
		
		LocalTime tiempoRec = LocalTime.of(horasRec,minutosRec);
		
		
		
//---------------- Platos creados
        
        HashMap<String, Plato> misPlatos = new HashMap<String, Plato>();
        Ingrediente[] ingredientesPapasHuevos = {new Ingrediente("Patata", 500), new Ingrediente("Huevo", 30), new Ingrediente("Sal", -1)};
        Plato platin1 = new Plato("Papas con Huevos", ingredientesPapasHuevos, 1, LocalTime.of(0, 30));
        misPlatos.put("Papas con huevos", platin1 );
        
        Ingrediente[] ingredientesMojito = {new Ingrediente("cucharaditas de azúcar blanco", 2), new Ingrediente("hojas de hierbabuena", 8), new Ingrediente("ml de zumo de lima", 30)
        		, new Ingrediente("ml. de ron cubano", 60), new Ingrediente("lima en rodajas o cuartos", 1/2),new Ingrediente("ml. de Soda", 120),new Ingrediente("Hielo picado", -1)};
        misPlatos.put("Cóctel Mojito", new Plato("Cóctel Mojito", ingredientesMojito, 1, LocalTime.of(0, 5)));
        
        Ingrediente[] ingredientesTartaQueso = {new Ingrediente("queso crema", 600), new Ingrediente("nata de montar", 400), new Ingrediente("huevos camperos", 6)
        		, new Ingrediente("azúcar de caña", 200), new Ingrediente("sal", 4),new Ingrediente("queso Flor de guía", 60),new Ingrediente("galleta tipo María", 200),new Ingrediente("mantequilla salada", 125)};
        misPlatos.put("Tarta de Queso", new Plato("Tarta de Queso", ingredientesTartaQueso, 5, LocalTime.of(2, 0)));
        
        Ingrediente[] ingredientesTortitas = {new Ingrediente("huevos L", 2), new Ingrediente("mantequilla sin sal", 50), new Ingrediente("leche", 250)
        		, new Ingrediente("azúcar blanco", 50), new Ingrediente("harina de trigol", 200),new Ingrediente("cucharadita de levadura en polvo", 1),new Ingrediente("cucharaditas de vainilla", 2)};
        misPlatos.put("Tortitas", new Plato("Tortitas", ingredientesTortitas, 3, LocalTime.of(0, 40)));
        
        Ingrediente[] ingredientesEnsaladaPastaPollo = {new Ingrediente("pasta corta", 150), new Ingrediente("hojas de lechuga", -1), new Ingrediente("hojas de rúcula", -1)
        		, new Ingrediente("Cebolla", 1/2), new Ingrediente("pimiento rojo", 1/2),new Ingrediente("Aceite de oliva", -1),new Ingrediente("Sal", -1),new Ingrediente("kikos triturados", -1),new Ingrediente("pechuga de pollo", 1)};
        misPlatos.put("Ensalada de pasta con pollo", new Plato("Ensalada de pasta con pollo", ingredientesEnsaladaPastaPollo, 2, LocalTime.of(0, 30)));
        
		
		
		
		//CREAR PLATO
		
		JButton btnCrearReceta = new JButton("CREAR RECETA");
		btnCrearReceta.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
		/*	
		//ESTO ES PARA GUARDARLO EN LA BASE DE DATOS EL USUARIO RECIEN CREADO
		//ESTO CREA UN OBJETO USUARIO NUEVO
			try {
							
				//PARA LA TABLA USUARIOS
				ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.85:3306/recetas","chef","chef")); //ESTO CONECTA A LA BASE DE DATOS
				//usamos
				PreparedStatement smt =
				ventana.getCon().prepareStatement("insert into platos values(?,?,?,?)"); //ESTO INSERTA LOS VALORES
							
				smt.setString(1, nombreRec);
				smt.(2, ingredientesMojito);
				smt.setInt(3, numPersonRec);
				smt.setString(4, tiempoRec);
							
				smt.executeUpdate();                                                   //HASTA AQUI SE HAN INSERTADO LOS VALORES PARA LA BASE DE DATOS
							
							
				//CREAR USUARIO
							
				Plato plat;
				
				 //String nombrePlato, Ingrediente[] ingredientes, TiposPlato tipo, int numeroPersonas,
			//LocalTime tiempo, String pasos
				 
							
				ventana.setPlato(plat=new Plato(nombreRec,ingredientesMojito,numPersonRec,tiempoRec)); //ESTO CREA EL NUEVO OBJETO USUARIO
							
				//cerramos
				
				ventana.getCon().close();
				
				ventana.irAPrincipal();
				
				//ESTE CATCH SE PONE PARA QUE NO SE PUEDA REPETIR LA CLAVE PRIMARIA, EN ESTE CASO ES EL EMAI, EN NUESTRO PROYECTO SER� EL NOMBRE DE USUARIO
			} catch (SQLIntegrityConstraintViolationException iex){
				JOptionPane.showMessageDialog(ventana, "El plato ya est� registrado, elige otro","Plato ya registrado", JOptionPane.ERROR_MESSAGE);
				
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
										}
					
						
						
						
											*/}
													});
		
		btnCrearReceta.setBounds(345, 524, 150, 37);
		add(btnCrearReceta);
					
		
        
        
        /*
        	
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime plato a ver");
        String nombre = sc.nextLine();

        Plato plato = misPlatos.get(nombre);
        if (plato == null) {
            System.out.println("Ese plato no existe");
        } else {
            System.out.println(plato);
        }
        
        */
        
	
}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
