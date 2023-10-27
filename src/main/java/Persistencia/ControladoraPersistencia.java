
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
    
    //---------Metodos para Consulta---------
    
//    public void CrearConsulta(Consulta consulta) {
//        consultaJpa.create(consulta);
//        
//    }
    
    //----------CRUD de Usuario----------
    
    // Metodos para crear los ususarios
    
//    public void crearGestor(GestoresHospital gestor) {
//        gestorJpa.create(gestor);
//    }
//    
//    public void crearRecepcionista(Recepcionista recepcionista) {
//        recepcionistaJpa.create(recepcionista);
//    }
//    
//    public void crearMedico(Medico medico) {
//        medicoJpa.create(medico);
//    }
//    
//    public void crearLicEnEnfermeria(LicEnEnfermeria licEnEnfermeria) {
//        licEnEnfermeriaJpa.create(licEnEnfermeria);
//    }
//    
//    public void crearAdministrador(AdministradorDeSistema administrador) {
//        administradorJpa.create(administrador);
//    }    
    
    //Metodo para borrar un usuario
    
//    public void borrarFuncionarioGeneral(long id) {
//        try {
//            funcionarioGeneralJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void borrarGestor(long id) {
//        try {
//            gestorJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void borrarRecepcionista(long id) {
//        try {
//            recepcionistaJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void borrarMedico(long id) {
//        try {
//            medicoJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void borrarLicenciadoEnEnfermeria(long id) {
//        try {
//            licEnEnfermeriaJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void borrarAdministrador(long id) {
//        try {
//            administradorJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    //Metodo para editar usuario
//    
//    public void editarFuncionarioGeneral(FuncionarioGeneral funcionarioGeneral) {
//        try {
//            funcionarioGeneralJpa.edit(funcionarioGeneral);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void editarGestor(GestoresHospital gestor) {
//        try {
//            gestorJpa.edit(gestor);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void editarRecepcionista(Recepcionista recepcionista) {
//        try {
//            recepcionistaJpa.edit(recepcionista);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void editarMedico(Medico medico) {
//        try {
//            medicoJpa.edit(medico);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void editarlicEnEnfermeria(LicEnEnfermeria licenciado) {
//        try {
//            licEnEnfermeriaJpa.edit(licenciado);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void editarAdministradorDeSitema(AdministradorDeSistema admin) {
//        try {
//            administradorJpa.edit(admin);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    //----------Rol----------
//    public List<Rol> traerRoles() {
//        return rolJpa.findRolEntities();
//    }
//    
//    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
//        List<FuncionarioGeneral> listaFuncionariosEnGeneral = funcionarioGeneralJpa.findFuncionarioGeneralEntities();
//        return listaFuncionariosEnGeneral;
//    }
    
//    public List<GestoresHospital> traerGestores() {
//        List<GestoresHospital> listaGestores = gestorJpa.findGestoresHospitalEntities();
//        return listaGestores;
//    }
//
//    public List<Recepcionista> traerRecepcionistas() {
//        List<Recepcionista> listaRecepcionistas = recepcionistaJpa.findRecepcionistaEntities();
//        return listaRecepcionistas;
//    }
//
//    public List<Medico> traerMedicos() {
//        List<Medico> listaMedicos = medicoJpa.findMedicoEntities();
//        return listaMedicos;
//    }
//
//    public List<LicEnEnfermeria> traerLicenciadosEnEnfermeria() {
//        List<LicEnEnfermeria> listaLicenciados = licEnEnfermeriaJpa.findLicEnEnfermeriaEntities();
//        return listaLicenciados;
//    }
//
//    public List<AdministradorDeSistema> traerAdministradoresDeSistema() {
//        List<AdministradorDeSistema> listaAdministradores = administradorJpa.findAdministradorDeSistemaEntities();
//        return listaAdministradores;
//    }

//    public List<Especialidad> traerEspecialidades() {
//        List<Especialidad> listaEspecialidades = especialidadJpa.findEspecialidadEntities();
//        return listaEspecialidades;
//    }

//    public List<Triage> traeTriageRealizados() {
//        List<Triage> listaTriageRealizados = triageJpa.findTriageEntities();
//        return listaTriageRealizados;
//    }
//
//    public List<Consulta> traerConsultas() {
//        List<Consulta> listaConsultas = consultaJpa.findConsultaEntities();
//        return listaConsultas;
//    }
//
//    public void crearSector(Sector sector) {
//        sectorJpa.create(sector);
//    }

    //Metodos para buscar usuarios
    
//    public FuncionarioGeneral traerFuncionarioGeneral(long idUsuario) {
//        return funcionarioGeneralJpa.findFuncionarioGeneral(idUsuario);
//    }
//    
//    public GestoresHospital traerGestor(long idUsuario) {
//        return gestorJpa.findGestoresHospital(idUsuario);
//    }
//    
//    public Recepcionista traerRecepcionista(long idUsuario) {
//        return recepcionistaJpa.findRecepcionista(idUsuario);
//    }
//

//
//    public LicEnEnfermeria traerLicEnEnfermeria(long idUsuario) {
//        return licEnEnfermeriaJpa.findLicEnEnfermeria(idUsuario);
//    }
//
//    public AdministradorDeSistema traerAdministradorDeSistemas(long idUsuario) {
//        return administradorJpa.findAdministradorDeSistema(idUsuario);
//    }

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

    
}
    
