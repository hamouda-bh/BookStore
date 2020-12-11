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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class LivreKidsViewController extends BaseController implements Initializable {
    public LivreKidsViewController(ViewFactory vf, String fxmlName){
        super(vf, fxmlName);
    }
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button goToEspaceKids;

    @FXML
    private Button logOut;

    @FXML
    private Button AjouterNouveauLivreKids;

    @FXML
    private Button ShowLivreKids1;

    @FXML
    void AjouterNouveauLivreKids( ) {
        vf.ShowAjouterLivreKids();
    }

    @FXML
    void ShowKidsSpace( ) {
        vf.ShowKidsSpace();
    }

    @FXML
    void handleClicks( ) {

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
    @FXML
    void ConsulterLesLivres( ) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
