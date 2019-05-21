package interfaces;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import componentes.Audioss;
import componentes.BotonMenu;
import componentes.MiLabel;
import javafx.embed.swing.JFXPanel;
import javax.swing.JLabel;  
  
public class EligeLoginRegistro extends JPanel{
	private Ventana ventana;
	ImageIcon imagen;
	ImageIcon imagen2;
	private boolean pausa = false;
	Audioss audio1; 
	Font font ;
	public EligeLoginRegistro(Ventana v ,String nombre) {
		super();
		//setForeground(new Color(255, 255, 255));
		//setBackground(new Color(143, 188, 143));
		//setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		this.ventana = v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		
		imagen2 = new ImageIcon(getClass().getResource(nombre));
		;
		
		
		
		 
		 /*
		String ar1 = "src/audios/Tutorial.mp3";
		Media media = new Media(new File(ar1).toURI().toString());
		MediaPlayer mp = new MediaPlayer(media);
		mp.setAutoPlay(true);
		MediaView mediaView = new MediaView(mp);
		 
		String ar2 = "src/audios/Deal.mp3";
		Media media2 = new Media(new File(ar2).toURI().toString());
		MediaPlayer mp2 = new MediaPlayer(media);
		mp2.setAutoPlay(true);
		MediaView mediaView2 = new MediaView(mp);
		*/
		
		
		JFXPanel fxPanel = new JFXPanel();
		  audio1 = new Audioss();
		
		
		
		
		
		
		  
		BotonMenu botonRegistro = new BotonMenu("Registro");
		botonRegistro.setBounds(105, 384, 269, 105);
		botonRegistro.setText("");
		botonRegistro.setBorder(new LineBorder(new Color(0, 100, 0), 15, true));
		botonRegistro.setBackground(UIManager.getColor("Tree.textBackground"));
		botonRegistro.setForeground(UIManager.getColor("Tree.textBackground"));
		botonRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				audio1.Stop();
				pausa=true;
				ventana.irARegistro();
			}
			
		});
		setLayout(null);
		add(botonRegistro);
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.setBounds(709, 372, 283, 105);
		botonLogin.setText("");
		botonLogin.setBorder(new LineBorder(new Color(0, 100, 0), 14, true));
		botonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				audio1.getMp().stop();
				pausa=true;
				ventana.irALogin();
				
			}
		});
		add(botonLogin);
		
		
		
		BotonMenu botonSonido = new BotonMenu("Sonido");
		botonSonido.setBounds(404, 372, 223, 105);
		botonSonido.setText("Sonido");
		botonSonido.setBorder(new LineBorder(new Color(0, 100, 0), 14, true));
		botonSonido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonSonido.setBorderPainted(true);
		
		
		botonSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pausa==true) {
					audio1.getMp().play();
					pausa=false;
				}else {
					audio1.getMp().stop();
					pausa=true;
				}
			      
			}
		});
		add(botonSonido);
	
		
		
		MiLabel  lblBienvenidoa = new MiLabel("Bienvenido/a", 35);
		lblBienvenidoa.setBounds(31, 11, 296, 28);
		add(lblBienvenidoa);
		
		
		
		Random random = new Random();
		try {
			String ban = "billy.ttf";
			InputStream is = getClass().getResourceAsStream(ban);
			
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception ex) {
			System.err.println("No se cargo la fuente elegida");
			font = new Font("Arial.BOLD",3,160);
		} 
		
	  
	    
	}
	


protected void paintComponent(Graphics g) {
	Dimension d = getSize();
	g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
	this.setOpaque(false);

	
	 font = font.deriveFont(1,190);
	 g.setFont(font);
	    g.setColor(Color.black);
   Random random=new Random();
    int j=270;
    for (int i = 305; i < 380; i+=12) {
		g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		g.drawString("Mmm!", i, j);
		j+=2;
	}
    
	
	super.paintComponent(g);
	
	
	
	
}
}

