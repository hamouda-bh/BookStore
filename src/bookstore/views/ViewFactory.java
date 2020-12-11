/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.views;

import bookstore.viewsControllers.CommandeFaiteController;
import bookstore.viewsControllers.KidsSpaceController;
import bookstore.viewsControllers.BaseController;
import bookstore.viewsControllers.GererPanierController;
import bookstore.viewsControllers.*;
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
        BaseController cat = new KidsSpaceController(this, "CategorieKidsView.fxml");
        initializeStage(cat);
    }
    public void displayCategories(){
        
    }
    
            public void showLoginWindow() {
	        System.out.println("show login window called");
			BaseController loginController = new LoginWindowController(this, "LoginWindow.fxml");
			initializeStage(loginController);
	    }
	    public void showRegisterWindow() {
	        System.out.println("show register window called");
			BaseController registerController = new RegisterWindowController(this, "RegisterWindowController.fxml");
			initializeStage(registerController);
	    }
	    public void showMainWindow() {
	        System.out.println("show main window called");
			BaseController mainController = new MainCtrl(this, "main.fxml");
			initializeStage(mainController);
	    }
	    public void closeStage(Stage stageToClose) {
	    	stageToClose.close();
	    	st.remove(stageToClose);
	    }
             public void showCommandeFaite(){
			BaseController cmdfaite = new CommandeFaiteController(this, "commandeFaite.fxml");
			initializeStage(cmdfaite);
	    }
	    public void showAccountWindow(){
	    	System.out.println("show account window called");
			BaseController accountController = new AccountWindowController(this, "AccountWindow.fxml");
			initializeStage(accountController);
	    }
	    public void showAccountEditWindow(){
	    	System.out.println("show account edit window called");
			BaseController editAccountController = new EditAccountController(this, "EditAccountWindow.fxml");
			initializeStage(editAccountController);
		}
		
		public void showCommandeForm(  )
		{
                        System.out.println("Formulaire commande appelé");
			BaseController b= new PasserCommandeController(this, "PasserCommande.fxml");
			 initializeStage(b);
		}
		 public void showPanier(  )
		{
                        System.out.println("Panier appelé");
			BaseController b2= new GererPanierController(this, "GererPanier.fxml");
			 initializeStage(b2);
		}
                 public void showPaiement(){
                     System.out.println("Paiment appelé");
                     BaseController paiement = new PaiementController(this, "Paiement.fxml");
                     initializeStage(paiement);
                 } 
                 /*
                public void showCommandeFaite(){
                    BaseController b3= new CommandeFaiteController(this, "commandeFaite.fxml");
                    initializeStage(b3);
                }
                */

                public void ShowKidsSpace() {
                    BaseController enterKidsSpace = new KidsSpaceController(this, "KidsSpaceView.fxml");
                    initializeStage(enterKidsSpace);
                }

                public void ShowLivreKids() {
                    BaseController enterLivreKids = new LivreKidsViewController(this, "LivreKidsViewController.fxml");
                    initializeStage(enterLivreKids);
                }
                public void ShowAjouterLivreKids(){
                    BaseController ajouterLivre = new AjouterLivreKidsController(this, "AjouterLivreKids.fxml");
                    initializeStage(ajouterLivre);
                }
                  public void showAjoutLivre(){
                     BaseController ajoutlivre = new AjoutLivreController(this, "AjoutLivre.fxml");
                     initializeStage(ajoutlivre);
                 
		
                  }
                  public void showLivre(){
                     BaseController livre = new LivreController(this, "Livre.fxml");
                     initializeStage(livre);
					}
}