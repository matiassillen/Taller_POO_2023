package Model;

import java.util.ArrayList;
public class Medico extends FuncSalud{

    private Box box;
    private ArrayList<Especialidad>especialidad;
    private ArrayList<Triage>triage;
    public Medico() {
    }
    public Medico(Box box, ArrayList<Especialidad>especialidad,ArrayList<Triage>triage) {
         
        this.box = box;
        this.especialidad = especialidad;
        this.triage=triage;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public ArrayList<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(ArrayList<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Triage> getTriage() {
        return triage;
    }

    public void setTriage(ArrayList<Triage> triage) {
        this.triage = triage;
    }
    
    /**
     * @param paciente 
     * @return
    */
    public void tomarPaciente(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerTriage(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerConsulta(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerResultadoEstudios(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerAntecedenteClinico(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public Integer CantidadPacientesAtendidos(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @param edad1 
     * @param edad2 
     * @return
    */
    public Integer PacientesAtendidosPorEdad(String fecha1, String fecha2, String edad1, String edad2) {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public Medico MedicoConMasPacientes(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }
}
