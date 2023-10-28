package Model;

import java.util.Queue;



public class EsperaTriage {
    // Cola para las consultas en espera de triage
    private Queue<Consulta> enEsperaT;

    public EsperaTriage(Queue<Consulta> fila) {
        this.enEsperaT = fila;
    }

    /**
     *
     * @return
     */
    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }

    /**
     *
     * @param consu
     */
    public void AñadirALaFila(Consulta consu) {
        enEsperaT.add(consu);
    }

    /**
     *
     * @param t
     * @return
     */
    public Consulta QuitarDeFila(Triage t) {
        Consulta consu = this.enEsperaT.poll();
        consu.setTriage(t);
        return consu;
    }

    /**
     *
     * @param consu
     */
    public void quitarDeLista(Consulta consu) {
//        this.enEsperaT.remove(consu);
    }

}
