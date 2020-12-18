/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import bookstore.entities.Categorie;
import bookstore.Testing.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class  CategorieService{
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Categorie cat) {
try {
            String sql = "INSERT INTO categorie values (?,?) ";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cat.getId_categorie());
            st.setString(2,cat.getLabel());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            System.out.println("Categorie ajouté");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



/*public void ajouter (Categorie cat) {
	 String req ="INSERT INTO Livre (idCategorie, Label) VALUES ( '"+cat.getIdCategorie()+"', '"+cat.getLabel()+"')"; 
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre ajouté");
} catch (SQLException e) {
}
} */
}
public void supprimerCategorie(int i){
        try {
             //String sql = "DELETE FROM livre WHERE id_livre= "+l.getId_livre();
            String sql = "DELETE FROM categorie where id_categorie = "+i;
            PreparedStatement st = cnx.prepareStatement(sql);
            
            st.executeUpdate();
            System.out.println("Categorie Supprimé");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/*public void supprimer (Categorie cat) {
	 String req ="DELETE From Categorie WHERE id="+cat.getIdCategorie();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Categorie supprimée");
} catch (SQLException e) {
}
}*/
/*public void modifier (Categorie cat) {
	 String req ="UPDATE Categorie SET Label='"+cat.getLabel()+"' WHERE id="+cat.getIdCategorie();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Categorie modifié");
} catch (SQLException e) {
}
}*/
public List<Categorie> afficher () {
	List<Categorie> list= new ArrayList<>();
	 String req = "SELECT * FROM categorie c ";
                 //"SELECT * from Livre";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Categorie(res.getInt("id_categorie"),res.getString("Label")));
}
System.out.println("Categorie recuperé");
} catch (SQLException e) {
}
return list;
}
}
