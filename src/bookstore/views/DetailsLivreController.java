/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import bookstore.viewsControllers.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsLivreController extends BaseController implements Initializable {

    public DetailsLivreController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }

    @FXML
    private Label lbId;
    @FXML
    private Label lbLabelCat;
    @FXML
    private Label lbTitre;
    @FXML
    private Label lbAuteur;
    @FXML
    private Label lbGenre;
    @FXML
    private Label lbPrix;
    @FXML
    private Label lbImage;
    
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

    public void setLbId(int n) {
        this.lbId.setText(Integer.toString(n)); 
    }

    public void setLbLabelCat(String str) {
        this.lbLabelCat=lbLabelCat; 
    }

    public void setLbTitre(String str) {
        this.lbTitre = lbTitre;
    }

    public void setLbAuteur(String str) {
        this.lbAuteur = lbAuteur;
    }

    public void setLbGenre(String str) {
        this.lbGenre = lbGenre;
    }

    public void setLbPrix(Float m) {
        this.lbPrix.setText(String.valueOf(m));
        
    }

    public void setLbImage(String str) {
        this.lbImage = lbImage;
    }
    
}
