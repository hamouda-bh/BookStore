package com.example.Gestion.des.taches.project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFacture ;
	@Column(name="SUPPORT_PDF")
	private String SupportPDF;
	
	@OneToOne(mappedBy="facture")
	private Commande commande;


	public Facture() {
	     
	    }
    public Facture(int idFacture,String SupportPDF ) {
        this.idFacture = idFacture;
        this.SupportPDF = SupportPDF;
    }

 /*   @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Float.floatToIntBits(this.idFacture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if ((this.idFacture != other.idFacture) && (this.idCommande != other.idCommande) &&(this.id_client != other.id_client)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "idFacture=" + idFacture + ", idCommande=" + idCommande + ", id_client=" + id_client + ", date_fact=" + date_fact + ", prix_totale=" + prix_totale + '}';
    }*/

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getSupportPDF() {
		return SupportPDF;
	}
	public void setSupportPDF(String supportPDF) {
		SupportPDF = supportPDF;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public void imprimer()
    {}
    public void telecharger()
    {}
    public void envoyer()
    {}

	
}
