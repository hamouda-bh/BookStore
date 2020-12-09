/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class ajoutLivreFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      FXMLLoader loader = new FXMLLoader (getClass().getResource("../views/AjoutLivre.fxml"));
      Parent root = loader.load() ;
      Scene scene =new Scene (root) ;
      primaryStage.setTitle("projet BookStore");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
