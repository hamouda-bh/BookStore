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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import bookstore.views.ViewFactory;

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
    private TextField tfIdCategorie;

    @FXML
    private TextField tfLabel;

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
    private Button affCat;


    @FXML
    void ModifierCategorie(ActionEvent event) {

    }

    @FXML
    void SupprimerCategorie(ActionEvent event) {

    }

    @FXML
    void handleClicks(ActionEvent event) {

    }

    @FXML
    void logOutAction(ActionEvent event) {

    }
    
    @FXML
    private void afficherCategorie(ActionEvent event){
        vf.showDetailsCategorie();
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
   
Alert alert=new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private void AjouterUneCategorie(ActionEvent event) {
        int a = 0;
        String str = "N/A";
        try {
          a=Integer.parseInt(tfIdCategorie.getText());
        } catch (NumberFormatException ex){
        }
      if((!"".equals(a))&&(!"".equals(tfLabel.getText()))){
        CategorieService Cs = new CategorieService ();
     Cs.ajouter(new Categorie (a,tfLabel.getText()));
     JOptionPane.showMessageDialog(null,"Categorie ajouté!");
    }
    else if(("".equals(a))||("".equals(tfLabel.getText()))){
        {
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("type valide information !");
            alert.showAndWait();
        }
        }
    
    }
 
    

}