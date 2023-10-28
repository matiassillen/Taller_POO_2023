package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Titulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;
    @OneToOne(mappedBy = "titulo")
    private Medico medico;
    @OneToOne(mappedBy = "titulo")
    private Especialidad especialidad;
    private String universidad;
    private String fecha;

    /**
     * Default constructor
     */
    public Titulo() {
        nombre = null;
        medico = null;
        especialidad = null;
        this.universidad = "";
        this.fecha = "";
    }

    /**
     * Constructor con parametros
     *
     * @param idTitulo
     * @param nombre
     * @param medico
     * @param especialidad
     * @param universidad
     * @param fecha
     */
    public Titulo(long idTitulo, String nombre, Medico medico, Especialidad especialidad, String universidad, String fecha) {
        this.id = idTitulo;
        this.nombre = nombre;
        this.medico = medico;
        this.especialidad = especialidad;
        this.universidad = universidad;
        this.fecha = fecha;
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
    public Medico getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     *
     * @return
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     *
     * @param especialidad
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     *
     * @return
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     *
     * @param universidad
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
