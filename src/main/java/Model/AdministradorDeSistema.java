package Model;

public class AdministradorDeSistema extends FuncAdministrativo{

    public AdministradorDeSistema(String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public AdministradorDeSistema(Sector sector, String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(sector, nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
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
