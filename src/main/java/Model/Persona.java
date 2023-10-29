package Model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;
    private String apellido;
    private String fechaDeNac;
    private String domicilio;
    private int dni;
    private String telefonoFijo;
    private String telefonoCel;
    private String correoE;
    private String estadoCivil;

    /**
     * Default constructor
     */
    public Persona() {

    }

    /**
     * Contructor con parametros
     * 
     * @param id es un long Id generado automaticamente, en este caso es extraido de las tablas de la base de datos
     * @param nombre String nombre de la persona
     * @param apellido String apellido de la persona
     * @param fechaDeNac String de la fecha de nacimiento en formato aaaa/MM/dd
     * @param domicilio String del domicilio de la persona
     * @param dni int del DNI de la persona
     * @param telefonoFijo String del telefono fijo de la persona
     * @param telefonoCel String del telefono celular de la persona
     * @param correoE String del correo de la persona
     * @param estadoCivil String del estado civil de la persona
     */
    public Persona(long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        this.id = id;
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

    /**
     *
     * @return retorna el Id de la persona
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id long con el Id de la persona a modificar / no se usa
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return String del nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre String con el nombre de la persona amodificar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return String del apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido String con el apellido de la persona a modificar
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return String con la fecha de nacimiento de la persona
     */
    public String getFechaDeNac() {
        return fechaDeNac;
    }

    /**
     *
     * @param fechaDeNac String fecha en formato aaaa/MM/dd
     */
    public void setFechaDeNac(String fechaDeNac) {
        this.fechaDeNac = fechaDeNac;
    }

    /**
     *
     * @return String con el domicilio de la persona
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param domicilio String con un domicilio para modificar
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     *
     * @return un int con el DNI de la persona
     */
    public int getDni() {
        return dni;
    }

    /**
     *
     * @param dni un int para cambiar en el atributo Dni
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     *
     * @return String con el numero de telefono fijo de la persona
     */
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    /**
     *
     * @param telefonoFijo String con un numero de telefono para la persona
     */
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    /**
     *
     * @return String con el numero de telefono celular de la persona
     */
    public String getTelefonoCel() {
        return telefonoCel;
    }

    /**
     *
     * @param telefonoCel String con un numero para el telefono celular de la persona
     */
    public void setTelefonoCel(String telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    /**
     *
     * @return String con el correo de la persona
     */
    public String getCorreoE() {
        return correoE;
    }

    /**
     *
     * @param correoE String con un correo para la persona
     */
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    /**
     *
     * @return String con el estado civil de la persona
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     *
     * @param estadoCivil String con el estado civil para la persona
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
