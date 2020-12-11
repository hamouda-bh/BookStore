/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class AjouterLivreKidsController extends BaseController implements Initializable {
    public AjouterLivreKidsController (ViewFactory vf,String fxmlName){
        super(vf, fxmlName);
    }
        @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button AccountBtn;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button goToEspaceKids;

    @FXML
    private Button logOut;

    @FXML
    private Button AnnulerAjouterLivreKids;

    @FXML
    private Button AjouterLivreKids;
    /**
     * Initializes the controller class.
     */  
    
    @FXML
    void AfficherPageLivreKids(ActionEvent event) {
        vf.ShowLivreKids();
    }
    @FXML
    private void ShowKidsSpace() {
        vf.ShowKidsSpace();
    }

    @FXML
    void myAccountAction() {
        vf.showAccountWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	    vf.closeStage(stage);
    }
	

    @FXML
    void logOutAction() {
    	Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    public void ajouterLivreAuBD(){
        
    }
}   
