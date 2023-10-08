
package Persistencia;

import Model.Paciente;
import java.util.List;


public class ControladoraPersistencia {
    
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    
    public void RegistrarPaciente(Paciente paciente) {
        
        pacienteJpa.create(paciente);
        
    }

    public List<Paciente> traerPaciente() {
        List<Paciente>listaPaciente = pacienteJpa.findPacienteEntities();
        
        return listaPaciente;
    }
    
}
