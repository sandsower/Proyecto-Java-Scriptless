package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.movimientosBD;
import java.sql.*;
import java.sql.Connection.*;

public final class Resultado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      clases.ConexionBD person = null;
      synchronized (request) {
        person = (clases.ConexionBD) _jspx_page_context.getAttribute("person", PageContext.REQUEST_SCOPE);
        if (person == null){
          person = new clases.ConexionBD();
          _jspx_page_context.setAttribute("person", person, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Busqueda de usuarios</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form action=\"mostrarInfo.do\" method=\"POST\">\r\n");
      out.write("        Selecciona el ID de la persona a desplegar:<br>\r\n");
      out.write("        <select name=\"ID\">\r\n");
      out.write("        ");

            Statement stmt = null;
            ResultSet rs = null;
            movimientosBD m = new movimientosBD();
            //SQL query command
            String SQL = "SELECT * FROM Persona";
            Connection con = person.conectarBD("root", "gameover");
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
        
      out.write("\r\n");
      out.write("            <option>");
      out.print(rs.getString("ID"));
      out.write("</option>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("        <br>\r\n");
      out.write("        <input type=\"submit\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
