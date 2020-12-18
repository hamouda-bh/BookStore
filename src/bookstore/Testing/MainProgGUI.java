
package bookstore.Testing;

import bookstore.entities.Panier_livre;
import bookstore.services.PanierService;
import bookstore.views.ViewFactory;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class MainProgGUI extends Application {
    
    

	public static void main(String[] args) {
		launch(args);  
	}

	@Override
	public void start(Stage stage)   {
		try {   
			ViewFactory vf = new ViewFactory();
			//vf.ShowKidsSpace();
                        //vf.ShowKidsSpace();
                        //vf.showConsulterLesLivresKids();
                        //vf.showCategoriesKids();
                        //vf.showUI();
                        vf.showMainWindow();
                        //vf.showPanier();
                        //vf.ShowAjouterLivreKids();
                        //vf.showUI();                        
                        //vf.showColorationKids();
                        //vf.showUI();
			            //vf.showUI();
                        //vf.showMainWindow();
                        
                        
                        /* 
                            nour.benhadjyahia@esprit.tn
                            Nour123nour@
                        */
                        
		}catch(Exception e) {			
			e.printStackTrace();
        }	
    }
}




    

