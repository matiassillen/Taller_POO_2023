package Model;


import java.util.*;

/**
 * 
 */
public class Sector {

    /**
     * Default constructor
     */
    public Sector() {
        this.Nombre = "";
        this.funcAdministrativo = new ArrayList<FuncAdministrativo>();
    }

    public Sector(String Nombre, ArrayList<FuncAdministrativo> funcAdministrativo) {
        this.Nombre = Nombre;
        this.funcAdministrativo = funcAdministrativo;
    }

    /**
     * 
     */
    private String Nombre;
    
    /**
     * 
     */
    private ArrayList<FuncAdministrativo> funcAdministrativo;

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