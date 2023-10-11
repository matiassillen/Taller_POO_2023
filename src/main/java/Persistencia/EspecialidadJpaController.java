/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Especialidad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class EspecialidadJpaController implements Serializable {

    public EspecialidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EspecialidadJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidad especialidad) {
        if (especialidad.getMedico() == null) {
            especialidad.setMedico(new ArrayList<Medico>());
        }
        if (especialidad.getRol() == null) {
            especialidad.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Medico> attachedMedico = new ArrayList<Medico>();
            for (Medico medicoMedicoToAttach : especialidad.getMedico()) {
                medicoMedicoToAttach = em.getReference(medicoMedicoToAttach.getClass(), medicoMedicoToAttach.getId());
                attachedMedico.add(medicoMedicoToAttach);
            }
            especialidad.setMedico(attachedMedico);
            ArrayList<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : especialidad.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            especialidad.setRol(attachedRol);
            em.persist(especialidad);
            for (Medico medicoMedico : especialidad.getMedico()) {
                medicoMedico.getEspecialidad().add(especialidad);
                medicoMedico = em.merge(medicoMedico);
            }
            for (Rol rolRol : especialidad.getRol()) {
                rolRol.getFuncionarioGeneral().add(especialidad);
                rolRol = em.merge(rolRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidad especialidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad persistentEspecialidad = em.find(Especialidad.class, especialidad.getId());
            ArrayList<Medico> medicoOld = persistentEspecialidad.getMedico();
            ArrayList<Medico> medicoNew = especialidad.getMedico();
            ArrayList<Rol> rolOld = persistentEspecialidad.getRol();
            ArrayList<Rol> rolNew = especialidad.getRol();
            ArrayList<Medico> attachedMedicoNew = new ArrayList<Medico>();
            for (Medico medicoNewMedicoToAttach : medicoNew) {
                medicoNewMedicoToAttach = em.getReference(medicoNewMedicoToAttach.getClass(), medicoNewMedicoToAttach.getId());
                attachedMedicoNew.add(medicoNewMedicoToAttach);
            }
            medicoNew = attachedMedicoNew;
            especialidad.setMedico(medicoNew);
            ArrayList<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            especialidad.setRol(rolNew);
            especialidad = em.merge(especialidad);
            for (Medico medicoOldMedico : medicoOld) {
                if (!medicoNew.contains(medicoOldMedico)) {
                    medicoOldMedico.getEspecialidad().remove(especialidad);
                    medicoOldMedico = em.merge(medicoOldMedico);
                }
            }
            for (Medico medicoNewMedico : medicoNew) {
                if (!medicoOld.contains(medicoNewMedico)) {
                    medicoNewMedico.getEspecialidad().add(especialidad);
                    medicoNewMedico = em.merge(medicoNewMedico);
                }
            }
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getFuncionarioGeneral().remove(especialidad);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getFuncionarioGeneral().add(especialidad);
                    rolNewRol = em.merge(rolNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = especialidad.getId();
                if (findEspecialidad(id) == null) {
                    throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.");
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
            Especialidad especialidad;
            try {
                especialidad = em.getReference(Especialidad.class, id);
                especialidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Medico> medico = especialidad.getMedico();
            for (Medico medicoMedico : medico) {
                medicoMedico.getEspecialidad().remove(especialidad);
                medicoMedico = em.merge(medicoMedico);
            }
            ArrayList<Rol> rol = especialidad.getRol();
            for (Rol rolRol : rol) {
                rolRol.getFuncionarioGeneral().remove(especialidad);
                rolRol = em.merge(rolRol);
            }
            em.remove(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidad> findEspecialidadEntities() {
        return findEspecialidadEntities(true, -1, -1);
    }

    public List<Especialidad> findEspecialidadEntities(int maxResults, int firstResult) {
        return findEspecialidadEntities(false, maxResults, firstResult);
    }

    private List<Especialidad> findEspecialidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidad.class));
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

    public Especialidad findEspecialidad(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidad> rt = cq.from(Especialidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
