package Model;

import java.util.ArrayList;

public class LicEnEnfermeria extends FuncionarioGeneral {

    public LicEnEnfermeria() {
    }

    public LicEnEnfermeria(long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }


}