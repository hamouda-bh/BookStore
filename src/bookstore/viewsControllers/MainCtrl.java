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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class MainCtrl extends BaseController implements Initializable {
    public MainCtrl(ViewFactory vf, String fxmlName){
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
    private Button btn_panier;
    @FXML
    private Button logOut;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private Button myAccountButton;
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
    private void goBlog(ActionEvent event) {
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
    void panier(ActionEvent event) {
        vf.showPanier();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks() {
    }
    public void goAnnonce(){
        vf.showAnnonces();
    }
    
    
    
}
