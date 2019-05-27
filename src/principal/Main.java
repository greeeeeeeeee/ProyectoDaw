package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.ContraseniaCortaException;
import clases.Ingrediente;
import clases.Plato;
import clases.TiposPlato;
import clases.Usuario;
import interfaces.Ventana;


public class Main {
	
	 public static void main(String[] args) throws InterruptedException, ContraseniaCortaException {
        Ventana principal = new Ventana();
        

        /*
      //---crear usuarios con gustos
        ArrayList<TiposPlato> gustos1;
        gustos1 = new ArrayList<TiposPlato>();
        Usuario usuarioGusto = new Usuario(, contraseniaRegis, gustos1);
        
         */ 
         
        /*
        //---------crear usuario
        
        System.out.println("Inicio de registro de usuario-----------------------------------\n");
        
        System.out.println("Introduce el nombre de registro");
        String nombreRegis = leerTexto();
        System.out.println("Introduce la contraseña de registro");
        String contraseniaRegis = leerTexto();
        
        Usuario usuario1 = new Usuario(nombreRegis, contraseniaRegis);
        System.out.println("-----------------------------------Registro completado con exito!\n");

        //-------------------guardar usuarios creados en fichero y añadir usuarios desde el archivo
        
        // Nos creamos un ArrayList de objetos de la Clase Usuario
        System.out.println("\n Creamos un ArrayList de objetos de la Clase Usuario");
      
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
          Thread.sleep(1000);       //por si tarda
        // Instanciamos el fichero
        File fichero = new File("./listausu.txt");
        Scanner s = null;
        try {
            fichero.createNewFile();  //es mejor ioexception o try catch??
            FileWriter escritor = new FileWriter(fichero, true);    //true para no sobreescribir
            escritor.write("\n"+usuario1.getNombre()+"::"+usuario1.getContrasenia());
            //escritor.write("\n");
            //PROBLEMA DE QUE ESCRIBE EN LA MISMA LINEA !!!!!
            escritor.flush();
            escritor.close();
            
            // Leemos el contenido del fichero
	System.out.println("Leemos el contenido del fichero...");
	s = new Scanner(fichero);
	// Obtengo los datos 
	while (s.hasNextLine()){
		String linea = s.nextLine();	// Obtengo una linea del fichero 
		String [] cortarString = linea.split("::");		// separa un string en dos a partir de ::
		Usuario users = new Usuario(cortarString[0],cortarString[1]);	// Creo un objeto de la clase "Usuario"

		// Añadimos el objeto "users" al ArrayList
		listaUsuarios.add(users);
	}


        } catch (IOException ex) {
            
        }finally{
            try {
		if (s != null)
			s.close();      //cerrar lectura para que no pase como gta
	} catch (Exception e2) {
		        System.out.println("No hay nada que cerrar");
	}
        }
        System.out.println("... Guardados "+listaUsuarios.size()+" usuarios.\n");
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(listaUsuarios.get(i));
        }
        
        System.out.println("los usuarios registrado: ");
        Iterator<Usuario> itrRegistrados = listaUsuarios.iterator();
        while(itrRegistrados.hasNext()){
	Usuario users = itrRegistrados.next();
	System.out.println(users.getNombre() + " "
			+ users.getContrasenia() );
}
        
        //----------------- login usuario
        
        String nombre1 = "";
        String password1 = "";
        //boolean encontrado = true;        POSIBLE VARIABLE PARA EL WHILE DE ABAJO
        //SERIA MEJOR COMPARAR CON UN IF EL NOMBRE Y PASSWORD Y SI COINCIDEN PONER TRUE EL BOOLEAN??
        System.out.println("Inicio del login de usuario-----------------------------------\n");
        boolean loginok=false;
        do {
            System.out.println("Introduce tu nombre de usuario");
            nombre1 = leerTexto();
            System.out.println("Introduce la contraseña");
            password1 = leerTexto();
            
            Iterator buscaLogin=listaUsuarios.iterator();
            while (buscaLogin.hasNext()) {
               Usuario comparado=(Usuario)buscaLogin.next();
               loginok=true;
               //si el nombre y la contraseña de comparado es igual nombre1 y password1: loginok=true; break;
            }
            
        } while (!loginok);
        System.out.println("-----------------------------------Login completado con exito!\n");
        
         */
        
        
    }
	 /*
    public static String leerTexto() {
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        return nombre;

    

}*/
 
}
