package Model;



import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
*/

@Entity
public class Titulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idTitulo;
    @OneToOne
    private Medico medico;
    @OneToOne
    private Especialidad especialidad;
    private String universidad;
    private String fecha;

    public Titulo() {
        medico = null;
        especialidad = null;
        this.universidad = "";
        this.fecha  = "";
    }

    public Titulo(long idTitulo, Medico medico, Especialidad especialidad, String universidad, String fecha) {
        this.idTitulo = idTitulo;
        this.medico = medico;
        this.especialidad = especialidad;
        this.universidad = universidad;
        this.fecha = fecha;
    }

    public long getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(long idTitulo) {
        this.idTitulo = idTitulo;
    }
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Titulo{" + "medico=" + medico + ", especialidad=" + especialidad + ", universidad=" + universidad + ", fecha=" + fecha + '}';
    }
}