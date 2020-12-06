package bookstore.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.entities.Panier_livre;

public class PanierService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Panier_livre p) {
	 String req ="INSERT INTO panier_livre (id_panier, id_client, id_livre, somme_ajouter,quantite_ajouter) VALUES ('"
                 +p.getId_panier()+"', '"+p.getId_user()+"',  '"+p.getId_comm()+"',  '"+p.getSomme_ajoute()+"',  '"+p.getQuantite_ajouter()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("p ajoutée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void supprimer (Panier_livre p) {
	 String req ="DELETE From panier_livre WHERE id_panier="+p.getId_comm();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("p supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
public void modifier (Panier_livre p) {
	 String req ="UPDATE panier_livre SET Quantite_ajouter='"+p.getQuantite_ajouter()+"' WHERE id_panier="+p.getId_comm();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("p modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}

public List<Panier_livre> afficher ( ) {
	List<Panier_livre> list= new ArrayList<>();
	 String req = "SELECT * from panier_livre";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Panier_livre(res.getInt("id_panier"),res.getInt("id_user"),res.getInt("id_comm"),res.getInt("somme_ajoute"),res.getInt("quantite_ajouter")));
}
System.out.println("p recupere");
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}
}
