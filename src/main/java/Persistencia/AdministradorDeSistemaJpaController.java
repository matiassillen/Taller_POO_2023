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
import java.util.ArrayList;
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
    
    public AdministradorDeSistemaJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AdministradorDeSistema administradorDeSistema) {
        if (administradorDeSistema.getRol() == null) {
            administradorDeSistema.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : administradorDeSistema.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            administradorDeSistema.setRol(attachedRol);
            em.persist(administradorDeSistema);
            for (Rol rolRol : administradorDeSistema.getRol()) {
                rolRol.getFuncionarioGeneral().add(administradorDeSistema);
                rolRol = em.merge(rolRol);
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
            ArrayList<Rol> rolOld = persistentAdministradorDeSistema.getRol();
            ArrayList<Rol> rolNew = administradorDeSistema.getRol();
            ArrayList<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            administradorDeSistema.setRol(rolNew);
            administradorDeSistema = em.merge(administradorDeSistema);
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getFuncionarioGeneral().remove(administradorDeSistema);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getFuncionarioGeneral().add(administradorDeSistema);
                    rolNewRol = em.merge(rolNewRol);
                }
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
            ArrayList<Rol> rol = administradorDeSistema.getRol();
            for (Rol rolRol : rol) {
                rolRol.getFuncionarioGeneral().remove(administradorDeSistema);
                rolRol = em.merge(rolRol);
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
