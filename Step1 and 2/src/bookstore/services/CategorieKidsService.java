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
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author PC-Hamouda
 */
public class CategorieKidsService {
    Connection cnx = DBConnection.getInstance().getCnx();
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
    public void ajouterCategorieKids(CategorieKids cat) {
        try {
            String sql = "INSERT INTO categoriekids (nom_categorie,description) values (?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, cat.getNomCategorie());
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
    public void afficherLesCategorieKids(ObservableList<CategorieKids> categories){
        try {
            String sql = "SELECT nom_categorie,description FROM categoriekids";
            PreparedStatement st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                CategorieKids cat1 = new CategorieKids();
                cat1.setNomCategorie(rs.getString(1));
                cat1.setDescription(rs.getString(2));
                categories.add(cat1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void SupprimerLivreKids(CategorieKids cat){
        try {
            String sql = "DELETE FROM categoriekids where id_categorie_kids = ?";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1,cat.getIdCategorieKids());
            st.executeUpdate();
            System.out.println("Categorie Supprimer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}