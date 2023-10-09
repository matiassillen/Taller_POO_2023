package Model;

import java.util.ArrayList;

public class FuncSalud extends FuncionarioGeneral {

    public FuncSalud() {
    }

    public FuncSalud(long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public void AsignarBox() {
        // TODO implement here
    }
   
    public void CargarSintomas() {
        // TODO implement here
    }

    public void CambiarColor() {
        // TODO implement here
    }

}