package bookstore.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Panier_livre;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanierService {

    Connection cnx = DBConnection.getInstance().getCnx();

    public void ajouter(Panier_livre p) throws SQLException {

        String requete1 = "INSERT INTO panier_livre (id_client, id_livre, somme_ajouter,quantite_ajouter) VALUES (?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete1);

        pst.setInt(1, p.getId_user());
        pst.setInt(2, p.getId_comm());
        pst.setFloat(3, p.getSomme_ajoute());
        pst.setInt(4, p.getQuantite_ajouter());
        pst.executeUpdate();
        System.out.println("p ajoutée");
        try {
            pst = cnx.prepareStatement(requete1);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimer(int i) {
        String req = "DELETE From panier_livre WHERE panier_livre.id_livre=?";
        try {
 PreparedStatement pst2 = cnx.prepareStatement(req);
            pst2.setInt(1, i);
            pst2.executeUpdate();
          
            System.out.println("p supprimée");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifier(int qte, int id_livre) throws SQLException {
        
        
        String requete5 = "UPDATE panier_livre SET quantite_ajouter = ?  WHERE id_livre = ?";

        try {

            PreparedStatement pst2 = cnx.prepareStatement(requete5);
            pst2.setInt(1, qte);
            pst2.setInt(2, id_livre); 
            pst2.executeUpdate();
            System.out.println("panier updated");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /*  public List<Panier_livre> afficher() {
        List<Panier_livre> list = new ArrayList<>();
        String req = "SELECT * from panier_livre ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Panier_livre(res.getInt("id_panier"), res.getInt("id_client"),res.getInt("id_livre"), res.getFloat("quantite_ajouter"), res.getInt("somme_ajouter")));
            }
            System.out.println("p recupere");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/
    
   /*  public List<Panier_livre> afficherActivite1() {
        ArrayList<Panier_livre> panierList = new ArrayList<>();
        String requete4 = "SELECT * FROM panier_livre";
        try {

            
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(requete4);

            while (rs.next()) {

                Panier_livre a = new Panier_livre();
                a.setId_comm(rs.getInt(1));
                a.setQuantite_ajouter(rs.getInt(2));
                panierList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return panierList;
    }*/
    
    public void affichage() {

            List<Panier_livre> panier = this.afficherL();
            for (Panier_livre a : panier) {
                
                System.out.println(a.toString());
            
            }}

    public int afficherQ() {
        List<Panier_livre> list = new ArrayList<>();
        String req = "SELECT quantite_ajouter from panier_livre p join livre l on p.id_livre=l.id_livre";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                int i = res.getInt("quantite_ajouter");
                return i;
            }
            System.out.println("p recupere");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    public List<Panier_livre> afficherL() {
        List<Panier_livre> list = new ArrayList<>();
        String req = "SELECT p.* from panier_livre p ";
        try {
           
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
                       
            while (res.next()) {
                            
                list.add(new Panier_livre(res.getInt("id_panier"), res.getInt("id_client"),res.getInt("id_livre"), res.getFloat("quantite_ajouter"), res.getInt("somme_ajouter"),  res.getString("titre"), res.getFloat("prix")));
                       
            }
            System.out.println("p recupere");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
}
