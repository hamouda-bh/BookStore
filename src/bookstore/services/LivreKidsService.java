package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Livre;
import bookstore.entities.LivreKids;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LivreKidsService{
    Connection cnx = DBConnection.getInstance().getCnx();
    
    //methode qui permet de vérifier l'existence d'un livre en utilisant un titre en parametre
    public boolean rechercheTitre(String titre){
        try {
            String sql = "SELECT titre from livrekids where UPPER(?)=UPPER(titre)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, titre);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                    if((rs.getString(1)).equals(titre)){
                    System.out.println("Livre Trouvé");
                    return true;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    
    //methode qui permet d'jouter un livre à la BD
    public void ajouterLivreKids(LivreKids c) {
        try {
            String sql = "INSERT INTO livrekids () values (?,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,c.getDescription());
            st.setString(2,c.getImage());
            st.setString(3,c.getSon());
            st.setString(4,c.getVideo());
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
    
    //methode qui permet d'afficher tous les livres ainsi que leur categorie
    public void afficherLesLivresKids(){
        //List<LivreKids> list = new ArrayList<>();
        try {
            String sql = "SELECT l.titre,c.nom_categorie,l.description,l.image FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String titreLivre = rs.getString(1);
                String nom_categorie = rs.getString(2);
                String description = rs.getString(3);
                String image = rs.getString(4);
                //list.add(new LivreKids(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                // int idlivrekids = rs.getInt(1);
                // int idcategoriekids = rs.getInt(2);
                // String descriptionLivreKids = rs.getString(3);
                // String Image = rs.getString(4);
                // String Video = rs.getString(5);
                // String Son = rs.getString(6);
                // int idcategoriekids2 = rs.getInt(7);
                // String descriptionCategorieKids = rs.getString(8);
                //System.out.println(idlivrekids + " " + idcategoriekids + " " + descriptionLivreKids + " " + Image + " " + Video + " " + Son + " " + idcategoriekids2 + " " + descriptionCategorieKids);
                System.out.println(titreLivre +" "+ nom_categorie +" "+ description +" "+ image);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //return list;
    }
    
    //methode d'afficher un livre en lisant son titre en parametre
    public String afficherUnLivreParTitre(String titre){
        //List<LivreKids> list = new ArrayList<>();
        try {
            if(rechercheTitre(titre)){
                String sql = "SELECT l.titre,c.nom_categorie,l.description,l.image FROM livrekids FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids WHERE UPPER('?') = UPPER(l.titre) ";
                PreparedStatement st = cnx.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                st.setString(1, titre);

                while(rs.next()){
                    String titreLivre = rs.getString(1);
                    String nom_categorie = rs.getString(2);
                    String description = rs.getString(3);
                    String image = rs.getString(4);
                    System.out.println(titreLivre + " " + nom_categorie + " " + description + " " + image );
                }
            }
            else
                return "Livre introuvable";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //return list;
        return null;
    }
    
    //methode permettant de supprimer un livre de BD
    public void SupprimerUnLivreKids(Livre c){
        try {
            String sql = "DELETE FROM livrekids where id_livre = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,c.getId_livre());
            st.executeUpdate();
            System.out.println("Livre Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
