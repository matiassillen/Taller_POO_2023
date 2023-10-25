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
import Model.Titulo;
import Model.Usuario;
import Model.Especialidad;
import Model.Medico;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public MedicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) {
        if (medico.getEspecialidad() == null) {
            medico.setEspecialidad(new ArrayList<Especialidad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Titulo titulo = medico.getTitulo();
            if (titulo != null) {
                titulo = em.getReference(titulo.getClass(), titulo.getId());
                medico.setTitulo(titulo);
            }
            Usuario usu = medico.getUsu();
            if (usu != null) {
                usu = em.getReference(usu.getClass(), usu.getId());
                medico.setUsu(usu);
            }
            List<Especialidad> attachedEspecialidad = new ArrayList<Especialidad>();
            for (Especialidad especialidadEspecialidadToAttach : medico.getEspecialidad()) {
                especialidadEspecialidadToAttach = em.getReference(especialidadEspecialidadToAttach.getClass(), especialidadEspecialidadToAttach.getId());
                attachedEspecialidad.add(especialidadEspecialidadToAttach);
            }
            medico.setEspecialidad(attachedEspecialidad);
            em.persist(medico);
            if (titulo != null) {
                Medico oldMedicoOfTitulo = titulo.getMedico();
                if (oldMedicoOfTitulo != null) {
                    oldMedicoOfTitulo.setTitulo(null);
                    oldMedicoOfTitulo = em.merge(oldMedicoOfTitulo);
                }
                titulo.setMedico(medico);
                titulo = em.merge(titulo);
            }
            if (usu != null) {
                Model.FuncionarioGeneral oldFuncionarioGeneralOfUsu = usu.getFuncionarioGeneral();
                if (oldFuncionarioGeneralOfUsu != null) {
                    oldFuncionarioGeneralOfUsu.setUsu(null);
                    oldFuncionarioGeneralOfUsu = em.merge(oldFuncionarioGeneralOfUsu);
                }
                usu.setFuncionarioGeneral(medico);
                usu = em.merge(usu);
            }
            for (Especialidad especialidadEspecialidad : medico.getEspecialidad()) {
                especialidadEspecialidad.getMedico().add(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
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
            Titulo tituloOld = persistentMedico.getTitulo();
            Titulo tituloNew = medico.getTitulo();
            Usuario usuOld = persistentMedico.getUsu();
            Usuario usuNew = medico.getUsu();
            List<Especialidad> especialidadOld = persistentMedico.getEspecialidad();
            List<Especialidad> especialidadNew = medico.getEspecialidad();
            if (tituloNew != null) {
                tituloNew = em.getReference(tituloNew.getClass(), tituloNew.getId());
                medico.setTitulo(tituloNew);
            }
            if (usuNew != null) {
                usuNew = em.getReference(usuNew.getClass(), usuNew.getId());
                medico.setUsu(usuNew);
            }
            List<Especialidad> attachedEspecialidadNew = new ArrayList<Especialidad>();
            for (Especialidad especialidadNewEspecialidadToAttach : especialidadNew) {
                especialidadNewEspecialidadToAttach = em.getReference(especialidadNewEspecialidadToAttach.getClass(), especialidadNewEspecialidadToAttach.getId());
                attachedEspecialidadNew.add(especialidadNewEspecialidadToAttach);
            }
            especialidadNew = attachedEspecialidadNew;
            medico.setEspecialidad(especialidadNew);
            medico = em.merge(medico);
            if (tituloOld != null && !tituloOld.equals(tituloNew)) {
                tituloOld.setMedico(null);
                tituloOld = em.merge(tituloOld);
            }
            if (tituloNew != null && !tituloNew.equals(tituloOld)) {
                Medico oldMedicoOfTitulo = tituloNew.getMedico();
                if (oldMedicoOfTitulo != null) {
                    oldMedicoOfTitulo.setTitulo(null);
                    oldMedicoOfTitulo = em.merge(oldMedicoOfTitulo);
                }
                tituloNew.setMedico(medico);
                tituloNew = em.merge(tituloNew);
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
                usuNew.setFuncionarioGeneral(medico);
                usuNew = em.merge(usuNew);
            }
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
            Titulo titulo = medico.getTitulo();
            if (titulo != null) {
                titulo.setMedico(null);
                titulo = em.merge(titulo);
            }
            Usuario usu = medico.getUsu();
            if (usu != null) {
                usu.setFuncionarioGeneral(null);
                usu = em.merge(usu);
            }
            List<Especialidad> especialidad = medico.getEspecialidad();
            for (Especialidad especialidadEspecialidad : especialidad) {
                especialidadEspecialidad.getMedico().remove(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
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
