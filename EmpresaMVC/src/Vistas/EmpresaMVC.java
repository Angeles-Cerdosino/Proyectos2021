/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ProductoController;
import Modelo.ProductoModel;

/**
 *
 * @author NotebookSFC
 */
public class EmpresaMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductoModel prod = new ProductoModel();
        prod.setNombre("lapiz");
        prod.setPrecio(100);
        
        ProductoController gestor = new ProductoController();
        gestor.agregarProducto(prod);
        
    }
    
}
