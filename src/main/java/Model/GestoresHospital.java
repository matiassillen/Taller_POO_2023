package Model;


import java.util.*;
import javax.persistence.Entity;

@Entity
public class GestoresHospital extends FuncionarioGeneral {
    
    private Estadistica estadistica;
    
    public GestoresHospital() {
        estadistica = null;
    }

    public GestoresHospital(Estadistica estadistica, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.estadistica = estadistica;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }
      
    
}
