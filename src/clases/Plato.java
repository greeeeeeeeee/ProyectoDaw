/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalTime;

/**
 *
 * @author 1DAM
 */
public class Plato {
    private String nombrePlato;
    private Ingrediente[] ingredientes;
    private TiposPlato tipo;
    private int numeroPersonas;
    private LocalTime tiempo;
    private String pasos;
    
    public static String tipoPlatoToString(TiposPlato tipo) {
    	switch(tipo) {
    	case PASTA:
    		return "pasta";
    		
    	}
    	return null;
    }

   

    public Plato(String nombrePlato, Ingrediente[] ingredientes, TiposPlato tipo, int numeroPersonas,
			LocalTime tiempo, String pasos) {
		super();
		this.nombrePlato = nombrePlato;
		this.ingredientes = ingredientes;
		this.tipo = tipo;
		this.numeroPersonas = numeroPersonas;
		this.tiempo = tiempo;
		this.pasos = pasos;
	}

    

	/**
	 * @return the tipo
	 */
	public TiposPlato getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TiposPlato tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the pasos
	 */
	public String getPasos() {
		return pasos;
	}


	/**
	 * @param pasos the pasos to set
	 */
	public void setPasos(String pasos) {
		this.pasos = pasos;
	}


	public String getNombrePlato() {
        return nombrePlato;
    }

    public Ingrediente[] getIngredientes() {
    	
    	
        return ingredientes;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }
    
}
