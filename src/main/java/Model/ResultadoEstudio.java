package Model;


import java.util.*;

/**
 * 
 */
public class ResultadoEstudio {

    /**
     * Default constructor
     */
    public ResultadoEstudio() {
        
    }

    public ResultadoEstudio(String nombre, String Informe, String hora, String Fecha, Paciente paciente) {
        this.nombre = nombre;
        this.Informe = Informe;
        this.hora = hora;
        this.Fecha = Fecha;
        this.paciente = paciente;
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String Informe;

    /**
     * 
     */
    private String hora;

    /**
     * 
     */
    private String Fecha;
    
    /**
     * 
     */
    private Paciente paciente;

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getInforme() {
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
    public String getFecha() {
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
        return "ResultadoEstudio{" + "nombre=" + nombre + ", Informe=" + Informe + ", hora=" + hora + ", Fecha=" + Fecha + ", paciente=" + paciente + '}';
    }

}