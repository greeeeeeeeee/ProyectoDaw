package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;


import clases.Ingrediente;
import clases.Plato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recetas extends JPanel {
	private Ventana ventana;
	ImageIcon imagen;
	public Recetas thisRef;
	
	
	public Recetas (Ventana v,String nombre) {
		super();
		thisRef=this;
		this.ventana=v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(840,552);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 855, 503);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDelPlato = new JLabel("Nombre del Plato:");
		lblNombreDelPlato.setForeground(Color.WHITE);
		lblNombreDelPlato.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblNombreDelPlato.setBounds(27, 24, 157, 27);
		panel.add(lblNombreDelPlato);
		
		
		// NOMBRE REC
		JTextField campoNombre = new JTextField();
		campoNombre.setBounds(194, 30, 387, 20);
		panel.add(campoNombre);
		campoNombre.setColumns(10);
		
		
		//PASOS
		
		JTextArea textAreaPasos = new JTextArea();
		textAreaPasos.setBounds(27, 281, 787, 211);
		panel.add(textAreaPasos);
		
		JLabel lblPasos = new JLabel("Pasos");
		lblPasos.setBackground(Color.BLACK);
		lblPasos.setForeground(Color.WHITE);
		lblPasos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblPasos.setBounds(27, 243, 145, 33);
		panel.add(lblPasos);
		
		
		//NUM PERSONAS
		
		JTextField personas = new JTextField();
		personas.setBounds(295, 75, 40, 27);
		panel.add(personas);
		personas.setColumns(10);
		
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
		
		JTextField minPlat = new JTextField();
		minPlat.setColumns(10);
		minPlat.setBounds(541, 75, 40, 27);
		panel.add(minPlat);
		
		JTextField hourPlat = new JTextField();
		hourPlat.setColumns(10);
		hourPlat.setBounds(491, 75, 40, 27);
		panel.add(hourPlat);
		
		
		//INGREDIENTES
		
		List listIngredientes = new List();
		listIngredientes.setBounds(349, 139, 232, 123);
		panel.add(listIngredientes);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblIngredientes.setBounds(349, 108, 100, 33);
		panel.add(lblIngredientes);
		
		
		//GUSTOS
		
		JLabel lblGustos = new JLabel("Reloj");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblGustos.setBounds(27, 72, 64, 27);
		panel.add(lblGustos);
		
		JButton buttonReloj = new JButton("+");
		buttonReloj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//VENTANA GUSTOS
				Ventana modGustos = new Ventana("Temporizador");
				modGustos.setResizable(true);
				
			}
		});
		buttonReloj.setBounds(95, 75, 89, 27);
		panel.add(buttonReloj);
		
		
		//IMAGEN
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblImagen.setBounds(27, 127, 64, 27);
		panel.add(lblImagen);
		
		JButton btnElegirImagen = new JButton("Ver");
		btnElegirImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ventana modGustos = new Ventana("Imagen");
				modGustos.setResizable(true);
			}
		});
		btnElegirImagen.setBounds(95, 132, 89, 23);
		panel.add(btnElegirImagen);
		
		
		//VIDEO
		
		JLabel lblVideo = new JLabel("Video");
		lblVideo.setForeground(Color.WHITE);
		lblVideo.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblVideo.setBounds(27, 181, 64, 27);
		panel.add(lblVideo);
		
		JButton btnAadir = new JButton("Play");
		btnAadir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAadir.setBounds(95, 186, 89, 23);
		panel.add(btnAadir);
		
		
		
		
		
		
		//LocalTime tiempoRec = LocalTime.of(horasRec,minutosRec);
		
		
		
//---------------- Platos creados
        
        HashMap<String, Plato> misPlatos = new HashMap<String, Plato>();
        Ingrediente[] ingredientesPapasHuevos = {new Ingrediente("Patata", 500), new Ingrediente("Huevo", 30), new Ingrediente("Sal", -1)};
        misPlatos.put("Papas con huevos", new Plato("Papas con Huevos", ingredientesPapasHuevos, 1, LocalTime.of(0, 30)));
        
        /*
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
		*/
		
		
		
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				ventana.irALista();
			}
		});
		
		botonAtras.setBounds(289, 506, 112, 35);
		add(botonAtras);
		
		
		
		JButton btnVer = new JButton("MODIFICAR");
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irANuevasRecetas();
			}
		});
		btnVer.setBounds(408, 506, 112, 35);
		add(btnVer);
		
		String clave;
	    Iterator<String> nombrecillos = misPlatos.keySet().iterator();
	  
	    while(nombrecillos.hasNext()){
	    	clave = nombrecillos.next();
	    	campoNombre.setText(misPlatos.get(clave).getNombrePlato());
	    	
	    	personas.setText(Integer.toString(misPlatos.get(clave).getNumeroPersonas()));
	    	
	    }  
		
	    campoNombre.setEditable(false);
		personas.setEditable(false);
		textAreaPasos.setEditable(false);
		hourPlat.setEditable(false);
		minPlat.setEditable(false);
	}
	private String copyValueOf(int numeroPersonas) {
		// TODO Auto-generated method stub
		return null;
	}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
