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
    private File images;
    private File video;
    private File son;
    ArrayList<Book> livres = new ArrayList<>();

    public CategorieKids() {
    }

    public CategorieKids(int idLivreKids) {
        this.idLivreKids = idLivreKids;
    }

    public CategorieKids(int idLivreKids, String Description, File images, File video, File son) {
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

    public File getImages() {
        return images;
    }

    public File getVideo() {
        return video;
    }

    public File getSon() {
        return son;
    }

    public ArrayList<Book> getLivres() {
        return livres;
    }
    
    
    
}
