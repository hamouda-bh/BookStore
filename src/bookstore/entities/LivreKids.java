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
    private int idCategorie;
    private String titre;
    private String Description;
    private String Image;
    private String Video;
    private String Son;

    public LivreKids(int idLivreKids, int idCategorie, String titre, String Description, String Image, String Video, String Son) {
        this.idLivreKids = idLivreKids;
        this.idCategorie = idCategorie;
        this.titre = titre;
        this.Description = Description;
        this.Image = Image;
        this.Video = Video;
        this.Son = Son;
    }
    
    public LivreKids(String titre, String Description, String Image, String Video, String Son) {
        this.titre = titre;
        this.Description = Description;
        this.Image = Image;
        this.Video = Video;
        this.Son = Son;
    }

    public LivreKids(String titre, String Description) {
        this.titre = titre;
        this.Description = Description;
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

    public String getVideo() {
        return Video;
    }

    public void setVideo(String Video) {
        this.Video = Video;
    }

    public String getSon() {
        return Son;
    }

    public void setSon(String Son) {
        this.Son = Son;
    }

    @Override
    public String toString() {
        return "LivreKids{" + "idLivreKids=" + idLivreKids + ", Description=" + Description + ", Image=" + Image + ", Video=" + Video + ", Son=" + Son + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idLivreKids;
        hash = 97 * hash + Objects.hashCode(this.Description);
        hash = 97 * hash + Objects.hashCode(this.Image);
        hash = 97 * hash + Objects.hashCode(this.Video);
        hash = 97 * hash + Objects.hashCode(this.Son);
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
        final LivreKids other = (LivreKids) obj;
        if (this.idLivreKids != other.idLivreKids) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Image, other.Image)) {
            return false;
        }
        if (!Objects.equals(this.Video, other.Video)) {
            return false;
        }
        if (!Objects.equals(this.Son, other.Son)) {
            return false;
        }
        return true;
    }
    
}
