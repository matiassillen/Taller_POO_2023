package Model;


import java.io.Serializable;

public class GestoresHospital extends FuncionarioGeneral implements Serializable{
     
    public GestoresHospital() {
        
    }

    public GestoresHospital(Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

}