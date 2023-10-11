package Model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
@Entity
public class Especialidad {
    @Id
    private String nombreEspecialidad;
    @ManyToMany
    private ArrayList<Medico> medico;

    public Especialidad() {
        this.nombreEspecialidad = "";
        this.medico = new ArrayList<Medico>();
    }

    public Especialidad(String nombreEspecialidad, ArrayList<Medico> medico) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.medico = medico;
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