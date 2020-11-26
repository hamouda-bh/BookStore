package bookstore.entities;

import java.io.File;

public abstract class User {
    private int id;
    private String username,nom,prenom,email,pwd;
    private String Photo;

    public User(String username, String nom, String prenom, String email, String pwd, String Photo) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.Photo = Photo;
    }
    
    public User(int id, String username, String nom, String prenom, String email, String pwd, String Photo) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.Photo = Photo;
    }
    
    public abstract void login(String username,String pwd);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pwd=" + pwd + ", Photo=" + Photo + '}';
    }
    
}
