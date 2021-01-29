<%-- 
    Document   : Index
    Created on : 17-Dec-2020, 01:01:24
    Author     : NotebookSFC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Iniciar Sesion - Hola ${user} </h1>
        <% if(request.getAttribute("msjerror") !=null && !request.getAttribute("msjerror").equals("")) { %>
        <h2>${ msjerror } </h2>
        <% } %>
        
        <form method="POST" action="Login"> <!--action va al servlet en este caso login-->
            <p>
            <label>Usuario: </label>
            <input name="txtusuario" />
            </p>
            <p>
            <label>Contraseña: </label>
            <input type="password" name="txtpassword" />
            </p>
            <input type="submit" value="Iniciar Sesion"/>
        </form>
    </body>
</html>
