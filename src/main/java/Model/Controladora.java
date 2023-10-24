package Model;

import Persistencia.ControladoraPersistencia;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controladora implements Serializable{
    ControladoraPersistencia controlPersis;
    Usuario usu;
    
    private EsperaAtencion esperaAtencion = new EsperaAtencion();

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
    
    public List<Consulta> traerConsultas() {
        return controlPersis.traerConsultas();
    }
    

    public Usuario traerUsuario(long idUsuario) {
        return controlPersis.traerUsuarios(idUsuario);
    }
    
    //----------Metodos que estaban en la clase Medico----------
    
     /**
     * @param paciente
    */
    public void tomarPaciente(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente
    */
    public void VerTriage(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente
    */
    public void VerConsulta(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente
    */
    public void VerResultadoEstudios(Paciente paciente) {
        // TODO implement here
    }

    /**
     * @param paciente
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

    public Medico medicoConMasPacientes(LocalDate fecha1, LocalDate fecha2) {
        Map<Medico, Integer> conteoConsultas = new HashMap<>();
        Medico medicoConMasPacientes = null;
        int maxConsultas = 0;

        for (Consulta consulta : consultas) {
            LocalDate fechaConsulta = consulta.getFecha();
            if (fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                Medico medico = consulta.getMedico();
                int consultasMedico = conteoConsultas.getOrDefault(medico, 0) + 1;
                conteoConsultas.put(medico, consultasMedico);

                if (consultasMedico > maxConsultas) {
                    maxConsultas = consultasMedico;
                    medicoConMasPacientes = medico;
                }
            }
        }

        return medicoConMasPacientes;
    }

//    public Medico MedicoConMasPacientes(LocalDate fecha1, LocalDate fecha2) {
//        
//        return Medico;
//    }

    
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

    // -----
    /*
    * Validar es el metodo publico que llama a validacion
    * @return retorna un objeto Usuario
    */
    public Usuario validar(String uss, String pass){
        return validacion(uss, pass);
    }
    /*
    * @param uss String de nombre de usuario
    * @param pass String de contraseña
    */
    
    /*
    * Validacion hace la logica de buscar y confirmar la existencia del usuario
    * @return Usuario
    */
    private Usuario validacion(String us, String pas){
        Usuario resultado = null;
        try{
            List<Usuario> listaBusqueda = controlPersis.traerUsuarios();
            for (Usuario comprobar : listaBusqueda) {
                if ((comprobar.getNomUsuario().equals(us)) && (comprobar.getPassw().equals(pas))){
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



    public List<Box> TraerBoxDelMedico() {
        long idMedico = this.usu.getFuncionarioGeneral().getId();
        Medico medico = this.controlPersis.traerMedico(idMedico);
        List<Box> boxes = this.controlPersis.traerBoxes();
        for(Box box : boxes){
            if(box.getConsulta().getMedico()!=medico){
                boxes.remove(box);
            }
        }
        return boxes;
    }

    public List<Usuario> traerTriagesCambiados() {
        List <Rol> usu= traerRoles();
        
       return null;
    }
    public List<Box> TraerBoxDisponibles() {
        List<Box> boxes = this.controlPersis.traerBoxes();
        for(Box box : boxes){
            if(box.getConsulta().getMedico()!=null){
                boxes.remove(box);
            }
        }
        return boxes;
    }

    public Box traerBox(long idBox) {
        return this.controlPersis.traerBox(idBox); 
    }
    
    public void tomarPaciente(Box box, Medico medico) throws Exception {
        List<Object> objetos = this.esperaAtencion.moverPaciente(box, medico);
        Consulta consuAct = (Consulta)objetos.get(0);
        Medico medAct = (Medico)objetos.get(1);
        Box boxAct = (Box)objetos.get(2);
        this.tomarPacientePersistirDatos(consuAct,medAct,boxAct);
    }

    private void tomarPacientePersistirDatos(Consulta consuAct, Medico medAct, Box boxAct) throws Exception {
        this.controlPersis.tomarPacientePersistirDatos(consuAct,medAct,boxAct);
    }

    public Paciente traerPacienteEnElBox(String idBox) {
        long id = Long.parseLong(idBox);
        return this.controlPersis.traerBox(id).getConsulta().getPaciente();
    }

    public List<ResultadoEstudio> TraerResultEstudio(Paciente paciente) {
        List<ResultadoEstudio> restEstu = paciente.getResultadoEstudio();
        return restEstu;
    }

    public List<DiagnosticoClinico> traerDiagnosticoClinico(Paciente paciente) {
        List<DiagnosticoClinico> diagCli = paciente.getDiagnosticoClinico();
        return diagCli;
    }

    public void cargarNuevoResEstudio(Paciente paciente, String titulo, String descripcion) {
        String hora = "";
        String fecha = "";
        
        ResultadoEstudio res = new ResultadoEstudio(paciente, titulo, descripcion ,hora ,fecha);
        
        this.controlPersis.crearResultadoEstudio(res);
        
        paciente.getResultadoEstudio().add(res);
        this.controlPersis.editarPaciente(paciente);
        
    }
    
    public void cargarNuevoDiagClinico(Paciente paciente, String titulo, String descripcion) {
        String hora = "";
        String fecha = "";
        FuncionarioGeneral func = this.usu.getFuncionarioGeneral();
        Medico medico = (Medico) func;
        
        DiagnosticoClinico diag = new DiagnosticoClinico(paciente, titulo, fecha, hora, descripcion, medico);
        
        this.controlPersis.cargarNuevoDiagClinico(diag);
        
        paciente.getDiagnosticoClinico().add(diag);
        this.controlPersis.editarPaciente(paciente);
    }

    public void terminarConsulta(String diagnostico, String idBox) {
        long id = Long.parseLong(idBox);
        
        
        Box boxAVaciar = this.controlPersis.traerBox(id);
        Consulta consulta = boxAVaciar.getConsulta();
        
        consulta.setDiagnConsulta(diagnostico);
        this.controlPersis.editarConsulta(consulta);
        
        boxAVaciar.setConsulta(null);
        this.controlPersis.editarBox(boxAVaciar);
        
    }
         //Metodo que muestra un mensaje por pantalla
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public FuncionarioGeneral traerFuncionarioGeneral(long id) {
        return controlPersis.traerFuncionarioGeneral(id);
    }

    public void editarFuncionarioGeneral(FuncionarioGeneral funcGeneral) {
        controlPersis.editarFuncionarioGeneral(funcGeneral);
    }

    public String mostrarUsuario(Usuario buscarUsuario) {
        return "Id: " + buscarUsuario.getId() + "\nNombre de Usuario: " + buscarUsuario.getNomUsuario() + "\nRol/es: " + buscarUsuario.getRol().getFirst().getNombre();
    }

    public Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = this.traerRoles();
        
        for (Rol rol : listaRoles) {
            
            if (rol.getNombre().equalsIgnoreCase(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }
}
