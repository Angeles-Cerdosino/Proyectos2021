/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * ListaServiciosSrvlt
 * @author NotebookSFC
 */
public class Servicio {
    private int id;
    private Tipo tipo;
    private String descripcion;
    private double costo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Servicio(int id, Tipo tipo, String descripcion, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    public Servicio () {}

    @Override
    public String toString() {
        return  id + tipo.getDescripcionT() + descripcion + costo;
    }

  
    
    
    
}
