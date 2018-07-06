/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.test.entities;

/**
 *
 * @author merlinh
 */
public class Persona {
    
    private int id, valor_max;
    private String nombre;
    private double tasa;
    
    public Persona(int id, String nombre, double tasa, int valor_max){
        this.id = id;
        this.nombre = nombre;
        this.tasa = tasa;
        this.valor_max = valor_max;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the valor_max
     */
    public int getValor_max() {
        return valor_max;
    }

    /**
     * @param valor_max the valor_max to set
     */
    public void setValor_max(int valor_max) {
        this.valor_max = valor_max;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the tasa
     */
    public double getTasa() {
        return tasa;
    }
    
}
