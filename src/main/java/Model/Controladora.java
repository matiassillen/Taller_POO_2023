package Model;

import Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controladoraPersi = new ControladoraPersistencia();
    public void RegistrarPaciente(String nombre, String apellido, String dni, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
        
        Paciente paciente = new Paciente();
        int documento = Integer.parseInt(dni);
        int telfijo = Integer.parseInt(telFijo);
        int telcelular = Integer.parseInt(telCelular);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDNI(documento);
        paciente.setFechaDeNac(fechaNacimiento);
        paciente.setDomicilio(domicilio);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setCorreoE(correo);
        paciente.setTelefonoCel(telfijo);
        paciente.setTelefonoFijo(telcelular);
        paciente.setPersoDeContacto(personaContacto);
        paciente.setTelDeContacto(numContacto);
        
        controladoraPersi.RegistrarPaciente(paciente);
    }

    public List<Paciente> traerPaciente() {
        return controladoraPersi.traerPaciente();
    }
    
}
