/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public enum TipoColor {
    AZUL(1),
    VERDE(2),
    AMARILLO(3),
    NARANJA(4),
    ROJO(5);

    private final Integer point;

    TipoColor(Integer a){
        this.point = a;
    }

    public Integer getValorNumerico(){
        return this.point;
    }
}