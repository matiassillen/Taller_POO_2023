package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;
    @ManyToMany(mappedBy = "especialidad")
    private List<Medico> medico;
    @OneToOne
    @JoinColumn(name = "id_titulo")
    private Titulo titulo;

    /**
     * Default constructor
     */
    public Especialidad() {
        medico = new ArrayList<>();
    }

    /**
     * Constructor con parametros
     *
     * @param id
     * @param nombre
     * @param medico
     * @param titulo
     */
    public Especialidad(long id, String nombre, List<Medico> medico, Titulo titulo) {
        this.id = id;
        this.nombre = nombre;
        this.medico = medico;
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public List<Medico> getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(List<Medico> medico) {
        this.medico = medico;
    }

    /**
     *
     * @return
     */
    public Titulo getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

}
