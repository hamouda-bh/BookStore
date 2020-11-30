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
    private String nom_auteur ;
    private float prix ;
    private String image ;

    public Livre() {
    }

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

    public String getNomAuteur() {
        return nom_auteur;
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

    public void setIdLivre(int id_ivre) {
        this.id_livre = id_livre;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.id_categorie = id_categorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nom_auteur = nom_auteur;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    @Override
    public String toString() {
        return "Livre{" + "idLivre=" + id_livre + ", idCategorie=" + id_categorie + ", titre=" + titre + ", nomAuteur=" + nom_auteur + ", prix=" + prix + ", Image=" + image + '}';
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
        result = prime * result + ((nom_auteur == null) ? 0 : nom_auteur.hashCode());
        result = prime * result + ((titre == null) ? 0 : titre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livre other = (Livre) obj;
        if (nom_auteur == null) {
            if (other.nom_auteur != null)
                return false;
        } else if (!nom_auteur.equals(other.nom_auteur))
            return false;
        if (titre == null) {
            if (other.titre != null)
                return false;
        } else if (!titre.equals(other.titre))
            return false;
        return true;
    }

    
    
}
