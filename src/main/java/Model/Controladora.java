package Model;

import Persistencia.ControladoraPersistencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Controladora implements Serializable{
    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        
        for (Rol rol : listaRoles) {
            if (rol.getNombre().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    public int buscarUltimaIdGestores() {
        List<GestoresHospital> listaGestores = this.traerGestores();
        
        GestoresHospital gestor = listaGestores.get(listaGestores.size()-1);
        return (int) gestor.getId();
        
    }

    public List<GestoresHospital> traerGestores() {
        return controlPersis.traerGestores(); 
    }

    public int buscarUltimaIdRecepcionistas() {
        List<Recepcionista> listaRecepcionistas = this.traerRecepcionistas();
        
        Recepcionista recepcionista = listaRecepcionistas.get(listaRecepcionistas.size()-1);
        return (int) recepcionista.getId();
    }

    public List<Recepcionista> traerRecepcionistas() {
        return controlPersis.traerRecepcionistas();
    }

    public int buscarUltimaIdMedicos() {
        List<Medico> listaMedicos = this.traerMedicos();
        
        Medico medico = listaMedicos.get(listaMedicos.size()-1);
        return (int) medico.getId();
    }

    public List<Medico> traerMedicos() {
        return controlPersis.traerMedicos();
    }

    public int buscarUltimaIdlicenciadosEnEnfermeria() {
        List<LicEnEnfermeria> listaLicenciados = this.traerLicenciadosEnEnfermeria();
        
        LicEnEnfermeria licEnEnfermeria = listaLicenciados.get(listaLicenciados.size()-1);
        return (int) licEnEnfermeria.getId();
    }

    public List<LicEnEnfermeria> traerLicenciadosEnEnfermeria() {
        return controlPersis.traerLicenciadosEnEnfermeria();
    }

    public int buscarUltimaIdAdministradoresDeSistema() {
        List<AdministradorDeSistema> listaAdministradores = this.traerAdministradoresDeSistema();
        
        AdministradorDeSistema administrador = listaAdministradores.get(listaAdministradores.size()-1);
        return (int) administrador.getId();
    }

    public List<AdministradorDeSistema> traerAdministradoresDeSistema() {
        return controlPersis.traerAdministradoresDeSistema();
    }

    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
        List<FuncionarioGeneral> listaFuncionariosEnGeneral = new ArrayList<FuncionarioGeneral>();
        List<GestoresHospital> listaGestores = this.traerGestores();
        List<Recepcionista> listaRecepcionistas = this.traerRecepcionistas();
        List<Medico> listaMedicos = this.traerMedicos();
        List<LicEnEnfermeria> listaLicenciados = this.traerLicenciadosEnEnfermeria();
        List<AdministradorDeSistema> listaAdministradores = this.traerAdministradoresDeSistema();
        
        listaFuncionariosEnGeneral.addAll(listaGestores);
        listaFuncionariosEnGeneral.addAll(listaRecepcionistas);
        listaFuncionariosEnGeneral.addAll(listaMedicos);
        listaFuncionariosEnGeneral.addAll(listaLicenciados);
        listaFuncionariosEnGeneral.addAll(listaAdministradores);

        return listaFuncionariosEnGeneral;
    }

    public GestoresHospital traerGestor(long idUsuario) {
        return controlPersis.traerGestor(idUsuario);
    }

    public Recepcionista traerRecepcionista(long idUsuario) {
       return controlPersis.traerRecepcionista(idUsuario);
    }

    public Medico traerMedico(long idUsuario) {
        return controlPersis.traerMedico(idUsuario);
    }

    public LicEnEnfermeria traerLicEnEnfermeria(long idUsuario) {
        return controlPersis.traerLicEnEnfermeria(idUsuario);
    }

    public AdministradorDeSistema traerAdministradorDeSitema(long idUsuario) {
        return controlPersis.traerAdministradorDeSistemas(idUsuario);
    }
}