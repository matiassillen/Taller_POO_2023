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
import Model.Medico;
import Model.Especialidad;
import Model.Titulo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class TituloJpaController implements Serializable {

    public TituloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TituloJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Titulo titulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico medico = titulo.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                titulo.setMedico(medico);
            }
            Especialidad especialidad = titulo.getEspecialidad();
            if (especialidad != null) {
                especialidad = em.getReference(especialidad.getClass(), especialidad.getId());
                titulo.setEspecialidad(especialidad);
            }
            em.persist(titulo);
            if (medico != null) {
                Titulo oldTituloOfMedico = medico.getTitulo();
                if (oldTituloOfMedico != null) {
                    oldTituloOfMedico.setMedico(null);
                    oldTituloOfMedico = em.merge(oldTituloOfMedico);
                }
                medico.setTitulo(titulo);
                medico = em.merge(medico);
            }
            if (especialidad != null) {
                Titulo oldTituloOfEspecialidad = especialidad.getTitulo();
                if (oldTituloOfEspecialidad != null) {
                    oldTituloOfEspecialidad.setEspecialidad(null);
                    oldTituloOfEspecialidad = em.merge(oldTituloOfEspecialidad);
                }
                especialidad.setTitulo(titulo);
                especialidad = em.merge(especialidad);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Titulo titulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Titulo persistentTitulo = em.find(Titulo.class, titulo.getId());
            Medico medicoOld = persistentTitulo.getMedico();
            Medico medicoNew = titulo.getMedico();
            Especialidad especialidadOld = persistentTitulo.getEspecialidad();
            Especialidad especialidadNew = titulo.getEspecialidad();
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                titulo.setMedico(medicoNew);
            }
            if (especialidadNew != null) {
                especialidadNew = em.getReference(especialidadNew.getClass(), especialidadNew.getId());
                titulo.setEspecialidad(especialidadNew);
            }
            titulo = em.merge(titulo);
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                medicoOld.setTitulo(null);
                medicoOld = em.merge(medicoOld);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                Titulo oldTituloOfMedico = medicoNew.getTitulo();
                if (oldTituloOfMedico != null) {
                    oldTituloOfMedico.setMedico(null);
                    oldTituloOfMedico = em.merge(oldTituloOfMedico);
                }
                medicoNew.setTitulo(titulo);
                medicoNew = em.merge(medicoNew);
            }
            if (especialidadOld != null && !especialidadOld.equals(especialidadNew)) {
                especialidadOld.setTitulo(null);
                especialidadOld = em.merge(especialidadOld);
            }
            if (especialidadNew != null && !especialidadNew.equals(especialidadOld)) {
                Titulo oldTituloOfEspecialidad = especialidadNew.getTitulo();
                if (oldTituloOfEspecialidad != null) {
                    oldTituloOfEspecialidad.setEspecialidad(null);
                    oldTituloOfEspecialidad = em.merge(oldTituloOfEspecialidad);
                }
                especialidadNew.setTitulo(titulo);
                especialidadNew = em.merge(especialidadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = titulo.getId();
                if (findTitulo(id) == null) {
                    throw new NonexistentEntityException("The titulo with id " + id + " no longer exists.");
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
            Titulo titulo;
            try {
                titulo = em.getReference(Titulo.class, id);
                titulo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The titulo with id " + id + " no longer exists.", enfe);
            }
            Medico medico = titulo.getMedico();
            if (medico != null) {
                medico.setTitulo(null);
                medico = em.merge(medico);
            }
            Especialidad especialidad = titulo.getEspecialidad();
            if (especialidad != null) {
                especialidad.setTitulo(null);
                especialidad = em.merge(especialidad);
            }
            em.remove(titulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Titulo> findTituloEntities() {
        return findTituloEntities(true, -1, -1);
    }

    public List<Titulo> findTituloEntities(int maxResults, int firstResult) {
        return findTituloEntities(false, maxResults, firstResult);
    }

    private List<Titulo> findTituloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Titulo.class));
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

    public Titulo findTitulo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Titulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTituloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Titulo> rt = cq.from(Titulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
