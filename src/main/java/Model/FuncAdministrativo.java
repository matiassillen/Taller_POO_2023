package Model;

public class FuncAdministrativo extends FuncionarioGeneral {
    
    private Sector sector;

    public FuncAdministrativo(String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public FuncAdministrativo(Sector sector, String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
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