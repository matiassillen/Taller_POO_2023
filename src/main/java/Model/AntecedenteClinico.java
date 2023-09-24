package Model;


import java.util.*;

/**
 * 
 */
public class AntecedenteClinico {

    /**
     * Default constructor
     */
    public AntecedenteClinico() {
        
    }

    public AntecedenteClinico(String nombreDiagnostico, String fecha, String hora, Medico medico, Paciente paciente) {
        this.nombreDiagnostico = nombreDiagnostico;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
    }
    
    /**
     * 
     */
    private String nombreDiagnostico;

    /**
     * 
     */
    private String fecha;

    /**
     * 
     */
    private String hora;

    /**
     * 
     */
    private Medico medico;
    
    /**
     * 
     */
    private Paciente paciente;
    
    /**
     * @return
     */
    public String getNombreDiagnostico() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getFecha() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getHora() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getMedico() {
        // TODO implement here
        return "";
    }
    
    /**
     * @return
     */
    public Paciente getPaciente() {
        // TODO implement here
        return paciente;
    }

    /**
     * @param value
     */
    public void setPaciente(Paciente paciente) {
        // TODO implement here
        this.paciente = paciente;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "AntecedenteClinico{" + "nombreDiagnostico=" + nombreDiagnostico + ", fecha=" + fecha + ", hora=" + hora + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
}