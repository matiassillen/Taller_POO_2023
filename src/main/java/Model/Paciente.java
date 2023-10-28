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
    @JoinColumn(name = "id_diagnosticoClinico")
    private List<DiagnosticoClinico> diagnosticoClinico;
    @OneToMany
    @JoinColumn(name = "id_resultadoEstudiol")
    private List<ResultadoEstudio> resultadoEstudio;
    @OneToMany
    @JoinColumn(name = "id_consulta")
    private List<Consulta> consultas;

    /**
     * Default costructor
     */
    public Paciente() {
    }

    /**
     * Constructor con parametros
     *
     * @param persoDeContacto
     * @param telDeContacto
     * @param antecedenteClinico
     * @param resultadoEstudio
     * @param consultas
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
    public Paciente(String persoDeContacto, String telDeContacto, List<DiagnosticoClinico> antecedenteClinico, List<ResultadoEstudio> resultadoEstudio, List<Consulta> consultas, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.persoDeContacto = persoDeContacto;
        this.telDeContacto = telDeContacto;
        this.diagnosticoClinico = antecedenteClinico;
        this.resultadoEstudio = resultadoEstudio;
        this.consultas = consultas;
    }

    /**
     *
     * @return
     */
    public String getPersoDeContacto() {
        return persoDeContacto;
    }

    /**
     *
     * @param persoDeContacto
     */
    public void setPersoDeContacto(String persoDeContacto) {
        this.persoDeContacto = persoDeContacto;
    }

    /**
     *
     * @return
     */
    public String getTelDeContacto() {
        return telDeContacto;
    }

    /**
     *
     * @param telDeContacto
     */
    public void setTelDeContacto(String telDeContacto) {
        this.telDeContacto = telDeContacto;
    }

    /**
     *
     * @return
     */
    public List<DiagnosticoClinico> getDiagnosticoClinico() {
        return diagnosticoClinico;
    }

    /**
     *
     * @param diagnosticoClinico
     */
    public void setDiagnosticoClinico(List<DiagnosticoClinico> diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }

    /**
     *
     * @return
     */
    public List<ResultadoEstudio> getResultadoEstudio() {
        return resultadoEstudio;
    }

    /**
     *
     * @param resultadoEstudio
     */
    public void setResultadoEstudio(List<ResultadoEstudio> resultadoEstudio) {
        this.resultadoEstudio = resultadoEstudio;
    }

    /**
     *
     * @return
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     *
     * @param consultas
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    /**
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public Paciente pacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

}
