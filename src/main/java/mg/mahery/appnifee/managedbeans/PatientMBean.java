/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.appnifee.managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mg.mahery.appnifee.entities.Patient;
import mg.mahery.appnifee.session.PatientManager;

/**
 *
 * @author Mahery
 */
@Named(value = "patientMBean")
@ViewScoped
public class PatientMBean implements Serializable {

   private List<Patient> patientList;
   @EJB
   private PatientManager patientManager;

   /**
    * Creates a new instance of PatientMBean
    */
   public PatientMBean() {
   }

   /**
    * Retourne la liste des clients pour affichage dans une
    * DataTable
    *
    * @return
    */
   public List<Patient> getPatients() {
      if (patientList == null) {
         patientList = patientManager.getAllPatients();
      }
      return patientList;
   }

   public String delete(Patient patient) throws IOException {
      FacesContext context = FacesContext.getCurrentInstance();
      //patientManager.delete(patient);
      //FacesContext.getCurrentInstance().getExternalContext()
      //.redirect("PatientList.xhtml"); 
      // context.getExternalContext()
      //.redirect("PatientList.xhtml");
      context.addMessage("Trop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression du patient", "avec succès"));
      //FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "YES", null);
      return "PatientList.xhtml?faces-redirect=true";

//return "PatientList";
   }

}
