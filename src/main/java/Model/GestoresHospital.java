package Model;


import java.util.*;


public class GestoresHospital extends FuncionarioGeneral {

    public GestoresHospital() {
    }

    public GestoresHospital(long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

}
