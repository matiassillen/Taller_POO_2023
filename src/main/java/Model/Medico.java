package Model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Medico extends FuncSalud{
    
    private int numMatriculaProfesional;
    
    private Box box;
    @ManyToMany
    private ArrayList<Especialidad>especialidad;
    @ManyToMany
    private ArrayList<Triage>triage;
    @ManyToMany
    private ArrayList<Consulta> consulta;
 
    public Medico() {
        box = null;
        especialidad = new ArrayList<Especialidad>();
        triage = new ArrayList<Triage>();
        consulta = new ArrayList<Consulta>();
        
    }

    public Medico(Box box, ArrayList<Especialidad> especialidad, ArrayList<Triage> triage, ArrayList<Consulta> consulta, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.box = box;
        this.especialidad = especialidad;
        this.triage = triage;
        this.consulta = consulta;
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

    public ArrayList<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(ArrayList<Consulta> consulta) {
        this.consulta = consulta;
    }

    public int getNumMatriculaProfesional() {
        return numMatriculaProfesional;
    }

    public void setNumMatriculaProfesional(int numMatriculaProfesional) {
        this.numMatriculaProfesional = numMatriculaProfesional;
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
