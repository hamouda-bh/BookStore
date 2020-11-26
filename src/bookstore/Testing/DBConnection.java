/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import java.sql.*;


/**
 *
 * @author PC-Hamouda
 */
public class DBConnection {
    private Connection cnx;
    private static DBConnection Instance; 
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/book_store_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private DBConnection (){
        try {
        cnx = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        System.out.println("Connected to Bookstore");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    } 
    
    public static DBConnection getInstance(){
        if (Instance == null)
            Instance = new DBConnection();
        return Instance;
    }

    public Connection getCnx() {
        return cnx;
    }    
}
