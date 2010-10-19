/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import clases.Persona;
import clases.movimientosBD;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sandsower
 */
public class ingresarDatosBD extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String nombre = request.getParameter("Nombre");
       String apellidoPaterno = request.getParameter("Apellido_Paterno");
       String apellidoMaterno = request.getParameter("Apellido_Materno");
       String calle = request.getParameter("Calle");
       int numeroCalle = Integer.parseInt(request.getParameter("Num_Calle"));
       String colonia = request.getParameter("Colonia");
       String estado = request.getParameter("Estado");
       String municipio = request.getParameter("Municipio");
       int edad = Integer.parseInt(request.getParameter("Edad"));
       int telefono = Integer.parseInt(request.getParameter("Telefono"));

       Persona p = new Persona(nombre, apellidoPaterno, apellidoMaterno, calle, numeroCalle, colonia, estado, municipio, edad, telefono);
       movimientosBD m = new movimientosBD();
       int filasAfectadas = m.agregarPersona(p);
       request.setAttribute("filas", filasAfectadas);
       if(filasAfectadas > 0){
           RequestDispatcher view = request.getRequestDispatcher("Resultado.jsp");
           view.forward(request, response);
       }
       else{
           RequestDispatcher view = request.getRequestDispatcher("Error.jsp");
           view.forward(request, response);
       }
   }
}
