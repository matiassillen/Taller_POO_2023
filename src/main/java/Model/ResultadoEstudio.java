package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultadoEstudio implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Paciente paciente;
    private String nombre;
    private String Informe;
    private String hora;
    private String fecha;
    
    public ResultadoEstudio() {
        this.paciente = null;
        this.nombre = null;
        this.Informe = null;
        this.hora = null;
        this.fecha = null;
    }

    public ResultadoEstudio(long id, Paciente paciente, String nombre, String Informe, String hora, String Fecha) {
        this.id = id;
        this.paciente = paciente;
        this.nombre = nombre;
        this.Informe = Informe;
        this.hora = hora;
        this.fecha = Fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInforme() {
        return Informe;
    }

    public void setInforme(String Informe) {
        this.Informe = Informe;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}