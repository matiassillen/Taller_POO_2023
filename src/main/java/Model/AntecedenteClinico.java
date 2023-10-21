package Model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class AntecedenteClinico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int numAntecedente;
    @ManyToOne
    private Paciente paciente;
    private String nombreDiagnostico;
    private String fecha;
    private String hora;
    @OneToOne
    private Medico medico;
    
    public AntecedenteClinico() {
        
    }

    public AntecedenteClinico(int numAntecedente, String nombreDiagnostico, String fecha, String hora, Medico medico, Paciente paciente) {
        this.numAntecedente = numAntecedente;
        this.nombreDiagnostico = nombreDiagnostico;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }

    public int getNumAntecedente() {
        return numAntecedente;
    }
    
    public void setNumAntecedente(int numAntecedente) {
        this.numAntecedente = numAntecedente;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "AntecedenteClinico{" + "nombreDiagnostico=" + nombreDiagnostico + ", fecha=" + fecha + ", hora=" + hora + ", medico=" + medico + ", paciente=" + paciente + '}';
    }

    
}