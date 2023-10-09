package Model;

import Model.Sintomas.*;


public class Triage {

    private String motivoCambio;
    private TipoColor colorOriginal;
    private TipoColor colorFinal;
    private Respiracion respiración;
    private Pulso pulso;
    private Mental estadoMental;
    private Conciencia conciencia;
    private DolorPecho dificultadRespiratoria;
    private LesionesGraves lesionesGraves;
    private LesionesLeves lesionesLeves;
    private Edad edad;
    private Fiebre fiebre;
    private Vomitos vómitos;
    private DolorAbd dolorAbdominal;
    private Shock signosShock;
    private Sangrado sangrado;
    private Consulta consulta;
    private Medico medico;
    private LicEnEnfermeria enfermero;
 

    public Triage() {
    }

    public Triage(String motivoCambio, TipoColor colorOriginal, TipoColor colorFinal, Respiracion respiración, Pulso pulso, Mental estadoMental, Conciencia conciencia, DolorPecho dificultadRespiratoria, LesionesGraves lesionesGraves, LesionesLeves lesionesLeves, Edad edad, Fiebre fiebre, Vomitos vómitos, DolorAbd dolorAbdominal, Shock signosShock, Sangrado sangrado, Consulta consulta, Medico realizoTriage, LicEnEnfermeria enfermero) {
        this.motivoCambio = motivoCambio;
        this.colorOriginal = colorOriginal;
        this.colorFinal = colorFinal;
        this.respiración = respiración;
        this.pulso = pulso;
        this.estadoMental = estadoMental;
        this.conciencia = conciencia;
        this.dificultadRespiratoria = dificultadRespiratoria;
        this.lesionesGraves = lesionesGraves;
        this.lesionesLeves = lesionesLeves;
        this.edad = edad;
        this.fiebre = fiebre;
        this.vómitos = vómitos;
        this.dolorAbdominal = dolorAbdominal;
        this.signosShock = signosShock;
        this.sangrado = sangrado;
        this.consulta = consulta;
        this.medico = realizoTriage;
        this.enfermero = enfermero;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public TipoColor getColorOriginal() {
        return colorOriginal;
    }

    public TipoColor getColorFinal() {
        return colorFinal;
    }

    public Respiracion getRespiración() {
        return respiración;
    }

    public Pulso getPulso() {
        return pulso;
    }

    public Mental getEstadoMental() {
        return estadoMental;
    }

    public Conciencia getConciencia() {
        return conciencia;
    }

    public DolorPecho getDificultadRespiratoria() {
        return dificultadRespiratoria;
    }

    public LesionesGraves getLesionesGraves() {
        return lesionesGraves;
    }

    public LesionesLeves getLesionesLeves() {
        return lesionesLeves;
    }

    public Edad getEdad() {
        return edad;
    }

    public Fiebre getFiebre() {
        return fiebre;
    }

    public Vomitos getVómitos() {
        return vómitos;
    }

    public DolorAbd getDolorAbdominal() {
        return dolorAbdominal;
    }

    public Shock getSignosShock() {
        return signosShock;
    }

    public Sangrado getSangrado() {
        return sangrado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public Medico getRealizoTriage() {
        return medico;
    }

    public LicEnEnfermeria getEnfermero() {
        return enfermero;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public void setColorOriginal(TipoColor colorOriginal) {
        this.colorOriginal = colorOriginal;
    }

    public void setColorFinal(TipoColor colorFinal) {
        this.colorFinal = colorFinal;
    }

    public void setRespiración(Respiracion respiración) {
        this.respiración = respiración;
    }

    public void setPulso(Pulso pulso) {
        this.pulso = pulso;
    }

    public void setEstadoMental(Mental estadoMental) {
        this.estadoMental = estadoMental;
    }

    public void setConciencia(Conciencia conciencia) {
        this.conciencia = conciencia;
    }

    public void setDificultadRespiratoria(DolorPecho dificultadRespiratoria) {
        this.dificultadRespiratoria = dificultadRespiratoria;
    }

    public void setLesionesGraves(LesionesGraves lesionesGraves) {
        this.lesionesGraves = lesionesGraves;
    }

    public void setLesionesLeves(LesionesLeves lesionesLeves) {
        this.lesionesLeves = lesionesLeves;
    }

    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    public void setFiebre(Fiebre fiebre) {
        this.fiebre = fiebre;
    }

    public void setVómitos(Vomitos vómitos) {
        this.vómitos = vómitos;
    }

    public void setDolorAbdominal(DolorAbd dolorAbdominal) {
        this.dolorAbdominal = dolorAbdominal;
    }

    public void setSignosShock(Shock signosShock) {
        this.signosShock = signosShock;
    }

    public void setSangrado(Sangrado sangrado) {
        this.sangrado = sangrado;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public void setRealizoTriage(Medico realizoTriage) {
        this.medico = realizoTriage;
    }

    public void setEnfermero(LicEnEnfermeria enfermero) {
        this.enfermero = enfermero;
    }

   public void obtenerPuntos() {
       int puntos = 0;
       puntos += this.respiración.getValorNumerico();
       puntos += this.dolorAbdominal.getValorNumerico();
       puntos += this.sangrado.getValorNumerico();
       puntos += this.estadoMental.getValorNumerico();
       puntos += this.signosShock.getValorNumerico();
       puntos += this.edad.getValorNumerico();
       puntos += this.dificultadRespiratoria.getValorNumerico();
       puntos += this.pulso.getValorNumerico();
       puntos += this.conciencia.getValorNumerico();
       puntos += this.lesionesGraves.getValorNumerico();
       puntos += this.lesionesLeves.getValorNumerico();
       puntos += this.fiebre.getValorNumerico();
       puntos += this.vómitos.getValorNumerico();
       this.setColorOriginal(obtenerColor(puntos));
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