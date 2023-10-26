/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.DiagnosticoClinico;
import java.util.ArrayList;
import java.util.List;
import Model.ResultadoEstudio;
import Model.Consulta;
import Model.Paciente;
import Persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matías Sillen Ríos
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PacienteJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getDiagnosticoClinico() == null) {
            paciente.setDiagnosticoClinico(new ArrayList<DiagnosticoClinico>());
        }
        if (paciente.getResultadoEstudio() == null) {
            paciente.setResultadoEstudio(new ArrayList<ResultadoEstudio>());
        }
        if (paciente.getConsultas() == null) {
            paciente.setConsultas(new ArrayList<Consulta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DiagnosticoClinico> attachedDiagnosticoClinico = new ArrayList<DiagnosticoClinico>();
            for (DiagnosticoClinico diagnosticoClinicoDiagnosticoClinicoToAttach : paciente.getDiagnosticoClinico()) {
                diagnosticoClinicoDiagnosticoClinicoToAttach = em.getReference(diagnosticoClinicoDiagnosticoClinicoToAttach.getClass(), diagnosticoClinicoDiagnosticoClinicoToAttach.getId());
                attachedDiagnosticoClinico.add(diagnosticoClinicoDiagnosticoClinicoToAttach);
            }
            paciente.setDiagnosticoClinico(attachedDiagnosticoClinico);
            List<ResultadoEstudio> attachedResultadoEstudio = new ArrayList<ResultadoEstudio>();
            for (ResultadoEstudio resultadoEstudioResultadoEstudioToAttach : paciente.getResultadoEstudio()) {
                resultadoEstudioResultadoEstudioToAttach = em.getReference(resultadoEstudioResultadoEstudioToAttach.getClass(), resultadoEstudioResultadoEstudioToAttach.getId());
                attachedResultadoEstudio.add(resultadoEstudioResultadoEstudioToAttach);
            }
            paciente.setResultadoEstudio(attachedResultadoEstudio);
            List<Consulta> attachedConsultas = new ArrayList<Consulta>();
            for (Consulta consultasConsultaToAttach : paciente.getConsultas()) {
                consultasConsultaToAttach = em.getReference(consultasConsultaToAttach.getClass(), consultasConsultaToAttach.getId());
                attachedConsultas.add(consultasConsultaToAttach);
            }
            paciente.setConsultas(attachedConsultas);
            em.persist(paciente);
            for (DiagnosticoClinico diagnosticoClinicoDiagnosticoClinico : paciente.getDiagnosticoClinico()) {
                Paciente oldPacienteOfDiagnosticoClinicoDiagnosticoClinico = diagnosticoClinicoDiagnosticoClinico.getPaciente();
                diagnosticoClinicoDiagnosticoClinico.setPaciente(paciente);
                diagnosticoClinicoDiagnosticoClinico = em.merge(diagnosticoClinicoDiagnosticoClinico);
                if (oldPacienteOfDiagnosticoClinicoDiagnosticoClinico != null) {
                    oldPacienteOfDiagnosticoClinicoDiagnosticoClinico.getDiagnosticoClinico().remove(diagnosticoClinicoDiagnosticoClinico);
                    oldPacienteOfDiagnosticoClinicoDiagnosticoClinico = em.merge(oldPacienteOfDiagnosticoClinicoDiagnosticoClinico);
                }
            }
            for (ResultadoEstudio resultadoEstudioResultadoEstudio : paciente.getResultadoEstudio()) {
                Paciente oldPacienteOfResultadoEstudioResultadoEstudio = resultadoEstudioResultadoEstudio.getPaciente();
                resultadoEstudioResultadoEstudio.setPaciente(paciente);
                resultadoEstudioResultadoEstudio = em.merge(resultadoEstudioResultadoEstudio);
                if (oldPacienteOfResultadoEstudioResultadoEstudio != null) {
                    oldPacienteOfResultadoEstudioResultadoEstudio.getResultadoEstudio().remove(resultadoEstudioResultadoEstudio);
                    oldPacienteOfResultadoEstudioResultadoEstudio = em.merge(oldPacienteOfResultadoEstudioResultadoEstudio);
                }
            }
            for (Consulta consultasConsulta : paciente.getConsultas()) {
                Paciente oldPacienteOfConsultasConsulta = consultasConsulta.getPaciente();
                consultasConsulta.setPaciente(paciente);
                consultasConsulta = em.merge(consultasConsulta);
                if (oldPacienteOfConsultasConsulta != null) {
                    oldPacienteOfConsultasConsulta.getConsultas().remove(consultasConsulta);
                    oldPacienteOfConsultasConsulta = em.merge(oldPacienteOfConsultasConsulta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getId());
            List<DiagnosticoClinico> diagnosticoClinicoOld = persistentPaciente.getDiagnosticoClinico();
            List<DiagnosticoClinico> diagnosticoClinicoNew = paciente.getDiagnosticoClinico();
            List<ResultadoEstudio> resultadoEstudioOld = persistentPaciente.getResultadoEstudio();
            List<ResultadoEstudio> resultadoEstudioNew = paciente.getResultadoEstudio();
            List<Consulta> consultasOld = persistentPaciente.getConsultas();
            List<Consulta> consultasNew = paciente.getConsultas();
            List<DiagnosticoClinico> attachedDiagnosticoClinicoNew = new ArrayList<DiagnosticoClinico>();
            for (DiagnosticoClinico diagnosticoClinicoNewDiagnosticoClinicoToAttach : diagnosticoClinicoNew) {
                diagnosticoClinicoNewDiagnosticoClinicoToAttach = em.getReference(diagnosticoClinicoNewDiagnosticoClinicoToAttach.getClass(), diagnosticoClinicoNewDiagnosticoClinicoToAttach.getId());
                attachedDiagnosticoClinicoNew.add(diagnosticoClinicoNewDiagnosticoClinicoToAttach);
            }
            diagnosticoClinicoNew = attachedDiagnosticoClinicoNew;
            paciente.setDiagnosticoClinico(diagnosticoClinicoNew);
            List<ResultadoEstudio> attachedResultadoEstudioNew = new ArrayList<ResultadoEstudio>();
            for (ResultadoEstudio resultadoEstudioNewResultadoEstudioToAttach : resultadoEstudioNew) {
                resultadoEstudioNewResultadoEstudioToAttach = em.getReference(resultadoEstudioNewResultadoEstudioToAttach.getClass(), resultadoEstudioNewResultadoEstudioToAttach.getId());
                attachedResultadoEstudioNew.add(resultadoEstudioNewResultadoEstudioToAttach);
            }
            resultadoEstudioNew = attachedResultadoEstudioNew;
            paciente.setResultadoEstudio(resultadoEstudioNew);
            List<Consulta> attachedConsultasNew = new ArrayList<Consulta>();
            for (Consulta consultasNewConsultaToAttach : consultasNew) {
                consultasNewConsultaToAttach = em.getReference(consultasNewConsultaToAttach.getClass(), consultasNewConsultaToAttach.getId());
                attachedConsultasNew.add(consultasNewConsultaToAttach);
            }
            consultasNew = attachedConsultasNew;
            paciente.setConsultas(consultasNew);
            paciente = em.merge(paciente);
            for (DiagnosticoClinico diagnosticoClinicoOldDiagnosticoClinico : diagnosticoClinicoOld) {
                if (!diagnosticoClinicoNew.contains(diagnosticoClinicoOldDiagnosticoClinico)) {
                    diagnosticoClinicoOldDiagnosticoClinico.setPaciente(null);
                    diagnosticoClinicoOldDiagnosticoClinico = em.merge(diagnosticoClinicoOldDiagnosticoClinico);
                }
            }
            for (DiagnosticoClinico diagnosticoClinicoNewDiagnosticoClinico : diagnosticoClinicoNew) {
                if (!diagnosticoClinicoOld.contains(diagnosticoClinicoNewDiagnosticoClinico)) {
                    Paciente oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico = diagnosticoClinicoNewDiagnosticoClinico.getPaciente();
                    diagnosticoClinicoNewDiagnosticoClinico.setPaciente(paciente);
                    diagnosticoClinicoNewDiagnosticoClinico = em.merge(diagnosticoClinicoNewDiagnosticoClinico);
                    if (oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico != null && !oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico.equals(paciente)) {
                        oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico.getDiagnosticoClinico().remove(diagnosticoClinicoNewDiagnosticoClinico);
                        oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico = em.merge(oldPacienteOfDiagnosticoClinicoNewDiagnosticoClinico);
                    }
                }
            }
            for (ResultadoEstudio resultadoEstudioOldResultadoEstudio : resultadoEstudioOld) {
                if (!resultadoEstudioNew.contains(resultadoEstudioOldResultadoEstudio)) {
                    resultadoEstudioOldResultadoEstudio.setPaciente(null);
                    resultadoEstudioOldResultadoEstudio = em.merge(resultadoEstudioOldResultadoEstudio);
                }
            }
            for (ResultadoEstudio resultadoEstudioNewResultadoEstudio : resultadoEstudioNew) {
                if (!resultadoEstudioOld.contains(resultadoEstudioNewResultadoEstudio)) {
                    Paciente oldPacienteOfResultadoEstudioNewResultadoEstudio = resultadoEstudioNewResultadoEstudio.getPaciente();
                    resultadoEstudioNewResultadoEstudio.setPaciente(paciente);
                    resultadoEstudioNewResultadoEstudio = em.merge(resultadoEstudioNewResultadoEstudio);
                    if (oldPacienteOfResultadoEstudioNewResultadoEstudio != null && !oldPacienteOfResultadoEstudioNewResultadoEstudio.equals(paciente)) {
                        oldPacienteOfResultadoEstudioNewResultadoEstudio.getResultadoEstudio().remove(resultadoEstudioNewResultadoEstudio);
                        oldPacienteOfResultadoEstudioNewResultadoEstudio = em.merge(oldPacienteOfResultadoEstudioNewResultadoEstudio);
                    }
                }
            }
            for (Consulta consultasOldConsulta : consultasOld) {
                if (!consultasNew.contains(consultasOldConsulta)) {
                    consultasOldConsulta.setPaciente(null);
                    consultasOldConsulta = em.merge(consultasOldConsulta);
                }
            }
            for (Consulta consultasNewConsulta : consultasNew) {
                if (!consultasOld.contains(consultasNewConsulta)) {
                    Paciente oldPacienteOfConsultasNewConsulta = consultasNewConsulta.getPaciente();
                    consultasNewConsulta.setPaciente(paciente);
                    consultasNewConsulta = em.merge(consultasNewConsulta);
                    if (oldPacienteOfConsultasNewConsulta != null && !oldPacienteOfConsultasNewConsulta.equals(paciente)) {
                        oldPacienteOfConsultasNewConsulta.getConsultas().remove(consultasNewConsulta);
                        oldPacienteOfConsultasNewConsulta = em.merge(oldPacienteOfConsultasNewConsulta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<DiagnosticoClinico> diagnosticoClinico = paciente.getDiagnosticoClinico();
            for (DiagnosticoClinico diagnosticoClinicoDiagnosticoClinico : diagnosticoClinico) {
                diagnosticoClinicoDiagnosticoClinico.setPaciente(null);
                diagnosticoClinicoDiagnosticoClinico = em.merge(diagnosticoClinicoDiagnosticoClinico);
            }
            List<ResultadoEstudio> resultadoEstudio = paciente.getResultadoEstudio();
            for (ResultadoEstudio resultadoEstudioResultadoEstudio : resultadoEstudio) {
                resultadoEstudioResultadoEstudio.setPaciente(null);
                resultadoEstudioResultadoEstudio = em.merge(resultadoEstudioResultadoEstudio);
            }
            List<Consulta> consultas = paciente.getConsultas();
            for (Consulta consultasConsulta : consultas) {
                consultasConsulta.setPaciente(null);
                consultasConsulta = em.merge(consultasConsulta);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
