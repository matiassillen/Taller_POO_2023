package Model;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Sector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idSector;
    private String nombre;
    @ManyToMany
    private ArrayList<FuncAdministrativo> funcAdministrativo;
    
    
    /**
     * Default constructor
     */
    public Sector() {
        this.nombre = "";
        this.funcAdministrativo = new ArrayList<FuncAdministrativo>();
    }

    public Sector(long idSector, String nombre, ArrayList<FuncAdministrativo> funcAdministrativo) {
        this.idSector = idSector;
        this.nombre = nombre;
        this.funcAdministrativo = funcAdministrativo;
    }

    public long getIdSector() {    
        return idSector;
    }

    public void setIdSector(long idSector) {    
        this.idSector = idSector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return
     */
    public ArrayList<FuncAdministrativo> getFuncAdministrativo() {
        return funcAdministrativo;
    }

    /**
     * @return
     */
    public void setFuncAdministrativo(ArrayList<FuncAdministrativo> funcAdministrativo) {
        this.funcAdministrativo = funcAdministrativo;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Sector{" + "Nombre=" + nombre + ", funcAdministrativo=" + funcAdministrativo + '}';
    }
}