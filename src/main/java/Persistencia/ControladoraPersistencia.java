
package Persistencia;

import Model.Consulta;
import Model.Especialidad;
import Model.FuncionarioGeneral;
import Model.GestoresHospital;
import Model.Paciente;
import Model.Rol;
import Model.Sector;
import Model.Triage;
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matías Sillen Ríos
 */

public class ControladoraPersistencia implements Serializable{
    
    PacienteJpaController pacienteJpa = new PacienteJpaController();
<<<<<<< HEAD
    FuncionarioGeneralJpaController funcionarioGeneralJpa = new FuncionarioGeneralJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    MedicoJpaController medicoJpa = new MedicoJpaController();
    TriageJpaController triageJpa = new TriageJpaController();
=======
    //RolJpaController rolJpa = new RolJpaController();
    //GestoresHospitalJpaController gestorJpa = new GestoresHospitalJpaController();
    //RecepcionistaJpaController recepcionistaJpa = new RecepcionistaJpaController();
    //MedicoJpaController medicoJpa = new MedicoJpaController();
    //LicEnEnfermeriaJpaController licEnEnfermeriaJpa = new LicEnEnfermeriaJpaController();
    //AdministradorDeSistemaJpaController administradorJpa = new AdministradorDeSistemaJpaController();
    //EspecialidadJpaController especialidadJpa = new EspecialidadJpaController();
    //TriageJpaController triageJpa = new TriageJpaController();
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    ConsultaJpaController consultaJpa = new ConsultaJpaController();
    //SectorJpaController sectorJpa = new SectorJpaController();
    
    //---------Metodos para Paciente---------

    public void RegistrarPaciente(Paciente paciente) {
        pacienteJpa.create(paciente);
        
    }

    public List<Paciente> TraerPaciente() {
        return pacienteJpa.findPacienteEntities();    
    }
    
    public Paciente TraerPaciente(int dni) {
        
        return pacienteJpa.findPaciente(dni);
        
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
<<<<<<< HEAD
    
    //Metodo para borrar un usuario
    
//    public void borrarFuncionarioGeneral(long id) {
//        try {
//            funcionarioGeneralJpa.destroy(id);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
=======
//    
//    //Metodos para borrar un usuarios
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
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
<<<<<<< HEAD
    //Metodo para editar usuario
//    
//    public void editarFuncionarioGeneral(FuncionarioGeneral funcionarioGeneral) {
//        try {
//            funcionarioGeneralJpa.edit(funcionarioGeneral);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
=======
//    //Metodos para editar usuarios
//    
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
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
<<<<<<< HEAD
    
    //----------Rol----------
//    public List<Rol> traerRoles() {
//        return rolJpa.findRolEntities();
//    }
//    
//    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
//        List<FuncionarioGeneral> listaFuncionariosEnGeneral = funcionarioGeneralJpa.findFuncionarioGeneralEntities();
//        return listaFuncionariosEnGeneral;
//    }
=======
//    
//    //----------Rol----------
//    public List<Rol> traerRoles() {
//        return rolJpa.findRolEntities();
//    }
//
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
//
//    public List<Especialidad> traerEspecialidades() {
//        List<Especialidad> listaEspecialidades = especialidadJpa.findEspecialidadEntities();
//        return listaEspecialidades;
//    }
//
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

>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    
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
    
<<<<<<< HEAD
//    public FuncionarioGeneral traerFuncionarioGeneral(long idUsuario) {
//        return funcionarioGeneralJpa.findFuncionarioGeneral(idUsuario);
//    }
//    
=======
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
//    public GestoresHospital traerGestor(long idUsuario) {
//        return gestorJpa.findGestoresHospital(idUsuario);
//    }
//    
//    public Recepcionista traerRecepcionista(long idUsuario) {
//        return recepcionistaJpa.findRecepcionista(idUsuario);
//    }
//
//    public Medico traerMedico(long idUsuario) {
//        return medicoJpa.findMedico(idUsuario);
//    }
//
//    public LicEnEnfermeria traerLicEnEnfermeria(long idUsuario) {
//        return licEnEnfermeriaJpa.findLicEnEnfermeria(idUsuario);
//    }
//
//    public AdministradorDeSistema traerAdministradorDeSistemas(long idUsuario) {
//        return administradorJpa.findAdministradorDeSistema(idUsuario);
//    }

<<<<<<< HEAD
    public void CrearConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
=======
    
    
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    
}