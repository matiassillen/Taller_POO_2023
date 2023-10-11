package Model;


import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
<<<<<<< Updated upstream
import java.util.List;
=======
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
>>>>>>> Stashed changes

@Entity
public class Recepcionista extends FuncionarioGeneral {
    
<<<<<<< Updated upstream
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
=======
    ControladoraPersistencia control; 
    
    @ManyToMany
>>>>>>> Stashed changes
    private ArrayList <Paciente> paciente;

    public Recepcionista() {
       control = new ControladoraPersistencia();
        this.paciente = new ArrayList<Paciente>();
    }
    
    public Recepcionista(ArrayList<Paciente> paciente, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.paciente = paciente;
        control = new ControladoraPersistencia();
    }
    
    public ArrayList<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(ArrayList<Paciente> paciente) {
        this.paciente = paciente;
    }

    
    
    public int BuscarPaciente (int dni){
        
        return 0;
    }
    
    
    public void CrearConsulta(){
    }
    
    public void AniadirAListaDeEsperaTriage(){
    
    }

    public void RegistrarPaciente(String nombre, String apellido, String dni, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
        Paciente paciente = new Paciente();
        int documento = Integer.parseInt(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(documento);
        paciente.setFechaDeNac(fechaNacimiento);
        paciente.setDomicilio(domicilio);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setCorreoE(correo);
        paciente.setTelefonoCel(telFijo);
        paciente.setTelefonoFijo(telCelular);
        paciente.setPersoDeContacto(personaContacto);
        paciente.setTelDeContacto(numContacto);
        
        controlPersis.RegistrarPaciente(paciente);
    }
    
    

    public List<Paciente> traerPaciente() {
        
        return controlPersis.traerPaciente();
    }
    
    @Override
    public String toString() {
        return "Recepcionista{" + "paciente=" + paciente + '}';
    }
}
