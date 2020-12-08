package bookstore.entities;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Livre {
    private int id_livre;
    private int id_categorie ;
    private String titre ;
    private String auteur ;
    private float prix ;
    private String genre;
    private String image ;

    public Livre() {
    }

    public Livre(int id_livre, int id_categorie, String titre, String auteur, float prix, String genre, String image) {
        this.id_livre = id_livre;
        this.id_categorie = id_categorie;
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
        this.genre=genre;
        this.image = image;
    }
    public Livre(int id_categorie,String titre,String nom_auteur,float prix,String genre,String Image){
        this.id_categorie = id_categorie;
        this.titre=titre;
        this.auteur=nom_auteur;
        this.prix=prix;
        this.genre=genre;
        this.image=image;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Livre{" + "idLivre=" + id_livre + ", idCategorie=" + id_categorie + ", titre=" + titre + ", nomAuteur=" + auteur + ", prix=" + prix + ", Image=" + image + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_livre;
        hash = 41 * hash + Objects.hashCode(this.id_categorie);
        hash = 41 * hash + Objects.hashCode(this.titre);
        hash = 41 * hash + Objects.hashCode(this.auteur);
        hash = 41 * hash + Float.floatToIntBits(this.prix);
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
        final Livre other = (Livre) obj;
        if (this.id_livre != other.id_livre) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        return true;
    }

    public void ajouterLivre(){
        
    }
    public void modifierLivre(){

    }
    public void supprimerLivre(){
        
    }

  
       
}

    
    

