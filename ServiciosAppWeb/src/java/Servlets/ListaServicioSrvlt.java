/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Gestores;
import Modelo.Servicio;
import Modelo.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NotebookSFC
 */
@WebServlet(name = "ListaServicioSrvlt", urlPatterns = {"/ListaServicioSrvlt"})
public class ListaServicioSrvlt extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
               
        String usuario = (String)request.getSession().getAttribute("user"); //se castea a string porque getattributes devuelve objetos
        if(usuario != null && !usuario.equals(""))
        {
        Gestores g = new Gestores();
        ArrayList<Servicio> lista = g.obtenerServicio();
        request.setAttribute ("lista", lista);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoServicios.jsp");
        rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
            rd.forward(request, response);
        }
       }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//         Gestores gestor = new Gestores();
//        ArrayList<Tipo> lista = gestor.obtenerTipo();
//        request.setAttribute("listadoProductos", lista);
//        
//        RequestDispatcher rd = request.getRequestDispatcher("/AltaServicios.jsp");
//        rd.forward(request, response);
//        Gestores gestor = new Gestores();
//        String modo = request.getParameter("modo");
//        
//        if(modo == null || modo.isEmpty())
//        {
//            request.setAttribute("ventas", gestor.obtenerVentas());
//
//            RequestDispatcher rd = request.getRequestDispatcher("/listadoVentas.jsp");
//            rd.forward(request, response);
//        }
//        else if(modo.equals("alta"))
//        {
//            ArrayList<Producto> lista = gestor.obtenerProductos();
//            request.setAttribute("listadoProductos", lista);
//            RequestDispatcher rd = request.getRequestDispatcher("/venta.jsp");
//            rd.forward(request, response);
//        }
//        else if(modo.equals("editar"))
//        {
//        
//        }
    

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
