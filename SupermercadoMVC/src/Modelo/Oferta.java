/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author NotebookSFC
 */
public class Oferta 
{
    private int idOferta;
    private double precioNormal;
    private double precioOferta;
    private int stockDisponible;
    private String fechaInicioOferta;
    private int diasVigencia;
    private Producto producto;

    public Oferta(int idOferta, double precioNormal, double precioOferta, int stockDisponible, String fechaInicioOferta, int diasVigencia, Producto producto) {
        this.idOferta = idOferta;
        this.producto = producto;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.stockDisponible = stockDisponible;
        this.fechaInicioOferta = fechaInicioOferta;
        this.diasVigencia = diasVigencia;
        
    }
    
    public Oferta(){};

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }


    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public String getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public void setFechaInicioOferta(String fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Oferta{" + "idOferta=" + idOferta + ", precioNormal=" + precioNormal + ", precioOferta=" + precioOferta + ", stockDisponible=" + stockDisponible + ", fechaInicioOferta=" + fechaInicioOferta + ", diasVigencia=" + diasVigencia + ", producto=" + producto + '}';
    }
    
     


    
    
    
}
