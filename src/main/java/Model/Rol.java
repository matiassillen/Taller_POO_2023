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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_rol;
    private String nombre;
    @ManyToMany(mappedBy = "rol")
    private List<Usuario> usuario;

    /**
     * Default constructor
     */
    public Rol() {
        this.nombre = "";
        this.usuario = new ArrayList<>();
    }

    /**
     * Constructo con parametros
     *
     * @param id_rol
     * @param nombre
     * @param usuario
     */
    public Rol(long id_rol, String nombre, List<Usuario> usuario) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public long getId_rol() {
        return id_rol;
    }

    /**
     *
     * @param id_rol
     */
    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

}
