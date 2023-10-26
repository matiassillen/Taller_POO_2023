/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.DiagnosticoClinico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Paciente;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class DiagnosticoClinicoJpaController implements Serializable {

    public DiagnosticoClinicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public DiagnosticoClinicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DiagnosticoClinico diagnosticoClinico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = diagnosticoClinico.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                diagnosticoClinico.setPaciente(paciente);
            }
            em.persist(diagnosticoClinico);
            if (paciente != null) {
                paciente.getDiagnosticoClinico().add(diagnosticoClinico);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DiagnosticoClinico diagnosticoClinico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiagnosticoClinico persistentDiagnosticoClinico = em.find(DiagnosticoClinico.class, diagnosticoClinico.getId());
            Paciente pacienteOld = persistentDiagnosticoClinico.getPaciente();
            Paciente pacienteNew = diagnosticoClinico.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                diagnosticoClinico.setPaciente(pacienteNew);
            }
            diagnosticoClinico = em.merge(diagnosticoClinico);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getDiagnosticoClinico().remove(diagnosticoClinico);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getDiagnosticoClinico().add(diagnosticoClinico);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = diagnosticoClinico.getId();
                if (findDiagnosticoClinico(id) == null) {
                    throw new NonexistentEntityException("The diagnosticoClinico with id " + id + " no longer exists.");
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
            DiagnosticoClinico diagnosticoClinico;
            try {
                diagnosticoClinico = em.getReference(DiagnosticoClinico.class, id);
                diagnosticoClinico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diagnosticoClinico with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = diagnosticoClinico.getPaciente();
            if (paciente != null) {
                paciente.getDiagnosticoClinico().remove(diagnosticoClinico);
                paciente = em.merge(paciente);
            }
            em.remove(diagnosticoClinico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DiagnosticoClinico> findDiagnosticoClinicoEntities() {
        return findDiagnosticoClinicoEntities(true, -1, -1);
    }

    public List<DiagnosticoClinico> findDiagnosticoClinicoEntities(int maxResults, int firstResult) {
        return findDiagnosticoClinicoEntities(false, maxResults, firstResult);
    }

    private List<DiagnosticoClinico> findDiagnosticoClinicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DiagnosticoClinico.class));
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

    public DiagnosticoClinico findDiagnosticoClinico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DiagnosticoClinico.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiagnosticoClinicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DiagnosticoClinico> rt = cq.from(DiagnosticoClinico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
