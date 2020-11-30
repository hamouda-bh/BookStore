/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Mehdi
 */
public class CategorieKids {
    
    private int idLivreKids;
    private String Description;
    private String images;
    private String video;
    private String son;

    public CategorieKids() {
    }

    public CategorieKids(int idLivreKids) {
        this.idLivreKids = idLivreKids;
    }

    public CategorieKids(int idLivreKids, String Description, String images, String video, String son) {
        this.idLivreKids = idLivreKids;
        this.Description = Description;
        this.images = images;
        this.video = video;
        this.son = son;
    }

    public int getIdLivreKids() {
        return idLivreKids;
    }

    public String getDescription() {
        return Description;
    }

    public String getImages() {
        return images;
    }

    public String getVideo() {
        return video;
    }

    public String getSon() {
        return son;
    }   
    
    
}
