package Model;

<<<<<<< HEAD
import static Model.Paciente_.antecedenteClinico;
import static Model.Paciente_.resultadoEstudio;
=======
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
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
    public void CrearConsulta(Date fecha, Long hora, String lugar, String Motivo, Paciente paciente){
        Consulta consulta = new Consulta();
        
        Medico medico = new Medico();
        Triage triage = new Triage();
        
        consulta.setPaciente(paciente);
        consulta.setLugar(lugar);
        consulta.setFecha(fecha);
        consulta.setHora(hora);
        consulta.setMedico(medico);
        consulta.setTriage(triage);
        consulta.setDiagnConsulta("");
        controlPersis.CrearConsulta(consulta);
    }
    
    public void AniadirAListaDeEsperaTriage(){
    
    }
    
    //---------Metodos para Paciente---------
    public void RegistrarPaciente(String dni, String nombre, String apellido,  String fechaNacimiento, String domicilio, String estadoCivil, String correo, String telCelular, String telFijo, String personaContacto, String numContacto) {
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
        
        List <AntecedenteClinico>listAntecedenteClinico = new ArrayList <AntecedenteClinico>();
        List <ResultadoEstudio>listResultadoEstudio = new ArrayList <ResultadoEstudio>();
        List <Consulta>listConsulta = new ArrayList <Consulta>();
        
        paciente.setAntecedenteClinico(listAntecedenteClinico);
        paciente.setResultadoEstudio(listResultadoEstudio);
        paciente.setConsulta(listConsulta);
        
        controlPersis.RegistrarPaciente(paciente);
    }
    
    public Paciente TraerPaciente(int dni) {
        
        return controlPersis.TraerPaciente(dni);
    }
    
    
    @Override
    public String toString() {
        return "Recepcionista{" + "paciente=" + paciente + '}';
    }

    
}
