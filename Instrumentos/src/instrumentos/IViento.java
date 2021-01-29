/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos;
/*
 Negocio que se dedica al ALQUILER DE INSTRUMENTOS MUSICALES
 * De cada alquiler el negocio regista NOMBRE DEL CLIENTE y EL NOMBRE DEL INSTRUMENTO. 
 * El neg se especializa en inst de viento y cuerda
 * 
 * Los INST VIENTO son alquilados por 1000 por semana. para el alquiler se debe incluir el precio de desinfeccion
 *      de boquilla que tiene un costo de 500.
 * 
 * El programa tiene que permitir el ingreso de los datos de los alquileres 
 *      y que luego de ingresar cada uno muestre el total a cobrar al cliente
 * 
 * Asimismo debe permitir consultar;
 * - Nombre del cliente que contrató el alquiler de mayor duracion
 * - Total ganado en concepto de alquiler pero sin incluir los gastos de desinfeccion
 * - Total de recaudacion de los alquileres de inst de cuerda, incluye lo cobrado por las cuerdas
 */
public class IViento extends Alquiler {
    
    private double precioDesinfeccion;

    public IViento(String nombreCliente, String nombreInstrumento, int cantSemanas, double precioDesinfeccion) {
        super(nombreCliente, nombreInstrumento, cantSemanas);
        this.precioDesinfeccion = precioDesinfeccion;
    }

    public double getPrecioDesinfeccion() {
        return precioDesinfeccion;
    }

    public void setPrecioDesinfeccion(double precioDesinfeccion) {
        this.precioDesinfeccion = precioDesinfeccion;
    }
    
    @Override
    public double precioAlquiler() 
    {
        double precio =0;
        precio = (getCantSemanas() * 1000) + 500;
        return precio;        
    }
    
    public double precioAlquilerSinDesinfeccion() //Total ganado en concepto de alquiler pero sin incluir los gastos de desinfeccion
    {
        double precio = 0;
        precio = (getCantSemanas() *1000);
        return precio;
                
    }
    
    
    
    
    
    
    
            
}
