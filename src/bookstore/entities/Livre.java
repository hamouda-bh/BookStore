package bookstore.entities;

import java.util.Objects;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class Livre {
    private int id_livre;
    private String label_cat ;
    private String titre ;
    private String auteur ;
    private String genre;
    private float prix ;
    private String image ;

    public Livre() {
    }

    public Livre(int id_livre, String label_cat, String titre, String auteur, String genre,float prix,String image) {
        this.id_livre = id_livre;
        this.label_cat = label_cat;
        this.titre = titre;
        this.auteur = auteur;
        this.genre=genre;
        this.prix = prix;
        this.image = image;
    }

    public Livre(String label_cat, String titre, String auteur, String genre, float prix, String image) {
        this.label_cat = label_cat;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.prix = prix;
        this.image = image;
    }

    
   
    

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public String getLabel_cat() {
        return label_cat;
    }

    public void setLabel_cat(String label_cat) {
        this.label_cat = label_cat;
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
        return "Livre{" + "idLivre=" + id_livre + ", Label=" + label_cat + ", titre=" + titre + ", nomAuteur=" + auteur + ", genre=" + genre + ",  prix=" + prix + ", Image=" + image + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_livre;
        hash = 41 * hash + Objects.hashCode(this.label_cat);
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

    
    

