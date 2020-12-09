package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientService {
	
	Connection cnx = DBConnection.getInstance().getCnx();
	public void ajouter (Client c) {
		  try {
		  String req = "INSERT INTO personne (id_client, nom, prenom, username, email, tel, photo, password, adresse) VALUES ('"+c.getId_user()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getUsername()+"','"+c.getEmail()+"','"+c.getTel()+"','"+c.getPhoto()+"','"+c.getPassword()+"','"+c.getAdress()+"')";
		  Statement st = cnx.createStatement();		  
		  st.executeUpdate(req);
		  System.out.println("F�licitations !");
		  }catch(SQLException ex) {
			  System.out.println(ex.getMessage());
		  }
	  }
}