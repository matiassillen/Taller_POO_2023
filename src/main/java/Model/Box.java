package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Box implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    @ManyToOne
    private Medico medico;
    @OneToOne
    private Paciente pacienteActual;
    @OneToOne(mappedBy="box") 
    private Consulta consulta;
    
    public Box() {
    }

    /**
     * Default constructor
     * @param id
     * @param medico
     * @param pacienteActual
     * @param consulta
     */

    public Box(long id, Medico medico, Paciente pacienteActual, Consulta consulta) {
        this.id = id;
        this.medico = medico;
        this.pacienteActual = pacienteActual;
        this.consulta = consulta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
}