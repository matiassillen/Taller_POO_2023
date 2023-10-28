package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Paciente paciente;
    private String fecha;
    private String hora;
    private String diagnConsulta;
    private String lugar;
    private String motivo;
    @OneToOne
    @JoinColumn(name = "id_box")
    private Box box;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @OneToOne
    @JoinColumn(name = "id_triage")
    private Triage triage;

    /**
     * Default constructor
     */
    public Consulta() {

    }

    /**
     * Constructor con parámetros
     *
     * @param paciente
     * @param fecha
     * @param hora
     * @param diagnConsulta
     * @param lugar
     * @param motivo
     * @param box
     * @param medico
     * @param triage
     */
    public Consulta(Paciente paciente, String fecha, String hora, String diagnConsulta, String lugar, String motivo, Box box, Medico medico, Triage triage) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnConsulta = diagnConsulta;
        this.lugar = lugar;
        this.motivo = motivo;
        this.box = box;
        this.medico = medico;
        this.triage = triage;
    }

    /**
     *
     * @return
     */
    public int getId() {
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
    public String getDiagnConsulta() {
        return diagnConsulta;
    }

    /**
     *
     * @param diagnConsulta
     */
    public void setDiagnConsulta(String diagnConsulta) {
        this.diagnConsulta = diagnConsulta;
    }

    /**
     *
     * @return
     */
    public String getLugar() {
        return lugar;
    }

    /**
     *
     * @param lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     *
     * @return
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     *
     * @param motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     *
     * @return
     */
    public Box getBox() {
        return box;
    }

    /**
     *
     * @param box
     */
    public void setBox(Box box) {
        this.box = box;
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
    public Triage getTriage() {
        return triage;
    }

    /**
     *
     * @param triage
     */
    public void setTriage(Triage triage) {
        this.triage = triage;
    }

}
