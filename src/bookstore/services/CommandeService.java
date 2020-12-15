package bookstore.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Commande;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class CommandeService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Commande p) throws SQLException {
         String requete1 = "INSERT INTO commande (id_commande,  date_commande, id_client, prix_Totale) VALUES (?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete1);

        pst.setInt(1, p.getId_commande());
        pst.setDate(2, (Date) p.getDate_commande());
        pst.setInt(3, p.getId_client());
        pst.setFloat(4, p.getPrixTotale());
        pst.executeUpdate();
        System.out.println("p ajoutée");
        try {
            pst = cnx.prepareStatement(requete1);
        } catch (SQLException e) {
        e.printStackTrace();        }
          
}


public void supprimer (int i) {
	 String req = "DELETE From commande WHERE commande.id_commande=?";
        try {
 PreparedStatement pst2 = cnx.prepareStatement(req);
            pst2.setInt(1, i);
            pst2.executeUpdate();
          
            System.out.println("cmd supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
/*
public void modifier (Commande p) {
	 String req ="UPDATE commande SET date_commande='"+p.getDate_commande()+"' WHERE id="+p.getId_commande();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("c modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
*/










public List<Commande> afficher ( ) {
	 List<Commande> list = new ArrayList<>();
        String req = "SELECT * from commande ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Commande(res.getInt("id_commande"), res.getDate("date_commande"),res.getInt("id_client"), res.getFloat("prix_Totale")));
            }
            System.out.println("p recupere");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public void affichage() {

            List<Commande> cmd = this.afficher();
            for (Commande a : cmd) {
                
                System.out.println(a.toString());
                
            }}
}
