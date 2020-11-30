/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.services;

import bookstore.Testing.DBConnection;
import java.sql.Connection;

/**
 *
 * @author PC-Hamouda
 */
public class CategorieKidsService {
    Connection cnx = DBConnection.getInstance().getCnx();
    public void ajouterCategorieKids(){
        String sql = "INSERT INTO categorie_kids VALUES(?,?,?,?)";
        
    }
}