package Model;

import Model.Sintomas.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Triage implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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
    private Vomitos vómitos;
    private DolorAbd dolorAbd;
    private Shock shock;
    private Sangrado sangrado;
    @OneToOne(mappedBy="triage")
    private Consulta consulta;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private LicEnEnfermeria enfermero;
 
    public Triage() {
        
    }

    public Triage(int id, String motivoCambio, TipoColor colorOriginal, TipoColor colorFinal, Respiracion respiración, Pulso pulso, Mental estadoMental, Conciencia conciencia, DolorPecho dificultadRespiratoria, LesionesGraves lesionesGraves, LesionesLeves lesionesLeves, Edad edad, Fiebre fiebre, Vomitos vómitos, DolorAbd dolorAbdominal, Shock signosShock, Sangrado sangrado, Consulta consulta, Medico realizoTriage, LicEnEnfermeria enfermero) {
        this.id = id;
        this.motCambio = motivoCambio;
        this.colorInicial = colorOriginal;
        this.colorFinal = colorFinal;
        this.resp = respiración;
        this.pulso = pulso;
        this.estMental = estadoMental;
        this.conciencia = conciencia;
        this.difiResp = dificultadRespiratoria;
        this.lesGraves = lesionesGraves;
        this.lesLeves = lesionesLeves;
        this.edad = edad;
        this.fiebre = fiebre;
        this.vómitos = vómitos;
        this.dolorAbd = dolorAbdominal;
        this.shock = signosShock;
        this.sangrado = sangrado;
        this.consulta = consulta;
        this.medico = realizoTriage;
        this.enfermero = enfermero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMotCambio() {
        return motCambio;
    }

    public void setMotCambio(String motCambio) {
        this.motCambio = motCambio;
    }

    public TipoColor getColorInicial() {
        return colorInicial;
    }

    public void setColorInicial(TipoColor colorInicial) {
        this.colorInicial = colorInicial;
    }

    public TipoColor getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(TipoColor colorFinal) {
        this.colorFinal = colorFinal;
    }

    public Respiracion getResp() {
        return resp;
    }

    public void setResp(Respiracion resp) {
        this.resp = resp;
    }

    public Pulso getPulso() {
        return pulso;
    }

    public void setPulso(Pulso pulso) {
        this.pulso = pulso;
    }

    public Mental getEstMental() {
        return estMental;
    }

    public void setEstMental(Mental estMental) {
        this.estMental = estMental;
    }

    public Conciencia getConciencia() {
        return conciencia;
    }

    public void setConciencia(Conciencia conciencia) {
        this.conciencia = conciencia;
    }

    public DolorPecho getDifiResp() {
        return difiResp;
    }

    public void setDifiResp(DolorPecho difiResp) {
        this.difiResp = difiResp;
    }

    public LesionesGraves getLesGraves() {
        return lesGraves;
    }

    public void setLesGraves(LesionesGraves lesGraves) {
        this.lesGraves = lesGraves;
    }

    public LesionesLeves getLesLeves() {
        return lesLeves;
    }

    public void setLesLeves(LesionesLeves lesLeves) {
        this.lesLeves = lesLeves;
    }

    public Edad getEdad() {
        return edad;
    }

    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    public Fiebre getFiebre() {
        return fiebre;
    }

    public void setFiebre(Fiebre fiebre) {
        this.fiebre = fiebre;
    }

    public Vomitos getVómitos() {
        return vómitos;
    }

    public void setVómitos(Vomitos vómitos) {
        this.vómitos = vómitos;
    }

    public DolorAbd getDolorAbd() {
        return dolorAbd;
    }

    public void setDolorAbd(DolorAbd dolorAbd) {
        this.dolorAbd = dolorAbd;
    }

    public Shock getShock() {
        return shock;
    }

    public void setShock(Shock shock) {
        this.shock = shock;
    }

    public Sangrado getSangrado() {
        return sangrado;
    }

    public void setSangrado(Sangrado sangrado) {
        this.sangrado = sangrado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LicEnEnfermeria getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(LicEnEnfermeria enfermero) {
        this.enfermero = enfermero;
    }

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
       puntos += this.vómitos.getValorNumerico();
       this.setColorInicial(obtenerColor(puntos));
   }

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