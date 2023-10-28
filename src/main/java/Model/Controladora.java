package Model;

import Model.Sintomas.Conciencia;
import Model.Sintomas.DolorAbd;
import Model.Sintomas.DolorPecho;
import Model.Sintomas.Edad;
import Model.Sintomas.Fiebre;
import Model.Sintomas.LesionesGraves;
import Model.Sintomas.LesionesLeves;
import Model.Sintomas.Mental;
import Model.Sintomas.Pulso;
import Model.Sintomas.Respiracion;
import Model.Sintomas.Sangrado;
import Model.Sintomas.Shock;
import Model.Sintomas.Vomitos;
import Persistencia.ControladoraPersistencia;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * La clase `Controladora` es el controlador principal del sistema. Administra
 * usuarios, pacientes, consultas y otros datos relacionados con la atención
 * médica.
 */
public class Controladora implements Serializable {

    ControladoraPersistencia controlPersis;
    Usuario usu;

    PriorityQueue<Consulta> filaAten;
    Queue<Consulta> filaTriag;
    EsperaAtencion esperaAtencion;
    EsperaTriage esperaAtencionTriage;

    /**
     * Constructor de la clase `Controladora`. Inicializa una instancia de
     * `ControladoraPersistencia` y establece `usu` en `null`.
     */
    public Controladora() {
        this.controlPersis = new ControladoraPersistencia();
        this.usu = null;
        this.filaAten = actualizarColaAtencion();
        this.filaTriag = this.actualizarColaTriage();
        this.esperaAtencion = new EsperaAtencion(filaAten);
        this.esperaAtencionTriage = new EsperaTriage(filaTriag);
    }

    /**
     *
     * @param usu
     */
    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    /**
     *
     * @return
     */
    public Usuario getUsu() {
        return usu;
    }

    /**
     * Obtiene una lista de funcionarios generales.
     *
     * @return Lista de funcionarios generales.
     */
    public List<FuncionarioGeneral> traerFuncionariosEnGeneral() {
        return controlPersis.traerFuncionariosEnGeneral();
    }

    /**
     * Este método devuelve una lista de objetos de tipo Usuario. Esta lista
     * contiene todos los usuarios almacenados en la base de datos.
     *
     * @return
     */
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    /**
     * Este método devuelve una lista de objetos de tipo Rol. Esta lista
     * contiene todos los roles almacenados en la base de datos.
     *
     * @return
     */
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    /**
     * Este método devuelve una lista de objetos de tipo Triage. Esta lista
     * contiene todos los triages almacenados en la base de datos.
     *
     * @return
     */
    public List<Triage> traerTriages() {
        return controlPersis.traerTriages();
    }

    /**
     * Este método devuelve una lista de objetos de tipo Medico. Esta lista
     * contiene todos los médicos almacenados en la base de datos.
     *
     * @return
     */
    public List<Medico> traerMedicos() {
        return controlPersis.traerMedicos();
    }

    /**
     * Este método devuelve una lista de objetos de tipo Consulta. Esta lista
     * contiene todas las consultas almacenadas en la base de datos.
     *
     * @return
     */
    public List<Consulta> traerConsultas() {
        return controlPersis.traerConsultas();
    }

    /**
     * Este método devuelve un objeto de tipo Usuario que corresponde al usuario
     * con el ID especificado.
     *
     * @param idUsuario
     * @return
     */
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
     * @param idMedico es el numero para identificar al medico
     * @param fecha1 parametro limite inferior
     * @param fecha2 parametro limite superior
     * @return String del contador de ocurrencias del medico en una lista de
     * consultas entre fechas
     */
    public String pacientesPorMedico(LocalDate fecha1, LocalDate fecha2, Integer idMedico) {
        ArrayList<Consulta> listaFiltro = this.filtraFechas(fecha1, fecha1);
        List<Medico> listaMed = this.traerMedicos();
        Integer contador = 0;

        for (Medico leerMed : listaMed) {
            if (leerMed.getId() == idMedico) {
                for (Consulta leerConsulta : listaFiltro) {
                    if (leerConsulta.getMedico().getDni() == leerMed.getDni()) {
                        contador++;
                    }
                }
            }
        }
        return String.valueOf(contador);
    }

    /**
     * Metodo que llama al metodo privado medicoConMasPacientes
     *
     * @param fecha1 fecha de tipo LocalDate limite inferior
     * @param fecha2 fecha de tipo LocalDate limite superior
     * @return devuelve un objeto de tipo Medico
     */
    public Medico medicoConMasPacientes(LocalDate fecha1, LocalDate fecha2) {
        return medicoConMasPacientesPrivate(fecha1, fecha2);
    }

    /**
     * Busca y devuelve el médico con la mayor cantidad de pacientes atendidos
     * en un rango de fechas.
     *
     * @param fecha1 La fecha de inicio del rango.
     * @param fecha2 La fecha de fin del rango.
     * @return El médico con más pacientes atendidos en el rango de fechas
     * especificado, o null si no hay consultas en el rango.
     */
    private Medico medicoConMasPacientesPrivate(LocalDate fecha1, LocalDate fecha2) {
        // Mapa para llevar un conteo de las consultas por médico
        Map<Medico, Integer> conteoConsultas = new HashMap<>();
        // Medico con la mayor cantidad de pacientes atendidos
        Medico medicoConMasPacientes = null;
        // Obtener la lista de consultas
        List<Consulta> consultas = traerConsultas();
        // Verificar si hay consultas
        if (consultas != null) {
            int maxConsultas = 0;
            // Recorremos las consultas para contar cuántas atendió cada médico en el rango de fechas
            for (Consulta consulta : consultas) {
                LocalDate fechaConsulta = LocalDate.parse(consulta.getFecha());
                if (fechaConsulta != null && fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {
                    Medico medico = consulta.getMedico();
                    int consultasMedico = conteoConsultas.getOrDefault(medico, 0) + 1;
                    conteoConsultas.put(medico, consultasMedico);
                    // Actualizamos al médico con más pacientes si encontramos un nuevo máximo      
                    if (consultasMedico > maxConsultas) {
                        maxConsultas = consultasMedico;
                        medicoConMasPacientes = medico;
                    }
                }
            }
        } else {
            // No hay consultas, retornar null
            return null;
        }

        return medicoConMasPacientes;
    }

    /**
     * Metodo que llama al metodo privado filtraFechasPrivate
     *
     * @return ArrayList de consultas
     * @param fecha1 es la fecha limite inferior para filtrar del tipo LocalDate
     * en formato aaaa/MM/dd
     * @param fecha2 es la fecha limite superior para filtrar del tipo LocalDate
     * en formato aaaa/MM/dd
     */
    public ArrayList<Consulta> filtraFechas(LocalDate fecha1, LocalDate fecha2) {
        return filtraFechasPrivate(fecha1, fecha2);
    }

    /**
     * Metodo que llena una lista con las consultas realizadas entre dos fechas
     *
     * @param fecha1 limite inferior del tipo LocalDate en formato aaaa/MM/dd
     * @param fecha2 limite superior del tipo LocalDate en formato aaaa/MM/dd
     * @return devuelve un ArrayList de objetos Consulta que contiene todas las
     * consultas entre las fechas pasadas por parametro
     */
    private ArrayList<Consulta> filtraFechasPrivate(LocalDate fecha1, LocalDate fecha2) {
        ArrayList<Consulta> listaFiltrada = null;
        List<Consulta> consultas = this.traerConsultas();

        if (!consultas.isEmpty()) {
            for (Consulta consulta : consultas) {
                LocalDate fechaConsulta = LocalDate.parse(consulta.getFecha());
                if (fechaConsulta != null && fechaConsulta.isAfter(fecha1) && fechaConsulta.isBefore(fecha2)) {

                    listaFiltrada.add(consulta);
                }
            }
        } else {
            return listaFiltrada;
        }

        return listaFiltrada;
    }

    /**
     * Metodo que llama al metodo privado contadorPacientesEdadPrivate
     *
     * @param edad1 entero de edad limite inferior
     * @param edad2 entero de edad limite superior
     * @param fecha1 fecha limite inferior
     * @param fecha2 fecha limite superior
     * @return devuelve un String con el resultado del conteo
     */
    public String contadorPacientesEdad(Integer edad1, Integer edad2, LocalDate fecha1, LocalDate fecha2) {
        return contadorPacientesEdadPrivate(edad1, edad2, fecha1, fecha2);
    }

    /**
     * Metodo que cuenta las ocurrencias de un paciente en una lista de
     * consultas filtrada
     *
     * @param edad1 parametro de tipo entero limite inferior de edad para
     * filtrar
     * @param edad2 parametro limite de tipo entero superior de edad para
     * filtrar
     * @param fecha1 parametro de tipo LocalDate formato aaaa/MM/dd limite
     * inferior de fecha para filtrar
     * @param fecha2 parametro de tipo LocalDate formato aaaa/MM/dd limite
     * superior de fecha para filtrar
     * @return devuelve un entero transformado a String del contador de
     * ocurrencias
     */
    private String contadorPacientesEdadPrivate(Integer edad1, Integer edad2, LocalDate fecha1, LocalDate fecha2) {
        // this.traerPacientes();
        ArrayList<Consulta> listaFiltrada = filtraFechas(fecha1, fecha2);
        Integer contador = 0;

        for (Consulta consultaPaciente : listaFiltrada) {
            LocalDate fechaNacimiento = LocalDate.parse(consultaPaciente.getPaciente().getFechaDeNac());
            Integer edadPaciente = (int) fechaNacimiento.until(fecha2, YEARS);
            if ((edadPaciente >= edad1) && (edadPaciente <= edad2)) {
                contador = +1;
            }
        }
        return String.valueOf(contador);
    }

    /**
     * Metodo guarda los 3 pacientes mas atendidos evaluando la cantidad de
     * veces que aparece un paciente en el ArrayList de consultas
     *
     * @param listaFiel es un ArrayList de consultas filtradas por fecha
     * @return devuelve un ArrayList de objetos de tipo paciente con los 3
     * pacientes mas atendidos
     */
    public ArrayList<Paciente> listaPacientesMasAtendidos(ArrayList<Consulta> listaFiel) {
        ArrayList<Consulta> listaFiltro = listaFiel;
        // this.traerPacientes();
        Paciente pacienteOne = null;
        ArrayList<Paciente> devolver = new ArrayList<>();
        Integer contadorMax = 0;

        ArrayList<Paciente> noRepetir = new ArrayList<>();

        for (int repeticiones = 0; repeticiones < 3; repeticiones++) {
            if (listaFiltro.isEmpty()) {
                devolver.add(null);
            }

            for (Consulta leerConsulta : listaFiltro) {

                if (noRepetir.contains(leerConsulta.getPaciente())) {
                    continue;
                } else {
                    noRepetir.add(leerConsulta.getPaciente());
                }
                Integer contadorAux = 0;
                for (Consulta leerAux : listaFiltro) {
                    if (leerConsulta.getPaciente().getDni() == leerAux.getPaciente().getDni()) {
                        contadorAux++;
                    }
                    if (contadorAux > contadorMax) {
                        pacienteOne = leerConsulta.getPaciente();
                        contadorMax = contadorAux;
                    }
                }
            }
            devolver.add(pacienteOne);
            for (Consulta eliminaConsulta : listaFiltro) {
                if (eliminaConsulta.getPaciente().getId() == pacienteOne.getId()) {
                    listaFiltro.remove(eliminaConsulta);
                }
            }
        }
        return devolver;
    }

    /**
     * Metodo que devuelve cuantas vecces aparece un paciente en una ArrayList
     * de consultas
     *
     * @param listaFiltro ArrayList de objetos Consulta
     * @param listaPaciente ArraList de objetos Paciente En el ArrayList de
     * pacientes estan aquellos que se quiere contabilizar sus atenciones
     * Generalmente se usa luego de obtener un ArrayList con el metodo
     * listaPacientesMasAtendidos
     * @return devuelve un ArrayList con Strings de los contadores de cada
     * paciente en el mismo orden que los pacientes estan en el ArraList de
     * pacientes
     */
    public ArrayList<String> cantidadDeAtenciones(ArrayList<Consulta> listaFiltro, ArrayList<Paciente> listaPaciente) {
        ArrayList<String> cantidadAtencion = new ArrayList<>();

        for (Paciente leerPaciente : listaPaciente) {
            if (leerPaciente == null) {
                cantidadAtencion.add(null);
                continue;
            }
            int contador = 0;
            for (Consulta leerConsulta : listaFiltro) {
                if (leerConsulta.getPaciente() == leerPaciente) {
                    contador++;
                }
                cantidadAtencion.add(String.valueOf(contador));
            }
        }
        return cantidadAtencion;
    }

////    /**
////     * Metodo que devuelve los 3 pacientes que mas consultas tuvieron en un rango de fechas
////     * @param fecha1 limite inferior
////     * @param fecha2 limite superior
////     * @return devuelve un ArrayList que contiene otros ArrayList por cada paciente
////     */
////    public ArrayList<Object> listaPacientesMasAtendidos(LocalDate fecha1, LocalDate fecha2) {
////        Paciente pacienteAux = null;
////        ArrayList<Consulta> listaFiltro = this.filtraFechas(fecha1, fecha2);
////        ArrayList<Object> accesoDirecto = new ArrayList<>();
////        
////        for(int repeticiones = 0; repeticiones < 3; repeticiones ++){
////            
////            ArrayList<Object> agregarEstadistica = this.pacienteMasAtendido(fecha1, fecha2, listaFiltro);
////            pacienteAux = (Paciente) agregarEstadistica.get(0);
////            for (Consulta eliminaConsulta : listaFiltro) {
////                if (eliminaConsulta.getPaciente().getId() == pacienteAux.getId())
////                    listaFiltro.remove(eliminaConsulta);
////            }
////            accesoDirecto.add(agregarEstadistica);
////        }
////        return accesoDirecto;
////    }
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

    /*
    * Validar es el metodo publico que llama a validacion
    * @return retorna un objeto Usuario
     */
    public Usuario validar(String uss, String pass) {
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
    private Usuario validacion(String us, String pas) {
        Usuario resultado = null;
        try {
            List<Usuario> listaBusqueda = controlPersis.traerUsuarios();
            for (Usuario comprobar : listaBusqueda) {
                if ((comprobar.getNomUsuario().equals(us)) && (comprobar.getPassw().equals(pas))) {
                    resultado = comprobar;
                    return resultado;
                } else {
                }
            }
            return resultado;
        } catch (Exception e) {
            return resultado;
        }
    }

    /**
     * Este método devuelve una lista de objetos de tipo Box. Esta lista
     * contiene todos los boxes que están asignados al médico que está
     * actualmente conectado.
     *
     * @return
     */
    public List<Box> TraerBoxDelMedico() {
        long idMedico = this.usu.getFuncionarioGeneral().getId();
        Medico medico = this.controlPersis.traerMedico(idMedico);
        List<Box> boxes = this.controlPersis.traerBoxes();
        for (Box box : boxes) {
            if (box.getConsulta().getMedico() != medico) {
                boxes.remove(box);
            }
        }
        return boxes;
    }

    /**
     * Este método devuelve una lista de objetos de tipo Usuario. Esta lista
     * contiene todos los usuarios que tienen el rol de triage y han sido
     * modificados.
     *
     * @return
     */
    public List<Usuario> traerTriagesCambiados() {
        List<Rol> usu = traerRoles();

        return null;
    }

    /**
     * Este método devuelve una lista de objetos de tipo Box. Esta lista
     * contiene todos los boxes que no están asignados a ningún médico.
     *
     * @return
     */
    public List<Box> TraerBoxDisponibles() {
        List<Box> boxes = this.controlPersis.traerBoxes();
        for (Box box : boxes) {
            if (box.getConsulta().getMedico() != null) {
                boxes.remove(box);
            }
        }
        return boxes;
    }

    /**
     * Este método devuelve un objeto de tipo Box que corresponde al box con el
     * ID especificado.
     *
     * @param idBox
     * @return
     */
    public Box traerBox(long idBox) {
        return this.controlPersis.traerBox(idBox);
    }

    /**
     * Este método toma un objeto de tipo Box y un objeto de tipo Medico como
     * entrada. Luego, utiliza estos objetos para quitar al paciente
     * correspondiente de la fila de espera y asignarlo al box especificado.
     *
     * @param box
     * @param medico
     * @throws java.lang.Exception
     */
    public void tomarPaciente(Box box, Medico medico) throws Exception {
        List<Object> objetos = this.esperaAtencion.quitarDeFila(box, medico);
        Consulta consuAct = (Consulta) objetos.get(0);
        Medico medAct = (Medico) objetos.get(1);
        Box boxAct = (Box) objetos.get(2);
        this.tomarPacientePersistirDatos(consuAct, medAct, boxAct);
    }

    /**
     * Este método toma tres objetos como entrada: un objeto de tipo Consulta,
     * un objeto de tipo Medico y un objeto de tipo Box. Luego, utiliza estos
     * objetos para actualizar la base de datos con la información
     * correspondiente.
     */
    private void tomarPacientePersistirDatos(Consulta consuAct, Medico medAct, Box boxAct) throws Exception {
        this.controlPersis.tomarPacientePersistirDatos(consuAct, medAct, boxAct);
    }

    /**
     * Este método toma un ID de box como entrada y devuelve un objeto de tipo
     * Paciente que corresponde al paciente asignado a ese box.
     *
     * @param idBox
     * @return
     */
    public Paciente traerPacienteEnElBox(String idBox) {
        long id = Long.parseLong(idBox);
        return this.controlPersis.traerBox(id).getConsulta().getPaciente();
    }

    /**
     * Este método devuelve una lista de objetos de tipo ResultadoEstudio. Esta
     * lista contiene todos los resultados de estudio asociados con el paciente
     * especificado.
     *
     * @param paciente
     * @return
     */
    public List<ResultadoEstudio> TraerResultEstudio(Paciente paciente) {
        List<ResultadoEstudio> restEstu = paciente.getResultadoEstudio();
        return restEstu;
    }

    /**
     * Este método devuelve una lista de objetos de tipo DiagnosticoClinico.
     * Esta lista contiene todos los diagnósticos clínicos asociados con el
     * paciente especificado.
     *
     * @param paciente
     * @return
     */
    public List<DiagnosticoClinico> traerDiagnosticoClinico(Paciente paciente) {
        List<DiagnosticoClinico> diagCli = paciente.getDiagnosticoClinico();
        return diagCli;
    }

    /**
     * Este método toma tres argumentos: un objeto de tipo Paciente, un título y
     * una descripción. Luego, utiliza estos argumentos para crear un nuevo
     * objeto de tipo ResultadoEstudio y lo agrega a la lista de resultados de
     * estudio del paciente especificado. Finalmente, actualiza la base de datos
     * con la información correspondiente.
     *
     * @param paciente
     * @param titulo
     * @param descripcion
     */
    public void cargarNuevoResEstudio(Paciente paciente, String titulo, String descripcion) {
        // Obtenemos la fecha y hora actual
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        // Creamos un formateador para la hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formateamos la fecha y la hora a cadenas de texto
        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(formato);

        // Creamos un nuevo resultado de estudio con los datos proporcionados
        ResultadoEstudio res = new ResultadoEstudio(paciente, titulo, descripcion, hora, fecha);

        // Cargamos el nuevo resultado de estudio en el controlador de persistencia
        this.controlPersis.crearResultadoEstudio(res);

        // Añadimos el resultado de estudio al paciente y actualizamos el paciente en el controlador de persistencia
        paciente.getResultadoEstudio().add(res);
        this.controlPersis.editarPaciente(paciente);
    }

    /**
     * Este método toma tres argumentos: un objeto de tipo Paciente, un título y
     * una descripción. Luego, utiliza estos argumentos para crear un nuevo
     * objeto de tipo DiagnosticoClinico y lo agrega a la lista de diagnósticos
     * clínicos del paciente especificado. Finalmente, actualiza la base de
     * datos con la información correspondiente.
     *
     * @param paciente
     * @param titulo
     * @param descripcion
     */
    public void cargarNuevoDiagClinico(Paciente paciente, String titulo, String descripcion) {
        // Obtenemos la fecha y hora actual
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        // Creamos un formateador para la hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formateamos la fecha y la hora a cadenas de texto
        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(formato);

        // Obtenemos el funcionario general del usuario actual y lo convertimos a médico
        FuncionarioGeneral func = this.usu.getFuncionarioGeneral();
        Medico medico = (Medico) func;

        // Creamos un nuevo diagnóstico clínico con los datos proporcionados y el médico obtenido
        DiagnosticoClinico diag = new DiagnosticoClinico(paciente, titulo, fecha, hora, descripcion, medico);

        // Cargamos el nuevo diagnóstico clínico en el controlador de persistencia
        this.controlPersis.cargarNuevoDiagClinico(diag);

        // Añadimos el diagnóstico al paciente y actualizamos el paciente en el controlador de persistencia
        paciente.getDiagnosticoClinico().add(diag);
        this.controlPersis.editarPaciente(paciente);
    }

    /**
     * Este método toma dos argumentos: un objeto de tipo String llamado
     * diagnostico y un objeto de tipo String llamado idBox. Luego, utiliza
     * estos argumentos para establecer el diagnóstico de la consulta
     * correspondiente y vaciar el box especificado. Finalmente, actualiza la
     * base de datos con la información correspondiente.
     *
     * @param diagnostico
     * @param idBox
     */
    public void terminarConsulta(String diagnostico, String idBox) {
        // Convertimos el id del box a long
        long id = Long.parseLong(idBox);

        // Obtenemos el box a vaciar del controlador de persistencia
        Box boxAVaciar = this.controlPersis.traerBox(id);

        // Obtenemos la consulta del box
        Consulta consulta = boxAVaciar.getConsulta();

        // Establecemos el diagnóstico de la consulta y actualizamos la consulta en el controlador de persistencia
        consulta.setDiagnConsulta(diagnostico);
        this.controlPersis.editarConsulta(consulta);

        // Vaciamos la consulta del box y actualizamos el box en el controlador de persistencia
        boxAVaciar.setConsulta(null);
        this.controlPersis.editarBox(boxAVaciar);
    }

    /**
     * Este método toma tres argumentos: un objeto de tipo String llamado
     * mensaje, un objeto de tipo String llamado tipo y un objeto de tipo String
     * llamado titulo. Luego, utiliza estos argumentos para mostrar un mensaje
     * emergente en la pantalla del usuario. El mensaje emergente puede ser de
     * dos tipos: información o error. El tipo se especifica mediante el
     * argumento tipo.
     *
     * @param mensaje
     * @param tipo
     * @param titulo
     */
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equalsIgnoreCase("info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equalsIgnoreCase("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /**
     * Este método toma un argumento de tipo long llamado id. Luego, utiliza
     * este argumento para buscar y devolver un objeto de tipo
     * FuncionarioGeneral correspondiente al ID especificado.
     *
     * @param id
     * @return
     */
    public FuncionarioGeneral traerFuncionarioGeneral(long id) {
        return controlPersis.traerFuncionarioGeneral(id);
    }

    /**
     * Este método toma un objeto de tipo FuncionarioGeneral como entrada.
     * Luego, utiliza este objeto para actualizar la base de datos con la
     * información correspondiente.
     *
     * @param funcGeneral
     */
    public void editarFuncionarioGeneral(FuncionarioGeneral funcGeneral) {
        controlPersis.editarFuncionarioGeneral(funcGeneral);
    }

    /**
     * Este método toma un objeto de tipo Usuario como entrada. Luego, utiliza
     * este objeto para crear una cadena de texto que contiene información sobre
     * el usuario. La cadena de texto contiene el ID del usuario, el nombre de
     * usuario y los roles asociados con el usuario.
     *
     * @param buscarUsuario
     * @return
     */
    public String mostrarUsuario(Usuario buscarUsuario) {
        return "Id: " + buscarUsuario.getId() + "\nNombre de Usuario: " + buscarUsuario.getNomUsuario() + "\nRol/es: " + buscarUsuario.getRol().getFirst().getNombre();
    }

    /**
     * Este método toma un argumento de tipo String llamado rolRecibido. Luego,
     * utiliza este argumento para buscar y devolver un objeto de tipo Rol
     * correspondiente al nombre del rol especificado.
     *
     * @param rolRecibido
     * @return
     */
    public Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = this.traerRoles();

        for (Rol rol : listaRoles) {

            if (rol.getNombre().equalsIgnoreCase(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    /**
     * Este método toma un argumento de tipo int llamado dni. Luego, utiliza
     * este argumento para buscar y devolver un objeto de tipo Usuario
     * correspondiente al DNI especificado.
     *
     * @param dni
     * @return
     */
    public Usuario traerUsu(int dni) {

        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {

            for (Usuario usu : listaUsuarios) {

                if (usu.getFuncionarioGeneral() != null) {
                    int dnii = usu.getFuncionarioGeneral().getDni();

                    if (dnii == dni) {
                        return controlPersis.traerUsuario(usu.getId());
                    }
                }
            }

        }
        return null;
    }

    /**
     * Este método se llama registrarPaciente y toma 11 argumentos de tipo
     * String. Luego, utiliza estos argumentos para crear un nuevo objeto de
     * tipo Paciente y lo agrega a la base de datos.
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
     * @return
     */
    public Paciente registrarPaciente(String dni, String nombre, String apellido, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
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

        List<Consulta> listConsultas = new ArrayList<>();
        List<DiagnosticoClinico> listDiagnosticoClinico = new ArrayList<>();
        List<ResultadoEstudio> listResultadoEstudio = new ArrayList<>();

        paciente.setDiagnosticoClinico(listDiagnosticoClinico);
        paciente.setResultadoEstudio(listResultadoEstudio);
        paciente.setConsultas(listConsultas);
        controlPersis.RegistrarPaciente(paciente);
        return paciente;
    }

    /**
     * Este método toma tres argumentos: un objeto de tipo String llamado lugar,
     * un objeto de tipo String llamado motivo y un objeto de tipo Paciente
     * llamado p. Luego, utiliza estos argumentos para crear un nuevo objeto de
     * tipo Consulta y lo agrega a la lista de consultas del paciente
     * especificado. Finalmente, actualiza la base de datos con la información
     * correspondiente.
     *
     * @param lugar
     * @param motivo
     * @param p
     */
    public void CrearConsulta(String lugar, String motivo, Paciente p) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        String fecha = fechaActual.format(DateTimeFormatter.ISO_DATE);
        String hora = horaActual.format(formato);

        Consulta consu = new Consulta(p, fecha, hora, null, lugar, motivo, null, null, null);
        this.controlPersis.CrearConsulta(consu);
        List<Consulta> consultas = p.getConsultas();
        consultas.add(consu);
        p.setConsultas(consultas);
        this.controlPersis.editarPaciente(p);

    }

    /**
     * Este método devuelve una lista de objetos de tipo Consulta. Esta lista
     * contiene todas las consultas que están en espera.
     *
     * @return
     */
    public List<Consulta> traerPacientesEnEspera() {
        List<Consulta> consultas = (List<Consulta>) this.esperaAtencionTriage.getEnEspera();
        return consultas;
    }

    /**
     * Este método toma un argumento de tipo int llamado dni. Luego, utiliza
     * este argumento para buscar y devolver un objeto de tipo Paciente
     * correspondiente al DNI especificado.
     *
     * @param dni
     * @return
     */
    public Paciente buscarPacientePorDni(int dni) {
        // Obtenemos la lista de pacientes del controlador de persistencia
        List<Paciente> pacientes = this.controlPersis.traerPacientes();

        // Creamos un nuevo paciente
        Paciente paciente = new Paciente();

        // Recorremos la lista de pacientes
        for (Paciente p : pacientes) {
            // Si el DNI del paciente coincide con el DNI proporcionado, asignamos el paciente a la variable paciente y terminamos el bucle
            if (p.getDni() == dni) {
                paciente = p;
                break;
            }
        }

        // Devolvemos el paciente encontrado (o el paciente vacío si no se encontró ninguno)
        return paciente;
    }

    /**
     * Crea una instancia de la clase Triage con información específica y
     * realiza varias operaciones relacionadas.
     *
     * @param respiracion El estado de la respiración.
     * @param dolorAbd La intensidad del dolor abdominal.
     * @param sangrado La intensidad del sangrado.
     * @param lesionGrave La presencia de lesiones graves.
     * @param lesionLeve La presencia de lesiones leves.
     * @param fiebre La intensidad de la fiebre.
     * @param estadoMental El estado mental del paciente.
     * @param signosShock La presencia de signos de shock.
     * @param dolorPecho La presencia de dolor en el pecho.
     * @param pulso El estado del pulso.
     * @param vomito La intensidad de los vómitos.
     * @param conciencia El estado de conciencia del paciente.
     * @param edad El grupo de edad del paciente.
     * @param idConsulta El ID de la consulta asociada.
     * @param usu El objeto Usuario asociado a esta operación.
     * @return Una instancia de Triage creada y configurada con la información
     * proporcionada.
     */
    public Triage crearTriage(String respiracion, String dolorAbd, String sangrado, String lesionGrave, String lesionLeve, String fiebre, String estadoMental, String signosShock, String dolorPecho, String pulso, String vomito, String conciencia, String edad, int idConsulta, Usuario usu) {

        Triage triage = new Triage();

        //Respiración 
        if (respiracion.equals(Respiracion.GRAVE.getTipo())) {

            triage.setResp(Respiracion.GRAVE);

        } else if (respiracion.equals(Respiracion.MODERADA.getTipo())) {

            triage.setResp(Respiracion.MODERADA);

        } else if (respiracion.equals(Respiracion.NORMAL.getTipo())) {

            triage.setResp(Respiracion.NORMAL);

        }

        //Mental
        if (estadoMental.equals(Mental.GRAVE.getTipo())) {

            triage.setEstMental(Mental.GRAVE);

        } else if (estadoMental.equals(Mental.LEVE.getTipo())) {

            triage.setEstMental(Mental.LEVE);

        } else if (estadoMental.equals(Mental.NORMAL.getTipo())) {

            triage.setEstMental(Mental.NORMAL);

        }

        //Fiebre
        if (fiebre.equals(Fiebre.ALTA.getTipo())) {

            triage.setFiebre(Fiebre.ALTA);

        } else if (fiebre.equals(Fiebre.MODERADA.getTipo())) {

            triage.setFiebre(Fiebre.MODERADA);

        } else if (fiebre.equals(Fiebre.SIN.getTipo())) {

            triage.setFiebre(Fiebre.SIN);

        }

        //Vomitos
        if (vomito.equals(Vomitos.INTENSOS.getTipo())) {

            triage.setVomitos(Vomitos.INTENSOS);

        } else if (vomito.equals(Vomitos.MODERADOS.getTipo())) {

            triage.setVomitos(Vomitos.MODERADOS);

        } else if (vomito.equals(Vomitos.SIN.getTipo())) {

            triage.setVomitos(Vomitos.SIN);

        }

        if (dolorAbd.equals(DolorAbd.SEVERO.getTipo())) {

            triage.setDolorAbd(DolorAbd.SEVERO);

        } else if (dolorAbd.equals(DolorAbd.MODERADO.getTipo())) {

            triage.setDolorAbd(DolorAbd.MODERADO);

        } else if (dolorAbd.equals(DolorAbd.NOP.getTipo())) {

            triage.setDolorAbd(DolorAbd.NOP);

        }

        //Sangrado
        if (sangrado.equals(Sangrado.INTENSO.getTipo())) {

            triage.setSangrado(Sangrado.INTENSO);

        } else if (sangrado.equals(Sangrado.MODERADO.getTipo())) {
            triage.setSangrado(Sangrado.MODERADO);

        } else if (sangrado.equals(Sangrado.NOP.getTipo())) {

            triage.setSangrado(Sangrado.NOP);

        }

        //Pulso
        if (pulso.equals(Pulso.ANORMAL.getTipo())) {

            triage.setPulso(Pulso.ANORMAL);

        } else if (pulso.equals(Pulso.NORMAL.getTipo())) {

            triage.setPulso(Pulso.NORMAL);

        }

        //Conciencia
        if (conciencia.equals(Conciencia.INCONCIENTE.getTipo())) {

            triage.setConciencia(Conciencia.INCONCIENTE);

        } else if (conciencia.equals(Conciencia.CONCIENTE.getTipo())) {

            triage.setConciencia(Conciencia.CONCIENTE);

        }

        //Dolor de Pecho
        if (dolorPecho.equals(DolorPecho.PRESENTE.getTipo())) {

            triage.setDifiResp(DolorPecho.PRESENTE);

        } else if (dolorPecho.equals(DolorPecho.NOP.getTipo())) {

            triage.setDifiResp(DolorPecho.NOP);

        }

        //LesionesGraves
        if (lesionGrave.equals(LesionesGraves.PRESENTES.getTipo())) {

            triage.setLesGraves(LesionesGraves.PRESENTES);

        } else if (lesionGrave.equals(LesionesGraves.NOP.getTipo())) {

            triage.setLesGraves(LesionesGraves.NOP);

        }

        //Edad
        if (edad.equals(Edad.ADULTO.getTipo())) {

            triage.setEdad(Edad.ADULTO);

        } else if (edad.equals(Edad.OTRO.getTipo())) {

            triage.setEdad(Edad.OTRO);

        }

        //Shock
        if (signosShock.equals(Shock.PRESENTES.getTipo())) {
            triage.setShock(Shock.PRESENTES);

        } else if (signosShock.equals(Shock.NOP.getTipo())) {

            triage.setShock(Shock.NOP);

        }

        //LesionesLeves
        if (lesionLeve.equals(LesionesLeves.PRESENTES.getTipo())) {

            triage.setLesLeves(LesionesLeves.PRESENTES);

        } else if (lesionLeve.equals(LesionesLeves.NOP.getTipo())) {

            triage.setLesLeves(LesionesLeves.NOP);
        }

        Consulta consulta = this.controlPersis.traerConsulta(idConsulta);
        triage.setConsulta(consulta);

        triage.setMedico(null);
        triage.setEnfermero(null);

        if (("Medico - Triagiador").equalsIgnoreCase(usu.getRol().getFirst().getNombre())) {

            FuncionarioGeneral funcGeneral = usu.getFuncionarioGeneral();

            triage.setMedico((Medico) funcGeneral);

        } else if (("Licenciado en Enfermeria").equalsIgnoreCase(usu.getRol().getFirst().getNombre())) {

            FuncionarioGeneral funcGeneral = usu.getFuncionarioGeneral();

            triage.setEnfermero((LicEnEnfermeria) funcGeneral);

        } else {

            FuncionarioGeneral funcGeneral = usu.getFuncionarioGeneral();

            triage.setMedico((Medico) funcGeneral);

        }

        triage.setMotCambio(null);
        triage.obtenerPuntos();

        return triage;

    }

    /**
     * Este método devuelve una lista de objetos de tipo Paciente. Esta lista
     * contiene todos los pacientes almacenados en la base de datos.
     *
     * @return
     */
    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();

    }

    /**
     * Este método toma tres argumentos: un objeto de tipo String llamado
     * motivo, un objeto de tipo String llamado color y un objeto de tipo
     * Triage. Luego, utiliza estos argumentos para actualizar el triage
     * correspondiente con el motivo y el color especificados. Finalmente,
     * actualiza la base de datos con la información correspondiente.
     *
     * @param motivo
     * @param color
     * @param triage
     * @throws java.lang.Exception
     */
    public void editarTriage(String motivo, String color, Triage triage) throws Exception {
        triage.setMotCambio(motivo);
        TipoColor colorNuevo = TipoColor.valueOf(color);
        triage.setColorFinal(colorNuevo);
        this.persistirDatos(triage);
    }

    /**
     * Este método toma un objeto de tipo Consulta como entrada. Luego, utiliza
     * este objeto para agregar la consulta a la fila de espera.
     *
     * @param consu
     */
    public void añadirALaFila(Consulta consu) {
        Consulta consuActualizada = this.esperaAtencionTriage.QuitarDeFila(consu.getTriage());
        this.esperaAtencion.añadirAFila(consuActualizada);
    }

    private PriorityQueue<Consulta> actualizarColaAtencion() {
        List<Consulta> consultas = this.controlPersis.traerConsultas();
        this.ordenarPorFechaYHora(consultas);
        this.filtrarConBox(consultas);
        PriorityQueue<Consulta> colaDeAtencion = new PriorityQueue<>(new ComparadorDeConsultas());
        for (Consulta consu : consultas) {
            colaDeAtencion.add(consu);
        }
        return colaDeAtencion;
    }

    private Queue<Consulta> actualizarColaTriage() {
        List<Consulta> consultas = this.controlPersis.traerConsultas();
        this.filtrarConTriage(consultas);
        this.ordenarPorFechaYHora(consultas);
        Queue<Consulta> colaDeTriage = new LinkedList<>();
        for (Consulta consu : consultas) {
            colaDeTriage.add(consu);
        }
        return colaDeTriage;
    }

    public void persistirDatos(Triage triage) {
        Consulta consu = triage.getConsulta();
        this.controlPersis.crearTriage(triage);
        consu.setTriage(triage);
        this.controlPersis.editarConsulta(consu);
        this.cambiarDeFila(consu);
    }

    public void cambiarDeFila(Consulta consu) {
        this.esperaAtencionTriage.quitarDeLista(consu);
        this.esperaAtencion.añadirAFila(consu);
        
    }

    class ComparadorDeConsultas implements Comparator<Consulta> {

        /**
         * Método para comparar dos consultas basándose en el color del triage.
         *
         * @param c1 La primera consulta a comparar.
         * @param c2 La segunda consulta a comparar.
         * @return Un entero que indica el resultado de la comparación.
         */
        @Override
        public int compare(Consulta c1, Consulta c2) {
            if (c1.getTriage().getColorFinal() != null) {
                if (c2.getTriage().getColorFinal() != null) {
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                } else {
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());

                }
            } else {
                if (c2.getTriage().getColorFinal() != null) {
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                } else {
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());
                }
            }
        }
    }

    public void ordenarPorFechaYHora(List<Consulta> lista) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Collections.sort(lista, new Comparator<Consulta>() {
            @Override
            public int compare(Consulta c1, Consulta c2) {
                LocalDateTime dateTime1 = LocalDateTime.parse(c1.getFecha() + " " + c1.getHora(), formatter);
                LocalDateTime dateTime2 = LocalDateTime.parse(c2.getFecha() + " " + c2.getHora(), formatter);
                return dateTime1.compareTo(dateTime2);
            }
        });
    }

    public void filtrarConTriage(List<Consulta> lista) {
    Iterator<Consulta> iterador = lista.iterator();

    while (iterador.hasNext()) {
        Consulta consu = iterador.next();

        if (consu.getTriage() != null) {
            iterador.remove();
        }
    }
}

    public void filtrarConBox(List<Consulta> lista) {
    Iterator<Consulta> iterador = lista.iterator();

    while (iterador.hasNext()) {
        Consulta consu = iterador.next();

        if (consu.getBox() != null) {
            iterador.remove();
        }
    }
}
}
