/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.appnifee.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mahery
 */
@Entity
@Table(name = "rendez_vous")
@NamedQueries({
   @NamedQuery(name = "RendezVous.findAll", query = "SELECT r FROM RendezVous r"),
   @NamedQuery(name = "RendezVous.findById", query = "SELECT r FROM RendezVous r WHERE r.id = :id"),
   @NamedQuery(name = "RendezVous.findByVersion", query = "SELECT r FROM RendezVous r WHERE r.version = :version"),
   @NamedQuery(name = "RendezVous.findByDate", query = "SELECT r FROM RendezVous r WHERE r.date = :date"),
   @NamedQuery(name = "RendezVous.findByEtat", query = "SELECT r FROM RendezVous r WHERE r.etat = :etat"),
   @NamedQuery(name = "RendezVous.findByHeure", query = "SELECT r FROM RendezVous r WHERE r.heure = :heure")})
public class RendezVous implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "id")
   private Long id;
   @Basic(optional = false)
   @NotNull
   @Column(name = "version")
   private long version;
   @Basic(optional = false)
   @NotNull
   @Column(name = "date")
   @Temporal(TemporalType.TIMESTAMP)
   private Date date;
   @Basic(optional = false)
   @NotNull
   @Column(name = "etat")
   private int etat;
   @Basic(optional = false)
   @NotNull
   @Column(name = "heure")
   private int heure;
   @JoinColumn(name = "patient_id", referencedColumnName = "id")
   @ManyToOne
   private Patient patientId;

   public RendezVous() {
   }

   public RendezVous(Long id) {
      this.id = id;
   }

   public RendezVous(Long id, long version, Date date, int etat, int heure) {
      this.id = id;
      this.version = version;
      this.date = date;
      this.etat = etat;
      this.heure = heure;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public long getVersion() {
      return version;
   }

   public void setVersion(long version) {
      this.version = version;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public int getEtat() {
      return etat;
   }

   public void setEtat(int etat) {
      this.etat = etat;
   }

   public int getHeure() {
      return heure;
   }

   public void setHeure(int heure) {
      this.heure = heure;
   }

   public Patient getPatientId() {
      return patientId;
   }

   public void setPatientId(Patient patientId) {
      this.patientId = patientId;
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
      if (!(object instanceof RendezVous)) {
         return false;
      }
      RendezVous other = (RendezVous) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "mg.mahery.appnifee.entities.RendezVous[ id=" + id + " ]";
   }
   
}
