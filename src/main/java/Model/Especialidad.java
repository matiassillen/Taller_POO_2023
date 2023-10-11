package Model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
@Entity
public class Especialidad {
    @Id
    private String nombreEspecialidad;
    @ManyToMany
    private ArrayList<Medico> medico;

    public Especialidad() {
        this.nombreEspecialidad = "";
        this.medico = new ArrayList<Medico>();
    }

<<<<<<< HEAD
    public Especialidad(String nombreEspecialidad, ArrayList<Medico> medico, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
=======
    public Especialidad(String nombreEspecialidad, ArrayList<Medico> medico) {
>>>>>>> 59cc8ba46e2c03981dc4685c111025819b7b014f
        this.nombreEspecialidad = nombreEspecialidad;
        this.medico = medico;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public ArrayList<Medico> getMedico() {
        return medico;
    }

    public void setMedico(ArrayList<Medico> medico) {
        this.medico = medico;
    }

}