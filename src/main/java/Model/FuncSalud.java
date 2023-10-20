package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class FuncSalud extends FuncionarioGeneral {

    public FuncSalud() {
    }

    public FuncSalud(Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
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