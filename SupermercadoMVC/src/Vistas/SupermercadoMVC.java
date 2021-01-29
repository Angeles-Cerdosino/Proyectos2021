/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Controller;
import Modelo.Oferta;

/**
 *
 * @author NotebookSFC
 */
public class SupermercadoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Oferta o = new Oferta();
        o.setPrecioNormal(10);
        o.setPrecioOferta(8);
        
        Controller gestor = new Controller();
        gestor.agregarOferta(o);
        
    }
    
}
