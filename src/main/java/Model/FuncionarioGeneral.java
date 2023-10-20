package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@Entity
public class FuncionarioGeneral extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nomUsuario;
    private String passw;
    @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol rol; 
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
        this.nomUsuario = "";
        this.passw = "";
        
    }

    public FuncionarioGeneral(long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.id = id;
        this.nomUsuario = nomUsuario;
        this.passw = passw;
        this.rol = rol;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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