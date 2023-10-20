
package Persistencia;

import Model.AdministradorDeSistema;
import Model.Consulta;
import Model.Especialidad;
import Model.GestoresHospital;
import Model.LicEnEnfermeria;
import Model.Medico;
import Model.Paciente;
import Model.Recepcionista;
import Model.Rol;
import Model.Sector;
import Model.Triage;
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
    //RolJpaController rolJpa = new RolJpaController();
    //GestoresHospitalJpaController gestorJpa = new GestoresHospitalJpaController();
    //RecepcionistaJpaController recepcionistaJpa = new RecepcionistaJpaController();
    //MedicoJpaController medicoJpa = new MedicoJpaController();
    //LicEnEnfermeriaJpaController licEnEnfermeriaJpa = new LicEnEnfermeriaJpaController();
    //AdministradorDeSistemaJpaController administradorJpa = new AdministradorDeSistemaJpaController();
    //EspecialidadJpaController especialidadJpa = new EspecialidadJpaController();
    //TriageJpaController triageJpa = new TriageJpaController();
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
    
    public void CrearConsulta(Consulta consulta) {
        consultaJpa.create(consulta);
        
    }
    
    
    
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
//    
//    //Metodos para borrar un usuarios
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
//    //Metodos para editar usuarios
//    
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

    

    
    
    //Metodos para buscar usuarios
    
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

    
    
    
}