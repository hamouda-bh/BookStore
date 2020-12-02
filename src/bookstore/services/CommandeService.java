package bookstore.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Commande;

public class CommandeService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Commande p) {
	 String req ="INSERT INTO commande (id_commande, date_commande, id_client, prix_Totale) VALUES ('"
                 +p.getId_commande()+"', '"+p.getDate_commande()+"',  '"+p.getId_client()+"',  '"+p.getPrixTotale()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("c ajoutée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void supprimer (Commande p) {
	 String req ="DELETE From commande WHERE id_commande="+p.getId_commande();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("c supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
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

public List<Commande> afficher ( ) {
	List<Commande> list= new ArrayList<>();
	 String req = "SELECT * from commande";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Commande(res.getInt("id_commande"),res.getDate("date_commande"),res.getInt("id_client"),res.getInt("prixTotale")));
}
System.out.println("c recupere");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}
