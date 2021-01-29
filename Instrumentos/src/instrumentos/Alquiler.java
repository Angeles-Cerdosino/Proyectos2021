/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos;

/*
 Negocio que se dedica al ALQUILER DE INSTRUMENTOS MUSICALES
 * De cada alquiler el negocio regista NOMBRE DEL CLIENTE y EL NOMBRE DEL INSTRUMENTO. El neg se especializa en inst de viento y cuerda
 * Los INST CUERDA se entregan con cuerdas nuevas en c/ ocasion por lo tanto el precio del alquiler 
 *      de este tipo es de 800 por semana mas 300 por c/ cuerda
 * Los INST VIENTO son alquilados por 1000 por semana. para el alquiler se debe incluir el precio de desinfeccion
 *      de boquilla que tiene un costo de 500.
 * El programa tiene que permitir el ingreso de los datos de los alquileres 
 *      y que luego de ingresar cada uno muestre el total a cobrar al cliente
 * Asimismo debe permitir consultar;
 * - Nombre del cliente que contrató el alquiler de mayor duracion
 * -Total ganado en concepto de alquiler pero sin incluir los gastos de desinfeccion
 * - Total de recaudacion de los alquileres de inst de cuerda, incluye lo cobrado por las cuerdas
 */
public abstract class Alquiler {
    private String nombreCliente;
    private String nombreInstrumento;
    private int cantSemanas;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreInstrumento() {
        return nombreInstrumento;
    }

    public void setNombreInstrumento(String nombreInstrumento) {
        this.nombreInstrumento = nombreInstrumento;
    }

    public int getCantSemanas() {
        return cantSemanas;
    }

    public void setCantSemanas(int cantSemanas) {
        this.cantSemanas = cantSemanas;
    }

    public Alquiler(String nombreCliente, String nombreInstrumento, int cantSemanas) {
        this.nombreCliente = nombreCliente;
        this.nombreInstrumento = nombreInstrumento;
        this.cantSemanas = cantSemanas;
    }
   
    public Alquiler ()
    {}

    @Override
    public String toString() {
        return "Alquiler: " + "nombreCliente=" + nombreCliente + ", nombreInstrumento=" + nombreInstrumento + ", cantSemanas=" + cantSemanas + '}';
    }
    
    public abstract double precioAlquiler(); //traigo el metodo de todas las clases hijas
    
}
