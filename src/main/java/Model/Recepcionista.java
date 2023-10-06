package Model;


import java.util.ArrayList;


public class Recepcionista extends FuncionarioGeneral {
    private ArrayList <Paciente> paciente;

    public Recepcionista(String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }
    
    public Recepcionista(ArrayList<Paciente> paciente, String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
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
    
    public void RegisPaciente(String nombre,String apellido,String dni,String fechaNacimiento,String domicilio,String estadoCivil,String correo,String telCelular,String telFijo,String personaContacto,String numContacto){
        
    }
    
    public void CrearConsulta(){
    }
    
    public void AniadirAListaDeEsperaTriage(){
    
    }
    
    
}
