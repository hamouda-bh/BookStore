package bookstore.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Facture {

private int idFacture ;
private int idCommande ;
private int id_client ;
private int id_livre;
private Date date_fact ;

    public Facture(int idFacture, int idCommande, int id_client, int id_livre, Date date_fact) {
        this.idFacture = idFacture;
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.id_livre = id_livre;
        this.date_fact = date_fact;
    }
  public Facture(int idCommande, int id_client, int id_livre, Date date_fact) {
       
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.id_livre = id_livre;
        this.date_fact = date_fact;
    }

    public Facture(Date date_fact) {
        Client c = null;
        Livre l = null;
        Commande cc = null;
        this.idCommande = cc.getId_commande();
        this.id_client = c.getId_user();
        this.id_livre = l.getId_livre();
        this.date_fact = date_fact;
    }
    @Override
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
        return "Facture{" + "idFacture=" + idFacture + ", idCommande=" + idCommande + ", id_client=" + id_client + ", id_Livre=" + id_livre + ", date fact=" + date_fact + '}';
    }

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

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public Date getDate_fact() {
        return date_fact;
    }

    public void setDate_fact(Date date_fact) {
        this.date_fact = date_fact;
    }


    public void imprimer()
    {}
    public void telecharger()
    {}
    public void envoyer()
    {}

    
}
