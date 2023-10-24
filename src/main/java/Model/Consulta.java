package Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Paciente paciente;
    private LocalDate fecha;
    private String hora;
    private String diagnConsulta;
    private String lugar;
    private String motivo;
    @OneToOne
    @JoinColumn(name="id_box")
    private Box box;
    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;
    @OneToOne
    @JoinColumn(name="id_triage")
    private Triage triage;
    
    public Consulta(){
        
    }

    public Consulta(int numConsulta, Paciente paciente, LocalDate fecha, String hora, String diagnConsulta, String lugar, String motivo, Box box, Medico medico, Triage triage) {
        this.id = numConsulta;
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

    public int getId() {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

}