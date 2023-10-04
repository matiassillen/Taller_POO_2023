package Model;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import com.example.Variable;
import javax.swing.plaf.synth.ColorType;
import Estado;
import TipoColor;
import TDosEstados;
import TEdad;
import Consulta;
import Medico;
import LicEnEnfermeria;


/**
 * 
 */
public class Triage {

    private String motivoCambio;
    private TipoColor colorOriginal;
    private TipoColor colorFinal;
    private Estado respiración;
    private TDosEstados pulso;
    private Estado estadoMental;
    private TDosEstados conciencia;
    private Boolean dificultadRespiratoria;
    private Boolean lesionesGraves;
    private Boolean lesionesLeves;
    private TEdad edad;
    private Estado fiebre;
    private Estado vómitos;
    private Estado dolorAbdominal;
    private Boolean signosShock;
    private Estado sangrado;
    private Consulta consulta;
    private Medico realizoTriage;
    private LicEnEnfermeria enfermero;
 

    public Triage() {
    }
    
    public Triage(String motivoCambio, TipoColor colorOriginal, TipoColor colorFinal, Estado respiración,
            TDosEstados pulso, Estado estadoMental, TDosEstados conciencia, Boolean dificultadRespiratoria,
            Boolean lesionesGraves, Boolean lesionesLeves, TEdad edad, Estado fiebre, Estado vómitos,
            Estado dolorAbdominal, Boolean signosShock, Estado sangrado) {
        this.MotivoCambio = motivoCambio;
        this.ColorOriginal = colorOriginal;
        this.ColorFinal = colorFinal;
        this.Respiración = respiración;
        this.Pulso = pulso;
        this.EstadoMental = estadoMental;
        this.Conciencia = conciencia;
        this.DificultadRespiratoria = dificultadRespiratoria;
        this.LesionesGraves = lesionesGraves;
        this.LesionesLeves = lesionesLeves;
        this.Edad = edad;
        this.Fiebre = fiebre;
        this.Vómitos = vómitos;
        this.DolorAbdominal = dolorAbdominal;
        this.SignosShock = signosShock;
        this.Sangrado = sangrado;
    }

    public Triage(String motivoCambio, TipoColor colorOriginal, TipoColor colorFinal, Estado respiración,
            TDosEstados pulso, Estado estadoMental, TDosEstados conciencia, Boolean dificultadRespiratoria,
            Boolean lesionesGraves, Boolean lesionesLeves, TEdad edad, Estado fiebre, Estado vómitos,
            Estado dolorAbdominal, Boolean signosShock, Estado sangrado, Consulta consulta, Medico medico, LicEnEnfermeria Lic) {
        this.MotivoCambio = motivoCambio;
        this.ColorOriginal = colorOriginal;
        this.ColorFinal = colorFinal;
        this.Respiración = respiración;
        this.Pulso = pulso;
        this.EstadoMental = estadoMental;
        this.Conciencia = conciencia;
        this.DificultadRespiratoria = dificultadRespiratoria;
        this.LesionesGraves = lesionesGraves;
        this.LesionesLeves = lesionesLeves;
        this.Edad = edad;
        this.Fiebre = fiebre;
        this.Vómitos = vómitos;
        this.DolorAbdominal = dolorAbdominal;
        this.SignosShock = signosShock;
        this.Sangrado = sangrado;
        this.consulta = consulta;
        this.medico = medico;
        this.LicEnEnfermeria = lic;
        comparar();
    }
    

    /**
     * @return
    */
    public String getMotivoCambio() {
        return MotivoCambio;
    }

    /**
     * @param value
    */     
    public void setMotivoCambio(String value) {
        this.MotivoCambio = value
    }

    /**
     * @return
    */     
    public TipoColor getColorOriginal() {
        return ColorOriginal;
    }

    /**
     * @param value
    */     
    public void setColorOriginal(String value) {
        this.ColorOriginal = value;
    }

    /**
     * @return
    */
    public TipoColor getColorFinal() {
        return ColorFinal;
    }

    /**
     * @param value
    */
    public void setColorFinal(String value) {
        this.ColorFinal = value;
    }

    /**
     * @return
    */
    public Estado getRespiración() {
        return Respiración;
    }

    /**
     * @param value
    */     
    public void setRespiración(Estado value) {
        this.Respiración = value;
    }

    /**
     * @return
    */
    public TDosEstados getPulso() {
        return Pulso;
    }

    /**
     * @param value
    */
    public void setPulso(Boolean value) {
        this.Pulso = value;
    }

    /**
     * @return
    */
    public Estado getEstadoMental() {
        return EstadoMental;
    }

    /**
     * @param value
    */
    public void setEstadoMental(Estado value) {
        this.EstadoMental = value;
    }

    /**
     * @return
    */
    public TDosEstados getConciencia() {
        return Conciencia;
    }

    /**
     * @param value
    */
    public void setConciencia(Boolean value) {
        this.Conciencia = value;
    }

    /**
     * @return
    */
    public Boolean getDificultadRespiratoria() {
        return DificultadRespiratoria;
    }

    /**
     * @param value
    */
    public void setDificultadRespiratoria(Boolean value) {
        this.DificultadRespiratoria = value;
    }

    /**
     * @return
    */
    public Boolean getLesionesGraves() {
        return LesionesGraves;
    }

    /**
     * @param value
    */
    public void setLesionesGraves(Boolean value) {
        this.LesionesGraves = value;
    }

    /**
     * @return
    */
    public Boolean getLesionesLeves() {
        return LesionesLeves;
    }

    /**
     * @param value
    */
    public void setLesionesLeves(Boolean value) {
        this.lesionesLeves = value;
    }

    /**
     * @return
    */
    public TEdad getEdad() {
        return Edad;
    }

    /**
     * @param value
    */
    public void setEdad(TEdad value) {
        this.Edad = value;
    }

    /**
     * @return
    */
    public Estado getFiebre() {
        return Fiebre;
    }

    /**
     * @param value
    */
    public void setFiebre(Estado value) {
        this.Fiebre = value;
    }

    /**
     * @return
    */
    public Estado getVómitos() {
        return Vómitos;
    }

    /**
     * @param value
    */
    public void setVómitos(Estado value) {
        this.Vómitos = value;
    }

    /**
     * @return
    */
    public Estado getDolorAbdominal() {
        return DolorAbdominal;
    }

    /**
     * @param value
    */
    public void setDolorAbdominal(Estado value) {
        this.DolorAbdominal = value;
    }

    /**
     * @return
    */
    public Boolean getSignosShock() {
        return SignosShock;
    }

    /**
     * @param value
    */
    public void setSignosShock(Boolean value) {
        this.SignosShock = value;
    }

    /**
     * @return
    */
    public Estado getSangrado() {
        return Sangrado;
    }

    /**
     * @param value
    */
    public void setSangrado(Estado value) {
        this.Sangrado = value;
    }

    /**
    * @void
    */
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
        puntos += variablee.getValorNumerico();
        this.setColorOriginal(obtenerColor(puntos));
    }

    /**
    * @return
    */
    public TipoColor obtenerColor(int puntos) {
        TipoColor color;
        switch (puntos) {
            case puntos>=15:
                color = TipoColor.ROJO;
                break;
            case puntos>=10&&puntos<=14:
                color = TipoColor.NARANJA;
                break;
            case puntos>=5&&puntos<=9:
                color = TipoColor.AMARILLO;
                break;
            case puntos>=0&&puntos<=4:
                color = TipoColor.VERDE;
                break;
            default:
                color = TipoColor.AZUL;
                break;
            //Azul (Condiciones que pueden ser tratadas en un entorno no hospitalario):
            //Dependerá del protocolo específico de la institución y las circunstancias.
        }
        return color;
    }

    /**
     * @param fecha1 
     * @param fecha2 
     * @return
    */
    public static Map<TipoColor, Integer> triageFiltrarColorYFecha(String fecha1, String fecha2) {
        Map<String, Integer> diccionario = new HashMap<>();
        for (Codigo Para Recorer Arbol de Tiage) {
            if (Clase.fecha<fecha1&&Clase.fecha<fecha2) {
                tipoColor clave = Triage.ColorFinal;
                if(diccionario.containsKey(clave)){
                    diccionario.merge(clave, 1, Integer::sum);
                }else{
                    diccionario.put(clave, 1);
                }
            }            
        }
        return diccionario;
    }

    /**
     * @param FuncAdministrativo 
     * @return
    */
    public Integer TriagesCambiados(FuncSalud funcionario) {
        int sum = 0;
        int rango = len(funcionario.traigeHechos);
        for (i= 0; i<rango; i++) {
            Traige triageN = funcionario.traigeHechos[i];
            if (triageN.colorFinal=!null) {
                sum += 1;
            }
        }
        return sum;
    }
    
    public void comparar(FuncionarioGeneral funcionario){
        switch (funcionario.type) {
            // Revisarrr;
            case LicEnEnfermeria:
                enfermero = funcionario;
                medico = null;
                break;
            default:
                medico = funcionario;
                enfermero = null;
                break;
        }
    }

}
