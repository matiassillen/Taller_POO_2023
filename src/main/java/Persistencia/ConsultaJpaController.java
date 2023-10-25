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
import Model.Paciente;
import Model.Box;
import Model.Consulta;
import Model.Medico;
import Model.Triage;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
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
            Paciente paciente = consulta.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                consulta.setPaciente(paciente);
            }
            Box box = consulta.getBox();
            if (box != null) {
                box = em.getReference(box.getClass(), box.getId());
                consulta.setBox(box);
            }
            Medico medico = consulta.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                consulta.setMedico(medico);
            }
            Triage triage = consulta.getTriage();
            if (triage != null) {
                triage = em.getReference(triage.getClass(), triage.getId());
                consulta.setTriage(triage);
            }
            em.persist(consulta);
            if (paciente != null) {
                paciente.getConsultas().add(consulta);
                paciente = em.merge(paciente);
            }
            if (box != null) {
                Consulta oldConsultaOfBox = box.getConsulta();
                if (oldConsultaOfBox != null) {
                    oldConsultaOfBox.setBox(null);
                    oldConsultaOfBox = em.merge(oldConsultaOfBox);
                }
                box.setConsulta(consulta);
                box = em.merge(box);
            }
            if (medico != null) {
                medico.getConsulta().add(consulta);
                medico = em.merge(medico);
            }
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
            Consulta persistentConsulta = em.find(Consulta.class, consulta.getId());
            Paciente pacienteOld = persistentConsulta.getPaciente();
            Paciente pacienteNew = consulta.getPaciente();
            Box boxOld = persistentConsulta.getBox();
            Box boxNew = consulta.getBox();
            Medico medicoOld = persistentConsulta.getMedico();
            Medico medicoNew = consulta.getMedico();
            Triage triageOld = persistentConsulta.getTriage();
            Triage triageNew = consulta.getTriage();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                consulta.setPaciente(pacienteNew);
            }
            if (boxNew != null) {
                boxNew = em.getReference(boxNew.getClass(), boxNew.getId());
                consulta.setBox(boxNew);
            }
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                consulta.setMedico(medicoNew);
            }
            if (triageNew != null) {
                triageNew = em.getReference(triageNew.getClass(), triageNew.getId());
                consulta.setTriage(triageNew);
            }
            consulta = em.merge(consulta);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getConsultas().remove(consulta);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getConsultas().add(consulta);
                pacienteNew = em.merge(pacienteNew);
            }
            if (boxOld != null && !boxOld.equals(boxNew)) {
                boxOld.setConsulta(null);
                boxOld = em.merge(boxOld);
            }
            if (boxNew != null && !boxNew.equals(boxOld)) {
                Consulta oldConsultaOfBox = boxNew.getConsulta();
                if (oldConsultaOfBox != null) {
                    oldConsultaOfBox.setBox(null);
                    oldConsultaOfBox = em.merge(oldConsultaOfBox);
                }
                boxNew.setConsulta(consulta);
                boxNew = em.merge(boxNew);
            }
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                medicoOld.getConsulta().remove(consulta);
                medicoOld = em.merge(medicoOld);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                medicoNew.getConsulta().add(consulta);
                medicoNew = em.merge(medicoNew);
            }
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
                int id = consulta.getId();
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
                consulta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = consulta.getPaciente();
            if (paciente != null) {
                paciente.getConsultas().remove(consulta);
                paciente = em.merge(paciente);
            }
            Box box = consulta.getBox();
            if (box != null) {
                box.setConsulta(null);
                box = em.merge(box);
            }
            Medico medico = consulta.getMedico();
            if (medico != null) {
                medico.getConsulta().remove(consulta);
                medico = em.merge(medico);
            }
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
