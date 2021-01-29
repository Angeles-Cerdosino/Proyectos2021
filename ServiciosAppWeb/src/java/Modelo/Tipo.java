/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Tipo
{
 private int idTipo;
 private String DescripcionT;

    public Tipo(int idTipo, String Descripcion) {
        this.idTipo = idTipo;
        this.DescripcionT = Descripcion;
    }
 
    public Tipo () {}

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionT() {
        return DescripcionT;
    }

    public void setDescripcion(String Descripcion) {
        this.DescripcionT = Descripcion;
    }

    @Override
    public String toString() {
        return DescripcionT;
    }

  
 
 
 
 
}
