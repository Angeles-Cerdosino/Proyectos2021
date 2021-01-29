<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Service List</title>
    </head>
    
    <body>
        <h1>Service List</h1>
        <table border=1>
            <th> ID </th>
            <th> TIPO </th>
            <th> DESCRIPCION </th>
            <th> COSTO </th>
        <%
            ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("lista"); /*el arraylist viene como object asique posteriormente se castea entre (). el "lista" es como viene del jsp*/
                     
            for (Servicio servicio : lista)                                                 /*luego lo recorro con foreach*/
                {                                               
                    out.print("<tr><td>" + servicio.getId() + 
                            "</td><td>" + servicio.getTipo().getDescripcionT() + 
                            "</td><td>" + servicio.getDescripcion()+
                            "</td><td>" + servicio.getCosto() + 
                            "</td></tr>");
                }
        %>
        </table>
            
    </body>
</html>
