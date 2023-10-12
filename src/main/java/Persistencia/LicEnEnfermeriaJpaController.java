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
import Model.Triage;
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
    
    public LicEnEnfermeriaJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LicEnEnfermeria licEnEnfermeria) {
        if (licEnEnfermeria.getTriage() == null) {
            licEnEnfermeria.setTriage(new ArrayList<Triage>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol = licEnEnfermeria.getRol();
            if (rol != null) {
                rol = em.getReference(rol.getClass(), rol.getId_rol());
                licEnEnfermeria.setRol(rol);
            }
            ArrayList<Triage> attachedTriage = new ArrayList<Triage>();
            for (Triage triageTriageToAttach : licEnEnfermeria.getTriage()) {
                triageTriageToAttach = em.getReference(triageTriageToAttach.getClass(), triageTriageToAttach.getNumTriage());
                attachedTriage.add(triageTriageToAttach);
            }
            licEnEnfermeria.setTriage(attachedTriage);
            em.persist(licEnEnfermeria);
            if (rol != null) {
                rol.getFuncionarioGeneral().add(licEnEnfermeria);
                rol = em.merge(rol);
            }
            for (Triage triageTriage : licEnEnfermeria.getTriage()) {
                LicEnEnfermeria oldEnfermeroOfTriageTriage = triageTriage.getEnfermero();
                triageTriage.setEnfermero(licEnEnfermeria);
                triageTriage = em.merge(triageTriage);
                if (oldEnfermeroOfTriageTriage != null) {
                    oldEnfermeroOfTriageTriage.getTriage().remove(triageTriage);
                    oldEnfermeroOfTriageTriage = em.merge(oldEnfermeroOfTriageTriage);
                }
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
            Rol rolOld = persistentLicEnEnfermeria.getRol();
            Rol rolNew = licEnEnfermeria.getRol();
            ArrayList<Triage> triageOld = persistentLicEnEnfermeria.getTriage();
            ArrayList<Triage> triageNew = licEnEnfermeria.getTriage();
            if (rolNew != null) {
                rolNew = em.getReference(rolNew.getClass(), rolNew.getId_rol());
                licEnEnfermeria.setRol(rolNew);
            }
            ArrayList<Triage> attachedTriageNew = new ArrayList<Triage>();
            for (Triage triageNewTriageToAttach : triageNew) {
                triageNewTriageToAttach = em.getReference(triageNewTriageToAttach.getClass(), triageNewTriageToAttach.getNumTriage());
                attachedTriageNew.add(triageNewTriageToAttach);
            }
            triageNew = attachedTriageNew;
            licEnEnfermeria.setTriage(triageNew);
            licEnEnfermeria = em.merge(licEnEnfermeria);
            if (rolOld != null && !rolOld.equals(rolNew)) {
                rolOld.getFuncionarioGeneral().remove(licEnEnfermeria);
                rolOld = em.merge(rolOld);
            }
            if (rolNew != null && !rolNew.equals(rolOld)) {
                rolNew.getFuncionarioGeneral().add(licEnEnfermeria);
                rolNew = em.merge(rolNew);
            }
            for (Triage triageOldTriage : triageOld) {
                if (!triageNew.contains(triageOldTriage)) {
                    triageOldTriage.setEnfermero(null);
                    triageOldTriage = em.merge(triageOldTriage);
                }
            }
            for (Triage triageNewTriage : triageNew) {
                if (!triageOld.contains(triageNewTriage)) {
                    LicEnEnfermeria oldEnfermeroOfTriageNewTriage = triageNewTriage.getEnfermero();
                    triageNewTriage.setEnfermero(licEnEnfermeria);
                    triageNewTriage = em.merge(triageNewTriage);
                    if (oldEnfermeroOfTriageNewTriage != null && !oldEnfermeroOfTriageNewTriage.equals(licEnEnfermeria)) {
                        oldEnfermeroOfTriageNewTriage.getTriage().remove(triageNewTriage);
                        oldEnfermeroOfTriageNewTriage = em.merge(oldEnfermeroOfTriageNewTriage);
                    }
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
            Rol rol = licEnEnfermeria.getRol();
            if (rol != null) {
                rol.getFuncionarioGeneral().remove(licEnEnfermeria);
                rol = em.merge(rol);
            }
            ArrayList<Triage> triage = licEnEnfermeria.getTriage();
            for (Triage triageTriage : triage) {
                triageTriage.setEnfermero(null);
                triageTriage = em.merge(triageTriage);
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
