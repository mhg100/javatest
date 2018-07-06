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
public class Cotizacion {
    
    private final int monto, valor_max;
    private final String socio;
    private final double cuota_mensual, valor_final, tasa;
    
    public Cotizacion(
            int monto, String socio, 
            double cuota_mensual, 
            double valor_final, 
            double tasa, 
            int valor_max
    ){
        this.cuota_mensual = cuota_mensual;
        this.monto = monto;
        this.socio = socio;
        this.tasa = tasa;
        this.valor_final = valor_final;
        this.valor_max = valor_max;
    }

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @return the valor_max
     */
    public int getValor_max() {
        return valor_max;
    }

    /**
     * @return the socio
     */
    public String getSocio() {
        return socio;
    }

    /**
     * @return the cuota_mensual
     */
    public double getCuota_mensual() {
        return cuota_mensual;
    }

    /**
     * @return the valor_final
     */
    public double getValor_final() {
        return valor_final;
    }

    /**
     * @return the tasa
     */
    public double getTasa() {
        return tasa;
    }
    
}
