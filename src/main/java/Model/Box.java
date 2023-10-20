package Model;

<<<<<<< HEAD
=======

>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToOne;
=======
import javax.persistence.OneToMany;
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
import javax.persistence.OneToOne;

/**
 * 
 */

<<<<<<< HEAD
@Entity
public class Box implements Serializable {

=======

public enum Box implements Serializable{
    
    BOX1(1, false),
    BOX2(2, false),
    BOX3(3, false),
    BOX4(4, false),
    BOX5(5, false),
    BOX6(6, false),
    BOX7(7, false),
    BOX8(8, false);
    
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    private Boolean estado;
    @ManyToOne
    private Medico medico;
<<<<<<< HEAD
     @OneToOne
    private Paciente pacienteActual;
=======
    @OneToMany
    private Consulta consulta;
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    
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