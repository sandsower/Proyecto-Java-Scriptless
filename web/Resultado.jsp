<%-- 
    Document   : Resultado
    Created on : 12/10/2010, 09:43:30 PM
    Author     : Sandsower
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="movimientos" scope="page" class="clases.movimientosBD"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda de usuarios</title>
    </head>
    <body>
        <form action="mostrarInfo.do" method="POST">
        Selecciona el ID de la persona a desplegar:<br>
        <select name="ID">
            <c:forEach var="ID" items="${movimientos.lasPersonas}">
                <option>${ID}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit"/>
        </form>
    </body>
</html>
