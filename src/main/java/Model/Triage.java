package Model;

import Model.Sintomas.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Triage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String motCambio;
    private TipoColor colorInicial;
    private TipoColor colorFinal;
    private Respiracion resp;
    private Pulso pulso;
    private Mental estMental;
    private Conciencia conciencia;
    private DolorPecho difiResp;
    private LesionesGraves lesGraves;
    private LesionesLeves lesLeves;
    private Edad edad;
    private Fiebre fiebre;
    private Vomitos vomitos;
    private DolorAbd dolorAbd;
    private Shock shock;
    private Sangrado sangrado;
    @OneToOne(mappedBy = "triage")
    private Consulta consulta;
    @ManyToOne
    private Medico medico;
    //@ManyToOne
    @Transient
    private LicEnEnfermeria enfermero;

    /**
     * Defautl constructor
     */
    public Triage() {

    }

    /**
     * Constructor con parametros
     *
     * @param id
     * @param motivoCambio
     * @param respiracion
     * @param pulso
     * @param estadoMental
     * @param conciencia
     * @param dificultadRespiratoria
     * @param lesionesGraves
     * @param lesionesLeves
     * @param edad
     * @param fiebre
     * @param vómitos
     * @param dolorAbdominal
     * @param signosShock
     * @param sangrado
     * @param consulta
     * @param realizoTriage
     * @param enfermero
     */
    public Triage(int id, String motivoCambio, Respiracion respiracion, Pulso pulso, Mental estadoMental, Conciencia conciencia, DolorPecho dificultadRespiratoria, LesionesGraves lesionesGraves, LesionesLeves lesionesLeves, Edad edad, Fiebre fiebre, Vomitos vómitos, DolorAbd dolorAbdominal, Shock signosShock, Sangrado sangrado, Consulta consulta, Medico realizoTriage, LicEnEnfermeria enfermero) {
        this.id = id;
        this.motCambio = motivoCambio;
        this.resp = respiracion;
        this.pulso = pulso;
        this.estMental = estadoMental;
        this.conciencia = conciencia;
        this.difiResp = dificultadRespiratoria;
        this.lesGraves = lesionesGraves;
        this.lesLeves = lesionesLeves;
        this.edad = edad;
        this.fiebre = fiebre;
        this.vomitos = vomitos;
        this.dolorAbd = dolorAbdominal;
        this.shock = signosShock;
        this.sangrado = sangrado;
        this.consulta = consulta;
        this.medico = realizoTriage;
        this.enfermero = enfermero;
        this.obtenerPuntos();
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getMotCambio() {
        return motCambio;
    }

    /**
     *
     * @param motCambio
     */
    public void setMotCambio(String motCambio) {
        this.motCambio = motCambio;
    }

    /**
     *
     * @return
     */
    public TipoColor getColorInicial() {
        return colorInicial;
    }

    /**
     *
     * @param colorInicial
     */
    public void setColorInicial(TipoColor colorInicial) {
        this.colorInicial = colorInicial;
    }

    /**
     *
     * @return
     */
    public TipoColor getColorFinal() {
        return colorFinal;
    }

    /**
     *
     * @param colorFinal
     */
    public void setColorFinal(TipoColor colorFinal) {
        this.colorFinal = colorFinal;
    }

    /**
     *
     * @return
     */
    public Respiracion getResp() {
        return resp;
    }

    /**
     *
     * @param resp
     */
    public void setResp(Respiracion resp) {
        this.resp = resp;
    }

    /**
     *
     * @return
     */
    public Pulso getPulso() {
        return pulso;
    }

    /**
     *
     * @param pulso
     */
    public void setPulso(Pulso pulso) {
        this.pulso = pulso;
    }

    /**
     *
     * @return
     */
    public Mental getEstMental() {
        return estMental;
    }

    /**
     *
     * @param estMental
     */
    public void setEstMental(Mental estMental) {
        this.estMental = estMental;
    }

    /**
     *
     * @return
     */
    public Conciencia getConciencia() {
        return conciencia;
    }

    /**
     *
     * @param conciencia
     */
    public void setConciencia(Conciencia conciencia) {
        this.conciencia = conciencia;
    }

    /**
     *
     * @return
     */
    public DolorPecho getDifiResp() {
        return difiResp;
    }

    /**
     *
     * @param difiResp
     */
    public void setDifiResp(DolorPecho difiResp) {
        this.difiResp = difiResp;
    }

    /**
     *
     * @return
     */
    public LesionesGraves getLesGraves() {
        return lesGraves;
    }

    /**
     *
     * @param lesGraves
     */
    public void setLesGraves(LesionesGraves lesGraves) {
        this.lesGraves = lesGraves;
    }

    /**
     *
     * @return
     */
    public LesionesLeves getLesLeves() {
        return lesLeves;
    }

    /**
     *
     * @param lesLeves
     */
    public void setLesLeves(LesionesLeves lesLeves) {
        this.lesLeves = lesLeves;
    }

    /**
     *
     * @return
     */
    public Edad getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    /**
     *
     * @return
     */
    public Fiebre getFiebre() {
        return fiebre;
    }

    /**
     *
     * @param fiebre
     */
    public void setFiebre(Fiebre fiebre) {
        this.fiebre = fiebre;
    }

    /**
     *
     * @return
     */
    public Vomitos getVomitos() {
        return vomitos;
    }

    /**
     *
     * @param vomitos
     */
    public void setVomitos(Vomitos vomitos) {
        this.vomitos = vomitos;
    }

    /**
     *
     * @return
     */
    public DolorAbd getDolorAbd() {
        return dolorAbd;
    }

    /**
     *
     * @param dolorAbd
     */
    public void setDolorAbd(DolorAbd dolorAbd) {
        this.dolorAbd = dolorAbd;
    }

    /**
     *
     * @return
     */
    public Shock getShock() {
        return shock;
    }

    /**
     *
     * @param shock
     */
    public void setShock(Shock shock) {
        this.shock = shock;
    }

    /**
     *
     * @return
     */
    public Sangrado getSangrado() {
        return sangrado;
    }

    /**
     *
     * @param sangrado
     */
    public void setSangrado(Sangrado sangrado) {
        this.sangrado = sangrado;
    }

    /**
     *
     * @return
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     *
     * @param consulta
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     *
     * @return
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     *
     * @return
     */
    public LicEnEnfermeria getEnfermero() {
        return enfermero;
    }

    /**
     *
     * @param enfermero
     */
    public void setEnfermero(LicEnEnfermeria enfermero) {
        this.enfermero = enfermero;
    }

    /**
     * El método tiene trece variables de instancia, resp, dolorAbd, sangrado,
     * estMental, shock, edad, difiResp, pulso, conciencia, lesGraves, lesLeves,
     * fiebre y vomitos. El método suma los valores numéricos de estas variables
     * de instancia y los almacena en la variable local puntos. Luego, el método
     * llama al método setColorInicial() con el resultado de la función
     * obtenerColor() pasando como argumento la variable local puntos.
     */
    public void obtenerPuntos() {
        int puntos = 0;
        puntos += this.resp.getValorNumerico();
        puntos += this.dolorAbd.getValorNumerico();
        puntos += this.sangrado.getValorNumerico();
        puntos += this.estMental.getValorNumerico();
        puntos += this.shock.getValorNumerico();
        puntos += this.edad.getValorNumerico();
        puntos += this.difiResp.getValorNumerico();
        puntos += this.pulso.getValorNumerico();
        puntos += this.conciencia.getValorNumerico();
        puntos += this.lesGraves.getValorNumerico();
        puntos += this.lesLeves.getValorNumerico();
        puntos += this.fiebre.getValorNumerico();
        puntos += this.vomitos.getValorNumerico();
        this.setColorInicial(obtenerColor(puntos));
    }

    /**
     * El método obtenerColor toma un argumento puntos de tipo int y devuelve un
     * objeto TipoColor. El método utiliza una serie de declaraciones if-else
     * para asignar un valor a la variable color en función del valor de puntos.
     * Si puntos es mayor o igual a 15, el método devuelve el valor
     * TipoColor.ROJO. Si puntos está entre 10 y 14, ambos inclusive, el método
     * devuelve el valor TipoColor.NARANJA. Si puntos está entre 5 y 9, ambos
     * inclusive, el método devuelve el valor TipoColor.AMARILLO. Si puntos está
     * entre 0 y 4, ambos inclusive, el método devuelve el valor
     * TipoColor.VERDE. De lo contrario, el método devuelve el valor
     * TipoColor.AZUL.
     */
    public TipoColor obtenerColor(int puntos) {
        TipoColor color;
        if (puntos >= 15) {
            color = TipoColor.ROJO;
        } else if (puntos >= 10 && puntos <= 14) {
            color = TipoColor.NARANJA;
        } else if (puntos >= 5 && puntos <= 9) {
            color = TipoColor.AMARILLO;
        } else if (puntos >= 0 && puntos <= 4) {
            color = TipoColor.VERDE;
        } else {
            color = TipoColor.AZUL;
        }
        return color;
    }

}
