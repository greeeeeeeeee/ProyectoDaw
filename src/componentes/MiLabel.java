package componentes;

import java.awt.Font;

import javax.swing.JLabel;

public class MiLabel extends JLabel {
	
	public MiLabel(String txt, int fontSize) {
		super(txt);
		this.setFont(new Font("Lucida Fax", Font.BOLD, fontSize));
		this.setHorizontalAlignment(CENTER);
	}
	
	//CONSTRUCTOR CON TAMAÑO DE FUENTE FIJO (16)
	public MiLabel(String txt) {
		super(txt);
		this.setFont(new Font("Lucida Fax", Font.BOLD,16));
		this.setHorizontalAlignment(CENTER);
	}

}
