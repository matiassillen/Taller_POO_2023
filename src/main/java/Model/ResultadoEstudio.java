package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultadoEstudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Paciente paciente;
    private String nombre;
    private String Informe;
    private String hora;
    private String fecha;

    /**
     * Default constructor
     */
    public ResultadoEstudio() {
        this.paciente = null;
        this.nombre = null;
        this.Informe = null;
        this.hora = null;
        this.fecha = null;
    }

    /**
     * Constructor con parametros
     *
     * @param paciente
     * @param nombre
     * @param Informe
     * @param hora
     * @param Fecha
     */
    public ResultadoEstudio(Paciente paciente, String nombre, String Informe, String hora, String Fecha) {
        this.paciente = paciente;
        this.nombre = nombre;
        this.Informe = Informe;
        this.hora = hora;
        this.fecha = Fecha;
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
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
    public String getInforme() {
        return Informe;
    }

    /**
     *
     * @param Informe
     */
    public void setInforme(String Informe) {
        this.Informe = Informe;
    }

    /**
     *
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
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
