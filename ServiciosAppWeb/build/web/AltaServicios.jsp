

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
    </head>
    <body>
        <h1>Alta de Servicio</h1>
        <form action="AltaServicioSrvlt" method="POST" > 
            <p>
            <label> TIPO: </label>
            <select name="cbotipo">
                <c:forEach items="${listaTipo}" var="item">                    
                    <option value="${item.id}">${item.descripcion}</option>
                </c:forEach>
            </select>        
          
            </p>
            <p>
            <label for="txtdescripcion"> DESCRIPCION: </label>
            <input type="text" name="txtdescripcion">
            </p>
            <p>
            <label for="txtcosto"> COSTO: </label>
            <input type="number" name="txtcosto">
            </p>
            
            <input type="submit" value="Enviar">  
        </form>
    </body>
</html>

