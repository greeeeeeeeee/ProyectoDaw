package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ListaRec extends JPanel {
private Ventana ventana;

	public ListaRec (Ventana v,String nombre) {
		super();
		
		this.ventana=v;
		ventana.setSize(800,800);
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				ventana.irALogin();
			}
		});
		setLayout(null);
		botonAtras.setBounds(79, 26, 59, 23);
		add(botonAtras);
		
		JButton btnAnadir = new JButton("+ PLATOS");
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAnadir.setBounds(186, 266, 89, 23);
		add(btnAnadir);
		
		JButton btnVer = new JButton("VER RECETA");
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnVer.setBounds(323, 136, 89, 23);
		add(btnVer);
		
	}
}
