/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.security.auth.message.callback.PrivateKeyCallback;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        RequestDispatcher rd = request.getRequestDispatcher("Index.jsp"); //redirije la peticion al index.jsp
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String usuario = request.getParameter("txtusuario");
        String password = request.getParameter("txtpassword");
        //ACA SE PUEDEN AUTENTICAR LOS MISMOS
        if(usuario.equals("tecni") && password.equals("tecni"))
            {
                request.getSession().setAttribute("user", usuario);                         //si coincide puedo almacenar en sesion esta info en user
                //request.getSession().invalidate();                                          //borra los objetos que tenia seteados. no queda almacenada la info del usuario
                //request.getSession().setMaxInactiveInterval(5);                             //setea el tiempo max de inactividad de una sesion en seg. entre el navegador y el servlet
                RequestDispatcher rd = request.getRequestDispatcher("ListaServicioSrvlt"); //redirecciono
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("msjerror", "Usuario o contraseña incorrectos");       //cargamos un msj. en el index: si llego este atributo lo muestro sino, no
                RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);
            }                          
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
