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

    /**
     * Constructor de la clase SectorJpaController con un EntityManagerFactory
     * proporcionado.
     *
     * @param emf El EntityManagerFactory utilizado para interactuar con la base
     * de datos.
     */
    public SectorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase SectorJpaController que crea un
     * EntityManagerFactory interno.
     */
    public SectorJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene un EntityManager para interactuar con la base de datos.
     *
     * @return Un EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo sector en la base de datos.
     *
     * @param sector El sector que se va a crear.
     */
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

    /**
     * Edita un sector existente en la base de datos.
     *
     * @param sector El sector que se va a editar.
     * @throws NonexistentEntityException Si el sector no existe en la base de
     * datos.
     * @throws Exception Si se produce un error durante la edición.
     */
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

    /**
     * Elimina un sector de la base de datos por su ID.
     *
     * @param id El ID del sector que se va a eliminar.
     * @throws NonexistentEntityException Si el sector no existe en la base de
     * datos.
     */
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

    /**
     * Obtiene una lista de sectores desde la base de datos.
     *
     * @return Una lista de sectores.
     */
    public List<Sector> findSectorEntities() {
        return findSectorEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de sectores desde la base de datos.
     *
     * @param maxResults
     * @param firstResult
     * @return Una lista de sectores.
     */
    public List<Sector> findSectorEntities(int maxResults, int firstResult) {
        return findSectorEntities(false, maxResults, firstResult);
    }

    /**
     * Obtiene una lista de sectores con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de sectores con opciones de paginación.
     */
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

    /**
     * Busca y devuelve un sector por su ID en la base de datos.
     *
     * @param id El ID del sector que se desea buscar.
     * @return El sector con el ID especificado.
     */
    public Sector findSector(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sector.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de sectores en la base de datos.
     *
     * @return El número total de sectores.
     */
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
