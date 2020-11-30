/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;




import bookstore.entities.Categorie;
import bookstore.Testing.DBConnection;

public class  CategorieService{
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Categorie cat) {
	 String req ="INSERT INTO Livre (idCategorie, Label) VALUES ( '"+cat.getIdCategorie()+"', '"+cat.getLabel()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre ajouté");
} catch (SQLException e) {
}
}
}
