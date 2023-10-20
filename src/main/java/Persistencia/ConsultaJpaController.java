/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Consulta;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
<<<<<<< HEAD
=======
import Model.Paciente;
import Model.Medico;
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
import Model.Triage;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author trapo
 */
public class ConsultaJpaController implements Serializable {

    public ConsultaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ConsultaJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consulta consulta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
<<<<<<< HEAD
=======
            Paciente paciente = consulta.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdP());
                consulta.setPaciente(paciente);
            }
            Medico medico = consulta.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                consulta.setMedico(medico);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
            Triage triage = consulta.getTriage();
            if (triage != null) {
                triage = em.getReference(triage.getClass(), triage.getNumTriage());
                consulta.setTriage(triage);
            }
            em.persist(consulta);
<<<<<<< HEAD
=======
            if (paciente != null) {
                paciente.getConsulta().add(consulta);
                paciente = em.merge(paciente);
            }
            if (medico != null) {
                medico.getConsulta().add(consulta);
                medico = em.merge(medico);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
            if (triage != null) {
                Consulta oldConsultaOfTriage = triage.getConsulta();
                if (oldConsultaOfTriage != null) {
                    oldConsultaOfTriage.setTriage(null);
                    oldConsultaOfTriage = em.merge(oldConsultaOfTriage);
                }
                triage.setConsulta(consulta);
                triage = em.merge(triage);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consulta consulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta persistentConsulta = em.find(Consulta.class, consulta.getNumConsulta());
<<<<<<< HEAD
            Triage triageOld = persistentConsulta.getTriage();
            Triage triageNew = consulta.getTriage();
=======
            Paciente pacienteOld = persistentConsulta.getPaciente();
            Paciente pacienteNew = consulta.getPaciente();
            Medico medicoOld = persistentConsulta.getMedico();
            Medico medicoNew = consulta.getMedico();
            Triage triageOld = persistentConsulta.getTriage();
            Triage triageNew = consulta.getTriage();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdP());
                consulta.setPaciente(pacienteNew);
            }
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                consulta.setMedico(medicoNew);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
            if (triageNew != null) {
                triageNew = em.getReference(triageNew.getClass(), triageNew.getNumTriage());
                consulta.setTriage(triageNew);
            }
            consulta = em.merge(consulta);
<<<<<<< HEAD
=======
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getConsulta().remove(consulta);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getConsulta().add(consulta);
                pacienteNew = em.merge(pacienteNew);
            }
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                medicoOld.getConsulta().remove(consulta);
                medicoOld = em.merge(medicoOld);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                medicoNew.getConsulta().add(consulta);
                medicoNew = em.merge(medicoNew);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
            if (triageOld != null && !triageOld.equals(triageNew)) {
                triageOld.setConsulta(null);
                triageOld = em.merge(triageOld);
            }
            if (triageNew != null && !triageNew.equals(triageOld)) {
                Consulta oldConsultaOfTriage = triageNew.getConsulta();
                if (oldConsultaOfTriage != null) {
                    oldConsultaOfTriage.setTriage(null);
                    oldConsultaOfTriage = em.merge(oldConsultaOfTriage);
                }
                triageNew.setConsulta(consulta);
                triageNew = em.merge(triageNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = consulta.getNumConsulta();
                if (findConsulta(id) == null) {
                    throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta consulta;
            try {
                consulta = em.getReference(Consulta.class, id);
                consulta.getNumConsulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
<<<<<<< HEAD
=======
            Paciente paciente = consulta.getPaciente();
            if (paciente != null) {
                paciente.getConsulta().remove(consulta);
                paciente = em.merge(paciente);
            }
            Medico medico = consulta.getMedico();
            if (medico != null) {
                medico.getConsulta().remove(consulta);
                medico = em.merge(medico);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
            Triage triage = consulta.getTriage();
            if (triage != null) {
                triage.setConsulta(null);
                triage = em.merge(triage);
            }
            em.remove(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulta> findConsultaEntities() {
        return findConsultaEntities(true, -1, -1);
    }

    public List<Consulta> findConsultaEntities(int maxResults, int firstResult) {
        return findConsultaEntities(false, maxResults, firstResult);
    }

    private List<Consulta> findConsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulta.class));
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

    public Consulta findConsulta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulta> rt = cq.from(Consulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
