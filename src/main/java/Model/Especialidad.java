package Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
@Entity
public class Especialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombreEspecialidad;
    @ManyToMany
    private ArrayList<Medico> medico;

    public Especialidad() {
        this.nombreEspecialidad = "";
        medico = new ArrayList<Medico>();
    }

    public Especialidad(String nombreEspecialidad, ArrayList<Medico> medico) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.medico = medico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public ArrayList<Medico> getMedico() {
        return medico;
    }

    public void setMedico(ArrayList<Medico> medico) {
        this.medico = medico;
    }
   
}