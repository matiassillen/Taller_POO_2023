package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nomUsuario;
    private String passw;
    @ManyToMany
    @JoinColumn(name = "id_rol")
    private List<Rol> rol;
    @OneToOne(mappedBy = "usu")
    private FuncionarioGeneral funcionarioGeneral;

    /**
     * Default constructor
     */
    public Usuario() {
    }

    /**
     * Constructor con parametros
     *
     * @param id
     * @param nomUsuario
     * @param passw
     * @param rol
     * @param funcionarioGeneral
     */
    public Usuario(long id, String nomUsuario, String passw, List<Rol> rol, FuncionarioGeneral funcionarioGeneral) {
        this.id = id;
        this.nomUsuario = nomUsuario;
        this.passw = passw;
        this.rol = rol;
        this.funcionarioGeneral = funcionarioGeneral;
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
    public String getNomUsuario() {
        return nomUsuario;
    }

    /**
     *
     * @param nomUsuario
     */
    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    /**
     *
     * @return
     */
    public String getPassw() {
        return passw;
    }

    /**
     *
     * @param passw
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     *
     * @return
     */
    public List<Rol> getRol() {
        return rol;
    }

    /**
     *
     * @param rol
     */
    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    public FuncionarioGeneral getFuncionarioGeneral() {
        return funcionarioGeneral;
    }

    /**
     *
     * @param funcionarioGeneral
     */
    public void setFuncionarioGeneral(FuncionarioGeneral funcionarioGeneral) {
        this.funcionarioGeneral = funcionarioGeneral;
    }

}
