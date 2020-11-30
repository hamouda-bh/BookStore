/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.CategorieKids;
import bookstore.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PC-Hamouda
 */
public class CategorieKidsService {
    Connection cnx = DBConnection.getInstance().getCnx();
    public void ajouterCategorieKids(CategorieKids cat) {
        try {
            String sql = "INSERT INTO categoriekids values (?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cat.getIdCategorieKids());
            st.setString(2,cat.getDescription());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("Categorie ajoute");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void afficherLesCategorieKids(){
        try {
            String sql = "SELECT * FROM categoriekids";
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
            String sql = "DELETE FROM categoriekids where id_categorie_kids = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,c.getIdLivre());
            st.executeUpdate();
            System.out.println("Categorie Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}