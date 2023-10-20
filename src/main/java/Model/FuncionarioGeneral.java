package Model;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

<<<<<<< HEAD
=======

>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
@Entity
public class FuncionarioGeneral extends Persona {
    
    @OneToOne
    private Usuario usu;
    
    
    //private static final int idTotales = 0;
    
    //A debatir, si asignar rangos de id con privilegios segun rol o generar id globales
    
    /**
     * Constructor de la clase Funcionario General
     * @param nomUsuario Nombre de usuario para el sistema
     * @param passw contraseña para la cuenta personal
     * @param nombre Nombre real de la persona
     * @param apellido  Apellido real de la persona
     * @param fechaDeNac Fecha de nacimiento de la persona
     * @param domicilio Domicilio de la persona
     * @param dni numero de DNI de la persona
     * @param telefonoFijo Numero de telefono fijo de la persona
     * @param telefonoCel Numero de telefono movil de la persona
     * @param correoE Correo electronico de la persona
     * @param estadoCivil Estado civil de la persona
     */
    
    
    
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