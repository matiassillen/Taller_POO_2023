package Model;


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
public class Rol {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id_rol;
    private String nombre;
    @ManyToMany
    private ArrayList<FuncionarioGeneral> funcionarioGeneral;

    
    
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

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
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