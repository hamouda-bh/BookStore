package com.example.Gestion.des.taches.project.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_panier;
	private float somme_ajoute ;
	private int quantite_ajouter;
	@ManyToOne(cascade = CascadeType.ALL)
    private Livre livre;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public float getSomme_ajoute() {
        return somme_ajoute;
    }

    public void setSomme_ajoute(float somme_ajouté) {
        this.somme_ajoute = somme_ajouté;
    }

    public int getQuantite_ajouter() {
        return quantite_ajouter;
    }

    public void setQuantite_ajouter(int quantite_ajouter) {
        this.quantite_ajouter = quantite_ajouter;
    }

   /*

    public Panier(int id_panier, int id_user, int id_comm, float somme_ajoute, int quantite_ajouter) {
        this.id_panier = id_panier;
        this.id_user = id_user;
        this.id_comm = id_comm;
        this.somme_ajoute = somme_ajoute;
        this.quantite_ajouter = quantite_ajouter;
    }
    public Panier(int id_user, int id_comm, float somme_ajoute, int quantite_ajouter) {
        this.id_user = id_user;
        this.id_comm = id_comm;
        this.somme_ajoute = somme_ajoute;
        this.quantite_ajouter = quantite_ajouter;
    }
    
    public Panier(float somme_ajoute, int quantite_ajouter) {
       
        this.somme_ajoute = somme_ajoute;
        this.quantite_ajouter = quantite_ajouter;
    
    }*/

  
    public Long getId_panier() {
        return id_panier;
    }

    public void setId_panier(Long id_panier) {
        this.id_panier = id_panier;
    }

   
    /*  @Override
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
        final Panier_livre other = (Panier_livre) obj;
        if (this.id_panier != other.id_panier) {
            return false;
        }
        if ((this.id_user != other.id_user)&&(this.id_comm != other.id_comm)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_user=" + id_user + ", id_comm=" + id_comm + ", somme=" + somme_ajoute + ", quantité ajouté"+ quantite_ajouter+'}';
    }
*/
    
/*
    @Override
    public void retirerLivre(Livre b) {
         Panier ps = new Panier();
        ps.supprimer(this.id_comm);
    }

    @Override
    public int modifierQuantité(ArrayList<Livre> list) {
       
        PanierService ps = new PanierService();
    try {
        ps.modifier(this.quantite_ajouter,this.id_comm);
    } catch (SQLException ex) {
        Logger.getLogger(Panier_livre.class.getName()).log(Level.SEVERE, null, ex);
    }
        return ps.afficherQ();
    
    }*/

   
	
}