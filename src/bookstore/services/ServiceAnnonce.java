/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import bookstore.Testing.Cache;
import bookstore.Testing.DBConnection;
import bookstore.entities.Annonce;
import bookstore.entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Mehdi
 */
public class ServiceAnnonce {
    
    Connection cnx = DBConnection.getInstance().getCnx();
    
    public void ajouterAnnonce(Annonce a) {
        try {
            String req = "INSERT INTO annonce(date_publication,prix,etat_de_livre,date_achat) values (?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,a.getDate_publication());
            st.setString(2,a.getPrix());
            st.setString(3,a.getEtat_de_livre());
            st.setString(4,a.getDate_achat());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("Annonce ajoutée !");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierAnnonce(Annonce e) {
        try {
        String req = "UPDATE ON annonce WHERE id="+e.getId_annonce();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Annonce modifiée !"); 
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerAnnonce(Annonce e) {
        try {
            String req = "DELETE FROM annonce WHERE id="+e.getId_annonce();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Annonce supprimée !");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  
    public ObservableList<Annonce> afficherAnnonces() {
        ObservableList<Annonce> list = FXCollections.observableArrayList();
        //List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT date_publication,prix,etat_de_livre,date_achat FROM annonce";
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while(res.next()) {
                list.add(new Annonce(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            }
            System.out.println("Annonces récupérées !");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }    
    
    public ObservableList<Annonce> afficherMesAnnonces(int id){
        ObservableList<Annonce> list = FXCollections.observableArrayList();
        try {
            String req = "SELECT date_publication,prix,etat_de_livre,date_achat FROM annonce WHERE id_client="+id;
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while(res.next()) {
                list.add(new Annonce(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            }
            System.out.println("Annonces récupérées !");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return list;
    }
}
