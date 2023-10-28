package Model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idSector;
    private String nombre;
    @OneToMany(mappedBy = "sector")
    private List<FuncAdministrativo> funcAdministrativo;

    /**
     * Default constructor
     */
    public Sector() {
        this.nombre = "";
        this.funcAdministrativo = new ArrayList<>();
    }

    /**
     * Constructor con parametros
     *
     * @param idSector
     * @param nombre
     * @param funcAdministrativo
     */
    public Sector(long idSector, String nombre, List<FuncAdministrativo> funcAdministrativo) {
        this.idSector = idSector;
        this.nombre = nombre;
        this.funcAdministrativo = funcAdministrativo;
    }

    /**
     *
     * @return
     */
    public long getIdSector() {
        return idSector;
    }

    /**
     *
     * @param idSector
     */
    public void setIdSector(long idSector) {
        this.idSector = idSector;
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
    public List<FuncAdministrativo> getFuncAdministrativo() {
        return funcAdministrativo;
    }

    /**
     *
     * @param funcAdministrativo
     */
    public void setFuncAdministrativo(List<FuncAdministrativo> funcAdministrativo) {
        this.funcAdministrativo = funcAdministrativo;
    }

}
