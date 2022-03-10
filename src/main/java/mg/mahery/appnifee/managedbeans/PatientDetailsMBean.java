/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.appnifee.managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import mg.mahery.appnifee.entities.Patient;
import mg.mahery.appnifee.session.PatientManager;

/**
 *
 * @author Mahery
 */
@Named(value = "patientDetailsMBean") 
@ViewScoped
public class PatientDetailsMBean implements Serializable {

   @EJB
   private PatientManager patientManager;
 
   private int idPatient;
   private Patient patient;

   
      /**
    * Creates a new instance of PatientDetailsMBean
    */
   public PatientDetailsMBean() {
   }
   
   
   
   public int getIdPatient() {
      return idPatient;
   }

   public void setIdPatient(int idPatient) {
      this.idPatient = idPatient;
   }
   
   /**
   * Retourne les détails du patient courant (celui dans l'attribut patient de
   * cette classe), qu'on appelle une propriété (property)
   */
   public Patient getDetails(){
      return patient;
   }
   /**
   * Action handler - met à jour dans la base de données les données du patient
   * contenu dans la variable d'instance patient.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
   public String update(){
     patient= patientManager.update(patient);
     return "PatientList";
   }
   
   public void loadPatient(){
      this.patient=patientManager.getPatient(idPatient);
   }
   
}
