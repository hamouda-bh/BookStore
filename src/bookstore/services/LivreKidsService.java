package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import bookstore.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LivreKidsService{
    Connection cnx = DBConnection.getInstance().getCnx();
    public void ajouterLivreKids(Livre c) {
        try {
            String sql = "INSERT INTO livre values (?,?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, 1);
            st.setString(2, "C'est un livre de kalila et demna");
            st.setString(3, "https://phpmyadmin/book_store/book1.jpg");
            st.setString(4, "https://phpmyadmin/book_store/book1.mp3");
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("Livre ajoute");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void afficherLesLivresKids(){
        try {
            String sql = "SELECT * FROM livre";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void SupprimerLivreKids(){
        try {
            String sql = "DELETE FROM livre where id_livre = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, 1);
            st.executeUpdate();
            System.out.println("Livre Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
