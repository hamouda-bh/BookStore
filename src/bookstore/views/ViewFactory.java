/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.views;

import bookstore.viewsControllers.LivreKidsController;
import bookstore.viewsControllers.BaseController;
import bookstore.viewsControllers.CommandeFaiteController;
import bookstore.viewsControllers.GererPanierController;
import bookstore.viewsControllers.PasserCommandeController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PC-Hamouda
 */
public class ViewFactory {
    private List<Stage> st ;

    public ViewFactory() {
        st = new ArrayList<Stage>();
    }
    
    public void initializeStage(BaseController baseController) {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
	        fxmlLoader.setController(baseController);
	        Parent parent;
	        try {
	            parent = fxmlLoader.load();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return;
	        }
	        Scene scene = new Scene(parent);
	        Stage stage = new Stage();
	        
	        stage.setScene(scene);
	        stage.show();
	        st.add(stage);
	    }
    public void showCategoriesWindowFromLivre(){
        BaseController cat = new LivreKidsController(this,"CategorieKidsView.fxml");
        initializeStage(cat);
    }
    public void displayCategories(){
        
    }
    
    public void showCommandeForm(  )
    {
        BaseController b= new GererPanierController(this, "PasserCommande.fxml");
         initializeStage(b);
    }
     public void showPanier(  )
    {
        BaseController b2= new PasserCommandeController(this, "GererPanier.fxml");
         initializeStage(b2);
    }
     public void showCommandeFaite()
    {
        BaseController b3= new CommandeFaiteController(this, "commandeFaite.fxml");
         initializeStage(b3);
    }
}