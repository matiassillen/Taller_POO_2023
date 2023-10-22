package Model;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id_rol;
    private String nombre;
    @ManyToMany(mappedBy="rol") 
    private List<Usuario> usuario;
    
    /**
     * Default constructor
     */
    public Rol() {
        this.nombre = "";
        this.usuario = new ArrayList<>();
    }

    public Rol(long id_rol, String nombre, List<Usuario> usuario) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.usuario = usuario;
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

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
 
    /**
     * @return
     */
    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", nombre=" + nombre + ", usuario=" + usuario + '}';
    }

}