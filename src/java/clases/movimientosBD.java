/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandsower
 */
public class movimientosBD {

    private ArrayList lasPersonas;

    public movimientosBD(){
        try {
            this.consultarPersonas();
        } catch (SQLException ex) {
            Logger.getLogger(movimientosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int agregarPersona(Persona p){
        try {

            ConexionBD connect = new ConexionBD();
            Connection con = connect.getConnect();
            
                    PreparedStatement stmt1 = (PreparedStatement) con.prepareStatement
                            ("Insert into persona(Nombre,Apellido_Paterno,Apellido_Materno,Calle,Num_Calle,Colonia,Estado,Municipio,Edad,Telefono)"
                            +  "VALUES(?,?,?,?,?,?,?,?,?,?)");
                    stmt1.setString(1, p.getNombre());
                    stmt1.setString(2, p.getApellidoPaterno());
                    stmt1.setString(3, p.getApellidoMaterno());
                    stmt1.setString(4, p.getCalle());
                    stmt1.setInt(5,p.getNumeroCalle());
                    stmt1.setString(6,p.getColonia() );
                    stmt1.setString(7,p.getEstado() );
                    stmt1.setString(8,p.getMunicipio() );
                    stmt1.setInt(9,p.getEdad() );
                    stmt1.setInt(10, p.getTelefono());
                   int  rows_updated = stmt1.executeUpdate();

            con.close();
            return rows_updated;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: "+ ex.toString());
        }
        return 0;
    }

    public Persona obtenerPersona(int id){
         ConexionBD connect = new ConexionBD();
            Connection con = connect.getConnect();
            Persona p = null;
            ResultSet rs = null;
            Statement stmt = null;
        try{
           
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

            finally{
            try {
                stmt.close();
                rs.close();
                connect.cerrarBD();
            } catch (SQLException ex) {
                }
            }
        return null;
    }

    public void consultarPersonas () throws SQLException{
         ConexionBD connect = new ConexionBD();
         Connection con = null;
         Statement stmt = null;
            ResultSet rs = null;
            //SQL query command
            String SQL = "SELECT * FROM Persona";
        try {
            con = connect.getConnect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            ArrayList unasPersonas = new ArrayList();
            while (rs.next()) {
                unasPersonas.add(rs.getString("ID"));
            }
            this.setLasPersonas(unasPersonas);
        } catch (SQLException ex) {
            Logger.getLogger(movimientosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally{
                stmt.close();
                rs.close();
                connect.cerrarBD();
            }
    }

    public static void main(String[] args) {
        movimientosBD mov = new movimientosBD();
        ConexionBD connect = new ConexionBD();
        if(connect.getConnect() != null){
            System.out.println("Conexion correcta.");
        }
    }

    /**
     * @return the lasPersonas
     */
    public ArrayList getLasPersonas() {
        return lasPersonas;
    }

    /**
     * @param lasPersonas the lasPersonas to set
     */
    public void setLasPersonas(ArrayList lasPersonas) {
        this.lasPersonas = lasPersonas;
    }
}
