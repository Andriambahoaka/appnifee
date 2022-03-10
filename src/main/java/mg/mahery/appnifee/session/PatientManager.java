/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.appnifee.session;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.mahery.appnifee.entities.Patient;

/**
 *
 * @author Mahery
 */
@Stateless
public class PatientManager {

   @PersistenceContext(unitName = "cabinetdentairePU")
   private EntityManager em;

   @Resource

   // Add business logic below. (Right-click in editor and choose
   // "Insert Code > Add Business Method")
   public List<Patient> getAllPatients() {
      Query query = em.createNamedQuery("Patient.findAll");
      return query.getResultList();
   }

   public Patient update(Patient patient) {
      return em.merge(patient);
   }

   public void persist(Patient patient) {
      em.persist(patient);
   }

   public Patient getPatient(int idPatient) {
      return em.find(Patient.class, idPatient);
   }

   public void delete(Patient patient) {
      if (!em.contains(patient)) {
         patient = em.merge(patient);
      }
      em.remove(patient);
   }
}
