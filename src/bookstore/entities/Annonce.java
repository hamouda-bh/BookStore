/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mehdi
 */
public class Annonce {
    
    private int id_annonce;
    private Date date_publication;
    private int id_client;
    private int id_livre;
    private float prix;
    private String etat_de_livre;
    private Date date_achat;
    
    List<Livre> livre = new ArrayList<>();
    
    public void confirmerAnnonce(){}
    
    public void ajouterLive(){}
    
    public void supprimerLivre(){}

    public Annonce(int id_annonce, Date date_publication, int id_client, int id_livre, float prix, String etat_de_livre, Date date_achat) {
        this.id_annonce = id_annonce;
        this.date_publication = date_publication;
        this.id_client = id_client;
        this.id_livre = id_livre;
        this.prix = prix;
        this.etat_de_livre = etat_de_livre;
        this.date_achat = date_achat;
    }

    public Annonce() {
    }

    public Annonce(Date date_publication, float prix, String etat_de_livre, Date date_achat) {
        this.date_publication = date_publication;
        this.prix = prix;
        this.etat_de_livre = etat_de_livre;
        this.date_achat = date_achat;
    }

    
    public Annonce(Date date_publication, int id_client, int id_livre, float prix, String etat_de_livre, Date date_achat) {
        this.date_publication = date_publication;
        this.id_client = id_client;
        this.id_livre = id_livre;
        this.prix = prix;
        this.etat_de_livre = etat_de_livre;
        this.date_achat = date_achat;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getEtat_de_livre() {
        return etat_de_livre;
    }

    public void setEtat_de_livre(String etat_de_livre) {
        this.etat_de_livre = etat_de_livre;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id_annonce;
        hash = 29 * hash + Objects.hashCode(this.date_publication);
        hash = 29 * hash + this.id_client;
        hash = 29 * hash + this.id_livre;
        hash = 29 * hash + Float.floatToIntBits(this.prix);
        hash = 29 * hash + Objects.hashCode(this.etat_de_livre);
        hash = 29 * hash + Objects.hashCode(this.date_achat);
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
        final Annonce other = (Annonce) obj;
        if (this.id_annonce != other.id_annonce) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.id_livre != other.id_livre) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.etat_de_livre, other.etat_de_livre)) {
            return false;
        }
        if (!Objects.equals(this.date_publication, other.date_publication)) {
            return false;
        }
        if (!Objects.equals(this.date_achat, other.date_achat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", date_publication=" + date_publication + ", id_client=" + id_client + ", id_livre=" + id_livre + ", prix=" + prix + ", etat_de_livre=" + etat_de_livre + ", date_achat=" + date_achat + '}';
    }
    
    
         
}
