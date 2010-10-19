<%--
    Document   : Info
    Created on : 12/10/2010, 09:44:41 PM
    Author     : Sandsower
--%>

<%@page import="clases.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar informacion personal</title>
    </head>
    <body>
        <form action="Resultado.jsp" method="post">
        <%
        Persona p =(Persona) request.getAttribute("Persona");
        %>
            Nombre: <%=p.getNombre()%> <br>
            Apellido Paterno: <%=p.getApellidoPaterno()%> <br>
            Apellido Materno: <%=p.getApellidoMaterno()%> <br>
            Edad: <%=p.getEdad()%> <br>
            Calle: <%=p.getCalle()%> <br>
            Numero de calle: <%=p.getNumeroCalle()%> <br>
            Colonia: <%=p.getColonia()%> <br>
            Estado: <%=p.getEstado()%> <br>
            Municipio: <%=p.getMunicipio()%> <br>
            Telefono (solo numeros): <%=p.getTelefono()%> <br>
            <input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
