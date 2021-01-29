/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author NotebookSFC
 */
public class DTOProducto 
{
    private String nombre;
    private int precioNormal;
    private int PrecioOferta;
    private int diasVigencia;

    public DTOProducto(String nombre, int precioNormal, int PrecioOferta, int diasVigencia) {
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.PrecioOferta = PrecioOferta;
        this.diasVigencia = diasVigencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(int precioNormal) {
        this.precioNormal = precioNormal;
    }

    public int getPrecioOferta() {
        return PrecioOferta;
    }

    public void setPrecioOferta(int PrecioOferta) {
        this.PrecioOferta = PrecioOferta;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }
    
    
    
    
}
