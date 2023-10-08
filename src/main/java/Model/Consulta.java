package Model;

import java.io.Serializable;

public class Consulta implements Serializable {
  
    private Paciente paciente;
    private String fecha;
    private int hora;
    private String diagnConsulta;
    private String lugar;
    private String motivo;
    private Box box;
    private Medico medico;
    private Triage triage;
    
    public Consulta(){}

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDiagnConsulta() {
        return diagnConsulta;
    }

    public void setDiagnConsulta(String diagnConsulta) {
        this.diagnConsulta = diagnConsulta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Triage getTriage() {
        return triage;
    }

    public void setTriage(Triage triage) {
        this.triage = triage;
    }

    @Override
    public String toString() {
        return "Consulta{" + "paciente=" + paciente + ", fecha=" + fecha + ", hora=" + hora + ", diagnConsulta=" + diagnConsulta + ", lugar=" + lugar + ", motivo=" + motivo + ", box=" + box + ", medico=" + medico + ", triage=" + triage + '}';
    }
    
    

}