package Model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Persona implements Serializable {
    
    private String persoDeContacto;
    private String telDeContacto;
    @OneToMany
    @JoinColumn(name="id_diagnosticoClinico")
    private List <DiagnosticoClinico> diagnosticoClinico;
     @OneToMany
     @JoinColumn(name="id_resultadoEstudiol")
    private List <ResultadoEstudio> resultadoEstudio;
    @OneToMany
    @JoinColumn(name="id_consulta")
    private List <Consulta> consultas;
    
    public Paciente() {
    }

    public Paciente(String persoDeContacto, String telDeContacto, List<DiagnosticoClinico> antecedenteClinico, List<ResultadoEstudio> resultadoEstudio, List<Consulta> consultas, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.persoDeContacto = persoDeContacto;
        this.telDeContacto = telDeContacto;
        this.diagnosticoClinico = antecedenteClinico;
        this.resultadoEstudio = resultadoEstudio;
        this.consultas = consultas;
    }

    public String getPersoDeContacto() {
        return persoDeContacto;
    }

    public void setPersoDeContacto(String persoDeContacto) {
        this.persoDeContacto = persoDeContacto;
    }

    public String getTelDeContacto() {
        return telDeContacto;
    }

    public void setTelDeContacto(String telDeContacto) {
        this.telDeContacto = telDeContacto;
    }

    public List<DiagnosticoClinico> getDiagnosticoClinico() {
        return diagnosticoClinico;
    }

    public void setDiagnosticoClinico(List<DiagnosticoClinico> diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }

    public List<ResultadoEstudio> getResultadoEstudio() {
        return resultadoEstudio;
    }

    public void setResultadoEstudio(List<ResultadoEstudio> resultadoEstudio) {
        this.resultadoEstudio = resultadoEstudio;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Paciente pacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

}