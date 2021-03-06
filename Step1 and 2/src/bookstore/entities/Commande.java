
package bookstore.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

public class Commande {
    private int id_commande; 
    private String date_commande;
    private int id_client;
    private float prixTotale ;

    public Commande() {
    }

    public Commande(int id_commande, String date_commande, int id_client, float prixTotale) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.id_client = id_client;
        this.prixTotale = prixTotale;
    }
    
    public Commande(String date_commande, int id_client, float prixTotale) {
        this.date_commande = date_commande;
        this.id_client = id_client;
        this.prixTotale = prixTotale;
    }
     public Commande( String date_commande,float prixTotale) {
      
        this.date_commande = date_commande;
        this.prixTotale = prixTotale;
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

    public int  getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }


    public float getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(float prixTotale) {
        this.prixTotale = prixTotale;
    }

    @Override
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
    }
    public void confirmerCommande ()
    {
    }
    
}
