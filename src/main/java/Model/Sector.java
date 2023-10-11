package Model;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 */

@Entity
public class Sector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_Sector;
    private String Nombre;
    @ManyToMany
    private ArrayList<FuncAdministrativo> funcAdministrativo;
    
    
    /**
     * Default constructor
     */
    public Sector() {
        this.Nombre = "";
        this.funcAdministrativo = new ArrayList<FuncAdministrativo>();
    }

    public Sector(long id_Sector, String Nombre, ArrayList<FuncAdministrativo> funcAdministrativo) {
        this.id_Sector = id_Sector;
        this.Nombre = Nombre;
        this.funcAdministrativo = funcAdministrativo;
    }

    public long getId_Sector() {    
        return id_Sector;
    }

    /**
     * 
     */
    /**
     * 
     */
    public void setId_Sector(long id_Sector) {    
        this.id_Sector = id_Sector;
    }

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setNombre(String value) {
        // TODO implement here
    }
    
    /**
     * @return
     */
    public ArrayList<FuncAdministrativo> getFuncAdministrativo() {
        // TODO implement here
        return funcAdministrativo;
    }

    /**
     * @return
     */
    public void setFuncAdministrativo(ArrayList<FuncAdministrativo> funcAdministrativo) {
        // TODO implement here
        this.funcAdministrativo = funcAdministrativo;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Sector{" + "Nombre=" + Nombre + ", funcAdministrativo=" + funcAdministrativo + '}';
    }
}