package Model;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeSistema extends FuncAdministrativo {

    Controladora control;

    /**
     * Constructor que inicializa la instancia de la clase Controladora.
     *
     * @param control
     */
    public AdministradorDeSistema(Controladora control) {
        this.control = control;
    }

    /**
     * Constructor que inicializa los atributos de la clase con los valores
     * recibidos.
     *
     * @param sector
     * @param usu
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaDeNac
     * @param domicilio
     * @param dni
     * @param telefonoFijo
     * @param telefonoCel
     * @param correoE
     * @param estadoCivil
     */
    public AdministradorDeSistema(Sector sector, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(sector, usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public void VerInfoAdministrativa() {
        // TODO implement here
    }

    /**
     * Método que crea un nuevo usuario con el nombre de usuario y contraseña
     * recibidos. También asigna el rol y el funcionario general
     * correspondientes al usuario.
     *
     * @param nombreUsuario
     * @param contrasenia
     * @param rolRecibido
     * @param funcGeneral
     */
    public void crearUsuario(String nombreUsuario, String contrasenia, String rolRecibido, FuncionarioGeneral funcGeneral) {
        Usuario usu = new Usuario();

        usu.setNomUsuario(nombreUsuario);
        usu.setPassw(contrasenia);

        Rol rolEncontrado = new Rol();
        rolEncontrado = control.traerRol(rolRecibido);

        if (rolEncontrado != null) {

            List<Rol> roles = new ArrayList<>();
            roles.add(rolEncontrado);

            usu.setRol(roles);
        }

        usu.setFuncionarioGeneral(funcGeneral);

        control.controlPersis.crearUsuario(usu);
    }

    /**
     * Método que busca un usuario por su número de documento. Si se encuentra
     * el usuario, se muestra un mensaje de éxito y se devuelve el objeto
     * Usuario correspondiente. De lo contrario, se muestra un mensaje de error.
     *
     * @param dni
     * @return
     */
    public Usuario buscarUsuario(int dni) {

        List<Usuario> listaUsuarios = control.controlPersis.traerUsuarios();

        if (listaUsuarios != null) {

            for (Usuario usu : listaUsuarios) {

                if (usu.getFuncionarioGeneral().getDni() == dni) {

                    control.mostrarMensaje("Usuario encotrado", "Info", "Busqueda exitosa");
                    return control.controlPersis.traerUsuario(usu.getId());

                }
            }
        } else {
            control.mostrarMensaje("Usuario no encontrado", "Error", "Error");
        }

        return null;

    }

    /**
     * El método elimina un usuario de la base de datos. Primero, se recupera el
     * usuario correspondiente al ID recibido utilizando el método
     * traerUsuario(id). Luego, se recupera el objeto FuncionarioGeneral
     * asociado al usuario y se establece su atributo usu en null. Finalmente,
     * se llama al método borrarUsuario(id) de la instancia de la clase
     * Controladora para eliminar el usuario de la base de datos.
     *
     * @param id
     */
    public void borrarUsuario(long id) {

        Usuario usuario = control.controlPersis.traerUsuario(id);
        FuncionarioGeneral funcioGeneral = usuario.getFuncionarioGeneral();

        control.controlPersis.borrarUsuario(id);

        funcioGeneral.setUsu(null);

    }

    /**
     * El método actualiza los atributos del objeto Usuario recibido con los
     * valores recibidos. Primero, se establecen los nuevos valores para los
     * atributos nomUsuario y passw. Luego, se busca el objeto Rol
     * correspondiente al nombre del rol proporcionado utilizando el método
     * traerRol(rolRecibido). Si se encuentra el objeto Rol, se crea una lista
     * que contiene solo ese objeto y se establece como el nuevo valor del
     * atributo rol del objeto Usuario. Finalmente, se llama al método
     * editarUsuario(usuario) de la instancia de la clase Controladora para
     * actualizar el objeto Usuario en la base de datos.
     *
     * @param usuario
     * @param nombreUsuario
     * @param contrasenia
     * @param rolRecibido
     */
    public void editarUsuario(Usuario usuario, String nombreUsuario, String contrasenia, String rolRecibido) {

        usuario.setNomUsuario(nombreUsuario);
        usuario.setPassw(contrasenia);

        Rol rolEncontrado = new Rol();
        rolEncontrado = control.traerRol(rolRecibido);

        if (rolEncontrado != null) {

            List<Rol> roles = new ArrayList<>();
            roles.add(rolEncontrado);

            usuario.setRol(roles);
        }

        control.controlPersis.editarUsuario(usuario);
    }

}
