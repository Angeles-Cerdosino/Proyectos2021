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
 * 
 * 
 * El programa tiene que permitir el ingreso de los datos de los alquileres 
 *      y que luego de ingresar cada uno muestre el total a cobrar al cliente
 * Asimismo debe permitir consultar;
 * - Nombre del cliente que contrató el alquiler de mayor duracion
 * -Total ganado en concepto de alquiler pero sin incluir los gastos de desinfeccion
 * - Total de recaudacion de los alquileres de inst de cuerda, incluye lo cobrado por las cuerdas
 */
public class ICuerda extends Alquiler {
    private int cantCuerdas;

    public ICuerda(String nombreCliente, String nombreInstrumento, int cantSemanas, int cantCuerdas) {
        super(nombreCliente, nombreInstrumento, cantSemanas);
        this.cantCuerdas = cantCuerdas;
    }

    public ICuerda() {
    }

    public int getCantCuerdas() {
        return cantCuerdas;
    }

    public void setCantCuerdas(int cantCuerdas) {
        this.cantCuerdas = cantCuerdas;
    }
    
    public double precioAlquiler()
    {
        double precio = 0;
        precio = ((getCantSemanas() * 800 + (getCantCuerdas() * 300)));
        return precio;
    }
    
}
