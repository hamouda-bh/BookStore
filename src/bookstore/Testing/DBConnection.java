
package bookstore.Testing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String login = "root";
    private String password = "root";

    private Connection cnx;
<<<<<<< HEAD
    private static DBConnection Instance; 
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:mysql://localhost:3306/books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
=======
  //  private static DBConnection Instance; 
  //  private final String USERNAME = "root";
  //  private final String PASSWORD = "root";
  //  private final String URL = "jdbc:mysql://localhost:3306/books?serverTimezone=UTC";
>>>>>>> b39cf7cb77404b728d1fccf391c60ea06a7a6093
    //?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

    static DBConnection instance;

    private DBConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion établie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

}