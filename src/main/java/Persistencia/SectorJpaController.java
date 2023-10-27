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
import Model.FuncAdministrativo;
import Model.Sector;
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
public class SectorJpaController implements Serializable {

    public SectorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SectorJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sector sector) {
        if (sector.getFuncAdministrativo() == null) {
            sector.setFuncAdministrativo(new ArrayList<FuncAdministrativo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<FuncAdministrativo> attachedFuncAdministrativo = new ArrayList<FuncAdministrativo>();
            for (FuncAdministrativo funcAdministrativoFuncAdministrativoToAttach : sector.getFuncAdministrativo()) {
                funcAdministrativoFuncAdministrativoToAttach = em.getReference(funcAdministrativoFuncAdministrativoToAttach.getClass(), funcAdministrativoFuncAdministrativoToAttach.getId());
                attachedFuncAdministrativo.add(funcAdministrativoFuncAdministrativoToAttach);
            }
            sector.setFuncAdministrativo(attachedFuncAdministrativo);
            em.persist(sector);
            for (FuncAdministrativo funcAdministrativoFuncAdministrativo : sector.getFuncAdministrativo()) {
                Sector oldSectorOfFuncAdministrativoFuncAdministrativo = funcAdministrativoFuncAdministrativo.getSector();
                funcAdministrativoFuncAdministrativo.setSector(sector);
                funcAdministrativoFuncAdministrativo = em.merge(funcAdministrativoFuncAdministrativo);
                if (oldSectorOfFuncAdministrativoFuncAdministrativo != null) {
                    oldSectorOfFuncAdministrativoFuncAdministrativo.getFuncAdministrativo().remove(funcAdministrativoFuncAdministrativo);
                    oldSectorOfFuncAdministrativoFuncAdministrativo = em.merge(oldSectorOfFuncAdministrativoFuncAdministrativo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sector sector) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector persistentSector = em.find(Sector.class, sector.getIdSector());
            List<FuncAdministrativo> funcAdministrativoOld = persistentSector.getFuncAdministrativo();
            List<FuncAdministrativo> funcAdministrativoNew = sector.getFuncAdministrativo();
            List<FuncAdministrativo> attachedFuncAdministrativoNew = new ArrayList<FuncAdministrativo>();
            for (FuncAdministrativo funcAdministrativoNewFuncAdministrativoToAttach : funcAdministrativoNew) {
                funcAdministrativoNewFuncAdministrativoToAttach = em.getReference(funcAdministrativoNewFuncAdministrativoToAttach.getClass(), funcAdministrativoNewFuncAdministrativoToAttach.getId());
                attachedFuncAdministrativoNew.add(funcAdministrativoNewFuncAdministrativoToAttach);
            }
            funcAdministrativoNew = attachedFuncAdministrativoNew;
            sector.setFuncAdministrativo(funcAdministrativoNew);
            sector = em.merge(sector);
            for (FuncAdministrativo funcAdministrativoOldFuncAdministrativo : funcAdministrativoOld) {
                if (!funcAdministrativoNew.contains(funcAdministrativoOldFuncAdministrativo)) {
                    funcAdministrativoOldFuncAdministrativo.setSector(null);
                    funcAdministrativoOldFuncAdministrativo = em.merge(funcAdministrativoOldFuncAdministrativo);
                }
            }
            for (FuncAdministrativo funcAdministrativoNewFuncAdministrativo : funcAdministrativoNew) {
                if (!funcAdministrativoOld.contains(funcAdministrativoNewFuncAdministrativo)) {
                    Sector oldSectorOfFuncAdministrativoNewFuncAdministrativo = funcAdministrativoNewFuncAdministrativo.getSector();
                    funcAdministrativoNewFuncAdministrativo.setSector(sector);
                    funcAdministrativoNewFuncAdministrativo = em.merge(funcAdministrativoNewFuncAdministrativo);
                    if (oldSectorOfFuncAdministrativoNewFuncAdministrativo != null && !oldSectorOfFuncAdministrativoNewFuncAdministrativo.equals(sector)) {
                        oldSectorOfFuncAdministrativoNewFuncAdministrativo.getFuncAdministrativo().remove(funcAdministrativoNewFuncAdministrativo);
                        oldSectorOfFuncAdministrativoNewFuncAdministrativo = em.merge(oldSectorOfFuncAdministrativoNewFuncAdministrativo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = sector.getIdSector();
                if (findSector(id) == null) {
                    throw new NonexistentEntityException("The sector with id " + id + " no longer exists.");
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
            Sector sector;
            try {
                sector = em.getReference(Sector.class, id);
                sector.getIdSector();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sector with id " + id + " no longer exists.", enfe);
            }
            List<FuncAdministrativo> funcAdministrativo = sector.getFuncAdministrativo();
            for (FuncAdministrativo funcAdministrativoFuncAdministrativo : funcAdministrativo) {
                funcAdministrativoFuncAdministrativo.setSector(null);
                funcAdministrativoFuncAdministrativo = em.merge(funcAdministrativoFuncAdministrativo);
            }
            em.remove(sector);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sector> findSectorEntities() {
        return findSectorEntities(true, -1, -1);
    }

    public List<Sector> findSectorEntities(int maxResults, int firstResult) {
        return findSectorEntities(false, maxResults, firstResult);
    }

    private List<Sector> findSectorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sector.class));
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

    public Sector findSector(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sector.class, id);
        } finally {
            em.close();
        }
    }

    public int getSectorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sector> rt = cq.from(Sector.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
