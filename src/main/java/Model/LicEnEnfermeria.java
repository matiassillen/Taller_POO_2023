package Model;

public class LicEnEnfermeria extends FuncionarioGeneral {

    /**
     * Default constructor
     */
    public LicEnEnfermeria() {
    }

    /**
     * Contructor con parametros
     *
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
    public LicEnEnfermeria(Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

}
