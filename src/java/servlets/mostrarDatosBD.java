/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import clases.Persona;
import clases.movimientosBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sandsower
 */
public class mostrarDatosBD extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        movimientosBD m = new movimientosBD();
        int id = Integer.parseInt(request.getParameter("ID"));
        Persona p = m.obtenerPersona(id);
        request.setAttribute("Persona", p);
        RequestDispatcher view = request.getRequestDispatcher("Info.jsp");
        view.forward(request, response);
    }
}
