package bookstore.services;
import bookstore.Testing.Cache;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Commande;
import bookstore.entities.Facture;
import bookstore.utils.PDFutil;
import bookstore.viewsControllers.CommandeFaiteController;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BidiOrder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactureService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Facture p) throws IOException, SQLException {

  String requete1 = "INSERT INTO facture (id_facture, id_commande, id_client,date_facturation,prix_totale) VALUES (?,?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete1);

        pst.setInt(1, p.getIdFacture());
        pst.setInt(2, p.getIdCommande());
        pst.setInt(3, Cache.client.getId_user());
        pst.setString(4, p.getDate_fact());
        pst.setFloat(5, p.getPrix_totale() );
        pst.executeUpdate();
        System.out.println(" facture ajoutée");
        try {
            pst = cnx.prepareStatement(requete1);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

 
/*
public void supprimer (Facture p) {
	 String req ="DELETE From facture WHERE id_facture="+p.getIdFacture();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}


public void modifier (Facture p) {
	 String req ="UPDATE facture SET date_facturation='"+p.getDate_fact();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
*/
public List<Facture> afficher() {
        List<Facture> list = new ArrayList<>();
        String req = "SELECT * from facture ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Facture(res.getInt("id_facture"), res.getInt("id_commande"),res.getInt("id_client"), res.getString("date_facturation"), res.getFloat("prix_totale")));
            }
            System.out.println("p recupere");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public void affichage() {

            List<Facture> fact = this.afficher();
            for (Facture a : fact) {
                
                System.out.println(a.toString());
                
                
            }}

}

