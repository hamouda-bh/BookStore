/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services;

import bookstore.Testing.DBConnection;
import bookstore.entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC-Hamouda
 */
public class ClientService {
    Connection cnx= DBConnection.getInstance().getCnx();
    public void ajouterClientDB(Client c){
        try {
            String sql = "INSERT INTO Client Values (?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1,c.getId());
            st.setString(2,c.getUsername());
            st.setString(3,c.getNom());
            st.setString(4,c.getPrenom());
            st.setString(5,c.getEmail());
            st.setString(6,c.getPwd());
            st.setString(7,c.getPhoto());
            //System.out.println("Insert Status" + (st.executeUpdate()>0));
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next())
                System.out.println(rs.getInt(1));
        } catch (SQLException e) {
            System.out.println("Client non ajouté");
        }
        
    }
}
