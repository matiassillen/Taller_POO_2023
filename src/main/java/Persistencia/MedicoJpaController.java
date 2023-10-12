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
import Model.Rol;
import Model.Especialidad;
import java.util.ArrayList;
import Model.Triage;
import Model.Consulta;
import Model.Medico;
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
    
    public MedicoJpaController() {
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
        if (medico.getTriage() == null) {
            medico.setTriage(new ArrayList<Triage>());
        }
        if (medico.getConsulta() == null) {
            medico.setConsulta(new ArrayList<Consulta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol = medico.getRol();
            if (rol != null) {
                rol = em.getReference(rol.getClass(), rol.getId_rol());
                medico.setRol(rol);
            }
            ArrayList<Especialidad> attachedEspecialidad = new ArrayList<Especialidad>();
            for (Especialidad especialidadEspecialidadToAttach : medico.getEspecialidad()) {
                especialidadEspecialidadToAttach = em.getReference(especialidadEspecialidadToAttach.getClass(), especialidadEspecialidadToAttach.getId());
                attachedEspecialidad.add(especialidadEspecialidadToAttach);
            }
            medico.setEspecialidad(attachedEspecialidad);
            ArrayList<Triage> attachedTriage = new ArrayList<Triage>();
            for (Triage triageTriageToAttach : medico.getTriage()) {
                triageTriageToAttach = em.getReference(triageTriageToAttach.getClass(), triageTriageToAttach.getNumTriage());
                attachedTriage.add(triageTriageToAttach);
            }
            medico.setTriage(attachedTriage);
            ArrayList<Consulta> attachedConsulta = new ArrayList<Consulta>();
            for (Consulta consultaConsultaToAttach : medico.getConsulta()) {
                consultaConsultaToAttach = em.getReference(consultaConsultaToAttach.getClass(), consultaConsultaToAttach.getNumConsulta());
                attachedConsulta.add(consultaConsultaToAttach);
            }
            medico.setConsulta(attachedConsulta);
            em.persist(medico);
            if (rol != null) {
                rol.getFuncionarioGeneral().add(medico);
                rol = em.merge(rol);
            }
            for (Especialidad especialidadEspecialidad : medico.getEspecialidad()) {
                especialidadEspecialidad.getMedico().add(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
            }
            for (Triage triageTriage : medico.getTriage()) {
                Medico oldMedicoOfTriageTriage = triageTriage.getMedico();
                triageTriage.setMedico(medico);
                triageTriage = em.merge(triageTriage);
                if (oldMedicoOfTriageTriage != null) {
                    oldMedicoOfTriageTriage.getTriage().remove(triageTriage);
                    oldMedicoOfTriageTriage = em.merge(oldMedicoOfTriageTriage);
                }
            }
            for (Consulta consultaConsulta : medico.getConsulta()) {
                Medico oldMedicoOfConsultaConsulta = consultaConsulta.getMedico();
                consultaConsulta.setMedico(medico);
                consultaConsulta = em.merge(consultaConsulta);
                if (oldMedicoOfConsultaConsulta != null) {
                    oldMedicoOfConsultaConsulta.getConsulta().remove(consultaConsulta);
                    oldMedicoOfConsultaConsulta = em.merge(oldMedicoOfConsultaConsulta);
                }
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
            Rol rolOld = persistentMedico.getRol();
            Rol rolNew = medico.getRol();
            ArrayList<Especialidad> especialidadOld = persistentMedico.getEspecialidad();
            ArrayList<Especialidad> especialidadNew = medico.getEspecialidad();
            ArrayList<Triage> triageOld = persistentMedico.getTriage();
            ArrayList<Triage> triageNew = medico.getTriage();
            ArrayList<Consulta> consultaOld = persistentMedico.getConsulta();
            ArrayList<Consulta> consultaNew = medico.getConsulta();
            if (rolNew != null) {
                rolNew = em.getReference(rolNew.getClass(), rolNew.getId_rol());
                medico.setRol(rolNew);
            }
            ArrayList<Especialidad> attachedEspecialidadNew = new ArrayList<Especialidad>();
            for (Especialidad especialidadNewEspecialidadToAttach : especialidadNew) {
                especialidadNewEspecialidadToAttach = em.getReference(especialidadNewEspecialidadToAttach.getClass(), especialidadNewEspecialidadToAttach.getId());
                attachedEspecialidadNew.add(especialidadNewEspecialidadToAttach);
            }
            especialidadNew = attachedEspecialidadNew;
            medico.setEspecialidad(especialidadNew);
            ArrayList<Triage> attachedTriageNew = new ArrayList<Triage>();
            for (Triage triageNewTriageToAttach : triageNew) {
                triageNewTriageToAttach = em.getReference(triageNewTriageToAttach.getClass(), triageNewTriageToAttach.getNumTriage());
                attachedTriageNew.add(triageNewTriageToAttach);
            }
            triageNew = attachedTriageNew;
            medico.setTriage(triageNew);
            ArrayList<Consulta> attachedConsultaNew = new ArrayList<Consulta>();
            for (Consulta consultaNewConsultaToAttach : consultaNew) {
                consultaNewConsultaToAttach = em.getReference(consultaNewConsultaToAttach.getClass(), consultaNewConsultaToAttach.getNumConsulta());
                attachedConsultaNew.add(consultaNewConsultaToAttach);
            }
            consultaNew = attachedConsultaNew;
            medico.setConsulta(consultaNew);
            medico = em.merge(medico);
            if (rolOld != null && !rolOld.equals(rolNew)) {
                rolOld.getFuncionarioGeneral().remove(medico);
                rolOld = em.merge(rolOld);
            }
            if (rolNew != null && !rolNew.equals(rolOld)) {
                rolNew.getFuncionarioGeneral().add(medico);
                rolNew = em.merge(rolNew);
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
            for (Triage triageOldTriage : triageOld) {
                if (!triageNew.contains(triageOldTriage)) {
                    triageOldTriage.setMedico(null);
                    triageOldTriage = em.merge(triageOldTriage);
                }
            }
            for (Triage triageNewTriage : triageNew) {
                if (!triageOld.contains(triageNewTriage)) {
                    Medico oldMedicoOfTriageNewTriage = triageNewTriage.getMedico();
                    triageNewTriage.setMedico(medico);
                    triageNewTriage = em.merge(triageNewTriage);
                    if (oldMedicoOfTriageNewTriage != null && !oldMedicoOfTriageNewTriage.equals(medico)) {
                        oldMedicoOfTriageNewTriage.getTriage().remove(triageNewTriage);
                        oldMedicoOfTriageNewTriage = em.merge(oldMedicoOfTriageNewTriage);
                    }
                }
            }
            for (Consulta consultaOldConsulta : consultaOld) {
                if (!consultaNew.contains(consultaOldConsulta)) {
                    consultaOldConsulta.setMedico(null);
                    consultaOldConsulta = em.merge(consultaOldConsulta);
                }
            }
            for (Consulta consultaNewConsulta : consultaNew) {
                if (!consultaOld.contains(consultaNewConsulta)) {
                    Medico oldMedicoOfConsultaNewConsulta = consultaNewConsulta.getMedico();
                    consultaNewConsulta.setMedico(medico);
                    consultaNewConsulta = em.merge(consultaNewConsulta);
                    if (oldMedicoOfConsultaNewConsulta != null && !oldMedicoOfConsultaNewConsulta.equals(medico)) {
                        oldMedicoOfConsultaNewConsulta.getConsulta().remove(consultaNewConsulta);
                        oldMedicoOfConsultaNewConsulta = em.merge(oldMedicoOfConsultaNewConsulta);
                    }
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
            Rol rol = medico.getRol();
            if (rol != null) {
                rol.getFuncionarioGeneral().remove(medico);
                rol = em.merge(rol);
            }
            ArrayList<Especialidad> especialidad = medico.getEspecialidad();
            for (Especialidad especialidadEspecialidad : especialidad) {
                especialidadEspecialidad.getMedico().remove(medico);
                especialidadEspecialidad = em.merge(especialidadEspecialidad);
            }
            ArrayList<Triage> triage = medico.getTriage();
            for (Triage triageTriage : triage) {
                triageTriage.setMedico(null);
                triageTriage = em.merge(triageTriage);
            }
            ArrayList<Consulta> consulta = medico.getConsulta();
            for (Consulta consultaConsulta : consulta) {
                consultaConsulta.setMedico(null);
                consultaConsulta = em.merge(consultaConsulta);
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
