/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.viewsControllers;

import bookstore.Testing.Cache;
import bookstore.entities.CategorieKids;
import bookstore.services.CategorieKidsService;
import bookstore.views.ViewFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC-Hamouda
 */
public class CategorieKidsController extends BaseController implements Initializable {
    public CategorieKidsController(ViewFactory vf,String fxmlName){
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
    void ShowKidsSpace() {
        vf.ShowKidsSpace(); 
    }

    @FXML
    void goBlog() {
        vf.showBlog();
    }

    @FXML
    void goLivre() {
        vf.showLivre(); 
    }

    @FXML
    void logOutAction() {
        Cache.client = null ;
    	Stage stage = (Stage) logOut.getScene().getWindow();
    	vf.closeStage(stage);
    	vf.showLoginWindow();
    }

    @FXML
    void panier() {
        vf.showPanier();
    }
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
            

    
}
