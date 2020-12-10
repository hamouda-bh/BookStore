package bookstore.services;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactureService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Facture p , Commande c) throws IOException {
	 String req ="INSERT INTO facture (id_facture, id_commande, id_client, date_facturaction, prix_totale) "
                 + "VALUES ('"+p.getIdFacture()+"', '"+c.getId_commande()+"',  '"+c.getId_client()+"',  '"+c.getDate_commande()+"',  '"+c.getPrixTotale()+"')"; 
try {
    
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F ajoutée");



System.out.println("F ajoutée");
    


} catch (SQLException e) {
	e.printStackTrace();
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
public List<Facture> afficher ( ) {
	List<Facture> list= new ArrayList<>();
	 String req = "SELECT date_facturation from facture";
try {
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Facture(res.getDate("date_fact")));
}
System.out.println("f recupere");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}

