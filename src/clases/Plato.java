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

    public Plato(String nombrePlato, Ingrediente[] ingredientes, int numeroPersonas,  LocalTime tiempo) {
        this.nombrePlato = nombrePlato;
        this.ingredientes = ingredientes;
        this.numeroPersonas = numeroPersonas;
        this.tiempo = tiempo;
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
