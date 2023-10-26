/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Box;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Consulta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class BoxJpaController implements Serializable {

    public BoxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    public BoxJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Box box) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta consulta = box.getConsulta();
            if (consulta != null) {
                consulta = em.getReference(consulta.getClass(), consulta.getId());
                box.setConsulta(consulta);
            }
            em.persist(box);
            if (consulta != null) {
                Box oldBoxOfConsulta = consulta.getBox();
                if (oldBoxOfConsulta != null) {
                    oldBoxOfConsulta.setConsulta(null);
                    oldBoxOfConsulta = em.merge(oldBoxOfConsulta);
                }
                consulta.setBox(box);
                consulta = em.merge(consulta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Box box) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Box persistentBox = em.find(Box.class, box.getId());
            Consulta consultaOld = persistentBox.getConsulta();
            Consulta consultaNew = box.getConsulta();
            if (consultaNew != null) {
                consultaNew = em.getReference(consultaNew.getClass(), consultaNew.getId());
                box.setConsulta(consultaNew);
            }
            box = em.merge(box);
            if (consultaOld != null && !consultaOld.equals(consultaNew)) {
                consultaOld.setBox(null);
                consultaOld = em.merge(consultaOld);
            }
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                Box oldBoxOfConsulta = consultaNew.getBox();
                if (oldBoxOfConsulta != null) {
                    oldBoxOfConsulta.setConsulta(null);
                    oldBoxOfConsulta = em.merge(oldBoxOfConsulta);
                }
                consultaNew.setBox(box);
                consultaNew = em.merge(consultaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = box.getId();
                if (findBox(id) == null) {
                    throw new NonexistentEntityException("The box with id " + id + " no longer exists.");
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
            Box box;
            try {
                box = em.getReference(Box.class, id);
                box.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The box with id " + id + " no longer exists.", enfe);
            }
            Consulta consulta = box.getConsulta();
            if (consulta != null) {
                consulta.setBox(null);
                consulta = em.merge(consulta);
            }
            em.remove(box);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Box> findBoxEntities() {
        return findBoxEntities(true, -1, -1);
    }

    public List<Box> findBoxEntities(int maxResults, int firstResult) {
        return findBoxEntities(false, maxResults, firstResult);
    }

    private List<Box> findBoxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Box.class));
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

    public Box findBox(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Box.class, id);
        } finally {
            em.close();
        }
    }

    public int getBoxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Box> rt = cq.from(Box.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
