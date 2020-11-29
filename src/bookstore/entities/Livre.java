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
    private int idLivre;
    private int idCategorie ;
    private String titre ;
    private String nomAuteur ;
    private float prix ;
    private String Image ;

    public Livre() {
    }

    public Livre(int idLivre, int idCategorie, String titre, String nomAuteur, float prix, String Image) {
        this.idLivre = idLivre;
        this.idCategorie = idCategorie;
        this.titre = titre;
        this.nomAuteur = nomAuteur;
        this.prix = prix;
        this.Image = Image;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getTitre() {
        return titre;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return Image;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "Livre{" + "idLivre=" + idLivre + ", idCategorie=" + idCategorie + ", titre=" + titre + ", nomAuteur=" + nomAuteur + ", prix=" + prix + ", Image=" + Image + '}';
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
        result = prime * result + ((nomAuteur == null) ? 0 : nomAuteur.hashCode());
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
        if (nomAuteur == null) {
            if (other.nomAuteur != null)
                return false;
        } else if (!nomAuteur.equals(other.nomAuteur))
            return false;
        if (titre == null) {
            if (other.titre != null)
                return false;
        } else if (!titre.equals(other.titre))
            return false;
        return true;
    }

    
    
}
