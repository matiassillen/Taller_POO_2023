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
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Paciente paciente;
    private String nombreDiagnostico;
    private String fecha;
    private String hora;
    private String descripcion;
    @ManyToOne
    private Medico medico;
    
    public DiagnosticoClinico() {
        this.paciente = null;
        this.nombreDiagnostico = null;
        this.fecha = null;
        this.hora = null;
        this.descripcion = null;
        this.medico = null;

    }

    public DiagnosticoClinico( Paciente paciente, String nombreDiagnostico, String fecha, String hora, String descripcion, Medico medico) {
        this.paciente = paciente;
        this.nombreDiagnostico = nombreDiagnostico;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.medico = medico;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}