/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Livre {
    private int id_livre;
    private Categorie id_categorie ;
    private String titre ;
<<<<<<< HEAD
    private String auteur ;
    private float prix ;
    private String genre ;
    private String Image ;
=======
    private String nom_auteur ;
    private float prix ;
    private String image ;
>>>>>>> medBh

    public Livre() {
    }

<<<<<<< HEAD
    public Livre(int idLivre, int idCategorie, String titre, String auteur, float prix,String genre , String Image) {
        this.idLivre = idLivre;
        this.idCategorie = idCategorie;
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
        this.genre=genre ;
        this.Image = Image;
=======
    public Livre(int id_livre, Categorie id_categorie, String titre, String nom_auteur, float prix, String image) {
        this.id_livre = id_livre;
        this.id_categorie = id_categorie;
        this.titre = titre;
        this.nom_auteur = nom_auteur;
        this.prix = prix;
        this.image = image;
    }
    public Livre(Categorie id_categorie,String titre,String nom_auteur,float prix,String Image){
        this.id_categorie = id_categorie;
        this.titre=titre;
        this.nom_auteur=nom_auteur;
        this.prix=prix;
        this.image=image;
>>>>>>> medBh
    }

    public int getIdLivre() {
        return id_livre;
    }

    public Categorie getIdCategorie() {
        return id_categorie;
    }

    public String getTitre() {
        return titre;
    }

<<<<<<< HEAD
    public String getAuteur() {
        return auteur;
=======
    public String getNomAuteur() {
        return nom_auteur;
>>>>>>> medBh
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

<<<<<<< HEAD
    public String getGenre() {
        return genre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
=======
    public void setIdLivre(int id_ivre) {
        this.id_livre = id_livre;
>>>>>>> medBh
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.id_categorie = id_categorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNomAuteur(String nomAuteur) {
<<<<<<< HEAD
        this.auteur = nomAuteur;
=======
        this.nom_auteur = nom_auteur;
>>>>>>> medBh
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Livre{" + "idLivre=" + idLivre + ", idCategorie=" + idCategorie + ", titre=" + titre + ", nomAuteur=" + auteur + ", prix=" + prix + ", Image=" + Image + '}';
=======
        return "Livre{" + "idLivre=" + id_livre + ", idCategorie=" + id_categorie + ", titre=" + titre + ", nomAuteur=" + nom_auteur + ", prix=" + prix + ", Image=" + image + '}';
>>>>>>> medBh
    }
    public void ajouterLivre(){
        
    }
    public void modifierLivre(){
}
    public void supprimerLivre(){
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
<<<<<<< HEAD
        result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
=======
        result = prime * result + ((nom_auteur == null) ? 0 : nom_auteur.hashCode());
>>>>>>> medBh
        result = prime * result + ((titre == null) ? 0 : titre.hashCode());
        return result;
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
<<<<<<< HEAD
        }
        final Livre other = (Livre) obj;
        if (this.idLivre != other.idLivre) {
=======
        Livre other = (Livre) obj;
        if (nom_auteur == null) {
            if (other.nom_auteur != null)
                return false;
        } else if (!nom_auteur.equals(other.nom_auteur))
>>>>>>> medBh
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return Objects.equals(this.auteur, other.auteur);
    }
  
       
}

    
    

