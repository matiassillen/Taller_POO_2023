
package Persistencia;

import Model.Box;
import Model.Consulta;
import Model.DiagnosticoClinico;
import Model.FuncionarioGeneral;
import Model.Medico;
import Model.Paciente;
import Model.ResultadoEstudio;
import Model.Rol;
import Model.Triage;
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia implements Serializable{
    
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    FuncionarioGeneralJpaController funcionarioGeneralJpa = new FuncionarioGeneralJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    MedicoJpaController medicoJpa = new MedicoJpaController();
    TriageJpaController triageJpa = new TriageJpaController();
    ConsultaJpaController consultaJpa = new ConsultaJpaController();
    SectorJpaController sectorJpa = new SectorJpaController();
    TituloJpaController tituloJpa = new TituloJpaController();
    ResultadoEstudioJpaController resEstudioJpa = new ResultadoEstudioJpaController();
    FuncAdministrativoJpaController funcAdminJpa = new FuncAdministrativoJpaController();
    EspecialidadJpaController especialidadJpa = new EspecialidadJpaController();
    DiagnosticoClinicoJpaController diagnosticoJpa = new DiagnosticoClinicoJpaController();
    BoxJpaController boxJpa = new BoxJpaController();
    
    //---------Metodos para Paciente---------

    public void RegistrarPaciente(Paciente paciente) {
        pacienteJpa.create(paciente);
        
    }

    public List<Paciente> traerPacientes() {
        return pacienteJpa.findPacienteEntities();
    }
    
    public Paciente traerPaciente(int id_Paciente) {
        
        return pacienteJpa.findPaciente(id_Paciente);
    }

    public void CrearConsulta(Consulta consu) {
        this.consultaJpa.create(consu);
    }

    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
        return funcionarioGeneralJpa.findFuncionarioGeneralEntities();
    }

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public Usuario traerUsuarios(long idUsuario) {
        return usuJpa.findUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usuario) {
        try {
            usuJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }

    public Medico traerMedico(long idUsuario) {
        return medicoJpa.findMedico(idUsuario);
    }

    public List<Box> traerBoxes() {
        return boxJpa.findBoxEntities();
    }

    public Box traerBox(long idBox) {
        return boxJpa.findBox(idBox);
    }

    public void tomarPacientePersistirDatos(Consulta consuAct, Medico medAct, Box boxAct) throws Exception {
        boxJpa.edit(boxAct);
        medicoJpa.edit(medAct);
        consultaJpa.edit(consuAct);
    }
    
    public List<Rol>  traerRoles() {
        return rolJpa.findRolEntities();
    }

    public FuncionarioGeneral traerFuncionarioGeneral(long id) {
        return funcionarioGeneralJpa.findFuncionarioGeneral(id);
    }

    public Usuario traerUsuario(long id) {
        return usuJpa.findUsuario(id);
    }

    public void editarFuncionarioGeneral(FuncionarioGeneral funcGeneral) {
        try {
            funcionarioGeneralJpa.edit(funcGeneral);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuario(long id) {
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ResultadoEstudio> TraerResultadosEst() {
        return this.resEstudioJpa.findResultadoEstudioEntities();
    }

    public List<DiagnosticoClinico> traerDiagnosticoClinico() {
        return this.diagnosticoJpa.findDiagnosticoClinicoEntities();
    }

    public void crearResultadoEstudio(ResultadoEstudio res) {
        this.resEstudioJpa.create(res);
    }

    public void cargarNuevoDiagClinico(DiagnosticoClinico diag) {
        this.diagnosticoJpa.create(diag);
    }

    public void editarPaciente(Paciente paciente) {
        try {
            this.pacienteJpa.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarConsulta(Consulta consulta) {
        try {
            this.consultaJpa.edit(consulta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarBox(Box boxAVaciar) {
        try {
            this.boxJpa.edit(boxAVaciar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void traerRol(String rolRecibido) {
}

    public List<Consulta> traerConsultas() {
        return consultaJpa.findConsultaEntities();
    }

    public List<Triage> traerTriages() {
        return triageJpa.findTriageEntities();
    }

    public List<Medico> traerMedicos() {
        return medicoJpa.findMedicoEntities();
    }

    public void crearTriage(Triage triage) {
        this.triageJpa.create(triage);
    }

    public Consulta traerConsulta(int idConsulta) {
        return consultaJpa.findConsulta(idConsulta);
    }

    public void editarTriage(Triage triage) throws Exception {
        this.triageJpa.edit(triage);
    }

    
}
    
