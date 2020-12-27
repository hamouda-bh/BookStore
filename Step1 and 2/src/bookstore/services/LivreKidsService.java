package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.CategorieKids;
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
            String sql = "INSERT INTO livrekids (id_categorie_kids,titre,description,image) values (2,?,?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, c.getTitre());
            st.setString(2,c.getDescription());
            st.setString(3,c.getImage());
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
    public ArrayList<LivreKids> afficherLesLivresKids(){
        //List<LivreKids> list = new ArrayList<>();
        ArrayList<LivreKids> listlivre = new ArrayList<>();
        try {
            String sql = "SELECT l.titre,c.nom_categorie,l.description,l.image FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                LivreKids livre1 = new LivreKids();
                livre1.setTitre(rs.getString(1));
                CategorieKids cat1 = new CategorieKids();
                cat1.setNomCategorie(rs.getString(2));
                livre1.setCat(cat1);
                livre1.setDescription(rs.getString(3));
                livre1.setImage(rs.getString(4));
                listlivre.add(livre1);
            }
                //String titreLivre = rs.getString(1);
                //String nom_categorie = rs.getString(2);
                //String description = rs.getString(3);
              
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listlivre;
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
    public String afficherLesLivreParCategorie(String Categorie){
        //List<LivreKids> list = new ArrayList<>();
        try {
            if(rechercheTitre(Categorie)){
                String sql = "SELECT l.titre,c.nom_categorie,l.description,l.image FROM livrekids FROM livrekids l INNER join categoriekids c on l.id_categorie_kids = c.id_categorie_kids GROUP BY c.nom_categorie ";
                PreparedStatement st = cnx.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                st.setString(1, Categorie);

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
