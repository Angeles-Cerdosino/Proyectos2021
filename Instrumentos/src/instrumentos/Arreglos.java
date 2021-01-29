/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos;

import java.util.ArrayList;

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
 * - Total ganado en concepto de alquiler pero sin incluir los gastos de desinfeccion
 * - Total de recaudacion de los alquileres de inst de cuerda, incluye lo cobrado por las cuerdas
 */
public class Arreglos {
    
    private ArrayList<Alquiler> alquileres; //declaramos arreglo
    
    public Arreglos ()
    {
        alquileres = new ArrayList(); //definimos el tamaño del ALQUILER. Ser{a el arraylist
    }
    
    public ArrayList<Alquiler> getAlquileres () //get de alquiler
    {
        return alquileres;
    }
    
    public void agregarAlquiler (Alquiler a) //insercion o metodo agregar alquiler
    {
        alquileres.add(a);
    }
            
    //Nombre del cliente que contrató el alquiler de mayor duracion
    public String ClienteMayorDuracion ()
    {
        int max = alquileres.get(0).getCantSemanas();
        String nombre = alquileres.get(0).getNombreCliente();
        
        for (Alquiler a : alquileres) 
        {
            if(a.getCantSemanas() > max)
            {
                max=a.getCantSemanas();
                nombre=a.getNombreCliente();
            }
        }
        return nombre;
    }
    
    //Total ganado en concepto de alquiler 
    //pero sin incluir los gastos de desinfeccion
    public double TotalGanadoSinDesinfeccion()
    {
        double total = 0; //declaro variable
        for (Alquiler a : alquileres) //recorro con foreach
        {
         if(a instanceof ICuerda) //pregunto si a es instancia de la clase hija cuerda
         {
             ICuerda ic = (ICuerda) a; //cuerda es a
             total += ic.precioAlquiler(); //almaceno el total del precio alquiler
         }
         else if (a instanceof IViento)
         {
             IViento iv = (IViento) a;
             total +=iv.precioAlquilerSinDesinfeccion();
         }
        }
        return total;
    }
    
    //Total de recaudacion de los alquileres de inst de cuerda, 
    //incluye lo cobrado por las cuerdas
    
    public double TotalRecaudadoInstrumentoCuerda()
    {
        double acumulador = 0;
        for (Alquiler a : alquileres) 
        {
            if(a instanceof ICuerda)
            {
                ICuerda ic = (ICuerda) a ;
                acumulador += ic.precioAlquiler();
            }
        }
        return acumulador;
    }
    
    
    
    
    
    
    
    
}
