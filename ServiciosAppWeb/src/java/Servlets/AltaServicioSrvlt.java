
package Servlets;

import Controlador.Gestores;
import Modelo.Tipo;
import Modelo.Servicio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AltaServicioSrvlt", urlPatterns = {"/AltaServicioSrvlt"})
public class AltaServicioSrvlt extends HttpServlet {
    
    Gestores g = new Gestores();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ArrayList<Tipo> lista = g.obtenerTipos();
        request.setAttribute("listaTipo", lista);
               
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaServicios.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        int tipo = Integer.parseInt(request.getParameter("cbotipo"));
        String descripcion = request.getParameter("txtdescripcion");
        double costo = Double.parseDouble(request.getParameter("txtcosto"));
        
        Servicio s = new Servicio(); 
        Gestores gestor = new Gestores();
        gestor.insertarServicio(s);
        
        request.setAttribute("servicios", gestor.obtenerServicio());
        
        RequestDispatcher rd = request.getRequestDispatcher("/listadoServicios.jsp");
        rd.forward(request, response);

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
