/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.views;

import bookstore.Testing.Cache;
import bookstore.entities.Categorie;
import bookstore.services.CategorieService;
import bookstore.viewsControllers.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutCategorieController extends BaseController implements Initializable {

    public AjoutCategorieController(ViewFactory vf, String fxmlName) {
        super(vf, fxmlName);
    }

    
    
    @FXML
    private AnchorPane tfAjouCat;
    @FXML
    private Label tfIdCategorie;
    @FXML
    private Label tfLabel;
    @FXML
    private Button tfAjout;
    @FXML
    private Button tfmodcat;
    @FXML
    private Button tfSuppCat;
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
    private Button btnSettings;
    @FXML
    private Button logOut;
  
      @FXML
    private Button btn_panier;
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
    private void AjouterUneCategorie(ActionEvent event) {
        CategorieService Cs = new CategorieService ();
        int a=Integer.parseInt(tfIdCategorie.getText());
     Cs.ajouter(new Categorie (a,tfLabel.getText()));
     JOptionPane.showMessageDialog(null,"Categorie ajouté!");
     
    }

    @FXML
    private void ModifierCategorie(ActionEvent event) {
    }

    @FXML
    private void SupprimerCategorie(ActionEvent event) {
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void logOutAction(ActionEvent event) {
    }

    @FXML
    private void AjouterUneCategorie(MouseEvent event) {
    }
    
}
