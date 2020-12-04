/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Annonce;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mehdi
 */
public class ServiceAnnonce {
    
    Connection cnx = DBConnection.getInstance().getCnx();
    
    public void ajouterAnnonce(Annonce a) {
        try {
            String req = "INSERT INTO annonce () values (?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,a.getId_annonce());
            st.setDate(2,a.getDate_publication());
            st.setInt(3,a.getId_client());
            st.setInt(4,a.getId_livre());
            st.setFloat(5,a.getPrix());
            st.setString(6,a.getEtat_de_livre());
            st.setDate(7,a.getDate_achat());
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
    
    public List<Integer> afficherIdAnnonce() {
        List<Integer> id = new ArrayList<>();
        try {
            String req = "SELECT id_Annonce FROM annonce";
            PreparedStatement ps = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
               id.add(new Integer(rs.getInt(1)));
           }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }    
    
    public List<Date> afficherDateAnnonce() {
        List<Date> date = new ArrayList<>();
        try {
            String req = "SELECT date_publication FROM annonce";
            PreparedStatement ps = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
               date.add(new Date(rs.getLong(1)));
           }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return date;
    } 
    
    public List<Float> afficherPrixAnnonce() {
        List<Float> prix = new ArrayList<>();
        try {
            String req = "SELECT prix FROM annonce";
            PreparedStatement ps = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
               prix.add(new Float(rs.getFloat(1)));
           }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prix;
    } 
        
    public List<String> afficherEtatAnnonce() {
        List<String> id = new ArrayList<>();
        try {
            String req = "SELECT etat_de_livre FROM annonce";
            PreparedStatement ps = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
               id.add(new String(rs.getString(1)));
           }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }       
        
        
    public List<Annonce> afficherAnnonces() {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM annonce";
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while(res.next()) {
                list.add(new Annonce(res.getInt(1),res.getDate(2),res.getInt(3),res.getInt(4),res.getFloat(5),res.getString(6),res.getDate(7)));
            }
            System.out.println("Annonces récupérées !");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }    
}
