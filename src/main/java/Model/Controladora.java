package Model;

import Persistencia.ControladoraPersistencia;
import static java.awt.SystemColor.control;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controladora implements Serializable{
    ControladoraPersistencia controlPersis;
    Usuario usu;
    
    private EsperaAtencion esperaAtencion = new EsperaAtencion();
    private EsperaTriage esperaAtencionTriage = new EsperaTriage();
    

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
    
    public List<Triage> traerTriages() {
        return controlPersis.traerTriages();
    }
    public List<Medico> traerMedicos() {
        return controlPersis.traerMedicos();
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
     * @param idMedico
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public String pacientesPorMedico(LocalDate fecha1, LocalDate fecha2, Integer idMedico) {
        ArrayList<Consulta> listaFiltro = this.filtraFechas(fecha1, fecha1);
        List<Medico> listaMed = this.traerMedicos();
        Integer contador = 0;

        for (Medico leerMed : listaMed) {
            if (leerMed.getId() == idMedico) {       
                for (Consulta leerConsulta : listaFiltro) {
                    if (leerConsulta.getMedico().getDni() == leerMed.getDni()) {
                        contador ++;
                    }
                }
            }
        }
        return String.valueOf(contador);
    }
    


    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    
    public Medico medicoConMasPacientes(LocalDate fecha1, LocalDate fecha2){
        return medicoConMasPacientesPrivate(fecha1, fecha2);
    }

    private Medico medicoConMasPacientesPrivate(LocalDate fecha1, LocalDate fecha2) {
        Map<Medico, Integer> conteoConsultas = new HashMap<>();
        Medico medicoConMasPacientes = null;
        List<Consulta> consultas = traerConsultas();

        if (consultas != null) { 
            int maxConsultas = 0;

            for (Consulta consulta : consultas) {
                LocalDate fechaConsulta = LocalDate.parse(consulta.getFecha());
                if (fechaConsulta != null && fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                    Medico medico = consulta.getMedico();
                    int consultasMedico = conteoConsultas.getOrDefault(medico, 0) + 1;
                    conteoConsultas.put(medico, consultasMedico);

                    if (consultasMedico > maxConsultas) {
                        maxConsultas = consultasMedico;
                        medicoConMasPacientes = medico;
                    }
                }
            }
        } else {
            return null;
        }

        return medicoConMasPacientes;
    }
    
    
    /**
    * Metodo que devuelve una lista de consultas entre dos fechas
    * @return ArrayList de consultas
    * @param fecha1 es la fecha limite inferior para filtrar
    * @param fecha2 es la fecha limite superior para filtrar
    */
    public ArrayList<Consulta> filtraFechas(LocalDate fecha1, LocalDate fecha2) {
        return filtraFechasPrivate(fecha1, fecha2);
    }
    
    private ArrayList<Consulta> filtraFechasPrivate(LocalDate fecha1, LocalDate fecha2) {
        ArrayList<Consulta> listaFiltrada = null;
        List<Consulta> consultas = traerConsultas();

        if (!consultas.isEmpty()) { 
            for (Consulta consulta : consultas) {
                LocalDate fechaConsulta = LocalDate.parse(consulta.getFecha());
//                LocalDate fechaConsulta = consulta.getFecha();
                if (fechaConsulta != null && fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                    listaFiltrada.add(consulta);
                }
            } 
        } 
        else {
            return listaFiltrada;
        }

        return listaFiltrada;
    }
    
    /**
     * @param edad1 parametro limite inferior de edad para filtrar
     * @param edad2 parametro limite superior de edad para filtrar
     * @param fecha1 parametro limite inferior de fecha para filtrar
     * @param fecha2 parametro limite superior de fecha para filtrar
     * @return devuelve un entero contador de ocurrencias
     */
    
    public String contadorPacientesEdad(Integer edad1, Integer edad2, LocalDate fecha1, LocalDate fecha2){
        return contadorPacientesEdadPrivate(edad1, edad2, fecha1, fecha2);
    }
            
    private String contadorPacientesEdadPrivate(Integer edad1, Integer edad2, LocalDate fecha1, LocalDate fecha2) {
        ArrayList<Consulta> listaFiltrada = filtraFechas(fecha1, fecha2);
        Integer contador = 0;
        
        for (Consulta consultaPaciente : listaFiltrada) {
            LocalDate fechaNacimiento = LocalDate.parse(consultaPaciente.getPaciente().getFechaDeNac());
            Integer edadPaciente = (int)fechaNacimiento.until(fecha2, YEARS);
            if ((edadPaciente >= edad1) && (edadPaciente <= edad2)){
                contador = +1;
            }
        }
        return String.valueOf(contador);
    }
    
    
    /**
    *Metodo que utiliza una lista filtrada para realizar una busqueda y conteo
    *@return ArrayList con un objeto Paciente y un int contador de ocurrencias
    * @param LocalDate fecha1 parametro para pasar como argumento a otra funcion
    * @param LocalDate fecha2 parametro para pasar como argumento a otra funcion
    * @param ArrayList listaFiel lista donde se realizara el conteo
    */
    public ArrayList<Object> pacienteMasAtendido(LocalDate fecha1, LocalDate fecha2, ArrayList<Consulta> listaFiel) {
////////////////        ArrayList<Consulta> listaFiltro = listaFiel;
////////////////        Paciente pacienteOne = null;
////////////////        ArrayList<Object> devolver = new ArrayList<>();
////////////////        Integer contador = 0;
////////////////        
////////////////        if (listaFiltro.isEmpty()) {
////////////////            devolver.add(pacienteOne);
////////////////            devolver.add(contador);
////////////////            return devolver;
////////////////        }
////////////////        
////////////////        ArrayList<Consulta> noRepetir = new ArrayList<>();
////////////////        for (Consulta leerConsulta : listaFiltro){
////////////////
////////////////            if (noRepetir.contains(leerConsulta)){
////////////////                continue;
////////////////            }
////////////////            else {
////////////////                noRepetir.add(leerConsulta);
////////////////            }
////////////////            Integer contadorAux = 0;
////////////////            for (Consulta leerAux : listaFiltro) {
////////////////                if (leerConsulta.getPaciente().getDni() == leerAux.getPaciente().getDni()) {
////////////////                    contadorAux ++;
////////////////                }
////////////////                if (contadorAux > contador) {
////////////////                    pacienteOne = leerConsulta.getPaciente();
////////////////                    contador = contadorAux;
////////////////                }
////////////////            }
////////////////        }
////////////////
////////////////        devolver.add(pacienteOne);
////////////////        devolver.add(contador);
////////////////        return devolver;
        return null;
    }
    
////////////////    /**
////////////////     *
////////////////     * @param fecha1
////////////////     * @param fecha2
////////////////     * @return
////////////////     */
//    public Map<int, Paciente> listaPacientesMasAtendidos(LocalDate fecha1, LocalDate fecha2) {
//////////////////        Paciente pacienteAux = null;
//////////////////        ArrayList<Consulta> listaFiltro = this.filtraFechas(fecha1, fecha2);
//////////////////        Map<int, ArrayList<Object>> accesoDirecto = new HashMap<>();
//////////////////        
//////////////////        for(int repeticiones = 0; repeticiones < 3; repeticiones ++){
//////////////////            
//////////////////            ArrayList<Object> agregarPaciente = this.pacienteMasAtendido(fecha1, fecha2, listaFiltro);
//////////////////            pacienteAux = (Paciente) agregarPaciente.get(0);
//////////////////            
//////////////////            accesoDirecto.put((repeticiones +1), agregarPaciente);
//////////////////            listaFiltro.remove(pacienteAux);
//////////////////            
//////////////////            }
//////////////////        return accesoDirecto;
//        return null;
//    }


    
    //---------Metodos estadisticos----------
    
    public void VerEstadistica() {
        // TODO implement here
    }
////////////     public static Map<TipoColor, Integer> triageFiltrarColorYFecha(String fecha1, String fecha2) {
//////////////        Map<String, Integer> diccionario = new HashMap<>();
//////////////        for (Codigo Para Recorer Arbol de Tiage) {
//////////////            if (Clase.fecha<fecha1&&Clase.fecha<fecha2) {
//////////////                tipoColor clave = Triage.ColorFinal;
//////////////                if(diccionario.containsKey(clave)){
//////////////                    diccionario.merge(clave, 1, Integer::sum);
//////////////                }else{
//////////////                    diccionario.put(clave, 1);
//////////////                }
//////////////            }            
//////////////        }
//////////////        return diccionario;
////////////    }


    
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
        List<Object> objetos = this.esperaAtencion.quitarDeFila(box, medico);
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
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(DateTimeFormatter.ISO_DATE);
        
        ResultadoEstudio res = new ResultadoEstudio(paciente, titulo, descripcion ,hora ,fecha);
        
        this.controlPersis.crearResultadoEstudio(res);
        
        paciente.getResultadoEstudio().add(res);
        this.controlPersis.editarPaciente(paciente);
        
    }
    
    public void cargarNuevoDiagClinico(Paciente paciente, String titulo, String descripcion) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(DateTimeFormatter.ISO_DATE);
        
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

    public Usuario traerUsu(int dni) {
        
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {

            for (Usuario usu : listaUsuarios) {

                if (usu.getFuncionarioGeneral().getDni() == dni) {
                    
                    mostrarMensaje("Usuario encotrado", "Info", "Busqueda exitosa");    
                    return controlPersis.traerUsuario(usu.getId());  
                    
                }
            }
        }
        return null;
    }
    /**
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param domicilio
     * @param estadoCivil
     * @param correo
     * @param telCelular
     * @param telFijo
     * @param personaContacto
     * @param numContacto
     */
    public void registrarPaciente(String dni, String nombre, String apellido, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
        Paciente paciente = new Paciente();
        int documento = Integer.parseInt(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(documento);
        paciente.setFechaDeNac(fechaNacimiento);
        paciente.setDomicilio(domicilio);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setCorreoE(correo);
        paciente.setTelefonoCel(telFijo);
        paciente.setTelefonoFijo(telCelular);
        paciente.setPersoDeContacto(personaContacto);
        paciente.setTelDeContacto(numContacto);
        paciente.setDiagnosticoClinico(null);
        paciente.setResultadoEstudio(null);
        
        controlPersis.RegistrarPaciente(paciente);
        
    }

    public void CrearConsulta(String lugar, String motivo, Paciente p) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(DateTimeFormatter.ISO_DATE);
        
        Consulta consu = new Consulta(p ,fecha ,hora ,null ,lugar ,motivo ,null ,null , null);
        this.controlPersis.CrearConsulta(consu);
        this.esperaAtencionTriage.AñadirALaFila(consu);
        
    }

//    public Object[] ValidarPaciente(int doc) {
//        List<Paciente> pacientes = this.controlPersis.traerPacientes();
//        Object[] objetos = {11};
//        for(Paciente p : pacientes){
//            if(p.getDni()==doc){
//                objetos[0] = p.getDni();
//                objetos[1] = p.getApellido();
//                objetos[2] = p.getNombre();
//                objetos[3] = p.getFechaDeNac();
//                objetos[4] = p.getEstadoCivil();
//                objetos[5] = p.getCorreoE();
//                objetos[6] = p.getDomicilio();
//                objetos[7] = p.getTelefonoCel();
//                objetos[8] = p.getTelefonoFijo();
//                objetos[9] = p.getPersoDeContacto();
//                objetos[10] = p.getTelDeContacto();        
//                break;
//            }
//        }
//        return objetos;
//    }

    public List<Consulta> traerPacientesEnEspera() {
        List<Consulta> consultas = (List<Consulta>) this.esperaAtencionTriage.getEnEspera();
        return  consultas;
    }

    public Paciente buscarPacientePorDni(int dni) {
        List<Paciente> pacientes = this.controlPersis.traerPacientes();
        Paciente paciente = new Paciente();
        for(Paciente p : pacientes){
            if(p.getDni()==dni){
               paciente = p;
               break;   
            }
        }
        return paciente;
    }

 
}
