/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bookstore.entities.Livre;
import bookstore.Testing.DBConnection;

public class  livreService{
Connection cnx = DBConnection.getInstance().getCnx();

    
     
public void ajouter (Livre l)  {
    try {
         String sql =  "INSERT INTO Livre(Id_categorie,Titre,Auteur,Prix,Image) VALUES (?,?,?,?,?)";
        PreparedStatement pst =  cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        pst.setInt(1, l.getId_categorie());
        pst.setString(2,l.getTitre());
        pst.setString(3,l.getAuteur());
        pst.setFloat(4,l.getPrix());
        pst.setString(5,l.getImage());
        System.out.println(l);
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        System.out.println("Livre ajoutée");
         while(rs.next()){
           System.out.println(rs.getInt(1));
         }
        } catch (SQLException e) {
        System.out.println(e.getMessage());       }
          
}
     
/*public void ajouter (Livre l) {
	 String req ="INSERT INTO Livre (label_cat ,titre,auteur,genre,prix,image) VALUES ('"+l.getLabel_cat()+","+l.getTitre()+","+l.getAuteur()+","+l.getGenre()+","+l.getPrix()+","+l.getImage()+")";
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre ajouté");
} catch (SQLException e) {
}
}
public void supprimer (Livre l) {
	 String req ="DELETE From Livre WHERE id="+l.getId_livre();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre supprimé");
} catch (SQLException e) {
}
}
public void modifier (Livre l) {
	 String req ="UPDATE Livre SET Prix='"+l.getPrix()+"' WHERE id="+l.getId_livre();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("Livre modifié");
} catch (SQLException e) {
}
}

public List<Livre> afficher ( ) {
	List<Livre> list= new ArrayList<>();
	 String req = "SELECT c.Label,l.titre,l.auteur,l.genre,l.prix,l.image FROM livre l INNER join categorie c on l.idCategorie = c.idCategorie";
                 //"SELECT * from Livre";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Livre(res.getString("label_cat"),res.getString("titre"),res.getString("auteur"),res.getString("genre"),res.getFloat("prix"),res.getString("image")));
}
System.out.println("Livre recupere");
} catch (SQLException e) {
}
return list;
}
/*
public List<Livre> afficherL() {
        List<Livre> list = new ArrayList<>();
        String req = "SELECT * from livre ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Livre(res.getInt("id_livre"), res.getInt("id_categorie"),res.getString("titre"), res.getString("auteur"), res.getString("genre"), res.getFloat("prix"), res.getString("image")));
            }
            System.out.println("p recupere");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/

}

    

