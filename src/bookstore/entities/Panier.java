package bookstore.entities;

import java.util.ArrayList;

public class Panier{

private int id_panier;
private Client id_user;
private Commande id_comm;
private ArrayList<Book> list=new ArrayList<>();

    public Panier() {
    }

    public Panier(int id_panier, Client id_user, Commande id_comm) {
        this.id_panier = id_panier;
        this.id_user = id_user;
        this.id_comm = id_comm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_panier;
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
        final Panier other = (Panier) obj;
        if (this.id_panier != other.id_panier) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_comm != other.id_comm) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_user=" + id_user + ", id_comm=" + id_comm + ", list=" + list + '}';
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public Client getId_user() {
        return id_user;
    }

    public void setId_user(Client id_user) {
        this.id_user = id_user;
    }

    public Commande getId_comm() {
        return id_comm;
    }

    public void setId_comm(Commande id_comm) {
        this.id_comm = id_comm;
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void setList(ArrayList<Book> list) {
        this.list = list;
    }

    public void retirerLivre(Book b)
    {
    }
    
    public ArrayList ajouterLivre (Book b)
    {
        return list;
    }
    
    public int modifierQuantité (ArrayList<Book> list)
    {
        return 0;
    }
}