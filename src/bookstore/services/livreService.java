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
import java.sql.PreparedStatement;

public class  livreService{
    
Connection cnx = DBConnection.getInstance().getCnx();

    
     
public void ajouter (Livre l)  {
    try {
         String sql = "INSERT INTO Livre(Id_categorie,Titre,Auteur,Prix,Image) VALUES (?,?,?,?,?)";
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
} */
public void Supprimer (Livre l){
        try {
            String sql = "DELETE FROM livre WHERE id_livre= "+l.getId_livre();
            PreparedStatement st = cnx.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Livre Supprimé");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

public void modifier (Livre l) {
   try{
    String req ="UPDATE Livre SET Prix=?, Auteur=? ,Titre=? , Image=? WHERE id_livre=?";
    PreparedStatement st = cnx.prepareStatement(req);
    
        st.setString(2,l.getTitre());
        st.setString(3,l.getAuteur());
        st.setFloat(4,l.getPrix());
        st.setString(5,l.getImage());
st.executeUpdate(req);
System.out.println("Livre modifié");
} catch (SQLException e) {
}
}

public boolean rechercheTitre(String titre){
        try {
            String sql = "SELECT titre from Livre where UPPER(?)=UPPER(titre)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1, titre);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                    if((rs.getString(1)).equals(titre)){
                    System.out.println("Livre Trouvé");
                    return true;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
public List<Livre> afficher () {
	List<Livre> list= new ArrayList<>();
	 String req = "SELECT l.titre,l.auteur,c.Label,l.prix,l.image,l.Id_livre FROM livre l INNER join categorie c on l.id_Categorie = c.id_Categorie";
                 //"SELECT * from Livre";
try {
	
	Statement st = cnx.createStatement();
ResultSet res =st.executeQuery(req);
while (res.next()) {
	list.add(new Livre(res.getString("titre"),res.getString("auteur"),res.getFloat("prix"),res.getString("image"),res.getInt("Id_livre")));
}
System.out.println("Livre recupere");
} catch (SQLException e) {
}
return list;
}
}

    

