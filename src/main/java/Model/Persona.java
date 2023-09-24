package Model;


import java.util.*;

/**
 * 
 */
public abstract class Persona {
    
    private String nombre;
    private String apellido;
    private String fechaDeNac;
    private String domicilio;
    private int dni;
    private int telefonoFijo;
    private int telefonoCel;
    private String correoE;
    private String estadoCivil;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNac = fechaDeNac;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCel = telefonoCel;
        this.correoE = correoE;
        this.estadoCivil = estadoCivil;
    }

    public Persona(String nombre, String apellido, int telefonoCel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoCel = telefonoCel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaDeNac() {
        return fechaDeNac;
    }

    public void setFechaDeNac(String fechaDeNac) {
        this.fechaDeNac = fechaDeNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return dni;
    }

    public void setDNI(int dni) {
        this.dni = dni;
    }

    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(int telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public int getTelefonoCel() {
        return telefonoCel;
    }

    public void setTelefonoCel(int telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}

    
    
   