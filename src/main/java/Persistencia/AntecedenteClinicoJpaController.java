/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.AntecedenteClinico;
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
 * @author Matías Sillen Ríos
 */
public class AntecedenteClinicoJpaController implements Serializable {

    public AntecedenteClinicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AntecedenteClinicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AntecedenteClinico antecedenteClinico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = antecedenteClinico.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                antecedenteClinico.setPaciente(paciente);
            }
            em.persist(antecedenteClinico);
            if (paciente != null) {
                paciente.getAntecedenteClinico().add(antecedenteClinico);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AntecedenteClinico antecedenteClinico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AntecedenteClinico persistentAntecedenteClinico = em.find(AntecedenteClinico.class, antecedenteClinico.getNumAntecedente());
            Paciente pacienteOld = persistentAntecedenteClinico.getPaciente();
            Paciente pacienteNew = antecedenteClinico.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                antecedenteClinico.setPaciente(pacienteNew);
            }
            antecedenteClinico = em.merge(antecedenteClinico);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getAntecedenteClinico().remove(antecedenteClinico);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getAntecedenteClinico().add(antecedenteClinico);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = antecedenteClinico.getNumAntecedente();
                if (findAntecedenteClinico(id) == null) {
                    throw new NonexistentEntityException("The antecedenteClinico with id " + id + " no longer exists.");
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
            AntecedenteClinico antecedenteClinico;
            try {
                antecedenteClinico = em.getReference(AntecedenteClinico.class, id);
                antecedenteClinico.getNumAntecedente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The antecedenteClinico with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = antecedenteClinico.getPaciente();
            if (paciente != null) {
                paciente.getAntecedenteClinico().remove(antecedenteClinico);
                paciente = em.merge(paciente);
            }
            em.remove(antecedenteClinico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AntecedenteClinico> findAntecedenteClinicoEntities() {
        return findAntecedenteClinicoEntities(true, -1, -1);
    }

    public List<AntecedenteClinico> findAntecedenteClinicoEntities(int maxResults, int firstResult) {
        return findAntecedenteClinicoEntities(false, maxResults, firstResult);
    }

    private List<AntecedenteClinico> findAntecedenteClinicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AntecedenteClinico.class));
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

    public AntecedenteClinico findAntecedenteClinico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AntecedenteClinico.class, id);
        } finally {
            em.close();
        }
    }

    public int getAntecedenteClinicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AntecedenteClinico> rt = cq.from(AntecedenteClinico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
