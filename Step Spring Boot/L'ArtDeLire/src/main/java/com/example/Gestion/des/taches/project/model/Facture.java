package com.example.Gestion.des.taches.project.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFacture ;
	private int idCommande ;
	private int id_client ;
	private String date_fact ;
	private float prix_totale; 


public Facture() {
     
    }
    public Facture(int idFacture, int idCommande, int id_client,String date_fact, float prix_totale) {
        this.idFacture = idFacture;
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.date_fact = date_fact;
        this.prix_totale = prix_totale;
    }

    public float getPrix_totale() {
        return prix_totale;
    }

    public void setPrix_totale(float prix_totale) {
        this.prix_totale = prix_totale;
    }
  public Facture(int idCommande, int id_client,  String date_fact, float prix_totale) {
       this.prix_totale= prix_totale;
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.date_fact = date_fact;
    }

    public Facture(String date_fact) {
        
        Livre l = null;
        Commande cc = null;
        this.idCommande = cc.getId_commande();
        this.date_fact = date_fact;
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

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

   
    public String getDate_fact() {
        return date_fact;
    }

    public void setDate_fact(String date_fact) {
        this.date_fact = date_fact;
    }


    public void imprimer()
    {}
    public void telecharger()
    {}
    public void envoyer()
    {}

	
}
