package Model;

import java.io.Serializable;



public class AntecedenteClinico implements Serializable {
    
    private Paciente paciente;
    private String nombreDiagnostico;
    private String fecha;
    private String hora;
    private Medico medico;
    
    
    public AntecedenteClinico() {
        
    }

    public AntecedenteClinico(String nombreDiagnostico, String fecha, String hora, Medico medico, Paciente paciente) {
        this.nombreDiagnostico = nombreDiagnostico;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
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