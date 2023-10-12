/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.AdministradorDeSistema;
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
public class AdministradorDeSistemaJpaController implements Serializable {

    public AdministradorDeSistemaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AdministradorDeSistemaJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AdministradorDeSistema administradorDeSistema) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol = administradorDeSistema.getRol();
            if (rol != null) {
                rol = em.getReference(rol.getClass(), rol.getId_rol());
                administradorDeSistema.setRol(rol);
            }
            em.persist(administradorDeSistema);
            if (rol != null) {
                rol.getFuncionarioGeneral().add(administradorDeSistema);
                rol = em.merge(rol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AdministradorDeSistema administradorDeSistema) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AdministradorDeSistema persistentAdministradorDeSistema = em.find(AdministradorDeSistema.class, administradorDeSistema.getId());
            Rol rolOld = persistentAdministradorDeSistema.getRol();
            Rol rolNew = administradorDeSistema.getRol();
            if (rolNew != null) {
                rolNew = em.getReference(rolNew.getClass(), rolNew.getId_rol());
                administradorDeSistema.setRol(rolNew);
            }
            administradorDeSistema = em.merge(administradorDeSistema);
            if (rolOld != null && !rolOld.equals(rolNew)) {
                rolOld.getFuncionarioGeneral().remove(administradorDeSistema);
                rolOld = em.merge(rolOld);
            }
            if (rolNew != null && !rolNew.equals(rolOld)) {
                rolNew.getFuncionarioGeneral().add(administradorDeSistema);
                rolNew = em.merge(rolNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = administradorDeSistema.getId();
                if (findAdministradorDeSistema(id) == null) {
                    throw new NonexistentEntityException("The administradorDeSistema with id " + id + " no longer exists.");
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
            AdministradorDeSistema administradorDeSistema;
            try {
                administradorDeSistema = em.getReference(AdministradorDeSistema.class, id);
                administradorDeSistema.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administradorDeSistema with id " + id + " no longer exists.", enfe);
            }
            Rol rol = administradorDeSistema.getRol();
            if (rol != null) {
                rol.getFuncionarioGeneral().remove(administradorDeSistema);
                rol = em.merge(rol);
            }
            em.remove(administradorDeSistema);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AdministradorDeSistema> findAdministradorDeSistemaEntities() {
        return findAdministradorDeSistemaEntities(true, -1, -1);
    }

    public List<AdministradorDeSistema> findAdministradorDeSistemaEntities(int maxResults, int firstResult) {
        return findAdministradorDeSistemaEntities(false, maxResults, firstResult);
    }

    private List<AdministradorDeSistema> findAdministradorDeSistemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AdministradorDeSistema.class));
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

    public AdministradorDeSistema findAdministradorDeSistema(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AdministradorDeSistema.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorDeSistemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AdministradorDeSistema> rt = cq.from(AdministradorDeSistema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
