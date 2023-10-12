
package Persistencia;

import Model.AdministradorDeSistema;
import Model.GestoresHospital;
import Model.LicEnEnfermeria;
import Model.Medico;
import Model.Paciente;
import Model.Recepcionista;
import Model.Rol;
import java.util.List;

/**
 *
 * @author Matías Sillen Ríos
 */
public class ControladoraPersistencia {
    
    PacienteJpaController pacientee = new PacienteJpaController();
    RolJpaController rolJpa = new RolJpaController();
    GestoresHospitalJpaController gestorJpa = new GestoresHospitalJpaController();
    RecepcionistaJpaController recepcionistaJpa = new RecepcionistaJpaController();
    MedicoJpaController medicoJpa = new MedicoJpaController();
    LicEnEnfermeriaJpaController licEnEnfermeriaJpa = new LicEnEnfermeriaJpaController();
    AdministradorDeSistemaJpaController administradorJpa = new AdministradorDeSistemaJpaController();
    
    //----------CRUD de Paceinte----------

    public void RegistrarPaciente(Paciente paciente) {
        pacientee.create(paciente);
        
    }

    public List<Paciente> traerPaciente() {
        return pacientee.findPacienteEntities();
    }

    //----------CRUD de Usuario----------
    
    // Metodo para crear los ususarios
    
    public void crearGestor(GestoresHospital gestor) {
        gestorJpa.create(gestor);
    }
    
    public void crearRecepcionista(Recepcionista recepcionista) {
        recepcionistaJpa.create(recepcionista);
    }
    
    public void crearMedico(Medico medico) {
        medicoJpa.create(medico);
    }
    
    public void crearLicEnEnfermeria(LicEnEnfermeria licEnEnfermeria) {
        licEnEnfermeriaJpa.create(licEnEnfermeria);
    }
    
    public void crearAdministrador(AdministradorDeSistema administrador) {
        administradorJpa.create(administrador);
    }    
    
    //----------Rol----------
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

}
