package com.example.Gestion.des.taches.project.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Commande {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_commande; 
	    private String date_commande;
	    private float prixTotale ;
	    @OneToOne
	    private Facture facture;
	    @OneToOne
	    private Panier panier;
	    
	   
	    public Commande(int id_commande, String date_commande,  float prixTotale) {
	        this.id_commande = id_commande;
	        this.date_commande = date_commande;
	        this.prixTotale = prixTotale;
	    }
	     public Commande( String date_commande,float prixTotale) {
	        
	        this.date_commande = date_commande;
	        this.prixTotale = prixTotale;
	    }

	    public Facture getFacture() {
			return facture;
		}

		public void setFacture(Facture facture) {
			this.facture = facture;
		}

		public Panier getPanier() {
			return panier;
		}

		public void setPanier(Panier panier) {
			this.panier = panier;
		}

		public int getId_commande() {
	        return id_commande;
	    }

	    public void setId_commande(int id_commande) {
	        this.id_commande = id_commande;
	    }

	    public String getDate_commande() {
	        return date_commande;
	    }

	    public void setDate_commande(String date_commande) {
	        this.date_commande = date_commande;
	    }


	    public float getPrixTotale() {
	        return prixTotale;
	    }

	    public void setPrixTotale(float prixTotale) {
	        this.prixTotale = prixTotale;
	    }

	/*    @Override
	    public String toString() {
	        return "Commande{" + "id_commande=" + id_commande + ", date_commande=" + date_commande + ", id_client=" + id_client +  ", prixTotale=" + prixTotale + '}';
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 83 * hash + Float.floatToIntBits(this.prixTotale);
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
	        final Commande other = (Commande) obj;
	        if (this.id_commande != other.id_commande) {
	            return false;
	        }
	        if (this.id_client != other.id_client) {
	            return false;
	        }
	        if (this.prixTotale != other.prixTotale) {
	            return false;
	        }
	        return true;
	    }*/
	    public void confirmerCommande ()
	    {
	      /* Panier_livre p = new Panier_livre();
	        int i= p.getId_comm();
	        Facture f = new Facture(id_commande, id_client,i,date_commande);*/
	    }
	    
	
}
