package Model;

import Persistencia.ControladoraPersistencia;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Controladora implements Serializable{
    ControladoraPersistencia controlPersis;
    private Usuario usu;
    
    public Controladora() {
        this.controlPersis = new ControladoraPersistencia();
        this.usu = null;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Usuario getUsu() {
        return usu;
    }
    
    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
        return controlPersis.traerFuncionariosEnGeneral();
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }
    
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }
    

    public Usuario traerUsuario(long idUsuario) {
        return controlPersis.traerUsuarios(idUsuario);
    }
    
    //----------Metodos que estaban en la clase Medico----------
    
     /**
     * @param paciente 
     * @return
    */
    public void tomarPaciente(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerTriage(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerConsulta(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerResultadoEstudios(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente 
     * @return
    */
    public void VerAntecedenteClinico(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public Integer CantidadPacientesAtendidos(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @param edad1 
     * @param edad2 
     * @return
    */
    public Integer PacientesAtendidosPorEdad(String fecha1, String fecha2, String edad1, String edad2) {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public Medico MedicoConMasPacientes(LocalDate fecha1, LocalDate fecha2) {
        
        return Medico;
    }
    
    //---------Metodos estadiscticos----------
    
    public void VerEstadistica() {
        // TODO implement here
    }
    // public static Map<TipoColor, Integer> triageFiltrarColorYFecha(String fecha1, String fecha2) {
    //    Map<String, Integer> diccionario = new HashMap<>();
    //    for (Codigo Para Recorer Arbol de Tiage) {
    //        if (Clase.fecha<fecha1&&Clase.fecha<fecha2) {
    //            tipoColor clave = Triage.ColorFinal;
    //            if(diccionario.containsKey(clave)){
    //                diccionario.merge(clave, 1, Integer::sum);
    //            }else{
    //                diccionario.put(clave, 1);
    //            }
    //        }            
    //    }
    //    return diccionario;
    // }

     public Integer triagesCambiados() {
        int sum = 0;
    //    int rango = len(funcionario.traigeHechos);
    //    for (i= 0; i<rango; i++) {
    //        Triage triageN = funcionario.traigeHechos[i];
    //        if (triageN.colorFinal=!null) {
    //            sum += 1;
    //        }
    //    }
        return sum;
    }
    
//    public List<Rol> traerRoles() {
//        return controlPersis.traerRoles();
//    }

//    public Rol traerRol(String rolRecibido) {
//        List<Rol> listaRoles = controlPersis.traerRoles();
//        
//        for (Rol rol : listaRoles) {
//            if (rol.getNombre().equals(rolRecibido)) {
//                return rol;
//            }
//        }
//        return null;
//    }

//    public int buscarUltimaIdFuncionariosEnGeneral() {
//        List<FuncionarioGeneral> listaFuncionariosEnGeneral = controlPersis.traerFuncionariosEnGeneral();
//        
//        FuncionarioGeneral funcionarioGeneral = listaFuncionariosEnGeneral.get(listaFuncionariosEnGeneral.size()-1);
//        return (int) funcionarioGeneral.getId();
//        
//    }
    
//    public int buscarUltimaIdGestores() {
//        List<GestoresHospital> listaGestores = this.traerGestores();
//        
//        GestoresHospital gestor = listaGestores.get(listaGestores.size()-1);
//        return (int) gestor.getId();
//        
//    }
//
//    public List<GestoresHospital> traerGestores() {
//        return controlPersis.traerGestores(); 
//    }
//
//    public int buscarUltimaIdRecepcionistas() {
//        List<Recepcionista> listaRecepcionistas = this.traerRecepcionistas();
//        
//        Recepcionista recepcionista = listaRecepcionistas.get(listaRecepcionistas.size()-1);
//        return (int) recepcionista.getId();
//    }
//
//    public List<Recepcionista> traerRecepcionistas() {
//        return controlPersis.traerRecepcionistas();
//    }
//
//    public int buscarUltimaIdMedicos() {
//        List<Medico> listaMedicos = this.traerMedicos();
//        
//        Medico medico = listaMedicos.get(listaMedicos.size()-1);
//        return (int) medico.getId();
//    }
//
//    public List<Medico> traerMedicos() {
//        return controlPersis.traerMedicos();
//    }
//
//    public int buscarUltimaIdlicenciadosEnEnfermeria() {
//        List<LicEnEnfermeria> listaLicenciados = this.traerLicenciadosEnEnfermeria();
//        
//        LicEnEnfermeria licEnEnfermeria = listaLicenciados.get(listaLicenciados.size()-1);
//        return (int) licEnEnfermeria.getId();
//    }
//
//    public List<LicEnEnfermeria> traerLicenciadosEnEnfermeria() {
//        return controlPersis.traerLicenciadosEnEnfermeria();
//    }
//
//    public int buscarUltimaIdAdministradoresDeSistema() {
//        List<AdministradorDeSistema> listaAdministradores = this.traerAdministradoresDeSistema();
//        
//        AdministradorDeSistema administrador = listaAdministradores.get(listaAdministradores.size()-1);
//        return (int) administrador.getId();
//    }
//
//    public List<AdministradorDeSistema> traerAdministradoresDeSistema() {
//        return controlPersis.traerAdministradoresDeSistema();
//    }
//
//    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
//        List<FuncionarioGeneral> listaFuncionariosEnGeneral = new ArrayList<FuncionarioGeneral>();
//        List<GestoresHospital> listaGestores = this.traerGestores();
//        List<Recepcionista> listaRecepcionistas = this.traerRecepcionistas();
//        List<Medico> listaMedicos = this.traerMedicos();
//        List<LicEnEnfermeria> listaLicenciados = this.traerLicenciadosEnEnfermeria();
//        List<AdministradorDeSistema> listaAdministradores = this.traerAdministradoresDeSistema();
//        
//        listaFuncionariosEnGeneral.addAll(listaGestores);
//        listaFuncionariosEnGeneral.addAll(listaRecepcionistas);
//        listaFuncionariosEnGeneral.addAll(listaMedicos);
//        listaFuncionariosEnGeneral.addAll(listaLicenciados);
//        listaFuncionariosEnGeneral.addAll(listaAdministradores);
//
//        return listaFuncionariosEnGeneral;
//    }
//    
//   public List<FuncSalud> traerFuncionariosSalud() {
//        List<FuncSalud> listaFuncionariosSalud = new ArrayList<FuncSalud>();
//        List<Medico> listaMedicos = this.traerMedicos();
//        List<LicEnEnfermeria> listaLicenciados = this.traerLicenciadosEnEnfermeria();
//        
//        
//        listaFuncionariosSalud.addAll(listaMedicos);
//        listaFuncionariosSalud.addAll(listaLicenciados);
//
//        return listaFuncionariosSalud;
//    }

//    public GestoresHospital traerGestor(long idUsuario) {
//        return controlPersis.traerGestor(idUsuario);
//    }
//
//    public Recepcionista traerRecepcionista(long idUsuario) {
//       return controlPersis.traerRecepcionista(idUsuario);
//    }
//
//    public Medico traerMedico(long idUsuario) {
//        return controlPersis.traerMedico(idUsuario);
//    }
//
//    public LicEnEnfermeria traerLicEnEnfermeria(long idUsuario) {
//        return controlPersis.traerLicEnEnfermeria(idUsuario);
//    }
//
//    public AdministradorDeSistema traerAdministradorDeSitema(long idUsuario) {
//        return controlPersis.traerAdministradorDeSistemas(idUsuario);
//    }
    
    /*
    * Validar es el metodo publico que llama a validacion
    * @return retorna un booleano true o false
    */
    public Usuario validar(String uss, String pass){
        return validacion(uss, pass);
    }
  
    /*
    * Validacion hace la logica de buscar y confirmar la existencia del usuario
    * @return boolean
    */
    private Usuario validacion(String us, String pas){
        Usuario resultado = null;
        try{
            List<Usuario> listaBusqueda = controlPersis.traerUsuarios();
            for (Usuario comprobar : listaBusqueda) {
                if ((comprobar.getNomUsuario().equals(us)) && (comprobar.getPassw() == pas)){
                    resultado = comprobar;
                    return resultado;
                }
                else {}
            }
            return resultado;
        }
        catch (Exception e) {
            return resultado;
        }
    }


        
//    public List<Consulta> TraerPacientesTriageados() {
//        List<Consulta> consultas = controlPersis.traerConsultas();
//        Iterator<Consulta> iterator = consultas.iterator();
//        while (iterator.hasNext()) {
//            Consulta consulta = iterator.next();
//            if (consulta.getMedico() != null) {
//             iterator.remove();
//            }
//            if (consulta.getTriage() == null) {
//                iterator.remove();
//            }
//        }
//        return consultas;
//    }
//
//    public List<Box> TraerBoxDelMedico() {
//        long idMedico = this.usu.getFuncionarioGeneral().getId();
//        Medico medico = this.controlPersis.traerMedico(idMedico);
//        List<Box> boxes = medico.getBoxes();
//        return boxes;
//    }
//
//    public void terminarConsulta(Long boxSeleccionadoId) {
//        Box boxABorrar = this.controlPersis.traerBox(boxSeleccionadoId);
//        long idMedico = this.usu.getFuncionarioGeneral().getId();
//        Medico medico = this.controlPersis.traerMedico(idMedico);
//        List<Box> boxes = medico.getBoxes();
//        boxes.remove(boxABorrar); 
//        
//    }

    public List<Usuario> traerTriagesCambiados() {
        List <Usuario> usu= traerUsuarios();
        for(Usuario rol: usu){
           Object objeto []={};
        
        }
    
       return null;
    }
}
