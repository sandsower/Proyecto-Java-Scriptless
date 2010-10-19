/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sandsower
 */
public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private int numeroCalle;
    private String colonia;
    private String estado;
    private String municipio;
    private int edad;
    private int telefono;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String calle, int numeroCalle, String colonia, String estado, String municipio, int edad, int telefono){
        this.setApellidoMaterno(apellidoMaterno);
        this.setApellidoPaterno(apellidoPaterno);
        this.setCalle(calle);
        this.setColonia(colonia);
        this.setEdad(edad);
        this.setEstado(estado);
        this.setMunicipio(municipio);
        this.setNombre(nombre);
        this.setNumeroCalle(numeroCalle);
        this.setTelefono(telefono);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public final void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public final void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public final void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numeroCalle
     */
    public int getNumeroCalle() {
        return numeroCalle;
    }

    /**
     * @param numeroCalle the numeroCalle to set
     */
    public final void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public final void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public final void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public final void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public final void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public final void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public static void main(String[] args) {
        movimientosBD m = new movimientosBD();
        Persona p = new Persona("Victor", "Valenzuela", "Martinez", "Pedro Ascencio", 323, "Morelos I", "Aguascalientes", "Aguascalientes", 20, 9771851);
        int numeroFilas = m.agregarPersona(p);
        System.out.println("Numero de filas afectadas: "+numeroFilas);
    }
}
