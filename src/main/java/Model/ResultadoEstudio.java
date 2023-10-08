package Model;

import java.io.Serializable;

public class ResultadoEstudio implements Serializable {
   
    private Paciente paciente;
    private String nombre;
    private String Informe;
    private String hora;
    private String Fecha;
    
    
    public ResultadoEstudio() {
        
    }

    public ResultadoEstudio(String nombre, String Informe, String hora, String Fecha, Paciente paciente) {
        this.nombre = nombre;
        this.Informe = Informe;
        this.hora = hora;
        this.Fecha = Fecha;
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
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "ResultadoEstudio{" + "nombre=" + nombre + ", Informe=" + Informe + ", hora=" + hora + ", Fecha=" + Fecha + ", paciente=" + paciente + '}';
    }

    

}