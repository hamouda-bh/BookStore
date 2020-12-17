/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import bookstore.views.*;
import bookstore.services.*;
import bookstore.viewsControllers.BaseController;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class ConsulterCategoriesKidsController extends BaseController implements Initializable {
    public ConsulterCategoriesKidsController (ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
    
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button myAccountButton;
    @FXML
    private Button tflivre;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btn_panier;
    @FXML
    private Button goToEspaceKids;
    @FXML
    private Button logOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }
    /*
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
    */
    @FXML
    void ShowKidsSpace() {
        vf.ShowKidsSpace();
    }
     @FXML
    private void goLivre() {
    
     vf.showLivre() ;
    
           }
    @FXML
    private void goBlog() {
        vf.showBlog();
    }
    /*
    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }*/
    
     @FXML
    void panier() {
        vf.showPanier();
    }
    
    @FXML
    void AfficherPageLivreKids(ActionEvent event) {
        vf.ShowLivreKids();
    }

    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
	

}
