package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import bookstore.entities.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;


public class ClientService {
	
	Connection cnx = DBConnection.getInstance().getCnx();
	/*public void ajouter (Client c) {
		  try {
		  String req = "INSERT INTO personne (id_client, nom, prenom, username, email, tel, photo, password, adresse) VALUES ('"+c.getId_user()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getUsername()+"','"+c.getEmail()+"','"+c.getTel()+"','"+c.getPhoto()+"','"+c.getPassword()+"','"+c.getAdress()+"')";
		  Statement st = cnx.createStatement();		  
		  st.executeUpdate(req);
		  System.out.println("F�licitations !");
		  }catch(SQLException ex) {
			  System.out.println(ex.getMessage());
		  }
	  }*/
	
	/*public void addCustomer(Utilisateur c) {
        try {
            String req = "INSERT INTO customer (nom,lastname,age,email,password,address,telephone,roleid) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, c.getFirstName());
            pst.setString(2, c.getLastName());
            pst.setInt(3, c.getAge());
            pst.setString(4, c.getEmail());
            pst.setString(5,BCrypt.hashpw(c.getPassword(), BCrypt.gensalt ()));
            pst.setString(6, c.getAddress());
            pst.setString(7, c.getTelephone());
            pst.setInt(8, c.getRole().getId());
            pst.executeUpdate();
            System.out.println("+ CUSTOMER ADDED hhhhh TO DATABASE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
	public boolean authentification(String email, String pass) {

	       String password = "";
	       try {
	           String req = "SELECT password FROM client WHERE email = '"+email+"'" ;

	           PreparedStatement st = cnx.prepareStatement(req);
//	                     st.setString(1, username);
//				st.setString(2, pass);
	           ResultSet res = st.executeQuery(req);
	           while (res.next()) {

	               password = res.getString("password");
	           }
	          
	               if (BCrypt.checkpw(pass, password)) {
	                   return true;
	               } else {
	                   return false;
	               }
	           
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       }
	       return false;
	}

}