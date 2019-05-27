package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Ingrediente;
import clases.Plato;

import java.awt.Font;

public class ListaRec extends JPanel {
private Ventana ventana;

ImageIcon imagen;
private JTextField textFieldBuscador;
	public ListaRec (Ventana v,String nombre) {
		super();
		this.ventana=v;
		//ventana.setSize(800,800);
		imagen = new ImageIcon(getClass().getResource(nombre));
		
		JList list = new JList();
		list.setBounds(140, 141, 777, 285);
		DefaultListModel modelo = new DefaultListModel();
		
		
		//TODO
		HashMap<String , Plato> misPlatos = new HashMap<String, Plato>();
		Ingrediente[] ingredientesPapasHuevos = {new Ingrediente("Patata", 500), new Ingrediente("Huevo", 30), new Ingrediente("Sal", -1)};
        misPlatos.put("Papas con huevos", new Plato("Papas con Huevos", ingredientesPapasHuevos, 1, LocalTime.of(0, 30)));
        
		
        String clave;
	    Iterator<String> nombrecillos = misPlatos.keySet().iterator();
	    
	    while(nombrecillos.hasNext()){
	    	clave = nombrecillos.next();
	    	modelo.addElement(misPlatos.get(clave).getNombrePlato());
	        
	    }  
	    modelo.addElement("Papas con huevos");
	    modelo.addElement("Prueba");
        list.setModel(modelo);
        add(list);
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.setBounds(54, 22, 71, 33);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				ventana.irALogin();
			}
		});
		setLayout(null);
		add(botonAtras);
		
		JButton btnAnadir = new JButton("CREAR RECETA");
		btnAnadir.setBounds(582, 474, 136, 38);
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irANuevasRecetas();
			}
		});
		add(btnAnadir);
		
		JButton btnVer = new JButton("VER RECETA");
		btnVer.setBounds(441, 474, 109, 38);
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAReceta();
			}
		});
		add(btnVer);
		
		JButton btnNewButton = new JButton("Modificar Login");
		btnNewButton.setBounds(149, 27, 136, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				ventana.irALoginGustosMod();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
		
		
		
		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Banana Yeti", Font.BOLD, 27));
		lblBuscador.setBounds(500, 59, 166, 38);
		add(lblBuscador);
		
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(604, 72, 313, 22);
		add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		
	}
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
}
