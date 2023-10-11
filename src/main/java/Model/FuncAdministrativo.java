package Model;

import java.util.ArrayList;
import javax.persistence.ManyToOne;

public abstract class FuncAdministrativo extends FuncionarioGeneral {
    
    @ManyToOne
    private Sector sector;

    public FuncAdministrativo() {
        sector = null;
    }

    public FuncAdministrativo(Sector sector, long id, String nomUsuario, String passw, Rol rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.sector = sector;
    }


    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "FuncAdministrativo{" + "sector=" + sector + '}';
    }
    
}