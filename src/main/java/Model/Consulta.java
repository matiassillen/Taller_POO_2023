package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int numConsulta;
    @ManyToOne
    private Paciente paciente;
    private Date fecha;
    private Long hora;
    private String diagnConsulta;
    private String lugar;
    private String motivo;
    @OneToOne
    private Box box;
    @ManyToOne
    private Medico medico;
    @OneToOne
    private Triage triage;
    
    public Consulta(){}

    public Consulta(int numConsulta, Paciente paciente, Date fecha, Long hora, String diagnConsulta, String lugar, String motivo, Box box, Medico medico, Triage triage) {
        this.numConsulta = numConsulta;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnConsulta = diagnConsulta;
        this.lugar = lugar;
        this.motivo = motivo;
        this.box = box;
        this.medico = medico;
        this.triage = triage;
    }

    public int getNumConsulta() {
        return numConsulta;
    }

    public void setNumConsulta(int numConsulta) {
        this.numConsulta = numConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
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