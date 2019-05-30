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
	private boolean pausa ;
	
	Font font ;
	public EligeLoginRegistro(Ventana v ,String nombre) {
		super();
		//setForeground(new Color(255, 255, 255));
		//setBackground(new Color(143, 188, 143));
		//setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		this.ventana = v;
		imagen = new ImageIcon(getClass().getResource(nombre));
		JFXPanel fxPanel = new JFXPanel();
		 /*
		  * imagen2 = new ImageIcon(getClass().getResource(nombre));
		;
		  * 
		  * 
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
		
		
		
		
		  
		BotonMenu botonRegistro = new BotonMenu("Registro");
		botonRegistro.setBounds(78, 384, 296, 121);
		botonRegistro.setText("");
		botonRegistro.setBorder(null);
		botonRegistro.setBackground(UIManager.getColor("Tree.textBackground"));
		botonRegistro.setForeground(UIManager.getColor("Tree.textBackground"));
		botonRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.getAudiPri().getMp().stop();
				//pausa=true;
				ventana.irARegistro();
			}
			
		});
		setLayout(null);
		add(botonRegistro);
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.setBounds(709, 372, 283, 105);
		botonLogin.setText("");
		botonLogin.setBorder(null);
		botonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				//pausa=true;
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
					ventana.getAudiPri().getMp().play();
					pausa=false;
				}else {
					ventana.getAudiPri().getMp().pause();
					pausa=true;
				}
			      
			}
		});
		add(botonSonido);
	
		
		
		MiLabel  lblBienvenidoa = new MiLabel("Bienvenido/a", 35);
		lblBienvenidoa.setText("Bienvenido/a!");
		lblBienvenidoa.setFont(new Font("DialogInput", Font.BOLD, 40));
		lblBienvenidoa.setForeground(Color.BLUE);
		lblBienvenidoa.setBounds(367, 260, 428, 51);
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
	 
	int color1a = 187;
	int color1b = 36;
	int color1c = 92;
	//nranja rgb 246, 179, 126  
	int color2a =246;
	int color2b = 179;
	int color2c = 126;
	
	 font = font.deriveFont(1,160);
	 g.setFont(font);
	    g.setColor(Color.black);
   Random random=new Random();
    int j=260;//altura letra
    boolean cambio = true;
    for (int i = 210; i < 230; i+=12) {
		if(cambio==true) {
			g.setColor(new Color(color1a,color1b,color1c));
			g.drawString("Mmm!", i, j);
			j+=2;
			cambio=false;
		}else {
			g.setColor(new Color(color2a,color2b,color2c));
			g.drawString("Mmm!", i, j);
			j+=2;
			cambio=true;
		}
    	
	}
    
	
	super.paintComponent(g);
	
	
	
	
}
}

