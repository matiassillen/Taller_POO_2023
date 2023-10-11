
package Persistencia;

import Model.GestoresHospital;
import Model.Paciente;
import java.util.ArrayList;
import java.util.List;


public class ControladoraPersistencia {
    
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    GestoresHospitalJpaController gestorJpa = new GestoresHospitalJpaController();
    
    public void RegistrarPaciente(Paciente paciente) {
        
        pacienteJpa.create(paciente);
        
    }

    public List<Paciente> traerPaciente() {
        List<Paciente>listaPaciente = pacienteJpa.findPacienteEntities();
        
        return listaPaciente;
    }
    
    //----------CRUD de Usuario----------

    public void crearUsuario(GestoresHospital gestor) {
        gestorJpa.create(gestor);
    }
    
    
}
