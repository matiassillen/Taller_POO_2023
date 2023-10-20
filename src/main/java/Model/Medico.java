package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Transient;


@Entity
public class Medico extends FuncSalud implements Serializable{
    
    private int numMatriculaProfesional;
    @Transient
    private Box box;
    @ManyToMany
    private List<Especialidad> especialidad;
    @OneToMany
    private List<Triage> triage;
    @OneToMany
    private List<Consulta> consulta;
    @ManyToOne
    private Titulo titulo;
 
    public Medico() {
        box = null;
        especialidad = new ArrayList<>();
        triage = new ArrayList<>();
        consulta = new ArrayList<>();
        
    }

    public Medico(int numMatriculaProfesional, Box box, List<Especialidad> especialidad, List<Triage> triage, List<Consulta> consulta, Titulo titulo, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.numMatriculaProfesional = numMatriculaProfesional;
        this.box = box;
        this.especialidad = especialidad;
        this.triage = triage;
        this.consulta = consulta;
        this.titulo = titulo;
    }

    public int getNumMatriculaProfesional() {
        return numMatriculaProfesional;
    }

    public void setNumMatriculaProfesional(int numMatriculaProfesional) {
        this.numMatriculaProfesional = numMatriculaProfesional;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public List<Triage> getTriage() {
        return triage;
    }

    public void setTriage(List<Triage> triage) {
        this.triage = triage;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
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
