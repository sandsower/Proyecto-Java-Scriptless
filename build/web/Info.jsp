<%--
    Document   : Info
    Created on : 12/10/2010, 09:44:41 PM
    Author     : Garrison
--%>

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
            Nombre: ${Persona.nombre} <br>
            Apellido Paterno: ${Persona.apellidoPaterno} <br>
            Apellido Materno: ${Persona.apellidoMaterno}  <br>
            Edad: ${Persona.edad}  <br>
            Calle: ${Persona.calle}  <br>
            Numero de calle: ${Persona.numeroCalle}  <br>
            Colonia: ${Persona.colonia}  <br>
            Estado: ${Persona["estado"]}  <br>
            Municipio: ${Persona.municipio}  <br>
            Telefono (solo numeros): ${Persona.telefono}  <br>
            <input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
