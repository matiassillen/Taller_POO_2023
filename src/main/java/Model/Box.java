package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Box implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(mappedBy = "box")
    private Consulta consulta;

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * constructor parametrizado que toma un id y una consulta
     *
     * @param id
     * @param consulta
     */
    public Box(long id, Consulta consulta) {
        this.id = id;
        this.consulta = consulta;
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
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     *
     * @param consulta
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

}
