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
import Model.Especialidad;
import Model.Medico;
import java.util.ArrayList;
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
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public MedicoJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) {
        if (medico.getEspecialidad() == null) {
            medico.setEspecialidad(new ArrayList<Especialidad>());
        }
        if (medico.getRol() == null) {
            medico.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Especialidad> attachedEspecialidad = new ArrayList<Especialidad>();
            for (Especialidad especialidadEspecialidadToAttach : medico.getEspecialidad()) {
                especialidadEspecialidadToAttach = em.getReference(especialidadEspecialidadToAttach.getClass(), especialidadEspecialidadToAttach.getId());
                attachedEspecialidad.add(especialidadEspecialidadToAttach);
            }
            medico.setEspecialidad(attachedEspecialidad);
            ArrayList<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : medico.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            medico.setRol(attachedRol);
            em.persist(medico);
            for (Especialidad especialidadEspecialidad : medico.getEspecialidad()) {
                especialidadEspecialidad.getMedico().add(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
            }
            for (Rol rolRol : medico.getRol()) {
                rolRol.getFuncionarioGeneral().add(medico);
                rolRol = em.merge(rolRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getId());
            ArrayList<Especialidad> especialidadOld = persistentMedico.getEspecialidad();
            ArrayList<Especialidad> especialidadNew = medico.getEspecialidad();
            ArrayList<Rol> rolOld = persistentMedico.getRol();
            ArrayList<Rol> rolNew = medico.getRol();
            ArrayList<Especialidad> attachedEspecialidadNew = new ArrayList<Especialidad>();
            for (Especialidad especialidadNewEspecialidadToAttach : especialidadNew) {
                especialidadNewEspecialidadToAttach = em.getReference(especialidadNewEspecialidadToAttach.getClass(), especialidadNewEspecialidadToAttach.getId());
                attachedEspecialidadNew.add(especialidadNewEspecialidadToAttach);
            }
            especialidadNew = attachedEspecialidadNew;
            medico.setEspecialidad(especialidadNew);
            ArrayList<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            medico.setRol(rolNew);
            medico = em.merge(medico);
            for (Especialidad especialidadOldEspecialidad : especialidadOld) {
                if (!especialidadNew.contains(especialidadOldEspecialidad)) {
                    especialidadOldEspecialidad.getMedico().remove(medico);
                    especialidadOldEspecialidad = em.merge(especialidadOldEspecialidad);
                }
            }
            for (Especialidad especialidadNewEspecialidad : especialidadNew) {
                if (!especialidadOld.contains(especialidadNewEspecialidad)) {
                    especialidadNewEspecialidad.getMedico().add(medico);
                    especialidadNewEspecialidad = em.merge(especialidadNewEspecialidad);
                }
            }
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getFuncionarioGeneral().remove(medico);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getFuncionarioGeneral().add(medico);
                    rolNewRol = em.merge(rolNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = medico.getId();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Especialidad> especialidad = medico.getEspecialidad();
            for (Especialidad especialidadEspecialidad : especialidad) {
                especialidadEspecialidad.getMedico().remove(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
            }
            ArrayList<Rol> rol = medico.getRol();
            for (Rol rolRol : rol) {
                rolRol.getFuncionarioGeneral().remove(medico);
                rolRol = em.merge(rolRol);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
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

    public Medico findMedico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
