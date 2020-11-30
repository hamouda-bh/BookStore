package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Livre;
import bookstore.entities.LivreKids;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class LivreKidsService{
    Connection cnx = DBConnection.getInstance().getCnx();
    public void ajouterLivreKids(LivreKids c) {
        try {
            String sql = "INSERT INTO livrekids values (?,?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, c.getIdLivreKids());
            st.setString(2,c.getDescription());
            st.setString(3,c.getImage() );
            st.setString(4,c.getVideo() );
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
            String sql = "SELECT * FROM livrekids";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void SupprimerLivreKids(Livre c){
        try {
            String sql = "DELETE FROM livrekids where id_livre = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,c.getIdLivre());
            st.executeUpdate();
            System.out.println("Livre Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
