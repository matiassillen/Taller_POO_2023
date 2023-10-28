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
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaDeNac
     * @param domicilio
     * @param dni
     * @param telefonoFijo
     * @param telefonoCel
     * @param correoE
     * @param estadoCivil
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
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public String getFechaDeNac() {
        return fechaDeNac;
    }

    /**
     *
     * @param fechaDeNac
     */
    public void setFechaDeNac(String fechaDeNac) {
        this.fechaDeNac = fechaDeNac;
    }

    /**
     *
     * @return
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param domicilio
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     *
     * @return
     */
    public int getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    /**
     *
     * @param telefonoFijo
     */
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    /**
     *
     * @return
     */
    public String getTelefonoCel() {
        return telefonoCel;
    }

    /**
     *
     * @param telefonoCel
     */
    public void setTelefonoCel(String telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    /**
     *
     * @return
     */
    public String getCorreoE() {
        return correoE;
    }

    /**
     *
     * @param correoE
     */
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    /**
     *
     * @return
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     *
     * @param estadoCivil
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
