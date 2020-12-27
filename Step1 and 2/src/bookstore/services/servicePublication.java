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

import bookstore.entities.Publication;
import bookstore.Testing.DBConnection;
import bookstore.entities.Publication;
import java.sql.PreparedStatement;

public class  servicePublication {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Publication p) {
	try {
            String sql = "INSERT INTO publication values (?,?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, p.getId_publication());
            st.setInt(2, p.getId_blog());
            st.setInt(3, p.getId_client());
            st.setString(4,p.getContenue());
            st.setString(5,p.getCommentaire());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("pub ajoute");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
public void supprimer (Publication p) {
try {
            String sql = "DELETE FROM publication where id_publication = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,p.getId_publication());
            st.executeUpdate();
            System.out.println("publication Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
public void modifier (Publication p) {
	 String req ="UPDATE publication SET contenue='"+p.getContenue()+"' WHERE id="+p.getId_publication();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("publication modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}

public List<Publication> afficher ( ) {
	List<Publication> list= new ArrayList<>();
	 String req = "SELECT * from publication";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Publication(res.getInt("id_publication"),res.getInt("id_blog"),res.getInt("id_client"),res.getString("contenue"),res.getString("commentaire")));
}
System.out.println("blog recuperee");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}


