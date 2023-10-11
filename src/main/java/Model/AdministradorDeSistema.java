package Model;

//import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import javax.persistence.Entity;

@Entity
public class AdministradorDeSistema extends FuncAdministrativo{
    
    //ControladoraPersistencia controlPersis;
    
    private ArrayList<FuncionarioGeneral> funcionarioGeneral;
    
    public AdministradorDeSistema() {
        //controlPersis = new ControladoraPersistencia();
        funcionarioGeneral = new ArrayList<FuncionarioGeneral>();
    }

    public AdministradorDeSistema(ArrayList<FuncionarioGeneral> funcionarioGeneral, Sector sector, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(sector, id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.funcionarioGeneral = funcionarioGeneral;
    }

    public ArrayList<FuncionarioGeneral> getFuncionarioGeneral() {
        return funcionarioGeneral;
    }

    public void setFuncionarioGeneral(ArrayList<FuncionarioGeneral> funcionarioGeneral) {
        this.funcionarioGeneral = funcionarioGeneral;
    }

    public void ModificarUsuario() {
        // TODO implement here
        
    }
    
    /**
     * @return
    */
    public void VerInfoAdministrativa() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void BuscarUsuario() {
        // TODO implement here
        
    }

    public void crearUsuario(String nombre, String apellido, String fechaNacimiento, String dni, String correoElectronico, String telFijo, String telCelular, String estadoCivil, String domicilio, String nombreUsuario, String contrasenia, ArrayList<String> rol) {
        
         for (String  roles : rol) {
            
            if (roles.equalsIgnoreCase("Gestor")) {
                GestoresHospital gestor = new GestoresHospital();
                                
                  int documento = Integer.parseInt(dni);
                    
                  gestor.setNombre(nombre);
                  gestor.setApellido(apellido);
                  gestor.setFechaDeNac(fechaNacimiento);
                  gestor.setDni(documento);
                  gestor.setCorreoE(correoElectronico);
                  gestor.setTelefonoFijo(telFijo);
                  gestor.setTelefonoCel( telFijo);
                  gestor.setEstadoCivil(estadoCivil);
                  gestor.setDomicilio(domicilio);
                  gestor.setNomUsuario(nombreUsuario);
                  gestor.setPassw(contrasenia);
                  
                  
                  //controlPersis.crearUsuario(gestor);
                  
                   
            }
           
        } 

        
    }

    
    /**
     * @return
     */
    

}
