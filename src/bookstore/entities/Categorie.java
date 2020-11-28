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
    private int idCategorie ;
    private String Label ;

    public Categorie() {
    }

    public Categorie(int idCategorie, String Label) {
        this.idCategorie = idCategorie;
        this.Label = Label;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getLabel() {
        return Label;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }
    public void ajouterCategorie(){
    
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", Label=" + Label + '}';
    }
    
}
