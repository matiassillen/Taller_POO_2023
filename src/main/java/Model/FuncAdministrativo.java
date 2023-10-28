package Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FuncAdministrativo extends FuncionarioGeneral {

    @ManyToOne
    @JoinColumn(name = "id_sector")
    private Sector sector;

    /**
     * Default constructor
     */
    public FuncAdministrativo() {
        sector = null;
    }

    /**
     * Contructor con parametros
     *
     * @param sector
     * @param usu
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaDeNac
     * @param domicilio
     * @param dni
     * @param telefonoFijo
     * @param telefonoCel
     * @param correoE
     * @param estadoCivil
     */
    public FuncAdministrativo(Sector sector, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.sector = sector;
    }

    /**
     *
     * @return
     */
    public Sector getSector() {
        return sector;
    }

    /**
     *
     * @param sector
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }

}
