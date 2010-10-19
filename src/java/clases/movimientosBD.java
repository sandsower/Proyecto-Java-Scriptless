/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.sql.*;
/**
 *
 * @author Sandsower
 */
public class movimientosBD {

    public int agregarPersona(Persona p){
        try {

            ConexionBD connect = new ConexionBD();
            Connection con = connect.getConnect();

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
            ConexionBD connect = new ConexionBD();
            Connection con = connect.getConnect();
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

    public ResultSet consultarPersonas () throws SQLException{
         ConexionBD connect = new ConexionBD();
         Connection con = connect.getConnect();

         Statement stmt = null;
            ResultSet rs = null;
            //SQL query command
            String SQL = "SELECT * FROM Persona";
             con = connect.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            return rs;

    }
    public static void main(String[] args) {
        movimientosBD mov = new movimientosBD();
        ConexionBD connect = new ConexionBD();
        if(connect.getConnect() != null){
            System.out.println("Conexion correcta.");
        }
    }
}
