package Model;


import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;

@Entity
public class GestoresHospital extends FuncionarioGeneral implements Serializable{
    
    private Estadistica estadistica;
    
    public GestoresHospital() {
        estadistica = null;
    }

    public GestoresHospital(Estadistica estadistica, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.estadistica = estadistica;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

}
