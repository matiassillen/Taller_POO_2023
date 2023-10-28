package Model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_entidad")
public class FuncionarioGeneral extends Persona {

    @JoinColumn(name = "id_Usuario")
    @OneToOne
    private Usuario usu;

    /**
     * Defautl constructor
     */
    public FuncionarioGeneral() {

    }

    /**
     * Constructor con parametros
     *
     * @param usu
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaDeNac
     * @param domicilio
     * @param dni
     * @param telefonoFijo
     * @param telefonoCel
     * @param correoE
     * @param estadoCivil
     */
    public FuncionarioGeneral(Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.usu = usu;
    }

    /**
     * Deprecated Metodo que no se utiliza mas, se agrego similar en otra clase
     *
     * @return
     */
    public Usuario getUsu() {
        return usu;
    }

    /**
     * Deprecated Metodo que no se utiliza mas, se agrego similar en otra clase
     *
     * @param usu
     */
    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

}
