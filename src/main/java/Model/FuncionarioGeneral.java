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
    
    @JoinColumn(name="id_Usuario")
    @OneToOne
    private Usuario usu;
 
    public FuncionarioGeneral() {
       
    }

    public FuncionarioGeneral(Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.usu = usu;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }


    /**
     * Metodo que genera una ID para el usuario
     * Accede y modifica la variable static idTotales de la clase Funcionario General
     * @return devuelve un entero con el valor de la variable luego de su modificacion
     */
    /**private static int generarId(){
        FuncionarioGeneral.idTotales += 1;
        return FuncionarioGeneral.idTotales;
    }
    */
    
    public void verifLogin() {
        // TODO implement here
    }

   


}

    /**
     * @return retorna el id del propio usuario
     */
    /**
     * 
    public String getIdPersonal() {
       return String.format("%d",idPersonal);
    }
    */

    /**
     * Metodo para que un usuario con privilegios pueda ver la id de otro usuario
     * @param otroFuncionario funcionario a consultar la Id
     * @return retorna el valor de id del funcionario pasado por parametro
     */
//    public String getIdAdministrador(FuncionarioGeneral otroFuncionario){
//        if (this instanceof AdministradorDeSistema){
//            FuncionarioGeneral varTemp2 = otroFuncionario;
//            return String.format("%d", varTemp2.idPersonal);
//        }
//        else {
//            return "Error, usuario sin privilegios necesarios";
//            }
//        }
//    }
    
    // El siguiente metodo debe verificar que un funcionario tenga privilegios