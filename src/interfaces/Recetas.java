package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Recetas extends JPanel {
	private Ventana ventana;
	public Recetas (Ventana v,String nombre) {
		super();
		
		this.ventana=v;
		ventana.setSize(800,800);
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				ventana.irALista();
			}
		});
		setLayout(null);
		botonAtras.setBounds(79, 26, 59, 23);
		add(botonAtras);
		
		
		
		JButton btnVer = new JButton("MODIFICAR");
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnVer.setBounds(323, 136, 89, 23);
		add(btnVer);
		
	}
}
