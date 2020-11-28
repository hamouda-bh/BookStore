/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

/**
 *
 * @author PC-Hamouda
 */
public class Book {
    private int id;
    private String nomLivre;
    private String nomAuteur;
    
    public Book(String nomLivre, String nomAuteur) {
        this.nomLivre = nomLivre;
        this.nomAuteur = nomAuteur;
    }

    public Book(int id, String nomLivre, String nomAuteur) {
        this.id = id;
        this.nomLivre = nomLivre;
        this.nomAuteur = nomAuteur;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }


    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", nomLivre=" + nomLivre + ", nomAuteur=" + nomAuteur + '}';
    }
}
