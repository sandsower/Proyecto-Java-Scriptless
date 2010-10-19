<%-- 
    Document   : Resultado
    Created on : 12/10/2010, 09:43:30 PM
    Author     : Sandsower
--%>

<%@page import="clases.movimientosBD"%>
<%@page import="java.sql.*"%>
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
        <%
            Statement stmt = null;
            ResultSet rs = null;
            movimientosBD m = new movimientosBD();
            //SQL query command
            String SQL = "SELECT * FROM Persona";
            Connection con = m.conectarBD("root", "gameover");
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
        %>
            <option><%=rs.getString("ID")%></option>
        <%}%>
        </select>
        <br>
        <input type="submit"/>
        </form>
    </body>
</html>
