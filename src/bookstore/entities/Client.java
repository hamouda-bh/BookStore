package bookstore.entities;

import java.io.File;

public class Client extends User{

    public Client(String username, String nom, String prenom, String email, String pwd, String Photo) {
        super(username, nom, prenom, email, pwd, Photo);
    }

    public Client(int id, String username, String nom, String prenom, String email, String pwd, String Photo) {
        super(id, username, nom, prenom, email, pwd, Photo);
    }
    
  
    
    @Override
    public void login(String username, String pwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
