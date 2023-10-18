package Model;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AdministradorDeSistema extends FuncAdministrativo {

    Controladora control;
    ControladoraPersistencia controlPersis;

    @OneToMany
    private List<FuncionarioGeneral> funcionarioGeneral;

    public AdministradorDeSistema() {
        control = new Controladora();
        controlPersis = new ControladoraPersistencia();
        funcionarioGeneral = new ArrayList<>();
    }

    public AdministradorDeSistema(Controladora control, ControladoraPersistencia controlPersis, List<FuncionarioGeneral> funcionarioGeneral, Sector sector, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(sector, id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.control = control;
        this.controlPersis = controlPersis;
        this.funcionarioGeneral = funcionarioGeneral;
    }

    public List<FuncionarioGeneral> getFuncionarioGeneral() {
        return funcionarioGeneral;
    }

    public void setFuncionarioGeneral(List<FuncionarioGeneral> funcionarioGeneral) {
        this.funcionarioGeneral = funcionarioGeneral;
    }

    /**
     */
    public void VerInfoAdministrativa() {
        // TODO implement here

    }

    /**
     * @param nombre
     * @param apellido
     * @return
     */
    
    public String buscarUsuario(String nombre, String apellido) {
        String cadena = "";
        List<GestoresHospital> listaGestores = control.traerGestores();

        if (listaGestores != null) {

            for (GestoresHospital gestor : listaGestores) {

                if (gestor.getNombre().equals(nombre) && gestor.getApellido().equalsIgnoreCase(apellido)) {

                    cadena = "Id: " + gestor.getId() + " Nombre: " + gestor.getNombre() + " Apellido: "
                            + gestor.getApellido() + " Fecha de nacimiento: " + gestor.getFechaDeNac()
                            + " DNI: " + gestor.getDni() + " Domicilio: " + gestor.getDomicilio()
                            + " Tel Fijo: " + gestor.getTelefonoFijo() + " Tel Cel: " + gestor.getTelefonoCel()
                            + "Correo Electrónico: " + gestor.getCorreoE() + "Estado Civil: " + gestor.getEstadoCivil()
                            + "Nombre Usuario: " + gestor.getNomUsuario() + " Rol: " + gestor.getRol().getNombre();
                    return cadena;
                }

            }
        }

        //Traer de la DB la lista de Gestores
        List<Recepcionista> listaRecepcionistas = control.traerRecepcionistas();

        if (listaRecepcionistas != null) {

            for (Recepcionista recepcionista : listaRecepcionistas) {

                if (recepcionista.getNombre().equals(nombre) && recepcionista.getApellido().equalsIgnoreCase(apellido)) {

                    cadena = "Id: " + recepcionista.getId() + " Nombre: " + recepcionista.getNombre() + " Apellido: "
                            + recepcionista.getApellido() + " Fecha de nacimiento: " + recepcionista.getFechaDeNac()
                            + " DNI: " + recepcionista.getDni() + " Domicilio: " + recepcionista.getDomicilio()
                            + " Tel Fijo: " + recepcionista.getTelefonoFijo() + " Tel Cel: " + recepcionista.getTelefonoCel()
                            + "Correo Electrónico: " + recepcionista.getCorreoE() + "Estado Civil: " + recepcionista.getEstadoCivil()
                            + "Nombre Usuario: " + recepcionista.getNomUsuario() + " Rol: " + recepcionista.getRol().getNombre();
                    return cadena;
                }
            }
        }

        //Traer de la DB la lista de Gestores
        List<Medico> listaMedicos = control.traerMedicos();

        if (listaMedicos != null) {

            for (Medico medico : listaMedicos) {

                if (medico.getNombre().equals(nombre) && medico.getApellido().equalsIgnoreCase(apellido)) {

                    cadena = "Id: " + medico.getId() + " Nombre: " + medico.getNombre() + " Apellido: "
                            + medico.getApellido() + " Fecha de nacimiento: " + medico.getFechaDeNac()
                            + " DNI: " + medico.getDni() + " Domicilio: " + medico.getDomicilio()
                            + " Tel Fijo: " + medico.getTelefonoFijo() + " Tel Cel: " + medico.getTelefonoCel()
                            + "Correo Electrónico: " + medico.getCorreoE() + "Estado Civil: " + medico.getEstadoCivil()
                            + "Nombre Usuario: " + medico.getNomUsuario() + " Rol: " + medico.getRol().getNombre();
                    return cadena;
                }
            }
        }

        //Traer de la DB la lista de Gestores
        List<LicEnEnfermeria> listalicenciados = control.traerLicenciadosEnEnfermeria();

        if (listalicenciados != null) {

            for (LicEnEnfermeria licenciado : listalicenciados) {

                if (licenciado.getNombre().equals(nombre) && licenciado.getApellido().equalsIgnoreCase(apellido)) {

                    cadena = "Id: " + licenciado.getId() + " Nombre: " + licenciado.getNombre() + " Apellido: "
                            + licenciado.getApellido() + " Fecha de nacimiento: " + licenciado.getFechaDeNac()
                            + " DNI: " + licenciado.getDni() + " Domicilio: " + licenciado.getDomicilio()
                            + " Tel Fijo: " + licenciado.getTelefonoFijo() + " Tel Cel: " + licenciado.getTelefonoCel()
                            + "Correo Electrónico: " + licenciado.getCorreoE() + "Estado Civil: " + licenciado.getEstadoCivil()
                            + "Nombre Usuario: " + licenciado.getNomUsuario() + " Rol: " + licenciado.getRol().getNombre();
                    return cadena;
                }
            }
        }

        //Traer de la DB la lista de Gestores
        List<AdministradorDeSistema> listaAdministradores = control.traerAdministradoresDeSistema();

        if (listaAdministradores != null) {

            for (AdministradorDeSistema administrador : listaAdministradores) {

                if (administrador.getNombre().equals(nombre) && administrador.getApellido().equalsIgnoreCase(apellido)) {

                    cadena = "Id: " + administrador.getId() + " Nombre: " + administrador.getNombre() + " Apellido: "
                            + administrador.getApellido() + " Fecha de nacimiento: " + administrador.getFechaDeNac()
                            + " DNI: " + administrador.getDni() + " Domicilio: " + administrador.getDomicilio()
                            + " Tel Fijo: " + administrador.getTelefonoFijo() + " Tel Cel: " + administrador.getTelefonoCel()
                            + "Correo Electrónico: " + administrador.getCorreoE() + "Estado Civil: " + administrador.getEstadoCivil()
                            + "Nombre Usuario: " + administrador.getNomUsuario() + " Rol: " + administrador.getRol().getNombre();
                    return cadena;
                }
            }
        }

        return null;
    }

    public void crearUsuario(String nombre, String apellido, String FechaNacimiento, int documento, String domicilio, String telFijo, String telCel, String correoE, String estadoCivil, String nombreUsuario, String contrasenia, String rolRecibido) {

        if (rolRecibido.equalsIgnoreCase("Gestor")) {

            GestoresHospital gestor = new GestoresHospital();

            gestor.setNombre(nombre);
            gestor.setApellido(apellido);
            gestor.setFechaDeNac(FechaNacimiento);
            gestor.setDni(documento);
            gestor.setDomicilio(domicilio);
            gestor.setTelefonoFijo(telFijo);
            gestor.setTelefonoCel(telCel);
            gestor.setCorreoE(correoE);
            gestor.setEstadoCivil(estadoCivil);
            gestor.setNomUsuario(nombreUsuario);
            gestor.setPassw(contrasenia);

            Estadistica estadistica = new Estadistica();

            gestor.setEstadistica(estadistica);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                gestor.setRol(rolEncontrado);
            }

            int id = control.buscarUltimaIdGestores();
            gestor.setId(id + 1);
            controlPersis.crearGestor(gestor);
        }

        if (rolRecibido.equalsIgnoreCase("Recepcionista")) {

            Recepcionista recepcionista = new Recepcionista();

            recepcionista.setNombre(nombre);
            recepcionista.setApellido(apellido);
            recepcionista.setFechaDeNac(FechaNacimiento);
            recepcionista.setDni(documento);
            recepcionista.setDomicilio(domicilio);
            recepcionista.setTelefonoFijo(telFijo);
            recepcionista.setTelefonoCel(telCel);
            recepcionista.setCorreoE(correoE);
            recepcionista.setEstadoCivil(estadoCivil);
            recepcionista.setNomUsuario(nombreUsuario);
            recepcionista.setPassw(contrasenia);

            List<Paciente> listaPacientes = controlPersis.traerPaciente();
            recepcionista.setPaciente((ArrayList<Paciente>) listaPacientes);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                recepcionista.setRol(rolEncontrado);
            }

            int id = control.buscarUltimaIdRecepcionistas();
            recepcionista.setId(id + 1);
            controlPersis.crearRecepcionista(recepcionista);
        }

        if (rolRecibido.equalsIgnoreCase("Medico")) {

            Medico medico = new Medico();

            medico.setNombre(nombre);
            medico.setApellido(apellido);
            medico.setFechaDeNac(FechaNacimiento);
            medico.setDni(documento);
            medico.setDomicilio(domicilio);
            medico.setTelefonoFijo(telFijo);
            medico.setTelefonoCel(telCel);
            medico.setCorreoE(correoE);
            medico.setEstadoCivil(estadoCivil);
            medico.setNomUsuario(nombreUsuario);
            medico.setPassw(contrasenia);

            List<Especialidad> listaEspecialidades = controlPersis.traerEspecialidades();
            List<Triage> listaTriageRealizados = controlPersis.traeTriageRealizados();
            List<Consulta> listaConsultas = controlPersis.traerConsultas();

            medico.setEspecialidad((ArrayList<Especialidad>) listaEspecialidades);
            medico.setTriage((ArrayList<Triage>) listaTriageRealizados);
            medico.setConsulta((ArrayList<Consulta>) listaConsultas);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                medico.setRol(rolEncontrado);
            }

            int id = control.buscarUltimaIdMedicos();
            medico.setId(id + 1);
            controlPersis.crearMedico(medico);
        }

        if (rolRecibido.equalsIgnoreCase("Licenciado en Enfermeria")) {

            LicEnEnfermeria licEnEnfermeria = new LicEnEnfermeria();

            licEnEnfermeria.setNombre(nombre);
            licEnEnfermeria.setApellido(apellido);
            licEnEnfermeria.setFechaDeNac(FechaNacimiento);
            licEnEnfermeria.setDni(documento);
            licEnEnfermeria.setDomicilio(domicilio);
            licEnEnfermeria.setTelefonoFijo(telFijo);
            licEnEnfermeria.setTelefonoCel(telCel);
            licEnEnfermeria.setCorreoE(correoE);
            licEnEnfermeria.setEstadoCivil(estadoCivil);
            licEnEnfermeria.setNomUsuario(nombreUsuario);
            licEnEnfermeria.setPassw(contrasenia);

            List<Triage> listaTriageRealizados = controlPersis.traeTriageRealizados();
            licEnEnfermeria.setTriage((ArrayList<Triage>) listaTriageRealizados);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                licEnEnfermeria.setRol(rolEncontrado);
            }

            int id = control.buscarUltimaIdlicenciadosEnEnfermeria();
            licEnEnfermeria.setId(id + 1);
            controlPersis.crearLicEnEnfermeria(licEnEnfermeria);
        }

        if (rolRecibido.equalsIgnoreCase("Administrador de sistema")) {

            AdministradorDeSistema administrador = new AdministradorDeSistema();

            administrador.setNombre(nombre);
            administrador.setApellido(apellido);
            administrador.setFechaDeNac(FechaNacimiento);
            administrador.setDni(documento);
            administrador.setDomicilio(domicilio);
            administrador.setTelefonoFijo(telFijo);
            administrador.setTelefonoCel(telCel);
            administrador.setCorreoE(correoE);
            administrador.setEstadoCivil(estadoCivil);
            administrador.setNomUsuario(nombreUsuario);
            administrador.setPassw(contrasenia);

            Sector sector = new Sector();

            sector.setNombre("Informatica");
            administrador.setSector(sector);
            List<FuncAdministrativo> listaFuncAdministrativo = new ArrayList<FuncAdministrativo>();
            listaFuncAdministrativo.addAll(control.traerAdministradoresDeSistema());
            sector.setFuncAdministrativo(listaFuncAdministrativo);

            controlPersis.crearSector(sector);

            List<FuncionarioGeneral> listaFuncionariosEnGeneral = control.traerFuncionariosEnGeneral();
            administrador.setFuncionarioGeneral((ArrayList<FuncionarioGeneral>) listaFuncionariosEnGeneral);
            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                administrador.setRol(rolEncontrado);
            }

            int id = control.buscarUltimaIdAdministradoresDeSistema();
            administrador.setId(id + 1);
            controlPersis.crearAdministrador(administrador);
        }

    }

    public void borrarUsuario(long id, String rol) {

        if (rol.equalsIgnoreCase("Gestor")) {
            controlPersis.borrarGestor(id);
        }

        if (rol.equalsIgnoreCase("Recepcionista")) {
            controlPersis.borrarRecepcionista(id);
        }

        if (rol.equalsIgnoreCase("Medico")) {
            controlPersis.borrarMedico(id);
        }

        if (rol.equalsIgnoreCase("Licenciado en Enfermeria")) {
            controlPersis.borrarLicenciadoEnEnfermeria(id);
        }

        if (rol.equalsIgnoreCase("Administrador de Sistema")) {
            controlPersis.borrarAdministrador(id);
        }
    }

    public void editarUsuario(GestoresHospital gestor, Recepcionista recepcionista, Medico medico, LicEnEnfermeria licenciado, AdministradorDeSistema admin, String nombre, String apellido, String FechaNacimiento, int documento, String domicilio, String telFijo, String telCel, String correoE, String estadoCivil, String nombreUsuario, String contrasenia, String rolRecibido, int numMatricula) {
        if (rolRecibido.equalsIgnoreCase("Gestor")) {

            gestor.setNombre(nombre);
            gestor.setApellido(apellido);
            gestor.setFechaDeNac(FechaNacimiento);
            gestor.setDni(documento);
            gestor.setDomicilio(domicilio);
            gestor.setTelefonoFijo(telFijo);
            gestor.setTelefonoCel(telCel);
            gestor.setCorreoE(correoE);
            gestor.setEstadoCivil(estadoCivil);
            gestor.setNomUsuario(nombreUsuario);
            gestor.setPassw(contrasenia);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                gestor.setRol(rolEncontrado);
            }

            controlPersis.editarGestor(gestor);
        }

        if (rolRecibido.equalsIgnoreCase("Recepcionista")) {

            recepcionista.setNombre(nombre);
            recepcionista.setApellido(apellido);
            recepcionista.setFechaDeNac(FechaNacimiento);
            recepcionista.setDni(documento);
            recepcionista.setDomicilio(domicilio);
            recepcionista.setTelefonoFijo(telFijo);
            recepcionista.setTelefonoCel(telCel);
            recepcionista.setCorreoE(correoE);
            recepcionista.setEstadoCivil(estadoCivil);
            recepcionista.setNomUsuario(nombreUsuario);
            recepcionista.setPassw(contrasenia);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                recepcionista.setRol(rolEncontrado);
            }

            controlPersis.editarRecepcionista(recepcionista);
        }

        if (rolRecibido.equalsIgnoreCase("Medico")) {

            medico.setNombre(nombre);
            medico.setApellido(apellido);
            medico.setFechaDeNac(FechaNacimiento);
            medico.setDni(documento);
            medico.setDomicilio(domicilio);
            medico.setTelefonoFijo(telFijo);
            medico.setTelefonoCel(telCel);
            medico.setCorreoE(correoE);
            medico.setEstadoCivil(estadoCivil);
            medico.setNomUsuario(nombreUsuario);
            medico.setPassw(contrasenia);
            medico.setNumMatriculaProfesional(numMatricula);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                medico.setRol(rolEncontrado);
            }

            controlPersis.editarMedico(medico);
        }

        if (rolRecibido.equalsIgnoreCase("Licenciado en Enfermeria")) {

            licenciado.setNombre(nombre);
            licenciado.setApellido(apellido);
            licenciado.setFechaDeNac(FechaNacimiento);
            licenciado.setDni(documento);
            licenciado.setDomicilio(domicilio);
            licenciado.setTelefonoFijo(telFijo);
            licenciado.setTelefonoCel(telCel);
            licenciado.setCorreoE(correoE);
            licenciado.setEstadoCivil(estadoCivil);
            licenciado.setNomUsuario(nombreUsuario);
            licenciado.setPassw(contrasenia);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                licenciado.setRol(rolEncontrado);
            }

            controlPersis.editarlicEnEnfermeria(licenciado);
        }

        if (rolRecibido.equalsIgnoreCase("Administrador de Sistema")) {

            admin.setNombre(nombre);
            admin.setApellido(apellido);
            admin.setFechaDeNac(FechaNacimiento);
            admin.setDni(documento);
            admin.setDomicilio(domicilio);
            admin.setTelefonoFijo(telFijo);
            admin.setTelefonoCel(telCel);
            admin.setCorreoE(correoE);
            admin.setEstadoCivil(estadoCivil);
            admin.setNomUsuario(nombreUsuario);
            admin.setPassw(contrasenia);

            Rol rolEncontrado = new Rol();
            rolEncontrado = control.traerRol(rolRecibido);
            if (rolEncontrado != null) {
                admin.setRol(rolEncontrado);
            }

            controlPersis.editarAdministradorDeSitema(admin);
        }
    }

}
