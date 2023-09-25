/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Agustin C
 * 
 */
public class Sintomas {
    // enumeracion de sintomas de respiracion
    public enum Respiracion {
        NORMAL("Respiracion normal", 0),
        MODERADA("Dificultad moderada", 1),
        GRAVE("Dificultad grave",2);

        private final String tipo;
        private final int point;

        Respiracion(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("RESPIRACION: 1) %s, 2) %s , 3) %s", Respiracion.NORMAL.getTipo(), Respiracion.MODERADA.getTipo(), Respiracion.GRAVE.getTipo());
        }
    }
    // enumeracion de sintomas mentales
    public enum Mental{
        NORMAL("Normal", 0),
        LEVE("Confusion leve", 1),
        GRAVE("Confusion grave o somnolencia",2);

        private final String tipo;
        private final int point;

        Mental(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("ESTADO MENTAL: 1) %s, 2) %s , 3) %s", Mental.NORMAL.getTipo(), Mental.LEVE.getTipo(), Mental.GRAVE.getTipo());
        }
    }
    
    // enumeracion de sintomas de fiebre
    public enum Fiebre{
        SIN("Sin fiebre", 0),
        MODERADA("Fiebre moderada", 1),
        ALTA("Fiebre alta",2);

        private final String tipo;
        private final int point;

        Fiebre(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("FIEBRE: 1) %s, 2) %s , 3) %s", Fiebre.SIN.getTipo(), Fiebre.MODERADA.getTipo(), Fiebre.ALTA.getTipo());
        }
    }
    
    // enumeracion de vomitos
    public enum Vomitos{
        SIN("Sin Vomitos", 0),
        MODERADOS("Vomitos moderados", 1),
        INTENSOS("Vomitos intensos",2);

        private final String tipo;
        private final int point;

        Vomitos(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("VOMITOS: 1) %s, 2) %s , 3) %s", Vomitos.SIN.getTipo(), Vomitos.MODERADOS.getTipo(), Vomitos.INTENSOS.getTipo());
        }
    }
        
    // enumeracion de dolor abdominales
    public enum DolorAbd{
        NOP("No Presente", 0),
        MODERADO("Dolor abdominal moderado", 1),
        SEVERO("Dolor abdominal severo",2);

        private final String tipo;
        private final int point;
 
        
        DolorAbd(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("DOLOR ABDOMINAL: 1) %s, 2) %s , 3) %s", DolorAbd.NOP.getTipo(), DolorAbd.MODERADO.getTipo(), DolorAbd.SEVERO.getTipo());
        }
    }   
    
    public enum Sangrado{
        NOP("No Presente", 0),
        MODERADO("Sangrado moderado", 1),
        INTENSO("Sangrado Intenso",2);

        private final String tipo;
        private final int point;
        
        Sangrado(String a, int b){
            this.tipo = a;
            this.point = b;
        }

        public int getValorNumerico(){
            return this.point;
        }
        public String getTipo(){
            return this.tipo;
        }

        public static String opciones(){
            return String.format("SANGRADO: 1) %s, 2) %s , 3) %s", Sangrado.NOP.getTipo(), Sangrado.MODERADO.getTipo(), Sangrado.INTENSO.getTipo());
        }
    }
}