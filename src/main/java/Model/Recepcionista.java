package Model;

import java.util.ArrayList;
import java.util.List;

public class Recepcionista extends FuncionarioGeneral {

    private List<Paciente> paciente;

    /**
     * Defautl constructor
     */
    public Recepcionista() {
        this.paciente = new ArrayList<>();
    }

    /**
     * Constructor con parametros
     *
     * @param paciente
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
    public Recepcionista(List<Paciente> paciente, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.paciente = paciente;
    }

    /**
     *
     * @return
     */
    public List<Paciente> getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

}
