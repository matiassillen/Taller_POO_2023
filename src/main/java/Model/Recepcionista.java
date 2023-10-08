package Model;


import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;


public class Recepcionista extends FuncionarioGeneral {
    
    ControladoraPersistencia controladoraPersi = new ControladoraPersistencia();
    private ArrayList <Paciente> paciente;

    public Recepcionista() {
    }

    public Recepcionista(ArrayList<Paciente> paciente, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.paciente = paciente;
    }
    
    public ArrayList<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(ArrayList<Paciente> paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "paciente=" + paciente + '}';
    }
    
    public int BuscarPaciente (int dni){
        
        return 0;
    }
    
    
    public void CrearConsulta(){
    }
    
    public void AniadirAListaDeEsperaTriage(){
    
    }

    public void RegistrarPaciente(String nombre, String apellido, String dni, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
        
    }
    
    
}
