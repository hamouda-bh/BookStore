/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Objects;

/**
 *
 * @author PC-Hamouda
 */
public class LivreKids {
    private int idLivreKids;

    private String titre;
    private String Description;
    private String Image;
    private CategorieKids cat;
    
    
    public LivreKids(){
    }

    public LivreKids(int idLivreKids, String titre, String Description, String Image  ) {
        this.idLivreKids = idLivreKids;

        this.titre = titre;
        this.Description = Description;
        this.Image = Image;
    }
    
    public LivreKids(String titre, String Description, String Image) {
        this.titre = titre;
        this.Description = Description;
        this.Image = Image;

    }

    public LivreKids(String titre, String Description) {
        this.titre = titre;
        this.Description = Description;
    }

    public CategorieKids getCat() {
        return cat;
    }

    public void setCat(CategorieKids cat) {
        this.cat = cat;
    }
    

    

    public int getIdLivreKids() {
        return idLivreKids;
    }

    public void setIdLivreKids(int idLivreKids) {
        this.idLivreKids = idLivreKids;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "LivreKids{" + "idLivreKids=" + idLivreKids + ", titre=" + titre + ", Description=" + Description + ", Image=" + Image + ", cat=" + cat + '}';
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
        final LivreKids other = (LivreKids) obj;
        if (this.idLivreKids != other.idLivreKids) {
            return false;
        }
        return true;
    }
    
}
