
package Persistencia;

import Model.Paciente;


public class ControladoraPersistencia {
    
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    
    public void RegistrarPaciente(Paciente paciente) {
        
        pacienteJpa.create(paciente);
        
    }
    
}
