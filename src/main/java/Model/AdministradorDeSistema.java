package Model;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AdministradorDeSistema extends FuncAdministrativo{
    
    Controladora control;
    ControladoraPersistencia controlPersis;

    @OneToMany
    private ArrayList<FuncionarioGeneral> funcionarioGeneral;
    
    public AdministradorDeSistema() {
        control = new Controladora();
        controlPersis = new ControladoraPersistencia();
        funcionarioGeneral = new ArrayList<FuncionarioGeneral>();
    }

    public AdministradorDeSistema(ArrayList<FuncionarioGeneral> funcionarioGeneral, Sector sector, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(sector, id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.funcionarioGeneral = funcionarioGeneral;
        control = new Controladora();
        controlPersis = new ControladoraPersistencia();
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

//    public void crearUsuario(String nombre, String apellido, String fechaNacimiento, String dni, String correoElectronico, String telFijo, String telCelular, String estadoCivil, String domicilio, String nombreUsuario, String contrasenia, ArrayList<String> rol) {
//        
//         
//           
//        } 

    public void crearUsuario(String nombre, String apellido, String FechaNacimiento, int documento, String domicilio, String telFijo, String telCel, String correoE, String estadoCivil, String nombreUsuario, String contrasenia, String rolRecibido) {
        
        if (rolRecibido.equalsIgnoreCase("Gestor")) {
            
            GestoresHospital gestor = new GestoresHospital();
            
            gestor.setNombre(nombre);
            gestor.setApellido(apellido);
            gestor.setFechaDeNac(FechaNacimiento);
            gestor.setDni(documento);
            gestor.setDomicilio(domicilio);
            gestor.setTelefonoFijo(telFijo);
            gestor.setTelefonoCel(telCel);
            gestor.setCorreoE(correoE);
            gestor.setEstadoCivil(estadoCivil);
            gestor.setNomUsuario(nombreUsuario);
            gestor.setPassw(contrasenia);
            
            
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                gestor.setRol(rolEncontrado);
            }
            
            controlPersis.crearGestor(gestor);
        }
        
        if (rolRecibido.equalsIgnoreCase("Recepcionista")) {
            
            Recepcionista recepcionista = new Recepcionista();
            
            recepcionista.setNombre(nombre);
            recepcionista.setApellido(apellido);
            recepcionista.setFechaDeNac(FechaNacimiento);
            recepcionista.setDni(documento);
            recepcionista.setDomicilio(domicilio);
            recepcionista.setTelefonoFijo(telFijo);
            recepcionista.setTelefonoCel(telCel);
            recepcionista.setCorreoE(correoE);
            recepcionista.setEstadoCivil(estadoCivil);
            recepcionista.setNomUsuario(nombreUsuario);
            recepcionista.setPassw(contrasenia);
            
            
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                recepcionista.setRol(rolEncontrado);
            }
            
            controlPersis.crearRecepcionista(recepcionista);
        }
        
        if (rolRecibido.equalsIgnoreCase("Medico")) {
            
            Medico medico = new Medico();
            
            medico.setNombre(nombre);
            medico.setApellido(apellido);
            medico.setFechaDeNac(FechaNacimiento);
            medico.setDni(documento);
            medico.setDomicilio(domicilio);
            medico.setTelefonoFijo(telFijo);
            medico.setTelefonoCel(telCel);
            medico.setCorreoE(correoE);
            medico.setEstadoCivil(estadoCivil);
            medico.setNomUsuario(nombreUsuario);
            medico.setPassw(contrasenia);
            
            
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                medico.setRol(rolEncontrado);
            }
            
            controlPersis.crearMedico(medico);
        }
        
        if (rolRecibido.equalsIgnoreCase("Licenciado en Enfermeria")) {
            
            LicEnEnfermeria licEnEnfermeria = new LicEnEnfermeria();
            
            licEnEnfermeria.setNombre(nombre);
            licEnEnfermeria.setApellido(apellido);
            licEnEnfermeria.setFechaDeNac(FechaNacimiento);
            licEnEnfermeria.setDni(documento);
            licEnEnfermeria.setDomicilio(domicilio);
            licEnEnfermeria.setTelefonoFijo(telFijo);
            licEnEnfermeria.setTelefonoCel(telCel);
            licEnEnfermeria.setCorreoE(correoE);
            licEnEnfermeria.setEstadoCivil(estadoCivil);
            licEnEnfermeria.setNomUsuario(nombreUsuario);
            licEnEnfermeria.setPassw(contrasenia);
            
            
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                licEnEnfermeria.setRol(rolEncontrado);
            }
            
            controlPersis.crearLicEnEnfermeria(licEnEnfermeria);
        }
        
        if (rolRecibido.equalsIgnoreCase("Administrador de sistema")) {
            
            AdministradorDeSistema administrador = new AdministradorDeSistema();
            
            administrador.setNombre(nombre);
            administrador.setApellido(apellido);
            administrador.setFechaDeNac(FechaNacimiento);
            administrador.setDni(documento);
            administrador.setDomicilio(domicilio);
            administrador.setTelefonoFijo(telFijo);
            administrador.setTelefonoCel(telCel);
            administrador.setCorreoE(correoE);
            administrador.setEstadoCivil(estadoCivil);
            administrador.setNomUsuario(nombreUsuario);
            administrador.setPassw(contrasenia);
            
            
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                administrador.setRol(rolEncontrado);
            }
            
            controlPersis.crearAdministrador(administrador);
        }
        
        
        
    }

    
}
