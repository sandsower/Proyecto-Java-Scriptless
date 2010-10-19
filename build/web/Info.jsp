<%--
    Document   : Info
    Created on : 12/10/2010, 09:44:41 PM
    Author     : Sandsower
--%>

<%@page import="clases.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="person" class="clases.Persona" scope="request" />
<jsp:getProperty name="person" property="name" />
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
            Nombre: <% person.getNombre(); %> <br>
            Apellido Paterno: <% person.getApellidoPaterno(); %> <br>
            Apellido Materno: <% person.getApellidoMaterno(); %> <br>
            Edad: <%person.getEdad(); %> <br>
            Calle: <% person.getCalle(); %> <br>
            Numero de calle: <% person.getNumeroCalle(); %> <br>
            Colonia: <% person.getColonia(); %> <br>
            Estado: <% person.getEstado(); %> <br>
            Municipio: <% person.getMunicipio(); %> <br>
            Telefono (solo numeros): <% person.getTelefono(); %> <br>
            <input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
