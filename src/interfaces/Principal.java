package interfaces;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import componentes.MiLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JPanel{
	
	private Ventana ventana;
	
	
	public Principal(Ventana v) {
		super();
		setLayout(null);
		
		ventana = v;
		MiLabel lblHola = new MiLabel("Hola,"+ventana.getUsuario().getNombre(),30);
		lblHola.setBounds(10, 21, 417, 39);
		add(lblHola);
		
		MiLabel lblNewLabel = new MiLabel(ventana.getUsuario().getEmail()+", "+ventana.getUsuario());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(0, 71, 420, 39);
		add(lblNewLabel);
		
		//TODO ESTE PUTO CODIGO ES PARA  HACER UN PANEL DONDE APAREZCAN LOS DATOS DE LOS USUARIOS
		//PODRIAMOS APLICARLO PARA DIETAS O RECETAS O CUALQUIER OTRO TIPO DE DATO
		
		
		ScrollPane jsp = new ScrollPane();//A�ADIMOS PRIMERO UN SCROLL
		JPanel listaUsuarios = new JPanel(); //LUEGO HACEMOS UN PANEL
		listaUsuarios.setBackground(Color.WHITE);//COLOR DEL PANEL
		jsp.setBounds(10, 144, 419, 156);//POSICION DEL SCROLL
		jsp.add(listaUsuarios);//DENTRO DEL SCROLL. METEMOS EL PANEL
		add(jsp);//NO SE PA Q ES
		listaUsuarios.setLayout(new GridLayout(0, 1, 0, 0)); //ESTO SE PONE PARA QUE PUEDA SALIR EN ORDEN EL LISTADO DE TODOS LOS USUARIOS DE LA BD
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.irALogin();
			}
		});
		btnLogin.setBounds(351, 37, 89, 23);
		add(btnLogin);
		this.ventana.setSize(450, 300);
		//AQUI VAMOS A LISTAR TODOS LOS USUARIOS
		try {
			ventana.setCon(DriverManager.getConnection("\"jdbc:mysql://192.168.1.68:3306/recetas","chef","chef"));//CONECTAMOS A BASE DE DATOS
			
			Statement smt = ventana.getCon().createStatement();//NO SE PA Q 
			ResultSet rs = smt.executeQuery("select * from usuarios");//LLAMAMOS A TODOS LOS ELEMENTOS DE LA TABLA USUARIO
			
			while (rs.next()) {//BUCLE WHILE PARA QUE RECUPERE TODOS LOS USUARIOS HASTA QUE NO HAYA MAS
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				
				
				listaUsuarios.add(new JLabel(nombre+" : "+email));//EN EL PANEL LISTAUSUARIOS, SE A�ADEN EL NOMBRE Y EMAIL DE TODOS LOS USUARIOS
			}
			
			
			ventana.getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setVisible(true);;
	}
}
