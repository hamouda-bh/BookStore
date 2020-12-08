
package bookstore.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Commande {
    private int id_commande; 
    private Date date_commande;
    private int id_client;
    private int prixTotale ;

    public Commande() {
    }

    public Commande(int id_commande, Date date_commande, int id_client, int prixTotale) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.id_client = id_client;
        this.prixTotale = prixTotale;
    }
     public Commande( Date date_commande,int prixTotale) {
        Client c = null;   
        this.date_commande = date_commande;
        this.id_client = c.getId_user();
        this.prixTotale = prixTotale;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public int  getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }


    public int getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(int prixTotale) {
        this.prixTotale = prixTotale;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", date_commande=" + date_commande + ", id_client=" + id_client +  ", prixTotale=" + prixTotale + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.prixTotale;
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
        Panier_livre p = new Panier_livre();
        int i= p.getId_comm();
        Facture f = new Facture(id_commande, id_client,i,date_commande);
    }
    
}
