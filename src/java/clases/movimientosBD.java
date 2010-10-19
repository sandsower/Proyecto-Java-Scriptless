/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sandsower
 */
public class movimientosBD {
    public Connection conectarBD(String username, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/javaprueba?user="+username+"&password="+password;
            Connection con = DriverManager.getConnection(connectionUrl);
            return con;
        }
        catch(SQLException e){
            System.out.println("SQL Exception: "+e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found Exception: "+e.toString());
        }
        return null;
    }

    public int agregarPersona(Persona p){
        try {
            Connection con = this.conectarBD("root", "gameover");
            Statement stmt = null;
            String query = "INSERT INTO Persona(Nombre,Apellido_Paterno,Apellido_Materno,Calle,Num_Calle,Colonia,Estado,Municipio,Edad,Telefono) "
                    + " VALUES('" + p.getNombre() + "','" + p.getApellidoPaterno() + "','" + p.getApellidoMaterno() + "','" + p.getCalle() + "',"
                    + p.getNumeroCalle() + ",'" + p.getColonia() + "','" + p.getEstado() + "','" + p.getMunicipio() + "'," + p.getEdad() + "," +
                    p.getTelefono() + ")";
            stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            con.close();
            return rowsAffected;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: "+ ex.toString());
        }
        return 0;
    }

    public Persona obtenerPersona(int id){
        try{
            Connection con = this.conectarBD("root", "13450811");
            Persona p = null;
            ResultSet rs = null;
            Statement stmt = null;
            String query = "SELECT * FROM Persona WHERE ID = "+id;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                p = new Persona(rs.getString("Nombre"), rs.getString("Apellido_Paterno"), rs.getString("Apellido_Materno"),
                        rs.getString("Calle"), Integer.parseInt(rs.getString("Num_Calle")), rs.getString("Colonia"), rs.getString("Estado"),
                        rs.getString("Municipio"), Integer.parseInt(rs.getString("Edad")), Integer.parseInt(rs.getString("Telefono")));
            }
            return p;
        }
        catch(SQLException e){
            System.out.println("SQL Exception: "+e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        movimientosBD mov = new movimientosBD();
        if(mov.conectarBD("root", "13450811") != null){
            System.out.println("Conexion correcta.");
        }
    }
}
