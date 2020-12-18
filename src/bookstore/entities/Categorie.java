/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

/**
 *
 * @author user
 */
public class Categorie {
    private int id_categorie ;
    private String Label ;

    public Categorie() {
    }

    public Categorie(int id_categorie, String Label) {
        this.id_categorie = id_categorie;
        this.Label = Label;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getLabel() {
        return Label;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }
    public void ajouterCategorie(){
    
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + id_categorie + ", Label=" + Label + '}';
    }
    
}