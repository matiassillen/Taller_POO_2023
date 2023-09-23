package Model;

import java.util.*;

/**
 *
 */
public class Titulo {

    private Medico medico;
    private Especialidad especialidad;
    private String universidad;
    private String fecha;

    public Titulo() {
    }

    public Titulo(Medico medico, Especialidad especialidad, String universidad, String fecha) {
        this.medico = medico;
        this.especialidad = especialidad;
        this.universidad = universidad;
        this.fecha = fecha;
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
