package bookstore.entities;

import java.util.ArrayList;

public class Facture {

private int idFacture ;
private int idCommande ;
private int id_client ;
private String nomClient;
private String  prenomClient ;
private ArrayList<Book> bookList = new ArrayList();
private float prixtotal;

    public Facture(int idCommande, int id_client, String nomClient, String prenomClient, ArrayList<Book> bookList,
    float prixtotal) {
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.bookList = bookList;
        this.prixtotal = prixtotal;
    }

    public Facture(int idFacture, int idCommande, int id_client, String nomClient, String prenomClient, float prixtotal) {
        this.idFacture = idFacture;
        this.idCommande = idCommande;
        this.id_client = id_client;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.prixtotal = prixtotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Float.floatToIntBits(this.prixtotal);
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
        if (this.idFacture != other.idFacture) {
            return false;
        }
        if (this.idCommande != other.idCommande) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "idFacture=" + idFacture + ", idCommande=" + idCommande + ", id_client=" + id_client + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", bookList=" + bookList + ", prixtotal=" + prixtotal + '}';
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

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public float getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(float prixtotal) {
        this.prixtotal = prixtotal;
    }

    public void imprimer()
    {}
    public void telecharger()
    {}
    public void envoyer()
    {}

    
}
