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
import java.sql.PreparedStatement;

public class  serviceBlog {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Blog b) {
try {
            String sql = "INSERT INTO Blog values (?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, b.getId_blog());
            st.setInt(2, b.getId_client());
            st.setString(3,b.getCategorie_blog());
            st.setString(4,b.getDescription());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("blog ajoute");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

}
public void supprimer (Blog b) {
try {
            String sql = "DELETE FROM Blog where id_blog = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,b.getId_blog());
            st.executeUpdate();
            System.out.println("blog Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

public void afficherBlog (Blog b ) {
 try {
            String sql = "SELECT * FROM blog";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
}

