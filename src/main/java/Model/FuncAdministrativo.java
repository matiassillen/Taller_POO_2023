package Model;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class FuncAdministrativo extends FuncionarioGeneral {
    
    //@ManyToOne
   @Transient
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