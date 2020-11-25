/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.utils;

import java.sql.*;


/**
 *
 * @author PC-Hamouda
 */
public class DataSource {
    private Connection cnx;
    private static DataSource Instance; 
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3308/book_store_db";
    
    public DataSource (){
        try {
        cnx = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        System.out.println("Connected to Bookstore");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    } 
    
    public static DataSource getInstance(){
        if (Instance == null)
            Instance = new DataSource();
        return Instance;
    }
}
