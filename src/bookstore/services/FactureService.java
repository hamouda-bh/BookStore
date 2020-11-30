package bookstore.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Facture;

public class FactureService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Facture p) {
	 String req ="INSERT INTO facture (id_facture, id_commande, id_client, id_livre, date_facturaction) "
                 + "VALUES ('"+p.getIdFacture()+"', '"+p.getIdCommande()+"',  '"+p.getId_client()+"',  '"+p.getId_livre()+"',  '"+p.getDate_fact()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F ajoutée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
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

public List<Facture> afficher ( ) {
	List<Facture> list= new ArrayList<>();
	 String req = "SELECT * from facture";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Facture(res.getInt("idFacture"),res.getInt("idCommande"),res.getInt("id_client"),res.getInt("id_livre"),res.getDate("date_fact")));
}
System.out.println("f recupere");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}

