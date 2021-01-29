<%-- 
    Document   : Alta
    Created on : 17-Dec-2020, 15:28:30
    Author     : NotebookSFC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta 2</title>
        </head>
   <form method="POST" action="/SER/AltaServicioSrvlt">
        <p>
            <label>Tipo: </label>
            <select>
               <c:forEach item="${listaTipo}" var="item">
                    <option value="${item.idTipo}">${item.Descripcion}</option>
                    
                </c:forEach>               
            </select>
        </p>
    </form>
    
    <body>
        <h1>Alta 2</h1>
    </body>
</html>
