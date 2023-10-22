package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Medico extends FuncionarioGeneral {
    
    private String numMat;
    @ManyToMany
    @JoinColumn(name="id_especialidad")
    private List<Especialidad> especialidad;
    @OneToMany
    private List<Consulta> consulta;
    @OneToOne
    @JoinColumn(name="id_titulo")
    private Titulo titulo;
 
    public Medico() {
        this.numMat = null;
        this.especialidad = new ArrayList<>();
        this.consulta = new ArrayList<>();
        this.titulo = null;
    }

    public Medico(String numMat, List<Especialidad> especialidad, List<Consulta> consulta, Titulo titulo, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.numMat = numMat;
        this.especialidad = especialidad;
        this.consulta = consulta;
        this.titulo = titulo;
    }

    public String getNumMat() {
        return numMat;
    }

    public void setNumMat(String numMat) {
        this.numMat = numMat;
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
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

   
}
