package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 */

@Entity
public class Box implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    private Boolean estado;
    @ManyToOne
    private Medico medico;
     @OneToOne
    private Paciente pacienteActual;
    
    public Box() {
    }

    /**
     * Default constructor
     * @param id
     * @param estado
     * @param medico
     * @param pacienteActual
     */
    public Box(long id, Boolean estado, Medico medico, Paciente pacienteActual) {
        this.id = id;
        this.estado = estado;
        this.medico = medico;
        this.pacienteActual = pacienteActual;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPacienteActual() {
        return pacienteActual;
    }

    public void setPacienteActual(Paciente pacienteActual) {
        this.pacienteActual = pacienteActual;
    }

}