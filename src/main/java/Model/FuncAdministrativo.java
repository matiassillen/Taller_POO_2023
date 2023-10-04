package Model;

public class FuncAdministrativo extends FuncionarioGeneral {
    
    private Sector sector;
    public FuncAdministrativo() {
    }
    public FuncAdministrativo(Sector sector) {
        
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