package clases;


import java.util.ArrayList;
import java.util.Scanner;



public class Usuario {
	private String nombre;
	private String contrasenia;
	private String email;
    private ArrayList<TiposPlato> gustos;
	
	
	
	public Usuario(String nombre, String contrasenia,  String email) throws ContraseniaCortaException, NombreCortoException {
		super();
		this.nombre = nombre;
		this.setContrasenia(contrasenia);
		this.setNombre(nombre);
		this.email = email;
	}
	
	
	public Usuario(String nombre, String contrasenia, String email,ArrayList<TiposPlato> gustos) throws ContraseniaCortaException, NombreCortoException {
        super();
		this.nombre = nombre;
		this.setContrasenia(contrasenia);
		this.setNombre(nombre);
		this.email = email;
        this.gustos = gustos;
    }

    

	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreCortoException {
        while (nombre.length() > 30 || nombre.length() < 6) {
            System.out.println("Nombre usuario no válido, introduce un nombre de entre 6 y 30 carácteres");
            nombre = leerTexto();
            throw new NombreCortoException("El nombre es incorrecto ");
        }
        this.nombre = nombre;
    }
	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	
	public void setContrasenia(String contrasenia) throws ContraseniaCortaException {
        while (contrasenia.length() > 30 || contrasenia.length() < 6 || contrasenia.equals(nombre)) {
            if (contrasenia.length() > 30 || contrasenia.length() < 6) {
            	System.out.println("Contrasenia no válida, introduce una contraseña de entre 6 y 30 carácteres");
                contrasenia = leerTexto();
            	throw new ContraseniaCortaException("La contraseña es incorrecta ");
                
            } else if (contrasenia.equals(nombre)) {
                System.out.println("¡La contraseña y el nombre de usuario no pueden coincidir!");
                contrasenia = leerTexto();
            }

        }
        this.contrasenia = contrasenia;
    }

	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public ArrayList<TiposPlato> getGustos() {
        return gustos;
    }

    public void setGustos(ArrayList<TiposPlato> gustos) {
        this.gustos = gustos;
    }

    
	public static String leerTexto() {
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        return nombre;

    }
	


}
