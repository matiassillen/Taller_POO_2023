package Model;

import java.util.ArrayList;

public class AdministradorDeSistema extends FuncAdministrativo{

    public AdministradorDeSistema() {
    }

    public AdministradorDeSistema(Sector sector, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(sector, id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public void ModificarUsuario() {
        // TODO implement here
        
    }

    /**
     * @return
    */
    public void VerInfoAdministrativa() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void CrearUsuario() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public void BuscarUsuario() {
        // TODO implement here
        
    }

}
