package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import clases.Ingrediente;
import clases.Plato;
import clases.TiposPlato;
import clases.Usuario;

import java.awt.BorderLayout;
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
import javax.swing.WindowConstants;

public class NuevasRec extends JPanel {
	private Ventana ventana;
	ImageIcon imagen;
	public NuevasRec thisRef;
	private JTextField campoNombre;
	private JTextArea textAreaPasos;
	public Plato platin;
	public ListaRec lista;
	private Ventana modGustos;
	private JTextField textFieldIngrediente;
	private Ingrediente[] ingredientesPlato ;
	private ArrayList<TiposPlato> gustoUs;
	private JPanel panel_1;
	public Boolean botOn;
	private JCheckBox chckbxPasta;
	private JCheckBox checkBoxCoctel;
	private JCheckBox chcEnsalada;
	boolean hayNull;
	int posBorrada;
	private int indice;
	private ArrayList<Integer> arl ;
	
	public NuevasRec (Ventana v,String nombre) {
		super();
		thisRef=this;
		this.ventana=v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(984,572);
		setLayout(null);
		chckbxPasta=new JCheckBox();
		gustoUs = new ArrayList<TiposPlato>();
		checkBoxCoctel=new JCheckBox();
		chcEnsalada=new JCheckBox();
		ingredientesPlato=new Ingrediente[30];
		 hayNull = false;
		  arl = new ArrayList<Integer>();
		 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(37, 38, 612, 469);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDelPlato = new JLabel("Nombre del Plato :");
		lblNombreDelPlato.setForeground(Color.WHITE);
		lblNombreDelPlato.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		lblNombreDelPlato.setBounds(27, 24, 195, 27);
		panel.add(lblNombreDelPlato);
		
		
		// NOMBRE REC
		campoNombre = new JTextField();
		campoNombre.setBounds(275, 30, 306, 20);
		panel.add(campoNombre);
		campoNombre.setColumns(10);
		
		
		//PASOS
		
		textAreaPasos = new JTextArea();
		textAreaPasos.setBounds(27, 280, 554, 165);
		panel.add(textAreaPasos);
		
		JLabel lblPasos = new JLabel("Pasos");
		lblPasos.setBackground(Color.BLACK);
		lblPasos.setForeground(Color.WHITE);
		lblPasos.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblPasos.setBounds(257, 236, 145, 33);
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
		labelTiempoCoc.setFont(new Font("Banana Yeti", Font.BOLD, 22));
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
		listIngredientes.setBounds(455, 127, 126, 85);
		panel.add(listIngredientes);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		lblIngredientes.setBounds(275, 113, 112, 33);
		panel.add(lblIngredientes);
		
		
		//GUSTOS
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(648, 38, 260, 469);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		botOn=true;
		
		
		JLabel lblGustos = new JLabel("Gustos");
		lblGustos.setForeground(Color.WHITE);
		lblGustos.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		lblGustos.setBounds(27, 72, 64, 27);
		panel.add(lblGustos);
		
		JButton buttonGustos = new JButton("+");
		
		
		
		buttonGustos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//VENTANA GUSTOS
				if(botOn==false) {
					//modGustos.setVisible(false);
					panel_1.setVisible(false);
					buttonGustos.setText("+");
					//modGustos=null;
					botOn=true;
					
				}else {
					
					//modGustos = new Ventana("Gustos");
					 
					panel_1.setVisible(true);
					buttonGustos.setText("-");
					
					JLabel lblTipPla = new JLabel("Tipo de plato");
					lblTipPla.setFont(new Font("Banana Yeti", Font.BOLD, 25));
					lblTipPla.setForeground(Color.WHITE);
					lblTipPla.setBounds(10, 21, 173, 31);
					panel_1.add(lblTipPla);
					
					 chckbxPasta = new JCheckBox("Pasta");
					chckbxPasta.setBackground(Color.BLACK);
					chckbxPasta.setForeground(Color.WHITE);
					chckbxPasta.setFont(new Font("Consolas", Font.BOLD, 18));
					chckbxPasta.setBounds(16, 70, 75, 23);
					panel_1.add(chckbxPasta);
					
					checkBoxCoctel = new JCheckBox("Cóctel");
					checkBoxCoctel.setForeground(Color.WHITE);
					checkBoxCoctel.setFont(new Font("Consolas", Font.BOLD, 18));
					checkBoxCoctel.setBackground(Color.BLACK);
					checkBoxCoctel.setBounds(16, 120, 85, 23);
					panel_1.add(checkBoxCoctel);
					
					chcEnsalada = new JCheckBox("Ensalada");
					chcEnsalada.setBackground(Color.BLACK);
					chcEnsalada.setFont(new Font("Consolas", Font.BOLD, 18));
					chcEnsalada.setForeground(Color.WHITE);
					chcEnsalada.setBounds(16, 170, 115, 23);
					panel_1.add(chcEnsalada);
					
					/*
					JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
					chckbxNewCheckBox.setBounds(10, 69, 97, 23);
					panel_1.add(chckbxNewCheckBox);*/
					
					
					//modGustos.setVisible(true);
					//modGustos.getContentPane().add(chckbxPasta);
					
					
					
					//modGustos.setBounds(700, 100, 300, 300);
					//modGustos.setSize(300, 300);
					
					
					
					
					botOn=false;
					/*modGustos.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent arg0) {
							buttonGustos.setText("+");
							
						}
					});*/
				}
				
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
		lblImagen.setFont(new Font("Banana Yeti", Font.BOLD, 25));
		lblImagen.setBounds(27, 127, 64, 27);
		panel.add(lblImagen);
		
		JButton btnElegirImagen = new JButton("Elegir");
		btnElegirImagen.setEnabled(false);
		btnElegirImagen.setBounds(95, 132, 89, 27);
		panel.add(btnElegirImagen);
		
		
		//VIDEO
		
		JLabel lblVideo = new JLabel("Video");
		lblVideo.setForeground(Color.WHITE);
		lblVideo.setFont(new Font("Banana Yeti", Font.BOLD, 20));
		lblVideo.setBounds(27, 181, 64, 27);
		panel.add(lblVideo);
		
		JButton btnAVideo = new JButton("Añadir");
		btnAVideo.setEnabled(false);
		btnAVideo.setBounds(95, 185, 89, 27);
		panel.add(btnAVideo);
		
		textFieldIngrediente = new JTextField();
		textFieldIngrediente.setBounds(275, 150, 89, 27);
		panel.add(textFieldIngrediente);
		textFieldIngrediente.setColumns(10);
		
		JSpinner spinnerGramos = new JSpinner();
		spinnerGramos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGramos.setBounds(275, 184, 40, 27);
		panel.add(spinnerGramos);
		
		JLabel lblGr = new JLabel("gr.");
		lblGr.setForeground(Color.WHITE);
		lblGr.setFont(new Font("Banana Yeti", Font.BOLD, 30));
		lblGr.setBounds(325, 181, 46, 31);
		panel.add(lblGr);
		indice=0;
		
		
		JButton btnAddIngre = new JButton("-->");
		btnAddIngre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textFieldIngrediente.getText()!="" && (Integer)spinnerGramos.getValue()>0) {
					if(hayNull==true) {
						listIngredientes.add(textFieldIngrediente.getText()+" - "+ (Integer)spinnerGramos.getValue());
						
						if(!arl.isEmpty()) {
							ingredientesPlato[arl.get(0)]= new Ingrediente(textFieldIngrediente.getText(), (Integer)spinnerGramos.getValue());
							arl.remove(0);
							
						}
						
						if(arl.isEmpty()) {
							hayNull=false;
							
						}
						textFieldIngrediente.setText("");
						spinnerGramos.setValue(0);
						
					}else {
						listIngredientes.add(textFieldIngrediente.getText()+" - "+ (Integer)spinnerGramos.getValue());
						
						 ingredientesPlato[indice]= new Ingrediente(textFieldIngrediente.getText(), (Integer)spinnerGramos.getValue());
						 indice++;
						textFieldIngrediente.setText("");
						spinnerGramos.setValue(0);
					}
					
				}else {
					JOptionPane.showMessageDialog(ventana, "Añade nombre y cantidad", "Error: ingrediente incompleto",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAddIngre.setBounds(385, 150, 51, 27);
		panel.add(btnAddIngre);
		
		JButton btnDelIngre = new JButton("X");
		btnDelIngre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(arl.size()>=ingredientesPlato.length) {
					JOptionPane.showMessageDialog(ventana, "Reseteo de ingredientes", "Logro Borrador Masivo +30",
							JOptionPane.INFORMATION_MESSAGE);
					indice=0;
					listIngredientes.removeAll();
					hayNull=false;
					arl.clear();
					ingredientesPlato=null;
					ingredientesPlato=new Ingrediente[30];
					textFieldIngrediente.setText("");
					spinnerGramos.setValue(0);
				}else {
					if(listIngredientes.getSelectedIndex()!=-1) {
						//ingredientesPlato[listIngredientes.getSelectedIndex()]= null;
						posBorrada=listIngredientes.getSelectedIndex();
						listIngredientes.remove(listIngredientes.getSelectedIndex());
						hayNull=true;
						arl.add(posBorrada);
						textFieldIngrediente.setText("");
						spinnerGramos.setValue(0);
						
					}
				}
				
				
				
			}
		});
		btnDelIngre.setBounds(385, 184, 51, 27);
		panel.add(btnDelIngre);
		
		
		
		
		
//---------------- Platos creados
        /*
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
        
        
        Ingrediente[] ingredientesEnsaladaPastaPollo = {new Ingrediente("pasta corta", 150), new Ingrediente("hojas de lechuga", -1), new Ingrediente("hojas de rúcula", -1)
        		, new Ingrediente("Cebolla", 1/2), new Ingrediente("pimiento rojo", 1/2),new Ingrediente("Aceite de oliva", -1),new Ingrediente("Sal", -1),new Ingrediente("kikos triturados", -1),new Ingrediente("pechuga de pollo", 1)};
        misPlatos.put("Ensalada de pasta con pollo", new Plato("Ensalada de pasta con pollo", ingredientesEnsaladaPastaPollo, 2, LocalTime.of(0, 30)));
        
		*/
		
		if(ventana.getRec()!=null) {
			campoNombre.setText(ventana.getRec().getPlatin().getNombrePlato());
		}
		
		JButton btnCrearReceta = new JButton("CREAR RECETA");
		btnCrearReceta.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			try {
							
				
				
				
				String nombreRec = campoNombre.getText();
				String pasosRec = textAreaPasos.getText();
				Integer numPersonRec = (Integer)spinnerPersonas.getValue();
				Integer minutosRec = (Integer)spinnerMinutos.getValue();
				Integer horasRec = (Integer)spinnerHoras.getValue();
				if(minutosRec==60) {
					minutosRec=0;
					horasRec+=1;
				}
				//String minutitos = String.valueOf(horasRec);
				//String hora = String.valueOf(minutosRec);
				
				
				//convert String to LocalTime
				
				LocalTime tiempoRec = LocalTime.of(horasRec,minutosRec);
				if(chckbxPasta.isSelected()) {
					gustoUs.add(TiposPlato.PASTA);
				}
				if(checkBoxCoctel.isSelected()) {
					gustoUs.add(TiposPlato.CÓCTELES);
				}
				if(chcEnsalada.isSelected()) {
					gustoUs.add(TiposPlato.ENSALADA);
				}
					
				if(!nombreRec.equals("") && !pasosRec.equals("") && numPersonRec>0 && (minutosRec>0 || horasRec>0) ) {
					if(!gustoUs.isEmpty()) {
						
						
						///DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
						//String tiempo = LocalTime.parse(tiempoRec, formatter);
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.112:3306/recetas","chef","chef")); 
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into receta_plato values(?,?,?,?,?,?,?)"); //ESTO INSERTA LOS VALORES
									
						smt.setString(1, nombreRec);
						String todosIngre="";
						for (int i = 0; i < indice; i++) {
							todosIngre+=ingredientesPlato[i].getNombre()+"-"+ingredientesPlato[i].getGramosPersona()+"gr.\n";
						}
						String todosGustos="";
						smt.setString(2, todosIngre);
						for (int i = 0; i < gustoUs.size(); i++) {
							todosGustos+=gustoUs.get(i).toString()+"\n";
						}
						smt.setString(3, todosGustos);
						smt.setInt(4, numPersonRec);
						smt.setString(5, tiempoRec.toString());
						smt.setString(6,pasosRec );
						smt.setString(7, ventana.getLista().getNombreUsuario());			
						smt.executeUpdate();                                                   //HASTA AQUI SE HAN INSERTADO LOS VALORES PARA LA BASE DE DATOS
									
						//PARA añadir en bd necesitamos los campo:  String nombrePlato (String), Ingrediente[] ingredientes (String) , TiposPlato tipo (string), int numeroPersonas int ,LocalTime tiempo string , String pasos string, usuario string		
						//cerramos
						
						ventana.getCon().close();
						
						JOptionPane.showMessageDialog(ventana, "Receta creada", "vuelve a la lista para ver el plato",
								JOptionPane.INFORMATION_MESSAGE);
						campoNombre.setText("");
						textAreaPasos.setText("");
						spinnerPersonas.setValue(0);
						spinnerMinutos.setValue(0);
						spinnerHoras.setValue(0);
						listIngredientes.removeAll();
						ingredientesPlato= null;
						gustoUs.clear();
						}else {
							JOptionPane.showMessageDialog(ventana, "Añade algún gusto", "Error: poco Gusto",
									JOptionPane.ERROR_MESSAGE);
						}
				}else {
					JOptionPane.showMessageDialog(ventana, "Porfavor, rellene todos los campos", "Error: campo vacío",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
										}
					
						
						
						
											}
													});
		
		btnCrearReceta.setBounds(345, 524, 150, 37);
		add(btnCrearReceta);
					
		JButton botonAtras = new JButton("Ir a lista");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
				textAreaPasos.setText("");
				spinnerPersonas.setValue(0);
				spinnerMinutos.setValue(0);
				spinnerHoras.setValue(0);
				listIngredientes.removeAll();
				ingredientesPlato= null;
				ingredientesPlato=new Ingrediente[30];
				gustoUs.clear();
				if(ventana.getRec()!=null) {
					ventana.getRec().setPlatin(null);
				}
				
				ventana.irALista(ventana.getLista().getNombreUsuario());
			}
		});
		botonAtras.setBounds(200, 524, 127, 37);
		add(botonAtras);
		
		
        
        /*
         * 
         * JScrollPane jsp = new JScrollPane(); //SCROLLPANE ES PARA QUE SALGA LA BARRA DE DESPLAZAMIENTO POR SI ESCRIBES FUERA DE LA PANATALLA
		jsp.setViewportView(textArea);
		
		 
		 add(jsp, BorderLayout.CENTER); //A�ADE EL TEXT AREA DENTRO DEL SCROLLPANE
        	
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
