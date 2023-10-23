package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author yairc
 */
public class EsperaAtencion {
    
    private PriorityQueue<Consulta> enEspera = new PriorityQueue<>(new ComparadorDeConsultas());
    
    public List<Object> moverPaciente(Box box, Medico medico) {
        List<Object> objetos = new ArrayList<>();
        Consulta consu = enEspera.poll();
        Paciente paciente = consu.getPaciente();
    
        consu.setBox(box);
        consu.setMedico(medico);
        objetos.add(consu);
        control.controlPersis.consultaJpa.edit(consu);
        
        box.setMedico(medico);
        box.setPacienteActual(paciente);
        objetos.add(box);
        control.controlPersis.boxJpa.edit(box);
        
        medico.getConsulta().add(consu);
        objetos.add(medico);
        control.controlPersis.medicoJpa.edit(medico);
        
        return objetos;      
    }

    public PriorityQueue<Consulta> getEnEspera() {
        return enEspera;
    }
    
    public void AñadirConsulta(Consulta consu){
        enEspera.add(consu);
    }
    public class ComparadorDeConsultas implements Comparator<Consulta> {
        @Override
        public int compare(Consulta c1, Consulta c2) {
            if(c1.getTriage().getColorFinal()!=null){
                if(c2.getTriage().getColorFinal()!=null){
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                }
                else{
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());
                            
                }
            }else{
                if(c2.getTriage().getColorFinal()!=null){
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                }
                else{
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());
                }
            }
        }
    
    }

}
