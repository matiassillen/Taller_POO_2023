package Model;



import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
*/

@Entity
public class Titulo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;
    @OneToOne(mappedBy="titulo")
    private Medico medico;
    @OneToOne(mappedBy="titulo")
    private Especialidad especialidad;
    private String universidad;
    private String fecha;

    public Titulo() {
        nombre = null;
        medico = null;
        especialidad = null;
        this.universidad = "";
        this.fecha  = "";
    }

    public Titulo(long idTitulo, String nombre, Medico medico, Especialidad especialidad, String universidad, String fecha) {
        this.id = idTitulo;
        this.nombre = nombre;
        this.medico = medico;
        this.especialidad = especialidad;
        this.universidad = universidad;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}