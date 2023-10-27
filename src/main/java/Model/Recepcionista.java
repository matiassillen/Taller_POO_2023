package Model;

import java.util.ArrayList;
import java.util.List;

public class Recepcionista extends FuncionarioGeneral {

    private List<Paciente> paciente;

    public Recepcionista() {
        this.paciente = new ArrayList<>();
    }

    public Recepcionista(List<Paciente> paciente, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.paciente = paciente;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public int BuscarPaciente(int dni) {

        return 0;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "paciente=" + paciente + '}';
    }
}
