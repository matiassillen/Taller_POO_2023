package Model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DiagnosticoClinico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Paciente paciente;
    private String nombreDiagnostico;
    private String fecha;
    private String hora;
    private String descripcion;
    @ManyToOne
    private Medico medico;

    /**
     * Default constructor
     */
    public DiagnosticoClinico() {
        this.paciente = null;
        this.nombreDiagnostico = null;
        this.fecha = null;
        this.hora = null;
        this.descripcion = null;
        this.medico = null;
    }

    /**
     * Constructor con parámetros
     *
     * @param paciente
     * @param nombreDiagnostico
     * @param fecha
     * @param hora
     * @param descripcion
     * @param medico
     */
    public DiagnosticoClinico(Paciente paciente, String nombreDiagnostico, String fecha, String hora, String descripcion, Medico medico) {
        this.paciente = paciente;
        this.nombreDiagnostico = nombreDiagnostico;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.medico = medico;
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
    public void setId(int id) {
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
    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    /**
     *
     * @param nombreDiagnostico
     */
    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
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
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

}
