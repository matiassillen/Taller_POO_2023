/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.GestoresHospital;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Rol;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matías Sillen Ríos
 */
public class GestoresHospitalJpaController implements Serializable {

    public GestoresHospitalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public GestoresHospitalJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GestoresHospital gestoresHospital) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol = gestoresHospital.getRol();
            if (rol != null) {
                rol = em.getReference(rol.getClass(), rol.getId_rol());
                gestoresHospital.setRol(rol);
            }
            em.persist(gestoresHospital);
            if (rol != null) {
                rol.getFuncionarioGeneral().add(gestoresHospital);
                rol = em.merge(rol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GestoresHospital gestoresHospital) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GestoresHospital persistentGestoresHospital = em.find(GestoresHospital.class, gestoresHospital.getId());
            Rol rolOld = persistentGestoresHospital.getRol();
            Rol rolNew = gestoresHospital.getRol();
            if (rolNew != null) {
                rolNew = em.getReference(rolNew.getClass(), rolNew.getId_rol());
                gestoresHospital.setRol(rolNew);
            }
            gestoresHospital = em.merge(gestoresHospital);
            if (rolOld != null && !rolOld.equals(rolNew)) {
                rolOld.getFuncionarioGeneral().remove(gestoresHospital);
                rolOld = em.merge(rolOld);
            }
            if (rolNew != null && !rolNew.equals(rolOld)) {
                rolNew.getFuncionarioGeneral().add(gestoresHospital);
                rolNew = em.merge(rolNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = gestoresHospital.getId();
                if (findGestoresHospital(id) == null) {
                    throw new NonexistentEntityException("The gestoresHospital with id " + id + " no longer exists.");
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
            GestoresHospital gestoresHospital;
            try {
                gestoresHospital = em.getReference(GestoresHospital.class, id);
                gestoresHospital.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gestoresHospital with id " + id + " no longer exists.", enfe);
            }
            Rol rol = gestoresHospital.getRol();
            if (rol != null) {
                rol.getFuncionarioGeneral().remove(gestoresHospital);
                rol = em.merge(rol);
            }
            em.remove(gestoresHospital);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GestoresHospital> findGestoresHospitalEntities() {
        return findGestoresHospitalEntities(true, -1, -1);
    }

    public List<GestoresHospital> findGestoresHospitalEntities(int maxResults, int firstResult) {
        return findGestoresHospitalEntities(false, maxResults, firstResult);
    }

    private List<GestoresHospital> findGestoresHospitalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GestoresHospital.class));
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

    public GestoresHospital findGestoresHospital(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GestoresHospital.class, id);
        } finally {
            em.close();
        }
    }

    public int getGestoresHospitalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GestoresHospital> rt = cq.from(GestoresHospital.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
