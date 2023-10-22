/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.FuncAdministrativo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Sector;
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncAdministrativoJpaController implements Serializable {

    public FuncAdministrativoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public FuncAdministrativoJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncAdministrativo funcAdministrativo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector sector = funcAdministrativo.getSector();
            if (sector != null) {
                sector = em.getReference(sector.getClass(), sector.getIdSector());
                funcAdministrativo.setSector(sector);
            }
            Usuario usu = funcAdministrativo.getUsu();
            if (usu != null) {
                usu = em.getReference(usu.getClass(), usu.getId());
                funcAdministrativo.setUsu(usu);
            }
            em.persist(funcAdministrativo);
            if (sector != null) {
                sector.getFuncAdministrativo().add(funcAdministrativo);
                sector = em.merge(sector);
            }
            if (usu != null) {
                Model.FuncionarioGeneral oldFuncionarioGeneralOfUsu = usu.getFuncionarioGeneral();
                if (oldFuncionarioGeneralOfUsu != null) {
                    oldFuncionarioGeneralOfUsu.setUsu(null);
                    oldFuncionarioGeneralOfUsu = em.merge(oldFuncionarioGeneralOfUsu);
                }
                usu.setFuncionarioGeneral(funcAdministrativo);
                usu = em.merge(usu);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncAdministrativo funcAdministrativo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncAdministrativo persistentFuncAdministrativo = em.find(FuncAdministrativo.class, funcAdministrativo.getId());
            Sector sectorOld = persistentFuncAdministrativo.getSector();
            Sector sectorNew = funcAdministrativo.getSector();
            Usuario usuOld = persistentFuncAdministrativo.getUsu();
            Usuario usuNew = funcAdministrativo.getUsu();
            if (sectorNew != null) {
                sectorNew = em.getReference(sectorNew.getClass(), sectorNew.getIdSector());
                funcAdministrativo.setSector(sectorNew);
            }
            if (usuNew != null) {
                usuNew = em.getReference(usuNew.getClass(), usuNew.getId());
                funcAdministrativo.setUsu(usuNew);
            }
            funcAdministrativo = em.merge(funcAdministrativo);
            if (sectorOld != null && !sectorOld.equals(sectorNew)) {
                sectorOld.getFuncAdministrativo().remove(funcAdministrativo);
                sectorOld = em.merge(sectorOld);
            }
            if (sectorNew != null && !sectorNew.equals(sectorOld)) {
                sectorNew.getFuncAdministrativo().add(funcAdministrativo);
                sectorNew = em.merge(sectorNew);
            }
            if (usuOld != null && !usuOld.equals(usuNew)) {
                usuOld.setFuncionarioGeneral(null);
                usuOld = em.merge(usuOld);
            }
            if (usuNew != null && !usuNew.equals(usuOld)) {
                Model.FuncionarioGeneral oldFuncionarioGeneralOfUsu = usuNew.getFuncionarioGeneral();
                if (oldFuncionarioGeneralOfUsu != null) {
                    oldFuncionarioGeneralOfUsu.setUsu(null);
                    oldFuncionarioGeneralOfUsu = em.merge(oldFuncionarioGeneralOfUsu);
                }
                usuNew.setFuncionarioGeneral(funcAdministrativo);
                usuNew = em.merge(usuNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = funcAdministrativo.getId();
                if (findFuncAdministrativo(id) == null) {
                    throw new NonexistentEntityException("The funcAdministrativo with id " + id + " no longer exists.");
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
            FuncAdministrativo funcAdministrativo;
            try {
                funcAdministrativo = em.getReference(FuncAdministrativo.class, id);
                funcAdministrativo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcAdministrativo with id " + id + " no longer exists.", enfe);
            }
            Sector sector = funcAdministrativo.getSector();
            if (sector != null) {
                sector.getFuncAdministrativo().remove(funcAdministrativo);
                sector = em.merge(sector);
            }
            Usuario usu = funcAdministrativo.getUsu();
            if (usu != null) {
                usu.setFuncionarioGeneral(null);
                usu = em.merge(usu);
            }
            em.remove(funcAdministrativo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncAdministrativo> findFuncAdministrativoEntities() {
        return findFuncAdministrativoEntities(true, -1, -1);
    }

    public List<FuncAdministrativo> findFuncAdministrativoEntities(int maxResults, int firstResult) {
        return findFuncAdministrativoEntities(false, maxResults, firstResult);
    }

    private List<FuncAdministrativo> findFuncAdministrativoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncAdministrativo.class));
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

    public FuncAdministrativo findFuncAdministrativo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncAdministrativo.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncAdministrativoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncAdministrativo> rt = cq.from(FuncAdministrativo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
