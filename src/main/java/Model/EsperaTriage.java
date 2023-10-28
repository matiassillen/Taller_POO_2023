package Model;


import java.util.List;
import java.util.Queue;



public class EsperaTriage {

   
    // Cola para las consultas en espera de triage
    private Queue<Consulta> enEsperaT;

    private List<Consulta> EnEsperaPersis;

    public EsperaTriage(Queue<Consulta> fila) {
        this.enEsperaT = fila;
    }

    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }

    public void AñadirALaFila(Consulta consu) {
        enEsperaT.add(consu);
    }

    public Consulta QuitarDeFila(Triage t) {
        Consulta consu = this.enEsperaT.poll();
        consu.setTriage(t);
        return consu;
    }

    void quitarDeLista(Consulta consu) {
//        this.enEsperaT.remove(consu);
    }

}
