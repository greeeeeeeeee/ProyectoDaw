/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 1DAM
 */
public class Ingrediente {
    private String nombre;
    private int gramosPersona;

    public Ingrediente(String nombre, int gramosPersona) {
        this.nombre = nombre;
        this.gramosPersona = gramosPersona;
    }
    
    public Ingrediente(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getGramosPersona() {
        return gramosPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGramosPersona(int gramosPersona) {
        this.gramosPersona = gramosPersona;
    }
    
}