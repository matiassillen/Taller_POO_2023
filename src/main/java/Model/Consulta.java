package Model;


import java.util.*;

/**
 * 
 */
public class Consulta {

    /**
     * Default constructor
    */
    public Consulta() {
        
    }

    public Consulta(String fecha, int hora, String diagnConsulta, String lugar, String motivo, Paciente paciente, Box box, Medico medico, Triage triage) {
        this.fecha = fecha;
        this.hora = hora;
        this.diagnConsulta = diagnConsulta;
        this.lugar = lugar;
        this.motivo = motivo;
        this.paciente = paciente;
        this.box = box;
        this.medico = medico;
        this.triage = triage;
    }
    
    /**
     * 
    */
    private String fecha;

    /**
     * 
     */
    private int hora;

    /**
     * 
    */
    private String diagnConsulta;

    /**
     * 
     */
    private String lugar;

    /**
     * 
     */
    private String motivo;
    
     /**
     * 
     */
    private Paciente paciente;
    
     /**
     * 
     */
    private Box box;
    
    /**
     * 
    */
    private Medico medico;
    
     /**
     * 
     */
    private Triage triage;

    /**
     * @return
    */
    public String getFecha() {
        // TODO implement here
        return fecha;
    }
    
    /**
     * @param value
    */
    public void setFecha(String fecha) {
        // TODO implement here
        this.fecha = fecha;
    }

    /**
     * @return
     */
    public int getHora() {
        // TODO implement here
        return hora;
    }

    /**
     * @param value
     */
    public void setHora(int hora) {
        // TODO implement here
        this.hora = hora;
    }

    /**
     * @return
    */
    public String getDiagnConsulta() {
        // TODO implement here
        return diagnConsulta;
    }

    /**
     * @param value
    */
    public void setDiagnConsulta(String diagnConsulta) {
        // TODO implement here
        this.diagnConsulta = diagnConsulta;
    }

    /**
     * @return
     */
    public String getLugar() {
        // TODO implement here
        return lugar;
    }

    /**
     * @param value
     */
    public void setLugar(String lugar) {
        // TODO implement here
        this.lugar = lugar;
    }

    /**
     * @return
     */
    public String getMotivo() {
        // TODO implement here
        return motivo;
    }

    /**
     * @param value
     */
    public void setMotivo(String motivo) {
        // TODO implement here
        this.motivo = motivo;
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
    public Box getBox() {
        // TODO implement here
        return box;
    }
    
    /**
     * @param value
     */
    public void setBox(Box box) {
        // TODO implement here
        this.box = box;
    }
    
    /**
     * @return

    public Medico getMedico() {
        // TODO implement here
        return medico;
    }
    
    /**
     * @param value
    */
    public void setMedico(Medico medico) {
        // TODO implement here
        this.medico = medico;
    }
    
    /**
     * @return
     */
    public Triage getTriage() {
        // TODO implement here
        return triage;
    }
    
    /**
     * @param value
     */
    public void setTriage(Triage triage) {
        // TODO implement here
        this.triage = triage;
    }
    
    /**
     * @return
    */
    @Override
    public String toString() {
        return "Consulta{" + "fecha=" + fecha + ", hora=" + hora + ", diagnConsulta=" + diagnConsulta + ", lugar=" + lugar + ", motivo=" + motivo + ", paciente=" + paciente + ", box=" + box + ", medico=" + medico + ", triage=" + triage + '}';
    }

}