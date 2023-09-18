package Model;


import java.util.*;

/**
 * 
 */
public class Paciente extends Persona {
    
    private Persona persoDeContacto;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil, String nombreP, String apellidoP, int telefonoCelP) {
        super(nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        //this.persoDeContacto(String nombreP, String apellidoP, int telefonoCelP);
    }

    public Persona getPersoDeContacto() {
        // TODO implement here
        return persoDeContacto;
    }

    public void setPersoDeContacto(Persona value) {
        // TODO implement here
    }

    public Paciente PacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

}