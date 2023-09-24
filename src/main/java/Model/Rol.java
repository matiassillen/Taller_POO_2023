package Model;


import java.util.*;

/**
 * 
 */
public class Rol {

    /**
     * Default constructor
     */
    public Rol() {
        this.nombre = "";
        this.funcionarioGeneral = new ArrayList<FuncionarioGeneral>();
    }

    public Rol(String nombre, ArrayList<FuncionarioGeneral> funcionarioGeneral) {
        this.nombre = nombre;
        this.funcionarioGeneral = funcionarioGeneral;
    }

    /**
     * 
     */
    private String nombre;
    
    /**
     * 
     */
    private ArrayList<FuncionarioGeneral> funcionarioGeneral;

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
    public ArrayList<FuncionarioGeneral> getFuncionarioGeneral() {
        // TODO implement here
        return funcionarioGeneral;
    }
    
    /**
     * @param value
     */
    public void setFuncionarioGeneral(ArrayList<FuncionarioGeneral> funcionarioGeneral) {
        // TODO implement here
        this.funcionarioGeneral = funcionarioGeneral;
    }
    
    /**
     * @return
     */
    @Override
    public String toString() {
        // TODO implement here
        return "Rol{" + "nombre=" + nombre + ", funcionarioGeneral=" + funcionarioGeneral + '}';
    }

}