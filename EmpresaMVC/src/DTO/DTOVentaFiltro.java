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
public class DTOVentaFiltro 
{
    private String cliente;
    private String producto;
    private double importeTotal;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public DTOVentaFiltro(String cliente, String producto, double importeTotal) {
        this.cliente = cliente;
        this.producto = producto;
        this.importeTotal = importeTotal;
    }
    
    
    
}
