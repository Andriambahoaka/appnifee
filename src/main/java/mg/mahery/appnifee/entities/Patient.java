/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.appnifee.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mahery
 */
@Entity
@Table(name = "patient")
@NamedQueries({
   @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
   @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
   @NamedQuery(name = "Patient.findByVersion", query = "SELECT p FROM Patient p WHERE p.version = :version"),
   @NamedQuery(name = "Patient.findBySexe", query = "SELECT p FROM Patient p WHERE p.sexe = :sexe"),
   @NamedQuery(name = "Patient.findByPrenom", query = "SELECT p FROM Patient p WHERE p.prenom = :prenom"),
   @NamedQuery(name = "Patient.findByNom", query = "SELECT p FROM Patient p WHERE p.nom = :nom"),
   @NamedQuery(name = "Patient.findByContact", query = "SELECT p FROM Patient p WHERE p.contact = :contact"),
   @NamedQuery(name = "Patient.findByDateNaissance", query = "SELECT p FROM Patient p WHERE p.dateNaissance = :dateNaissance"),
   @NamedQuery(name = "Patient.findByAdresse", query = "SELECT p FROM Patient p WHERE p.adresse = :adresse")})
public class Patient implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id")
   private Integer id;
   @Basic(optional = false)
   @NotNull
   @Column(name = "version")
   private long version;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "sexe")
   private String sexe;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "prenom")
   private String prenom;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "nom")
   private String nom;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "contact")
   private String contact;
   @Basic(optional = false)
   @NotNull
   @Column(name = "date_naissance")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dateNaissance;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 255)
   @Column(name = "adresse")
   private String adresse;
   @OneToMany(mappedBy = "patientId")
   private Collection<RendezVous> rendezVousCollection;

   public Patient() {
   }

   public Patient(int id) {
      this.id = id;
   }

   public Patient(int id, long version, String sexe, String prenom, String nom, String contact, Date dateNaissance, String adresse) {
      this.id = id;
      this.version = version;
      this.sexe = sexe;
      this.prenom = prenom;
      this.nom = nom;
      this.contact = contact;
      this.dateNaissance = dateNaissance;
      this.adresse = adresse;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public long getVersion() {
      return version;
   }

   public void setVersion(long version) {
      this.version = version;
   }

   public String getSexe() {
      return sexe;
   }

   public void setSexe(String sexe) {
      this.sexe = sexe;
   }

   public String getPrenom() {
      return prenom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getContact() {
      return contact;
   }

   public void setContact(String contact) {
      this.contact = contact;
   }

   public Date getDateNaissance() {
      return dateNaissance;
   }

   public void setDateNaissance(Date dateNaissance) {
      this.dateNaissance = dateNaissance;
   }

   public String getAdresse() {
      return adresse;
   }

   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   public Collection<RendezVous> getRendezVousCollection() {
      return rendezVousCollection;
   }

   public void setRendezVousCollection(Collection<RendezVous> rendezVousCollection) {
      this.rendezVousCollection = rendezVousCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Patient)) {
         return false;
      }
      Patient other = (Patient) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "mg.mahery.appnifee.entities.Patient[ id=" + id + " ]";
   }
   
}
