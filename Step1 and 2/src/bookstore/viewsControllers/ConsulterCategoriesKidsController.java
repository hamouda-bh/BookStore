/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.CategorieKids;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import bookstore.views.*;
import bookstore.services.*;
import bookstore.views.ViewFactory;
import bookstore.viewsControllers.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    @FXML
    private TableColumn<CategorieKids, String> nom_categorie;

    @FXML
    private TableColumn<CategorieKids, String> description;
    
    @FXML
    private TableView<CategorieKids> Table_categorie;
    
    
    @FXML
    private Button AjouterNouvelleCategorieKids;

    @FXML
    private Button ConsulterLesCategoriesKids;
    
    
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<CategorieKids> categorie_list = FXCollections.observableArrayList();
        System.out.println(categorie_list);
        CategorieKidsService bs = new CategorieKidsService();
        bs.afficherLesCategorieKids(categorie_list);
        System.out.println(categorie_list);
        nom_categorie.setCellValueFactory(new PropertyValueFactory<>("NomCategorie"));
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        Table_categorie.setItems(categorie_list);
        //Table_categorie.getItems().addAll(categorie_list);
    }    


    @FXML
    void logOutAction() {
    	Cache.client = null ;
    	vf.showLoginWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	
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
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }
     @FXML
    private void goLivre() {
        vf.showLivre() ;
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }
    @FXML
    private void goBlog() {
        vf.showBlog();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
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
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }
    
    @FXML
    void AfficherPageLivreKids(ActionEvent event) {
        vf.ShowLivreKids();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
    }

    @FXML
    void myAccountAction() {
        vf.showAccountEditWindow();
        Stage stage = (Stage) logOut.getScene().getWindow();
  	vf.closeStage(stage);
    }    
    @FXML
    void returnToCategoriKids(ActionEvent event) {
        vf.showCategoriesKids();
        Stage stage = (Stage) logOut.getScene().getWindow();
	vf.closeStage(stage);
        
        
    }
}
