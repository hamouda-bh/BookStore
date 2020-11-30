/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.entities.Blog;
import bookstore.Testing.DBConnection;
import bookstore.entities.Blog;

public class  serviceBlog {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Blog b) {
	 String req ="INSERT INTO blog (id_blog, id_client,categorie_blog,description) VALUES ('"+b.getId_blog()+"', '"+b.getId_client()+"', '"+b.getCategorie_blog()+"', '"+b.getDescription()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("blog ajoutée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void supprimer (Blog b) {
	 String req ="DELETE From blog WHERE id="+b.getId_blog();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("blog supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void modifier (Blog b) {
	 String req ="UPDATE blog SET description='"+b.getDescription()+"' WHERE id="+b.getId_blog();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("blog modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}

public List<Blog> afficher ( ) {
	List<Blog> list= new ArrayList<>();
	 String req = "SELECT * from blog";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Blog(res.getInt("id_blog"),res.getInt("id_client"),res.getString("categorie_blog"),res.getString("description")));
}
System.out.println("blog recupere");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}

