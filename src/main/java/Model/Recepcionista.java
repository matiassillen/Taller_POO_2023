package Model;

//import static Model.Paciente_.antecedenteClinico;
//import static Model.Paciente_.resultadoEstudio;
import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Recepcionista extends FuncionarioGeneral {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    @OneToMany
    private List <Paciente> paciente;

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

    public int BuscarPaciente (int dni){
        
        return 0;
    }
    
    //---------Metodos para Consulta---------
    public void CrearConsulta(String fecha, String hora, String diagnConsulta, String lugar, String motivo){
        Consulta consulta = new Consulta();
        Paciente pac = new Paciente();
        Medico medico = new Medico();
        Triage triage = new Triage();
        consulta.setPaciente(pac);
        consulta.setMotivo(motivo);
        consulta.setLugar(lugar);
        consulta.setFecha(fecha);
        consulta.setHora(0);
        consulta.setMedico(medico);
        consulta.setBox(Box.BOX1);
        consulta.setTriage(triage);
        consulta.setDiagnConsulta(diagnConsulta);
        controlPersis.CrearConsulta(consulta);
    }
    
    public void AniadirAListaDeEsperaTriage(){
    
    }
    
    //---------Metodos para Paciente---------
    public void RegistrarPaciente(String nombre, String apellido, String dni, String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
        Paciente paciente = new Paciente();
        int documento = Integer.parseInt(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setDni(documento);
        paciente.setFechaDeNac(fechaNacimiento);
        paciente.setDomicilio(domicilio);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setCorreoE(correo);
        paciente.setTelefonoCel(telFijo);
        paciente.setTelefonoFijo(telCelular);
        paciente.setPersoDeContacto(personaContacto);
        paciente.setTelDeContacto(numContacto);
//        paciente.setAntecedenteClinico((List<AntecedenteClinico>) antecedenteClinico);
//        paciente.setResultadoEstudio((List<ResultadoEstudio>) resultadoEstudio);
        controlPersis.RegistrarPaciente(paciente);
    }
    
    public List<Paciente> traerPacientes() {
        
        return controlPersis.traerPacientes();
    }
    
    public Paciente traerPaciente(int id_Paciente) {
        return controlPersis.traerPaciente(id_Paciente);
    }
    
    @Override
    public String toString() {
        return "Recepcionista{" + "paciente=" + paciente + '}';
    }
}
