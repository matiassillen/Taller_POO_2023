/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.LicEnEnfermeria;
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
public class LicEnEnfermeriaJpaController implements Serializable {

    public LicEnEnfermeriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public LicEnEnfermeriaJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LicEnEnfermeria licEnEnfermeria) {
        if (licEnEnfermeria.getRol() == null) {
            licEnEnfermeria.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : licEnEnfermeria.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            licEnEnfermeria.setRol(attachedRol);
            em.persist(licEnEnfermeria);
            for (Rol rolRol : licEnEnfermeria.getRol()) {
                rolRol.getFuncionarioGeneral().add(licEnEnfermeria);
                rolRol = em.merge(rolRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LicEnEnfermeria licEnEnfermeria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LicEnEnfermeria persistentLicEnEnfermeria = em.find(LicEnEnfermeria.class, licEnEnfermeria.getId());
            ArrayList<Rol> rolOld = persistentLicEnEnfermeria.getRol();
            ArrayList<Rol> rolNew = licEnEnfermeria.getRol();
            ArrayList<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            licEnEnfermeria.setRol(rolNew);
            licEnEnfermeria = em.merge(licEnEnfermeria);
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getFuncionarioGeneral().remove(licEnEnfermeria);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getFuncionarioGeneral().add(licEnEnfermeria);
                    rolNewRol = em.merge(rolNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = licEnEnfermeria.getId();
                if (findLicEnEnfermeria(id) == null) {
                    throw new NonexistentEntityException("The licEnEnfermeria with id " + id + " no longer exists.");
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
            LicEnEnfermeria licEnEnfermeria;
            try {
                licEnEnfermeria = em.getReference(LicEnEnfermeria.class, id);
                licEnEnfermeria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The licEnEnfermeria with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Rol> rol = licEnEnfermeria.getRol();
            for (Rol rolRol : rol) {
                rolRol.getFuncionarioGeneral().remove(licEnEnfermeria);
                rolRol = em.merge(rolRol);
            }
            em.remove(licEnEnfermeria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LicEnEnfermeria> findLicEnEnfermeriaEntities() {
        return findLicEnEnfermeriaEntities(true, -1, -1);
    }

    public List<LicEnEnfermeria> findLicEnEnfermeriaEntities(int maxResults, int firstResult) {
        return findLicEnEnfermeriaEntities(false, maxResults, firstResult);
    }

    private List<LicEnEnfermeria> findLicEnEnfermeriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LicEnEnfermeria.class));
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

    public LicEnEnfermeria findLicEnEnfermeria(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LicEnEnfermeria.class, id);
        } finally {
            em.close();
        }
    }

    public int getLicEnEnfermeriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LicEnEnfermeria> rt = cq.from(LicEnEnfermeria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
