/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author yairc
 */
public class EsperaTriage {
    private Queue<Consulta> enEsperaT;

    public EsperaTriage() {
        this.enEsperaT = new LinkedList<>();
    }
      
    
    public Consulta QuitarDeFila(Triage t){
        Consulta consu = this.enEsperaT.poll();
        consu.setTriage(t);
        return consu;
    }
    
    public void AñadirALaFila(Consulta consu){
        enEsperaT.add(consu);
    }

    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }
    

    
}
